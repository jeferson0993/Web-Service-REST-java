package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidatos")
public final class Candidato {

	private long id;
	private String rg;
	private String nome;
	private String cpf;
	private String sexo;
	private String endereco;
	private String telefone;
	private String estadoCivil;
	private String dataNascimento;
	//private ArrayList<Experiencia> experiencias;

	public Candidato() {}

	public Candidato(
		long id, 
		String rg, 
		String nome, 
		String cpf, 
		String sexo, 
		String endereco, 
		String telefone, 
		String estadoCivil, 
		String dataNascimento
	){
		this.id = id;
		this.rg = rg;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.endereco = endereco;
		this.telefone = telefone;
		this.estadoCivil = estadoCivil;
		this.dataNascimento = dataNascimento;
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

	@Column(name = "cpf", nullable = false)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "data_nascimento", nullable = false)
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "rg", nullable = false)
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Column(name = "sexo", nullable = false)
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(name = "endereco", nullable = false)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "telefone", nullable = false)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "estado_civil", nullable = false)
	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/*public ArrayList<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(ArrayList<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}*/

	@Override
	public String toString() {
		return "Candidato{" + "id=" + id + ", rg='" + rg + '\'' + ", nome='" + nome + '\'' + ", cpf='" + cpf + '\''
				+ ", sexo='" + sexo + '\'' + ", endereco='" + endereco + '\'' + ", telefone='" + telefone + '\''
				+ ", estadoCivil='" + estadoCivil + '\'' + ", dataNascimento='"
				+ dataNascimento + '\'' + '}';
	}

}
