package via.ads1.assignment2.implementations;

import via.ads1.assignment2.interfaces.BinarySearchTreeADT;
import via.ads1.assignment2.interfaces.BinaryTreeADT;
import via.ads1.assignment2.interfaces.BinaryTreeNodeADT;

import java.util.ArrayList;
import java.util.List;


public class BinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeADT<T> {

    private BinaryTreeADT<T> binaryTree;

    public BinarySearchTree() {
        binaryTree = new BinaryTree<>();
    }

    @Override
    public boolean insert(T element) {
        BinaryTreeNodeADT current, parent;

        //creating a node with the element we want to insert into the tree
        BinaryTreeNodeADT tempNode = new BinaryTreeNode(element);

        //if the root is empty -> tree is empty -> then set the root and return
        if (getRoot() == null) {
            setRoot(tempNode);
            return true;
        } else {
            //if the root is NOT empty then set the root as the current node we are looking at
            current = getRoot();
        }

        //repeat until broken by return statement
        while (true) {
            parent = current;

            //compare the values that nodes contain

            //if the inserted value is smaller than the value of the current node
            //then if the current node's left child is null -> insert a new node
            //otherwise continue the loop
            if (element.compareTo((T) current.getElement()) < 0) {
                current = current.getLeftChild();
                if (current == null) {
                    parent.addLeftChild(tempNode);
                    return true;
                }

            }

            //if the inserted value is bigger than the value of the current node
            //then if the current node's right child is null -> insert a new node
            //otherwise continue the loop
            else if (element.compareTo((T) current.getElement()) > 0) {
                current = current.getRightChild();

                if (current == null) {
                    parent.addRightChild(tempNode);
                    return true;
                }
            }
            //if the inserted value is equal to the value of the current node
            //then return false as Binary tree cannot contain two equal values.
            else if (element.compareTo((T) current.getElement()) == 0) {
                                 return false;
                }
            }

        }

    @Override
    public boolean removeElement(T element) {

        //if the tree is empty, then return false
        if(recursiveRemove(element, getRoot()) == null){
            return false;
        }

        //saving the recursiveRemove return value, which is the node that
        BinaryTreeNodeADT node = recursiveRemove(element, getRoot());

        //if the root was removed, then set the node returned by recursiveRemove() as root
        if(getRoot().getElement() == element){
            setRoot(node);
        }

       return true;
    }


    private BinaryTreeNodeADT recursiveRemove(T element, BinaryTreeNodeADT node){

        //if the passed node is null then return
        if (node == null) {
            return node;
        }

        //if element is smaller than node's element then
        // replace it's left child with the child's left child.
        if (element.compareTo((T) node.getElement()) < 0) {
            node.addLeftChild(recursiveRemove(element, node.getLeftChild()));
        }
        //if element is smaller than node's element then
        // replace it's left child with the child's right child.
        else if(element.compareTo((T) node.getElement()) > 0) {
            node.addRightChild(recursiveRemove(element, node.getRightChild()));
        } else {

            //when node's left child is null
            //then return node's right child
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            }
            //when node's right child is null
            //then return node's left child
            else if (node.getRightChild() == null) {
                //when node's left child is null
                return node.getLeftChild();
            }

            //set the element of the node we want to "remove"
            //with the node's smallest child element
            node.setElement(inOrderSuccessor(node.getRightChild()));

            //add node's right child to the node that was next in the tree
            node.addRightChild(recursiveRemove((T) node.getElement(), node.getRightChild()));
        }

        return node;

    }

    //this method searches the smallest child of the node passed in the argument
    public T inOrderSuccessor(BinaryTreeNodeADT root) {
        T minimum = (T) root.getElement();

        while (root.getLeftChild() != null) {
            minimum = (T) root.getLeftChild().getElement();
            root = root.getLeftChild();
        }
        return minimum;
    }

    @Override
    public T findMin() {
        BinaryTreeNodeADT current = getRoot();

        //checking if the tree is empty
        if(current == null){
            return null;
        }

        //setting the "current" to the farthest left child possible
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }

        return (T) current.getElement();
    }

    @Override
    public T findMax() {
        BinaryTreeNodeADT current = getRoot();

        //checking if the tree is empty
        if(current == null){
            return null;
        }

        //setting the "current" to the farthest right child possible
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }

        return (T) current.getElement();
    }

    @Override
    public BinaryTreeNodeADT<T> getRoot() {
        return binaryTree.getRoot();
    }

    @Override
    public void setRoot(BinaryTreeNodeADT<T> node) {
        binaryTree.setRoot(node);
    }

    @Override
    public boolean isEmpty() {
        return binaryTree.isEmpty();
    }

    @Override
    public int size() {
        return binaryTree.size();
    }

    @Override
    public boolean contains(T element) {
        return binaryTree.contains(element);
    }

    @Override
    public ArrayList<T> inOrder() {
        return binaryTree.inOrder();
    }

    @Override
    public ArrayList<T> preOrder() {
        return binaryTree.preOrder();
    }

    @Override
    public ArrayList<T> postOrder() {
        return binaryTree.postOrder();
    }

    @Override
    public ArrayList<T> levelOrder() {
        return binaryTree.levelOrder();
    }

    @Override
    public int height() {
        return binaryTree.height();
    }

    @Override
    public void rebalance() {
            List<T> elements = inOrder();
            // Set root to "middle" value gotten from inorder traversal
            setRoot(new BinaryTreeNode<>(elements.get(elements.size()/2)));
            // Remove node set as root in the line above
            elements.remove(elements.get(elements.size() / 2));

            // insert elements into the tree
            for (int i = elements.size() -1; i >= 0; i--) {
                insert(elements.get(i));
            }

    }
}
