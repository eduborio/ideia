package br.com.ideia.domain.layouts;

import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;
import static br.com.caelum.stella.boleto.utils.StellaStringUtils.prefixNotNullStringOrDefault;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.bancos.AbstractBanco;

public class BancoItau extends AbstractBanco implements Banco {

	private static final long serialVersionUID = 1L;

	private static final String NUMERO_ITAU = "341";
	private static final String DIGITO_ITAU = "7";

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		Beneficiario beneficiario = boleto.getBeneficiario();
		String carteira = beneficiario.getCarteira();
		StringBuilder campoLivre = new StringBuilder();
		//String all =
		//		beneficiario.getAgenciaFormatada()+ 
		//		getCodigoBeneficiarioFormatado(beneficiario)+
		//		getCarteiraFormatado(beneficiario) +
		//		getNossoNumeroFormatado(beneficiario);
		
		String agenciaECC = beneficiario.getAgenciaFormatada()+ 
				getCodigoBeneficiarioFormatado(beneficiario);
		
		String carteiraNN = getCarteiraFormatado(beneficiario) +
				getNossoNumeroFormatado(beneficiario);
				
		
		if("112".equals(carteira)) {
			
			//System.out.println("Dados all....: " + all );
			//System.out.println("Dados ag e cc: " + agenciaECC );
			//System.out.println("Dados cart nn: " + agenciaECC );
			//System.out.println("DAC all......: " + this.geradorDeDigito.geraDigitoMod10(all));
			//S/ystem.out.println("DAC ag e cc..: " + this.geradorDeDigito.geraDigitoMod10(agenciaECC));
			//System.out.println("DAC cart enn.: " + this.geradorDeDigito.geraDigitoMod10(carteiraNN));
			
			campoLivre.append(getCarteiraFormatado(beneficiario));
			campoLivre.append(getNossoNumeroFormatado(beneficiario));
			campoLivre.append(this.geradorDeDigito.geraDigitoMod10(carteiraNN));
			campoLivre.append(beneficiario.getAgenciaFormatada());
			campoLivre.append(getCodigoBeneficiarioFormatado(beneficiario));
			campoLivre.append(this.geradorDeDigito.geraDigitoMod10(agenciaECC));
			campoLivre.append("000");
		}else {
			campoLivre.append(getCarteiraFormatado(beneficiario));
			campoLivre.append(getNossoNumeroFormatado(beneficiario));
			campoLivre.append(beneficiario.getAgenciaFormatada());
			campoLivre.append(getCodigoBeneficiarioFormatado(beneficiario)).append("000");
			campoLivre.insert(20, this.geradorDeDigito.geraDigitoMod10(campoLivre.substring(11, 20)));
			campoLivre.insert(11, this.geradorDeDigito.geraDigitoMod10(campoLivre.substring(11, 20).concat(campoLivre.substring(0, 11))));
		}
		
		//System.out.println("Barras:" + new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre));
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		StringBuilder builder = new StringBuilder();
		builder.append(getNumeroFormatado()).append("-");
		return builder.append(DIGITO_ITAU).toString();
	}

	@Override
	public String getCarteiraFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCarteira(), 3);
	}

	@Override
	public String getCodigoBeneficiarioFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCodigoBeneficiario(), 5);
	}

	@Override
	public URL getImage() {
		String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = String.format(arquivo, getNumeroFormatado());
		return getClass().getResource(imagem);
	}

	@Override
	public String getNossoNumeroFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getNossoNumero(), 8);
	}
	
	@Override
	public String getNossoNumeroECodigoDocumento(Boleto boleto) {
		String valor = super.getNossoNumeroECodigoDocumento(boleto);
		Beneficiario beneficiario = boleto.getBeneficiario();
		return valor.concat("-").concat(beneficiario.getDigitoNossoNumero());
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_ITAU;
	}
	
	@Override
	public String getAgenciaECodigoBeneficiario(Beneficiario beneficiario) {
		StringBuilder builder = new StringBuilder();
		builder.append(beneficiario.getAgenciaFormatada()).append("/");
		builder.append(getCodigoBeneficiarioFormatado(beneficiario));
		builder.append(prefixNotNullStringOrDefault(beneficiario.getDigitoCodigoBeneficiario(),"","-"));	
		return builder.toString();
	}

}
