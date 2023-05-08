package io.vdubovsky.o2muni;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String address;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = false)
    @JoinColumn(name = "owner_id")
    private List<Pet> pets = new ArrayList<>();
}
