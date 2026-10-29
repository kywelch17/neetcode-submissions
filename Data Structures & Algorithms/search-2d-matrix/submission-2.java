class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length; int COLS = matrix[0].length;
        int left = 0; int right = ROWS * COLS - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int row = middle / COLS;
            int col = middle % COLS;
            int curr = matrix[row][col];

            if (curr < target) {
                left = middle + 1;
            } else if (curr > target) {
                right = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
