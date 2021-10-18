package datastructure.graph;

/**
 * 「有向无权图（邻接矩阵实现）」
 */
public class MGraphV {

    private int vertexCount;                                // 图顶点个数
    private boolean matrix[][];                             // 邻接矩阵

    public MGraphV(int vertexCount) {
        this.vertexCount = vertexCount;
        matrix = new boolean[vertexCount][vertexCount];     // 初始都为false
    }

    public int getVertexCount() {return this.vertexCount;}
    public boolean[][] getMatrix() {return this.matrix;}

    public void addEdge(int s, int t) {
        matrix[s][t] = true;
    }

}
