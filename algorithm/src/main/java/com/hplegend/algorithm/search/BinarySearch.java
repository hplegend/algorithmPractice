package com.hplegend.algorithm.search;

/**
 * @author hp.he
 * @date 2021/1/7 23:14
 */
public class BinarySearch {

    public static void main(String[] args) {



    }


    // 小于等于的最小索引
    /*
     * nums[index] >= target, min(index)
     */
    public static int lowerBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] < target) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb + 1;
    }

    // 大于等于的最大索引
    /*
     * nums[index] <= target, max(index)
     */
    public static int upperBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] > target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }

        return ub - 1;
    }


    // 寻找第一次或者最后一次出现

    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0, end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                start = mid;
            } else if (array[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (array[start] == target) {
            return start;
        }
        if (array[end] == target) {
            return end;
        }
        return -1;
    }

}
