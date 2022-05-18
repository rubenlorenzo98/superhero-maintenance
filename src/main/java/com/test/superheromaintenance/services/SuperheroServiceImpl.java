package com.test.superheromaintenance.services;

import com.test.superheromaintenance.models.Superhero;
import com.test.superheromaintenance.repositories.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuperheroServiceImpl implements SuperheroService {

    @Autowired
    private SuperheroRepository superheroRepository;

    @Override
    public List<Superhero> getAllSuperheroes() {
        return superheroRepository.findAll();
    }

    @Override
    public Superhero getSuperheroById(Long id) {
        return superheroRepository.findById(id).orElse(null);
    }

    @Override
    public List<Superhero> getSuperherosWhoseNameContains(String name) {
        List<Superhero> superheroesList = superheroRepository.findSuperherosWhoseNameContains(name);
        return superheroesList != null ? superheroesList : new ArrayList<Superhero>();
    }

    @Override
    public Superhero modifySuperhero(Long id, Superhero modifiedSuperhero) {
        Superhero superhero = superheroRepository.findById(id).orElse(null);
        if (superhero != null) {
            superhero.setName(modifiedSuperhero.getName());
            return superheroRepository.save(superhero);
        } else {
            return null;
        }
    }

    @Override
    public Boolean deleteSuperhero(Long id) {
        try {
            superheroRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
