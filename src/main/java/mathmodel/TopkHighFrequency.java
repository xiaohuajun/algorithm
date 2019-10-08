package mathmodel;

import java.util.*;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/21 11:16
 * @description 求一数组中的top k的高频元素
 * 1、使用hash表存储元素出现的次数<k,count>--考虑到hash表在不存在hash冲突的情况下查找时间是O(1)
 * 2、构建最小堆--最小优先队列-存储频率top k 的元素
 * 2.1 每次与堆顶元素比较，比堆顶大的替换堆顶
 */
public class TopkHighFrequency {


    /**
     * @param arr 需要处理的数据
     * @param k   前k个
     * @return 高频 top k
     */
    public static List<Integer> topKHighFrequency(int[] arr, int k) {
        int len = arr.length;
        if (len == 0) {
            throw new IllegalArgumentException("array is empty");
        }
        List<Integer> res = new ArrayList<>();
        //hash表存储每个元素出现的次数
        Map<Integer, Integer> countMap = new HashMap<>(16);
        for (int i : arr) {
            if (countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i) + 1);
            } else {
                countMap.put(i, 1);
            }
        }
        //构建最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.get(o1) - countMap.get(o2);
            }
        });
        for (Integer key : countMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (countMap.get(key) > countMap.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll());
        }
        return res;
    }


    public static void main(String[] args) {
        int k = 2;
        int[] arr = {1, 1, 1, 2, 2, 3, 10, 11, 1, 4, 5, 6, 7, 8, 4, 6, 3, 6, 8, 22};
        List<Integer> res = TopkHighFrequency.topKHighFrequency(arr, k);
        int ab = (int) (Math.random() * 900000) + 100000;
        System.out.println(res);
    }
}
