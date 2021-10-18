package datastructure.graph;

/**
 * 「无向无权图（邻接矩阵）」
 */
public class MGraph {

    private int vertexCount;
    private boolean matrix[][];

    public MGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        matrix = new boolean[vertexCount][vertexCount];
    }

    public int getVertexCount() {return this.vertexCount;}

    public void addEdge(int s, int t) {
        matrix[s][t] = true;
        matrix[t][s] = true;
    }

}
