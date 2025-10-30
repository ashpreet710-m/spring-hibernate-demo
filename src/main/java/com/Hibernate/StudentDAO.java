package com.example.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class StudentDAO {
    public void save(StudentEntity student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
        }
    }

    public List<StudentEntity> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from StudentEntity", StudentEntity.class).list();
        }
    }

    public void update(int id, String newName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            StudentEntity s = session.get(StudentEntity.class, id);
            s.setName(newName);
            session.merge(s);
            tx.commit();
        }
    }

    public void delete(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            StudentEntity s = session.get(StudentEntity.class, id);
            if (s != null) session.remove(s);
            tx.commit();
        }
    }
}
