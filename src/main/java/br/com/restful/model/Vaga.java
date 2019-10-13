package br.com.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class Vaga {

    private String uf;
    private Integer id;
    private String nome;
    private String turno;
    private String remuneracao;
    private boolean valeRefeicao;
    private String especificacoes;
    private boolean valeTransporte;
    private String formaContratacao;
    private Integer empresa_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setValeTransporte(boolean valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public boolean getValeTransporte() {
        return this.valeTransporte;
    }

    public boolean getValeRefeicao() {
        return this.valeRefeicao;
    }

    public void setValeRefeicao(boolean valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public String getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(String remuneracao) {
        this.remuneracao = remuneracao;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getFormaContratacao() {
        return formaContratacao;
    }

    public void setFormaContratacao(String formaContratacao) {
        this.formaContratacao = formaContratacao;
    }

    public Integer getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }

    @Override
    public String toString() {
        return "Vaga{" + "uf=" + uf + ", id=" + id + ", nome=" + nome + ", turno=" + turno + ", remuneracao=" + remuneracao + ", valeRefeicao=" + valeRefeicao + ", especificacoes=" + especificacoes + ", valeTransporte=" + valeTransporte + ", formaContratacao=" + formaContratacao + ", empresa_id=" + empresa_id + '}';
    }

}
