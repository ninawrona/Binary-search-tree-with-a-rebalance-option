package via.ads1.assignment2.implementations;

import via.ads1.assignment2.interfaces.BinaryTreeADT;
import via.ads1.assignment2.interfaces.BinaryTreeNodeADT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> implements BinaryTreeADT<T> {

    private BinaryTreeNodeADT<T> root;


    @Override
    public BinaryTreeNodeADT<T> getRoot() {
        return root;
    }

    @Override
    public void setRoot(BinaryTreeNodeADT<T> node) {
        root = node;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return inOrder().size();
    }

    @Override
    public boolean contains(T element) {
        return inOrder().contains(element);
    }

    @Override
    public ArrayList<T> inOrder() {
        return traverseInorder(new ArrayList<>(), root);
    }

    private ArrayList<T> traverseInorder(ArrayList<T> list, BinaryTreeNodeADT<T> node) {
        if (node != null) {
            traverseInorder(list, node.getLeftChild());
            list.add(node.getElement());
            traverseInorder(list, node.getRightChild());
        }

        return list;
    }

    @Override
    public ArrayList<T> preOrder() {
        return traversePreorder(new ArrayList<>(), root);
    }

    private ArrayList<T> traversePreorder(ArrayList<T> list, BinaryTreeNodeADT<T> node) {
        if (node != null) {
            list.add(node.getElement());
            traversePreorder(list, node.getLeftChild());
            traversePreorder(list, node.getRightChild());
        }

        return list;
    }


    @Override
    public ArrayList<T> postOrder() {
        return traversePostOrder(new ArrayList<>(), root);
    }

    private ArrayList<T> traversePostOrder(ArrayList<T> list, BinaryTreeNodeADT<T> node) {
        if (node != null) {
            traversePostOrder(list, node.getLeftChild());
            traversePostOrder(list, node.getRightChild());
            list.add(node.getElement());
        }

        return list;
    }

    @Override
    public ArrayList<T> levelOrder() {
        ArrayList<T> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<BinaryTreeNodeADT<T>> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            BinaryTreeNodeADT<T> node = nodes.remove();

            list.add(node.getElement());

            if (node.getLeftChild() != null) {
                nodes.add(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                nodes.add(node.getRightChild());
            }
        }

        return list;
    }

    @Override
    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(BinaryTreeNodeADT<T> node) {
        int leftHeight = 0;
        int rightHeight = 0;

        if (node.getLeftChild() != null) leftHeight = heightRecursive(node.getLeftChild());
        if (node.getRightChild() != null) rightHeight = heightRecursive(node.getRightChild());

        int maxHeight = Math.max(leftHeight, rightHeight);

        if (node.equals(root)) return maxHeight;
        return (maxHeight + 1);
    }
}
