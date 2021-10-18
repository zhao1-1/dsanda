package datastructure.graph;

/**
 * 「有向有权图（邻接矩阵）」
 */

public class MGraphVM {

    private int vertexCount;
    private int matrix[][];

    public MGraphVM(int vertexCount) {
        this.vertexCount = vertexCount;
        matrix = new int[vertexCount][vertexCount];
    }

    public int getVertexCount() {return this.vertexCount;}
    public int[][] getMatrix() {return this.matrix;}

    public void addEdge(int s, int t, int weight) {
        matrix[s][t] = weight;
    }

}
