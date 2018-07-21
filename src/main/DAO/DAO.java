package main.DAO;

import main.model.Student;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.ArrayList;

public interface DAO {
    void add(Student student);

    void update(Student student);

    void deleteById(int no);

    void deleteByName(String name);

    ArrayList<Student> select();


}
