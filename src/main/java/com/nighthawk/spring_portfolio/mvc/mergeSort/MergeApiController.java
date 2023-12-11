package com.nighthawk.spring_portfolio.mvc.mergeSort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.mergeSort.ForSortMerge;
import com.nighthawk.spring_portfolio.mvc.mergeSort.RecursiveSortMerge;
import com.nighthawk.spring_portfolio.mvc.mergeSort.WhileSortMerge;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/merge")  // all requests in file begin with this URI
public class MergeApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private MergeJpaRepository repository;

    /* GET List of Jokes
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Merge>> getSorts() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/while/time")
    public ResponseEntity<Merge> whileTime(@RequestBody ArrayList<Integer> list) {

        WhileSortMerge whileSort = new WhileSortMerge();

        whileSort.runSort(list);

        repository.save(whileSort);

        return new ResponseEntity<>(whileSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/while")
    public ResponseEntity<Merge> whileSort(@RequestBody ArrayList<Integer> list) {

        WhileSortMerge whileSort = new WhileSortMerge();

        for (int i = 0; i < 10; i ++){
            whileSort.runSort(list);
        }

        Collections.sort(whileSort.times);

        whileSort.times.remove(whileSort.times.size() - 1);       
        whileSort.times.remove(whileSort.times.size() - 1);

        repository.save(whileSort);

        return new ResponseEntity<>(whileSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/for/time")
    public ResponseEntity<Merge> forTime(@RequestBody ArrayList<Integer> list) {

        ForSortMerge forSort = new ForSortMerge();

        forSort.runSort(list);

        repository.save(forSort);

        return new ResponseEntity<>(forSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/for")
    public ResponseEntity<Merge> forSort(@RequestBody ArrayList<Integer> list) {

        ForSortMerge forSort = new ForSortMerge();

        for (int i = 0; i < 10; i ++){
            forSort.runSort(list);
        }

        Collections.sort(forSort.times);

        forSort.times.remove(forSort.times.size() - 1);       
        forSort.times.remove(forSort.times.size() - 1);
        repository.save(forSort);

        return new ResponseEntity<>(forSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/recursive/time")
    public ResponseEntity<Merge> recursiveTime(@RequestBody ArrayList<Integer> list) {

        RecursiveSortMerge recursiveSort = new RecursiveSortMerge();

        recursiveSort.runSort(list, 0);

        repository.save(recursiveSort);

        return new ResponseEntity<>(recursiveSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/recursive")
    public ResponseEntity<Merge> recursiveSort(@RequestBody ArrayList<Integer> list) {

        RecursiveSortMerge recursiveSort = new RecursiveSortMerge();

        for (int i = 0; i < 10; i ++){
            recursiveSort.runSort(list, 0);
        }

        Collections.sort(recursiveSort.times);

        recursiveSort.times.remove(recursiveSort.times.size() - 1);       
        recursiveSort.times.remove(recursiveSort.times.size() - 1);
        repository.save(recursiveSort);

        return new ResponseEntity<>(recursiveSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }


}
