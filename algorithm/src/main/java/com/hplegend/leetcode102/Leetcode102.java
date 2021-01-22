package com.hplegend.leetcode102;

import com.hplegend.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hp.he
 * @date 2021/1/22 19:28
 */
public class Leetcode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 所有的问题，不是一定要百分百最优，可以先用最笨的方法，然后依次去优化。
        // 不管是空间还是时间，都可以先不是最优的，然后继续优化。

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
}
