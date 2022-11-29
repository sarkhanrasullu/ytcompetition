package com.ytwebapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.experimental.Accessors;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "channel_competition")
public class ChannelCompetition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @CreationTimestamp
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedOn;

    @Basic(optional = false)
    @Column(name = "winner")
    private int winner;

    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Competition competitionId;

    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Channel channelId;

    public Integer getId() {
        return id;
    }

    public ChannelCompetition setId(final Integer id) {
        this.id = id;
        return this;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public ChannelCompetition setCreatedOn(final Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public ChannelCompetition setUpdatedOn(final Date updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public int getWinner() {
        return winner;
    }

    public ChannelCompetition setWinner(final int winner) {
        this.winner = winner;
        return this;
    }

    public Competition getCompetitionId() {
        return competitionId;
    }

    public ChannelCompetition setCompetitionId(final Competition competitionId) {
        this.competitionId = competitionId;
        return this;
    }

    public Channel getChannelId() {
        return channelId;
    }

    public ChannelCompetition setChannelId(final Channel channelId) {
        this.channelId = channelId;
        return this;
    }

}

