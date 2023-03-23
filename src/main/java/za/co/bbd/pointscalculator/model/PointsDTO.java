package za.co.bbd.pointscalculator.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name="VITALITY_POINTS")
@Getter
public class PointsDTO {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long Id;
    private String activity;
    private int points;
}


