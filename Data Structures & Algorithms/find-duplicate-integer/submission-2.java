class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1; int right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            int counter = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= middle) {
                    counter++;
                }
            }

            if (counter <= middle) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }
}
