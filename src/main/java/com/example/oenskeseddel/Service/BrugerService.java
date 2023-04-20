package com.example.oenskeseddel.Service;

import com.example.oenskeseddel.Model.Bruger;
import com.example.oenskeseddel.Repository.BrugerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrugerService {

    @Autowired
    BrugerRepo brugerRepo;

    public void addBruger(Bruger B) {
        brugerRepo.addBruger(B);
    }

    public Bruger findBrugernavn(String brugernavn) {
        return brugerRepo.findeBrugernavn(brugernavn);
    }
}
