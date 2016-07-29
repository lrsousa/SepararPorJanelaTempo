package ic.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ic.model.Evento;
import ic.model.LeitorCsv;
import ic.model.Linha;
import ic.model.Pessoa;
import ic.model.Turma;

public class Main {
	public static void main(String[] args) throws IOException, Exception {
		LeitorCsv csv = new LeitorCsv("../LogsMatAdm.csv");
		BufferedReader br = csv.getFileToRead();
		br.readLine();

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Pessoa p = null;
		Evento evento = null;
		
		Linha lnAnterior = null;
		Linha lnAtual = new Linha(br.readLine().split(";"));
		
		p = new Pessoa(lnAtual.getCodPessoa(), new Turma(lnAtual.getCodTurma()), lnAtual.getResultado());
		evento = new Evento();
		evento.concatEvento(lnAtual.getEvento());
		
		int i = 2;
		while(br.ready()) {
			lnAnterior = lnAtual;
			lnAtual = new Linha(br.readLine().split(";"));
			
			if(testaMesmaPessoa(lnAnterior, lnAtual)) {
				if(!testaJanela(lnAnterior, lnAtual)) {
					p.addEvento(evento);
					evento = new Evento();
				}
				evento.concatEvento(lnAtual.getEvento());
			} else {
				p.addEvento(evento);
				pessoas.add(p);
				p = new Pessoa(lnAtual.getCodPessoa(), new Turma(lnAtual.getCodTurma()), lnAtual.getResultado());
				evento = new Evento();
				evento.concatEvento(lnAtual.getEvento());
			}
			if(!br.ready()) {
				p.addEvento(evento);
				pessoas.add(p);
			}
			
			
		}
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
			if(pessoa.getCodPessoa() == 7690) {
				break;
			}
		}
		System.out.println(pessoas.size());
		System.out.println(i);
	}

	private static boolean testaMesmaPessoa(Linha lnAnterior, Linha lnAtual) {
		return lnAnterior.getCodPessoa().equals(lnAtual.getCodPessoa());
	}

	private static boolean testaJanela(Linha lnAnterior, Linha lnAtual) {
		return (lnAtual.getDataSegundos() - lnAnterior.getDataSegundos()) <= 60;
	}
}
