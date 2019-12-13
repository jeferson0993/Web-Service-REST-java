package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vagas")
public final class Vaga {

    private long id;
    private String nome;
    private String cidade;
    private String uf;
    private String turno;
    private String remuneracao;
    private boolean valeRefeicao;
    private String especificacoes;
    private boolean valeTransporte;
    private String formaContratacao;
    private long empresa_id;

    public Vaga(){}
        
    public Vaga(
        long id,
        String nome,
        String cidade,
        String uf,
        String turno,
        String remuneracao,
        boolean valeRefeicao,
        String especificacoes,
        boolean valeTransporte,
        String formaContratacao,
        long empresa_id
    ){
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.uf = uf;
        this.turno = turno;
        this.remuneracao = remuneracao;
        this.valeRefeicao = valeRefeicao;
        this.valeTransporte = valeTransporte;
        this.especificacoes = especificacoes;
        this.formaContratacao = formaContratacao;
        this.empresa_id = empresa_id;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "uf", nullable = false)
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }        

    public void setValeTransporte(boolean valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    @Column(name = "vale_transporte", nullable = false)
    public boolean getValeTransporte() {
        return this.valeTransporte;
    }

    public void setValeRefeicao(boolean valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }

    @Column(name = "vale_refeicao", nullable = false)
    public boolean getValeRefeicao() {
        return this.valeRefeicao;
    }

    @Column(name = "especificacoes", nullable = false)
    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    @Column(name = "remuneracao", nullable = false)
    public String getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(String remuneracao) {
        this.remuneracao = remuneracao;
    }

    @Column(name = "turno", nullable = false)
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Column(name = "forma_contratacao", nullable = false)
    public String getFormaContratacao() {
        return formaContratacao;
    }

    public void setFormaContratacao(String formaContratacao) {
        this.formaContratacao = formaContratacao;
    }

    @Column(name = "empresa_id", nullable = false)
    public long getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(long empresa_id) {
        this.empresa_id = empresa_id;
    }


    @Column(name = "cidade", nullable = false)
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Vaga{" + "uf=" + uf + ", id=" + id + ", nome=" + nome + ", turno=" + turno + ", remuneracao=" + remuneracao + ", valeRefeicao=" + valeRefeicao + ", especificacoes=" + especificacoes + ", valeTransporte=" + valeTransporte + ", formaContratacao=" + formaContratacao + ", empresa_id=" + empresa_id + '}';
    }
}
