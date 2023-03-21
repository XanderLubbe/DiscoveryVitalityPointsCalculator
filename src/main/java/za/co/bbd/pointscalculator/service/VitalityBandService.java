package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;

@Service
public class VitalityBandService {

    public String getBand(int points){
        if (0 < points & points < 7500){
            return  "Blue";
        } else if (7500 < points & points < 25000){
            return "Bronze";
        } else if (25000 < points & points < 40000){
            return "Silver";
        } else if (40000 < points & points < 50000){
            return "Gold";
        } else if (points > 50000){
            return "Diamond";
        } 
        return "Unable to determine vitality band.";
    }
    
}
