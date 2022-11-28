package com.moon.set;

import com.moon.util.FileUtil;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Chanmoey
 * @date 2022年11月29日
 */
public class SetTest {

    @Test
    public void test() throws FileNotFoundException {
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
}
