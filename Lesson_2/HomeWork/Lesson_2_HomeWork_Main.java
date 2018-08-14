package Lesson_2.HomeWork;

import java.io.*;
import java.sql.*;

public class Lesson_2_HomeWork_Main {

    private static Connection connection;
    private static Statement stmt;
    private static BufferedReader reader;

    public static void main(String[] args) {
        try {
            connect();
            initialize();
            reader = new BufferedReader(new InputStreamReader(System.in));
            String str;
            System.out.println("Введите команду\nУзнать цену - \t\t\t\t\t\t\t/цена название_товара\nСменить цену - \t\t\t\t\t\t\t/сменитьцену название_товара новая_цена\n" +
                    "Вывести товары в ценовом диапазоне - \t/товарыпоцене минимальная_цена максимальная_цена\nВыход - \t\t\t\t\t\t\t\t/exit");
            while (true) {
                try {
                    str = reader.readLine();
                    if (str.equals("/exit")) break;
                    String[] subStr = str.split(" ");
                    if (subStr[0].equals("/цена")) {
                        int tmp = callCostGood(subStr[1]);
                        System.out.println(tmp == -1 ? "Такого товара нет" : tmp);
                    }
                    if (subStr[0].equals("/сменитьцену")) {
                        System.out.println(!changeCost(subStr) ? "Такого товара нет" : "Цена успешно изменена");
                    }
                    if (subStr[0].equals("/товарыпоцене")) {
                        ResultSet rs = callCostGoods(subStr);
                        while (rs.next()) {
                            System.out.println(rs.getString(1) + " \t| " + rs.getInt(2));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
                reader.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet callCostGoods(String[] str) throws SQLException {
        return stmt.executeQuery("SELECT title, cost FROM goods WHERE cost BETWEEN " + str[1] + " AND " + str[2]);
    }

    public static boolean changeCost(String[] str) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("UPDATE goods\n" +
                " SET cost = ?\n" +
                " WHERE title = ?\n");
        pstmt.setInt(1, Integer.parseInt(str[2]));
        pstmt.setString(2, str[1]);
        return pstmt.executeUpdate() == 0 ? false : true;
    }

    public static int callCostGood(String string) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT cost FROM goods WHERE title = '" + string + "'");
        if (rs.next()) return rs.getInt(1);
        else return -1;
    }

    public static void initialize() throws SQLException {
        stmt = connection.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS goods (\n" +
                "    id     INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                   UNIQUE\n" +
                "                   NOT NULL,\n" +
                "    prodid INTEGER UNIQUE,\n" +
                "    title  STRING  NOT NULL,\n" +
                "    cost   INT  NOT NULL\n" +
                ");\n");
        stmt.executeUpdate("DELETE FROM goods");
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO goods " +
                "(prodid, title, cost)" +
                "VALUES (?, ?, ?)");
        connection.setAutoCommit(false);
        for (int i = 1; i <= 10_000; i++) {
            pstmt.setString(1, "id_good_" + i + "");
            pstmt.setString(2, "good_" + i);
            pstmt.setDouble(3, i * 10);
            pstmt.addBatch();
        }
        pstmt.executeBatch();
        connection.setAutoCommit(true);
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Main.db");
    }

    public static void disconnect() throws SQLException {
        connection.close();
    }
}
