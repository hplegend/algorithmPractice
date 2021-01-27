package com.hplegend.leetcode124;

import com.hplegend.base.TreeNode;

/**
 * @author hp.he
 * @date 2021/1/26 13:25
 */
public class Leetcode124 {

    // 空间换时间，空间换算法复杂度
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }


    public int maxGain(TreeNode node) {

        if (null == node) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 至少能有这个路径值(为0，那就不去寻找)
        // 计算自己的路径，如果比原先的大，则记录一下
        int priceNewPahtGain = node.val + leftGain + rightGain;


        // 判断与sum
        if (priceNewPahtGain > maxSum) {
            maxSum = priceNewPahtGain;
        }

        // 返回最大的，给别人用
        return node.val + Math.max(leftGain, rightGain);

    }


}
