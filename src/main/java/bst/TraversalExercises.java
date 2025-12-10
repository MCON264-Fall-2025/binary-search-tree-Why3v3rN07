package bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class TraversalExercises {

    // Iterative preorder using a stack
    public static <T extends Comparable<T>> List<T> preorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO: implement iterative preorder using Deque as a stack
        // Hint: push root; while stack not empty:
        //   pop node, visit it, then push right child, then left child
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            result.add(node.getValue());
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    // Iterative inorder using a stack
    public static <T extends Comparable<T>> List<T> inorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO: implement iterative inorder
        // Hint: use a pointer 'curr' and a stack:
        //   while (curr != null || !stack.isEmpty()) { ... }
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        TreeNode<T> curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.getValue());
            curr = curr.right;
        }
        return result;
    }

    // Optional / challenge: iterative postorder
    public static <T extends Comparable<T>> List<T> postorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO (challenge): implement iterative postorder
        // use two stacks with a previous-node pointer.
        if (root != null) {
            Deque<TreeNode<T>> stack = new ArrayDeque<>();
            TreeNode<T> curr = root;
            TreeNode<T> prev = root;
            while (!stack.isEmpty() || curr != null) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                else {
                    TreeNode<T> top = stack.peek();
                    if (top.right != null && prev != top.right) {
                        curr = top.right;
                    } else {
                        result.add(top.getValue());
                        prev = stack.pop();
                    }
                }
            }
        }
        return result;
    }

    // Practice version of level-order
    public static <T extends Comparable<T>> List<T> levelOrderUsingQueue(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO: implement BFS using a Queue<TreeNode<T>>
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            result.add(node.getValue());
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result;
    }
}

