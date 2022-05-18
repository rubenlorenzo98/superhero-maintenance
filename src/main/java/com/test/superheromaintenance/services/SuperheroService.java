package com.test.superheromaintenance.services;

import com.test.superheromaintenance.models.Superhero;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.util.List;

public interface SuperheroService {

    /**
     * Get all the superheroes.
     * @return List of superheroes(empty list if none exist)
     */
    List<Superhero> getAllSuperheroes();

    /**
     * Get a single superhero querying by id.
     * @param id Superhero id to search
     * @return A single superhero(null if none exist)
     */
    Superhero getSuperheroById(Long id);

    /**
     * Get all the superheroes that contains in their name the value that is passed by parameter.
     * @param name Text fragment to search
     * @return List of superheroes(empty list if none exist)
     */
    List<Superhero> getSuperherosWhoseNameContains(String name);

    /**
     * Modify a superhero.
     * @param id Id of the superhero to modify
     * @param superhero Superhero to modify
     * @return Modified superhero(null if no superhero exists for the id)
     */
    Superhero modifySuperhero(Long id, Superhero superhero);

    /**
     * Delete a superhero.
     * @param id Id of the superhero to delete
     * @return true if it could be deleted or false otherwise
     */
    Boolean deleteSuperhero(Long id);

}
