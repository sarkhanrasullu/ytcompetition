package com.ytwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ytwebapp.entity.ChannelCompetition;

@Repository
public interface ChannelCompetitionRepository extends JpaRepository<ChannelCompetition, Integer> {

    @Query("select c from ChannelCompetition c where c.competitionId.id=:competitionId and c.winner<>1")
    List<ChannelCompetition> getWinner(@Param("competitionId") Integer competitionId);
}
