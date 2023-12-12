package com.nighthawk.spring_portfolio.mvc.fibonachi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import jakarta.persistence.*;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public abstract class Fibonachi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String name;
    public ArrayList<Long> list = new ArrayList<>();
    public ArrayList<Long> times = new ArrayList<>();

    public Fibonachi(String name){
        this.name = name;
    }

    abstract void runFibo(int n);

    public long getAvgTime(){
        long sum = 0;
        for (long i : times){
            sum += i;
        }
        return sum/times.size();
    }

}
