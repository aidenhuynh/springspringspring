package com.nighthawk.spring_portfolio.mvc.insertionSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class ForSortInsertion extends Insertion {
    public ForSortInsertion(){
        super("Insertion Sort For Loop");
    }
    public ArrayList<Integer> runSort(ArrayList<Integer> arr){
        long startTime = System.nanoTime();
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            int key = arr.get(i);
            int j = i - 1;
            super.iterations += 1;

            while (j >= 0 && arr.get(j) > key) {
                super.swaps.add(arr.get(j));
                super.swaps.add(key);
                super.iterations += 1;
                super.comparisons += 1;
                System.out.println(comparisons);
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
        super.list = arr;
        super.times.add(System.nanoTime() - startTime);
        return arr;
    }
}
