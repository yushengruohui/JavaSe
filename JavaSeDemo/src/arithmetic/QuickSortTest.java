package arithmetic;

import org.junit.Test;

import java.util.Random;

/**
 * @author: yusheng
 * @create-date: 2019-10-13 10:12
 **/
public class QuickSortTest {
    @Test
    public void test() {
        //生成测试数据
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Random().nextInt(100);
        }

        //进行快排
        quickSort(nums, 0, nums.length - 1);

        //显示结果
        for (int i = 1; i <= nums.length; i++) {
            System.out.print(nums[i - 1] + "\t");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    private void quickSort(int[] nums, int left, int right) {

        //每次递归到这里都会有一个元素排到它的正确位置
        if (left < right) {
            //获取已比较，排好队的元素的索引
            int index = getIndex(nums, left, right);

            //递归调用，把索引左边序列排序
            quickSort(nums, left, index - 1);

            //递归调用，把索引右边序列排序
            quickSort(nums, index + 1, right);
        }
    }


    private int getIndex(int[] nums, int left, int right) {
        //将序列中的第一个元素设为索引，所以待会左右比较时，要先从右边开始比较
        int indexValue = nums[left];

        //一直循环到获取正确的索引的位置（索引排在正确的位置）
        while (left < right) {
            //索引和最右边未比较的元素比较,索引大，则交换位置，否则right向前划，继续比较
            while (left < right && indexValue <= nums[right]) {
                right--;
            }
            //把右边比索引小的元素换到索引暂时所在位置
            //swap(nums, left, right);不用直接交换
            nums[left] = nums[right];

            //索引和最左边未比较的元素比较,索引小，则交换位置，同时left向后划，继续比较
            while (left < right && indexValue >= nums[left]) {
                left++;
            }
            //把左边的元素换到索引暂时所在位置
            //swap(nums, left, right);不用直接交换
            nums[right] = nums[left];
        }
        //比较完后，left=right，最后的left所在位置的值应为indexValue
        nums[left] = indexValue;
        //索引所在位置
        return left;
    }

    public void swap(int[] nums, int x, int y) {
        nums[x] ^= nums[y];
        nums[y] ^= nums[x];
        nums[x] ^= nums[y];
    }

}
