package com.nighthawk.spring_portfolio.mvc.bubbleSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class ForSortBubble extends Bubble {
    public ForSortBubble(){
        super("Bubble Sort for Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr){
        super.Swaps.clear();
        super.iterations = 0;
        super.comparisons = 0;
        long startTime = System.nanoTime();
        int n = arr.size();
        
        // Iterate through list
    for (int i = 0; i < n - 1; i ++) {
        // Iterate through previous element in list
        for (int j = 0; j < n - i - 1; j ++) {
            // Swap if necessary
            if (arr.get(j) > arr.get(j + 1)) {
                int temp = arr.get(j);
                arr.set(j, arr.get(j + 1));
                arr.set(j + 1, temp);
            }
        }
    }
    return arr;
        
    }
}