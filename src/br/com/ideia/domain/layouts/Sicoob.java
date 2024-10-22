package br.com.ideia.domain.layouts;

import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.bancos.AbstractBanco;

public class Sicoob extends AbstractBanco implements Banco{
	
	private static final long serialVersionUID = 1L;

	private static final String NUMERO_SICCOB = "756";

	private static final String DIGITO_NUMERO_SiCOOB = "7";

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		
		Beneficiario beneficiario = boleto.getBeneficiario();
		StringBuilder campoLivre = new StringBuilder();
		campoLivre.append(getCarteiraFormatado(beneficiario));
		System.out.println(getCarteiraFormatado(beneficiario));
		
		campoLivre.append(getAgenciaFormatado(beneficiario));
		System.out.println(getAgenciaFormatado(beneficiario));
		
		campoLivre.append(getModalidadeFormatado(beneficiario));
		System.out.println(getModalidadeFormatado(beneficiario));
		
		campoLivre.append(getCodigoBeneficiarioFormatado(beneficiario));
		System.out.println(getCodigoBeneficiarioFormatado(beneficiario));
		
		campoLivre.append(getNossoNumeroFormatado(beneficiario));
		System.out.println(getNossoNumeroFormatado(beneficiario));
		
		campoLivre.append(numeroDaParcelaFormatado(boleto));
		System.out.println(numeroDaParcelaFormatado(boleto));
		//System.out.println(campoLivre.toString());
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}
	
	private Object numeroDaParcelaFormatado(Boleto boleto) {
		return leftPadWithZeros(boleto.getDescricoes().get(0),3);
	}

	private String getAgenciaFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getAgencia(),4);
	}
	
	private String getModalidadeFormatado(Beneficiario beneficiario) {
		return "01"; //Simples com Registro
	}

	@Override
	public String getCarteiraFormatado(Beneficiario benef) {
		return benef.getCarteira().substring(0,1);
	}
	
	@Override
	public String getCodigoBeneficiarioFormatado(Beneficiario benef) {
		return leftPadWithZeros(benef.getCodigoBeneficiario(),7) + benef.getDigitoCodigoBeneficiario();
	}

	@Override
	public URL getImage() {
		return null;
	}

	@Override
	public String getNossoNumeroFormatado(Beneficiario benef) {
		return leftPadWithZeros(benef.getNossoNumero(),8);
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_SICCOB;
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		return NUMERO_SICCOB.concat(DIGITO_NUMERO_SiCOOB) ;
	}

}
