/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package danje;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

@Fork(value = 2, warmups = 1)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 4, time = 2)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {
    static Map<Integer, BiConsumer<Integer, Blackhole>> map = new HashMap<>();
    static Map<Integer, BiConsumer<Integer, Blackhole>> largeMap = new HashMap<>();

    static {
        int i = 0;
        map.put(i++, MyBenchmark::callFoo0);
        map.put(i++, MyBenchmark::callFoo1);
        map.put(i++, MyBenchmark::callFoo2);
        map.put(i++, MyBenchmark::callFoo3);
        map.put(i++, MyBenchmark::callFoo4);
        map.put(i++, MyBenchmark::callFoo0);
        map.put(i++, MyBenchmark::callFoo1);
        map.put(i++, MyBenchmark::callFoo2);
        map.put(i++, MyBenchmark::callFoo3);
        map.put(i++, MyBenchmark::callFoo4);
        map.put(i++, MyBenchmark::callFoo0);
        map.put(i++, MyBenchmark::callFoo1);
        map.put(i++, MyBenchmark::callFoo2);
        largeMap.putAll(map);
        largeMap.put(i++, MyBenchmark::callFoo0);
        largeMap.put(i++, MyBenchmark::callFoo1);
        largeMap.put(i++, MyBenchmark::callFoo2);
        largeMap.put(i++, MyBenchmark::callFoo3);
        largeMap.put(i++, MyBenchmark::callFoo4);
        largeMap.put(i++, MyBenchmark::callFoo0);
        largeMap.put(i++, MyBenchmark::callFoo1);
        largeMap.put(i++, MyBenchmark::callFoo2);
        largeMap.put(i++, MyBenchmark::callFoo3);
        largeMap.put(i++, MyBenchmark::callFoo4);
        largeMap.put(i++, MyBenchmark::callFoo0);
        largeMap.put(i++, MyBenchmark::callFoo1);
        largeMap.put(i++, MyBenchmark::callFoo2);
        largeMap.put(i++, MyBenchmark::callFoo3);
        largeMap.put(i++, MyBenchmark::callFoo4);
        largeMap.put(i++, MyBenchmark::callFoo0);
        largeMap.put(i++, MyBenchmark::callFoo1);
        largeMap.put(i++, MyBenchmark::callFoo2);
        largeMap.put(i++, MyBenchmark::callFoo3);
        largeMap.put(i++, MyBenchmark::callFoo4);
        largeMap.put(i++, MyBenchmark::callFoo0);
        largeMap.put(i++, MyBenchmark::callFoo1);
        largeMap.put(i++, MyBenchmark::callFoo2);
        largeMap.put(i++, MyBenchmark::callFoo3);
        largeMap.put(i++, MyBenchmark::callFoo4);
        largeMap.put(i++, MyBenchmark::callFoo0);
        largeMap.put(i++, MyBenchmark::callFoo1);
        largeMap.put(i++, MyBenchmark::callFoo2);
    }

    private static Random random = new Random();

    @Benchmark
    public void control(Blackhole blackhole) {
        int num = random.nextInt() % 12;
        foo(num, blackhole);
    }

    @Benchmark
    public void testMethod(Blackhole blackhole) {
        int num = random.nextInt() % 12;
        switch (num) {
            case 0:
                foo(0, blackhole);
                break;
            case 1:
                foo(1, blackhole);
                break;
            case 2:
                foo(2, blackhole);
                break;
            case 3:
                foo(3, blackhole);
                break;
            case 4:
                foo(4, blackhole);
                break;
            case 5:
                foo(5, blackhole);
                break;
            case 6:
                foo(6, blackhole);
                break;
            case 7:
                foo(7, blackhole);
                break;
            case 8:
                foo(8, blackhole);
                break;
            case 9:
                foo(9, blackhole);
                break;
            case 10:
                foo(10, blackhole);
                break;
            default:
                foo(num, blackhole);
                break;
        }
    }

    @Benchmark
    public void testMap(Blackhole blackhole) {
        int next = random.nextInt() % 12;
        map.getOrDefault(next, MyBenchmark::callFoo0).accept(next, blackhole);
    }

    @Benchmark
    public void testMethodLarge(Blackhole blackhole) {
        int num = random.nextInt() % 42;
        switch (num) {
            case 0:
                foo(num, blackhole);
                break;
            case 1:
                foo(num, blackhole);
                break;
            case 2:
                foo(num, blackhole);
                break;
            case 3:
                foo(num, blackhole);
                break;
            case 4:
                foo(num, blackhole);
                break;
            case 5:
                foo(num, blackhole);
                break;
            case 6:
                foo(num, blackhole);
                break;
            case 7:
                foo(num, blackhole);
                break;
            case 8:
                foo(num, blackhole);
                break;
            case 9:
                foo(num, blackhole);
                break;
            case 10:
                foo(num, blackhole);
                break;
            case 11:
                foo(num, blackhole);
                break;
            case 12:
                foo(num, blackhole);
                break;
            case 13:
                foo(num, blackhole);
                break;
            case 14:
                foo(num, blackhole);
                break;
            case 15:
                foo(num, blackhole);
                break;
            case 16:
                foo(num, blackhole);
                break;
            case 17:
                foo(num, blackhole);
                break;
            case 18:
                foo(num, blackhole);
                break;
            case 19:
                foo(num, blackhole);
                break;
            case 20:
                foo(num, blackhole);
                break;
            case 21:
                foo(num, blackhole);
                break;
            case 22:
                foo(num, blackhole);
                break;
            case 23:
                foo(num, blackhole);
                break;
            case 24:
                foo(num, blackhole);
                break;
            case 25:
                foo(num, blackhole);
                break;
            case 26:
                foo(num, blackhole);
                break;
            case 27:
                foo(num, blackhole);
                break;
            case 28:
                foo(num, blackhole);
                break;
            case 29:
                foo(num, blackhole);
                break;
            case 30:
                foo(num, blackhole);
                break;
            case 31:
                foo(num, blackhole);
                break;
            case 32:
                foo(num, blackhole);
                break;
            case 33:
                foo(num, blackhole);
                break;
            case 34:
                foo(num, blackhole);
                break;
            case 35:
                foo(num, blackhole);
                break;
            case 36:
                foo(num, blackhole);
                break;
            case 37:
                foo(num, blackhole);
                break;
            case 38:
                foo(num, blackhole);
                break;
            case 39:
                foo(num, blackhole);
                break;
            case 40:
                foo(num, blackhole);
                break;
            case 41:
                foo(num, blackhole);
                break;
            default:
                foo(num, blackhole);
                break;
        }
    }

    @Benchmark
    public void testMapLarge(Blackhole blackhole) {
        int next = random.nextInt() % 42;
        largeMap.getOrDefault(next, MyBenchmark::callFoo0).accept(next, blackhole);
    }


    public static void foo(int n, Blackhole blackhole) {
        bar(n, blackhole);
    }

    public static void bar(int n, Blackhole blackhole) {
        int x = bruh(n);
        blackhole.consume(x);
        blackhole.consume(n);
    }

    private static int bruh(int n) {
        return 0;
    }

    public static void callFoo0(int num, Blackhole blackhole) {
        foo(num, blackhole);
    }

    public static void callFoo1(int num, Blackhole blackhole) {
        foo(num, blackhole);
    }

    public static void callFoo2(int num, Blackhole blackhole) {
        foo(num, blackhole);
    }

    public static void callFoo3(int num, Blackhole blackhole) {
        foo(num, blackhole);
    }

    public static void callFoo4(int num, Blackhole blackhole) {
        foo(num, blackhole);
    }

}
