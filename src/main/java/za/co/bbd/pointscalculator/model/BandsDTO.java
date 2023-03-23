package za.co.bbd.pointscalculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity(name="VITALITY_BANDS")
@Getter
public class BandsDTO {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long Id;
    private int lowerLimit;
    private int upperLimit;
    private String band;
}


