import java.io.*;
import java.util.*;

class Solution {
    public static int findPages(int[] a, int n, int m) {
        if (m > n) return -1;   // if students are more than books, allocation is impossible
        int end = 0;    // will hold sum of array elements
        int start = 0;  // will hold max element in array
        for(int x : a) {
            end += x;
            if (x > start) start = x;
        }
        if (m == n) return start;   // if students are equal to the number of books, the book with most pages is the answer
        if (m == 1) return end; // if there is only one student, all the books will be allocated to that student, hence the sum of all pages is the answer
        int ans = -1;   // will hold the required answer
        int totalPages = end;   // stores the sum of all pages, since the variable 'end' will be modified later
        while (start <= end) {  // binary search loop
            int mid = start + ((end - start)/2);
            if (isValid(mid, totalPages, a, m)) {   // if the books can be allocated to students, each having total pages <= mid
                ans = mid;  // store this as a potential answer
                end = mid - 1;  // decrease the range from start to mid -1
            }
            else start = mid + 1; // decrease the range from mid + 1 to end
        }
        return ans;
    }

    static boolean isValid(int maxPages, int totalPages, int[] books, int students) {
        int studentsRequired = 1;   // stores the number of students required to allocate the books with each student having total pages <= maxPages
        int pageSum = 0;    // stores the sum of pages of books with each student
        for(int pages : books) {    // for each book
            if (pageSum + pages <= maxPages &&  // if, on allocating current book to the student (the pages in the current book + pages in books already with the student), this sum is less than or equal to the specified page limit (maxPages)
                pageSum + pages < totalPages)   // and if this sum is less than sum of all the pages of all books (stored in variable 'totalPages') (makes sure that a single student does not get all the books)
                pageSum += pages;   // then allocate the book to student (add the pages of the current book to the sum of pages of books already with the student)
            else {  // if the book cannot be allocated to the student (allocating this book makes, the count of pages of books with the student, more than maxPages)
                studentsRequired++; // increase the studentsRequired count meaning that a new student will be required to allocate books further
                pageSum = pages;    // allocate the current book to new student
            }
            if (studentsRequired > students) return false;  // return false if more students are required to allocate the books within the current page limit (maxPages) than available (stored in variable 'students')
        }
        return studentsRequired <= students;    // will return true if no extra students were required to allocate books within specified page limit (maxPages) else, will return false
    }
}

// Driver Code Starts
class GFG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++) a[i]=sc.nextInt();
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(a,n,m));
        }
    }
}
// Driver Code Ends