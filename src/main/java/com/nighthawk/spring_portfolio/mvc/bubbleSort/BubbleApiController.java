package com.nighthawk.spring_portfolio.mvc.bubbleSort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.bubbleSort.ForSortBubble;
import com.nighthawk.spring_portfolio.mvc.bubbleSort.Bubble;
import com.nighthawk.spring_portfolio.mvc.bubbleSort.RecursiveSortBubble;
import com.nighthawk.spring_portfolio.mvc.bubbleSort.WhileSortBubble;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/bubble")  // all requests in file begin with this URI
public class BubbleApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private BubbleJpaRepository repository;

    /* GET List of Jokes
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Bubble>> getSorts() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }


    @PostMapping("/while/time")
    public ResponseEntity<Bubble> whileTime(@RequestBody ArrayList<Integer> list) {

        WhileSortBubble whileSort = new WhileSortBubble();

        whileSort.runSort(list);

        repository.save(whileSort);

        return new ResponseEntity<>(whileSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/while")
    public ResponseEntity<Bubble> whileSort(@RequestBody ArrayList<Integer> list) {

        WhileSortBubble whileSort = new WhileSortBubble();

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
    public ResponseEntity<Bubble> forTime(@RequestBody ArrayList<Integer> list) {

        ForSortBubble forSort = new ForSortBubble();

        forSort.runSort(list);

        repository.save(forSort);

        return new ResponseEntity<>(forSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/for")
    public ResponseEntity<Bubble> forSort(@RequestBody ArrayList<Integer> list) {

        ForSortBubble forSort = new ForSortBubble();

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
    public ResponseEntity<Bubble> recursiveTime(@RequestBody ArrayList<Integer> list) {

        RecursiveSortBubble recursiveSort = new RecursiveSortBubble();

        recursiveSort.runSort(list, 0);

        repository.save(recursiveSort);

        return new ResponseEntity<>(recursiveSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/recursive")
    public ResponseEntity<Bubble> recursiveSort(@RequestBody ArrayList<Integer> list) {

        RecursiveSortBubble recursiveSort = new RecursiveSortBubble();

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
