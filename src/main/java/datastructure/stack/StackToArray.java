package datastructure.stack;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/21 21:17
 * @description 使用数组来实现栈
 * 栈的使用场景
 * 1、字符串、单词逆序
 * 2、分隔符匹配
 */
public class StackToArray<T> {


    /**
     * 初始化栈的深度
     */
    private static final int INIT_SIZE = 10;

    /**
     * 数组
     */
    private T[] data;
    /**
     * 栈顶指针-从-1开始计数
     */
    private int top;

    /**
     * 栈的深度
     */
    private int size;

    /**
     * 初始化栈
     *
     * @param size 初始化的大小
     */
    public StackToArray(int size) {
        this.size = size;
        data = (T[]) new Object[size];
        this.top = -1;
    }

    /**
     * 默认创建初始化大小的栈
     */
    public StackToArray() {
        this.size = INIT_SIZE;
        data = (T[]) new Object[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    /**
     * 入栈
     *
     * @param value 入栈元素
     */
    public void push(T value) {
        if (isFull()) {
            throw new IllegalArgumentException("stack is full");
        }
        top++;
        data[top] = value;
    }

    /**
     * 取栈顶元素
     *
     * @return 栈顶元素
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("stack is null that have no a value");
        }
        //取栈顶元素
        T v = data[top];
        //并删除栈顶元素
        data[top] = null;
        top--;
        return v;
    }

    public T peek() {
        return data[top];
    }

    public static void main(String[] args) {
        StackToArray<Integer> st = new StackToArray<>(4);
        st.push(4);
        st.push(5);
        st.push(8);
        st.push(3);
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
        System.out.println("==test=");
    }


}
