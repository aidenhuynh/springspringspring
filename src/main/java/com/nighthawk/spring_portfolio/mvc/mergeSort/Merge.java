package com.nighthawk.spring_portfolio.mvc.bubbleSort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public abstract class Merge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String name;
    public ArrayList<Integer> list = new ArrayList<>();
    public int comparisons = 0;
    public ArrayList<Long> times = new ArrayList<>();
    public int iterations;
    public ArrayList<Integer> Swaps = new ArrayList<>();

    public Merge(String name){
        this.name = name;
    }

    public long getAvgTime(){
        long sum = 0;
        for (long i : times){
            sum += i;
        }
        return sum/times.size();
    }

}
