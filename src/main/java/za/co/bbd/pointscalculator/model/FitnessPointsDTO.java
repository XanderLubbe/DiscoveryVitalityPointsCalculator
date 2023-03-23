package za.co.bbd.pointscalculator.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name="FITNESS_POINTS")
// change all of these to suit your needs
public record FitnessPointsDTO (
    @Id @GeneratedValue(strategy = GenerationType.AUTO) Long Id,
    String activity,
    int points
){}


