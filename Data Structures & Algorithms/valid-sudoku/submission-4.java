class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == '.') continue;

                char num = (char) board[r][c];

                String row = num + "in row" + r;
                String col = num + "in col" + c;
                String blk = num + "in blk" + (r / 3) + "%" + (c / 3);

                if (!seen.add(row) || !seen.add(col) || !seen.add(blk)) {
                    return false;
                }
            }
        }

        return true;
    }
}
