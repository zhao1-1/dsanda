package datastructure;

import java.util.Arrays;

public class Solution1 {
    
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

    public int lengthOfLastWord_2(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

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


    public int strToInt(String str) {
        if (str.length() == 0) return 0;                    // “空字符串”快速通道

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

    // 这种也不行，如果长度大于long类型呢？（比如："9223372036854775808"）
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


    // 不可以用这种方法！
    public int strToInt_3(String str) {
        return Integer.valueOf(str).intValue();
    }

}
