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


    /**
     * 二进制转十进制
     */
    // binary -> 0 ~ 31 -> 低位 ~ 高位
    public int binary2decimal(int[] binary) {
        int decimal= 0;
        int mask = 1;   // 2 ^ 0 = 1
        for (int i = 0; i < binary.length; i++) {
            decimal += binary[i] * mask;
            mask <<= 1;
        }
        return decimal;
    }

    // binary -> 0 ~ 31 -> 高位 ~ 低位
    public int binary2decimalII(int[] binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length; i++) {
            decimal = (decimal << 1) + binary[i];
        }
        return decimal;
    }


    /**
     * 十进制转二进制
     */
    // binary -> 0 ~ 31 -> 低位 ~ 高位
    // 缺点：decimal值被破坏，且不可以处理负数
    public int[] decimal2binary(int decimal, int k) {
        int[] binary = new int[k];
        int i = 0;
        while (decimal != 0) {
            binary[i++] = (decimal & 1);
            decimal >>= 1;
        }
        return binary;
    }

    // binary -> 0 ~ 31 -> 高位 ~ 低位
    // 优点：decimal值保持不变，且可以处理负数（即有符号数）
    public int[] decimal2binaryII(int decimal, int k) {
        int[] binary = new int[k];
        int mask = 1;
        for (int i = k - 1; i >= 0; i++) {
            binary[i] = (decimal & mask);
            mask <<= 1;
        }
        return binary;
    }

}
