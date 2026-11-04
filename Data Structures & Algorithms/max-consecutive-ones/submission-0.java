class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currMax = 0;
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, currMax);
                currMax = 0;
            } else {
                currMax++;
            }
        }

        return Math.max(max, currMax);
    }
}