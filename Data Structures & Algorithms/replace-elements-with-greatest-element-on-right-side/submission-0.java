class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int rightMax = -1;

        for (int i = n - 1; i >= 0; i--) {
            result[i] = rightMax;
            rightMax = Math.max(rightMax, arr[i]);
        }

        return result;
    }
}