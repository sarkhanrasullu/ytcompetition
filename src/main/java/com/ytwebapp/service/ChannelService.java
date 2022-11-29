package com.ytwebapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ytwebapp.entity.Channel;
import com.ytwebapp.repository.ChannelRepository;

@Service
public class ChannelService {

    private final ChannelRepository repository;

    public ChannelService(final ChannelRepository repository) {
        this.repository = repository;
    }

    public Channel add(Channel channel) {
        return repository.save(channel);
    }

    public void deleteById(final Integer id) {
        repository.deleteById(id);
    }

    public Channel findById(Integer id) {
        return repository.getReferenceById(id);
    }

    public List<Channel> getList(
        String name,
        String surname,
        String channelLink,
        Integer age,
        String country,
        String city,
        String profession,
        Integer bought,
        Integer subscribersCount,
        Integer gender,
        String phone,
        Integer maritalStatus,
        String email,
        Integer winner
    ) {
        final Specification<Channel> specification = (Specification<Channel>)(root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && name.trim().length() > 0) {
                predicates.add(cb.like(root.get("name").as(String.class), "%" + name + "%"));
            }

            if (surname != null && surname.trim().length() > 0) {
                predicates.add(cb.like(root.get("surname").as(String.class), "%" + surname + "%"));
            }

            if (email != null && email.trim().length() > 0) {
                predicates.add(cb.like(root.get("email").as(String.class), "%" + email + "%"));
            }

            if (phone != null && phone.trim().length() > 0) {
                predicates.add(cb.like(root.get("phone").as(String.class), "%" + phone + "%"));
            }

            if (bought != null) {
                predicates.add(cb.equal(root.get("bought").as(Integer.class), bought));
            }

            if (profession != null && profession.trim().length() > 0) {
                predicates.add(cb.like(root.get("profession").as(String.class), "%" + profession + "%"));
            }

            if (country != null && country.trim().length() > 0) {
                predicates.add(cb.like(root.get("country").as(String.class), "%" + country + "%"));
            }

            if (city != null && city.trim().length() > 0) {
                predicates.add(cb.like(root.get("city").as(String.class), "%" + city + "%"));
            }

            if (channelLink != null && channelLink.trim().length() > 0) {
                predicates.add(cb.like(root.get("channelLink").as(String.class), "%" + channelLink + "%"));
            }

            if (age != null) {
                predicates.add(cb.equal(root.get("age").as(Integer.class), age));
            }

            if (subscribersCount != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("subscribersCount").as(Integer.class), subscribersCount));
            }

            if (gender != null) {
                predicates.add(cb.equal(root.get("gender").as(Integer.class), gender));
            }

            if (maritalStatus != null) {
                predicates.add(cb.equal(root.get("maritalStatus").as(Integer.class), maritalStatus));
            }

            if (winner != null) {
                predicates.add(cb.equal(root.get("winner").as(Integer.class), winner));
            }

            return cb.and(predicates.toArray(new Predicate[] {}));
        };

        return repository.findAll(specification);
    }

    public Channel update(final Channel channel) {
        return repository.save(channel);
    }

}
