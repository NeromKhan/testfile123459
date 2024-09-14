package org.example;

import java.sql.*;

public class CurdOperation {
    public static void main(String[] args) {
        //All class and method jdbe api create kora ace
        //jdbc api er madome database ke management kori.database
        //jdbe only handle kore java based application.
        //hybernet onnano based application

        //jdbc api er moddome sql server commnication kori.
    //JDBC API - Classes and Interfaces
//DriverManager - Class
//Connection
//Statement-fixed er jonno statement
//PreparedStatement-Dynamic parameter
//CallableStatement
//ResultSet
//SQLException - Class
//trycatch block er shortcut Crtul+ALter+t
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "root";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet  = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        // Table create
//        try {
//            String q =  "create table employee (empId int(10) primary key auto_increment," +
//                      "empName varchar(20) not null," +
//                      "empGender char (10)," +
//                      "empAge int," +
//                      "empSalary double)";
//           Statement statement = connection.createStatement();
//           statement.executeUpdate(q);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        //this method for specific
//        try {
//            //insertinto dia row creat kore
//            //1st trtcatch block a create koeci
//            String q = "insert into employee(empId,empName,empGender,empAge,empSalary) values(?,?,?,?,?)";
//            preparedStatement = connection.prepareStatement(q);
//            preparedStatement.setString(1,"213");
//            preparedStatement.setString(2,"Fatema");
//            preparedStatement.setString(3,"Female");
//            preparedStatement.setString(4,"26");
//            preparedStatement.setString(5,"50000");
//            //executeupdate database ke excute korbe
//            preparedStatement.executeUpdate();
//            System.out.println("Row created/ value added");
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
         //this method for Dynamic
        try {

            String q = "insert into employee(empName,empGender,empAge,empSalary) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(q);

            preparedStatement.setString(1,"Jhon");
            preparedStatement.setString(2,"Male");
            preparedStatement.setString(3,"40");
            preparedStatement.setString(4,"58000");

            preparedStatement.executeUpdate();
            System.out.println("Row created/ value added");

        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            //2nd try catch block a update korci.
            // String q = "update employee set empName=?, empAge=? , empSalary=? where empId=?";
            String q = "update employee set empName=?, empAge=? , empSalary=? where empId=?";
            preparedStatement= connection.prepareStatement(q);
            //set string 2ta parameter nei and value gula add korteci.
            //query method er jonno preparedStatement and executeUpdate method use korer jonno too.
            preparedStatement.setString(1,"Fatima");
            preparedStatement.setString(2,"25");
            preparedStatement.setString(3,"55000");
            preparedStatement.setString(4,"214");

            //executeupdate database ke excute korbe
            preparedStatement.executeUpdate();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            //delete specific feild delete er jonno
            String q = "Delete from employee where empId = ?";
            preparedStatement = connection.prepareStatement(q);
            preparedStatement.setString(1,"214");
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }


        //execute query method use kori get or read
        try {
            String q = "select * from employee where empId = ?";
            preparedStatement = connection.prepareStatement(q);
            preparedStatement.setString(1,"218");
            resultSet =preparedStatement.executeQuery();

            if (resultSet.next()){
//               String id = resultSet.getString("empId");
//                System.out.println(id);
                System.out.println(resultSet.getString("empId"));
                System.out.println(resultSet.getString("empName"));
                System.out.println(resultSet.getString("empAge"));
                System.out.println(resultSet.getString("empSalary"));
                System.out.println(resultSet.getString("empGender"));
            }else {
                System.out.println("No employee found" );
            }

        } catch (Exception e) {
            System.out.println();
        }
        try {
            String q = "select * from employee";
            preparedStatement = connection.prepareStatement(q);
            resultSet =preparedStatement.executeQuery();

            while (resultSet.next()){
                String id =  resultSet.getString(1);
                String name =  resultSet.getString(2);
                String age =  resultSet.getString(3);
                String gender =  resultSet.getString(4);
                String salary =  resultSet.getString(5);
                System.out.println(id + " " + name + " " + age + " " + gender + " "+ salary);

            }

        } catch (Exception e) {
            System.out.println();
        }
//        try {
//            //deleteAll method
//            String q = "Delete from employee";
//            preparedStatement = connection.prepareStatement(q);
//
//            preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e);
//        }

    }
}
