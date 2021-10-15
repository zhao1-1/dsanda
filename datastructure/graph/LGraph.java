package datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 「无向无权图（邻接表）」
 */
public class LGraph {

    private int v;
    private LinkedList<Integer> adj[];

    public LGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }


    /**
     * BFS (Breadth-First-Search) 广度优先搜索
     * 时间复杂度：o(E)
     * 空间复杂度：o(V)
     */
    public boolean bfs(int s, int t) {
        boolean[] visited = new boolean[this.v];    //「访问记录条」
        Queue<Integer> storeQueue = new LinkedList<>();
        storeQueue.add(s);
        visited[s] = true;
        while (!storeQueue.isEmpty()) {
            int focalN = storeQueue.poll();
            if (focalN == t) return true;           // 存在 s->t 路径
            for (int i = 0; i < this.adj[focalN].size(); i++) {
                int handleN = this.adj[focalN].get(i);
                if (!visited[handleN]) {
                    visited[handleN] = true;        // 设置为存在于「访问记录条」中
                    storeQueue.offer(handleN);
                }
            }
        }
        return false;                               // BFS扫描过程结束，未发现 s->t 路径
    }


    /**
     * BFP (Breadth-First-Print) 广度优先遍历「输出s->t路径」
     * ⚠️：结果不是唯一的，与vertex加入图的顺序有关（即与addEdge()执行顺序有关）
     */
    public void bfp(int s, int t) {
        boolean[] visited = new boolean[this.v];
        Queue<Integer> storeQueue = new LinkedList<>();
        storeQueue.add(s);
        visited[s] = true;

        // 路径追踪器
        /*
           path「0 -> 1 -> 3 -> 6」
           value: -1   0  -1   1  -1  -1   3
           index:  0   1   2   3   4   5   6
         */
        int[] pathTrack = new int[this.v];
        for (int i = 0; i < pathTrack.length; i++) {
            pathTrack[i] = -1;
        }

        while (!storeQueue.isEmpty()) {
            int focalV = storeQueue.poll();
            for (int i = 0; i < this.adj[focalV].size(); i++) {
                int handleV = this.adj[focalV].get(i);
                if (!visited[handleV]) {
                    pathTrack[handleV] = focalV;
                    if (handleV == t) {
                        printS2TPath(pathTrack, s, t);
                        return;
                    }
                    visited[handleV] = true;
                    storeQueue.offer(handleV);
                }
            }
        }
    }
    private void printS2TPath(int[] pathTrack, int end, int start) {
        printS2TPathR(pathTrack, end, start);
        System.out.print("END");
        System.out.println("");
    }
    private void printS2TPathR(int[] pathTrack, int end, int start) {
        if (pathTrack[start] != -1 && start != end)
            printS2TPathR(pathTrack, end, pathTrack[start]);
        System.out.print(start + " -> ");
    }


    /**
     * DFS (Depth-First-Search) 深度优先搜索
     * 时间复杂度：o(E)
     * 空间复杂度：o(V)
     */
    private boolean foundDFS;
    public boolean dfs(int s, int t) {
        this.foundDFS = false;
        boolean[] visited = new boolean[this.v];
        dfsR(s, t, visited);
        return foundDFS;
    }
    private void dfsR(int s, int t, boolean[] visited) {
        if (foundDFS) return;
        visited[s] = true;
        if (s == t) {
            foundDFS = true;
            return;
        }
        for (int i = 0; i < this.adj[s].size(); i++) {
            int focalN = this.adj[s].get(i);
            if (!visited[focalN])
                dfsR(focalN, t, visited);
        }
    }


    /**
     * DFP (Depth-First-Print) 深度优先搜索「打印s->t路径」（直接打印输出）
     * 解法一：打印方法用「路径追踪器」
     * ⚠️：结果不是唯一的，与vertex加入图的顺序有关（即与addEdge()执行顺序有关）
     */
    public void dfp(int s, int t) {
        this.foundDFS = false;
        boolean[] visited = new boolean[this.v];
        int[] pathTrack = new int[this.v];
        for (int i = 0; i < pathTrack.length; i++) {
            pathTrack[i] = -1;
        }
        dfpR(s, t, visited, pathTrack);
        this.printS2TPath(pathTrack, s, t);
    }
    private void dfpR(int s, int t, boolean[] visited, int[] pathTrack) {
        if (this.foundDFS) return;
        visited[s] = true;
        if (s == t) {
            this.foundDFS = true;
            return;
        }
        for (int i = 0; i < this.adj[s].size(); i++) {
            int focalV = this.adj[s].get(i);
            if (!visited[focalV]) {
                pathTrack[focalV] = s;
                this.dfpR(focalV, t, visited, pathTrack);
            }
        }
    }


    /**
     * DFP (Depth-First-Print) 深度优先搜索「打印s->t路径」（返回路径链表）
     * 解法二：打印方法用「全局变量resultPath」
     */
    private List<Integer> resultPathDFP = new ArrayList<>();
    public List<Integer> dfp2(int s, int t) {
        this.foundDFS = false;
        boolean[] visited = new boolean[this.v];
        dfpR2(s, t, visited, new ArrayList<>());
        return resultPathDFP;
    }
    private void dfpR2(int start, int target, boolean[] visited, List<Integer> path) {
        if (foundDFS) return;

        visited[start] = true;
        path.add(start);

        if (start == target) {
            resultPathDFP = new ArrayList<>(path);
            foundDFS = true;
            return;
        }

        for (int i = 0; i < this.adj[start].size(); i++) {
            int focalN = this.adj[start].get(i);
            if (!visited[focalN]) {
                dfpR2(focalN, target, visited, path);
            }
        }

        // 未发现目标值，函数出栈，弹出path里最后一个元素
        path.remove(path.size() - 1);
    }

}
