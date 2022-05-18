package com.test.superheromaintenance.controllers;

import com.test.superheromaintenance.models.Superhero;
import com.test.superheromaintenance.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superheroController")
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

    @GetMapping("/getAllSuperheroes")
    @ResponseBody
    public ResponseEntity<Superhero> getAllSuperheroes() {
        return new ResponseEntity(superheroService.getAllSuperheroes(), HttpStatus.OK);
    }

    @GetMapping("/getSuperheroById/{id}")
    @ResponseBody
    public ResponseEntity<Superhero> getSuperheroById(@PathVariable("id") Long id) {
        return new ResponseEntity(superheroService.getSuperheroById(id), HttpStatus.OK);
    }

    @GetMapping("/getSuperherosWhoseNameContains/{name}")
    @ResponseBody
    public ResponseEntity<Superhero> getSuperherosWhoseNameContains(@PathVariable("name") String name) {
        return new ResponseEntity(superheroService.getSuperherosWhoseNameContains(name), HttpStatus.OK);
    }

    @PutMapping("/modifySuperhero/{id}")
    public ResponseEntity modifySuperhero(@PathVariable("id") Long id, @RequestBody Superhero superhero) {
        Superhero superheroModified = superheroService.modifySuperhero(id, superhero);
        if (superheroModified != null) {
            return new ResponseEntity(superheroModified, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Failed to modify superhero with id = %d.", id));
        }
    }

    @DeleteMapping(path = "/deleteSuperhero/{id}")
    public ResponseEntity deleteSuperhero(@PathVariable("id") Long id) {
        Boolean isSuperheroDeleted = superheroService.deleteSuperhero(id);
        if (isSuperheroDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Failed to delete superhero with id = %d.", id));
        }
    }

}
