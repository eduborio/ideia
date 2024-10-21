package br.com.ideia.domain;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GeradorDeBoletoIdeia {
	
	private  Map<String, Object> params;
	private  JRDataSource datasource;
	private InputStream jasper;
	
	public GeradorDeBoletoIdeia(InputStream jasper,Map<String,Object> params,List<BoletoAdapter> boletos) {
		this.jasper = jasper;
		this.params = params;
		this.datasource = preparaImpressao(boletos);
	}
	
	public byte[] gerarPDF() {
	    JasperPrint print = preencheRelatorio();
	    try {
			return JasperExportManager.exportReportToPdf(print);
		} catch (JRException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private JRDataSource preparaImpressao(List<BoletoAdapter> boletos) {
		return new JRBeanCollectionDataSource(boletos);
	}

	private JasperPrint preencheRelatorio() {
		try {
			//params.put("jrDataSource",datasource);
			//params.put("REPORT_DATA_SOURCE",datasource);
			return JasperFillManager.fillReport(jasper, params, datasource);
		} catch (JRException e) {
			e.printStackTrace();
		}
		return null;
	}
}
