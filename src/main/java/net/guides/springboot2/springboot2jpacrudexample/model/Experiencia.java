package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "esperiencias")
public final class Experiencia {
    private long id;
    private String cargo;
    private String funcao;
    private long candidato_id;

    public Experiencia(){}

    public Experiencia(
        long id, 
        String cargo, 
        String funcao, 
        long candidato_id
    ){
        this.id = id;
        this.cargo = cargo;
        this.funcao = funcao;
        this.candidato_id = candidato_id;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "cargo", nullable = false)
    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    @Column(name = "funcao", nullable = false)
    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao){
        this.funcao = funcao;
    }    

    @Column(name = "candidato_id", nullable = false)
    public long getCandidato_id() {
        return this.candidato_id;
    }

    public void setCandidato_id(long candidato_id) {
        this.candidato_id = candidato_id;
    }

    @Override
    public String toString() {
        return "Experiencia{" + "id=" + id + ", cargo=" + cargo + ", funcao=" + funcao + ", candidato_id=" + candidato_id + '}';
    }

}
