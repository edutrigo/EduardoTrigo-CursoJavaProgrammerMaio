package servico;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JOptionPane;

import entidade.Cachorro;
import entidade.Cobra;
import validacao.EntidadeValidacao;

public class EntidadeServico {

	// CAPTURA O PRECO DO CACHORRO
	public Double buscaPrecoCachorro(String peso) {
		Cachorro cachorro = new Cachorro();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();

		if (entidadeValidacao.validaPeso(peso) == null) {
			JOptionPane.showMessageDialog(null, "O peso " + peso + " não é valido...");
		} else {
			return cachorro.calcularPreco(entidadeValidacao.validaPeso(peso));
		}
		return null;
	}

	// CAPTURA O PRECO DA COBRA
	public Double buscaPrecoCobra(String peso) {
		Cobra cobra = new Cobra();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();

		if (entidadeValidacao.validaPeso(peso) == null) {
			JOptionPane.showMessageDialog(null, "O peso " + peso + " não é valido...");
		} else {
			return cobra.calcularPreco(entidadeValidacao.validaPeso(peso));
		}
		return null;
	}

	public void gerarPdfDetalharCachorro(Cachorro cachorro) {
		String caminhoArquivo = "C:\\Users\\edutr\\Downloads\\" + "RelatorioDetalharCachorro-" + cachorro.getNome()
				+ ".pdf";
		// Caminho do arquivo com o nome do cachorro
		Document document = new Document();
		// Objeto java do Document que vai ser manipulado

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
			writer.setPageEvent(new RodapeTemplate());
			// Objeto gerador de PDF usando o cabeçalho e rodapé da classe
			// CabecalhoRodapeTemplate()

			document.open();// Abre Manipulação do objeto Document
			document.add(new Paragraph("Empresa: IMPACTA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
			// Adiciona nome da empresa no cabeçalho
			document.add(new Paragraph("Relatorio de Detalhe do Cachorro",
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
			// Adiciona o nome do relatorio
			document.add(new Paragraph(" "));// pular uma linha

			if (cachorro != null) {

				PdfPTable table = new PdfPTable(2);// Cria objeto da tabela com a quantidade de colunas
				table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				table.setWidthPercentage(100);// Ocupação da tabela na pagina

				table.addCell("CAF");// Primeiro item da primeira linha
				table.addCell(cachorro.getCaf().toString());// segundo item da primeira linha

				table.addCell("Nome");
				table.addCell(cachorro.getNome());

				table.addCell("Salario");
				table.addCell(cachorro.getCorPelo());

				table.addCell("Cep");
				table.addCell(cachorro.getEndereco().getCep());

				table.addCell("Localidade");
				table.addCell(cachorro.getEndereco().getLocalidade());

				table.addCell("Logradouro");
				table.addCell(cachorro.getEndereco().getLogradouro());

				table.addCell("Bairro");
				table.addCell(cachorro.getEndereco().getBairro());

				table.addCell("Uf");
				table.addCell(cachorro.getEndereco().getUf());

				table.addCell("Siafi");
				if (cachorro.getEndereco().getSiafi() == null) {

					table.addCell("Não informado");
				} else {
					table.addCell(cachorro.getEndereco().getSiafi());
				}

				document.add(table);

			}

			document.close();

			File pdfArquivo = new File(caminhoArquivo);

			if (pdfArquivo.exists()) {
				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfArquivo);
				} else {
					System.out.println("PDF gerado mas não foi possivel abrir");
				}

			} else {
				System.out.println("PDF gerado mas não foi possivel encontrar");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void gerarPdfDetalharCobra(Cobra cobra) {
		String caminhoArquivo = "C:\\Users\\edutr\\Downloads\\" + "RelatorioDetalharCobra-" + cobra.getNome() + ".pdf";
		// Caminho do arquivo com o nome do cobra
		Document document = new Document();
		// Objeto java do Document que vai ser manipulado

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
			writer.setPageEvent(new RodapeTemplate());
			// Objeto gerador de PDF usando o cabeçalho e rodapé da classe
			// CabecalhoRodapeTemplate()

			document.open();// Abre Manipulação do objeto Document
			document.add(new Paragraph("Empresa: IMPACTA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
			// Adiciona nome da empresa no cabeçalho
			document.add(new Paragraph("Relatorio de Detalhe do Cobra",
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
			// Adiciona o nome do relatorio
			document.add(new Paragraph(" "));// pular uma linha

			if (cobra != null) {

				PdfPTable table = new PdfPTable(2);// Cria objeto da tabela com a quantidade de colunas
				table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				table.setWidthPercentage(100);// Ocupação da tabela na pagina

				table.addCell("CAF");// Primeiro item da primeira linha
				table.addCell(cobra.getCaf().toString());// segundo item da primeira linha

				table.addCell("Nome");
				table.addCell(cobra.getNome());

				table.addCell("Salario");
				table.addCell(cobra.getTipoVeneno());

				table.addCell("Cep");
				table.addCell(cobra.getEndereco().getCep());

				table.addCell("Localidade");
				table.addCell(cobra.getEndereco().getLocalidade());

				table.addCell("Logradouro");
				table.addCell(cobra.getEndereco().getLogradouro());

				table.addCell("Bairro");
				table.addCell(cobra.getEndereco().getBairro());

				table.addCell("Uf");
				table.addCell(cobra.getEndereco().getUf());

				table.addCell("Siafi");
				if (cobra.getEndereco().getSiafi() == null) {

					table.addCell("Não informado");
				} else {
					table.addCell(cobra.getEndereco().getSiafi());
				}

				document.add(table);

			}

			document.close();

			File pdfArquivo = new File(caminhoArquivo);

			if (pdfArquivo.exists()) {
				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfArquivo);
				} else {
					System.out.println("PDF gerado mas não foi possivel abrir");
				}

			} else {
				System.out.println("PDF gerado mas não foi possivel encontrar");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}
}