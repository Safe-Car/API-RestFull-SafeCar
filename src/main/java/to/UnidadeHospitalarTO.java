package to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UnidadeHospitalarTO {
	private long id;
	private String unidade, endereco, cidade, logradouro, estado, numero;
	private int cep;
	private PlanoSaudeTO plano;
	
	
	public UnidadeHospitalarTO() {
		
	}


	public UnidadeHospitalarTO(String numero, PlanoSaudeTO plano, long id, String unidade, String endereco, String cidade, String logradouro, String estado,
			int cep) {
		super();
		this.id = id;
		this.unidade = unidade;
		this.endereco = endereco;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.estado = estado;
		this.cep = cep;
		this.plano = plano;
		this.numero = numero;
	}
	
	


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public PlanoSaudeTO getPlano() {
		return plano;
	}


	public void setPlano(PlanoSaudeTO plano) {
		this.plano = plano;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getCep() {
		return cep;
	}


	public void setCep(int cep) {
		this.cep = cep;
	}
	
	

}
