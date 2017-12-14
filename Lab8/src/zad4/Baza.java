package zad4;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


import java.sql.*;

public class Baza {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private int proby = 0;

    public boolean connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/elakrz",
                            "elakrz", "rd92NRAig3YW8Ltd");

            return true;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            proby += 1;
            if (proby < 3)
                this.connect();

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String listNames(String pesel_) {
        String name = "";
        try {
            connect();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM pracownicy where pesel LIKE ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //pstmt.setString(1, "%" + pesel_ + "%");
            pstmt.setString(1,pesel_);
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++)
                    name = name + " " + rs.getString(i);
            }
            System.out.println(name);
            return name;
        } catch (SQLException ex) {
            ex.printStackTrace();
            // handle any errors
        } finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                } // ignore

                stmt = null;
            }
        }
        System.out.println("Nie znaleziono");
        return "";
    }


    public String insertWorker(String pesel, String type, int brutto, int netto) {
        connect();
        Pesel p = new Pesel(pesel);
        if (p.check(pesel) == true) {
            try {
                String insert = "insert into pracownicy values (?,?,?,?);";
                PreparedStatement prepStmt = conn.prepareStatement(insert);
                prepStmt.setString(1, pesel);
                prepStmt.setString(2, type);
                prepStmt.setInt(3, brutto);
                prepStmt.setInt(4, netto);
                prepStmt.execute();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                System.out.println("niepowodzenie");
                return "niepowodzenie";
            }
           // System.out.println("Znalaeziono"+pesel + " " + type + " " + brutto + " " + netto);
            return pesel + " " + type + " " + brutto + " " + netto;
        }
        System.out.println("niepowodzenie");
        return "niepowodzenie";


    }
}