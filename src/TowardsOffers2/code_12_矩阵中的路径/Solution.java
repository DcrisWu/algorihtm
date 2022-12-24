package TowardsOffers2.code_12_矩阵中的路径;

class Solution {
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(used, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(boolean[][] used, String word, int i, int j, int index) {
        if (index == word.length()-1 && judge(used, word.charAt(index), i, j)){
            return true;
        }
        if (!judge(used, word.charAt(index), i, j)) {
            return false;
        }else {
            used[i][j] = true;
            if (dfs(used,word,i+1,j,index+1)){
                used[i][j] = false;
                return true;
            }
            if (dfs(used,word,i-1,j,index+1)){
                used[i][j] = false;
                return true;
            }
            if (dfs(used,word,i,j+1,index+1)){
                used[i][j] = false;
                return true;
            }
            if (dfs(used,word,i,j-1,index+1)){
                used[i][j] = false;
                return true;
            }
            used[i][j] = false;
            return false;
        }
    }

    boolean judge(boolean[][] used, char c, int i, int j) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length && !used[i][j] && board[i][j] == c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] chars = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        System.out.println(solution.exist(chars, "AAB"));
    }
}