package za.co.bbd.pointscalculator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestModel {
    private int amount = 50;
    private int otherAmount = 50;


    public TestModel(int amount, int otherAmount){
        this.amount = amount;
        this.otherAmount = otherAmount;

    }
}
