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


        LGraph graph2 = new LGraph(8);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 3);
        graph2.addEdge(2, 4);
        graph2.addEdge(2, 5);
        graph2.addEdge(4, 5);
        graph2.addEdge(4, 6);
        graph2.addEdge(5, 6);
        graph2.addEdge(7, 6);

        System.out.println(graph2.dfs(6, 3));
        System.out.println(graph2.dfs(5, 9));
        graph2.dfp(6, 3);
        graph2.dfp(5, 4);
        graph2.dfp(3, 5);
        System.out.println(graph2.dfp2(6, 3));
        System.out.println(graph2.dfp2(5, 4));
        System.out.println(graph2.dfp2(3, 5));

        System.out.println(graph2.bfs(6, 3));
        System.out.println(graph2.bfs(5, 9));
        graph2.bfp(6, 3);
        graph2.bfp(5, 4);
        graph2.bfp(3, 5);
        graph2.bfp(3, 6);

    }
}
