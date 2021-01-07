package com.hplegend.algorithm.sort;

/**
 * @author hp.he
 * @date 2021/1/7 22:29
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] num = new int[]{5, 0, 1, 9, 10, -1};
        quickSourt(num, 0, num.length - 1);

        for (int ele : num) {
            System.out.println(ele);
        }
    }


    public static void quickSourt(int[] num, int begin, int end) {

        // 判断是否end > begin
        if (begin >= end) {
            return;
        }

        // partition

        // 选择哨兵,默认选择begin位置的
        int minPos = begin;
        for (int i = begin + 1; i <= end; ++i) {
            // 把比l小的，按顺序放在l的后边即可
            if (num[i] < num[begin]) {
                minPos = minPos + 1;
                int temp = num[minPos];
                num[minPos] = num[i];
                num[i] = temp;
            }
        }


        // 交换poivt
        int temp = num[minPos];
        num[minPos] = num[begin];
        num[begin] = temp;

        // 递归排序
        quickSourt(num, begin, minPos - 1);
        quickSourt(num, minPos + 1, end);
    }

    public static void quickSort2(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = array[begin];
        int left = begin + 1;
        int right = end;
        while (left <= right) {
            // 数据接口书上学习到的
            // 左边找比哨兵大的
            while (left <= right && array[left] < pivot) {
                left++;
            }
            // 右边找比哨兵小的
            while (left <= right && array[right] >= pivot) {
                right--;
            }

            if (left > right) {
                break;
            }

            // 交换
            // swap array[left] with array[right] while left <= right
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        /* swap the smaller with pivot */

        // 最后要把哨兵放到中心，这里要是right作为交换位置，因为终止的条件是left>right
        // left 一定是比right小的。因此这里right过了，所以，right就行了
        int temp = array[right];
        array[right] = array[begin];
        array[begin] = temp;

        quickSort2(array, begin, right - 1);
        quickSort2(array, right + 1, end);
    }

}
