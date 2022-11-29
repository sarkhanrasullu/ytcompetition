package com.ytwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ytwebapp.entity.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer> {

}
