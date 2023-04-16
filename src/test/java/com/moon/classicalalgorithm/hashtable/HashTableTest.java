package com.moon.classicalalgorithm.hashtable;

import com.moon.classicalalgorithm.util.FileUtil;
import com.moon.classicalalgorithm.util.TimeUtil;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Chanmoey
 * @date 2022年12月26日
 */
public class HashTableTest {

    @Test
    public void test() throws FileNotFoundException {
        System.out.println("pride-and-prejudice");

        ArrayList<String> ppWords = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/pride-and-prejudice.txt", ppWords);
        System.out.println("Total words: " + ppWords.size());

        long startTime = System.nanoTime();

        HashTable<String, Integer> hashTable = new HashTable<>();
        ppWords.forEach(word -> {
            if (hashTable.contains(word)) {
                hashTable.set(word, hashTable.get(word) + 1);
            } else {
                hashTable.add(word, 1);
            }
        });

        for (String word : ppWords) {
            hashTable.contains(word);
        }

        long endTime = System.nanoTime();

        System.out.println("HashTable Using Time: " + TimeUtil.nanoSecond2Second(startTime, endTime) + "s");

        System.out.println("Total different words: " + hashTable.getSize());
        System.out.println("Frequency of pride: " + hashTable.get("pride"));
        System.out.println("Frequency of prejudice: " + hashTable.get("prejudice"));
    }
}
