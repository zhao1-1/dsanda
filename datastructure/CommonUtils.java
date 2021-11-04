package datastructure;

import java.util.Arrays;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/11/3 18:58
 */
public class CommonUtils {

    /**
     * 二维数组的打印
     */
    public void print2DArr(int[][] x) {
        System.out.print("[");
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(Arrays.toString(x[i]) + ", ");
        }
        System.out.print(Arrays.toString(x[x.length - 1]));
        System.out.print("]");
        System.out.println("");
    }

}
