package Lesson_6.HomeWork;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {

    }


    public static int task3_update(String string) {
        try {
            connect();
            int resultSet = stmt.executeUpdate(string);
            return resultSet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static String task3_read(String string) {
        try {
            connect();
            ResultSet resultSet = stmt.executeQuery(string);
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static int[] task1(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                int[] out = new int[array.length - i - 1];
                System.arraycopy(array, i + 1, out, 0, out.length);
                return out;
            }
        }
        throw new RuntimeException("В массиве нет четверок");
    }

    public static boolean isOnlyOneAndFour(int[] array) {
        boolean hasOne = false, hasFour = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) hasOne = true;
            else if (array[i] == 4) hasFour = true;
            else return false;
        }
        return hasOne && hasFour;
    }
}
