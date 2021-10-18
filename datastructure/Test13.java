package datastructure;

import datastructure.graph.LGraph;
import datastructure.graph.LGraphV;

public class Test13 {
    public static void main(String[] args) {

//        LGraphV graph1 = new LGraphV(7);
//        graph1.addEdge(0,1);
//        graph1.addEdge(0,2);
//        graph1.addEdge(1,3);
//        graph1.addEdge(1,4);
//        graph1.addEdge(2,4);
//        graph1.addEdge(2,5);
//        graph1.addEdge(3,6);
//        graph1.addEdge(4,6);
//        graph1.addEdge(5,6);
//
//        System.out.println(graph1.bfs(0,6));
//        System.out.println(graph1.bfs(2,3));
//        System.out.println(graph1.bfs(6,2));
//
//        graph1.bfp(0,6);
//        graph1.bfp(0,5);


//        LGraph graph2 = new LGraph(8);
//        graph2.addEdge(0, 1);
//        graph2.addEdge(1, 2);
//        graph2.addEdge(1, 3);
//        graph2.addEdge(2, 3);
//        graph2.addEdge(2, 4);
//        graph2.addEdge(2, 5);
//        graph2.addEdge(4, 5);
//        graph2.addEdge(4, 6);
//        graph2.addEdge(5, 6);
//        graph2.addEdge(7, 6);
//
//        System.out.println(graph2.dfs(6, 3));
//        System.out.println(graph2.dfs(5, 9));
//        graph2.dfp(6, 3);
//        graph2.dfp(5, 4);
//        graph2.dfp(3, 5);
//        System.out.println(graph2.dfp2(6, 3));
//        System.out.println(graph2.dfp2(5, 4));
//        System.out.println(graph2.dfp2(3, 5));
//
//        System.out.println(graph2.bfs(6, 3));
//        System.out.println(graph2.bfs(5, 9));
//        graph2.bfp(6, 3);
//        graph2.bfp(5, 4);
//        graph2.bfp(3, 5);
//        graph2.bfp(3, 6);


        Solution13 sl13 = new Solution13();

        /**
         *【13-1-1】机器人的运动范围
         * 「剑指Offer 13」
         */
//        Solution13.SS13_1_1 ss13_1_1 = sl13.new SS13_1_1();
//        System.out.println(ss13_1_1.movingCount(2,3,1));
//        System.out.println(ss13_1_1.movingCount(3,1,0));
//        System.out.println(ss13_1_1.movingCount(1,2,1));


        /**
         *【13-1-2】颜色填充
         * 「面试题金典 08.10.」
         */
        Solution13.SS13_1_2 ss13_1_2 = sl13.new SS13_1_2();
        System.out.println(ss13_1_2.floodFill(new int[][]{
                {1,1,1},
                {1,1,0},
                {1,0,1}},
                1, 1, 2));


        /**
         *【13-2-1】打开转盘锁
         * {力扣-752}
         */
//        System.out.println(sl13.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
//        System.out.println(sl13.openLock(new String[]{"8888"}, "0009"));
//        System.out.println(sl13.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
//        System.out.println(sl13.openLock(new String[]{"0000"}, "0001"));


        /**
         *【13-3-1】岛屿数量
         * 「力扣-200」
         */
//        Solution13.SS13_3_1 ss13_3_1 = sl13.new SS13_3_1();
//        System.out.println(ss13_3_1.numIslands(new char[][]{
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}}));
//        System.out.println(ss13_3_1.numIslands(new char[][]{
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}}));



        /**
         *【13-4】拓扑排序
         */


    }
}
