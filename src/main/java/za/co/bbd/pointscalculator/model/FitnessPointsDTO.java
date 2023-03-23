package za.co.bbd.pointscalculator.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name="FITNESS_POINTS")
@Getter
// change all of these to suit your needs
public class FitnessPointsDTO {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long Id;
    private String activity;
    private int points;
}


