package services;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import entity.EntCorrentista;
import validation.VldCampos;

public class SrvCriarPdf extends PdfPageEventHelper {

	public void gerarPdfCorrentista(EntCorrentista entCorrentista) {
		String caminhoArquivo = "C:\\Users\\edutr\\Downloads\\" + "RelatorioCorrentista-" + entCorrentista.getNome()
				+ ".pdf";

		Document document = new Document();

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));

			writer.setPageEvent(new SrvTemplatePdfFooter());

			document.open();
			document.add(new Paragraph("Empresa: IMPACTA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));

			document.add(new Paragraph("Relatorio de Detalhe do Cachorro",
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));

			document.add(new Paragraph(" "));

			if (entCorrentista != null) {

				PdfPTable table = new PdfPTable(2);
				table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				table.setWidthPercentage(100);

				VldCampos vldCampos = new VldCampos();

				// NOME
				table.addCell("Nome");
				if (vldCampos.campoNullBranco(entCorrentista.getNome())) {
					table.addCell("Não informado");
				} else {
					table.addCell(entCorrentista.getNome());
				}

				table.addCell("Cep");
				table.addCell(entCorrentista.getEndereco().getCep());

				table.addCell("Localidade");
				table.addCell(entCorrentista.getEndereco().getLocalidade());

				table.addCell("Logradouro");
				table.addCell(entCorrentista.getEndereco().getLogradouro());

				table.addCell("Uf");

				table.addCell(entCorrentista.getEndereco().getUf());

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
