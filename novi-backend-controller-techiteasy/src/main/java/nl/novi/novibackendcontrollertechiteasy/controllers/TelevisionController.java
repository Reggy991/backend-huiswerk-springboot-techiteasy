package nl.novi.novibackendcontrollertechiteasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TelevisionController {
    ArrayList<String> televisions = new ArrayList<String>();
    int id;
    ResponseEntity<Object> ResponseEntiteit;

    @GetMapping ("/show-all")
    public ArrayList<String> showAllTVs() {
        return televisions;
    }

    @GetMapping ("/show")
    public String showTV(@RequestParam int index) {
        if (index < televisions.size()) {
            return televisions.get(index);
        } else {
            return "No television found.";
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTV(@RequestParam String name) {
        televisions.add(name);
        return ResponseEntity.created(null).body("television");
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTV(@PathVariable int id, @RequestBody String newName) {
        return ResponseEntity.ok("television");
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTV(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }
}
