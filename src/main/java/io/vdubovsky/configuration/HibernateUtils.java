package io.vdubovsky.configuration;

import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtils {

    public SessionFactory buildSessionFactory(Class<?>... classes){
        Configuration configuration = new Configuration();

        for (Class<?> clazz : classes) {
            configuration.addAnnotatedClass(clazz);
        }
        configuration.configure();
        return configuration.buildSessionFactory();
    }
}
