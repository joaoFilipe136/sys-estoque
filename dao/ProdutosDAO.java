
package dao;

import dto.ProdutosDTO;
import dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ProdutosDTO> lista = new ArrayList<>();
    
    public void adicionarProduto(ProdutosDTO prdtDTO) throws SQLException{
        
        String sql = "insert into produtos (nome, fornecedor, lote, quant) values (?,?,?,?)";
        conn = (Connection) new ConnectionFactory().conectar();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, prdtDTO.getNome_produto());
            pstm.setString(2, prdtDTO.getFornecedor_produto());
            pstm.setInt(3, prdtDTO.getLote_produto());
            pstm.setInt(4, prdtDTO.getQuant_produto());
            
            pstm.executeUpdate();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "ProdutosDAO" + erro);
            
        }
    }
    
    public ArrayList<ProdutosDTO> consultar() throws SQLException {
      String sql = "select * from produtos";
      conn = (Connection) new ConnectionFactory().conectar();
      
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                ProdutosDTO prdtDTO = new ProdutosDTO();
                prdtDTO.setId_produto(rs.getInt("id"));
                prdtDTO.setNome_produto(rs.getString("nome"));
                prdtDTO.setFornecedor_produto(rs.getString("fornecedor"));
                prdtDTO.setLote_produto(rs.getInt("lote"));
                prdtDTO.setQuant_produto(rs.getInt("quant"));
                
                lista.add(prdtDTO);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Consultar " + erro);
        }
        return lista;
 }
    
    public void alterarProdutos(ProdutosDTO prdtDTO) throws SQLException{
        
        String sql = "update produtos set nome = ?, fornecedor = ?, lote = ?, quant =  ? where id = ?";
        conn = new ConnectionFactory().conectar();
        
        try {
            
           pstm = conn.prepareStatement(sql);
           pstm.setString(1, prdtDTO.getNome_produto());
           pstm.setString(2, prdtDTO.getFornecedor_produto());
           pstm.setInt(3, prdtDTO.getLote_produto());
           pstm.setInt(4, prdtDTO.getQuant_produto());
           pstm.setInt(5, prdtDTO.getId_produto());
           
           pstm.executeUpdate();
           pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "produtosDAO" + erro);
        }
        
        
    }
    
     public void deletarProdutos(Integer id) throws SQLException{
        
        String sql = "DELETE FROM produtos WHERE id = ?";
        conn = new ConnectionFactory().conectar();
        
        try {
            
           pstm = conn.prepareStatement(sql);
           pstm.setInt(1, id);
         
           
           pstm.executeUpdate();
           pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "produtosDAO" + erro);
        }
        
        
    }
    
    public ArrayList<ProdutosDTO> pegarValor(Integer id) throws SQLException {
      String sql = "select * from produtos where id = ?";
      conn = (Connection) new ConnectionFactory().conectar();
      
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                ProdutosDTO prdtDTO = new ProdutosDTO();
                prdtDTO.setNome_produto(rs.getString("nome"));
                prdtDTO.setLote_produto(rs.getInt("lote"));
                prdtDTO.setQuant_produto(rs.getInt("quant"));
                
                lista.add(prdtDTO);
            }
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no metodo pegarDados " + erro);
        }
        return lista;
 }
    
}
