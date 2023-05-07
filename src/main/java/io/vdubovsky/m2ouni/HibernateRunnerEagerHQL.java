package io.vdubovsky.m2ouni;

import org.hibernate.Session;

public class HibernateRunnerEagerHQL {

    // set EAGER fetch type
    public static void main(String[] args) {
        Session session = HibernateRunnerCommon.initAndGetSession();
        var pet = session.createQuery("select p from Pet p where p.id = 1L", Pet.class).getSingleResult();
        System.out.println("Getting entity via hql, even though fetch type is Eager, additional request takes place");
    }
}
