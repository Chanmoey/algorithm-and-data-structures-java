package com.moon.classicalalgorithm.map;

import com.moon.classicalalgorithm.util.FileUtil;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Chanmoey
 * @date 2022年11月30日
 */
public class MapTest {

    @Test
    public void linkedListMapTest() throws FileNotFoundException {

        System.out.println("pride-and-prejudice");

        ArrayList<String> ppWords = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/pride-and-prejudice.txt", ppWords);
        System.out.println("Total words: " + ppWords.size());

        LinkedListMap<String, Integer> map = new LinkedListMap<>();
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

    @Test
    public void bstMapTest() throws FileNotFoundException {

        System.out.println("pride-and-prejudice");

        ArrayList<String> ppWords = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/pride-and-prejudice.txt", ppWords);
        System.out.println("Total words: " + ppWords.size());

        BSTMap<String, Integer> map = new BSTMap<>();
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
