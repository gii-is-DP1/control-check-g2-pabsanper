package org.springframework.samples.petclinic.feeding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "feeding_types")//Falta algo en las constraints
public class FeedingType {
    @Id
    Integer id;
    @NotEmpty
    @Column(unique = true)
    @Size(min = 5, max = 30)
    String name;
    @NotEmpty
    String description;
    @ManyToOne
    @NotNull
    @NotEmpty
    @JoinColumn(name = "pet_type_id")
    PetType petType;
}
