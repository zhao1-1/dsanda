package datastructure;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Solution1 sl1 = new Solution1();

//        System.out.println(sl1.reverseString(new char[]{'h','e','l','l','o'}));
//        System.out.println(sl1.reverseString(new char[]{'H','a','n','n','a','h'}));

//        System.out.println(sl1.reverseWord("  hello world!  "));
//        System.out.println(sl1.reverseWord("a good   example"));
//        System.out.println(sl1.reverseWord("the sky is blue"));

//        System.out.println(sl1.testSplit("  "));
//        System.out.println(sl1.testSplit(" "));
//        System.out.println(sl1.testSplit("a b"));
//        System.out.println(sl1.testSplit("a  b"));
//        System.out.println(sl1.testSplit("a b "));
//        System.out.println(sl1.testSplit("a b  "));

        /**
         *【1-3】两数之和
         * {力扣-1}
         * 解法2：哈希表
         */
        System.out.println(Arrays.toString(sl1.twoSum_3(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(sl1.twoSum_3(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(sl1.twoSum_3(new int[]{3, 2, 6, 4}, 7)));
        System.out.println(Arrays.toString(sl1.twoSum_3(new int[]{3, 3}, 6)));

//        System.out.println(sl1.isPalindrome(" A man, ,a plan,  a canal: Panama... "));
//        System.out.println(sl1.isPalindrome("race a car"));
//        System.out.println(sl1.isPalindrome("OP"));
//        System.out.println(sl1.isPalindrome("0P"));
//        System.out.println(sl1.isPalindrome(" "));
//        System.out.println(sl1.isPalindrome("   "));
//        System.out.println(sl1.isPalindrome("  a    "));
//        System.out.println(sl1.isPalindrome("a"));
//        System.out.println(sl1.isPalindrome(", ."));
//        System.out.println(sl1.isPalindrome(",."));
//        System.out.println(sl1.isPalindrome(".,,"));

//        System.out.println(sl1.lengthOfLastWord("fly me   to   the moon"));
//        System.out.println(sl1.lengthOfLastWord("luffy is, still joyboy, ,"));
//        System.out.println(sl1.lengthOfLastWord("zHaObIn Wor!d"));
//        System.out.println(sl1.lengthOfLastWord("bes0t wi^shi"));

//        System.out.println(sl1.lengthOfLastWord_2("fly me   to   the moon"));
//        System.out.println(sl1.lengthOfLastWord_2("luffy is, still joyboy, ,"));
//        System.out.println(sl1.lengthOfLastWord_2("zHaObIn Wor!d"));
//        System.out.println(sl1.lengthOfLastWord_2("bes0t wi^shi"));
//        System.out.println(sl1.lengthOfLastWord_2("a"));
//        System.out.println(sl1.lengthOfLastWord_2("ab"));
//        System.out.println(sl1.lengthOfLastWord_2("  a "));
//        System.out.println(sl1.lengthOfLastWord_2("  ab c "));

//        System.out.println(sl1.replaceSpace("We are happy."));

//        System.out.println(sl1.reverseLeftWords("BestWishes", 2));
//        System.out.println(sl1.reverseLeftWords("GoodBy", 6));
//        System.out.println(sl1.reverseLeftWords("teacher", -3));

//        System.out.println(sl1.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
//        System.out.println(sl1.removeDuplicates(new int[]{1,3,9}));
//        System.out.println(sl1.removeDuplicates(new int[]{0,0}));
//        System.out.println(sl1.removeDuplicates(new int[]{0}));
//        System.out.println(sl1.removeDuplicates(new int[]{}));
//        System.out.println(sl1.removeDuplicates(null));

//        System.out.println(sl1.strToInt(""));
//        System.out.println(sl1.strToInt(" "));
//        System.out.println(sl1.strToInt("42"));
//        System.out.println(sl1.strToInt("+42"));
//        System.out.println(sl1.strToInt("    -42  "));
//        System.out.println(sl1.strToInt("  -42i"));
//        System.out.println(sl1.strToInt("  -42 35"));
//        System.out.println(sl1.strToInt("--42"));
//        System.out.println(sl1.strToInt("-o"));
//        System.out.println(sl1.strToInt("-0"));
//        System.out.println(sl1.strToInt("-4193 with words"));
//        System.out.println(sl1.strToInt("  words and 987"));
//        System.out.println(sl1.strToInt("-91283472332"));
//        System.out.println(sl1.strToInt("  -214748364A"));
//        System.out.println(sl1.strToInt("2147483647"));
//        System.out.println(sl1.strToInt("2147483648"));
//        System.out.println(sl1.strToInt("-2147483647"));
//        System.out.println(sl1.strToInt("-2147483648"));
//        System.out.println(sl1.strToInt("-2147483649"));
//        System.out.println(sl1.strToInt("9223372036854775808"));

//        System.out.println(sl1.strToInt_2(""));
//        System.out.println(sl1.strToInt_2(" "));
//        System.out.println(sl1.strToInt_2("42"));
//        System.out.println(sl1.strToInt_2("+42"));
//        System.out.println(sl1.strToInt_2("    -42  "));
//        System.out.println(sl1.strToInt_2("  -42i"));
//        System.out.println(sl1.strToInt_2("  -42 35"));
//        System.out.println(sl1.strToInt_2("--42"));
//        System.out.println(sl1.strToInt_2("-o"));
//        System.out.println(sl1.strToInt_2("-0"));
//        System.out.println(sl1.strToInt_2("-4193 with words"));
//        System.out.println(sl1.strToInt_2("  words and 987"));
//        System.out.println(sl1.strToInt_2("-91283472332"));
//        System.out.println(sl1.strToInt_2("  -214748364A"));
//        System.out.println(sl1.strToInt_2("2147483647"));
//        System.out.println(sl1.strToInt_2("2147483648"));
//        System.out.println(sl1.strToInt_2("-2147483647"));
//        System.out.println(sl1.strToInt_2("-2147483648"));
//        System.out.println(sl1.strToInt_2("-2147483649"));
//        System.out.println(sl1.strToInt_2("9223372036854775808"));

    }
}
