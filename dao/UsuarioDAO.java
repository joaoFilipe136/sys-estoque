
package dao;

import dto.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<UsuarioDTO> lista = new ArrayList<>();
    
    public void cadastrarUser(UsuarioDTO userDTO) throws SQLException{
        String sql = "insert into usuario (nome, email, telefone, senha) values (?,?,?,?)";
        conn = (Connection) new ConnectionFactory().conectar();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userDTO.getNome());
            pstm.setString(2, userDTO.getEmail());
            pstm.setInt(3, userDTO.getTelefone());
            pstm.setString(4, userDTO.getSenha());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
            
        }
        
    }
    
    public ArrayList<UsuarioDTO> consultar() throws SQLException {
      String sql = "select * from usuario";
      conn = (Connection) new ConnectionFactory().conectar();
      
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                UsuarioDTO userDTO = new UsuarioDTO();
                userDTO.setId_usuario(rs.getInt("id"));
                userDTO.setNome_usuario(rs.getString("nome"));
                userDTO.setEmail_usuario(rs.getString("email"));
                userDTO.setTelefone_usuario(rs.getInt("telefone"));
                userDTO.setSenha_usuario(rs.getString("senha"));
                
                lista.add(userDTO);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Consultar " + erro);
        }
        return lista;
 }
   
    public void alterarUser(UsuarioDTO userDTO)throws SQLException{
       
        String sql = "update usuario set nome = ?, email = ?, telefone = ?, senha ? where id = ?";
        conn = (Connection) new ConnectionFactory().conectar();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userDTO.getNome());
            pstm.setString(2, userDTO.getEmail());
            pstm.setInt(3, userDTO.getTelefone());
            pstm.setString(4, userDTO.getSenha());
            pstm.setInt(5, userDTO.getId_usuario());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
            
        }
        

        
    }
    
    public void excluirUser(UsuarioDTO userDTO) throws SQLException{
        
        String sql = "delete from usuario where id = ?";
        
        conn = (Connection) new ConnectionFactory().conectar();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, userDTO.getId_usuario());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
            
        }
    
    }
    
    public ResultSet autenticaoUser(UsuarioDTO userDTO) throws SQLException{
        
        conn = new ConnectionFactory().conectar();
        
        try {
            
            String sql = "select * from usuario where email = ? and senha = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userDTO.getEmail());
            pstm.setString(2, userDTO.getSenha());
            
            rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "usuarioDAO");
            return null;
        }
        
    }
    
}
