package com.hplegend.leetcode94;

import com.hplegend.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hp.he
 * @date 2021/1/22 18:08
 */
public class Leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {

        // 非递归，其实就是用栈记录遍历过程中没有访问的点，然后再继续访问
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
