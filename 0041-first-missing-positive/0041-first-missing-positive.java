class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        if (nums.length == 1) {
            return nums[0] == 1 ? 2 : 1;
        }
        int n = nums.length;
        // Move value to correct position with best efforts. O(n)
        int i = 0;
        while (i < n) {
            int val = nums[i];
            if (val != i && val >= 0 && val < n && val != nums[val]) { // val != nums[val], avoid infinitely loop
                int temp = nums[val];
                nums[val] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        // Check, O(n)
        // Skip index 0, only care about positive digits
        for (i = 1; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        
        // max value is n and stored at index 0 
        if (nums[0] == n) {
            return n + 1;
        }

        // max value if (n - 1) and n will be the next positive number (outside of array)
        return n;
    }
}