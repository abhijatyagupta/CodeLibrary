// solved using four pointers: i, j, left and right

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        Arrays.sort(nums);  // sort the array so that pointers can skip duplicate elements to always create unique quadruplets
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0) if (nums[i] == nums[i-1]) continue;   // skip duplicates
            for(int j = i+1; j < nums.length - 2; j++) {
                if (j != i+1) if (nums[j] == nums[j-1]) continue;   // skip duplicates
                int twoSum = nums[i] + nums[j];
                int left = j+1;
                int right = nums.length - 1;
                while(left < right) {
                    int fourSum = twoSum + nums[left] + nums[right];
                    if (fourSum == target) {
                        List<Integer> quadruplets = new ArrayList<>();
                        quadruplets.add(nums[i]);
                        quadruplets.add(nums[j]);
                        quadruplets.add(nums[left]);
                        quadruplets.add(nums[right]);
                        ans.add(quadruplets);
                        if (left != j+1) while(left < nums.length && nums[left] == nums[left-1]) left++;    // skip duplicates
                        else left++;
                        while(right > j && nums[right] == nums[right-1]) right--;   // skip duplicates
                        right--;
                    }
                    else if (fourSum < target) left++;  // if current sum is falling short of target, increment left pointer
                    else right--;   // else if current sum is greater than the target, decrement right pointer
                }
            }
        }
        return ans;
    }
}