package datastructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/10/3 15:44
 * @description leetcode-1
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 */
public class FindTargetValue {

    /**
     * 算法：利用hash表来存储<k,v> k:满足条件的数组元素，v:满足条件的数组元素的的下标
     *
     * @param nums   数组元素
     * @param target 目标值
     * @return 数组中的元素之和等于目标值的元素下标
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> res = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int tem = target - nums[i];
            if (res.containsKey(tem)) {
                return new int[]{res.get(tem), i};
            }
            res.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15,18};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(a, target)));
    }
}
