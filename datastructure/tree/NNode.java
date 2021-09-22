package datastructure.tree;

import java.util.List;

public class NNode {
    int data;
    List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        this.data = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        this.data = _val;
        this.children = _children;
    }

}
