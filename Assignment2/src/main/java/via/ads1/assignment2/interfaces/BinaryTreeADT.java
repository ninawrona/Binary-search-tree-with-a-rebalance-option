package via.ads1.assignment2.interfaces;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface BinaryTreeADT<T> {
    BinaryTreeNodeADT<T> getRoot();
    void setRoot(BinaryTreeNodeADT<T> node);
    boolean isEmpty();
    int size();
    boolean contains(T element);
    ArrayList<T> inOrder();
    ArrayList<T> preOrder();
    ArrayList<T> postOrder();
    ArrayList<T> levelOrder();
    int height();

}
