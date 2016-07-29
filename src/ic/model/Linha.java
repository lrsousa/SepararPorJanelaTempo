package ic.model;

public class Linha {
	private Integer codTurma;
	private Integer codPessoa;
	private String id;
	private Long dataSegundos;
	private String resultado;
	private String Evento;
	
	
	public Linha(Integer codTurma, Integer codPessoa, String id, long l, String resultado,
			String evento) {
		this.codTurma = codTurma;
		this.codPessoa = codPessoa;
		this.id = id;
		this.dataSegundos = l;
		this.resultado = resultado;
		Evento = evento;
	}
	
	public Linha(String[] linha) {
		this(Integer.parseInt(linha[0]),Integer.parseInt(linha[1]), linha[2], Long.parseLong(linha[3]), linha[4], linha[6]);
	}
	
	public Integer getCodTurma() {
		return codTurma;
	}
	public void setCodTurma(Integer codTurma) {
		this.codTurma = codTurma;
	}
	public Integer getCodPessoa() {
		return codPessoa;
	}
	public void setCodPessoa(Integer codPessoa) {
		this.codPessoa = codPessoa;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getDataSegundos() {
		return dataSegundos;
	}
	public void setDataSegundos(Long dataSegundos) {
		this.dataSegundos = dataSegundos;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getEvento() {
		return Evento;
	}
	public void setEvento(String evento) {
		Evento = evento;
	}
}
