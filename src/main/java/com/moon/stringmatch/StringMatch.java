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

    private static void checkNull(String... args) {
        for (String s : args) {
            if (s == null) {
                throw new IllegalArgumentException("s or t can not be null!");
            }
        }
    }
}
