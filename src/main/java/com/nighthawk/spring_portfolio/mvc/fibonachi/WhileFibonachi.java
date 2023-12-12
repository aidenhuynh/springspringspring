package com.nighthawk.spring_portfolio.mvc.fibonachi;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class WhileFibonachi extends Fibonachi {
    public WhileFibonachi(){
        super("Fibonachi While Loop");
    }
    @Override
    void runFibo(int n) {
        long startTime = System.nanoTime();
        ArrayList<Long> sequence = new ArrayList<>();
        Long a = 0L, b = 1L;

        for (int i = 0; i <= n; i++) {
            sequence.add(a);
            long temp = a;
            a = b;
            b = temp + b;
        }

        super.times.add(System.nanoTime() - startTime);
        super.list = sequence;
    }
   
}
