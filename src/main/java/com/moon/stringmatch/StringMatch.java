package com.moon.stringmatch;

/**
 * @author Chanmoey
 * @date 2022年12月29日
 */
public class StringMatch {

    private StringMatch() {
    }

    /**
     * 在s中是否存在字串t
     *
     * @param s 源字符串
     * @param t 目标字串
     * @return 返回-1表示没找到
     */
    public static int bruteforce(String s, String t) {
        checkNull(s, t);

        if (s.length() < t.length()) {
            return -1;
        }

        // 0 1 2 3
        //   i
        // a b c d
        //   b c d
        int stopIndex = s.length() - t.length();
        for (int i = 0; i <= stopIndex; i++) {

            int j = 0;
            for (; j < t.length(); j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    break;
                }
            }
            if (j == t.length()) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 滚动哈希
     */
    public static int rabinKarp(String s, String t) {
        checkNull(s, t);
        if (s.length() < t.length()) {
            return -1;
        }

        if (t.length() == 0) {
            throw new IllegalArgumentException("empty string can not match any other string!");
        }

        long mod = (long) 1e9 + 7;
        final long b = 256;

        long tHash = 0;
        for (int i = 0; i < t.length(); i++) {
            tHash = (tHash * b + t.charAt(i)) % mod;
        }

        long hash = 0;
        long p = 1;
        for (int i = 0; i < t.length() - 1; i++) {
            p = p * b % mod;
        }

        for (int i = 0; i < t.length() - 1; i++) {
            hash = (hash * b + s.charAt(i)) % mod;
        }

        for (int i = t.length() - 1; i < s.length(); i++) {
            hash = (hash * b + s.charAt(i)) % mod;

            if (hash == tHash && isTrueEqual(s, i - t.length() + 1, t)) {
                return i - t.length() + 1;
            }

            hash = (hash - s.charAt(i - t.length() + 1) * p % mod + mod) % mod;
        }

        return -1;
    }

    /**
     * s[l, t.length()]字串是否等于t
     */
    private static boolean isTrueEqual(String s, int l, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != s.charAt(i + l)) {
                return false;
            }
        }

        return true;
    }

    private static void checkNull(String... args) {
        for (String s : args) {
            if (s == null) {
                throw new IllegalArgumentException("s or t can not be null!");
            }
        }
    }
}
