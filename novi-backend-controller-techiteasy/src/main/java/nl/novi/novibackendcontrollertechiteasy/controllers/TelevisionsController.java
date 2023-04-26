package nl.novi.novibackendcontrollertechiteasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/television")
public class TelevisionsController {
    ArrayList<String> televisions = new ArrayList<String>();
    int id;
    ResponseEntity<Object> ResponseEntiteit;

    @GetMapping ("/all")
    public ResponseEntity<Object> showAllTVs() {
        // Ok code 200
        return ResponseEntity.ok("All televisions");
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> showTV(@PathVariable int id) {
        // Ok code 200
        return ResponseEntity.ok("Television " + id);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addTV(@RequestBody String television) {
        televisions.add(television);
        return ResponseEntity.created(null).body(television);
    }

    @PutMapping("/update/{id}")
    // Normaal gesproken bij @RequestBody voer je hier geen String in maar een datatype.naam (bijv. Television.television).
    public ResponseEntity<Object> updateTV(@PathVariable int id, @RequestBody String newTelevision) {
        return ResponseEntity.accepted().body(newTelevision + " " + id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTV(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }
}
