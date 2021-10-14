package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 */
public class Solution11 {

    /*
    回溯代码模板：

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


    /**
     *【11-1-1】八皇后
     * {面试题金典 08.12.}
     */


    /**
     *【11-1-2】解数独
     * {力扣-37}
     */


    /**
     *【11-1-3】电话号码的字母组合
     * {力扣-17}
     */


    /**
     *【11-2-1】组合（给N个数返回所有K个数的组合）
     * {力扣-77}
     */


    /**
     *【11-2-2】子集（所有的组合）
     * {力扣-78}
     */


    /**
     *【11-2-3】子集II（有重复数据）
     * {力扣-90}
     */


    /**
     *【11-2-4】全排列（所有的排列）
     * {力扣-46}
     */
    private List<List<Integer>> result7 = new ArrayList<>();
    private void backTrack7(int[] nums, int k, List<Integer> path) {
        // 结束
        if (k == nums.length) {
            result7.add(new ArrayList<>(path));
            return;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backTrack7(nums, 0, path);
        return result7;
    }


    /**
     *【11-2-5】全排列II（有重复数据）
     * {力扣-47}
     */


    /**
     *【11-3-1】组合总和（选出某几个数相加为给定和，无重复数据，可以使用多次，不能有重复答案）
     * {力扣-39}
     */


    /**
     *【11-3-2】组合总和II（选出某几个数相加为给定和，有重复数据，只能使用一次，不能有重复答案）
     * {力扣-40}
     */


    /**
     *【11-3-3】组合总和III（选出k个数相加为给定和，没有重复数据，只能使用一次）
     * {力扣-216}
     */


    /**
     *【11-4-1】分割回文串
     * {力扣-131}
     */


    /**
     *【11-4-2】复原IP地址
     * {力扣-93}
     */


    /**
     *【11-4-3】括号生成
     * {力扣-22}
     */

}
