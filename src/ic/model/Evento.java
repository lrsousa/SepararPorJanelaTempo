package ic.model;

public class Evento {
	private String evento;

	public Evento() {}
	
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	
	public void concatEvento(String evento) {
		if(this.evento == null || this.evento.isEmpty()) {
			this.evento = evento;
		} else {
			this.evento = new StringBuilder().append(this.evento).append(" > " + evento).toString();
		}
	}

	@Override
	public String toString() {
		return "Evento [evento=" + evento + "]";
	}
}
