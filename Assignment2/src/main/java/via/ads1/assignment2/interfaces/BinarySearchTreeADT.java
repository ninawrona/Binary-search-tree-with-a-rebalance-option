package via.ads1.assignment2.interfaces;

public interface BinarySearchTreeADT<T extends Comparable<T>> extends BinaryTreeADT<T>{
    boolean insert(T element);
    boolean removeElement(T element);
    T findMin();
    T findMax();
    boolean contains(T element);
    void rebalance();
}
