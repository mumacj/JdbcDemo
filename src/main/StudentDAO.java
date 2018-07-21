package main;

import main.DAO.DAO;
import main.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO implements DAO {

    public static Connection getConnection() throws Exception{
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://localhost:3306/myschool";
        String username = "root";
        String password = "ROOT";
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

    @Override
    public void add(Student student) {
        try {
            String sql = "INSERT INTO student VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,student.getStudentNo());
            preparedStatement.setString(2,student.getStudentName());
            preparedStatement.setString(3,student.getStudentSex());
            preparedStatement.setDate(4,student.getStudentBirth());
            preparedStatement.executeUpdate();
            System.out.println("成功插入一条数据");
        } catch (Exception e) {
            System.out.println("插入失败！");
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        try {
            String sql = "UPDATE student SET stu_name = ?,stu_sex = ?,stu_birth = ? WHERE studentNO = ?";
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getStudentName());
            preparedStatement.setString(2,student.getStudentSex());
            preparedStatement.setDate(3,student.getStudentBirth());
            preparedStatement.setInt(4,student.getStudentNo());
            System.out.println();
            preparedStatement.executeUpdate();
            //System.out.println("共"+count+"条数据被更新");
        } catch (Exception e){
            System.out.println("更新失败！");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int no) {
        try {
            String sql = "DELETE FROM student WHERE studentNO = ?";
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,no);
            int count = preparedStatement.executeUpdate();
            System.out.println("删除了"+count + "条数据");
        } catch (Exception e){
            System.out.println("根据id删除记录失败！");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByName(String name){
        try {
            String sql = "DELETE FROM student WHERE stu_name = ?";
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            int count = preparedStatement.executeUpdate();
            System.out.println("删除了"+count + "条数据");
        } catch (Exception e){
            System.out.println("根据姓名删除记录失败！");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> select() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "SELECT * FROM student";
            ResultSet resultSet = null;
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Student student = new Student();
                student.setStudentNo(resultSet.getInt("studentNO"));
                student.setStudentName(resultSet.getString("stu_name"));
                student.setStudentSex(resultSet.getString("stu_sex"));
                student.setStudentBirth(resultSet.getDate("stu_birth"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
