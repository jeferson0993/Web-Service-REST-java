
package br.com.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class Experiencia {
    private Integer id;
    private String cargo;
    private String funcao;
    private Integer candidato_id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao){
        this.funcao = funcao;
    }    

    public Integer getCandidato_id() {
        return this.candidato_id;
    }

    public void setCandidato_id(Integer candidato_id) {
        this.candidato_id = candidato_id;
    }

    @Override
    public String toString() {
        return "Experiencia{" + "id=" + id + ", cargo=" + cargo + ", funcao=" + funcao + ", candidato_id=" + candidato_id + '}';
    }

}
