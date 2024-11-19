package com.vendadelivro.estudo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stateName;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public State() {
    }

    public State(String stateName, Country country) {
        this.stateName = stateName;
        this.country = country;
    }

    public State(Long id, String stateName, Country country) {
        this.id = id;
        this.stateName = stateName;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
