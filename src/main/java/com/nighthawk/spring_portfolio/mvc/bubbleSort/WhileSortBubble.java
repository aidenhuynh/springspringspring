package com.nighthawk.spring_portfolio.mvc.bubbleSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class WhileSortBubble extends Bubble {
    public WhileSortBubble(){
        super("Insertion Sort While Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr){
        super.Swaps.clear();
        super.iterations = 0;
        super.comparisons = 0;
        long startTime = System.nanoTime();
        int n = arr.size();
        int i = 1;
        
        while (i < n) {
            int key = arr.get(i);
            int j = i - 1;
            super.iterations += 1;

            while (j >= 0 && arr.get(j) > key) {
                super.Swaps.add(arr.get(j));
                super.Swaps.add(key);
                super.iterations += 1;
                super.comparisons += 1;
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
            i++;
        }
        super.list = arr;
        
        super.times.add(System.nanoTime() - startTime);
        return arr;
    }
}
