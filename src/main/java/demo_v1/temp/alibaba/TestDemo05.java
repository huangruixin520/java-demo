package demo_v1.temp.alibaba;

import java.util.Arrays;

/**
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一
 * </p>
 *
 * @author ruixin
 * @date 2020-08-26
 */
public class TestDemo05 {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] exchange = exchange(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] exchange(int[] nums) {

        //考点：双指针、快慢指针
        //定义指针变量
        //1 2 3 4
        //1 3 2 4
        int i = 0, j = nums.length - 1;
        while (i < j) {
            //指针i：搜索偶数，即遇到奇数跳过，i++
            while (i < j && nums[i] % 2 != 0) {
                i++;
            }
            //指针j：搜索奇数，即遇到偶数跳过，j++
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            //交换val
            int temp;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;

    }

}








