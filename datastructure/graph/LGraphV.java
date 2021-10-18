package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 「有向无权图（邻接表）」
 */
public class LGraphV {

    private int vertexCount;                // 图节点个数
    private LinkedList<Integer> adj[];      // 邻接表

    public LGraphV(int vertexCount) {
        this.vertexCount = vertexCount;
        adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() { return this.vertexCount; }
    public LinkedList<Integer>[] getAdj() { return this.adj; }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    /**
     * BFS (Breadth-First-Search) 广度优先搜索
     * 时间复杂度：o(E)
     * 空间复杂度：o(V)
     */
    public boolean bfs(int s, int t) {
        boolean[] visited = new boolean[this.vertexCount];    //「访问记录条」
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
     */
    public void bfp(int s, int t) {
        boolean[] visited = new boolean[this.vertexCount];
        Queue<Integer> storeQueue = new LinkedList<>();
        storeQueue.add(s);
        visited[s] = true;

        // 路径追踪器
        /*
           path「0 -> 1 -> 3 -> 6」
           value: -1   0  -1   1  -1  -1   3
           index:  0   1   2   3   4   5   6
         */
        int[] pathTrack = new int[this.vertexCount];
        for (int i = 0; i < pathTrack.length; i++) {
            pathTrack[i] = -1;
        }

        while (!storeQueue.isEmpty()) {
            int focalN = storeQueue.poll();
            for (int i = 0; i < this.adj[focalN].size(); i++) {
                int handleN = this.adj[focalN].get(i);
                if (!visited[handleN]) {
                    pathTrack[handleN] = focalN;
                    if (handleN == t) {
                        printS2TPath(pathTrack, s, t);
                        System.out.print("END");
                        System.out.println("");
                        return;
                    }
                    visited[handleN] = true;
                    storeQueue.offer(handleN);
                }
            }
        }
    }
    private void printS2TPath(int[] pathTrack, int end, int start) {
        if (pathTrack[start] != -1 && start != end)
            printS2TPath(pathTrack, end, pathTrack[start]);
        System.out.print(start + " -> ");
    }


    /**
     * BFH (Breadth-First-Handle) 广度优先遍历
     */
    public void bfh() {

    }

}
