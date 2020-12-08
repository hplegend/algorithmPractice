package com.hplegend.leetcode101;


import com.hplegend.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hp.he
 * @date 2020/12/8 16:44
 */
public class Leetcode101 {
    /**
     * //给定一个二叉树，检查它是否是镜像对称的。
     * //
     * //
     * //
     * // 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * //
     * //     1
     * //   / \
     * //  2   2
     * // / \ / \
     * //3  4 4  3
     * //
     * //
     * //
     * //
     * // 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * //
     * //     1
     * //   / \
     * //  2   2
     * //   \   \
     * //   3    3
     * //
     * //
     * //
     */

    public boolean isSymmetric(TreeNode root) {
        // 方法一： 先序遍历，然后判断回文
        // 时间复杂度： O(n)
        //  isSymmetric_one(root);

        // 方法二：右子树，右中左遍历； 左子树，左中右。
        // 时间复杂度： O(log(n))

        return isSymmetric_two(root);
        // 方法三：完全递归解法
        // 只需要判断左右子树，剩下的内容交给递归吧
        //isSymmetric_three(root);
    }


    private boolean isSymmetric_one(TreeNode root) {
        List<Integer> preFirstRet = new ArrayList<>();
        isSymmetric_one_recursive(root, preFirstRet);

        for (Integer ele : preFirstRet) {
            System.out.println(ele);
        }


        return true;
    }

    private void isSymmetric_one_recursive(TreeNode node, List<Integer> ret) {

        if (null == node) {
            ret.add(null);
            return;
        }

        // 先序遍历
        ret.add(node.getVal());
        isSymmetric_one_recursive(node.getLeft(), ret);
        isSymmetric_one_recursive(node.getRight(), ret);
    }

    private boolean isSymmetric_two(TreeNode root) {

        List<Integer> leftRet = new ArrayList<>();
        List<Integer> rightRet = new ArrayList<>();

        isSymmetric_two_left(root.getLeft(), leftRet);
        isSymmetric_two_right(root.getRight(), rightRet);


        if (leftRet.size() != rightRet.size()) {
            return false;
        }

        int len = leftRet.size();

        for (int i = 0; i < len; ++i) {

            if (leftRet.get(i) == null && rightRet.get(i) == null) {
                continue;
            }


            if (leftRet.get(i) != null && leftRet.get(i).equals(rightRet.get(i))) {
                continue;
            }

            if (rightRet.get(i) != null && rightRet.get(i).equals(leftRet.get(i))) {
                continue;
            }

            return false;
        }

        return true;
    }


    private void isSymmetric_two_left(TreeNode node, List<Integer> ret) {
        if (null == node) {
            ret.add(null);
            return;
        }

        // 先序遍历
        ret.add(node.getVal());
        isSymmetric_two_left(node.getRight(), ret);
        isSymmetric_two_left(node.getLeft(), ret);

    }


    private void isSymmetric_two_right(TreeNode node, List<Integer> ret) {
        if (null == node) {
            ret.add(null);
            return;
        }

        // 先序遍历
        ret.add(node.getVal());
        isSymmetric_two_right(node.getLeft(), ret);
        isSymmetric_two_right(node.getRight(), ret);

    }


    private boolean isSymmetric_three(TreeNode root) {

        if (null == root) {
            return true;
        }

        int left_value = null == root.getLeft() ? 0 : root.getLeft().getVal();
        int right_value = null == root.getRight() ? 0 : root.getRight().getVal();

        if (left_value == right_value) {
            boolean leaf_sub = isSymmetric_three((root.getLeft()));
            boolean right_sub = isSymmetric_three((root.getRight()));
            return leaf_sub && right_sub;
        } else {
            return false;
        }
    }

}
