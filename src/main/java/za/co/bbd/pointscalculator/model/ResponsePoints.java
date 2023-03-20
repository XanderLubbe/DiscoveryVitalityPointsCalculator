package za.co.bbd.pointscalculator.model;

import lombok.Getter;

@Getter
public class ResponsePoints {
    
    private final int points;
    
    public ResponsePoints(int points){
        this.points = points;
    }
}
