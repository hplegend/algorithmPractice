package com.hplegend.leetcode501;

import javax.swing.tree.TreeNode;

/**
 * @author hp.he
 * @date 2020/10/28 22:41
 */
public class Leetcode501 {


    // 暴力破解
    // 需要额外的空间记录
    // 遍历一遍，获取每一个数出现的次数
    // 遍历一遍每一个数的次数，获取出现次数最多的众数
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)

    // 优化空间复杂度
    // 在遍历的过程中，记录最大值每一次变换元素时，单前最大的值和次数，如果遇到相等的，则进入素组，如果遇到更大的，清空返回结果数组
    // 这样，基本上一次遍历，加常量个辅助即可。 做这个的前提是，树的前序遍历，树是有序的


    public int[] findMode(TreeNode root) {

        return null;
    }

}
