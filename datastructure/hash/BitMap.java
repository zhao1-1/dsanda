package datastructure.hash;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/11/18 21:07
 */

/**
 *【自定义位图】
 */
public class BitMap {

    private char[] a;
    private int nBits;

    public BitMap(int nBits_) {
        this.nBits = nBits_;
        a = new char[this.nBits / 16 + 1];  // Java中char类型占据2 bytes，即16 bits
    }

    public void set(int k) {
        if (k > nBits) return;
        int charIdx = k / 16;
        int bitIdx  = k % 16;
        a[charIdx] |= (1 << bitIdx);
    }

    public boolean get(int k) {
        if (k > nBits) return false;
        int charIdx = k / 16;
        int bitIdx  = k % 16;
        return (a[charIdx] & (1 << bitIdx)) != 0;
    }

}
