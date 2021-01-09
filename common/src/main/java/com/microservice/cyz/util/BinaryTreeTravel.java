package com.microservice.cyz.util;

import com.microservice.cyz.dto.TreeNodeDTO;

import java.util.*;

/**
 * @author 崔耀中
 * @since 2020-12-23
 */
public class BinaryTreeTravel {

    /**
     * @Description 创建二叉树
     * @Param inputList 输入序列
     */
    public static TreeNodeDTO createTreeNodeDTO(List<Integer> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        TreeNodeDTO node = null;
        Integer data = inputList.remove(0);
        if (data != null) {
            node = new TreeNodeDTO(data);
            node.setLeftChild(createTreeNodeDTO(inputList));
            node.setRightChild(createTreeNodeDTO(inputList));

        }
        return node;
    }

    /**
     * @Description 二叉树前序遍历（根-左-右）
     * @Param node 二叉树节点
     */
    public static void preOrderTravel(TreeNodeDTO node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        preOrderTravel(node.getLeftChild());
        preOrderTravel(node.getRightChild());
    }

    /**
     * @Description 二叉树中序遍历（左-根-又）
     * @Param node 二叉树节点
     */
    public static void inOrderTravel(TreeNodeDTO node){
        if (node == null){
            return;
        }
        inOrderTravel(node.getLeftChild());
        System.out.println(node.getData());
        inOrderTravel(node.getRightChild());

    }

    /**
     * @Description 二叉树后序遍历（左-右-根）
     * @Param node 二叉树节点
     */
    public static void postOrderTravel(TreeNodeDTO node){
        if (node == null){
            return;
        }
        postOrderTravel(node.getLeftChild());
        postOrderTravel(node.getRightChild());
        System.out.println(node.getData());
    }

    /**
     * @Description 利用栈前序遍历二叉树
     * @Param [args]
     */
    public static void preOrderTraveralWithStack(TreeNodeDTO root){

        Stack<TreeNodeDTO> stack = new Stack<TreeNodeDTO>();
        TreeNodeDTO TreeNodeDTO = root;
        while (TreeNodeDTO!=null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while (TreeNodeDTO != null){
                System.out.println(TreeNodeDTO.getData());
                stack.push(TreeNodeDTO);
                TreeNodeDTO = TreeNodeDTO.getLeftChild();
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()){
                TreeNodeDTO = stack.pop();
                TreeNodeDTO = TreeNodeDTO.getRightChild();

            }
        }
    }

    /**
     * @Description 二叉树层序遍历
     * @Param [args]
     */
    public static void levelOrderTraversal(TreeNodeDTO root){
        Queue<TreeNodeDTO> queue = new LinkedList<TreeNodeDTO>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNodeDTO TreeNodeDTO = queue.poll();
            System.out.println(TreeNodeDTO.getData());
            if (TreeNodeDTO.getLeftChild() != null){
                queue.offer(TreeNodeDTO.getLeftChild());
            }
            if (TreeNodeDTO.getRightChild() != null){
                queue.offer(TreeNodeDTO.getRightChild());
            }
        }

    }

    public static void main(String[] args) {
        List<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null, null,8,null,4}));
        TreeNodeDTO node = createTreeNodeDTO(inputList);

        System.out.println("前序遍历");
        preOrderTravel(node);

        System.out.println("中序遍历");
        inOrderTravel(node);

        System.out.println("后序遍历");
        postOrderTravel(node);

        System.out.println("利用栈前序遍历二叉树");
        preOrderTraveralWithStack(node);

        System.out.println("层序遍历");
        levelOrderTraversal(node);
    }

}
