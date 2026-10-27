class Solution {
    public int trap(int[] height) {
        int left = 0; 
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int result = 0;

        while (left < right) {
            if (leftMax >= rightMax) {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
            } else {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
            }
        }

        return result;
    }
}
