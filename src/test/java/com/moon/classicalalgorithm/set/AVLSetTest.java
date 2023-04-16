package com.moon.classicalalgorithm.set;

import com.moon.classicalalgorithm.util.FileUtil;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Chanmoey
 * @date 2022年12月20日
 */
public class AVLSetTest {

    @Test
    public void test() throws FileNotFoundException {
        System.out.println("pride-and-prejudice");

        ArrayList<String> ppWords = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/pride-and-prejudice.txt", ppWords);

        System.out.println("Total words: " + ppWords.size());

        AVLSet<String> bstSet = new AVLSet<>();
        ppWords.forEach(bstSet::add);

        System.out.println("Total different words: " + bstSet.getSize());
    }
}
