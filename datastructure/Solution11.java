package datastructure;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/12/1 19:13
 */

/**
 * 字符串匹配算法、Trie树
 */
public class Solution11 {

    /*

    字符串匹配算法：

    1. 单模式串匹配算法（在主串中查找一个模式串）        "dsajflkaghoizhaobinkwxxljf" 查找 "zhaobin"
    （1）BF算法（暴力匹配算法、朴素字符串匹配算法）      "dsajflkaghoizhaobinkwxxljf" 查找 "zhaobin", "dsa", "wxx"
    （2）RK算法（Rabin-Karp算法）
        - 利用Hash算法；
    （3）BM算法
    （4）KMP算法

    2. 多模式串匹配算法（在主串中查找多个模式串）
    （5）Trie树
        - 适合前缀匹配；
        - 应用：见Trie树实现代码；
    （6）AC自动机
        - 一般多模式串匹配首选AC自动机，性能更高！
        - Trie树和AC自动机，相当于BF和KMP的关系；

     */


    /**
     *（1）BF算法
     最好时间复杂度：o(a.length)
     最坏时间复杂度：o(a.length * b.length)
     */
    int bf(char[] a, char[] b) {
        // 设定：a长度大于b
        int aN = a.length;
        int bN = b.length;
        for (int i = 0; i < aN - bN + 1; i++) {
            int curr = 0;
            while (curr < bN) {
                if (a[i + curr] != b[curr]) break;
                curr++;
            }
            if (curr == bN) return i;
        }
        return -1;
    }


    /**
     *（2）RK算法
     时间复杂度：o(n)
     */
    /*
    通过hash算法对主串的n-m+1个子串分别求hash值，然后逐个与模式串的哈希值比较。
    如果某个子串的哈希值与模式串的哈希值相等，那么就说明这个子串和模式串可能匹配了，可以进一步详细比较；
    本质其实就是通过hash值做了筛选。
     */


    /**
     *（3）BM算法
     *（4）KMP算法
     */
    /*
    模式串和主串的匹配过程，可以看做是，模式串在主串中不停的往后滑动。
    BF算法和RK算法做法：当遇到不匹配的字符时，将模式串往后滑动一位，然后从模式串的第一个字符开始重新匹配；
    BM算法和KMP算法核心思想是：
    寻找某种规律，借助这种规律，当模式串和主串中的某个字符不匹配时，能够跳过一些肯定不会匹配的情况，将模式串往后多滑动几位。
    最好情况时间复杂度：o(n/m)
    最坏情况时间复杂度：o(n)，且n前面系数很小
     */



    /**
     *【11-1】实现Trie（前缀树）
     *「力扣-208」
     */
    // 见tree.Trie类

}
