package jpabasic.ex1hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        try{
/*            Member2 member = new Member2();
            member.setId(3L);
            member.setName("리사");

            entityManager.persist(member);*/

            Member2 member21 = entityManager.find(Member2.class, 3L);
            Member2 member2 = entityManager.find(Member2.class, 3L);

            System.out.println("result = " + (member21 == member2));

            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
