package io.vdubovsky.m2ouni;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Accessors(chain = true)
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private UUID chipId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Owner owner;

    @Enumerated(EnumType.STRING)
    private PetType petType;
}
