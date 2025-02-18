package com.tattoostudio.rest.Repositories;

import com.tattoostudio.rest.Models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

}
