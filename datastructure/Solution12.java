package datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 回溯核心思想：
/*

【一】回溯的处理过程是一个「穷举（或者叫枚举）」的过程。枚举所有的解，找出其中满足期望的可行解。
     为了有规律的枚举所有可能的解，避免遗漏和重复，我们把问题求解的过程归纳为「多阶段决策模型」。
     每个阶段的决策会对应多个选择，从可选的选择列表中，任意选择一个，然后继续进行下一个阶段的决策。

【二】整个决策的过程，如果用拓扑结构来形象表示的话，就是一颗「决策树」。
     回溯枚举所有解来查找可行解的过程，就是「在决策树中进行遍历」的过程。
     遍历过程中记录的路径就是解。

【三】回溯一般使用「递归」来实现，递归树就跟决策树完全一样。
     「递」的过程进行函数调用，对应到递归树上为：从一个节点进入它的子节点；
     「归」的过程进行函数调用，对应到递归树上是：从子节点返回上一层节点。

 */


/**
 * 回溯
 */
public class Solution12 {

    // 回溯代码模板：
    /*
    result = [];
    def backTrack(可选列表, 决策阶段, 路径)
        if (满足结束条件「所有决策都已完成或得到可行解」)
            if (路径为可行解) : result.add(路径);
            return;

        for 选择 in [可选列表]:
            # 做选择
            路径.add(选择);
            backTrack(可选列表, 决策阶段+1, 路径);
            # 撤销选择
            路径.remove(选择);
     */



    /*
    === 模型一：八皇后模型
     */

    /**
     *【12-1-1】N皇后
     * {面试题金典 08.12.}
     */
    private List<List<String>> result1;
    /*
    board   -> 路径，记录已经做出的决策
    row     -> 阶段
    可选列表  -> 通过board推导出来，没有显式记录
     */
    private void backTrack1(char[][] board, int row, int n) {
        if (row == n) {
            List<String> snapshot = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                snapshot.add(new String(board[i]));
            }
            result1.add(snapshot);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isOKQueue(board, n, row, col)) {
                board[row][col] = 'Q';
                backTrack1(board, row+1, n);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        result1 = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backTrack1(board, 0, n);
        return result1;
    }
    private boolean isOKQueue(char[][] board, int n, int row, int col) {
        // 检查列是否冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // 检查左对角线是否冲突
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        // 检查右对角线是否冲突
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        return true;
    }


    /**
     *【12-1-2】解数独
     * {力扣-37}
     */
    private boolean[][] rows2 = new boolean[9][10];
    private boolean[][] cols2 = new boolean[9][10];
    private boolean[][][] blocks2 = new boolean[3][3][10];
    private boolean solved2;
    public void solveSudoku(char[][] board) {
        solved2 = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int x = board[i][j] - '0';
                    rows2[i][x] = true;
                    cols2[j][x] = true;
                    blocks2[i/3][j/3][x] = true;
                }
            }
        }
        backTrack2(board, 0, 0);
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(board[i]));
        }
    }
    private void backTrack2(char[][] board, int row, int col) {
        if (row == 9) {
            solved2 = true;
            return;
        }
        if (board[row][col] != '.') {
            int nextRow = row;
            int nextCol = col + 1;
            if (col == 8) {
                nextRow = row + 1;
                nextCol = 0;
            }
            backTrack2(board, nextRow, nextCol);
            // 在递归调用的返回点加「剪枝」条件
            if (solved2) return;
        } else {
            for (int num = 1; num <= 9; num++) {
                if (!rows2[row][num] && !cols2[col][num] && !blocks2[row/3][col/3][num]) {
                    board[row][col] = String.valueOf(num).charAt(0);
                    rows2[row][num] = true;
                    cols2[col][num] = true;
                    blocks2[row/3][col/3][num] = true;
                    int nextRow = row;
                    int nextCol = col + 1;
                    if (col == 8) {
                        nextRow = row + 1;
                        nextCol = 0;
                    }
                    backTrack2(board, nextRow, nextCol);
                    // 在递归调用的返回点加「剪枝」条件
                    if (solved2) return;
                    board[row][col] = '.';
                    rows2[row][num] = false;
                    cols2[col][num] = false;
                    blocks2[row/3][col/3][num] = false;
                }
            }
        }
    }


    /**
     *【12-1-3】电话号码的字母组合
     * {力扣-17}
     */
    private List<String> result3;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();

        String[] mappings = new String[10];
        mappings[2] = "abc";
        mappings[3] = "def";
        mappings[4] = "ghi";
        mappings[5] = "jkl";
        mappings[6] = "mno";
        mappings[7] = "pqrs";
        mappings[8] = "tuv";
        mappings[9] = "wxyz";

        result3 = new ArrayList<>();
        backTack3(mappings, digits, 0, new char[digits.length()]);
        return result3;
    }
    private void backTack3(String[] mappings, String digits, int k, char[] path) {
        if (k == digits.length()) {
            result3.add(new String(path));
            return;
        }

        String mapping = mappings[digits.charAt(k) - '0'];
        for (int i = 0; i < mapping.length(); i++) {
            path[k] = mapping.charAt(i);
            backTack3(mappings, digits, k+1, path);
        }
    }



    /*
    === 模型二：全排列
     */

    /**
     *【12-2-1】组合（给N个数返回所有K个数的组合）
     * {力扣-77}
     */
    private List<List<Integer>> result4;
    public List<List<Integer>> combine(int n, int k) {
        result4 = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backTrack4(nums, k, 0, new ArrayList<>());
        return result4;
    }
    /*
    n,k  -> 必须的参数
    step -> 阶段
    path -> 路径
    step选/不选 -> 可选列表
     */
    private void backTrack4(int[] nums, int selectN, int step, List<Integer> path) {
        if (path.size() == selectN) {
            result4.add(new ArrayList<>(path));
            return;
        }
        if (step == nums.length) return;

        // 不选
        backTrack4(nums, selectN, step+1, path);

        // 选择
        path.add(nums[step]);
        backTrack4(nums, selectN, step+1, path);
        path.remove(path.size()-1);
    }


    /**
     *【12-2-2】子集（所有的组合）（无重复数据）
     * 「类似与模型五0-1背包问题」
     * {力扣-78}
     */
    private List<List<Integer>> result5;
    private void backTrack5(int[] nums, int k, List<Integer> path) {
        if (k == nums.length) {
            result5.add(new ArrayList<>(path));
            return;
        }

        // 不选择
        backTrack5(nums, k+1, path);

        // 选择
        path.add(nums[k]);
        backTrack5(nums, k+1, path);
        path.remove(path.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        result5 = new ArrayList<>();
        backTrack5(nums, 0, new ArrayList<Integer>());
        return result5;
    }


    /**
     *【12-2-3】子集II（有重复数据）
     * {力扣-90}
     */
    private List<List<Integer>> result6;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (hm.containsKey(nums[i]))
                count += hm.get(nums[i]);
            hm.put(nums[i], count);
        }

        int n = hm.size();
        int[] uniqueNums = new int[n];
        int[] counts = new int[n];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                uniqueNums[k] = nums[i];
                counts[k] = hm.get(nums[i]);
                k++;
                hm.remove(nums[i]);
            }
        }

        result6 = new ArrayList<>();
        backTrack6(uniqueNums, counts, 0, new ArrayList<Integer>());
        return result6;
    }
    private void backTrack6(int[] uniqueNums, int[] counts, int k, List<Integer> path) {
        if (k == uniqueNums.length) {
            result6.add(new ArrayList<>(path));
            return;
        }
        for (int count = 0; count <= counts[k]; count++) {
            for (int i = 0; i < count; i++) {
                path.add(uniqueNums[k]);
            }
            backTrack6(uniqueNums, counts, k+1, path);
            for (int i = 0; i < count; i++) {
                path.remove(path.size()-1);
            }
        }
    }


    /**
     * 【12-2-4】全排列（所有的排列）（无重复数据）
     * {力扣-46}
     */
    private List<List<Integer>> result7;
    /*
    路径：记录在path中
    决策阶段：k
    可选列表：nums数组中去掉存在于path中的数据
     */
    private void backTrack7(int[] nums, int k, List<Integer> path) {
        if (k == nums.length) {
            result7.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue;
            // 做选择
            path.add(nums[i]);
            // 递归
            backTrack7(nums, k+1, path);
            // 撤销选择
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        result7 = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack7(nums, 0, path);
        return result7;
    }


    /**
     *【12-2-5】全排列II（有重复数据）
     * {力扣-47}
     */
    private List<List<Integer>> result8;
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (hm.containsKey(nums[i]))
                count += hm.get(nums[i]);
            hm.put(nums[i], count);
        }

        int n = hm.size();
        int[] uniqueNums = new int[n];
        int[] counts = new int[n];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                uniqueNums[k] = nums[i];
                counts[k] = hm.get(nums[i]);
                k++;
                hm.remove(nums[i]);
            }
        }

        result8 = new ArrayList<>();
        backTrack8(uniqueNums, counts, 0, new ArrayList<>(), nums.length);
        return result8;
    }
    private void backTrack8(int[] uniqueNums, int[] counts, int k, List<Integer> path, int n) {
        if (k == n) {
            result8.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < uniqueNums.length; i++) {
            if (counts[i] == 0) continue;
            path.add(uniqueNums[i]);
            counts[i]--;
            backTrack8(uniqueNums, counts, k+1, path, n);
            path.remove(path.size()-1);
            counts[i]++;
        }
    }


    /*
    === 模型三：所有的组合
     */

    /**
     *【12-3-1】组合总和（选出某几个数相加为给定和，无重复数据，可以使用多次，不能有重复答案）
     * {力扣-39}
     */
    private List<List<Integer>> result9;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result9 = new ArrayList<>();
        return result9;
    }
    private void backTrack9(int[] candidates) {

    }


    /**
     *【12-3-2】组合总和II（选出某几个数相加为给定和，有重复数据，只能使用一次，不能有重复答案）
     * {力扣-40}
     */


    /**
     *【12-3-3】组合总和III（选出k个数相加为给定和，没有重复数据，只能使用一次）
     * {力扣-216}
     */



    /*
    === 模型四：正则表达式
     */

    /**
     *【12-4-1】分割回文串
     * {力扣-131}
     */


    /**
     *【12-4-2】复原IP地址
     * {力扣-93}
     */


    /**
     *【12-4-3】括号生成
     * {力扣-22}
     */


    /*
    === 模型五：0-1背包模型
     */
    // 见Solution14【例A】（a）解法一

}