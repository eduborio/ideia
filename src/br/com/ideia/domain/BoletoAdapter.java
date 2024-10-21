package br.com.ideia.domain;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Calendar;

import br.com.caelum.stella.boleto.Boleto;

public class BoletoAdapter{

	private DadosBoleto dados;
	private Boleto boleto;
	
	public BoletoAdapter(DadosBoleto dados,Boleto boleto) {
		this.dados = dados;
		this.boleto = boleto;
	}
	
	public String getDadosBeneficiario() {
		
		StringBuilder sb = new StringBuilder();
		sb.append( dados.getBeneficiario() );
		sb.append( " - " );
		sb.append( dados.getCnpjBeneficiario() );
		sb.append( " - " );
		sb.append( dados.getLogradouroBeneficiario() );
		sb.append( ", " );
		sb.append( dados.getNumeroBeneficiario() );
		sb.append( " - " );
		sb.append( dados.getBairroBeneficiario() );
		sb.append( " - " );
		sb.append( dados.getCidadeBeneficiario() );
		sb.append( "/" );
		sb.append( dados.getUfBeneficiario() );
		sb.append( " - " );
		sb.append( dados.getCepBeneficiario() );
		
		return sb.toString();
	}
	
	public String getDocumentoBeneficiario() {
		return dados.getCnpjBeneficiario();
	}
	
	public String getPagadorNome() {
		return dados.getNomeSacado();
	}
	
	public String getPagadorCNPJ() {
		return dados.getCnpjSacado();
	}
	
	public String getAgenciaComDigito() {
		return dados.getAgencia() + "-" + dados.getDigitoAgencia();
	}
	
	public String getContaComDigito() {
		return dados.getNumeroConta() + "-" + dados.getDigitoConta();
	}
	
	public String getLocalDePagamento() {
		return dados.getLocalPagamento();
	}
	
	public String getNossoNumero() {
		return dados.getNossoNumero();
	}
	
	public String getNumeroFatura() {
		return dados.getNumeroFatura();
	}
	
	public String getEspecieDocumento() {
		return dados.getTipoDocumento();
	}
	
	public String getAceite() {
		return dados.getAceite();
	}
	
	public String getCarteira() {
		return dados.getCarteira();
	}
	
	public String getEspecieMoeda() {
		return "REAL";
	}
	
	public String getQuantidadeDeMoeda() {
		return "";
	}
	
	public String getValorMoeda() {
		return "";
	}
	
	public String getNomePagador() {
		return dados.getNomeSacado();
	}
	
	public String getDocumentoPagador() {
		return dados.getCnpjSacado();
	}
	
	public String getLogradouroPagador() {
		return dados.getLogradouroSacado();
	}
	
	public String getCepPagador() {
		return dados.getCepSacado();
	}
	
	public String getCidadePagador() {
		return dados.getCidadeSacado();
	}
	
	public String getBairroPagador() {
		return dados.getBairroSacado();
	}
	
	public String getUfPagador() {
		return dados.getUfSacado();
	}
	
	public String getLinhaDigitavel() {
		return boleto.getLinhaDigitavel();
	}
	
	public String getCodigoDeBarras() {
		return boleto.getCodigoDeBarras();
	}
	
	public BigDecimal getValorBoleto() {
		return boleto.getValorBoleto();
	}
	
	public Calendar getVencimento() {
		return boleto.getDatas().getVencimento();
	}
	
	public Calendar getDocumento() {
		return boleto.getDatas().getDocumento();
	}
	
	public Calendar getProcessamento() {
		return boleto.getDatas().getProcessamento();
	}
	
	public String getInstrucao01() {
		return dados.getInstrucao1();
	}
	
	public String getInstrucao02() {
		return dados.getInstrucao2();
	}
	
	public String getInstrucao03() {
		return dados.getInstrucao3();
	}
	
	public String getInstrucao04() {
		return dados.getInstrucao4();
	}
	
	public String getInstrucao05() {
		return dados.getInstrucao5();
	}
	
	public String getInstrucao06() {
		return dados.getInstrucao6();
	}
	
	public String getNumeroFormatadoComDigito() {
		return boleto.getBanco().getNumeroFormatadoComDigito();
	}
	
	public URL getLogo_banco() {
        String pathDoArquivo = "/br/com/ideia/domain/layouts/images/%s.png";
        String imagem = String.format(pathDoArquivo, dados.getNumeroBanco());
        return getClass().getResource(imagem);
    }
	
	public String getConvenio() {
		return dados.getConvenioBB();
	}
	
	public String getNumeroBanco() {
		return dados.getNumeroBanco();
	}
	
	public String getAgenciaSemDigito() {
		return dados.getAgencia();
	}
	
	public String getDigitoNossoNumero() {
		return dados.getDigitoNossoNumero();
	}

}
