/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.ResultSetRow;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Nomes;

/**
 *
 * @author Higor Lucas
 */
public class Nomedao {


    public void Create(Nomes n) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            
        try {
            
            stmt = con.prepareStatement("INSERT INTO nomes (cli_Nome,Id_gerador,Senha_gerador)VALUES(?,?,?)");
            stmt.setString(1, n.getNome());
            stmt.setString(2, n.getId());
            stmt.setString(3, n.getSenha());

            stmt.executeUpdate();
          
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
          
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Já possue no banco de dados");
        } finally {
            ConnectionFactory.closseconnection(con, stmt);
        }
            
    }

    public void Update(Nomes n) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE nomes SET Id_gerador = ?,Senha_gerador = ? WHERE cli_Nome = ?");
            stmt.setString(1, n.getId());
            stmt.setString(2, n.getSenha());
            stmt.setString(3, n.getNome());
            System.out.println(stmt);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar");
        } finally {
            ConnectionFactory.closseconnection(con, stmt);
        }
    }

    public void Buscarsenha(Nomes n) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * From nomes WHERE cli_Nome = ?");
            stmt.setString(1, n.getNome());
            ResultSet rs = stmt.executeQuery();
            rs.first();
            n.setId(rs.getString("Id_gerador"));
            n.setSenha(rs.getString("Senha_gerador"));
            JOptionPane.showMessageDialog(null, "Id: " + n.getId() + " Senha: " + n.getSenha());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe no banco de dados");
        } finally {
            ConnectionFactory.closseconnection(con, stmt);
        }
    }

    public void Inserir(Nomes n) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "UPDATE nomes SET Id_gerador = ?,Senha_gerador = ? WHERE cli_Nome = ?";
        String sqls = "SELECT * From nomes WHERE cli_Nome = ?";

        try {// Seleciona um objeto tipo String no banco de dados caso esetaja lá ele atualiza
                stmt = con.prepareCall(sqls);//"SELECT * From nomes WHERE cli_Nome = ?"
                stmt.setString(1, n.getNome());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()){
                
                stmt = con.prepareStatement(sql);//"UPDATE nomes SET Id_gerador = ?,Senha_gerador = ? WHERE cli_Nome = ?"
                stmt.setString(1, n.getId());
                stmt.setString(2, n.getSenha());
                stmt.setString(3, n.getNome());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
                
                }else{
                    JOptionPane.showMessageDialog(null, "Não existe no banco de dados");
                }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro do banco: "+ ex);
            
        } finally {
            ConnectionFactory.closseconnection(con, stmt);
        }
    }
}
    
