package ic.model;

public class Evento extends CodEvento {
	private String evento;
	private String eventoCod;

	public Evento() {}
	
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public String getEventoCod() {
		return eventoCod;
	}
	public void setEventoCod(String eventoCod) {
		this.eventoCod = eventoCod;
	}

	public void concatEvento(String evento) {
		if(this.evento == null || this.evento.isEmpty()) {
			this.evento = evento;
			this.eventoCod = String.valueOf(getCode(evento));
		} else {
			this.evento = new StringBuilder().append(this.evento).append(" > " + evento).toString();
			this.eventoCod = new StringBuilder().append(this.eventoCod).append(" -1 " + getCode(evento)).toString();
		}
	}
	
	public void finalizaEventoCod() {
		this.eventoCod = new StringBuilder().append(this.eventoCod).append(" -2").toString();
	}

	@Override
	public String toString() {
		return "Evento [evento=" + evento + "]";
	}
}

