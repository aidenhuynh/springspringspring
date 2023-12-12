package com.nighthawk.spring_portfolio.mvc.fibonachi;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class ForFibonachi extends Fibonachi {
    public ForFibonachi(){
        super("Fibonachi For Loop");
    }

    @Override
    void runFibo(int n) {
        long startTime = System.nanoTime();
        ArrayList<Long> sequence = new ArrayList<>();
        if (n >= 0) {
            sequence.add(0L);
        }
        if (n >= 1) {
            sequence.add(1L);
        }

        for (int i = 2; i <= n; i++) {
            sequence.add(sequence.get(i - 1) + sequence.get(i - 2));
        }

        super.list = sequence;
        super.times.add(System.nanoTime() - startTime);
    }
}