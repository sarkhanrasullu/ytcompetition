package com.ytwebapp.restcontroller;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ytwebapp.entity.Channel;
import com.ytwebapp.entity.ChannelCompetition;
import com.ytwebapp.entity.Competition;
import com.ytwebapp.repository.ChannelCompetitionRepository;
import com.ytwebapp.repository.CompetitionRepository;
import com.ytwebapp.service.ChannelService;

@RestController
@RequestMapping("competitions")
public class CompetitionRestController {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private ChannelCompetitionRepository channelCompetitionRepository;

    @Autowired
    private ChannelService channelService;

    @GetMapping("/{id}")
    public Competition getItem(@PathVariable(required = false, name = "id") Integer id) {
        return competitionRepository.getReferenceById(id);
    }




}
