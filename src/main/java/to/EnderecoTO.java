package to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EnderecoTO {
	private long id;
	private String estado, cidade, logradouro, numero, pais;
	private int cep;
	private long idUsuario ;
	
	public EnderecoTO() {
		
	}

	public EnderecoTO(long id, String estado, String cidade, String logradouro, String numero, String pais, int cep,
			long idUsuario) {
		super();
		this.id = id;
		this.estado = estado;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.numero = numero;
		this.pais = pais;
		this.cep = cep;
		this.idUsuario = idUsuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	
	

}
