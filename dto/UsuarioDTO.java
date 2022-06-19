
package dto;

public class UsuarioDTO {
    
    private String nome_usuario, email_usuario, senha_usuario, confSenha_usuario;                 
    private int telefone_usuario, id_usuario;

    public String getNome() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome) {
        this.nome_usuario = nome;
    }

    public String getEmail() {
        return email_usuario;
    }

    public void setEmail_usuario(String email) {
        this.email_usuario = email;
    }

    public String getSenha() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha) {
        this.senha_usuario = senha;
    }

    public String getConfSenha() {
        return confSenha_usuario;
    }

    public void setConfSenha_usuario(String confSenha) {
        this.confSenha_usuario = confSenha;
    }

    public int getTelefone() {
        return telefone_usuario;
    }

    public void setTelefone_usuario(int telefone) {
        this.telefone_usuario = telefone;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
