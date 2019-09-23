package br.com.restful.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class Vaga {

	private String uf;
	private Integer id;
	private String nome;
	private String turno;
	private String outros;
	private String remuneracao;
	private boolean valeRefeicao;
	private String especificacoes;
	private boolean valeTransporte;
	private String formaContratacao;

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

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
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

	@Override
	public String toString() {
		return "Vaga{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", uf='" + uf + '\'' +
				", valeTransporte=" + valeTransporte +
				", valeRefeicao=" + valeRefeicao +
				", especificacoes='" + especificacoes + '\'' +
				", remuneracao='" + remuneracao + '\'' +
				", outros='" + outros + '\'' +
				", turno='" + turno + '\'' +
				", formaContratacao='" + formaContratacao + '\'' +
				'}';
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaga other = (Vaga) obj;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}*/
	
	
}
