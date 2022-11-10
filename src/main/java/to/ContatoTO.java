package to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContatoTO {
	private long id;
	private int telefone, ddd, ddi;
	private String email, contato;
	private long idUsuario;
	
	
	public ContatoTO() {
		
	}


	public ContatoTO(long id, int telefone, int ddd, int ddi, String email, String contato, long idUsuario) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.ddd = ddd;
		this.ddi = ddi;
		this.email = email;
		this.contato = contato;
		this.idUsuario = idUsuario;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getTelefone() {
		return telefone;
	}


	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}


	public int getDdd() {
		return ddd;
	}


	public void setDdd(int ddd) {
		this.ddd = ddd;
	}


	public int getDdi() {
		return ddi;
	}


	public void setDdi(int ddi) {
		this.ddi = ddi;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContato() {
		return contato;
	}


	public void setContato(String contato) {
		this.contato = contato;
	}


	public long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	

}
