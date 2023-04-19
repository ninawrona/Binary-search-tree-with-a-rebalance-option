package via.ads1.assignment2.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree treeZero;
    BinarySearchTree<Integer> treeOne;
    BinarySearchTree<Integer> treeFive;

    @BeforeEach
    void setUp() {
        treeZero = new BinarySearchTree<>();
        treeOne = new BinarySearchTree<>();
        treeFive = new BinarySearchTree<>();

        treeOne.insert(1);

        treeFive.insert(2);
        treeFive.insert(4);
        treeFive.insert(3);
        treeFive.insert(9);
        treeFive.insert(11);
    }

    @Test
    void insertFalse() {
        assertFalse(treeOne.insert(1));
    }

    @Test
    void insertTrue() {
        assertTrue(treeZero.insert(4));
    }

    @Test
    void insertComparison() {

        ArrayList arr = new ArrayList();
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(9);
        arr.add(11);

        assertEquals(arr, treeFive.inOrder());
    }

    @Test
    void removeElement() {
        ArrayList arr = new ArrayList<>();

        arr.add(2);
        arr.add(4);
        arr.add(9);
        arr.add(11);

        treeFive.removeElement(3);
        assertEquals(arr, treeFive.inOrder());
    }

    @Test
    void removeElementWithPlaceSwitch() {
        ArrayList arr = new ArrayList<>();

        arr.add(3);
        arr.add(4);
        arr.add(9);
        arr.add(11);

        treeFive.removeElement(2);
        assertEquals(arr, treeFive.inOrder());
    }

    @Test
    void findMin() {
        assertEquals(2, treeFive.findMin());
    }

    @Test
    void findMax() {
        assertEquals(11, treeFive.findMax());
    }

    @Test
    void rebalance() {
        treeFive.removeElement(3);
        treeFive.rebalance();

        ArrayList arr = new ArrayList<>();

        arr.add(2);
        arr.add(4);
        arr.add(9);
        arr.add(11);

        assertEquals(arr, treeFive.inOrder());
    }
}