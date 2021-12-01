package datastructure.tree;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/12/1 19:49
 */
public class Trie {

    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndChar = false;
        public TrieNode(char data_) {this.data = data_;}
    }

    private TrieNode root = new TrieNode('/');

    /**
     * Trie树中插入字符串
     */
    public void insert(char[] text) {
        TrieNode p = this.root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) p.children[index] = new TrieNode(text[i]);
            p = p.children[index];
        }
        p.isEndChar = true;
    }


    /**
     * 应用一：字符串查找
     案例：【根据名字查找用户】，有1万多个用户，频繁根据名字查询用户是否出现其中？
     替代方案：红黑树、散列表；
     */
    public boolean find(char[] target) {
        TrieNode p = this.root;
        for (int i = 0; i < target.length; i++) {
            int index = target[i] - 'a';
            if (p.children[index] == null) return false;    // 不存在target
            p = p.children[index];
        }
        if (p.isEndChar == false)
            return false;                                   // 不能完全匹配，只达到前缀匹配
        else
            return true;
    }


    /**
     * 应用二：多模式串匹配
     案例：【敏感词过滤系统】
     替代方案：AC自动机
     */


    /**
     * 应用三：前缀匹配
     案例：【自动提示功能】，应用于搜索引擎、输入法、浏览器等；
     替代方案：无
     */


}
