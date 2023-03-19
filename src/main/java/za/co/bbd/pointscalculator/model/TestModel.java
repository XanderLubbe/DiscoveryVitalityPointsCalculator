package za.co.bbd.pointscalculator.model;

import lombok.Getter;

@Getter
public class TestModel {
    private int amount = 50;

    public TestModel(int amount){
        this.amount = amount;
    }
}
