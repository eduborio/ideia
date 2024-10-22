package br.com.ideia.domain.layouts;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.bancos.AbstractBanco;
import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

public class BancoSafra extends AbstractBanco implements Banco{
	
	private static final long serialVersionUID = 1L;

	private static final String NUMERO_SAFRA = "422";

	private static final String DIGITO_NUMERO_SAFRA = "7";

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		Beneficiario beneficiario = boleto.getBeneficiario();
		
		StringBuilder campoLivre = new StringBuilder("7");
		campoLivre.append(getAgenciaFormatado(beneficiario));//Agencia
		campoLivre.append(beneficiario.getDigitoAgencia());// Digito agencia
		campoLivre.append(getCodigoBeneficiarioFormatado(beneficiario));// Conta 9 Digitos
		campoLivre.append(getNossoNumeroFormatado(beneficiario)); //Nosso Numero com 9 Digitos
		campoLivre.append("2"); // Não sei do que se trata
		
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}

	private String getAgenciaFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getAgencia(),4);
	}

	@Override
	public String getCarteiraFormatado(Beneficiario benef) {
		return benef.getCarteira();
	}

	@Override
	public String getCodigoBeneficiarioFormatado(Beneficiario benef) {
		return leftPadWithZeros(benef.getCodigoBeneficiario(),8) + benef.getDigitoCodigoBeneficiario();
	}

	@Override
	public URL getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNossoNumeroFormatado(Beneficiario benef) {
		return leftPadWithZeros(benef.getNossoNumero(),9);
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_SAFRA;
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		return NUMERO_SAFRA.concat(DIGITO_NUMERO_SAFRA) ;
	}

}
