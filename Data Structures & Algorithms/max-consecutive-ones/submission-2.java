class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currMax = 0;
        int max = 0;
        
        for (int n : nums) {
            currMax = (n == 1) ? currMax + 1 : 0;
            max = Math.max(max, currMax);
        }

        return max;
    }
}