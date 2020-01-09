package mathmodel;

import java.util.*;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/20 13:54
 * @description 求连个数组的交集
 */
public class IntersectionArr {

    /**
     * 1、运用hash表来存储其中一个数组元素出现的次数，key--元素  value--次数
     * 2、再和另外一个数组比较，如果也存在的直接放入list,同时hash表中的value-1（表示找到了）
     *
     * @param a 数组 a
     * @param b 数组 b
     * @return 交集后的新的数组
     */
    public static int[] intersectionTwoArr(int[] a, int[] b) {
        List<Integer> integers = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>(16);
        for (int j : a) {
            Integer value = countMap.get(j);
            countMap.put(j, (value == null ? 0 : value) + 1);
        }
        for (int i : b) {

            if (countMap.containsKey(i) && countMap.get(i) != 0) {
                integers.add(i);
                countMap.put(i, countMap.get(i) - 1);
            }
        }
        int[] resArr = new int[integers.size()];
        int k = 0;
        for (Integer integer : integers) {
            resArr[k++] = integer;
        }
        return resArr;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 15, 10, 3, 1, 1};
        int[] b = {3, 4, 12, 10, 1, 2, 6};
        int[] resA = IntersectionArr.intersectionTwoArr(a, b);
        System.out.println(Arrays.toString(resA));
    }
}
