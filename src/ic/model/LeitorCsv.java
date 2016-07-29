package ic.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeitorCsv {

	private InputStream is;
	private BufferedReader br;
	
	public LeitorCsv(String path) {
		try {
			is = new FileInputStream(new File("../LogsMatAdm.csv"));
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado");
		}
		br = new  BufferedReader(new InputStreamReader(is));
	}

	public BufferedReader getFileToRead() {
		return br;
	}
	
	
}
