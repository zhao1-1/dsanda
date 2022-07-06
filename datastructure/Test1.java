package datastructure;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Solution1 sl1 = new Solution1();

        /**
         * 【1-1】IP地址解析
         * {拼多多}
         */
        System.out.println(1<<8);
        System.out.println(sl1.checkIp("255.255.0.0"));


        /**
         *【1-4】反转字符串
         * {力扣-344}
         */
//        System.out.println(sl1.reverseString(new char[]{'h','e','l','l','o'}));
//        System.out.println(sl1.reverseString(new char[]{'H','a','n','n','a','h'}));


        /**
         *【1-5】翻转单词顺序
         * {剑指58-i} {力扣-151}
         */
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
         *【1-6】验证回文字符串
         * {力扣125}
         */
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


        /**
         *【1-8】最后一个单词的长度
         * {力扣-58}
         */
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


        /**
         *【1-9】替换空格
         * {剑指Offer-5}
         */
//        System.out.println(sl1.replaceSpace("We are happy."));


        /**
         *【1-10】左旋转字符串
         * {剑指Offer-58-II}
         */
//        System.out.println(sl1.reverseLeftWords("BestWishes", 2));
//        System.out.println(sl1.reverseLeftWords("GoodBy", 6));
//        System.out.println(sl1.reverseLeftWords("teacher", -3));


        /**
         *【1-11】删除有序数组中的重复项
         * {力扣-26}
         */
//        System.out.println(sl1.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
//        System.out.println(sl1.removeDuplicates(new int[]{1,3,9}));
//        System.out.println(sl1.removeDuplicates(new int[]{0,0}));
//        System.out.println(sl1.removeDuplicates(new int[]{0}));
//        System.out.println(sl1.removeDuplicates(new int[]{}));
//        System.out.println(sl1.removeDuplicates(null));


        /**
         *【1-12】atoi*
         * {剑指Offer-67} {力扣-8}
         */
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
