package io.vdubovsky.o2muni;

import io.vdubovsky.m2ouni.Owner;
import io.vdubovsky.m2ouni.PetType;
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

    @Enumerated(EnumType.STRING)
    private PetType petType;
}
