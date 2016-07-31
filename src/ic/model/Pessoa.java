package ic.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	private Integer codPessoa;
	private Turma turma;
	private List<Evento> eventos;
	private String resultado;
	
	public Pessoa() {
	}
	
	public Pessoa(Integer codPessoa, Turma turma, String resultado) {
		this.codPessoa = codPessoa;
		this.turma = turma;
		this.resultado = resultado;
		this.eventos = new ArrayList<Evento>();
	}
	
	public Integer getCodPessoa() {
		return codPessoa;
	}
	public void setCodPessoa(Integer codPessoa) {
		this.codPessoa = codPessoa;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getId() {
		return getCodPessoa() + "-" + getTurma().getCodTurma();
	}
	
	@Override
	public String toString() {
		return "Pessoa [codPessoa=" + codPessoa + ", turma=" + turma + ", eventos=" + eventos + ", resultado="
				+ resultado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPessoa == null) ? 0 : codPessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (codPessoa == null) {
			if (other.codPessoa != null)
				return false;
		} else if (!codPessoa.equals(other.codPessoa))
			return false;
		return true;
	}

	public void addEvento(Evento evento) {
		this.eventos.add(evento);
	}
}
