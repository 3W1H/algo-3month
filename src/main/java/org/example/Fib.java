package org.example;

import org.junit.Test;

/**
 * @Package: org.example
 * @Class: Fib
 * @Description: todo
 * @Author: zhiyong.fan
 * @Date: 2020-10-22 18:01
 */
public class Fib {

    Integer[] cache = new Integer[31];

    public int fib_01(int n) {
        if (n <= 1) {
            return n;
        }
        return fib_01(n - 1) + fib_01(n - 2);
    }

    public int fib_02(int n) {
        int[] cache = new int[n + 1];
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public int fib_04(int n) {
        if (n <= 0) {
            return n;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memory(n);
    }

    public int memory(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        cache[n] = memory(n - 1) + memory(n - 2);
        return cache[n];
    }

    public int fib_03(int n) {
        if (n <= 0) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int current = 0;
        int pre1 = 1;
        int pre2 = 1;
        for (int i = 3; i <= n; i++) {
            current = pre1 + pre2;
            pre2 = pre1;
            pre1 = current;
        }
        return current;
    }


    @Test
    public void testFib() {
        //System.err.println(fib_01(50));
        System.err.println(fib_02(20));
        System.err.println(fib_03(20));
        System.err.println(Integer.MAX_VALUE);
    }
}
