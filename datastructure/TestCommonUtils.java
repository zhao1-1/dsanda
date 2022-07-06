package datastructure;

import com.sun.deploy.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/12/14 19:57
 */
public class TestCommonUtils {
    public static void main(String[] args) {

        /**
         * 获取给定时间的周数（该周数范围）
         */
        System.out.println(CommonUtils.getWeekNum(new Date()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date param1 = sdf.parse("2021/09/01");
            Date param2 = sdf.parse("2020/09/01");
            // Date类型的大小比较
            System.out.println(param1.compareTo(param2));
            // 当前年就是今年
            System.out.println(CommonUtils.getWeekNum(param1));
            // 当前年不是今年
            System.out.println(CommonUtils.getWeekNum(param2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
