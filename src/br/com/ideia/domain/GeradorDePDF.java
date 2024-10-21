package br.com.ideia.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeradorDePDF {
	
	private List<BoletoAdapter> boletos;
	private String layout;

	public GeradorDePDF(List<BoletoAdapter> boletos, String layout) {
		this.boletos = boletos;
		this.layout = layout;
	}
	
	public void gerar(String caminho, String arquivo) {
		
		String filename = arquivo.replaceAll(".txt",".pdf");
		filename = filename.replaceAll(".TXT",".PDF");
		filename = filename.replaceAll(".Txt",".PDF");
		
		InputStream customTemplate = GeradorDePDF.class.getResourceAsStream("/br/com/ideia/domain/layouts/"+layout);

		Map<String, Object> params = new HashMap<String, Object>();
		GeradorDeBoletoIdeia gerador = new GeradorDeBoletoIdeia(customTemplate,params, boletos);
		byte [] pdfBytes = gerador.gerarPDF();
		
		try {
			File arquivoPdf = new  File(caminho +"/"+ filename);
			FileOutputStream outputStream = new FileOutputStream(arquivoPdf);
			outputStream.write(pdfBytes);
			outputStream.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
