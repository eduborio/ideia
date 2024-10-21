package br.com.ideia.domain;

import java.util.Date;

public class DadosBoleto {

	private String beneficiario;
	private String cnpjBeneficiario;
	private String logradouroBeneficiario;
	private String numeroBeneficiario;
	private String bairroBeneficiario;
	private String cidadeBeneficiario;
	private String ufBeneficiario;
	private String cepBeneficiario;

	private String nomeSacado;
	private String cnpjSacado;
	private String ufSacado;
	private String cidadeSacado;
	private String cepSacado;
	private String bairroSacado;
	private String logradouroSacado;
	private String numeroSacado;

	private String nomeAvalista;
	private String cnpjAvalista;
	private String ufAvalista;
	private String cidadeAvalista;
	private String cepAvalista;
	private String bairroAvalista;
	private String logradouroAvalista;
	private String numeroAvalista;

	private String numeroBanco;
	private String numeroConta;
	private String digitoConta;
	private String carteira;
	private String agencia;
	private String digitoAgencia;
	private String numeroFatura;
	private String nossoNumero;
	private String digitoNossoNumero;
	private double valorTitulo;
	private Date emissao;
	private Date vencimento;
	private String tipoDocumento;

	private String aceite; // Aceite do Sacado
	private double desconto; // Desconto Título
	private double deducao; // Dedução Título
	private double mora; // Valor de Mora
	private double acrescimo; // Acréscimo do Título
	private double valorCobrado; // Valor Cobrado
	private String codigoOperacao;// Código da Operação
	private String localPagamento;// Local de Pagamento (PREFERENCIALMENTE PAGAR NO ....)
	private String instrucao1; // Instrução do Sacado 1
	private String instrucao2; // Instrução do Sacado 2
	private String instrucao3; // Instrução do Sacado 3
	private String instrucao4; // Instrução do Sacado 4
	private String instrucao5; // Instrução do Sacado 5
	private String instrucao6; // Instrução do Sacado 6
	private String instrucao7; // Instrução do Sacado 7
	private String instrucao8; // Instrução do Sacado 8
	private String instrucao9; // Instrução do Sacado 9
	private String instrucao10; // Instrução do Sacado 9
	private String convenioBB; // Instrução do Sacado 9

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(beneficiario);
		sb.append(" - ");
		sb.append(cnpjBeneficiario);
		sb.append(" - ");

		sb.append(nomeSacado);
		sb.append(" - ");
		sb.append(cnpjSacado);
		sb.append(" - ");
		sb.append(ufSacado);
		sb.append(" - ");
		sb.append(cidadeSacado);
		sb.append(" - ");
		sb.append(cepSacado);
		sb.append(" - ");
		sb.append(bairroSacado);
		sb.append(" - ");
		sb.append(logradouroSacado);
		sb.append(" - ");

		sb.append(nomeAvalista);
		sb.append(" - ");
		sb.append(cnpjAvalista);
		sb.append(" - ");
		sb.append(ufAvalista);
		sb.append(" - ");
		sb.append(cidadeAvalista);
		sb.append(" - ");
		sb.append(cepAvalista);
		sb.append(" - ");
		sb.append(bairroAvalista);
		sb.append(" - ");
		sb.append(logradouroAvalista);
		sb.append(" - ");
		sb.append(numeroAvalista);
		sb.append(" - ");

		sb.append(numeroBanco);
		sb.append(" - ");
		sb.append(numeroConta);
		sb.append(" - ");
		sb.append(digitoConta);
		sb.append(" - ");
		sb.append(carteira);
		sb.append(" - ");
		sb.append(agencia);
		sb.append(" - ");
		sb.append(digitoAgencia);
		sb.append(" - ");
		sb.append(numeroFatura);
		sb.append(" - ");
		sb.append(nossoNumero);
		sb.append(" - ");
		sb.append(digitoNossoNumero);
		sb.append(" - ");
		sb.append(valorTitulo);
		sb.append(" - ");
		sb.append(emissao);
		sb.append(" - ");
		sb.append(vencimento);
		sb.append(" - ");
		sb.append(tipoDocumento);

		return sb.toString();

	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getCnpjBeneficiario() {
		return cnpjBeneficiario;
	}

	public void setCnpjBeneficiario(String cnpjBeneficiario) {
		this.cnpjBeneficiario = cnpjBeneficiario;
	}

	public String getNomeSacado() {
		return nomeSacado;
	}

	public void setNomeSacado(String nomeSacado) {
		this.nomeSacado = nomeSacado;
	}

	public String getCnpjSacado() {
		return cnpjSacado;
	}

	public void setCnpjSacado(String cnpjSacado) {
		this.cnpjSacado = cnpjSacado;
	}

	public String getUfSacado() {
		return ufSacado;
	}

	public void setUfSacado(String ufSacado) {
		this.ufSacado = ufSacado;
	}

	public String getCidadeSacado() {
		return cidadeSacado;
	}

	public void setCidadeSacado(String cidadeSacado) {
		this.cidadeSacado = cidadeSacado;
	}

	public String getCepSacado() {
		return cepSacado;
	}

	public void setCepSacado(String cepSacado) {
		this.cepSacado = cepSacado;
	}

	public String getBairroSacado() {
		return bairroSacado;
	}

	public void setBairroSacado(String bairroSacado) {
		this.bairroSacado = bairroSacado;
	}

	public String getLogradouroSacado() {
		return logradouroSacado;
	}

	public void setLogradouroSacado(String logradouroSacado) {
		this.logradouroSacado = logradouroSacado;
	}

	public String getNomeAvalista() {
		return nomeAvalista;
	}

	public void setNomeAvalista(String nomeAvalista) {
		this.nomeAvalista = nomeAvalista;
	}

	public String getCnpjAvalista() {
		return cnpjAvalista;
	}

	public void setCnpjAvalista(String cnpjAvalista) {
		this.cnpjAvalista = cnpjAvalista;
	}

	public String getUfAvalista() {
		return ufAvalista;
	}

	public void setUfAvalista(String ufAvalista) {
		this.ufAvalista = ufAvalista;
	}

	public String getCidadeAvalista() {
		return cidadeAvalista;
	}

	public void setCidadeAvalista(String cidadeAvalista) {
		this.cidadeAvalista = cidadeAvalista;
	}

	public String getCepAvalista() {
		return cepAvalista;
	}

	public void setCepAvalista(String cepAvalista) {
		this.cepAvalista = cepAvalista;
	}

	public String getBairroAvalista() {
		return bairroAvalista;
	}

	public void setBairroAvalista(String bairroAvalista) {
		this.bairroAvalista = bairroAvalista;
	}

	public String getLogradouroAvalista() {
		return logradouroAvalista;
	}

	public void setLogradouroAvalista(String logradouroAvalista) {
		this.logradouroAvalista = logradouroAvalista;
	}

	public String getNumeroAvalista() {
		return numeroAvalista;
	}

	public void setNumeroAvalista(String numeroAvalista) {
		this.numeroAvalista = numeroAvalista;
	}

	public String getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(String numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getDigitoConta() {
		return digitoConta;
	}

	public void setDigitoConta(String digitoConta) {
		this.digitoConta = digitoConta;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getDigitoAgencia() {
		return digitoAgencia;
	}

	public void setDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}

	public String getNumeroFatura() {
		return numeroFatura;
	}

	public void setNumeroFatura(String numeroFatura) {
		this.numeroFatura = numeroFatura;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getDigitoNossoNumero() {
		return digitoNossoNumero;
	}

	public void setDigitoNossoNumero(String digitoNossoNumero) {
		this.digitoNossoNumero = digitoNossoNumero;
	}

	public double getValorTitulo() {
		return valorTitulo;
	}

	public void setValorTitulo(double valorTitulo) {
		this.valorTitulo = valorTitulo;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroSacado() {
		return numeroSacado;
	}

	public void setNumeroSacado(String numeroSacado) {
		this.numeroSacado = numeroSacado;
	}

	public String getAceite() {
		return aceite;
	}

	public void setAceite(String aceite) {
		this.aceite = aceite;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getDeducao() {
		return deducao;
	}

	public void setDeducao(double deducao) {
		this.deducao = deducao;
	}

	public double getMora() {
		return mora;
	}

	public void setMora(double mora) {
		this.mora = mora;
	}

	public double getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(double acrescimo) {
		this.acrescimo = acrescimo;
	}

	public double getValorCobrado() {
		return valorCobrado;
	}

	public void setValorCobrado(double valorCobrado) {
		this.valorCobrado = valorCobrado;
	}

	public String getCodigoOperacao() {
		return codigoOperacao;
	}

	public void setCodigoOperacao(String codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
	}

	public String getLocalPagamento() {
		return localPagamento;
	}

	public void setLocalPagamento(String localPagamento) {
		this.localPagamento = localPagamento;
	}

	public String getInstrucao1() {
		return instrucao1;
	}

	public void setInstrucao1(String instrucao1) {
		this.instrucao1 = instrucao1;
	}

	public String getInstrucao2() {
		return instrucao2;
	}

	public void setInstrucao2(String instrucao2) {
		this.instrucao2 = instrucao2;
	}

	public String getInstrucao3() {
		return instrucao3;
	}

	public void setInstrucao3(String instrucao3) {
		this.instrucao3 = instrucao3;
	}

	public String getInstrucao4() {
		return instrucao4;
	}

	public void setInstrucao4(String instrucao4) {
		this.instrucao4 = instrucao4;
	}

	public String getInstrucao5() {
		return instrucao5;
	}

	public void setInstrucao5(String instrucao5) {
		this.instrucao5 = instrucao5;
	}

	public String getInstrucao6() {
		return instrucao6;
	}

	public void setInstrucao6(String instrucao6) {
		this.instrucao6 = instrucao6;
	}

	public String getInstrucao7() {
		return instrucao7;
	}

	public void setInstrucao7(String instrucao7) {
		this.instrucao7 = instrucao7;
	}

	public String getInstrucao8() {
		return instrucao8;
	}

	public void setInstrucao8(String instrucao8) {
		this.instrucao8 = instrucao8;
	}

	public String getInstrucao9() {
		return instrucao9;
	}

	public void setInstrucao9(String instrucao9) {
		this.instrucao9 = instrucao9;
	}

	public String getInstrucao10() {
		return instrucao10;
	}

	public void setInstrucao10(String instrucao10) {
		this.instrucao10 = instrucao10;
	}

	public String getConvenioBB() {
		return convenioBB;
	}

	public void setConvenioBB(String convenioBB) {
		this.convenioBB = convenioBB;
	}
	
	public String getCodigoBeneficiario() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(agencia);
		sb.append(digitoAgencia);
		sb.append(numeroConta);
		sb.append(digitoConta);
		
		return sb.toString();
	}

	public String getLogradouroBeneficiario() {
		return logradouroBeneficiario;
	}

	public void setLogradouroBeneficiario(String logradouroBeneficiario) {
		this.logradouroBeneficiario = logradouroBeneficiario;
	}

	public String getNumeroBeneficiario() {
		return numeroBeneficiario;
	}

	public void setNumeroBeneficiario(String numeroBeneficiario) {
		this.numeroBeneficiario = numeroBeneficiario;
	}

	public String getBairroBeneficiario() {
		return bairroBeneficiario;
	}

	public void setBairroBeneficiario(String bairroBeneficiario) {
		this.bairroBeneficiario = bairroBeneficiario;
	}

	public String getCidadeBeneficiario() {
		return cidadeBeneficiario;
	}

	public void setCidadeBeneficiario(String cidadeBeneficiario) {
		this.cidadeBeneficiario = cidadeBeneficiario;
	}

	public String getUfBeneficiario() {
		return ufBeneficiario;
	}

	public void setUfBeneficiario(String ufBeneficiario) {
		this.ufBeneficiario = ufBeneficiario;
	}

	public String getCepBeneficiario() {
		return cepBeneficiario;
	}

	public void setCepBeneficiario(String cepBeneficiario) {
		this.cepBeneficiario = cepBeneficiario;
	}
	
	

}
