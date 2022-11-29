package com.ytwebapp.restcontroller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ytwebapp.entity.Channel;
import com.ytwebapp.service.ChannelService;

@RestController
@RequestMapping("channels")
public class ChannelRestController {

    private static final Random random = new Random();

    @Autowired
    private ChannelService channelService;

    @GetMapping
    public List<Channel> getList(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String surname,
        @RequestParam(required = false) String channelLink,
        @RequestParam(required = false) Integer age,
        @RequestParam(required = false) String country,
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String profession,
        @RequestParam(required = false) Integer bought,
        @RequestParam(required = false) Integer subscribersCount,
        @RequestParam(required = false) Integer gender,
        @RequestParam(required = false) String phone,
        @RequestParam(required = false) Integer maritalStatus,
        @RequestParam(required = false) String email) {
        return channelService.getList(
            name,
            surname,
            channelLink,
            age,
            country,
            city,
            profession,
            bought,
            subscribersCount,
            gender,
            phone,
            maritalStatus,
            email,
            null);
    }

    @GetMapping("/{id}")
    public Channel getItem(@PathVariable(required = false, name = "id") Integer id) {
        return channelService.findById(id);
    }

    @PostMapping
    public Channel add(@RequestBody Channel channel) {
        return channelService.add(channel);
    }

    @GetMapping("winner")
    public Channel getWinner(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String surname,
        @RequestParam(required = false) String channelLink,
        @RequestParam(required = false) Integer age,
        @RequestParam(required = false) String country,
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String profession,
        @RequestParam(required = false) Integer bought,
        @RequestParam(required = false) Integer subscribersCount,
        @RequestParam(required = false) Integer gender,
        @RequestParam(required = false) String phone,
        @RequestParam(required = false) Integer maritalStatus,
        @RequestParam(required = false) String email) {
        final List<Channel> channels = channelService.getList(
            name,
            surname,
            channelLink,
            age,
            country,
            city,
            profession,
            bought,
            subscribersCount,
            gender,
            phone,
            maritalStatus,
            email,
            0);

        if(channels.isEmpty()) return new Channel();

        final int randomIndex = random.nextInt(channels.size());
        final Channel channel = channels.get(randomIndex);
        channel.setWinner(1);

        channelService.update(channel);

        return channel;
    }

    @PutMapping
    public Boolean update(@RequestBody Channel channel) {
        return channelService.update(channel)!= null;
    }

    @DeleteMapping
    public Boolean delete(@RequestParam Integer id) {
        channelService.deleteById(id);
        return true;
    }

}
