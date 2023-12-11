package com.nighthawk.spring_portfolio.mvc.bubbleSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class ForSortBubble extends Bubble {
    public ForSortBubble(){
        super("Bubble Sort For Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr){
        long startTime = System.nanoTime();
        int n = arr.size();
        
        // Iterate through list
        for (int i = 0; i < n - 1; i ++) {
            super.iterations += 1;
            // Iterate through previous element in list
            for (int j = 0; j < n - i - 1; j ++) {
                // Swap if necessary
                super.comparisons += 1;
                super.iterations += 1;
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    super.swaps.add(temp);
                    super.swaps.add(arr.get(j+1));
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }

    super.list = arr;
    super.times.add(System.nanoTime() - startTime);
    return arr;
        
    }
}