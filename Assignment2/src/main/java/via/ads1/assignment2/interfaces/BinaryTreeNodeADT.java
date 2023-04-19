package via.ads1.assignment2.interfaces;

public interface BinaryTreeNodeADT<T> {
    void setElement(T element);
    T getElement();
    void addLeftChild(BinaryTreeNodeADT<T> node);
    void addRightChild(BinaryTreeNodeADT<T> node);
    BinaryTreeNodeADT<T> getLeftChild();
    BinaryTreeNodeADT<T> getRightChild();
}
