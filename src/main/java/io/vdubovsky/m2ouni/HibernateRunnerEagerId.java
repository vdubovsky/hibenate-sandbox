package io.vdubovsky.m2ouni;

public class HibernateRunnerEagerId {

    // set EAGER fetch type
    public static void main(String[] args) {
        var session = HibernateRunnerCommon.initAndGetSession();
        var petGet = session.get(Pet.class, 1L);
        System.out.println("Getting entity by id, no additional requests -" +
                " it is only the one case where we don't have additional request for initializing relations in M2O");

        System.out.println("note: If optional is true - it is inner join, otherwise - it is left join");
    }
}
