package main;

import main.model.Student;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author MMCJ
 */
public class JdbcDemo {
    public static void main(String[] args){
        Student student = new Student();
        StudentDAO studentDAO = new StudentDAO();
        Scanner scanner = new Scanner(System.in);

        /*//添加数据
        System.out.println("请输入学生数量");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++ ) {
            System.out.println("输入学号：");
            int no = scanner.nextInt();
            System.out.println("输入姓名：");
            scanner.nextLine();
            String name = scanner.nextLine().trim();
            System.out.println("输入出生日期：");
            String date = scanner.nextLine();
            Date birth = Date.valueOf(date);
            System.out.println("输入性别：");
            String sex = scanner.nextLine().trim();

            student.setStudentNo(no);
            student.setStudentName(name);
            student.setStudentSex(sex);
            student.setStudentBirth(birth);
            studentDAO.add(student);
        }*/

        //查询数据
        ArrayList<Student> students = studentDAO.select();
        for (Student student1 : students){
            System.out.println(student1);
        }

        //更新数据
       /* Student student2 = new Student();
        System.out.println("请输入需要更新的学生信息:");
        System.out.println("输入学号：");
        int no = scanner.nextInt();
        System.out.println("输入姓名：");
        scanner.nextLine();
        String name = scanner.nextLine().trim();
        System.out.println("输入性别：");
        String sex = scanner.nextLine().trim();
        System.out.println("输入出生日期：");
        Date birth = Date.valueOf(scanner.nextLine());
        student.setStudentNo(no);
        student.setStudentName(name);
        student.setStudentSex(sex);
        student.setStudentBirth(birth);
        studentDAO.update(student);*/

        //删除数据
        System.out.println("deleteById:");
        int deleteNo = scanner.nextInt();
        studentDAO.deleteById(deleteNo);
        scanner.nextLine();
        System.out.println("deleteByName：");
        String deleteName = scanner.nextLine().trim();
        studentDAO.deleteByName(deleteName);

    }

}
