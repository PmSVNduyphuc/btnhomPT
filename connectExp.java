package DemoSql;

import com.mysql.cj.xdevapi.SelectStatement;

import java.sql.*;
import java.util.Scanner;

public class connectExp {
    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Ket Noi Thanh Cong");
        }

    }

    public static Connection getConnection() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/PTgroup";
        String username = "";
        String password = "root";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        return connection;
    }

    public static void createProduct() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui Long nhap Id");
        Integer a = sc.nextInt();
        System.out.println("Vui Long Nhap Ten");
        String b = sc.nextLine();
        System.out.println("Vui Long Nhap Hang");
        String c = sc.nextLine();
        System.out.println("Vui Long Nhap Gia Ban");
        Integer d = sc.nextInt();
        Connection conn = getConnection();
        String query = "insert into product values(?.?.?.?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, a);
        preparedStatement.setString(2, b);
        preparedStatement.setString(3, c);
        preparedStatement.setDouble(4, d);
        int rowInserted = preparedStatement.executeUpdate();
        if (rowInserted > 0) {
            System.out.println("create thanh cong");
        }
    }

    public static void updateProduct() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui Long nhap Id");
        Integer a = sc.nextInt();
        System.out.println("Vui Long Nhap Ten");
        String b = sc.nextLine();
        System.out.println("Vui Long Nhap Hang");
        String c = sc.nextLine();
        System.out.println("Vui Long Nhap Gia Ban");
        Integer d = sc.nextInt();
        Connection conn = getConnection();
        String query = "update product set proName= '?',proDesc='?',price='?',where id='?' ";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, a);
        preparedStatement.setString(2, b);
        preparedStatement.setString(3, c);
        preparedStatement.setDouble(4, d);
        int rowInserted = preparedStatement.executeUpdate();
        if (rowInserted > 0) {
            System.out.println("Update thanh cong");
        }
    }

    public static void deleteProduct() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui Long Nhap Id");
        Integer a = sc.nextInt();
        Connection conn = getConnection();
        String query = "delete from product where id = '?'";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setDouble(1, a);
        int rowInserted = preparedStatement.executeUpdate();
        if (rowInserted > 0) {
            System.out.println("delete thanh cong");
        }
    }

    public static void showProduct() throws SQLException {

        Connection conn = getConnection();
        String query = "delete from product order by proName desc";

    }

    public static void searchById() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui Long nhap Id");
        Integer a = sc.nextInt();
        Connection conn = getConnection();
        String query = "select*from product where id like '?'";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1, a);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String proName = resultSet.getString("proName");
            String proDesc = resultSet.getString("proDesc");
            int price = resultSet.getInt("price");

        }
    }
    public static void searchByName() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui Long nhap Name");
        String b = sc.nextLine();
        Connection conn = getConnection();
        String query = "select*from product where proName like '?'";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setString(2,b);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String proName = resultSet.getString("proName");
            String proDesc = resultSet.getString("proDesc");
            int price = resultSet.getInt("price");

        }
    }
}

