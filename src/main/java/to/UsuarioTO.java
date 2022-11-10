package to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioTO {

	private String nome, profissao, raca, genero, nacionalidade, tpSanguineo, login, senha;
	private long id;
	private int idade;
	private EnderecoTO enderecos;
	private ContatoTO contatos;
	private long veiculo;
	private Double salario;

	public UsuarioTO() {

	}

	public UsuarioTO(String nome, String profissao, String raca, String genero, String nacionalidade,
			String tpSanguineo, String login, String senha, long id, int idade, EnderecoTO enderecos,
			ContatoTO contatos, long veiculo, Double salario) {
		super();
		this.nome = nome;
		this.profissao = profissao;
		this.raca = raca;
		this.genero = genero;
		this.nacionalidade = nacionalidade;
		this.tpSanguineo = tpSanguineo;
		this.login = login;
		this.senha = senha;
		this.id = id;
		this.idade = idade;
		this.enderecos = enderecos;
		this.contatos = contatos;
		this.veiculo = veiculo;
		this.salario = salario;
	}

	public long getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(long veiculo) {
		this.veiculo = veiculo;
	}

	public ContatoTO getContatos() {
		return contatos;
	}

	public void setContatos(ContatoTO contatos) {
		this.contatos = contatos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getTpSanguineo() {
		return tpSanguineo;
	}

	public void setTpSanguineo(String tpSanguineo) {
		this.tpSanguineo = tpSanguineo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public EnderecoTO getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(EnderecoTO enderecos) {
		this.enderecos = enderecos;
	}

}
