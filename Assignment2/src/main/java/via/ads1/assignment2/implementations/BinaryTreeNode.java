package via.ads1.assignment2.implementations;

import via.ads1.assignment2.interfaces.BinaryTreeNodeADT;

public class BinaryTreeNode<T> implements BinaryTreeNodeADT<T> {
    private T element;
    private BinaryTreeNodeADT<T> leftChild;
    private BinaryTreeNodeADT<T> rightChild;

    public BinaryTreeNode(T element) {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    @Override
    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public T getElement() {
        return element;
    }

    @Override
    public void addLeftChild(BinaryTreeNodeADT<T> node) {
        this.leftChild = node;
    }

    @Override
    public void addRightChild(BinaryTreeNodeADT<T> node) {
        this.rightChild = node;
    }

    @Override
    public BinaryTreeNodeADT<T> getLeftChild() {
        return leftChild;
    }

    @Override
    public BinaryTreeNodeADT<T> getRightChild() {
        return rightChild;
    }
}
