package com.udacity.jdnd.course3.critter.pet.entities;

import com.udacity.jdnd.course3.critter.pet.PetType;
import com.udacity.jdnd.course3.critter.schedule.entities.Schedule;
import com.udacity.jdnd.course3.critter.user.entities.Customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PetType type;

    private String name;

    private LocalDate birthDate;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Customer owner;

    @ManyToMany(mappedBy = "pets", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Schedule> schedules;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public PetType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public Customer getOwner() {
        return owner;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setType(PetType petType) {
        this.type = petType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
