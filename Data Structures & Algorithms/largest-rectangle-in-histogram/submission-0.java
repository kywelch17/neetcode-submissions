class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            } else {
                leftMost[i] = -1;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            stack.pop();
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            } else {
                rightMost[i] = n;
            }

            stack.push(i);

            // System.out.println(rightMost[i]);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            leftMost[i]++;
            rightMost[i]--;
            maxArea = Math.max(maxArea, heights[i] * (rightMost[i] - leftMost[i] + 1));
        }

        return maxArea;
    }
}
