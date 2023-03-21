package za.co.bbd.pointscalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Table;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@EntityScan
// @Table(name = TPOINTS_TABLE)
@Table(appliesTo = "POINTS_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class pointsDTO {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    private String pointName;
    private int points;

    public pointsDTO(String pointName, int points){

    }
    
}


