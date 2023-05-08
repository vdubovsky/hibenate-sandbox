package io.vdubovsky.o2muni;


import org.hibernate.Session;

import java.util.List;

public class HibernateRunnerOrphanRemoval {

    // set orphanRemoval true
    public static void main(String[] args) {
        Session session = HibernateRunnerCommon.initAndGetSession();
        session.getTransaction().begin();

        var owner = session.get(Owner.class, 1L);
        List<Pet> pets = owner.getPets();

        pets.removeIf(p -> "Teddy".equals(p.getNickname()));
        session.getTransaction().commit();

        System.out.println("Pet with name 'Teddy' has been removed from DB");
    }
}
