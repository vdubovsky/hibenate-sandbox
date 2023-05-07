package io.vdubovsky.m2ouni;

import io.vdubovsky.configuration.HibernateUtils;
import lombok.experimental.UtilityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.UUID;

@UtilityClass
public class HibernateRunnerCommon {

    public Session initAndGetSession() {


        System.out.println("************************************************************************");

        System.out.println("-----------------------------INITIALIZATION-----------------------------");

        System.out.println("************************************************************************");


        SessionFactory sessionFactory = HibernateUtils.buildSessionFactory(Owner.class, Pet.class);
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        UUID teddyChipId = UUID.fromString("4cf03673-697f-40d7-8516-bc0b8b5a43bb");
        UUID vinnyChipId = UUID.fromString("1cf03673-697f-40d7-8516-bc0b8b5a43bb");

        var owner = new Owner()
                .setAddress("Poland, Lodz, Tylna 8a/4")
                .setUsername("Vova");

        var teddy = new Pet()
                .setChipId(teddyChipId)
                .setOwner(owner)
                .setPetType(PetType.DOG)
                .setNickname("Teddy");

        var vinny = new Pet()
                .setChipId(vinnyChipId)
                .setOwner(owner)
                .setPetType(PetType.DOG)
                .setNickname("Vinny");

        session.save(owner);
        session.save(teddy);
        session.save(vinny);
        session.getTransaction().commit();
        session.clear();

        System.out.println("************************************************************************");

        System.out.println("---------------------COMPLETE INITIALIZATION----------------------------");

        System.out.println("************************************************************************");

        return session;
    }
}
