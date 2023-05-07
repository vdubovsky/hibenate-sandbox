package io.vdubovsky.m2ouni;

public class HibernateRunnerLazyId {

    // set LAZY fetch type
    public static void main(String[] args) {
        var session = HibernateRunnerCommon.initAndGetSession();
        var pet = session.get(Pet.class, 1L);
        System.out.println("Lazy fetch type, no additional requests so far");
        Owner owner = pet.getOwner();
        System.out.println("note: we dont initialize owner until unknown field is called");
        Long id = owner.getId();
        System.out.println("note: id is known because it is foreign key");
        String address = owner.getAddress();
        System.out.println("Only now we need to query Owner as address is not known");
    }
}
