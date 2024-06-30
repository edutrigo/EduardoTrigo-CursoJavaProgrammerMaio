package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.EntCorrentistaPremium;
import form.CorrentistaPremium.FrmAlteracaoCorrentistaPremiumSel;
import form.CorrentistaPremium.FrmConsultaCorrentistaPremium;
import form.CorrentistaPremium.FrmExclusaoCorrentistaPremium;
import form.CorrentistaPremium.FrmInclusaoCorrentistaPremium;
import repository.CorrentistaPremium.RepCorrentistaPremiumImplement;

public class CtlFrmMainMenuCorrentistaPremium implements ActionListener {

	JTextField opcaoMenu;
	JFrame frameRetornar;

	public CtlFrmMainMenuCorrentistaPremium(JTextField opcaoMenu, JFrame frameRetornar) {
		this.opcaoMenu = opcaoMenu;
		this.frameRetornar = frameRetornar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (opcaoMenu.getText()) {
		case "1": {
			// INCLUSAO
			FrmInclusaoCorrentistaPremium frmInclusaoCorrentistaPremium = new FrmInclusaoCorrentistaPremium();
			frmInclusaoCorrentistaPremium.inclusao();
			break;
		}
		case "2": {
			// CONSULTA/PDF
			List<EntCorrentistaPremium> listCorrentista = new ArrayList<>();

			RepCorrentistaPremiumImplement repCorrentistaPremiumImplement = new RepCorrentistaPremiumImplement();
			listCorrentista = repCorrentistaPremiumImplement.retornaConsultaCorrentista();

			FrmConsultaCorrentistaPremium frmConsultaCorrentistaPremium = new FrmConsultaCorrentistaPremium();
			frmConsultaCorrentistaPremium.ConsultaCorrentistaPremium(listCorrentista);
			break;
		}
		case "3": {
			// EXCLUSAO
			List<EntCorrentistaPremium> listCorrentista = new ArrayList<>();

			RepCorrentistaPremiumImplement repCorrentistaPremiumImplement = new RepCorrentistaPremiumImplement();
			listCorrentista = repCorrentistaPremiumImplement.retornaConsultaCorrentista();

			FrmExclusaoCorrentistaPremium frmExclusaoCorrentistaPremium = new FrmExclusaoCorrentistaPremium();
			frmExclusaoCorrentistaPremium.ExclusaoCorrentistaPremium(listCorrentista);
			break;
		}
		case "4": {
			// ATUALIZACAO
			List<EntCorrentistaPremium> listCorrentista = new ArrayList<>();

			RepCorrentistaPremiumImplement repCorrentistaPremiumImplement = new RepCorrentistaPremiumImplement();
			listCorrentista = repCorrentistaPremiumImplement.retornaConsultaCorrentista();

			FrmAlteracaoCorrentistaPremiumSel frmAlteracaoCorrentistaPremiumSel = new FrmAlteracaoCorrentistaPremiumSel();
			frmAlteracaoCorrentistaPremiumSel.alteracaoCorrentistaSel(listCorrentista);
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