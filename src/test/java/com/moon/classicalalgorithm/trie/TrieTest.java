package com.moon.classicalalgorithm.trie;

import com.moon.classicalalgorithm.set.BSTSet;
import com.moon.classicalalgorithm.set.TrieSet;
import com.moon.classicalalgorithm.util.FileUtil;
import com.moon.classicalalgorithm.util.TimeUtil;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Chanmoey
 * @date 2022年12月12日
 */
public class TrieTest {

    @Test
    public void baseTest() throws FileNotFoundException {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        FileUtil.readFile("src/main/java/com/moon/util/mock/pride-and-prejudice.txt", words);

        long startTime = System.nanoTime();
        BSTSet<String> set = new BSTSet<>();
        for (String word : words) {
            set.add(word);
        }

        for (String word : words) {
            set.contains(word);
        }

        long endTime = System.nanoTime();

        System.out.println(set.getSize());
        System.out.println("BSTSet: " + TimeUtil.nanoSecond2Second(startTime, endTime) + "s");

        startTime = System.nanoTime();
        TrieSet<String> trieSet = new TrieSet<>();
        for (String word : words) {
            trieSet.add(word);
        }

        for (String word : words) {
            trieSet.contains(word);
        }

        endTime = System.nanoTime();

        System.out.println(trieSet.getSize());
        System.out.println("TrieSet: " + TimeUtil.nanoSecond2Second(startTime, endTime) + "s");
    }

    @Test
    public void removeTest() {
        Trie trie = new Trie();
        trie.add("ab");
        trie.add("abc");
        trie.add("abd");
        System.out.println("包含ab吗 " + trie.contains("ab"));
        System.out.println("包含abc吗 " + trie.contains("abc"));

        System.out.println("删除ab");
        trie.remove("ab");

        System.out.println("包含ab吗 " + trie.contains("ab"));
        System.out.println("包含abc吗 " + trie.contains("abc"));
    }

    @Test
    public void remove1Test() {
        Trie trie = new Trie();
        trie.add("abc");
        System.out.println("包含ab吗 " + trie.contains("ab"));
        System.out.println("包含abc吗 " + trie.contains("abc"));
        System.out.println("包含前缀ab吗 " + trie.isPrefix("ab"));

        System.out.println("删除abc");
        trie.remove("abc");

        System.out.println("包含ab吗 " + trie.contains("ab"));
        System.out.println("包含abc吗 " + trie.contains("abc"));
        System.out.println("包含前缀ab吗 " + trie.isPrefix("ab"));
    }

    @Test
    public void remove2Test() {
        Trie trie = new Trie();
        trie.add("ab");
        trie.add("abc");
        trie.add("abcd");
        System.out.println("包含ab吗 " + trie.contains("ab"));
        System.out.println("包含abc吗 " + trie.contains("abc"));
        System.out.println("包含abcd吗 " + trie.contains("abcd"));
        System.out.println("包含前缀ab吗 " + trie.isPrefix("ab"));

        System.out.println("删除abc");
        trie.remove("abc");

        System.out.println("包含ab吗 " + trie.contains("ab"));
        System.out.println("包含abc吗 " + trie.contains("abc"));
        System.out.println("包含abcd吗 " + trie.contains("abcd"));
        System.out.println("包含前缀ab吗 " + trie.isPrefix("ab"));
    }
}
