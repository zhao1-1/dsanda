package datastructure;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 01-纯编程题（数组、字符串）
 */
public class Solution1 {

    /**
     * 【1-1】IP地址解析
     * {拼多多}
     */
    public Boolean checkIp(String ip) {
        //（1）非空判断
        if (ip == null) return false;
        //（2）根据“.”分割
        String[] ipSegments = ip.split("\\.");
        //（3）分割段数判断
        if (ipSegments.length != 4) return false;
        //（4）每段合法性判断
        for (int i = 0; i < 4; i++) {
            if (!checkSegment(ipSegments[i])) return false;
        }
        return true;
    }

    private Boolean checkSegment(String ipSegment) {
        int n = ipSegment.length();
        int i = 0;
        //（4.1）跳过前导空格【“  123”】
        while (i < n && ipSegment.charAt(i) == ' ') {i++;}
        if (i == n) return false;	// 判断全是空格以及空字符串的情况
        //（4.2-A）判断前导'0'情况，此处做标记
        int markOfFirst = i;
        //（4.3）将字符串转化成数字
        int digit = 0;
        while (i < n && ipSegment.charAt(i) != ' ') {
            char c = ipSegment.charAt(i);
            if (c < '0' || c > '9') return false;	// 非数字字符情况
            digit = digit * 10 + (c - '0');
            if (digit > ((1 << 8) - 1)) return false;
            i++;
        }
        //（4.2-B）判断前导'0'情况
        if (ipSegment.charAt(markOfFirst) == '0' && digit != 0) return false;
        //（4.4）处理后置空格【“123 ”，“12 3”】
        while (i < n) {
            char c = ipSegment.charAt(i);
            if (c != ' ') return false;
            i++;
        }
        return true;
    }




    /**
     *【1-2】IP地址无效化
     * {力扣-1108}
      解法1：直接使用 String 类的 replace。
     */
    public String defangIpaddr(String address) {
        return address.replace(".", "[.]");
    }

    // 解法2.1：StringBuilder + insert()方法。
    public String defangIpAddr2_1(String addr) {
        StringBuilder sb = new StringBuilder(addr);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '.') {
                sb.insert(i+1, ']');
                sb.insert(i, '[');
                i += 3;
            }
        }
        return sb.toString();
    }

    // 解法2.2：Stringbuilder + append()方法。
    public String defangIpAddr2_2(String addr) {
        StringBuilder sb = new StringBuilder(addr);
        for (int i = 0; i < addr.length(); i++) {
            if (addr.charAt(i) == '.') {
                sb.append("[.]");
            }
            sb.append(addr.charAt(i));
        }
        return sb.toString();
    }

    // 解法3：字符串数组（高性能）
    private String defangIpAddr3(String addr) {
        char[] origin = addr.toCharArray();
        char[] result = new char[origin.length + 3 * 2];
        int k = 0;
        for (int i = 0; i < origin.length; i++) {
            if ('.' != origin[i]) {
                result[k++] = origin[i];
            } else {
                result[k++] = '[';
                result[k++] = '.';
                result[k++] = ']';
            }
        }
        return String.valueOf(result);	// 此处不能用result.toString()，此方法字符串数组和StringBuilder可不一样！
    }

    // 解法4：重写String类的replace方法。（实现复杂，见JDK源码）
    // String.replace(CharSequence target, CharSequence replacement)



    /**
     *【1-3】两数之和
     * {力扣-1}
     * 解法1：暴力枚举
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     *【1-3】两数之和
     * {力扣-1}
     * 解法2：哈希表
     */
    // 见【8-1】
    public int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> pools = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (pools.containsKey(target - nums[i])) {
                return new int[]{pools.get(target-nums[i]), i};
            }
            pools.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     *【1-3】两数之和
     * {力扣-1}
     * 解法3：双指针
     */
    // 见【15-1-3】


    /**
     *【1-4】反转字符串
     * {力扣-344}
     * 解法：双指针，见【15-1-1】
     */
    public char[] reverseString(char[] noodles) {
        int left = 0;
        int right = noodles.length - 1;
        char tempC;
        while (left < right) {
            tempC = noodles[left];
            noodles[left++] = noodles[right];
            noodles[right--] = tempC;
        }
        return noodles;
    }


    /**
     *【1-5】翻转单词顺序
     * {剑指58-i} {力扣-151}
     */
    public String reverseWord(String words) {
        String[] temps = words.trim().split("\\ ");
        int left = 0;
        int right = temps.length - 1;
        String swapString;
        while (left < right) {
            swapString = temps[left];
            temps[left++] = temps[right];
            temps[right--] = swapString;
        }
        StringBuffer stringPools = new StringBuffer();
        for (String temp : temps) {
            if (!temp.isEmpty()) {
                stringPools.append(temp);
                stringPools.append(" ");
            }
        }
        return stringPools.toString().trim();
    }


    public int testSplit(String x) {
        String[] xxx = x.split(" ");
        return xxx.length;
    }


    /**
     *【1-6】验证回文字符串
     * {力扣125}
     */
    public Boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        char[] result = s.trim().toLowerCase().toCharArray();
        if (result.length <= 1) return true;
        int left = 0;
        int right = result.length - 1;
        while (left < right) {
            while (!(result[left] >= '0' && result[left] <= '9') && !(result[left] >= 'a' && result[left] <= 'z')) {
                if (left < right) {
                    left++;
                } else {
                    break;
                }
            }
            while (!(result[right] >= '0' && result[right] <= '9') && !(result[right] >= 'a' && result[right] <= 'z')) {
                if (left < right) {
                    right--;
                } else {
                    break;
                }
            }
            if (result[left++] != result[right--]) return false;
        }
        return true;
    }


    /**
     *【1-7】验证回文数
     * {力扣-9}
     */
    public Boolean isPalindromeNum(int x) {
        if (x < 0) return false;
        int curr = 0;
        int temp = x;
        while (temp != 0) {
            curr = curr * 10 + temp % 10;
            temp /= 10;
        }
        return x == curr;
    }


    /**
     *【1-8】最后一个单词的长度
     * {力扣-58}
     * 解法二：自己的思路，性能差
     */
    public int lengthOfLastWord(String s) {
        String[] sss = s.trim().split(" ");
        for (int i = sss.length - 1; i >= 0; i--) {
            int k = 0;
            while (k < sss[i].length() && Character.isLetter(sss[i].charAt(k))) {
                k++;
            }
            if (k == sss[i].length()) return sss[i].length();
        }
        return 0;
    }

    /**
     *【1-8】最后一个单词的长度
     * {力扣-58}
     * 解法二：官方答案
     */
    public int lengthOfLastWord_2(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }


    /**
     *【1-9】替换空格
     * {剑指Offer-5}
     */
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }


    /**
     *【1-10】左旋转字符串
     * {剑指Offer-58-II}
     * 解法一：自己的思路，性能差
     */
    public String reverseLeftWords (String s, int n) throws Exception {
        if (n == 0 || n >= s.length())      return s;
        if (n < 0)                          throw new Exception("n must >= 0");
        char[] ss = s.toCharArray();
        char[] ssNew = new char[ss.length];
        int index = 0;
        for (int i = n; i < ss.length; i++) {
            ssNew[index++] = ss[i];
        }
        for (int i = 0; i < n; i++) {
            ssNew[index++] = ss[i];
        }
        return String.valueOf(ssNew);
    }

    /**
     *【1-10】左旋转字符串
     * {剑指Offer-58-II}
     * 解法二：官方
     */
    public String reverseLeftWords_2(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    /**
     *【1-10】左旋转字符串
     * {剑指Offer-58-II}
     * 解法三：官方，性能好
     */
    public String reverseLeftWords_3(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    /**
     *【1-10】左旋转字符串
     * {剑指Offer-58-II}
     * 解法四：
     * 相当于k次左旋一位，只需要申请一个存储空间
     * 时间复杂度：o(k*n)
     * 空间复杂度：o(1)
     */
//    public String reverseLeftWords_4(String s, int n) {
//
//    }


    /**
     *【1-11】删除有序数组中的重复项
     * {力扣-26}
     * 解法一：自己实现
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int left = 0;
        int right = 1;
        while (right < n) {
            while (right < n && nums[left] == nums[right]) right++;
            if (right >= n) break;
            nums[++left] = nums[right++];
        }
        nums = Arrays.copyOfRange(nums, 0, left+1);
//        System.out.println(Arrays.toString(nums));
        return nums.length;
    }

    /**
     *【1-11】删除有序数组中的重复项
     * {力扣-26}
     * 解法二：推荐
     */
    public int removeDuplicates_2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                if(q - p > 1){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }



    /**
     *【1-12】atoi*
     * {剑指Offer-67} {力扣-8}
     * 解法一：比较Integer.MAX_VALUE / 10
     */
    public int strToInt(String str) {
        if (str.length() == 0) return 0;                    // “空字符串”快速通道

        /*
        功能：去除前面的空格
        注意：这种while一定要在前面判断j<str.length()，否则非常容易溢出！
        解决：用下面这种替换写法也很完美！
        while(str.charAt(i) == ' ')
            if(++i == length) return 0;
        */
        int j = 0;
        while (j < str.length() && ' ' == str.charAt(j)) j++;
        if (j == str.length()) return 0;                    // “全是空格”快速通道

        /*
        Integer.MAXVALUE ==  2147483647
        Integer.MINVALUE == -2147483648
         */
        int boundary = Integer.MAX_VALUE / 10;
        int result = 0;
        Boolean isNegative = false;

        if ('-' == str.charAt(j)) isNegative = true;
        if ('-' == str.charAt(j) || '+' == str.charAt(j)) j++;
        for (int i = j; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
            if (result > boundary || (result == boundary && str.charAt(i) > '7'))
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            result = result * 10 + (str.charAt(i) - '0');
        }
        return isNegative ? -1 * result : result;
    }

    /**
     *【1-12】atoi*
     * {剑指Offer-67} {力扣-8}
     * 解法二：中间状态用long表示
     * 这种也不行，如果长度大于long类型呢？（比如："9223372036854775808"）
     */
    public int strToInt_2(String str) {
        if (str.length() == 0) return 0;                    // “空字符串”快速通道

        int j = 0;
        while (j < str.length() && ' ' == str.charAt(j)) j++;
        if (j == str.length()) return 0;                    // “全是空格”快速通道

        long result = 0;
        Boolean isNegative = false;

        if ('-' == str.charAt(j)) isNegative = true;
        if ('-' == str.charAt(j) || '+' == str.charAt(j)) j++;
        for (int i = j; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
            result = result * 10 + (str.charAt(i) - '0');
        }
        if (result > Integer.MAX_VALUE)
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return isNegative ? -1 * (int)result : (int)result;
    }


    /**
     *【1-12】atoi*
     * {剑指Offer-67} {力扣-8}
     * 不可以用这种方法！
     */
    public int strToInt_3(String str) {
        return Integer.valueOf(str).intValue();
    }

}
