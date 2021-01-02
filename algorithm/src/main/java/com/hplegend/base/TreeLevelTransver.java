package com.hplegend.base;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的层序遍历
 *
 * @author hp.he
 * @date 2021/1/2 12:34
 */
public class TreeLevelTransver {


    // 层序遍历，借助栈来实现
    private static Queue<TreeNode> levelStack = new LinkedList<>();

    public static void doLevenTranser(TreeNode root) {

        levelStack.add(root);

        while (!levelStack.isEmpty()) {

            TreeNode curNode = levelStack.poll();

            if (null == curNode) {
                continue;
            }

            System.out.println(curNode.val);

            levelStack.add(curNode.left);
            levelStack.add(curNode.right);
        }
    }
}
