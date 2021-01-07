package com.hplegend.algorithm.sort;

/**
 * @author hp.he
 * @date 2021/1/7 22:26
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] num = new int[]{5, 0, 1, 9, 10, -1};
        selectionSort(num);

        for (int ele : num) {
            System.out.println(ele);
        }
    }


    public static void selectionSort(int[] num) {

        int len = num.length;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (num[i] > num[j]) {
                    int tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }
            }
        }
    }
}
