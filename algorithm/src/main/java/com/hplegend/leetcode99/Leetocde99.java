package com.hplegend.leetcode99;

import com.hplegend.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hp.he
 * @date 2021/1/30 15:23
 */
public class Leetocde99 {

    /**
     * 前提：不存在相等的数，否则好像会有问题
     */
    public void recoverTree(TreeNode root) {

        List<Integer> inOrderNums = new ArrayList<>();

        // 中序遍历，找到交换的两个节点
        inOrderTransev(root, inOrderNums);

        // 恢复二叉树
        // 注意这里的恢复，可不是重新建立，而是在原来的基础上调整
        int[] revizeArr = findTwoRevise(inOrderNums);

        recover(root, 2, revizeArr[0], revizeArr[1]);
    }


    public void recover(TreeNode node, int count, int first, int second) {

        if (null == node) {
            return;
        }

        if (node.val == first || node.val == second) {
            int selectVal = node.val == first ? second : first;
            node.val = selectVal;
            count -= 1;
            if (count <= 0) {
                return;
            }
        }

        recover(node.left, count, first, second);
        recover(node.right, count, first, second);
    }


    public void inOrderTransev(TreeNode node, List<Integer> inOrderNum) {

        if (null == node) {
            return;
        }

        inOrderTransev(node.left, inOrderNum);
        inOrderNum.add(node.val);
        inOrderTransev(node.right, inOrderNum);
    }


    /**
     * 不一定是有两个，有可能是一个
     */
    public int[] findTwoRevise(List<Integer> inOrderNums) {

        int first = -1;
        int second = -1;

        int len = inOrderNums.size();

        for (int itr = 0; itr < len - 1; ++itr) {

            if (inOrderNums.get(itr + 1) < inOrderNums.get(itr)) {
                // 这里就是写代码的技巧了。
                // 在第二次的时候，用second存储。第一次用first存储
                second = inOrderNums.get(itr + 1);
                if (first == -1) {
                    first = inOrderNums.get(itr);
                } else {
                    break;
                }
            }

        }

        return new int[]{first, second};
    }


}
