package com.hplegend.base;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * 树的层序遍历
 *
 * @author hp.he
 * @date 2021/1/2 12:34
 */
public class TreeLevelTransver {


    public static void doLevenTranser(TreeNode root) {

        if (null == root) {
            return;
        }

        System.out.println(root.val);
        doLevenTranser(root.left);
        doLevenTranser(root.right);


    }


}
