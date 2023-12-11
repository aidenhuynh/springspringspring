package com.nighthawk.spring_portfolio.mvc.mergeSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class ForSortMerge extends Merge {
    public ForSortMerge(){
        super("Merge Sort for Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr){
        long startTime = System.nanoTime();
        int n = arr.size();
        super.list = arr;
        
        // Iterate through list
    for (int i = 0; i < n - 1; i ++) {
        // Iterate through previous element in list
        super.iterations += 1;
        for (int j = 0; j < n - i - 1; j ++) {
            // Swap if necessary
            super.iterations += 1;
            super.comparisons += 1;
            if (arr.get(j) > arr.get(j + 1)) {
                int temp = arr.get(j);
                super.swaps.add(temp);
                super.swaps.add(arr.get(j+1));
                arr.set(j, arr.get(j + 1));
                arr.set(j + 1, temp);
            }
        }
    }
    super.times.add(System.nanoTime() - startTime);
    return arr;
        
    }
}