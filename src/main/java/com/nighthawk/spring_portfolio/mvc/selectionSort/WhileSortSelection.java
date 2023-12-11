package com.nighthawk.spring_portfolio.mvc.selectionSort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;


@Entity
public class WhileSortSelection extends Selection {
    public WhileSortSelection(){
        super("Insertion Sort While Loop");
    }

    public ArrayList<Integer> runSort(ArrayList<Integer> arr){
        long startTime = System.nanoTime();
        int n = arr.size();
        int i = 1;
        
        while (i < n) {
            int key = arr.get(i);
            int j = i - 1;
            super.iterations += 1;

            while (j >= 0 && arr.get(j) > key) {
                super.swaps.add(arr.get(j));
                super.swaps.add(key);
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
