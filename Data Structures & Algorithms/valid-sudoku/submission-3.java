class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> block = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == '.') continue;

                String blkKey = (r / 3) + "%" + (c / 3);

                if (cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                    rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    block.computeIfAbsent(blkKey, k -> new HashSet<>()).contains(board[r][c])) {
                        return false;
                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                block.get(blkKey).add(board[r][c]);
            }
        }

        return true;
    }
}
