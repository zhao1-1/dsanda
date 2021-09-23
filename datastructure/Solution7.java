package datastructure;

import java.util.Arrays;

/**
 * 07-二分查找
 */
public class Solution7 {

    /*
    二分查找题型套路：
    （1）查找区间永远是闭区间：
        [low, high]
    （2）循环条件永远是：
        while (low <= high) {}
    （3）返回值永远是：
        return middle;
        ** 不要是low或high **
    （4）low 和 high 的更新永远是：
        low = middle + 1;
        high = middle - 1;
    （5）特殊情况：
        + 对于 "low == high" ：
          必要的时候，在while内部补充退出条件（比如查找第一个/最后一个命中的值）；
        + 对于 "非确定性查找" ：
          使用<前后探测法>，来确定探测区间；
          先处理命中情况，再处理左右半部分查找的情况；
     */


    /**
     *【7-0.0】标准二分查找
     * {力扣-704}
     * 解法一：循环折半
     */
    public int search(int[] nums, int target) {
        // 如果数组是未排序的，需要预处理一下。
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] > target)
                high = middle - 1;
            else
                low = middle + 1;
        }
        return -1;
    }


    /**
     *【7-0.0】标准二分查找
     * {力扣-704}
     * 解法二：递归
     */
    public int search_2(int[] nums, int target) {
        return searchRecur(nums, 0, nums.length - 1, target);
    }
    private int searchRecur(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        int middle = (low + high) / 2;
        if (nums[middle] == target)
            return middle;
        else if (nums[middle] > target)
            return searchRecur(nums, low, middle - 1, target);
        else
            return searchRecur(nums,middle + 1, high, target);
    }




    /**
     *【7-0.1-1】查找第一个等于目标值的元素
     * {跟谁学21春招}
     */
    public int searchFirstTarget(int[] nums, int target) {
        // 快速通行
        if (target == nums[0]) return 0;
        if (target < nums[0] || target > nums[nums.length-1]) return -1;

        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            // 防止int越界的写法，(low + high) / 2 有发生int越界的可能
            middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                // 前面的判断条件是防止[middle-1]<0发生数组越界
                if (middle == 0 || nums[middle - 1] != target) return middle;
                high = middle - 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }



    /**
     *【7-0.1-2】查找最后一个等于目标值的元素
     */
    public int searchLastTarget(int[] nums, int target) {
        // 快速通行
        if (target == nums[nums.length-1]) return nums.length-1;
        if (target < nums[0] || target > nums[nums.length-1]) return -1;

        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                if (middle == nums.length - 1 || nums[middle + 1] != target) return middle;
                else low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }




    /**
     *【7-0.2-1】查找第一个大于等于target的元素
     */
    public int searchFirstGETarget(int[] nums , int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] >= target) {
                if (middle == 0 || nums[middle - 1] < target) return middle;
                else high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }


    /**
     *【7-0.2-2】查找第一个大于target的元素
     */
    public int searchFirstGTTarget(int[] nums , int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] > target) {
                if (middle == 0 || nums[middle - 1] <= target) return middle;
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }



    /**
     *【7-0.3-1】查找最后一个小于等于target的元素
     */
    public int searchLastLETarget(int[] nums , int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] <= target) {
                if (middle == nums.length - 1 || nums[middle + 1] > target) return middle;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     *【7-0.3-2】查找最后一个小于target的元素
     */
    public int searchLastLTarget(int[] nums , int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] < target) {
                if (middle == nums.length - 1 || nums[middle+1] >= target) return middle;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }


    /**
     *【7-0.4-1】循环有序数组中查找元素x（没有重复数据）
     */
    public int searchInCycleSortedArr(int[] cs_nums, int target) {
        int low = 0;
        int high = cs_nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (cs_nums[middle] == target) {
                return middle;
            } else if (cs_nums[low] < cs_nums[middle]) {
                if (target >= cs_nums[low] && target < cs_nums[middle]) high = middle - 1;
                else low = middle + 1;
            } else {
                if (target > cs_nums[middle] && target < cs_nums[high]) low = middle + 1;
                else high = middle - 1;
            }
        }
        return -1;
    }



    /**
     *【7-0.4-2】循环有序数组中查找最小的元素x所在位置（没有重复数据）
     */
    public int searchMinEleInCSA(int[] cs_nums) {
        int low = 0;
        int high = cs_nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (low == high) return middle;

            if ((middle != 0 && cs_nums[middle - 1] > cs_nums[middle]) || middle == 0 && cs_nums[middle] < cs_nums[high])
                return middle;
            else if (cs_nums[middle] > cs_nums[high])
                low = middle + 1;
            else
                high = middle - 1;
        }
        // 永远抵达不了此处
        return -1;
    }


    /**
     *【7-0.4-3】循环有序数组中查找最大的元素x所在位置（没有重复数据）
     */
    public int searchMaxEleInCSA(int[] cs_nums) {
        int low = 0;
        int high = cs_nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (low == high) return middle;

            if ((middle != cs_nums.length - 1 && cs_nums[middle + 1] < cs_nums[middle]) || (middle == cs_nums.length - 1 && cs_nums[middle] > cs_nums[low]))
                return middle;
            else if (cs_nums[middle] < cs_nums[low])
                high = middle - 1;
            else
                low = middle + 1;
        }
        // 异常
        return -1;
    }




    /**
     *【7-0.5】山峰数组中查找峰值元素所在位置
     */
    public int peakIndexInMountainArray(int[] nums) {
       int low = 0;
       int high = nums.length - 1;
       int middle;
       while (low <= high) {
           middle = low + (high - low) / 2;
           // 数组的两头必须单独考虑，否则[middle-1]、[middle+1]会越界！
           if (middle == 0)
               low = middle + 1;
           else if (middle == nums.length - 1)
               high = middle - 1;
           else if ((nums[middle] > nums[middle + 1]) && (nums[middle] > nums[middle - 1]))
               return middle;
           else if (nums[middle] < nums[middle + 1])
               low = middle + 1;
           else
               high = middle - 1;
       }
       // 异常
       return -1;
    }


    /**
     *【7-0.6】二分答案（x的平方根）
     */





    /**
     *【7-1】猜数字大小
     * {力扣-374}
     * 母题：【7-0.0】
     */
    // 别搞复杂了，注意n给的是数的范围，这就是一个最简单的二分查找，主要是读懂题！
    public int guessNumber(int n) {
        int low = 0;
        int high = n;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (guess(middle) == 0)
                return middle;
            else if (guess(middle) == 1)
                low = middle + 1;
            else
                high = middle - 1;
        }
        return -1;
    }
    private int guess(int num) {
        int BINGO = 1702766719;
        if (BINGO == num)
            return 0;
        else if (BINGO > num)
            return 1;
        else
            return -1;
    }




    /**
     *【7-2】寻找比目标字母大的最小字母
     * {力扣744}
     * 母题：【7-0.2-2】查找第一个大于target的元素
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (letters[middle] > target) {
                if (middle == 0 || letters[middle - 1] <= target) return letters[middle];
                high = middle - 1;
            } else {
//                if (middle == letters.length - 1) return letters[0];
//                if (middle != letters.length - 1 && letters[middle + 1] > target) return letters[middle + 1];
                low = middle + 1;
            }
        }
        // 如果不存在，则返回队首元素
        return letters[0];
    }



    /**
     *【7-3】搜索插入位置
     * {力扣-35}
     * 母题：【7-0.2-1】查找第一个大于等于target的元素
     * 解法一：套路
     */
    public int searchInsert(int[] nums, int target) {
        // 快速通行
        if (target <= nums[0]) return 0;
        if (target > nums[nums.length-1]) return nums.length;

        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] >= target) {
                if (middle == 0 || nums[middle-1] < target) return middle;
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return nums.length;
    }

    /**
     *【7-3】搜索插入位置
     * {力扣-35}
     * 母题：【7-0.2-1】查找第一个大于等于target的元素
     * 解法二：自己实现
     */
    public int searchInsert_2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high -low) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                if (middle != 0 && nums[middle - 1] < target) return middle;
//                if (middle == 0) return middle;
                high = middle - 1;
            } else {
//                if (middle == nums.length - 1) return middle + 1;
                low = middle + 1;
            }
        }
        if (target < nums[0]) return 0;
        else return nums.length;
    }


    /**
     *【7-4】在排序数组中查找元素的第一个和最后一个位置
     * {力扣-34}
     * 母题：【7-0.1-1】【7-0.1-2】
     * 解法一：直接二分查找两次
     * 时间复杂度：o(2 * log n)
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums == null || nums.length == 0) return result;

        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                if (middle == 0 || nums[middle - 1] != target) {
                    result[0] = middle;
                    break;
                }
                high = middle - 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                if (middle == nums.length - 1 || nums[middle + 1] != target) {
                    result[1] = middle;
                    break;
                }
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return result;
    }

    /**
     *【7-4】在排序数组中查找元素的第一个和最后一个位置
     * {力扣-34}
     * 解法二：左右小碎步探测法
     * 时间复杂度：o(logn)
       + 最坏时间复杂度退化为o(n)，比如[3,7,7,7,7,7,7,9]，target=7
     */
    public int[] searchRange_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};

        // 快速通行证，可以注释掉
        if (nums[0] == target && nums[nums.length-1] == target) return new int[]{0, nums.length-1};

        // 二分查找找到target
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;
        boolean findTarget = false;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                findTarget = true;
                break;
            }
            else if (nums[middle] > target) high = middle - 1;
            else low = middle + 1;
        }
        if (!findTarget) return new int[]{-1,-1};

        // 小碎步，左探索
        int i = middle;
        while (i >= 0 && nums[i] == target) i--;

        // 小碎步，右探索；
        int j = middle;
        while (j <= nums.length - 1 && nums[j] == target) j++;

        return new int[]{i+1,j-1};
    }


    /**
     *【7-5】稀疏数组搜索
     * {面金-10.05.}
     */
    public int findString(String[] words, String s) {
        int low = 0;
        int high = words.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (words[middle].equals(s))
                return middle;
            else if (words[middle].equals("")) {
                if (words[low].equals(s)) return low;
                low++;
            } else if (words[middle].compareTo(s) > 0)
                high = middle - 1;
            else
                low = middle + 1;
        }
        return -1;
    }


    /**
     *【7-6】搜索旋转排序数组
     * {力扣-33}
     * 母题：【7-0.4-1】循环有序数组中查找元素x（没有重复数据）
     */
    // 直接看母题即可，原题。


    /**
     *【7-7】寻找旋转排序数组的最小值
     * {力扣-153}
     * 母题：【7-0.4-2】循环有序数组中查找最小的元素x所在位置（没有重复数据）
     */
    // 直接看母题即可，原题。


    /**
     *【7-8】山脉数组的峰顶索引
     * {力扣-852} {剑指OfferII-069}
     * 母题：【7-0.5】山峰数组中查找峰值元素所在位置
     */
    // 直接看母题即可，原题。



    /**
     *【7-9】寻找峰值*
     * {力扣-162}
     */
//    public int findPeakElement(int[] nums) {
//
//    }




    /**
     *【7-10】有效的完全平方数
     * {力扣-367}
     * 母题：【7-0.6】二分答案（x的平方根）
     */
    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = num;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            long r = (long) middle * middle;
            long r1 = (long) (middle + 1) * (middle + 1);
            if (r == num) return true;
            else if (r < num) {
                if (r1 > num) return false;
                low = middle + 1;
            } else
                high = middle - 1;
        }
        return false;
    }




    /**
     *【7-11】x的整数平方根
     * {力扣-69}
     * 母题：【7-0.6】二分答案（x的平方根）
     */
    // 比母题简单
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int middle;
        int count = 0;
        while (low <= high) {
            count++;
            middle = low + (high - low) / 2;

            /*
            防止int越界
             int类型范围：-2^31 ~ 2^31-1
            long类型范围：-2^63 ~ 2^63-1
             */
            long r = (long) middle * middle;
            long r1 = (long) (middle + 1) * (middle + 1);

            if (r == x) {
                System.out.println("循环了：" + count + "次！");
                return middle;
            }
            else if (r < x) {
                if (r1 > x) {
                    System.out.println("循环了：" + count + "次！");
                    return middle;
                }
                low = middle + 1;
            } else
                high = middle - 1;
        }
        return -1;
    }



    /**
     *【7-12】搜索二维矩阵
     * {力扣-74}
     * 解法一：
     * 时间复杂度：o(log(m*n)) = o(log m + log n)
     * 空间复杂度：o(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;
        int middle;
        /*
        middle = n * i + j;
        i = middle / n;
        j = middle % n;
         */
        int middleValue;
        while (low <= high) {
            middle = low + (high - low) / 2;
            middleValue = matrix[middle / n][middle % n];
            if (middleValue == target)
                return true;
            else if (middleValue < target)
                low = middle + 1;
            else
                high = middle - 1;
        }
        return false;
    }


    /**
     *【7-12】搜索二维矩阵
     * {力扣-74}
     * 解法二：
     * （1）先二分查找第一列，找到最后一个小于等于target值的元素；【7-0.4】
     * （2）再二分查找该元素所在行。
     * 时间复杂度：o(log m + log n)
     * 空间复杂度：o(1)
     */
    public boolean searchMatrix_2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //（1）第一次二分查找，找到最后一个小于等于target值的元素所在的行号"i"
        int low1 = 0;
        int high1 = m - 1;
        int middle1;
        int i = -1;
        while (low1 <= high1) {
            middle1 = low1 + (high1 - low1) / 2;
            if (matrix[middle1][0] <= target) {
                if ((middle1 == m - 1) || (matrix[middle1+1][0] > target)) {
                    i = middle1;
                    break;
                }
                low1 = middle1 + 1;
            } else {
                high1 = middle1 - 1;
            }
        }
        // 快速判断：第一列所有的元素都没有小于或等于target，直接返回false
        if (i == -1) return false;

        //（2）再二分查找锁定的行
        // 快速判断：行首小于目标值，行尾大于目标值，直接返回false
        if (matrix[i][0] > target || matrix[i][n-1] < target) return false;
        int low2 = 0;
        int high2 = n - 1;
        int middle2;
        while (low2 <= high2) {
            middle2 = low2 + (high2 - low2) / 2;
            if (matrix[i][middle2] == target)
                return true;
            else if (matrix[i][middle2] > target)
                high2 = middle2 - 1;
            else
                low2 = middle2 + 1;
        }
        return false;
    }


    /**
     *【7-12】搜索二维矩阵
     * {力扣-74}
     * 解法三：
     * （1）把二维数组全部扫描存到一个一维数组里；（性能损耗大头！）
     * （2）再对该一维数组进行二分查找；
     * 时间复杂度：o(m*n)
     * 空间复杂度：o(m*n)
     */

}
