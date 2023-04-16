package com.moon.classicalalgorithm.bst;

import com.moon.classicalalgorithm.util.SortingHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Chanmoey
 * @date 2022年11月25日
 */
public class BSTTest {

    private static final Random RANDOM = new Random();

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

    @Test
    public void inOrderNRTest() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.inOrderNR();
    }

    @Test
    public void postOrderNRTest() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.postOrderNR();
    }

    @Test
    public void levelOrderTest() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.levelOrder();
    }

    @Test
    public void removeMin() {
        int n = 1000;
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < n; i++) {
            bst.add(RANDOM.nextInt(10000));
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (!bst.isEmpty()) {
            arr.add(bst.removeMin());
        }
        System.out.println(arr);
        System.out.println(SortingHelper.isSort(arr.toArray()));
    }
    @Test
    public void removeMax() {
        int n = 1000;
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < n; i++) {
            bst.add(RANDOM.nextInt(10000));
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (!bst.isEmpty()) {
            arr.add(bst.removeMax());
        }
        System.out.println(arr);
        System.out.println(SortingHelper.isReverseSort(arr.toArray()));
    }
}
