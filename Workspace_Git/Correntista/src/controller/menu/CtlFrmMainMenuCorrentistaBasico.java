package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.EntCorrentistaBasico;
import form.CorrentistaBasico.FrmAlteracaoCorrentistaBasicoSel;
import form.CorrentistaBasico.FrmConsultaCorrentistaBasico;
import form.CorrentistaBasico.FrmExclusaoCorrentistaBasico;
import form.CorrentistaBasico.FrmInclusaoCorrentistaBasico;
import repository.CorrentistaBasico.RepCorrentistaBasicoImplement;

public class CtlFrmMainMenuCorrentistaBasico implements ActionListener {

	JTextField opcaoMenu;
	JFrame frameRetornar;

	public CtlFrmMainMenuCorrentistaBasico(JTextField opcaoMenu, JFrame frameRetornar) {
		this.opcaoMenu = opcaoMenu;
		this.frameRetornar = frameRetornar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (opcaoMenu.getText()) {
		case "1": {
			// INCLUSAO
			FrmInclusaoCorrentistaBasico frmInclusaoCorrentistaBasico = new FrmInclusaoCorrentistaBasico();
			frmInclusaoCorrentistaBasico.inclusao();
			break;
		}
		case "2": {
			// CONSULTA/PDF
			List<EntCorrentistaBasico> listCorrentista = new ArrayList<>();

			RepCorrentistaBasicoImplement repCorrentistaBasicoImplement = new RepCorrentistaBasicoImplement();
			listCorrentista = repCorrentistaBasicoImplement.retornaConsultaCorrentista();

			FrmConsultaCorrentistaBasico frmConsultaCorrentistaBasico = new FrmConsultaCorrentistaBasico();
			frmConsultaCorrentistaBasico.ConsultaCorrentistaBasico(listCorrentista);
			break;
		}
		case "3": {
			// EXCLUSAO
			List<EntCorrentistaBasico> listCorrentista = new ArrayList<>();

			RepCorrentistaBasicoImplement repCorrentistaBasicoImplement = new RepCorrentistaBasicoImplement();
			listCorrentista = repCorrentistaBasicoImplement.retornaConsultaCorrentista();

			FrmExclusaoCorrentistaBasico frmExclusaoCorrentistaBasico = new FrmExclusaoCorrentistaBasico();
			frmExclusaoCorrentistaBasico.ExclusaoCorrentistaBasico(listCorrentista);
			break;
		}
		case "4": {
			// ATUALIZACAO
			List<EntCorrentistaBasico> listCorrentista = new ArrayList<>();

			RepCorrentistaBasicoImplement repCorrentistaBasicoImplement = new RepCorrentistaBasicoImplement();
			listCorrentista = repCorrentistaBasicoImplement.retornaConsultaCorrentista();

			FrmAlteracaoCorrentistaBasicoSel frmAlteracaoCorrentistaBasicoSel = new FrmAlteracaoCorrentistaBasicoSel();
			frmAlteracaoCorrentistaBasicoSel.alteracaoCorrentistaSel(listCorrentista);
			break;
		}
		case "X": {
			// RETORNAR MENU PRINCIPAL
			frameRetornar.setVisible(false);
			break;
		}
		case "x": {
			// RETORNAR MENU PRINCIPAL
			frameRetornar.setVisible(false);
			break;
		}
		default:
			opcaoMenu.setText(null);
			JOptionPane.showMessageDialog(null, "Somente as opções [1-4] ou 'X' são válidas...");
		}

	}
}