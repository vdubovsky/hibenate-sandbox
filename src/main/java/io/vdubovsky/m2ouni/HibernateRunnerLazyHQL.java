package io.vdubovsky.m2ouni;

public class HibernateRunnerLazyHQL {

    // set LAZY fetch type
    public static void main(String[] args) {
        var session = HibernateRunnerCommon.initAndGetSession();
        session.getTransaction().begin();
        var pet = session.createQuery("select p from Pet p where p.id = 1L", Pet.class).getSingleResult();
        System.out.println("Lazy fetch type, no additional requests so far");
        Owner owner = pet.getOwner();
        System.out.println("Owner class is : " + owner.getClass());
        System.out.println("note: we dont initialize owner until unknown field is called");
        Long id = owner.getId();
        System.out.println("note: id is known because it is foreign key");
        String address = owner.getAddress();
        System.out.println("Only now we need to query Owner as address is not known");
        session.getTransaction().commit();
    }
}
