package com.test.superheromaintenance.repositories;

import com.test.superheromaintenance.models.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
    @Query(value = "SELECT * FROM superhero WHERE name ILIKE %:name%", nativeQuery = true)
    List<Superhero> findSuperherosWhoseNameContains(@Param("name") String name);
}
