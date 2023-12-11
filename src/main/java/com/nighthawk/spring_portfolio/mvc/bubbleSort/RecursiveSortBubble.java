package com.nighthawk.spring_portfolio.mvc.bubbleSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class RecursiveSortBubble extends Bubble {
    public RecursiveSortBubble(){
        super("Bubble Sort Recursive Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr, int n){
        long startTime = System.nanoTime();
        super.list = arr;
        int k = arr.size();

        // If passing the last element in the array, stop
        super.comparisons += 1;
        if (n == k - 1) {
            return arr;
        }
        
        // Set minimum index to current
        int minIndex = n;
        
        // If different value is less than current minimum, set minIndex to that value's index
        for (int j = n + 1; j < k; j++) {
            super.iterations += 1;
            super.comparisons += 1;
            if (arr.get(j) < arr.get(minIndex)) {
                minIndex = j;
            }
        }
        
        // Swap minimum with initial index
        super.comparisons += 1;
        if (minIndex != n) {
            int temp = arr.get(n);
            super.swaps.add(temp);
            super.swaps.add(arr.get(minIndex));
            arr.set(n, arr.get(minIndex));
            arr.set(minIndex, temp);
        }
        
        // Recursive call for the next index
        super.iterations += 1;
        runSort(arr, n + 1, startTime);
        
        return arr;
    }

        public ArrayList<Integer> runSort(ArrayList<Integer> arr, int n, long startTime){
        int k = arr.size();

        // If passing the last element in the array, stop
        super.comparisons += 1;
        if (n == k - 1) {
            super.times.add(System.nanoTime() - startTime);
            return arr;
        }
        
        // Set minimum index to current
        int minIndex = n;
        
        // If different value is less than current minimum, set minIndex to that value's index
        for (int j = n + 1; j < k; j++) {
            super.iterations += 1;
            super.comparisons += 1;
            if (arr.get(j) < arr.get(minIndex)) {
                minIndex = j;
            }
        }
        
        // Swap minimum with initial index
        super.comparisons += 1;
        if (minIndex != n) {
            int temp = arr.get(n);
            super.swaps.add(temp);
            super.swaps.add(arr.get(minIndex));
            arr.set(n, arr.get(minIndex));
            arr.set(minIndex, temp);
        }
        
        // Recursive call for the next index
        super.iterations += 1;
        runSort(arr, n + 1, startTime);
        
        return arr;
    }

}

