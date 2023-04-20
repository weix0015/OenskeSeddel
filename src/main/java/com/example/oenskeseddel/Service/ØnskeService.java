package com.example.oenskeseddel.Service;

import com.example.oenskeseddel.Model.Ønske;
import com.example.oenskeseddel.Repository.BrugerRepo;
import com.example.oenskeseddel.Repository.ØnskeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ØnskeService {
    @Autowired
    ØnskeRepo ønskeRepo;


    public List<Ønske> fetchAll() {
        return ønskeRepo.fetchAll();
    }

    public List<Ønske> fetchUserWishes(int userId) {
        return ønskeRepo.fetchUserWishes(userId);
    }
     // add method in the service.
    public void addØnske(Ønske ø) {
        ønskeRepo.addØnske(ø);
    }
   // This method will finde the ønske.
    public Ønske findeØnske(int id) {
        return ønskeRepo.findeØnske(id);
    }
    // The delete method.
    public Boolean sletOenske(int id) {
        return ønskeRepo.sletOenske(id);
    }

    public void opdaterOenske(int id, Ønske ø) {
        ønskeRepo.opdaterOenske(id, ø);
    }
}
