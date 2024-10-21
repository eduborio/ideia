package br.com.ideia.domain;

import java.io.File;
import java.io.FilenameFilter;

public class FiltroArquivos implements FilenameFilter {

	@Override
	public boolean accept(File dir, String filename) {
		return filename.toUpperCase().endsWith(".TXT");
	}

}
