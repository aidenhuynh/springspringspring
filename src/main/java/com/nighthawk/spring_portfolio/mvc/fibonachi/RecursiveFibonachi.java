package com.nighthawk.spring_portfolio.mvc.fibonachi;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class RecursiveFibonachi extends Fibonachi {
    public RecursiveFibonachi(){
        super("Fibonachi Recursive Loop");
    }
    @Override
    void runFibo(int n) {
        ArrayList<Long> sequence = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i <= n; i++) {
            sequence.add(calculateFibonacciHelper(i, new Long[n + 1]));
        }
        long endTime = System.nanoTime();
        System.out.println("Recursive Time: " + (endTime - startTime) + " milliseconds");
        super.list = sequence;
    }

    private long calculateFibonacciHelper(int n, Long[] memo) {
        if (n <= 1) {
            return n;
        }
        else if (memo[n] != null) {
            return memo[n];
        } else {
            memo[n] = calculateFibonacciHelper(n - 1, memo) + calculateFibonacciHelper(n - 2, memo);
            return memo[n];
        }
    }
}

