package to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContatoEmergenciaTO {
	private String tipoContato;
	private int telefone, ddd, ddi;
	private long id;
	
	public ContatoEmergenciaTO() {
		
	}

	public ContatoEmergenciaTO(long id,String tipoContato, int telefone, int ddd, int ddi) {
		super();
		this.tipoContato = tipoContato;
		this.telefone = telefone;
		this.ddd = ddd;
		this.ddi = ddi;
		this.id = id;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(String tipoContato) {
		this.tipoContato = tipoContato;
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
	
	
	
	

}
