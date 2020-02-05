package com.aop;

/**
 * 2020/2/3
 */
public class InMemoryCalculate implements  Calculate {

    public int add(int numA, int numB) {
        return numA + numB ;
    }

    public int reduce(int numA, int numB) {
        return numA - numB ;
    }

    public int div(int numA, int numB) {
         return numA / numB ;
    }
}
