package br.com.ideia.domain.layouts;

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
		campoLivre.append(DIGITO_NUMERO_SiCOOB);
		campoLivre.append(beneficiario.getAgencia());
		campoLivre.append(beneficiario.getCodigoBeneficiario());
		campoLivre.append(beneficiario.getDigitoCodigoBeneficiario());
		campoLivre.append(getNossoNumeroFormatado(beneficiario));
		campoLivre.append("2");
		//System.out.println(campoLivre.toString());
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}

	@Override
	public String getCarteiraFormatado(Beneficiario benef) {
		return benef.getCarteira();
	}

	@Override
	public String getCodigoBeneficiarioFormatado(Beneficiario benef) {
		return benef.getCodigoBeneficiario();
	}

	@Override
	public URL getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNossoNumeroFormatado(Beneficiario benef) {
		return benef.getNossoNumero();
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
