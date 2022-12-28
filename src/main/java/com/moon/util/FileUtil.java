package com.moon.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Chanmoey
 * @date 2022年11月29日
 */
public class FileUtil {

    public static void readFile(String fileName, List<String> words) throws FileNotFoundException {
        if (fileName == null || fileName.length() == 0 || words == null) {
            throw new IllegalArgumentException("file name is null or word list is null!");
        }

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(new BufferedInputStream(fis), StandardCharsets.UTF_8);

        // 分词
        if (scanner.hasNextLine()) {

            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
                    i++;
                }
            }
        }
    }

    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }
        }
        return s.length();
    }

    public static String txt2String(String filePath) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        readFile(filePath, list);
        StringBuilder sb = new StringBuilder();
        list.stream().map(word -> word + " ").forEach(sb::append);
        return sb.toString();
    }
}
