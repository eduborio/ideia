package br.com.ideia.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.bancos.Bradesco;
import br.com.ideia.domain.layouts.Caixa;
import br.com.ideia.domain.layouts.BancoItau;
import br.com.ideia.domain.layouts.BancoSafra;
import br.com.ideia.domain.layouts.BancoSantander;
import br.com.ideia.domain.layouts.Sicoob;

public class BoletoBuilder {

	private List<DadosBoleto> dados;

	public BoletoBuilder(List<DadosBoleto> dados) {
		this.dados = dados;
	}

	public List<BoletoAdapter> geraBoletos() {
		
		List<BoletoAdapter> boletoList = new ArrayList<BoletoAdapter>();
		
		for(DadosBoleto info: dados) {
			
			boletoList.add( geraUmBoleto(info) );
			
		}
		
		return boletoList;
		
	}

	private BoletoAdapter geraUmBoleto(DadosBoleto info) {
		
		String nossoNumero = info.getNossoNumero();
		
		Calendar doc = Calendar.getInstance();
		doc.setTime(info.getEmissao());
		
		Calendar proc = Calendar.getInstance();
		proc.setTime(new Date());
		
		Calendar venc = Calendar.getInstance();
		venc.setTime(info.getVencimento());
		
		Datas datas = Datas.novasDatas()
				.comDocumento(doc)
				.comProcessamento(proc)
				.comVencimento(venc);
		
		//String empresa[] = info.getBeneficiario().split(" - ");
		//int cepIndex = info.getBeneficiario().indexOf("CEP");
		//String cep = info.getBeneficiario().substring(cepIndex,cepIndex+12);
		//System.out.println(cep);
		
		Endereco endEmpresa = Endereco.novoEndereco()
				.comBairro(info.getBairroBeneficiario())
				.comCep( info.getCepBeneficiario() )
				.comCidade( info.getCidadeBeneficiario() )
				.comLogradouro( info.getLogradouroBeneficiario() )
				.comUf( info.getUfBeneficiario() );
		
		Beneficiario beneficiario = null;
		String localDePagamento = "Pagável em qualquer banco até o vencimento.";
		
		if(info.getNumeroBanco().equals("001")){
			
			 localDePagamento = info.getLocalPagamento();
		     beneficiario = Beneficiario.novoBeneficiario()
		    		 .comAgencia(info.getAgencia())
						.comDigitoAgencia(info.getDigitoAgencia())
						.comCodigoBeneficiario(info.getNumeroConta())
						.comDigitoCodigoBeneficiario(info.getDigitoConta())
						.comNumeroConvenio(info.getConvenioBB())
						.comCarteira(info.getCarteira().substring(1))
						.comEndereco(endEmpresa)
						.comNomeBeneficiario( info.getBeneficiario() )
						.comDocumento( info.getCnpjBeneficiario() )
						.comNossoNumero(nossoNumero);
		     
		}else if(info.getNumeroBanco().equals("033")) {
			
			localDePagamento = info.getLocalPagamento();
			beneficiario = Beneficiario.novoBeneficiario()
					.comAgencia(info.getAgencia())
					.comDigitoAgencia(info.getDigitoAgencia())
					.comNumeroConvenio(info.getNumeroConta()+info.getDigitoConta())
					.comCarteira(info.getCarteira())
					.comEndereco(endEmpresa)
					.comNomeBeneficiario( info.getBeneficiario() )
					.comDocumento( info.getCnpjBeneficiario() )
					.comNossoNumero(info.getNossoNumero())
					.comDigitoNossoNumero(info.getDigitoNossoNumero());
			
		} else if(info.getNumeroBanco().equals("422")){
			
			localDePagamento = info.getLocalPagamento();
			
			beneficiario = Beneficiario.novoBeneficiario()
				.comAgencia(info.getAgencia())
				.comDigitoAgencia(info.getDigitoAgencia())
				.comCodigoBeneficiario(info.getNumeroConta())
				.comDigitoCodigoBeneficiario(info.getDigitoConta())
				.comCarteira(info.getCarteira())
				.comEndereco(endEmpresa)
				.comNomeBeneficiario( info.getBeneficiario() )
				.comDocumento( info.getCnpjBeneficiario() )
				.comNossoNumero(nossoNumero+info.getDigitoNossoNumero())
				;
			
		} else if(info.getNumeroBanco().equals("756")){
			
			localDePagamento = info.getLocalPagamento();
			
			beneficiario = Beneficiario.novoBeneficiario()
				.comAgencia(info.getAgencia())
				.comDigitoAgencia(info.getDigitoAgencia())
				.comCodigoBeneficiario(info.getNumeroConta())
				.comDigitoCodigoBeneficiario(info.getDigitoConta())
				.comCarteira(info.getCarteira())
				.comEndereco(endEmpresa)
				.comNomeBeneficiario( info.getBeneficiario() )
				.comDocumento( info.getCnpjBeneficiario() )
				.comNossoNumero(nossoNumero)
				.comDigitoNossoNumero(info.getDigitoNossoNumero())
				;	
		     
		}else if(info.getNumeroBanco().equals("237")) {
		 	
		 	beneficiario = Beneficiario.novoBeneficiario()
		 			.comAgencia(info.getAgencia())
		 			.comDigitoAgencia(info.getDigitoAgencia())
		 			.comCodigoBeneficiario(info.getNumeroConta())
		 			.comDigitoCodigoBeneficiario(info.getDigitoConta())
		 			.comCarteira(info.getCarteira().substring(1))
		 			.comEndereco(endEmpresa)
		 			.comNomeBeneficiario( info.getBeneficiario() )
		 			.comDocumento( info.getCnpjBeneficiario() )
		 			.comNossoNumero(info.getNossoNumero())
		 			.comDigitoNossoNumero(info.getDigitoNossoNumero());
				
		}else if(info.getNumeroBanco().equals("104")) {
		 	
		 	beneficiario = Beneficiario.novoBeneficiario()
		 			.comAgencia(info.getAgencia())
		 			.comCarteira(info.getCarteira())
		 			.comCodigoBeneficiario(info.getNumeroConta())
		 			.comDigitoCodigoBeneficiario(info.getDigitoConta())
		 			.comNossoNumero(info.getNossoNumero())
		 			.comDigitoNossoNumero(info.getDigitoNossoNumero())
		 			.comEndereco(endEmpresa)
		 			.comNomeBeneficiario( info.getBeneficiario() )
		 			.comDocumento( info.getCnpjBeneficiario() );
		 	
		 	if(info.getConvenioBB() != null) {
		 		
		 		beneficiario = Beneficiario.novoBeneficiario()
			 			.comAgencia(info.getAgencia())
			 			.comCarteira(info.getCarteira())
			 			.comCodigoBeneficiario(info.getConvenioBB().substring(0, 6))
			 			.comDigitoCodigoBeneficiario(info.getConvenioBB().substring(6, 7))
			 			.comNossoNumero(info.getNossoNumero())
			 			.comDigitoNossoNumero(info.getDigitoNossoNumero())
			 			.comEndereco(endEmpresa)
			 			.comNomeBeneficiario( info.getBeneficiario() )
			 			.comDocumento( info.getCnpjBeneficiario() );
		 		
		 	}
				
		}else if(info.getNumeroBanco().equals("341")) {
		 	
		 	beneficiario = Beneficiario.novoBeneficiario()
		 			.comAgencia(info.getAgencia())
		 			.comCodigoBeneficiario(info.getNumeroConta())
		 			.comDigitoCodigoBeneficiario(info.getDigitoConta())
		 			.comCarteira(info.getCarteira())
		 			.comEndereco(endEmpresa)
		 			.comNomeBeneficiario( info.getBeneficiario() )
		 			.comDocumento( info.getCnpjBeneficiario() )
		 			.comNossoNumero(info.getNossoNumero())
		 			.comDigitoNossoNumero(info.getDigitoNossoNumero());
				
		}
		
		else{
			
			beneficiario = Beneficiario.novoBeneficiario()
			.comAgencia(info.getAgencia())
			.comDigitoAgencia(info.getDigitoAgencia())
			.comCodigoBeneficiario(info.getNumeroConta())
			.comDigitoCodigoBeneficiario(info.getDigitoConta())
			.comCarteira(info.getCarteira().substring(1))
			.comEndereco(endEmpresa)
			.comNomeBeneficiario( info.getBeneficiario() )
			.comDocumento( info.getCnpjBeneficiario() )
			.comNossoNumero(info.getNossoNumero())
			.comDigitoNossoNumero(info.getDigitoNossoNumero());
			
		}
		
		Endereco endCliente = Endereco.novoEndereco()
				.comBairro( info.getBairroSacado() )
				.comCep( info.getCepSacado() )
				.comCidade( info.getCidadeSacado() )
				.comLogradouro( info.getLogradouroSacado()+", "+info.getNumeroSacado() )
				.comUf(info .getUfSacado() );
		
		Pagador pagador = Pagador.novoPagador()
				.comDocumento( info.getCnpjSacado() )
				.comNome( info.getNomeSacado() )
				.comEndereco(endCliente);
		
		
		br.com.caelum.stella.boleto.Banco banco =null;
		
		if(info.getNumeroBanco().equals("001"))
			banco = new BancoDoBrasil();
		
		if(info.getNumeroBanco().equals("033"))
			banco = new BancoSantander();
		
		if(info.getNumeroBanco().equals("341"))
			banco = new BancoItau();
		
		if(info.getNumeroBanco().equals("237"))
			banco = new Bradesco();
		
		if(info.getNumeroBanco().equals("422"))
			banco = new BancoSafra();
		
		if(info.getNumeroBanco().equals("104"))
			banco = new Caixa();
		
		if(info.getNumeroBanco().equals("756"))
			banco = new Sicoob();
		
		Boleto boleto = Boleto.novoBoleto()
				.comAceite(Boolean.FALSE)
				.comDatas(datas)
				.comBanco(banco)
				.comEspecieDocumento("DM")
				.comBeneficiario(beneficiario)
				.comPagador(pagador)
				.comValorBoleto(info.getValorTitulo())
				.comNumeroDoDocumento(info.getNumeroFatura())
				.comInstrucoes(info.getInstrucao1(),info.getInstrucao2(),info.getInstrucao3())
				.comLocaisDePagamento(localDePagamento)
				.comDescricoes(info.getParcela())
				;
		
		
		return new BoletoAdapter(info, boleto);
		
	}
	
	public static void main(String[] args) {
		
		
		String str = "1234567";
		
		System.out.println(str.substring(0, 6));
		System.out.println(str.substring(6, 7));
	}
	
	

}
