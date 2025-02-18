package com.tattoostudio.rest.Controller;

import com.tattoostudio.rest.Models.Visit;
import com.tattoostudio.rest.Repositories.VisitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class ApiControllers {

    @Autowired
    VisitRepository visitRepository;

    @GetMapping
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    @PostMapping
    public String saveVisit(@RequestBody Visit visit) {
        visitRepository.save(visit);
        return "Saved";
    }

    @PutMapping("/{id}")
    public String updateVisit(@PathVariable int id, @RequestBody Visit visitDetails) {
        visitRepository.findById(id).map(visit -> {
            visit.setName(visitDetails.getName());
            visit.setSurname(visitDetails.getSurname());
            visit.setEmail(visitDetails.getEmail());
            visit.setVisit_type(visitDetails.getVisit_type());
            visit.setVisit_date(visitDetails.getVisit_date());
            return visitRepository.save(visit);
        });
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteVisit(@PathVariable int id) {
        visitRepository.deleteById(id);
        return "Deleted visit with id: " + id;
    }
}