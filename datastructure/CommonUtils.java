package datastructure;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/11/3 18:58
 */
public class CommonUtils {

    static final int INT_BITS = 32;

    /**
     * 二维数组的打印
     */
    public static void print2DArr(int[][] x) {
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
       binary -> 0 ~ 31 -> 高位 ~ 低位
       因为计算机底层就是按照从高到底存储bit的
     */
    public static int binary2decimal(String binaryStr) {
        int[] binary = new int[binaryStr.length()];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = binaryStr.charAt(i) - '0';
        }

        int decimal= 0;
        int mask = 1;   // 2 ^ 0 = 1
        for (int i = binary.length - 1; i >= 0; i--) {
            decimal += binary[i] * mask;
            mask <<= 1;
        }
        return decimal;
    }
    public static int binary2decimal(int[] binary) {
        int decimal= 0;
        int mask = 1;   // 2 ^ 0 = 1
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i] == 1) decimal += mask;
            mask <<= 1;
        }
        return decimal;
    }

    public static int binary2decimalII(String binaryStr) {
        int[] binary = new int[binaryStr.length()];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = binaryStr.charAt(i) - '0';
        }

        int decimal = 0;
        for (int i = 0; i < binary.length; i++) {
            decimal = (decimal << 1) + binary[i];
        }
        return decimal;
    }
    public static int binary2decimalII(int[] binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length; i++) {
            decimal = (decimal << 1) + binary[i];
        }
        return decimal;
    }


    /**
     * 十进制转二进制
       binary -> 0 ~ 31 -> 高位 ~ 低位
     */
    // 缺点：decimal值被破坏，只有Java能处理负数
    public static int[] decimal2binary(int decimal) {
        int[] binary = new int[INT_BITS];
        int i = binary.length - 1;
        while (decimal != 0) {
            binary[i--] = (decimal & 1);
            decimal >>>= 1;     // 若想处理负数，此处必须逻辑右移（Java特有），如果算数右移，则此方法无法处理负数
        }

        return binary;
    }

    // 优点：decimal值保持不变，且任何语言都可以处理负数（即有符号数）
    public static int[] decimal2binaryII(int decimal) {
        int[] binary = new int[INT_BITS];
        int mask = 1;
        for (int i = INT_BITS - 1; i >= 0; i--) {
            if ((decimal & mask) != 0) binary[i] = 1;
            mask <<= 1;
        }

        return binary;
    }



    /**
     * 交换数组中俩元素
     */
    public static void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }



    /**
     * 输入数组生成链表
     */
    public static ListNode buildList(int[] inputArray) {
        if (null == inputArray || inputArray.length ==0) return null;
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i = 0; i < inputArray.length; i++) {
            p.val = inputArray[i];
            if (i != inputArray.length - 1) {
                p.next = new ListNode();
                p = p.next;
            }
        }
        p.next = null;
        return head;
    }



    /**
     * 打印输出链表
     */
    public static void printList(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null) {
            System.out.print(p.next.val + " -> ");
            p = p.next;
        }
        System.out.print("NULL");
        System.out.println("");
        System.out.println("------------");
    }

    /**
     * 获取给定时间的周数（该周数范围）
     */
    public static String getWeekNum(Date date) {
        // 参数校验
        if (Objects.isNull(date)) {
            return "param is null";
        }

        /*
        定义输出结果（如果年份为当前年份，则不显示）：
        + 第51周（12/13 - 12/19）
        + 2020年 第50周（12/06 - 12/12）
         */
        StringBuilder result = new StringBuilder();

        // 时间设置
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
        Calendar currCalendar = Calendar.getInstance();
        currCalendar.setTime(new Date());
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(date);
        targetCalendar.setFirstDayOfWeek(Calendar.MONDAY);

        // 获取目标年数及当前年数
        Integer targetYear = targetCalendar.get(Calendar.YEAR);
        Integer currYear = currCalendar.get(Calendar.YEAR);
        if(null != targetYear && null != currYear && !targetYear.equals(currYear)) {
            result.append(targetYear.toString() + "年 ");
        }

        // 获取目标时间的周数
        Integer weekNum = targetCalendar.get(Calendar.WEEK_OF_YEAR);
        if (null != weekNum) {
            result.append("第" + weekNum.toString() + "周");
        }

        // 获取目标周数的时间范围
        result.append("（");
        targetCalendar.set(Calendar.DAY_OF_WEEK, targetCalendar.getFirstDayOfWeek());
        result.append(sdf.format(targetCalendar.getTime()) + " - ");
        targetCalendar.add(Calendar.DAY_OF_WEEK, 6);
        result.append(sdf.format(targetCalendar.getTime()) + "）");

        // 返回目标日期格式
        return result.toString();
    }

}
