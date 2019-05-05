package br.senac.tads.pi3.gerenprod.model;

/**
 *
 * @author felip
 */
public class Usuario {
    
    private int idUsuario, idFilial;
    private String nome, email, senha, departamento;
    private boolean ativo;

    public Usuario() {
        this.idUsuario = 0;
        this.idFilial = 0;
        this.nome = "";
        this.email = "";
        this.senha = "";
        this.departamento = "1";
        this.ativo = true;
    }
    
    public Usuario(int idUsuario, int idFilial, String nome, String email, String senha, String departamento, boolean ativo) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.departamento = departamento;
        this.ativo = ativo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
