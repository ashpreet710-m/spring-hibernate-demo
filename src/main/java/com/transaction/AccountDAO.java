package com.example.demo.transaction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.demo.hibernate.HibernateUtil;

public class AccountDAO {
    public Account getAccount(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Account.class, id);
        }
    }

    public void updateAccount(Account acc) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(acc);
            tx.commit();
        }
    }
}
