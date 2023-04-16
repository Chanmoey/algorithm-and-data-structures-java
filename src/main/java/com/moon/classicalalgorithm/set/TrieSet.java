package com.moon.classicalalgorithm.set;

import com.moon.classicalalgorithm.trie.Trie;

/**
 * 字典树，当然只支持String啦。
 *
 * @author Chanmoey
 * @date 2022年12月12日
 */
public class TrieSet<E extends String> implements Set<E>{

    private final Trie trie;

    public TrieSet() {
        this.trie = new Trie();
    }

    @Override
    public void add(E e) {
        trie.add(e);
    }

    @Override
    public void remove(E e) {
        throw new RuntimeException();
    }

    @Override
    public boolean contains(E e) {
        return trie.contains(e);
    }

    @Override
    public int getSize() {
        return trie.getSize();
    }

    @Override
    public boolean isEmpty() {
        return trie.getSize() == 0;
    }
}
