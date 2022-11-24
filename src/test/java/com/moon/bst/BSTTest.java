package com.moon.bst;

import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2022年11月25日
 */
public class BSTTest {

    @Test
    public void addTest() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();

        System.out.println(bst);
    }

    @Test
    public void addNotRTest() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.addNR(num);
        }
        bst.preOrder();
    }

    @Test
    public void inOrderTest() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.inOrder();
    }

    @Test
    public void postOrderTest() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.postOrder();
    }

    @Test
    public void preOrderNRTest() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrderNR();
    }
}
