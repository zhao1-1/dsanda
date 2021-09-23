package datastructure;

import java.util.*;

/**
 * 02-找规律题
 */
public class Solution2 {

    /**
     *【2-1】换啤酒
     * {阿里钉钉} {滴滴}
     */
    public int drinkBeer(int x) {
        int bottleCount = x;
        int bodyCount = x;
        int capCount = x;
        while (bodyCount >= 3 || capCount >= 7) {
            while (bodyCount >= 3) {
                int changeCount = bodyCount / 3;
                bottleCount += changeCount;
                bodyCount %= 3;
                bodyCount += changeCount;
                capCount += changeCount;
            }
            while (capCount >= 7) {
                int changeCount = capCount / 7;
                bottleCount += changeCount;
                capCount %= 7;
                bodyCount += changeCount;
                capCount += changeCount;
            }
        }
        return bottleCount;
    }


    /**
     *【2-2】扑克牌中的顺子
     * {剑指Offer-61}
     */
    public boolean isStraight(int[] nums) {
        boolean[] dup = new boolean[14];
        int min = 14;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (dup[nums[i]])
                    return false;
                else
                    dup[nums[i]] = true;

                if (nums[i] < min) min = nums[i];
                if (nums[i] > max) max = nums[i];
            }
        }
        return (max - min) < nums.length;
    }


    /**
     *【2-3】零矩阵
     * {面试题金典-01.08}
     * 解法1：自己、性能只超过35%
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> iSet = new HashSet<>();
        Set<Integer> jSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    iSet.add(i);
                    jSet.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (iSet.contains(i) || jSet.contains(j)) matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("==============================");
    }

    // 解法2：不用容器工具类，空间o(m+n)，空间o(m*n)
    public void setZeroes_2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // 可以不用Set类
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     *【2-3】零矩阵
     * {面试题金典-01.08}
     * 解法3*：标记变量法
     * 时间复杂度：o(m*n + 2*(m+n))
     * 空间复杂度：o(1)
     */
    public void setZeroes_3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowFlag = false;
        boolean colFlag = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) colFlag = true;
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) rowFlag = true;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (colFlag)
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        if (rowFlag)
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("==============================");
    }


    /**
     *【2-4】跳水板
     * {面金16.11}
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        /*
        注意：
        （1）new int[0]    --->  []
        （2）new int[1]    --->  [0]
        （3）new int[]{0}  --->  [0]
        结论：下面两个判断不能换顺序！！否则输出不了[]这种形式，都将是[0]
        */
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{shorter * k};

        int[] a = new int[k+1];
        for (int i = k; i >= 0 ; i--) {
            a[k-i] = shorter * i + longer * (k - i);
        }
        return a;
    }


    /**
     *【2-5*】一次编辑
     * {面金01.05}
     * 解法一：双指针法
     * 时间复杂度：o(fN+sN)
     * 空间复杂度：o(1)
     */
    public boolean oneEditAway(String first, String second) {
        int fN = first.length();
        int sN = second.length();

        if (Math.abs(fN - sN) > 1) return false;
        if (first.equals(second)) return true;

        int fixN = 0;
        int fI = 0;
        int sI = 0;
        while (fI < fN && sI < sN) {
            if (first.charAt(fI++) == second.charAt(sI++)) continue;
            if (++fixN > 1) return false;
            if (fN > sN) sI--;
            if (fN < sN) fI--;
        }
        return true;
    }


    /**
     *【2-5*】一次编辑
     * {面金01.05}
     * 解法二：单指针，性能高
     * 时间复杂度：o(N)
     * 空间复杂度：o(1)
     */
    /*
    	高性能思路：只有一个地方需要修改，那么不妨定位到不同字符处。有以下两种情况
            + 长度相同：leetcode 与 leetkode。
              那么我们需要找到 'c' 和 'k'，然后比较 'ode' 和 'ode' 是否相同。
            + 长度不同：leetcode 与 leetode。
              我们发现 'c' 和 'o' 不相同，然后比较 'ode' 和 'ode' 是否相同。
    */
    public boolean oneEditAway_2(String first, String second) {
        if (Objects.isNull(first) || Objects.isNull(second)) return false;

        int fN = first.length();
        int sN = second.length();

        if (Math.abs(fN - sN) > 1) return false;
        if (fN < sN) return oneEditAway_2(second, first);

        for (int i = 0; i < sN; i++) {
            if (first.charAt(i) != second.charAt(i))
                return first.substring(i+1).equals(second.substring(fN == sN ? i+1 : i));
        }
        return true;
    }


    /**
     *【2-5*】一次编辑
     * {面金01.05}
     * 解法三：王争实现（逻辑清晰）
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean oneEditAway_3(String first, String second) {
        if (Objects.isNull(first) || Objects.isNull(second)) return false;

        int fN = first.length();
        int sN = second.length();
        if (Math.abs(fN - sN) > 1) return false;

        int fPoint = 0;
        int sPoint = 0;
        while (fPoint < fN && sPoint < sN && first.charAt(fPoint) == second.charAt(sPoint)){
            fPoint++;
            sPoint++;
        }
        if (fN == sN) {
            fPoint++;
            sPoint++;
        } else if (fN > sN) {
            fPoint++;
        } else {
            sPoint++;
        }
        // 这么写也是内存溢出！
//        while (fPoint < fN && sPoint < sN && first.charAt(fPoint++) == second.charAt(sPoint++)) ;
//        if (fN > sN) sPoint--;
//        if (fN < sN) fPoint--;
        // 如果这么写，会内存溢出！！
//        while (fPoint < fN && sPoint < sN && first.charAt(fPoint++) == second.charAt(sPoint++)) ;
//        return fPoint == fN ? true : false;
        while (fPoint < fN && sPoint < sN) {
            if (first.charAt(fPoint) != second.charAt(sPoint)) return false;
            fPoint++;
            sPoint++;
        }
        return true;
    }


    /**
     *【2-6】珠玑妙算
     * {面金-16.15}
     * 解法一：暴力枚举
     * 时间复杂度：o(n^2)
     */
    public int[] masterMind(String solution, String guess) {
        char FLAG = '%';
        char[] solutions = solution.toCharArray();
        char[] guesses = guess.toCharArray();
        int[] result = new int[2];
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < solutions.length; i++) {
            if (solutions[i] == guesses[i]) {
                countA++;
                solutions[i] = guesses[i] = FLAG;
            }
        }
        for (int i = 0; i < solutions.length; i++) {
            for (int j = 0; j < guesses.length; j++) {
                if (solutions[i] != FLAG && guesses[j] != FLAG && solutions[i] == guesses[j]) {
                    countB++;
                    solutions[i] = guesses[j] = FLAG;
                }
            }
        }
        result[0] = countA;
        result[1] = countB;
        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     *【2-6】珠玑妙算
     * {面金-16.15}
     * 解法1-2：暴力枚举，不用FALG，而是用标记数组（王争习题课思路）
     * 时间复杂度：o(n^2)
     */


    /**
     *【2-6】珠玑妙算
     * {面金-16.15}
     * 解法2：一次遍历梭哈，用大小为26的数组作为A-Z的map
     * 时间复杂度：o(n)
     */
    public int[] masterMind_2(String solution, String guess) {
        int[] countMap = new int[26];
        int realCount = 0;
        int fakeCount = 0;
        char solC;
        char gueC;
        for (int i = 0; i < 4; i++) {
            solC = solution.charAt(i);
            gueC = guess.charAt(i);
            if (solC == gueC){
                realCount++;
            } else {
                if (countMap[solC - 'A'] < 0) fakeCount++;
                countMap[solC - 'A'] ++;

                if ((countMap[gueC - 'A']) > 0) fakeCount++;
                countMap[gueC - 'A']--;
            }
        }
        System.out.println(realCount + "," + fakeCount);
        return new int[]{realCount, fakeCount};
    }


    /**
     *【2-7】井字游戏
     * {面金-16.04}
     */
//    public String tictactoe(String[] board) {
//        int N = board.length;
//        int rowCountO = 0;
//        int colCountO = 0;
//        int rightCountO = 0;
//        int leftCountO = 0;
//        int rowCountX = 0;
//        int colCountX = 0;
//        int rightCountX = 0;
//        int leftCountX = 0;
//        boolean hasEmpty = false;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j< N; j++) {
//                if (!hasEmpty && " " == board[i].charAt(j)) hasEmpty = true;
//                if ()
//            }
//        }
//    }


    // 第一次整个思路可能都是错的！！
    /*
    public String tictactoe_2(String[] board) {
        // 必须加这个判断，因为如果countX=0，0%1==0，1%1==0
        if (board.length == 1) {
            if (board[0] == " ")
                return "Pending";
            else
                return board[0];
        }
        int N = board.length;
        int emptyCount = 0;
        int iO = 0;
        int jO = 0;
        int iX = 0;
        int jX = 0;
        int countO = 0;
        int countX = 0;
        boolean successO = false;
        boolean successX = false;
        char currC;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                currC = board[i].charAt(j);
                if ('O' == currC) {
                    iO += i;
                    jO += j;
                    countO++;
                }
                if ('X' == currC) {
                    iX += i;
                    jX += j;
                    countX++;
                }
                if (' ' == currC) {
                    emptyCount++;
                }
            }
        }
        if (iO % N == 0 && jO % N == 0 && countO % N == 0) successO = true;
        if (iX % N == 0 && jX % N == 0 && countO % N == 0) successX = true;
        if (successO && successX) return "Draw";
        if (!successO && !successX && emptyCount > 0) return "Pending";
        if (!successO && !successX && emptyCount == 0) return "Draw";
        if (successO && !successX)
            return "O";
        else
            return "X";
    }
    */


    /**
     *【2-8】跳跃游戏
     * {力扣-55}
     // 错误思路，注意是最大跳跃长度，即你可以跳比这个数小的步数。
     */
    public boolean canJump_x(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i == nums.length - 1) return true;
            if (nums[i] == 0) return  false;
            i += nums[i];
        }
        return false;
    }

    /**
     *【2-8】跳跃游戏
     * {力扣-55}
     * 解法1：自己的思路（很不容易，完全正确！）
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int k;
                for (k = i-1 ; k >= 0; k--) {
                    if (nums[k] > i-k) break;
                }
                if (k < 0 && i != nums.length - 1) return false;
            }
        }
        return true;
    }

    // 解法2：用数组标记所有可达点（王争）
//    public boolean canJump_2(int[] nums) {
//        if (nums.length == 1) return true;
//        int n = nums.length;
//        boolean[] flags = new boolean[n];
//        int k = 0;
//        for (int i = 0; i < n; i++) {
//            for (k = i; k < nums[i]+i; k++) {
//                if (!flags[k])
//                    flags[k] = true;
//            }
//        }
//        for (int i = 1; i < n; i++) {
//            if (flags[i] == false) return false;
//        }
//        return true;
//
//    }

    // 解法3：最大跳跃距离----解法2的优化（王争）
    public boolean canJump_3(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxJump) return false;
            if (nums[i] + i > maxJump) maxJump = nums[i] + i;
            if (maxJump >= nums.length - 1) return true;
        }
        return false;
    }



    /**
     *【2-9】旋转图像*
     * {力扣-48}
     // 解法1：使用辅助数组（思路和实现都简单，但是不符合题意）
     * 注意：三种解法都需要掌握！
     */
    /*
 扩展题型：
（1）n*n的⼆维矩阵，沿上下中线翻转、沿左右中线翻转；
（2）n*n的⼆维矩阵，沿左上-右下对⻆线翻转、沿左下-右上对⻆线翻转；
（3）n*n的⼆维矩阵，旋转90度、180度、270度；
（4）n*m的⼆维矩阵，沿上下中线翻转、沿左右中线翻转
（5）n*m的⼆维矩阵，沿左上-右下对⻆线翻转、沿左下-右上对⻆线翻转
（6）n*m的⼆维矩阵，旋转90度、180度、270度
     */
    public void rotate_1(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n-1-i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    /**
     *【2-9】旋转图像*
     * {力扣-48}
     // 解法2：原地旋转（思路简单，实现难）
     */
    public void rotate_2(int[][] matrix) {
    }

    /**
     *【2-9】旋转图像*
     * {力扣-48}
     // 解法3：反转代替旋转（先水平翻转，再对角线翻转）
     */
   	/*
  	四种翻转：
  	（1）上下翻
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-i-1][j] = temp;
            }
        }
  	（2）左右翻
        for (int j = 0; j < n / 2; j++) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
  	（3）左对角翻\
  		for (int i = 0; i < n; i++) {
  			for (int j = 0; j < i; j++) {
  				int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
  			}
  		}
  	（4）右对角翻/
  		for (int j = 0; j < n; j++) {
  			for (int i = 0; i < j; j++) {
  				int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
  			}
  		}
  	三种旋转（顺时针）：
  	（A） 90度  ===  （1）+（3）
  	（B）180度  ===  （1）+（2）
  	（C）270度  ===  （2）+（3）
  	*/
    public void rotate_3(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("====================");
    }


    /**
     *【2-10】螺旋矩阵
     * {力扣-54}
     // 解法1：纯按顺序遍历
     */
    public List<Integer> spiralOrder_1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (null == matrix || matrix.length == 0) return Collections.emptyList();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int count = matrix.length * matrix[0].length;
        while (count > 0) {
            for (int i = left; i <= right && count > 0; i++) {
                result.add(matrix[top][i]);
                count--;
            }
            top++;
            for (int i = top; i <= bottom && count > 0; i++) {
                result.add(matrix[i][right]);
                count--;
            }
            right--;
            for (int i = right; i >= left && count > 0; i--) {
                result.add(matrix[bottom][i]);
                count--;
            }
            bottom--;
            for (int i = bottom; i >= top && count > 0; i--) {
                result.add(matrix[i][left]);
                count--;
            }
            left++;

        }

        return result;
    }

    /**
     *【2-10】螺旋矩阵
     * {力扣-54}
     * 解法二：
     */



    /**
     *【2-11】搜索二维矩阵ii
     * {力扣-240}
     * 解法一：根据王争思路，自己实现的。非常好的算法！
     根据，行升序、列升序两个规则：
     从右上角元素开始遍历，
     小于目标值，淘汰该行；
     大于目标值，淘汰该列。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int searchCount = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            searchCount++;
            if (matrix[i][j] == target) {
                System.out.println(searchCount);
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
                continue;
            }
            if (matrix[i][j] < target) {
                i++;
                continue;
            }
        }

        System.out.println("本次搜索共计遍历 " + searchCount + " 次");
        return false;
    }

    /**
     *【2-11】搜索二维矩阵ii
     * {力扣-240}
     // 解法2：暴力循环数组。。。
     */

    /**
     *【2-11】搜索二维矩阵ii
     * {力扣-240}
     // 解法3：二分法搜索
     */

    /**
     *【2-11】搜索二维矩阵ii
     * {力扣-240}
     // 解法4：递归缩减搜索空间
     */

}
