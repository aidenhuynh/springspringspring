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

        ArrayList<Long> times = new ArrayList<>();

        Collections.sort(list);

        for (Insertion i : repository.findAll()){
            if (i.getList().equals(list) && i.getName().equals("Insertion Sort While Loop")){
                times.add(i.getTimes().get(0));
            }
        }

        if (times.size() > 2) {
            Collections.sort(times);

            // Remove the smallest and largest values
            times.remove(0); // Remove the smallest
            times.remove(times.size() - 1); // Remove the largest
        }

        return new ResponseEntity<>(times, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

    @PostMapping("/while")
    public ResponseEntity<Insertion> whileSort(@RequestBody ArrayList<Integer> list) {

        WhileSort whileSort = new WhileSort();

        whileSort.runSort(list);

        repository.save(whileSort);

        return new ResponseEntity<>(whileSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

}
