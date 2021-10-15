package datastructure.graph;

/**
 * 「有向无权图（邻接矩阵实现）」
 */
public class MGraphV {

    private int v;                      // 图顶点个数
    private boolean matrix[][];         // 邻接矩阵

    public MGraphV(int v) {
        this.v = v;
        matrix = new boolean[v][v];     // 初始都为false
    }

    public void addEdge(int s, int t) {
        matrix[s][t] = true;
    }

}
