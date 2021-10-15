package datastructure;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 图 + 「DFS & BFS」
 */
public class Solution13 {

    /**
     *【13-2-1】打开转盘锁
     * 思路：DFS最短路径
     * {力扣-752}
     */
    public int openLock(String[] deadends, String target) {
        int depth = 0;

        HashSet<String> deadSet = new HashSet<>();
        for (String s : deadSet) {
            deadSet.add(s);
        }
        if (deadSet.contains("0000")) return -1;

        Queue<String> storeQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();              // 访问记录器

        storeQueue.add("0000");
        visited.add("0000");

        while (!storeQueue.isEmpty()) {

        }

        return -1;
    }

}
