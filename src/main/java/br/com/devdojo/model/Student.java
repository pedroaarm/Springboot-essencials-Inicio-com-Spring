package br.com.devdojo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    public static List<Student> studentlist;
    public Student(int id, String name) {
        this(name);
        this.id = id;
    }
    static {
        studentrepository();
    }

    public Student(String name) {
        this.name = name;
    }
    public Student(){

    }

    private static void studentrepository(){
        studentlist = new ArrayList<>(Arrays.asList(new Student(1,"Deku"), new Student(2,"teste")));
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
