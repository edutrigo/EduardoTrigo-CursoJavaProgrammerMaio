package services;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import entity.EntCorrentistaBasico;
import entity.EntEndereco;
import validation.VldCampos;

public class SrvCriarPdf extends PdfPageEventHelper {

	public void gerarPdfCorrentista(EntCorrentistaBasico entCorrentista) {
		String caminhoArquivo = "C:\\Users\\edutr\\Downloads\\" + "RelatorioCorrentista-" + entCorrentista.getNome()
				+ ".pdf";

		Document document = new Document();

		Font fonte = new Font(Font.FontFamily.UNDEFINED, 14, Font.BOLD);
		
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));

			writer.setPageEvent(new SrvTemplatePdfFooter());

			document.open();
			document.add(new Paragraph("Empresa: TRIGOSFOT", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));

			document.add(new Paragraph("Relatorio de CORRENTISTA BÁSICO",
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));

			document.add(new Paragraph(" "));

			if (entCorrentista != null) {

				PdfPTable table = new PdfPTable(2);
				table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				table.setWidthPercentage(100);

				VldCampos vldCampos = new VldCampos();

				//
				table.addCell("CPF");
				if (vldCampos.campoNullBranco(entCorrentista.getCpf())) {
					table.addCell("Não informado");
				} else {
					table.addCell(entCorrentista.getCpf());
				}

				//
				table.addCell("NOME");
				if (vldCampos.campoNullBranco(entCorrentista.getNome())) {
					table.addCell("Não informado");
				} else {
					table.addCell(entCorrentista.getNome());
				}

				//
				table.addCell("EMAIL");
				if (vldCampos.campoNullBranco(entCorrentista.getEmail())) {
					table.addCell("Não informado");
				} else {
					table.addCell(entCorrentista.getEmail());
				}

				//
				table.addCell("QTD TRANSAÇÃO");
				if (vldCampos.campoNullBranco(Integer.toString(entCorrentista.getQtdTransacao()))) {
					table.addCell("Não informado");
				} else {
					table.addCell(Integer.toString(entCorrentista.getQtdTransacao()));
				}

				//
				table.addCell("VAL ANUIDADE");
				if (vldCampos.campoNullBranco(Double.toString(entCorrentista.getValorAnuidade()))) {
					table.addCell("Não informado");
				} else {
					table.addCell(Double.toString(entCorrentista.getValorAnuidade()));
				}

				//
				table.addCell("LIM SAQUE");
				if (vldCampos.campoNullBranco(Double.toString(entCorrentista.getLimiteDeSaque()))) {
					table.addCell("Não informado");
				} else {
					table.addCell(Double.toString(entCorrentista.getLimiteDeSaque()));
				}

				//
				table.addCell(" ");
				table.addCell(" ");
				table.addCell(new Phrase("DADOS DE ENDEREÇO", fonte));
				table.addCell(" ");

				EntEndereco entEndereco = new EntEndereco();
				entEndereco = entCorrentista.getEndereco();
				//
				table.addCell("CEP");
				if (vldCampos.campoNullBranco(entEndereco.getCep())) {
					table.addCell("Não informado");
				} else {
					table.addCell(entEndereco.getCep());
				}

				//
				table.addCell("LOGRADOURO");
				if (vldCampos.campoNullBranco(entEndereco.getLogradouro())) {
					table.addCell("Não informado");
				} else {
					table.addCell(entEndereco.getLogradouro());
				}

				//
				table.addCell("LOCALIDADE");
				if (vldCampos.campoNullBranco(entEndereco.getLocalidade())) {
					table.addCell("Não informado");
				} else {
					table.addCell(entEndereco.getLocalidade());
				}

				//
				table.addCell("UF");
				if (vldCampos.campoNullBranco(entEndereco.getUf())) {
					table.addCell("Não informado");
				} else {
					table.addCell(entEndereco.getUf());
				}

				document.add(table);
			}

			document.close();

			File pdfArquivo = new File(caminhoArquivo);

			if (pdfArquivo.exists()) {
				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfArquivo);
				} else {
					System.out.println("PDF gerado, mas não foi possivel abrir...");
				}

			} else {
				System.out.println("PDF gerado, mas não foi possivel encontrar...");
			}

		} catch (Exception e) {
			System.out.println("Erro SrvCriarPdf.gerarPdfCorrentista: " + e.getMessage());
		}
	}
}
