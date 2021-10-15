package datastructure.graph;

/**
 * 「无向无权图（邻接矩阵）」
 */
public class MGraph {

    private int v;
    private boolean matrix[][];

    public MGraph(int v) {
        this.v = v;
        matrix = new boolean[v][v];
    }

    public void addEdge(int s, int t) {
        matrix[s][t] = true;
        matrix[t][s] = true;
    }

}
