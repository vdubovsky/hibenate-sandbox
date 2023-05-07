package io.vdubovsky.m2ouni;

public class HibernateRunnerCascade {

    // set CASCADE ALL
    // set optional true
    public static void main(String[] args) {
        var session = HibernateRunnerCommon.initAndGetSession();
        session.getTransaction().begin();
        var pet1 = session.get(Pet.class, 1L);
        var pet2 = session.get(Pet.class, 2L);
        pet1.setOwner(null);
        session.delete(pet2);
        session.getTransaction().commit();

        System.out.println("note: only if there's only one pet related to Owner we can delete Owner, " +
                " otherwise - Exception and pet is re-saved");
    }
}
