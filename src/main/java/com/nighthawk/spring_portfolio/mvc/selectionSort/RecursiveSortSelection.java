package com.nighthawk.spring_portfolio.mvc.selectionSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class RecursiveSortSelection extends Selection {
    public RecursiveSortSelection(){
        super("Selection Sort Recursive Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr, int n){
        long startTime = System.nanoTime();
        super.list = arr;
        super.iterations += 1;
        // If passing the last element in the array, stop
        if (n == arr.size() - 1) {
            return arr;
        }
        
        // Set minimum index to current
        int minIndex = n;
        
        // If different value is less than current minimum, set minIndex to that value's index
        for (int j = n + 1; j < arr.size(); j++) {
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
            super.swaps.add(arr.get(minIndex));
            super.swaps.add(temp);
            arr.set(n, arr.get(minIndex));
            arr.set(minIndex, temp);
        }
        
        // Recursive call for the next index
        runSort(arr, n + 1, startTime);
        
        return arr;
    }
    
    public ArrayList<Integer> runSort(ArrayList<Integer> arr, int n, long startTime){
        super.iterations += 1;
        // If passing the last element in the array, stop
        if (n == arr.size() - 1) {
            super.times.add((System.nanoTime() - startTime));
            return arr;
        }
        
        // Set minimum index to current
        int minIndex = n;
        
        // If different value is less than current minimum, set minIndex to that value's index
        for (int j = n + 1; j < arr.size(); j++) {
            super.iterations += 1;
            super.comparisons += 1;
            if (arr.get(j) < arr.get(minIndex)) {
                minIndex = j;
            }
        }
        
        // Swap minimum with initial index
        if (minIndex != n) {
            int temp = arr.get(n);
            super.swaps.add(arr.get(minIndex));
            super.swaps.add(temp);
            arr.set(n, arr.get(minIndex));
            arr.set(minIndex, temp);
        }
        
        // Recursive call for the next index
        runSort(arr, n + 1, startTime);
        
        return arr;
    }
    
}

