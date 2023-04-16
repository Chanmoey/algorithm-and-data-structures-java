package com.moon.classicalalgorithm.rbtree;

import com.moon.classicalalgorithm.rbt.RBTree;
import com.moon.classicalalgorithm.util.FileUtil;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Chanmoey
 * @date 2022年12月25日
 */
public class RBTreeTest {

    @Test
    public void test() throws FileNotFoundException {
        System.out.println("pride-and-prejudice");

        ArrayList<String> ppWords = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/pride-and-prejudice.txt", ppWords);
        System.out.println("Total words: " + ppWords.size());

        RBTree<String, Integer> map = new RBTree<>();
        ppWords.forEach(word -> {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        });

        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of pride: " + map.get("pride"));
        System.out.println("Frequency of prejudice: " + map.get("prejudice"));
    }
}
