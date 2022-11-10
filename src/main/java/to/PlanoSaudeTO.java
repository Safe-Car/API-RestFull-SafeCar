package to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlanoSaudeTO {
	private long id;
	private String empresa, nome, tipo, descricao;
	private long usuario;
	private String unidade, endereco, cidade;	
	
	
	
	
	public PlanoSaudeTO(long id, String empresa, String nome, String tipo, String descricao, long usuario,
			String unidade, String endereco, String cidade) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.usuario = usuario;
		this.unidade = unidade;
		this.endereco = endereco;
		this.cidade = cidade;
	}

	public PlanoSaudeTO() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	
	

	
	

}
