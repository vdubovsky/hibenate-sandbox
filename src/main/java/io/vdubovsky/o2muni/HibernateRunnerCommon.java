package io.vdubovsky.o2muni;

import io.vdubovsky.configuration.HibernateUtils;
import io.vdubovsky.m2ouni.PetType;
import lombok.experimental.UtilityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class HibernateRunnerCommon {

    public Session initAndGetSession() {

        System.out.println("************************************************************************");

        System.out.println("-----------------------------INITIALIZATION-----------------------------");

        System.out.println("************************************************************************");


        SessionFactory sessionFactory = HibernateUtils.buildSessionFactory(Owner.class, Pet.class);
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Pet teddy = new Pet().setNickname("Teddy").setPetType(PetType.DOG).setChipId(UUID.randomUUID());
        Pet vinny = new Pet().setNickname("Vinny").setPetType(PetType.DOG).setChipId(UUID.randomUUID());

        session.save(teddy);
        session.save(vinny);

        Owner vova = new Owner().setUsername("Vova").setAddress("Tylna 8a-4").setPets(List.of(teddy, vinny));

        session.save(vova);
        session.getTransaction().commit();
        session.clear();

        System.out.println("************************************************************************");

        System.out.println("---------------------COMPLETE INITIALIZATION----------------------------");

        System.out.println("************************************************************************");

        return session;
    }
}
