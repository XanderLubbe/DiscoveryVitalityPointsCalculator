package za.co.bbd.pointscalculator.model;

import lombok.Getter;

@Getter
public class Activity {


    private int id;
    private String name;
    private String condition;
    private int points;
    public Activity(int id, String name, String condition, int points) {
        this.id = id;
        this.name = name;
        this.condition = condition;
        this.points = points;
    }
}
