package Random.code_2642_设计可以求最短路径的图类;

/**
 * completion time = 2023.4.26
 */
public class Graph {
    // Floyd算法
    // 时间复杂度：O(n^3 + qn^2)，其中 q 为 addEdge的调用次数
    // 空间复杂度 O(n^2）
    private int INF = Integer.MAX_VALUE / 3;
    private int[][] graph;

    public Graph(int n, int[][] edges) {
        // 定义f[k][i][j] 表示除了 i 和 j 之外，中间节点编号最多为 k 的时候，i 到 i 的最短距离
        // 分类讨论 ：
        // 1. 从 i 到 j 的最短中间路径中节点最大是 k-1
        // 2. 从 i 到 j 的最短路径中最多为 k ，说明 k 一定是中间节点
        // f[k][i][j] = min(f[k-1][i][j], f[k-1][i][k] + f[k-1][k][j])
        // 因为 f[k-1][i][j] 及之前出现过的中间节点不包含 k, 也就是说 k 是第一次出现的 ，所以不用担心在压缩空间时候，被覆盖的问题
        // f[i][j] = min(f[i][j], f[i][k] + f[k][j])
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }

            }
        }
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
        }
        // floyd 算法
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
//                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }

    // 添加一条边
    public void addEdge(int[] e) {
        int from = e[0], to = e[1], w = e[2];
        // 因为从 from 到 to 的边，只会影响所有需要经过 from 到 to路径的节点
        // 如果 w 更大了，起不到缩减路径的作用，就直接忽略
        if (w >= graph[from][to]) {
            return;
        }
        int n = graph.length;
        // 考虑graph[i][j] 从 i 到 from 再到 to 再到 j 会不会更短
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                graph[i][j] = Math.min(graph[i][j], graph[i][from] + w + graph[to][j]);
                if (graph[i][from] + w + graph[to][j] < graph[i][j]) {
                    graph[i][j] = graph[i][from] + w + graph[to][j];
                }
            }
        }
    }

    // 朴素 Dijkstra 算法
    public int shortestPath(int start, int end) {
        return graph[start][end] == INF ? -1 : graph[start][end];
    }

    /*
    // Dijkstra算法
    // 时间复杂度：O(qn^2),其中 q 为 shortestPath 的调用次数。每次求最短路的时间复杂度为 O(n^2)
    // 空间复杂度 O(n^2）
    // 防止更新最短路径时候，加法溢出
    private int INF = Integer.MAX_VALUE / 2;
    private int[][] graph;

    public Graph(int n, int[][] edges) {
        this.graph = new int[n][n];
        for (int[] ints : graph) {
            Arrays.fill(ints, INF);
        }
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
        }
    }

    public void addEdge(int[] e) {
        graph[e[0]][e[1]] = e[2];
    }

    // 朴素 Dijkstra 算法
    public int shortestPath(int start, int end) {
        int n = graph.length;
        int[] dis = new int[n];
        boolean[] vist = new boolean[n];
        Arrays.fill(dis, INF);
        // dis[i] 表示从 start 到 i 的最短距离
        dis[start] = 0;
        while (true) {
            int x = -1;
            for (int i = 0; i < n; i++) {
                // 寻找没有被访问过的 i
                if (!vist[i] && (x < 0 || dis[i] < dis[x])) {
                    x = i;
                }
            }
            // 因为start和end都是合法的，所以在遍历完所有节点之前，一定可以找到一个节点是end
            // 找到了从start开始的，没有被访问过的节点中，距离最短的节点i
            if (dis[x] == INF) {
                return -1;
            }
            // 如果 x 就是 end
            if (x == end) {
                return dis[x];
            }
            // start 到 x 已经找到最短距离
            vist[x] = true;
            // 如果没找尾节点，就从x节点开始，找下一个最短路径节点
            for (int i = 0; i < n; i++) {
                if (!vist[i] && dis[x] + graph[x][i] < dis[i]) {
                    dis[i] = dis[x] + graph[x][i];
                }
            }
        }
    }*/
}
