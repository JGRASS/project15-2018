package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.layout.Border;
import kafic.Radnik;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel panel;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JLabel lblRealIme;
	private JLabel lblNewLabel;
	private JButton btnLogOut;
	private JLabel label;
	private JButton btnPrviSto;
	private JButton btnDrugiSto;
	private JButton btnTreciSto;
	private JButton btnCetvrtiSto;
	private JButton btnPetiSto;
	private JButton btnSestiSto;
	private JButton btnSedmiSto;
	private JButton btnOsmiSto;
	private JLabel lblNewLabel_1;

	/**
	 * Create the frame.
	 */
	public GlavniProzor(Radnik radnik) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 1000);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
		lblRealIme.setText(radnik.getIme());
		lblNewLabel.setText(radnik.getPrezime());
		label.setText(radnik.getUsername());
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setForeground(new Color(255, 0, 0));
			panel_1.setPreferredSize(new Dimension(120, 120));
			panel_1.setLayout(null);
			panel_1.add(getLblIme());
			panel_1.add(getLblPrezime());
			panel_1.add(getLblRealIme());
			panel_1.setBackground(new Color(200,200,200));
			panel_1.add(getLblNewLabel());
			panel_1.add(getBtnLogOut());
			panel_1.add(getLabel());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(237, 187, 153));
			panel.setLayout(null);
			panel.add(getBtnPrviSto());
			panel.add(getBtnDrugiSto());
			panel.add(getBtnTreciSto());
			panel.add(getBtnCetvrtiSto());
			panel.add(getBtnPetiSto());
			panel.add(getBtnSestiSto());
			panel.add(getBtnSedmiSto());
			panel.add(getBtnOsmiSto());
			panel.add(getLblNewLabel_1());
		}
		return panel;
	}
	private JLabel getLblIme() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime:");
			lblIme.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblIme.setBounds(15, 33, 69, 20);
		}
		return lblIme;
	}
	private JLabel getLblPrezime() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime:");
			lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblPrezime.setBounds(15, 69, 100, 20);
		}
		return lblPrezime;
	}
	
	private JLabel getLblRealIme() {
		if (lblRealIme == null) {
			lblRealIme = new JLabel("");
			lblRealIme.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblRealIme.setBounds(147, 37, 198, 20);
		}
		return lblRealIme;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel.setBounds(147, 73, 198, 20);
		}
		return lblNewLabel;
	}
	private JButton getBtnLogOut() {
		if (btnLogOut == null) {
			btnLogOut = new JButton("Log out");
			btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnLogOut.setBounds(1442, 33, 115, 50);
		}
		return btnLogOut;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setAlignmentX(Component.RIGHT_ALIGNMENT);
			label.setBounds(1259, 50, 150, 20);
		}
		return label;
	}
	private JButton getBtnPrviSto() {
		if (btnPrviSto == null) {
			btnPrviSto = new JButton("");
			btnPrviSto.setBackground(new Color(237, 187, 153));
			btnPrviSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
			btnPrviSto.setBorder(null);
			btnPrviSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnPrviSto.setBounds(100, 127, 247, 137);
		}
		return btnPrviSto;
	}
	private JButton getBtnDrugiSto() {
		if (btnDrugiSto == null) {
			btnDrugiSto = new JButton("");
			btnDrugiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
			btnDrugiSto.setBackground(new Color(237, 187, 153));
			btnDrugiSto.setBounds(100, 360, 247, 137);
			btnDrugiSto.setBorder(null);
		}
		return btnDrugiSto;
	}
	private JButton getBtnTreciSto() {
		if (btnTreciSto == null) {
			btnTreciSto = new JButton("");
			btnTreciSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
			btnTreciSto.setBackground(new Color(237, 187, 153));
			btnTreciSto.setBounds(100, 607, 247, 137);
			btnTreciSto.setBorder(null);
		}
		return btnTreciSto;
	}
	private JButton getBtnCetvrtiSto() {
		if (btnCetvrtiSto == null) {
			btnCetvrtiSto = new JButton("");
			btnCetvrtiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
			btnCetvrtiSto.setBackground(new Color(237, 187, 153));
			btnCetvrtiSto.setBounds(483, 607, 247, 137);
			btnCetvrtiSto.setBorder(null);
		}
		return btnCetvrtiSto;
	}
	private JButton getBtnPetiSto() {
		if (btnPetiSto == null) {
			btnPetiSto = new JButton("");
			btnPetiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
			btnPetiSto.setBackground(new Color(237, 187, 153));
			btnPetiSto.setBounds(859, 607, 247, 137);
			btnPetiSto.setBorder(null);
		}
		return btnPetiSto;
	}
	private JButton getBtnSestiSto() {
		if (btnSestiSto == null) {
			btnSestiSto = new JButton("");
			btnSestiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
			btnSestiSto.setBackground(new Color(237, 187, 153));
			btnSestiSto.setBounds(1227, 607, 247, 137);
			btnSestiSto.setBorder(null);
		}
		return btnSestiSto;
	}
	private JButton getBtnSedmiSto() {
		if (btnSedmiSto == null) {
			btnSedmiSto = new JButton("");
			btnSedmiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
			btnSedmiSto.setBackground(new Color(237, 187, 153));
			btnSedmiSto.setBounds(1227, 360, 247, 137);
			btnSedmiSto.setBorder(null);
		}
		return btnSedmiSto;
	}
	private JButton getBtnOsmiSto() {
		if (btnOsmiSto == null) {
			btnOsmiSto = new JButton("");
			btnOsmiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
			btnOsmiSto.setBackground(new Color(237, 187, 153));
			btnOsmiSto.setBounds(1227, 127, 247, 137);
			btnOsmiSto.setBorder(null);
		}
		return btnOsmiSto;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/barTable.png")));
			lblNewLabel_1.setBounds(581, 109, 407, 368);
		}
		return lblNewLabel_1;
	}
}
