package io.vdubovsky.o2muni;


import org.hibernate.Session;

import java.util.List;

public class HibernateRunnerEagerId {

    // set fetch type Eager
    public static void main(String[] args) {
        Session session = HibernateRunnerCommon.initAndGetSession();
        session.getTransaction().begin();

        var owner = session.get(Owner.class, 1L);
        System.out.println("Eager fetch type with id, no additional requests, using join");

        List<Pet> pets = owner.getPets();
        System.out.println("Pets class is : " + pets.getClass()); //interesting, even though list is initialized it is Persistent bag

        int size = pets.size();
        System.out.println("Now we don't have to query pet table, since we know size of the collection");

        session.getTransaction().commit();
    }
}
