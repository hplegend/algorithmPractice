package com.hplegend.algorithm.sort;

/**
 * @author hp.he
 * @date 2021/1/7 22:13
 */
public class BubboleSort {

    public static void main(String[] args) {
        int[] num = new int[]{5, 0, 1, 9, 10, -1};
        bubboSort(num);

        for (int ele : num){
            System.out.println(ele);
        }



    }


    public static void bubboSort(int[] num) {

        int len = num.length;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len - i - 1; ++j) {
                if (num[j] > num[j + 1]) {
                    int tmp = num[j + 1];
                    num[j + 1] = num[j];
                    num[j] = tmp;
                }

            }
        }


    }


}
