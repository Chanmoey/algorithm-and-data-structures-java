package com.moon.stringmatch;

import com.moon.util.FileUtil;
import com.moon.util.StringMatchHelper;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.stream.Stream;

/**
 * @author Chanmoey
 * @date 2022年12月29日
 */
public class StringMatchTest {

    @Test
    public void test() {
        String s = "hello, algo and data struct, find me";
        String t = "find me";
        StringMatchHelper.matchTest("com.moon.stringmatch.StringMatch",
                "bruteforce", s, t);
        System.out.println(StringMatch.bruteforce(s, t));
    }

    @Test
    public void testWithBigText() throws FileNotFoundException {
        String s = FileUtil.txt2String("src/main/java/com/moon/util/mock/pride-and-prejudice.txt");
        String t = "china";

        StringMatchHelper.matchTest("com.moon.stringmatch.StringMatch",
                "bruteforce", s, t);

        StringMatchHelper.matchTest("com.moon.stringmatch.StringMatch",
                "bruteforce", s, "xyz");
    }

    @Test
    public void testBadBruteforce() {
        int n = 1000000;
        int m = 10000;
        StringBuilder sb = new StringBuilder();
        Stream.generate(() -> 'a').limit(n).forEach(sb::append);
        String s = sb.toString();
        sb.delete(0, sb.length());

        Stream.generate(() -> 'a').limit(m -1).forEach(sb::append);
        sb.append('b');
        String t = sb.toString();

        StringMatchHelper.matchTest("com.moon.stringmatch.StringMatch",
                "bruteforce", s, t);
    }

    @Test
    public void rabinKarpTest() {
        String s = "hello, algo and data struct, find me";
        String t = "find me";
        StringMatchHelper.matchTest("com.moon.stringmatch.StringMatch",
                "rabinKarp", s, t);
        System.out.println(StringMatch.rabinKarp(s, t));
    }

    @Test
    public void testRabinKarpWithBigText() throws FileNotFoundException {
        String s = FileUtil.txt2String("src/main/java/com/moon/util/mock/pride-and-prejudice.txt");
        String t = "china";

        StringMatchHelper.matchTest("com.moon.stringmatch.StringMatch",
                "rabinKarp", s, t);

        StringMatchHelper.matchTest("com.moon.stringmatch.StringMatch",
                "rabinKarp", s, "xyz");
    }

    @Test
    public void testRabinKarp() {
        int n = 1000000;
        int m = 10000;
        StringBuilder sb = new StringBuilder();
        Stream.generate(() -> 'a').limit(n).forEach(sb::append);
        String s = sb.toString();
        sb.delete(0, sb.length());

        Stream.generate(() -> 'a').limit(m -1).forEach(sb::append);
        sb.append('b');
        String t = sb.toString();

        StringMatchHelper.matchTest("com.moon.stringmatch.StringMatch",
                "rabinKarp", s, t);
    }
}
