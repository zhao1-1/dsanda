package datastructure;

/**
 * @author bin2.zhao (D52B48 in ZhangMen)
 * @since 2021/8/31 14:38
 */
public class Test4 {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.push(6));
        System.out.println(arrayStack.push(7));
        System.out.println(arrayStack.push(13));
        System.out.println(arrayStack.push(666));
        arrayStack.printStack();
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());
        arrayStack.printStack();
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        arrayStack.printStack();


        LinkedListStack lls = new LinkedListStack();
        System.out.println(lls.pop());
        System.out.println(lls.peek());
        System.out.println(lls.push(6));
        System.out.println(lls.push(7));
        System.out.println(lls.push(13));
        System.out.println(lls.push(666));
        lls.printStack();
        System.out.println(lls.pop());
        System.out.println(lls.peek());
        lls.printStack();
        System.out.println(lls.pop());
        System.out.println(lls.pop());
        System.out.println(lls.pop());
        System.out.println(lls.pop());
        lls.printStack();


    }
}
