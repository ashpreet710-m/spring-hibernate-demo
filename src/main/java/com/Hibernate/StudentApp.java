package com.example.demo.hibernate;

public class StudentApp {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        dao.save(new StudentEntity("Alice", 22));
        dao.save(new StudentEntity("Bob", 24));

        System.out.println("All Students:");
        dao.getAll().forEach(s -> System.out.println(s.getId() + " - " + s.getName()));

        dao.update(1, "Alicia");
        dao.delete(2);

        System.out.println("After Updates:");
        dao.getAll().forEach(s -> System.out.println(s.getId() + " - " + s.getName()));
    }
}
