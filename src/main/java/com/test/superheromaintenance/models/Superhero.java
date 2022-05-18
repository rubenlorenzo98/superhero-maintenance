package com.test.superheromaintenance.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "superhero")
@Data @AllArgsConstructor @NoArgsConstructor
public class Superhero implements Serializable {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

}
