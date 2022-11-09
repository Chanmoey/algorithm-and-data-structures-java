package com.moon.linearsearch;

import com.moon.util.mock.Student;
import com.moon.util.ArrayGenerator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chanmoey
 */
public class LinearSearchTest {

    @Test
    public void testSearch() {
        Integer[] data = {2477, 18, 12, 9, 16, 66, 32, 4};
        Integer target = 16;
        Integer noTarget = 25;

        Assert.assertEquals(4, LinearSearch.search(data, target));
        Assert.assertEquals(-1, LinearSearch.search(data, noTarget));
        Assert.assertEquals(0, LinearSearch.search(data, 2477));
    }

    @Test
    public void testSearchWithMyClass() {
        Student[] data = {new Student("张三", 18), new Student("Zhang San", 17),
                new Student("李四", 18), new Student("王五", 18)};

        Assert.assertEquals(0, LinearSearch.search(data, new Student("张三", 18)));
        Assert.assertEquals(-1, LinearSearch.search(data, new Student("张三", 10)));
        Assert.assertEquals(2, LinearSearch.search(data, new Student("李四", 18)));
        Assert.assertEquals(-1, LinearSearch.search(data, "张三，18岁"));

        // 测试忽略大小写
        Assert.assertEquals(1, LinearSearch.search(data, new Student("zhang san", 17)));
    }

    @Test
    public void linearSearchBenchMark() {
        int n = 10000000;
        Integer[] data = ArrayGenerator.generateOrderedArray(n);

        long startTime = System.nanoTime();
        for (int k = 0; k < 100; k++) {
            Assert.assertEquals(-1, LinearSearch.search(data, n));
        }
        long endTime = System.nanoTime();

        System.out.println((endTime - startTime) / 1000000000.0 + "s");
    }
}
