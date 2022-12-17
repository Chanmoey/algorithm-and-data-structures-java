package com.moon.avltree;

import com.moon.map.BSTMap;
import com.moon.util.FileUtil;
import com.moon.util.TimeUtil;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Chanmoey
 * @date 2022年12月18日
 */
public class AVLTreeTest {

    @Test
    public void test() throws FileNotFoundException {
        System.out.println("pride-and-prejudice");

        ArrayList<String> ppWords = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/pride-and-prejudice.txt", ppWords);

        System.out.println("Total words: " + ppWords.size());

        AVLTree<String, Integer> avlTree = new AVLTree<>();
        ppWords.forEach(word -> {
            if (avlTree.contains(word)) {
                avlTree.set(word, avlTree.get(word) + 1);
            } else {
                avlTree.set(word, 1);
            }
        });

        System.out.println("Total different words: " + avlTree.getSize());
        System.out.println(avlTree.isBalance());
        System.out.println(avlTree.isBST());
        System.out.println("----------------------------------------------------");
    }

    @Test
    public void benchmark() throws FileNotFoundException {
        System.out.println("pride-and-prejudice");

        ArrayList<String> ppWords = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/pride-and-prejudice.txt", ppWords);

        System.out.println("Total words: " + ppWords.size());

        long startTime = System.nanoTime();
        AVLTree<String, Integer> avlTree = new AVLTree<>();
        ppWords.forEach(word -> {
            if (avlTree.contains(word)) {
                avlTree.set(word, avlTree.get(word) + 1);
            } else {
                avlTree.set(word, 1);
            }
        });

        ppWords.forEach(avlTree::contains);

        long endTime = System.nanoTime();

        System.out.println("AVLTree time: " + TimeUtil.nanoSecond2Second(startTime, endTime) + "s");

        System.out.println("----------------------------------------------------");

        startTime = System.nanoTime();
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        ppWords.forEach(word -> {
            if (bstMap.contains(word)) {
                bstMap.set(word, bstMap.get(word) + 1);
            } else {
                bstMap.set(word, 1);
            }
        });

        ppWords.forEach(bstMap::contains);

        endTime = System.nanoTime();

        System.out.println("BST time: " + TimeUtil.nanoSecond2Second(startTime, endTime) + "s");
    }

    @Test
    public void benchmarkOrderArray() throws FileNotFoundException {
        System.out.println("pride-and-prejudice");

        ArrayList<String> ppWords = new ArrayList<>();

        FileUtil.readFile("src/main/java/com/moon/util/mock/pride-and-prejudice.txt", ppWords);
        Collections.sort(ppWords);
        System.out.println("Total words: " + ppWords.size());

        long startTime = System.nanoTime();
        AVLTree<String, Integer> avlTree = new AVLTree<>();
        ppWords.forEach(word -> {
            if (avlTree.contains(word)) {
                avlTree.set(word, avlTree.get(word) + 1);
            } else {
                avlTree.set(word, 1);
            }
        });

        ppWords.forEach(avlTree::contains);

        long endTime = System.nanoTime();

        System.out.println("AVLTree time: " + TimeUtil.nanoSecond2Second(startTime, endTime) + "s");

        System.out.println("----------------------------------------------------");

        startTime = System.nanoTime();
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        ppWords.forEach(word -> {
            if (bstMap.contains(word)) {
                bstMap.set(word, bstMap.get(word) + 1);
            } else {
                bstMap.set(word, 1);
            }
        });

        ppWords.forEach(bstMap::contains);

        endTime = System.nanoTime();

        System.out.println("BST time: " + TimeUtil.nanoSecond2Second(startTime, endTime) + "s");
    }
}
