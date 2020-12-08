package com.hplegend.leetcode101;


import com.hplegend.leetcode101.TreeNode;

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


    private boolean isSymmetric_two(TreeNode root) {

        if (null == root) {
            return true;
        }


        List<Integer> leftRet = new ArrayList<>();
        List<Integer> rightRet = new ArrayList<>();

        isSymmetric_two_left(root.left, leftRet);
        isSymmetric_two_right(root.right, rightRet);


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
        ret.add(node.val);
        isSymmetric_two_left(node.right, ret);
        isSymmetric_two_left(node.left, ret);

    }


    private void isSymmetric_two_right(TreeNode node, List<Integer> ret) {
        if (null == node) {
            ret.add(null);
            return;
        }

        // 先序遍历
        ret.add(node.val);
        isSymmetric_two_right(node.left, ret);
        isSymmetric_two_right(node.right, ret);

    }

}
