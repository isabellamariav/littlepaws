package nl.vet.littlepaws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue
    private long Id;
    private String name;
    private String typeOfAnimal;
    private char gender;
    private int age;
    private double weight;

    // relations;
    @ManyToOne()
    private Client client;

    @ManyToMany()
    private Appointment appointment;
}
