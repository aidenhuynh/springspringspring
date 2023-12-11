package com.nighthawk.spring_portfolio.mvc.selectionSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class ForSortSelection extends Selection {
    public ForSortSelection(){
        super("Insertion Sort for Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr){
        super.Swaps.clear();
        super.iterations = 0;
        super.comparisons = 0;
        long startTime = System.nanoTime();
        int n = arr.size();
        
        // For loop to iterate through whole array, except last value because it will already be sorted by then
        for (int i = 0; i < n - 1; i ++) {
            // Define the minimum index by setting it to the first element not iterated yet
            int minIndex = i;
    
            // For loop to iterate through all elements after previous run
            for (int j = i + 1; j < n; j ++) {
                // If selected value is lower than current minimum, set the new minimum
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
    
            // If the minimum is different from the current value, swap them
            if (minIndex != i) {
                super.Swaps.add(arr.get(j));
                super.Swaps.add(i);
                super.iterations += 1;
                super.comparisons += 1;

                int temp = arr.get(i);
                arr.set(i,arr.get(minIndex));
                arr.set(minIndex, temp);
            }
        }
        
            return arr;
    }
        
        
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
