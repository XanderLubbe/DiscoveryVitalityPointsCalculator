package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;
import za.co.bbd.pointscalculator.repository.BandsRepository;

@Service
public class VitalityBandService {

    private final BandsRepository bandsRepository;

    public VitalityBandService(BandsRepository bandsRepository){
        this.bandsRepository = bandsRepository;
    }

    public String getBand(int points){
        String result = bandsRepository.findVitalityBand(points).getBand();
        return (result);
    }
    
}
