package com.nighthawk.spring_portfolio.mvc.bubbleSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class RecursiveSortBubble extends Bubble {
    public RecursiveSortBubble(){
        super("Insertion Sort Recursive Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr, int n){
        super.Swaps.clear();
        super.iterations = 0;
        super.comparisons = 0;
        long startTime = System.nanoTime();

        // If passing the last element in the array, stop
        if (n == arr.size() - 1) {
            return arr;
        }
        
        // Set minimum index to current
        int minIndex = n;
        
        // If different value is less than current minimum, set minIndex to that value's index
        for (int j = n + 1; j < arr.length; j++) {
            if (arr.get(j) < arr.get(minIndex)) {
                minIndex = j;
            }
        }
        
        // Swap minimum with initial index
        if (minIndex != n) {
            int temp = arr.get(n);
            arr.set(n, arr.get(minIndex));
            arr.set(minIndex, temp);
        }
        
        // Recursive call for the next index
        bubbleRecur(arr, n + 1);
        
        return arr;
    }
    
}

