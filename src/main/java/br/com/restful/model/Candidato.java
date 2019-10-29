package br.com.restful.model;

import java.util.ArrayList;
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
	private String dataNascimento;
	private ArrayList<Experiencia> experiencias;

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

	public ArrayList<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(ArrayList<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	@Override
	public String toString() {
		return "Candidato{" + "id=" + id + ", rg='" + rg + '\'' + ", nome='" + nome + '\'' + ", cpf='" + cpf + '\''
				+ ", sexo='" + sexo + '\'' + ", endereco='" + endereco + '\'' + ", telefone='" + telefone + '\''
				+ ", estadoCivil='" + estadoCivil + '\'' + ", experiencias='" + experiencias + '\'' + ", dataNascimento='"
				+ dataNascimento + '\'' + '}';
	}

}
