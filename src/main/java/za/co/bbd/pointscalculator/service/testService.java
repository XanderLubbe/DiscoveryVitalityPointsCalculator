package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;

import za.co.bbd.pointscalculator.model.TestModel;

@Service
public class testService {

    public TestModel getPointsService(String activity) {
        return new TestModel(50);
    }
    
}
