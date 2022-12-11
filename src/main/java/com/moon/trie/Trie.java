package com.moon.trie;

import java.nio.channels.IllegalChannelGroupException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年12月12日
 */
public class Trie {

    private static class Node {

        public boolean isWord;
        public Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private final Node root;
    private int size;

    /**
     * 帮助删除Trie中的元素
     */
    private boolean keepRemove;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 添加单词word到Trie中
     */
    public void add(String word) {
        Node cur = root;

        for (char c : word.toCharArray()) {
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询Trie中是否包含单词word
     */
    public boolean contains(String word) {

        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException("word is empty!");
        }

        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public boolean remove(String word) {
        return remove(root, word, 0);
    }

    private boolean remove(Node node, String word, int index) {

        if (index == word.length()) {
            // Trie中没有这个单词
            if (!node.isWord) {
                // 回溯时，不要继续删除了
                this.keepRemove = false;
                return false;

                // 这是一个单词
            } else {
                // 标记删除
                node.isWord = false;
                // 意味着word在这个路径下，并不是终点，所以，回溯时，也不需要继续删除了
                // word单词在这个路径下已经是末尾终点了，回溯时继续删除。
                this.keepRemove = node.next.size() == 0;

                return true;
            }
        }

        // 没有这个单词
        if (!node.next.containsKey(word.charAt(index))) {
            this.keepRemove = false;
            return false;
        }

        boolean removeResult = remove(node.next.get(word.charAt(index)), word, index + 1);

        // 上面递归的时候，删除了word，看看要不要继续删除。
        if (removeResult) {
            if (keepRemove) {
                node.next.remove(word.charAt(index));
                if (node.isWord) {
                    // 回溯过程中，路径上还有其他单词，则不需要继续删除了
                    this.keepRemove = false;
                }
            }
        }

        return removeResult;
    }
}






















