package br.com.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class Candidato {

	private Integer id;
	private String rg;
	private String nome;
	private String cpf;
	private String sexo;
	private String endereco;
	private String telefone;
	private String estadoCivil;
	private String experiencia;
	private String dataNascimento;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public String toString() {
		return "Candidato{" + "id=" + id + ", rg='" + rg + '\'' + ", nome='" + nome + '\'' + ", cpf='" + cpf + '\''
				+ ", sexo='" + sexo + '\'' + ", endereco='" + endereco + '\'' + ", telefone='" + telefone + '\''
				+ ", estadoCivil='" + estadoCivil + '\'' + ", experiencia='" + experiencia + '\'' + ", dataNascimento='"
				+ dataNascimento + '\'' + '}';
	}

}
