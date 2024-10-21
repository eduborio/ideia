package br.com.ideia.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class IdeiaBoleto {
	
	static String processar   = "/apps/cobranca/processar";
	static String processados = "/apps/cobranca/processado";
	static String caminhoArquivoPdf = "/apps/cobranca/boletos/";
	private static String layoutBoleto = "padraoIdeia.jasper";
	
	public static void main(String[] args) {
		
		nolog();
		
		if(args.length > 0)	processar = args[0];
		if(args.length > 1) processados = args[1];
		if(args.length > 2) caminhoArquivoPdf = args[2];
		if(args.length > 3) layoutBoleto = args[3];
		
		if(layoutBoleto.contains("carne"))
			layoutBoleto = "carne.jasper";
		
		File dir = new File(processar);
		FiltroArquivos filtro   = new FiltroArquivos();
		List<DadosBoleto> dados = new ArrayList<DadosBoleto>();
			
		for(File txt : dir.listFiles(filtro)){
		
			try {
				
				dados = new ProcessadorTxt(txt).texto2Boleto();
				BoletoBuilder builder = new BoletoBuilder(dados);
				GeradorDePDF gerador = new GeradorDePDF(builder.geraBoletos(),layoutBoleto);
				gerador.gerar(caminhoArquivoPdf, txt.getName());
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				moverArquivo(txt);
			}
		}
		
		return;
		
	}
	
	private static void nolog() {
		
		//@SuppressWarnings("unused")
		PrintStream noLogStream = new PrintStream(new OutputStream() {
		    public void write(int b) {
		        
		    }
		});
		
		System.setOut(noLogStream);
		System.setErr(noLogStream);
		
	}

	private static void moverArquivo(File file) {
		
		try{
			File destino = new File(processados+"/"+file.getName());
			InputStream inStream = new FileInputStream(file);
			OutputStream outStream = new FileOutputStream(destino);
	 
			byte[] buffer = new byte[1024];
	 
			int length;
			while ((length = inStream.read(buffer)) > 0){
				outStream.write(buffer, 0, length);
			}
	 
			inStream.close();
			outStream.close();
	 
			file.delete();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
