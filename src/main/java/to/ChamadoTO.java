package to;

import java.sql.Date;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ChamadoTO {
	private long id;
	private String tipoOcorrencia, grau, localizacao, cordenadas;
	private Date data;
	private VeiculoTO veiculo;
	private ContatoEmergenciaTO emergencia;
	
	public ChamadoTO() {
		
	}

	public ChamadoTO(ContatoEmergenciaTO emergencia,VeiculoTO veiculo, long id, String tipoOcorrencia, String grau, String localizacao, String cordenadas, Date data) {
		super();
		this.id = id;
		this.tipoOcorrencia = tipoOcorrencia;
		this.grau = grau;
		this.localizacao = localizacao;
		this.cordenadas = cordenadas;
		this.data = data;
		this.veiculo = veiculo;
		this.emergencia = emergencia;
	}
	
	

	public VeiculoTO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoTO veiculo) {
		this.veiculo = veiculo;
	}

	public ContatoEmergenciaTO getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(ContatoEmergenciaTO emergencia) {
		this.emergencia = emergencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(String tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getCordenadas() {
		return cordenadas;
	}

	public void setCordenadas(String cordenadas) {
		this.cordenadas = cordenadas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
	

}
