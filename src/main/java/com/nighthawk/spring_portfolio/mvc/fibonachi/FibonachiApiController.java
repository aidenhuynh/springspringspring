package com.nighthawk.spring_portfolio.mvc.fibonachi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.fibonachi.ForFibonachi;
import com.nighthawk.spring_portfolio.mvc.fibonachi.Fibonachi;
import com.nighthawk.spring_portfolio.mvc.fibonachi.RecursiveFibonachi;
import com.nighthawk.spring_portfolio.mvc.fibonachi.WhileFibonachi;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/fibonachi")  // all requests in file begin with this URI
public class FibonachiApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private FibonachiJpaRepository repository;

    /* GET List of Jokes
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Fibonachi>> getFibos() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/while")
    public ResponseEntity<Fibonachi> whileFibo(@RequestBody int num) {

        WhileFibonachi whileFibo = new WhileFibonachi();

        for (int i = 0; i < 10; i ++){
            whileFibo.runFibo(num);
        }

        Collections.sort(whileFibo.times);

        whileFibo.times.remove(whileFibo.times.size() - 1);       
        whileFibo.times.remove(whileFibo.times.size() - 1);

        repository.save(whileFibo);

        return new ResponseEntity<>(whileFibo, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/for")
    public ResponseEntity<Fibonachi> forFibo(@RequestBody int num) {

        ForFibonachi forFibo = new ForFibonachi();

        for (int i = 0; i < 10; i ++){
            forFibo.runFibo(num);
        }

        Collections.sort(forFibo.times);

        forFibo.times.remove(forFibo.times.size() - 1);       
        forFibo.times.remove(forFibo.times.size() - 1);
        repository.save(forFibo);

        return new ResponseEntity<>(forFibo, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/recursive")
    public ResponseEntity<Fibonachi> recursiveFibo(@RequestBody int num) {

        RecursiveFibonachi recursiveFibo = new RecursiveFibonachi();

        for (int i = 0; i < 10; i ++){
            recursiveFibo.runFibo(num);
        }

        Collections.sort(recursiveFibo.times);

        recursiveFibo.times.remove(recursiveFibo.times.size() - 1);       
        recursiveFibo.times.remove(recursiveFibo.times.size() - 1);
        repository.save(recursiveFibo);

        return new ResponseEntity<>(recursiveFibo, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

}
