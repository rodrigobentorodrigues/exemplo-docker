package com.ifpb.dac.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection() {
        
        String url = "jdbc:postgresql://host-banco:5432/cliente";
        String usuario = "postgres";
        String senha = "12345";
        
        Connection con = null;
        
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
    public static void closeConnection(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void closeStatement(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
