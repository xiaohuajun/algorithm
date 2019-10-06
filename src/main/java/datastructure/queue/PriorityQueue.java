package datastructure.queue;

import java.util.Arrays;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/15 15:57
 * @description 实现一个优先队列（堆）
 * 插入和删除还是遵循队列的规则
 * 1、插入元素是从队列的尾部插入，然后从叶子结点进行上浮调整
 * 2、删除元素是从队列的头部删除，然后把尾部的节点放到根节点，进行向下调整
 */
public class PriorityQueue {

    /**
     * 初始化队列的大小
     */
    private static final int INITIAL_SIZE = 8;
    /**
     * 使用数组来实现
     */
    private int[] array;

    /**
     * 当前队列的大小
     */
    private int currSize;


    public PriorityQueue() {
        this.array = new int[INITIAL_SIZE];
    }

    public PriorityQueue(int size) {
        this.array = new int[size];
    }

    /**
     * 插入数据
     * 上浮
     *
     * @param value 需要插入的数据
     */
    public void enQueue(int value) {
        //首先判断的当前队列的大小
        if (currSize >= this.array.length) {
            reSize();
        }
        array[currSize++] = value;
        //上浮调整
        upAdjust();
    }

    /**
     * 删除堆顶元素：
     * <p>
     * 堆顶和堆尾互换，尺寸size - 1 ,删除队尾
     */
    public int deQueue() {
        //堆顶
        int res = array[0];
        //堆尾和堆首互换
        array[0] = array[currSize - 1];
        currSize--;
        newArray();
        downAdjust();
        return res;
    }

    private void deleteVal(int v) {
        int i = 0;
        for (int j = 0; j < currSize; j++) {
            if (array[j] != v) {
                array[i] = array[j];
                i++;
            }
        }
        int[] res = new int[i];
        System.arraycopy(array, 0, res, 0, i);
        array = res;
    }


    /**
     * 上浮操作：从叶子结点开始上浮
     * 上浮都是改变父节点的索引
     * 最小优先队列的上浮操作
     */
    private void upAdjust() {
        //叶子（孩子）节点的索引
        int childIndex = currSize - 1;
        //父节点的索引
        int parentIndex = (childIndex - 1) / 2;
        //插入的数据先保存叶子结点（堆的尾部）--最后赋值用
        while (childIndex > 0 && array[childIndex] < array[parentIndex]) {
            int temp = array[parentIndex];
            //子节点到父节点
            array[parentIndex] = array[childIndex];
            //子节点到父节点
            array[childIndex] = temp;
            //改变子节点的索引
            childIndex = parentIndex;
            //计算新的父节点
            parentIndex = (childIndex - 1) / 2;
        }
    }

    /**
     * 下沉操作
     * 从堆顶往下沉
     * 都是改变子节点的索引
     */
    private void downAdjust() {
        int parentIndex = 0;
        int len = currSize - 1;
        //右子节点的索引
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < len) {
            //在左右子节点中找最小的
            if (childIndex + 1 < len && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            //父节点比最小的子节点都还要小，那就不需要下沉操作了
            if (array[parentIndex] <= array[childIndex]) {
                break;
            }
            //父节点
            int temp = array[parentIndex];
            //子节点到父节点
            array[parentIndex] = array[childIndex];
            //父节点到子节点
            array[childIndex] = temp;
            //父节点的索引改为子节点的索引
            parentIndex = childIndex;
            //重新计算子节点的索引
            childIndex = 2 * parentIndex + 1;
        }
    }


    private void newArray() {
        int[] resArray = new int[currSize];
        System.arraycopy(array, 0, resArray, 0, currSize);
        array = resArray;
    }


    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }

    /**
     * 对队列进行扩容
     */
    private void reSize() {
        int newSize = this.currSize * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(6);
        priorityQueue.enQueue(9);
        priorityQueue.enQueue(8);
        System.out.println("删除之前：" + priorityQueue.toString());
        System.out.println("堆顶元素：" + priorityQueue.deQueue());
        System.out.println("删除之前：" + priorityQueue.toString());
    }


}
