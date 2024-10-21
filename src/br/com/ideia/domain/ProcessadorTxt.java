package br.com.ideia.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProcessadorTxt {
	
	private File file;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public ProcessadorTxt(File file) {
		this.file = file;
	}
	
	public List<DadosBoleto> texto2Boleto() throws IOException{
		
		List<DadosBoleto> boletoList = new ArrayList<DadosBoleto>();
		
		InputStreamReader reader = null;
		BufferedReader leitor = null;
		String linhaArquivo = null;
		try{
			reader = new InputStreamReader(new FileInputStream(file),StandardCharsets.UTF_8);         
			leitor = new BufferedReader(reader);
			
			while ((linhaArquivo = leitor.readLine()) != null) {
				DadosBoleto boleto  = processaLinha(leitor,linhaArquivo);
				boletoList.add(boleto);
			}
			
			leitor.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(leitor!=null)
				leitor.close();
			
			if(reader!=null)
				reader.close();
			
		}
		
		return boletoList;
	}

	private DadosBoleto processaLinha(BufferedReader leitor, String linha) {
		
		DadosBoleto boleto = new DadosBoleto();
		
		String[] campos = linha.split("\\|");
		
		try {
			boleto.setBeneficiario          ( campos[0] );
			boleto.setCnpjBeneficiario      ( campos[1] );
			boleto.setLogradouroBeneficiario( campos[2] );
			boleto.setNumeroBeneficiario    ( campos[3] );
			boleto.setBairroBeneficiario    ( campos[4] );
			boleto.setCidadeBeneficiario    ( campos[5] );
			boleto.setUfBeneficiario        ( campos[6] );
			boleto.setCepBeneficiario       ( campos[7] );
			boleto.setCnpjBeneficiario      ( campos[8] );
			
			boleto.setNomeSacado         ( campos[9] );
			boleto.setCnpjSacado         ( campos[10] );
			boleto.setUfSacado           ( campos[11] );
			boleto.setCidadeSacado       ( campos[12] );
			boleto.setCepSacado          ( campos[13] );
			boleto.setBairroSacado       ( campos[14] );
			boleto.setLogradouroSacado   ( campos[15] );
			boleto.setNumeroSacado       ( campos[16] );
			                            
			boleto.setNomeAvalista       ( campos[17]);
			boleto.setCnpjAvalista       ( campos[18]);
			boleto.setUfAvalista         ( campos[19]);
			boleto.setCidadeAvalista     ( campos[20]);
			boleto.setCepAvalista        ( campos[21]);
			boleto.setBairroAvalista     ( campos[22]);
			boleto.setLogradouroAvalista ( campos[23]);
			boleto.setNumeroAvalista     ( campos[24]);
			                             
			boleto.setNumeroBanco        ( campos[25] );
			boleto.setNumeroConta        ( campos[26] );
			boleto.setDigitoConta        ( campos[27] );
			boleto.setCarteira           ( campos[28] );
			boleto.setAgencia            ( campos[29] );
			boleto.setDigitoAgencia      ( campos[30] );
			boleto.setNumeroFatura       ( campos[31] );
			boleto.setNossoNumero        ( campos[32] );
			boleto.setDigitoNossoNumero  ( campos[33] );
			boleto.setValorTitulo        ( Double.parseDouble(campos[34]));
			
			boleto.setEmissao            ( sdf.parse(campos[35]) );
			boleto.setVencimento         ( sdf.parse(campos[36]) );
			boleto.setTipoDocumento      ( campos[37] );
			
			boleto.setAceite             ( campos[38] );
			
			if(campos[39] != null && !campos[39].isEmpty())
				boleto.setDesconto           ( Double.parseDouble(campos[39]));
			
			if(campos[40] != null && !campos[40].isEmpty())
				boleto.setDeducao            ( Double.parseDouble(campos[40]));
			
			if(campos[41] != null && !campos[41].isEmpty())
			boleto.setMora               ( Double.parseDouble(campos[41]));
			
			if(campos[42] != null && !campos[42].isEmpty())
				boleto.setAcrescimo          ( Double.parseDouble(campos[42]));
			
			if(campos[43] != null && !campos[43].isEmpty())
				boleto.setValorCobrado       ( Double.parseDouble(campos[43]));
			
			boleto.setCodigoOperacao     ( campos[44] );
			boleto.setLocalPagamento     ( campos[45] );
			
 			boleto.setInstrucao1         ( campos[46] );
			boleto.setInstrucao2         ( campos[47] );
			boleto.setInstrucao3         ( campos[48] );
			boleto.setInstrucao4         ( campos[49] );
			boleto.setInstrucao5         ( campos[50] );
			boleto.setInstrucao6         ( campos[51] );
			boleto.setInstrucao7         ( campos[52] );
			boleto.setInstrucao8         ( campos[53] );
			boleto.setInstrucao9         ( campos[54] );
			boleto.setInstrucao10        ( campos[55] );
			
			if(boleto.getNumeroBanco().equals("001") || boleto.getNumeroBanco().equals("104") )
				boleto.setConvenioBB         ( campos[56] );
			
		}catch (Exception e) {
			System.out.println(campos[33]);
			e.printStackTrace();
		}
		
		return boleto;
	}
	

}
