package via.ads1.assignment2.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import via.ads1.assignment2.interfaces.BinaryTreeADT;
import via.ads1.assignment2.interfaces.BinaryTreeNodeADT;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTreeADT<Character> emptyTree;
    BinaryTreeADT<Character> treeWith1Element;
    BinaryTreeADT<Character> treeWith5Elements;

    @BeforeEach
    void setUp() {
        BinaryTreeNodeADT<Character> a = new BinaryTreeNode<>('a');
        BinaryTreeNodeADT<Character> b = new BinaryTreeNode<>('b');
        BinaryTreeNodeADT<Character> c = new BinaryTreeNode<>('c');
        BinaryTreeNodeADT<Character> d = new BinaryTreeNode<>('d');
        BinaryTreeNodeADT<Character> e = new BinaryTreeNode<>('e');
        BinaryTreeNodeADT<Character> f = new BinaryTreeNode<>('f');
        BinaryTreeNodeADT<Character> g = new BinaryTreeNode<>('g');
        BinaryTreeNodeADT<Character> h = new BinaryTreeNode<>('h');
        BinaryTreeNodeADT<Character> i = new BinaryTreeNode<>('i');
        BinaryTreeNodeADT<Character> j = new BinaryTreeNode<>('j');
        BinaryTreeNodeADT<Character> k = new BinaryTreeNode<>('k');
        BinaryTreeNodeADT<Character> l = new BinaryTreeNode<>('l');
        BinaryTreeNodeADT<Character> m = new BinaryTreeNode<>('m');


        emptyTree = new BinaryTree<>();

        treeWith1Element = new BinaryTree<>();
        treeWith1Element.setRoot(m);

        treeWith5Elements = new BinaryTree<>();
        treeWith5Elements.setRoot(a);
        a.addLeftChild(b);
        b.addLeftChild(d);
        b.addRightChild(e);
        d.addLeftChild(h);
        d.addRightChild(i);
        a.addRightChild(c);
        c.addLeftChild(f);
        c.addRightChild(g);
        f.addLeftChild(j);
        g.addLeftChild(k);
        g.addRightChild(l);
    }

    @Test
    void getRootIfNull() {
        assertNull(emptyTree.getRoot());
    }

    @Test
    void getRoot() {
        BinaryTreeNodeADT<Character> node = new BinaryTreeNode<>('m');
        assertEquals('m', treeWith1Element.getRoot().getElement());
    }
    @Test
    void isEmpty() {
        assertTrue(emptyTree.isEmpty());
    }

    @Test
    void isEmptyFalse() {
        assertFalse(treeWith1Element.isEmpty());
    }

    @Test
    void size() {
        assertEquals(12, treeWith5Elements.size());
    }

    @Test
    void contains() {
        assertTrue(treeWith1Element.contains('m'));
        assertFalse(treeWith1Element.contains('a'));
    }

    @Test
    void inOrder() {
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('h', 'd', 'i', 'b', 'e', 'a', 'j', 'f', 'c', 'k', 'g', 'l'));
        assertEquals(list, treeWith5Elements.inOrder());
    }

    @Test
    void preOrder() {
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('a', 'b', 'd', 'h', 'i', 'e', 'c', 'f', 'j', 'g', 'k', 'l'));
        assertEquals(list, treeWith5Elements.preOrder());
    }

    @Test
    void postOrder() {
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('h', 'i', 'd', 'e', 'b', 'j', 'f', 'k', 'l', 'g', 'c', 'a'));
        assertEquals(list, treeWith5Elements.postOrder());
    }

    @Test
    void levelOrder() {
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'));
        assertEquals(list, treeWith5Elements.levelOrder());
    }

    @Test
    void height() {
        assertEquals(3, treeWith5Elements.height());
    }
}