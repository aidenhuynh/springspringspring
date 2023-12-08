package com.nighthawk.spring_portfolio.mvc.insertionSort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

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


    @PostMapping("/while")
    public ResponseEntity<Insertion> whileSort(@RequestBody ArrayList<Integer> list) {

        WhileSort whileSort = new WhileSort();

        whileSort.runSort(list);

        return new ResponseEntity<>(whileSort, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
    }

}
