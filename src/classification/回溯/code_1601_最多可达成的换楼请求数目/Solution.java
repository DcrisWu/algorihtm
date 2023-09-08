package classification.回溯.code_1601_最多可达成的换楼请求数目;

/**
 * completion time = 2023.9.8
 */
class Solution {

    private int[][] requests;
    private int ans = 0;
    private int[] delta;


    public int maximumRequests(int n, int[][] requests) {
        this.requests = requests;
        this.delta = new int[n];
        recursive(0, 0);
        return ans;
    }

    public void recursive(int idx, int count) {
        if (idx == requests.length) {
            if (check()){
                ans = Math.max(ans,count);
            }
            return;
        }
        // 接受请求idx
        int[] request = requests[idx];
        int from = request[0];
        int to = request[1];
        delta[from]--;
        delta[to]++;
        recursive(idx + 1, count + 1);
        delta[from]++;
        delta[to]--;
        // 跳过当前请求
        recursive(idx + 1, count);
    }

    public boolean check() {
        for (int i : delta) {
            if (i != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumRequests(5, new int[][]{{0, 0},{1, 2}, {2, 1}}));
    }
}
