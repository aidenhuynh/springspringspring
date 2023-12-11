package com.nighthawk.spring_portfolio.mvc.selectionSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class ForSortSelection extends Selection {
    public ForSortSelection(){
        super("Selection Sort For Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr){
        super.list = arr;
        long startTime = System.nanoTime();
        int n = arr.size();
        
        // For loop to iterate through whole array, except last value because it will already be sorted by then
        for (int i = 0; i < n - 1; i ++) {
            // Define the minimum index by setting it to the first element not iterated yet
            int minIndex = i;
            super.iterations += 1;
    
            // For loop to iterate through all elements after previous run
            for (int j = i + 1; j < n; j ++) {
                super.iterations += 1;
                super.comparisons += 1;
                // If selected value is lower than current minimum, set the new minimum
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
    
            // If the minimum is different from the current value, swap them
            if (minIndex != i) {
                super.swaps.add(arr.get(minIndex));
                super.comparisons += 1;
                int temp = arr.get(i);
                super.swaps.add(temp);
                arr.set(i,arr.get(minIndex));
                arr.set(minIndex, temp);
            }
        }
        super.times.add(System.nanoTime() - startTime);
            return arr;
    }
}
