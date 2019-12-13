package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
public final class Empresa {

    private long id;
    private String cnpj;
    private String endereco;
    private String razaoSocial;
    private String cidade;
    private String bairro;
    private String uf;
    private String email;
    private String cep;
    private String telefone;
    //private ArrayList<Vaga> vagas;

    public Empresa() {
        
    }

    public Empresa(
        long id, 
        String cnpj, 
        String endereco, 
        String razaoSocial, 
        String cidade, 
        String bairro, 
        String uf, 
        String email, 
        String cep,
        String telefone
    ){
        this.id = id;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.razaoSocial = razaoSocial;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
        this.email = email;
        this.cep = cep;
        this.telefone = telefone;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "razao_social", nullable = false)
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Column(name = "cnpj", nullable = false)
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    @Column(name = "endereco", nullable = false)
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Column(name = "cidade", nullable = false)
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Column(name = "bairro", nullable = false)
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Column(name = "uf", nullable = false)
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "cep", nullable = false)
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    @Column(name = "telefone", nullable = false)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /*public ArrayList<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(ArrayList<Vaga> vagas) {
        this.vagas = vagas;
    }*/

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", cnpj=" + cnpj + ", endereco=" + endereco + ", razaoSocial=" + razaoSocial + '}';
    }
}
