package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.layout.Border;
import kafic.Radnik;
import kafic.gui.kontroler.GUIKontroler;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel panel;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JLabel lblRealIme;
	private JLabel lblRealPrezime;
	private JButton btnLogOut;
	private JLabel lblRealUserName;

	// Uzimanje dimenzija ekrana
//	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	double width = screenSize.getWidth();
//	double height = screenSize.getHeight();
	private JPanel zapadniPanel;
	private JPanel istocniPanel;
	private JPanel juzniPanel;
	private JPanel centralniPanel;
	private JButton btnPrvisto;
	private JButton btnDrugisto;
	private JButton btnTreciSto;
	private JButton btnCetvrtiSto;
	private JButton btnPetiSto;
	private JButton btnSestiSto;
	private JButton btnOsmiSto;
	private JButton btnSedmiSto;

	/**
	 * Create the frame.
	 */
	public GlavniProzor(Radnik radnik) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(GlavniProzor.class.getResource("/icons/ParadisoCaffee.jpeg")));
		setTitle("Paradiso Caffee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width - 400,screenSize.height - 200);
		//setBounds(100, 100, (int) width - 400, (int) height - 200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
		lblRealIme.setText(radnik.getIme());
		lblRealPrezime.setText(radnik.getPrezime());
		lblRealUserName.setText(radnik.getUsername());
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setForeground(new Color(255, 0, 0));
			panel_1.setPreferredSize(new Dimension(120, 100));
			panel_1.setLayout(null);
			panel_1.add(getLblIme());
			panel_1.add(getLblPrezime());
			panel_1.add(getLblRealIme());
			panel_1.setBackground(new Color(235, 237, 239));
			panel_1.add(getLblRealPrezime());
			panel_1.add(getBtnLogOut());
			panel_1.add(getLblRealUserName());
		}
		return panel_1;
	}

	private JPanel getPanel_2() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(237, 187, 153));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_2_1(), BorderLayout.WEST);
			panel.add(getPanel_2_2(), BorderLayout.EAST);
			panel.add(getPanel_2_3(), BorderLayout.SOUTH);
			panel.add(getPanel_2_4(), BorderLayout.CENTER);
		}
		return panel;
	}

	private JLabel getLblIme() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime:");
			lblIme.setFont(new Font("DialogInput", Font.BOLD, 24));
			lblIme.setBounds(12, 20, 120, 20);
		}
		return lblIme;
	}

	private JLabel getLblPrezime() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime:");
			lblPrezime.setFont(new Font("DialogInput", Font.BOLD, 24));
			lblPrezime.setBounds(12, 60, 120, 20);
		}
		return lblPrezime;
	}

	private JLabel getLblRealIme() {
		if (lblRealIme == null) {
			lblRealIme = new JLabel("");
			lblRealIme.setFont(new Font("DialogInput", Font.PLAIN, 24));
			lblRealIme.setBounds(144, 12, 198, 36);
		}
		return lblRealIme;
	}

	private JLabel getLblRealPrezime() {
		if (lblRealPrezime == null) {
			lblRealPrezime = new JLabel("");
			lblRealPrezime.setFont(new Font("DialogInput", Font.PLAIN, 24));
			lblRealPrezime.setBounds(144, 55, 198, 31);
		}
		return lblRealPrezime;
	}

	private JButton getBtnLogOut() {
		if (btnLogOut == null) {
			btnLogOut = new JButton("Log out");
			btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnLogOut.setBackground(new Color(234, 236, 238));
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.startovanjePrograma();
					dispose();
				}
			});
			btnLogOut.setBounds(1439, 24, 115, 50);
		}
		return btnLogOut;
	}

	private JLabel getLblRealUserName() {
		if (lblRealUserName == null) {
			lblRealUserName = new JLabel("");
			lblRealUserName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRealUserName.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblRealUserName.setBounds(1184, 33, 245, 28);
		}
		return lblRealUserName;
	}

	private JPanel getPanel_2_1() {
		if (zapadniPanel == null) {
			zapadniPanel = new JPanel();
			zapadniPanel.setPreferredSize(new Dimension(180, 0));
			zapadniPanel.setBackground(new Color(237, 187, 153));
			zapadniPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 90));
			zapadniPanel.add(getBtnPrvisto());
			zapadniPanel.add(getBtnDrugisto());
		}
		return zapadniPanel;
	}

	private JPanel getPanel_2_2() {
		if (istocniPanel == null) {
			istocniPanel = new JPanel();
			istocniPanel.setPreferredSize(new Dimension(180, 0));
			istocniPanel.setBackground(new Color(237, 187, 153));
			istocniPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 90));
			istocniPanel.add(getBtnOsmiSto());
			istocniPanel.add(getBtnSedmiSto());
		}
		return istocniPanel;
	}

	private JPanel getPanel_2_3() {
		if (juzniPanel == null) {
			juzniPanel = new JPanel();
			juzniPanel.setPreferredSize(new Dimension(0,180));
			juzniPanel.setBackground(new Color(237, 187, 153));
			juzniPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
			juzniPanel.add(getBtnTreciSto());
			juzniPanel.add(getBtnCetvrtiSto());
			juzniPanel.add(getBtnPetiSto());
			juzniPanel.add(getBtnSestiSto());
		}
		return juzniPanel;
	}

	private JPanel getPanel_2_4() {
		if (centralniPanel == null) {
			centralniPanel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) centralniPanel.getLayout();
			centralniPanel.setBackground(new Color(237, 187, 153));
		}
		return centralniPanel;
	}
	private JButton getBtnPrvisto() {
		if (btnPrvisto == null) {
			btnPrvisto = new JButton("");
			btnPrvisto.setBorder(null);
			btnPrvisto.setBackground(new Color(237, 187, 153));
			btnPrvisto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnPrvisto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
		}
		return btnPrvisto;
	}
	private JButton getBtnDrugisto() {
		if (btnDrugisto == null) {
			btnDrugisto = new JButton("");
			btnDrugisto.setBorder(null);
			btnDrugisto.setBackground(new Color(237, 187, 153));
			btnDrugisto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
		}
		return btnDrugisto;
	}
	private JButton getBtnTreciSto() {
		if (btnTreciSto == null) {
			btnTreciSto = new JButton("");
			btnTreciSto.setBorder(null);
			btnTreciSto.setBackground(new Color(237, 187, 153));
			btnTreciSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
		}
		return btnTreciSto;
	}
	private JButton getBtnCetvrtiSto() {
		if (btnCetvrtiSto == null) {
			btnCetvrtiSto = new JButton("");
			btnCetvrtiSto.setBorder(null);
			btnCetvrtiSto.setBackground(new Color(237, 187, 153));
			btnCetvrtiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
		}
		return btnCetvrtiSto;
	}
	private JButton getBtnPetiSto() {
		if (btnPetiSto == null) {
			btnPetiSto = new JButton("");
			btnPetiSto.setBorder(null);
			btnPetiSto.setBackground(new Color(237, 187, 153));
			btnPetiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
		}
		return btnPetiSto;
	}
	private JButton getBtnSestiSto() {
		if (btnSestiSto == null) {
			btnSestiSto = new JButton("");
			btnSestiSto.setBorder(null);
			btnSestiSto.setBackground(new Color(237, 187, 153));
			btnSestiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
		}
		return btnSestiSto;
	}
	private JButton getBtnOsmiSto() {
		if (btnOsmiSto == null) {
			btnOsmiSto = new JButton("");
			btnOsmiSto.setBorder(null);
			btnOsmiSto.setBackground(new Color(237, 187, 153));
			btnOsmiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
		}
		return btnOsmiSto;
	}
	private JButton getBtnSedmiSto() {
		if (btnSedmiSto == null) {
			btnSedmiSto = new JButton("");
			btnSedmiSto.setBorder(null);
			btnSedmiSto.setBackground(new Color(237, 187, 153));
			btnSedmiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
		}
		return btnSedmiSto;
	}
}
