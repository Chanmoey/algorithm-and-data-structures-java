package com.moon.classicalalgorithm.set;

import com.moon.classicalalgorithm.util.FileUtil;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Chanmoey
 * @date 2022年11月29日
 */
public class SetTest {

    @Test
    public void bstSetTest() throws FileNotFoundException {
        System.out.println("pride-and-prejudice");

        ArrayList<String> ppWords = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/pride-and-prejudice.txt", ppWords);

        System.out.println("Total words: " + ppWords.size());

        BSTSet<String> bstSet = new BSTSet<>();
        ppWords.forEach(bstSet::add);

        System.out.println("Total different words: " + bstSet.getSize());

        System.out.println("----------------------------------------------------");

        System.out.println("a-tale-of-two-cities");

        ArrayList<String> tcWords = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/a-tale-of-two-cities.txt", tcWords);

        System.out.println("Total words: " + tcWords.size());

        BSTSet<String> bstSet1 = new BSTSet<>();
        tcWords.forEach(bstSet1::add);

        System.out.println("Total different words: " + bstSet1.getSize());

    }

    @Test
    public void linkedListSet() throws FileNotFoundException {
        System.out.println("pride-and-prejudice");

        ArrayList<String> ppWords = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/pride-and-prejudice.txt", ppWords);

        System.out.println("Total words: " + ppWords.size());

        Set<String> set = new LinkedListSet<>();
        ppWords.forEach(set::add);

        System.out.println("Total different words: " + set.getSize());

        System.out.println("----------------------------------------------------");

        System.out.println("a-tale-of-two-cities");

        ArrayList<String> tcWords = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/a-tale-of-two-cities.txt", tcWords);

        System.out.println("Total words: " + tcWords.size());

        Set<String> set1 = new LinkedListSet<>();
        tcWords.forEach(set1::add);

        System.out.println("Total different words: " + set1.getSize());

    }
}
