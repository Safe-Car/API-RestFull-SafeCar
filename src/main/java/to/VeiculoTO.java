package to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VeiculoTO {
	private long id;
	private String nmVeiculo, tipo, cor, placa, modelo, dsVeiculo;
	private int tripulantes;
	private UsuarioTO user;
	
	
	public VeiculoTO() {
		
	}


	public VeiculoTO(long id, String nmVeiculo, String tipo, String cor, String placa, String modelo, String dsVeiculo,
			int tripulantes, UsuarioTO user) {
		super();
		this.id = id;
		this.nmVeiculo = nmVeiculo;
		this.tipo = tipo;
		this.cor = cor;
		this.placa = placa;
		this.modelo = modelo;
		this.dsVeiculo = dsVeiculo;
		this.tripulantes = tripulantes;
		this.user = user;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNmVeiculo() {
		return nmVeiculo;
	}


	public void setNmVeiculo(String nmVeiculo) {
		this.nmVeiculo = nmVeiculo;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getDsVeiculo() {
		return dsVeiculo;
	}


	public void setDsVeiculo(String dsVeiculo) {
		this.dsVeiculo = dsVeiculo;
	}


	public int getTripulantes() {
		return tripulantes;
	}


	public void setTripulantes(int tripulantes) {
		this.tripulantes = tripulantes;
	}


	public UsuarioTO getUser() {
		return user;
	}


	public void setUser(UsuarioTO user) {
		this.user = user;
	}
	
	
	
	
	

}
