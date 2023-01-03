package TowardsOffers2.code_面试题13_机器人的运动范围;

class Solution {
    private boolean[][] used;
    private int count;
    private int k;

    public int movingCount(int m, int n, int k) {
        used = new boolean[m][n];
        count = 0;
        this.k = k;
        dfs(0, 0);
        return count;
    }

    void dfs(int x, int y) {
        if (!isLegal(x, y)) {
            return;
        }
        count++;
        used[x][y] = true;
        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }

    boolean isLegal(int x, int y) {
        if (x >= 0 && x < used.length && y >= 0 && y < used[0].length && !used[x][y]) {
            int sum = 0;
            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            while (y != 0) {
                sum += y % 10;
                y /= 10;
            }
            return sum <= k;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(3, 1, 0));
    }
}
