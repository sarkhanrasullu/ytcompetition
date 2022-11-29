package com.ytwebapp.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author sarkhanrasullu
 */
@Data
@Entity
@Table(name = "channel")
public class Channel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "age")
    private int age;

    @Basic(optional = false)
    @Column(name = "bought")
    private int bought;

    @Basic(optional = false)
    @Column(name = "channel_link")
    private String channelLink;

    @Basic(optional = false)
    @Column(name = "city")
    private String city;

    @Basic(optional = false)
    @Column(name = "country")
    private String country;

    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @Column(name = "gender")
    private int gender;

    @Basic(optional = false)
    @Column(name = "marital_status")
    private int maritalStatus;

    @Basic(optional = false)
    @Column(name = "winner")
    private int winner;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Basic(optional = false)
    @Column(name = "profession")
    private String profession;

    @Basic(optional = false)
    @Column(name = "subscribers_count")
    private int subscribersCount;

    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;

    @CreationTimestamp
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedOn;

    @JsonIgnore
    @OneToMany(mappedBy = "channelId", fetch = FetchType.LAZY)
    private List<ChannelCompetition> channelCompetitionList;

}