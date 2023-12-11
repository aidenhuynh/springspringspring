package com.nighthawk.spring_portfolio.mvc.insertionSort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Collections;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/insertion")  // all requests in file begin with this URI
public class InsertionApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private InsertionJpaRepository repository;

    /* GET List of Jokes
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Insertion>> getSorts() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }


    @PostMapping("/while/time")
    public ResponseEntity<ArrayList<Long>> whileTime(@RequestBody ArrayList<Integer> list) {

        ArrayList<Long> avgTimes = new ArrayList<>();

        Collections.sort(list);

        for (Insertion i : repository.findAll()){
            if (i.getList().equals(list) && i.getName().equals("Insertion Sort While Loop")){
                avgTimes.add(i.getAvgTime());
            }
        }

        if (avgTimes.size() > 2) {
            Collections.sort(avgTimes);

            // Remove the smallest and largest values
            avgTimes.remove(0); // Remove the smallest
            avgTimes.remove(avgTimes.size() - 1); // Remove the largest
        }

        return new ResponseEntity<>(avgTimes, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/for/time")
    public ResponseEntity<ArrayList<Long>> forTime(@RequestBody ArrayList<Integer> list) {

        ArrayList<Long> avgTimes = new ArrayList<>();

        Collections.sort(list);

        for (Insertion i : repository.findAll()){
            if (i.getList().equals(list) && i.getName().equals("Insertion Sort For Loop")){
                avgTimes.add(i.getAvgTime());
            }
        }

        if (avgTimes.size() > 2) {
            Collections.sort(avgTimes);

            // Remove the smallest and largest values
            avgTimes.remove(0); // Remove the smallest
            avgTimes.remove(avgTimes.size() - 1); // Remove the largest
        }

        return new ResponseEntity<>(avgTimes, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }


    @PostMapping("/while")
    public ResponseEntity<Insertion> whileSort(@RequestBody ArrayList<Integer> list) {

        WhileSortInsertion whileSort = new WhileSortInsertion();

        for (int i = 0; i < 10; i ++){
            whileSort.runSort(list);
        }

        Collections.sort(whileSort.times);

        whileSort.times.remove(whileSort.times.size() - 1);       
        whileSort.times.remove(whileSort.times.size() - 1);

        repository.save(whileSort);

        return new ResponseEntity<>(whileSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/for")
    public ResponseEntity<Insertion> forSort(@RequestBody ArrayList<Integer> list) {

        ForSortInsertion forSort = new ForSortInsertion();

        for (int i = 0; i < 10; i ++){
            forSort.runSort(list);
        }

        Collections.sort(forSort.times);

        forSort.times.remove(forSort.times.size() - 1);       
        forSort.times.remove(forSort.times.size() - 1);

        repository.save(forSort);

        return new ResponseEntity<>(forSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

}
