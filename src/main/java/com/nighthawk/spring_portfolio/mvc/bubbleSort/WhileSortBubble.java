package com.nighthawk.spring_portfolio.mvc.bubbleSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class WhileSortBubble extends Bubble {
    public WhileSortBubble(){
        super("Bubble Sort While Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr){
        // While loop to iterate through whole array, except last value because it will already be sorted by then
        long startTime = System.nanoTime();
        int i = 0;
        int n = arr.size();
        super.iterations += 1;
        while (i < n - 1) {
            // Define the minimum index by setting it to the first element not iterated yet
            int minIndex = i;
    
            // While loop to iterate through all elements after previous run
            int j = i + 1;
            super.iterations += 1;
            while (j < n) {
                super.comparisons += 1;
                // If selected value is lower than current minimum, set the new minimum
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
    
                j += 1;
            }
    
            // If the minimum is different from the current value, swap them
            super.comparisons += 1;
            if (minIndex != i) {
                int temp = arr.get(i);
                super.swaps.add(temp);
                super.swaps.add(arr.get(minIndex));
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);
            }
    
            i += 1;
        }
        super.times.add(System.nanoTime() - startTime);
        super.list = arr;
        return arr;
    }
}
