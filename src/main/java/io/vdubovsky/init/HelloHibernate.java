package io.vdubovsky.init;

import io.vdubovsky.configuration.HibernateUtils;
import lombok.Cleanup;
import org.hibernate.SessionFactory;

public class HelloHibernate {

    public static void main(String[] args) {
        @Cleanup SessionFactory sessionFactory = HibernateUtils.buildSessionFactory();
    }
}
