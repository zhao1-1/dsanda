package datastructure.graph;

/**
 * 「有向有权图（邻接矩阵）」
 */

public class MGraphVM {

    private int v;
    private int matrix[][];

    public MGraphVM(int v) {
        this.v = v;
        matrix = new int[v][v];
    }

    public void addEdge(int s, int t, int weight) {
        matrix[s][t] = weight;
    }

}
