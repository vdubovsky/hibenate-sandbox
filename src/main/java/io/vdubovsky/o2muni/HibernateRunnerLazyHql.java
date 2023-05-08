package io.vdubovsky.o2muni;


import org.hibernate.Session;

import java.util.List;

public class HibernateRunnerLazyHql {

    // set fetch type to Lazy
    public static void main(String[] args) {
        Session session = HibernateRunnerCommon.initAndGetSession();
        session.getTransaction().begin();

        var owner = session.createQuery("select o from Owner o where o.id = 1L", Owner.class)
                .getSingleResult();
        System.out.println("Lazy fetch type, no additional requests so far");

        List<Pet> pets = owner.getPets();
        System.out.println("Pets class is : " + pets.getClass());
        System.out.println("note: since we didn't call any pets methods - still no request");

        int size = pets.size();
        System.out.println("Now we have to query pet table, since we do not know size of the collection");

        session.getTransaction().commit();
    }
}
