package com.nighthawk.spring_portfolio.mvc.bubbleSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class WhileSortMerge extends Merge {
    public WhileSortMerge(){
        super("Bubble Sort While Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr){
        // While loop to iterate through whole array, except last value because it will already be sorted by then
        int i = 0;
        int n = arr.size();
        while (i < n - 1) {
            // Define the minimum index by setting it to the first element not iterated yet
            int minIndex = i;
    
            // While loop to iterate through all elements after previous run
            int j = i + 1;
            while (j < n) {
                // If selected value is lower than current minimum, set the new minimum
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
    
                j += 1;
            }
    
            // If the minimum is different from the current value, swap them
            if (minIndex != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);
            }
    
            i += 1;
        }
        
        return arr;
    }
}
