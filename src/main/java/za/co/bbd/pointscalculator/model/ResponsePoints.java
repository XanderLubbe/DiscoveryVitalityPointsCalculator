package za.co.bbd.pointscalculator.model;

import lombok.Getter;

@Getter
public class ResponsePoints {

    private int points;
    
    public ResponsePoints(int points){
        this.points = points;
    }
}
