package com.hplegend.leetcode75;

/**
 * @author hp.he
 * @date 2020/2/10 17:12
 */
public class Leetcode75 {

    // O(n2)
    public void sortColors1(int[] nums) {


    }

    public void sortColors2(int[] nums) {


    }

    // 两个指针
    // 首指针指向末尾一个0，未指针指向末尾一个2
    public void sortColors3(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int zeroLastPos = -1;
        int twoStartPos = nums.length;

        for (int i = 0; i < twoStartPos; ++i) {
            if (nums[i] == 0) {
                zeroLastPos++;
                swap(nums, zeroLastPos, i);
            }

            if (nums[i] == 2) {
                twoStartPos--;

                // 如果last本来就是2，需要继续往前
                // 结束的位置就是当前的位置
                while (nums[twoStartPos] == 2) {
                    if (twoStartPos == i) {
                        break;
                    }
                    twoStartPos--;
                }
                swap(nums, twoStartPos, i);
                if (nums[i] == 0) {
                    zeroLastPos++;
                    swap(nums, zeroLastPos, i);
                }
            }
        }
    }


    public void swap(int[] nums, int swapPos, int curIndex) {
        int temp = nums[swapPos];
        nums[swapPos] = nums[curIndex];
        nums[curIndex] = temp;
    }


}
