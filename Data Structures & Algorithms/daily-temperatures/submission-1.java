class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];
            while (!stack.empty() && temperatures[stack.peek()] < currTemp) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return results;
    }
}
