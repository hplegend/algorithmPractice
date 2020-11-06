package com.hplegend.leetcode141;

import java.util.ArrayList;
import java.util.List;

public class MainTestClass {

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);

        for (int i = 0; i < arr.size(); ++i) {
            System.out.println(arr.get(i));
        }

        for (int ele : arr) {
            arr.add(4);
            System.out.println(ele);
        }

      arr.forEach(ele->{

      });


    }


}
