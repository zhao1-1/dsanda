package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    
    // 解法2：原地旋转
    public void rotate_2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
            }
        }
    }

    // 解法3：反转代替旋转（先水平翻转，再对角线翻转）
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

    // 解法1：纯按顺序遍历
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

    public boolean searchMatrix(int[][] matrix, int target) {

    }

}
