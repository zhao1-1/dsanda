package datastructure;

public class Test2 {
    public static void main(String[] args) {
        Solution2 sl2 = new Solution2();

//        sl2.rotate_2(new int[][]{{1}});
//        sl2.rotate_2(new int[][]{{1,2},{3,4}});
//        sl2.rotate_2(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
//        sl2.rotate_2(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});

//        System.out.println(sl2.spiralOrder_1(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
//        System.out.println(sl2.spiralOrder_1(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));

        System.out.println(sl2.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        System.out.println(sl2.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
        System.out.println(sl2.searchMatrix(new int[][]{{-5}}, -10));

    }
}
