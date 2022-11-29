package com.ytwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ytwebapp.entity.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer>, JpaSpecificationExecutor<Channel> {

    @Query(value = "select t from Channel t where t.name=:name and t.surname=:surname")
    List<Channel> findAllByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    Channel findByNameAndSurname(String name, String surname);

    List<Channel> findAllByNameAndSurnameOrderByIdDesc(String name, String surname);

}
