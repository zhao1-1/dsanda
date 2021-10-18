package datastructure;

import datastructure.graph.LGraphV;

import java.util.*;

/**
 * 图 + 「DFS & BFS」
 */
public class Solution13 {

    // 上、下、左、右
    private final int[][] DIRECTIONSTools = {{-1,0},{1,0},{0,-1},{0,1}};
    private final int DIRECTIONCounts = 4;

    /**
     *【13-1-1】机器人的运动范围
     * 「剑指Offer 13」
     */
    class SS13_1_1{
        private int result;
        public int movingCount(int m, int n, int k) {
            result = 0;
            boolean[][] visited = new boolean[m][n];
            dfsForMovingCount(0, 0, m, n, k, visited);
            return this.result;
        }
        private void dfsForMovingCount(int handleI, int handleJ, int m, int n, int k, boolean[][] visited) {
            visited[handleI][handleJ] = true;
            this.result++;
            for (int di = 0; di < DIRECTIONCounts; di++) {
                int moveI = DIRECTIONSTools[di][0] + handleI;
                int moveJ = DIRECTIONSTools[di][1] + handleJ;
                if (moveI >= 0 && moveI < m && moveJ >= 0 && moveJ < n && !visited[moveI][moveJ] && checkIsLegal(moveI, moveJ, k))
                    dfsForMovingCount(moveI, moveJ, m, n, k, visited);
            }
        }
        private boolean checkIsLegal(int i, int j, int k) {
            int sum = 0;
            while (i != 0) {
                sum += i % 10;
                i /= 10;
            }
            while (j != 0) {
                sum += j % 10;
                j /= 10;
            }
            return sum <= k;
        }
    }


    /**
     *【13-1-2】颜色填充
     * 「面试题金典 08.10.」
     */
    class SS13_1_2 {
        private boolean[][] visited;
        private int[][] result;
        private int nowColor;
        private int high;
        private int width;

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            this.high = image.length;
            this.width = image[0].length;
            this.result = new int[this.high][this.width];
            for (int i = 0; i < high; i++) {
                for (int j = 0; j < width; j++) {
                    this.result[i][j] = image[i][j];
                }
            }
            this.visited = new boolean[high][width];
            this.nowColor = image[sr][sc];

            dfsForFloodFill(this.result, sr, sc, newColor);
            return this.result;
        }

        private void dfsForFloodFill(int[][] result, int vertexI, int vertexJ, int newColor) {
            result[vertexI][vertexJ] = newColor;
            this.visited[vertexI][vertexJ] = true;
            for (int di = 0; di < DIRECTIONCounts; di++) {
                int moveI = vertexI + DIRECTIONSTools[di][0];
                int moveJ = vertexJ + DIRECTIONSTools[di][1];
                if (moveI >= 0 && moveI < high && moveJ >= 0 && moveJ < width && !visited[moveI][moveJ] && result[moveI][moveJ] == this.nowColor)
                    dfsForFloodFill(result, moveI, moveJ, newColor);
            }
        }
    }


    /**
     *【13-2-1】打开转盘锁
     * 思路：BFS最短路径
     * {力扣-752}
     */
    public int openLock(String[] deadEnds, String target) {
        int depth = 0;

        HashSet<String> deadSet = new HashSet<>();
        for (String s : deadEnds) {
            deadSet.add(s);
        }
        if (deadSet.contains("0000")) return -1;

        Queue<String> storeQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();              // 访问记录器
        storeQueue.offer("0000");
        visited.add("0000");

        while (!storeQueue.isEmpty()) {
            int currLevelSize = storeQueue.size();
            for (int i = 0; i < currLevelSize; i++) {
                String handleV = storeQueue.poll();
                if (handleV.equals(target)) return depth;

                List<String> handleVChildren = genChildren(handleV);
                for (String handleVChild : handleVChildren) {
                    if (!visited.contains(handleVChild) && !deadSet.contains(handleVChild)) {
                        visited.add(handleVChild);
                        storeQueue.offer(handleVChild);
                    }
                }
            }
            depth++;
        }

        return -1;
    }
    private List<String> genChildren(String father) {
        int PASSWORD_Bit = 4;
        List<String> newChildren = new ArrayList<>();
        for (int i = 0; i < PASSWORD_Bit; i++) {
            // 加一位
            char[] newChild1 = new char[4];
            for (int j = 0; j < father.length(); j++) {
                newChild1[j] = father.charAt(j);
            }
            newChild1[i] = ((newChild1[i] - '0' + 1) % 10 + "").charAt(0);
            newChildren.add(new String(newChild1));

            // 减一位
            char[] newChild2 = new char[4];
            for (int j = 0; j < father.length(); j++) {
                newChild2[j] = father.charAt(j);
            }
            newChild2[i] = ((newChild2[i] - '0' - 1 + 10) % 10 + "").charAt(0);
            newChildren.add(new String(newChild2));
        }
        return newChildren;
    }


    /**
     *【13-3-1】岛屿数量
     * 「力扣-200」
     */
    class SS13_3_1 {
        private int result;
        private boolean[][] visited;
        private int high;
        private int width;

        public int numIslands(char[][] grid) {
            result = 0;
            high = grid.length;
            width = grid[0].length;
            visited = new boolean[high][width];

            for (int i = 0; i < this.high; i++) {
                for (int j = 0; j < this.width; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        this.result++;
                        dfsForNumIslands(grid, i, j);
                    }
                }
            }
            return result;
        }

        private void dfsForNumIslands(char[][] grid, int vertexI, int vertexJ) {
            this.visited[vertexI][vertexJ] = true;
            for (int di = 0; di < DIRECTIONCounts; di++) {
                int moveI = vertexI + DIRECTIONSTools[di][0];
                int moveJ = vertexJ + DIRECTIONSTools[di][1];
                if (moveI >= 0 && moveI < this.high && moveJ >= 0 && moveJ < this.width && !visited[moveI][moveJ] && grid[moveI][moveJ] == '1')
                    dfsForNumIslands(grid, moveI, moveJ);
            }
        }
    }


    /**
     *【13-4】拓扑排序
     * 解法一：Kahn算法
     */
    public void topologySortByKahn() {

    }


    /**
     *【13-4】拓扑排序
     * 解法二：DFS算法
     */
    public void topologySortByDFS(LGraphV graph) {
        int vertexCount = graph.getVertexCount();
        boolean[] visited = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfsForTopologySort(graph, i, visited);
            }
        }
    }
    private void dfsForTopologySort(LGraphV graphV, int vertex, boolean[] visited) {
        LinkedList<Integer>[] adj = graphV.getAdj();
        for (int i = 0; i < adj[vertex].size(); i++) {
            int handleV = adj[vertex].get(i);
            if (visited[handleV]) continue;
            visited[handleV] = true;
            dfsForTopologySort(graphV, handleV, visited);
        }
        System.out.println(vertex + "->");
    }


    /**
     *【13-5】检测环
     * 「字节实习面试」
     * 解法：Kahn算法
     */

}
