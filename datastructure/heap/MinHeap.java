package datastructure.heap;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/11/24 16:26
 */
public class MinHeap {

    private int[] heap;
    private int n;
    private int count;

    public MinHeap(int n_) {
        this.n = n_;
        this.heap = new int[this.n];
    }

}
