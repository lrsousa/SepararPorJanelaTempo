package ic.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ic.model.Evento;
import ic.model.LeitorCsv;
import ic.model.Linha;
import ic.model.Pessoa;
import ic.model.Turma;

public class Main {
	static String nomeArquivo = "LogsMatAdm";
	static String extensao = ".csv";
	
	public static void main(String[] args) throws IOException, Exception {
		LeitorCsv csv = new LeitorCsv("../" + nomeArquivo + extensao);
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
		
		while(br.ready()) {
			lnAnterior = lnAtual;
			lnAtual = new Linha(br.readLine().split(";"));
			
			if(testaMesmaPessoa(lnAnterior, lnAtual)) {
				if(!testaJanela(lnAnterior, lnAtual)) {
					evento.finalizaEventoCod();
					p.addEvento(evento);
					evento = new Evento();
				}
				evento.concatEvento(lnAtual.getEvento());
			} else {
				evento.finalizaEventoCod();
				p.addEvento(evento);
				pessoas.add(p);
				p = new Pessoa(lnAtual.getCodPessoa(), new Turma(lnAtual.getCodTurma()), lnAtual.getResultado());
				evento = new Evento();
				evento.concatEvento(lnAtual.getEvento());
			}
			if(!br.ready()) {
				evento.finalizaEventoCod();
				p.addEvento(evento);
				pessoas.add(p);
			}
		}
		List<String> linhas = montarLinhas(pessoas);
		escreverArquivo(linhas);
	}
	
	static List<String> montarLinhas(List<Pessoa> pessoas) {
		List<String> lista = new ArrayList<String>();
		
		StringBuilder sb;
		for (Pessoa pessoa : pessoas) {
			sb = new StringBuilder();
			sb.append(pessoa.getTurma().getCodTurma()).append(";").append(pessoa.getCodPessoa()).append(";")
			  .append(pessoa.getId()).append(";").append(pessoa.getResultado()).append(";");
			
			Iterator<Evento> eventosIterator = pessoa.getEventos().iterator();
			
			while (eventosIterator.hasNext()) {
				String linha = sb.toString() + eventosIterator.next().getEventoCod();
				System.out.println(linha);
				lista.add(linha);
			}
		}
		System.out.println("ULTIMA LINHA: " + lista.get(lista.size()-1));
		return lista;
	}
	
	static void escreverArquivo(List<String> lista) {
		Path file = Paths.get("../" + nomeArquivo + "Output" + extensao);
		try {
			Files.write(file, lista,StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	
	static boolean testaMesmaPessoa(Linha lnAnterior, Linha lnAtual) {
		return (lnAnterior.getCodPessoa().equals(lnAtual.getCodPessoa()) && lnAnterior.getCodTurma().equals(lnAtual.getCodTurma()));
	}

	static boolean testaJanela(Linha lnAnterior, Linha lnAtual) {
		return (lnAtual.getDataSegundos() - lnAnterior.getDataSegundos()) <= 60;
	}
}
