package arithmetic;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: yusheng
 * @create-time 2019-10-23 10:07
 **/
public class SearchDemo {
    @Test
    public void test() {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100) + 1;
        }
        Arrays.sort(nums);
        binarySearch(nums, 3);
        for (int i = 1; i <= nums.length; i++) {
            System.out.print(nums[i - 1] + "\t");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    public int binarySearch(int[] nums, int keyValue) {
        int left = 0;
        int right = nums.length - 1;

        //循环查找，结束条件: key和数组的中位数比较完
        while (left <= right) {

            //中位数，向下取整
            int mid = (left + right) / 2;

            if (keyValue == nums[mid]) {
                //key和中位数相等，即找到了key，返回key的位置，结束循环
                return mid;
            } else {
                if (keyValue < nums[mid]) {
                    //key小于中位数，即key可能在当前中位数的左边数组，则在中位数左边继续循环查找过程
                    right = mid - 1;
                } else {
                    //key大于中位数，即key可能在当前中位数的右边边数组，继续循环查找过程
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
