package com.test.superheromaintenance.services;

import com.test.superheromaintenance.models.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SuperheroServiceTest {

    @Autowired
    private SuperheroService superheroService;

    /**
     * Check that the superhero is modified correctly.
     */
    @Test
    void modifySuperhero() {
        final String testingName = "TESTING_NAME";
        final Long idSuperhero = 1L;
        superheroService.modifySuperhero(idSuperhero, new Superhero(idSuperhero, testingName));
        Superhero superheroModified = superheroService.getSuperheroById(idSuperhero);

        assertEquals(testingName, superheroModified.getName());
    }

}
