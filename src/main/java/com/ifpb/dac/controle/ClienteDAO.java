package com.ifpb.dac.controle;

import com.ifpb.dac.entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection con;

    public ClienteDAO() {
    }

    public List<Cliente> listaTodos() {
        List<Cliente> lista = new ArrayList<>();
        try {
            con = Conexao.getConnection();
            String sql = "SELECT * FROM cliente";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                lista.add(c);
            }
            con.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

//    public void povoarLista(ResultSet rs, List<Cliente> lista) {
//        try {
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String nome = rs.getString("nome");
//                String email = rs.getString("email");
//                lista.add(new Cliente(id, nome, email));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//    public ResultSet consulta(PreparedStatement stmt){
//        ResultSet rs = null;
//        try {
//            rs = stmt.executeQuery();
//            return rs;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return rs;
//    }
}
