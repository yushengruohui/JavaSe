package arithmetic;

import org.junit.Test;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-13 09:49
 **/
public class BubbleTest {
    @Test
    public void test() {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100) + 1;
        }
        bubble(nums);
        for (int i = 1; i <= nums.length; i++) {
            System.out.print(nums[i - 1] + "\t");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    public void bubble(int[] nums) {
        //暂存交换位置
        int exchangeIndex = 0;
        //记录最后一次交换的位置
        int pos = nums.length - 1;
        //结束的标签
        boolean endFlag;

        for (int i = 0; i < nums.length - 1; i++) {
            endFlag = true;
            for (int j = 0; j < pos; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] ^= nums[j + 1];
                    nums[j + 1] ^= nums[j];
                    nums[j] ^= nums[j + 1];
                    endFlag = false;
                    exchangeIndex = j;
                }
            }
            pos = exchangeIndex;
            //没有交换了，结束
            if (endFlag) {
                break;
            }
        }
    }
}
