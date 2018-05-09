package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kafic.Radnik;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JPanel severniPanel;
	private JPanel centralniPanel;
	private JPanel istocniPanel;
	private JButton btnPrviSto;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnOsmiSto;
	private JButton btnDrugiSto;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JButton btnSedmiSto;
	private JButton btnTreciSto;
	private JButton btnCetvrtiSto;
	private JButton btnPetiSto;
	private JButton btnSestiSto;

	/**
	 * Create the frame.
	 */
	public GlavniProzor(Radnik randik) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getSeverniPanel(), BorderLayout.NORTH);
		contentPane.add(getCentralniPanel(), BorderLayout.CENTER);
		contentPane.add(getIstocniPanel(), BorderLayout.EAST);
	}

	private JPanel getSeverniPanel() {
		if (severniPanel == null) {
			severniPanel = new JPanel();
			severniPanel.setBackground(new Color(229, 231, 233));
			severniPanel.setPreferredSize(new Dimension(0, 120));
			severniPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return severniPanel;
	}
	private JPanel getCentralniPanel() {
		if (centralniPanel == null) {
			centralniPanel = new JPanel();
			centralniPanel.setBackground(new Color(237, 187, 153));
			centralniPanel.setLayout(new GridLayout(3, 4, 0, 0));
			centralniPanel.add(getBtnPrviSto());
			centralniPanel.add(getSeparator());
			centralniPanel.add(getSeparator_1());
			centralniPanel.add(getBtnOsmiSto());
			centralniPanel.add(getBtnDrugiSto());
			centralniPanel.add(getSeparator_2());
			centralniPanel.add(getSeparator_3());
			centralniPanel.add(getBtnSedmiSto());
			centralniPanel.add(getBtnTreciSto());
			centralniPanel.add(getBtnCetvrtiSto());
			centralniPanel.add(getBtnPetiSto());
			centralniPanel.add(getBtnSestiSto());
		}
		return centralniPanel;
	}
	private JPanel getIstocniPanel() {
		if (istocniPanel == null) {
			istocniPanel = new JPanel();
			istocniPanel.setBackground(new Color(253, 254, 254));
			istocniPanel.setPreferredSize(new Dimension(683, 0));
			istocniPanel.setLayout(new BorderLayout(0, 0));
		}
		return istocniPanel;
	}
	private JButton getBtnPrviSto() {
		if (btnPrviSto == null) {
			btnPrviSto = new JButton("1");
			btnPrviSto.setBorder(null);
			btnPrviSto.setBackground(new Color(237, 187, 153));
			btnPrviSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnPrviSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnPrviSto;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setVisible(false);
			separator.setBorder(null);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setVisible(false);
			separator_1.setBorder(null);
		}
		return separator_1;
	}
	private JButton getBtnOsmiSto() {
		if (btnOsmiSto == null) {
			btnOsmiSto = new JButton("8");
			btnOsmiSto.setBorder(null);
			btnOsmiSto.setBackground(new Color(237, 187, 153));
			btnOsmiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnOsmiSto;
	}
	private JButton getBtnDrugiSto() {
		if (btnDrugiSto == null) {
			btnDrugiSto = new JButton("2");
			btnDrugiSto.setBorder(null);
			btnDrugiSto.setBackground(new Color(237, 187, 153));
			btnDrugiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnDrugiSto;
	}
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setVisible(false);
			separator_2.setBorder(null);
		}
		return separator_2;
	}
	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
			separator_3.setVisible(false);
			separator_3.setBorder(null);
		}
		return separator_3;
	}
	private JButton getBtnSedmiSto() {
		if (btnSedmiSto == null) {
			btnSedmiSto = new JButton("7");
			btnSedmiSto.setBorder(null);
			btnSedmiSto.setBackground(new Color(237, 187, 153));
			btnSedmiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnSedmiSto;
	}
	private JButton getBtnTreciSto() {
		if (btnTreciSto == null) {
			btnTreciSto = new JButton("3");
			btnTreciSto.setBorder(null);
			btnTreciSto.setBackground(new Color(237, 187, 153));
			btnTreciSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnTreciSto;
	}
	private JButton getBtnCetvrtiSto() {
		if (btnCetvrtiSto == null) {
			btnCetvrtiSto = new JButton("4");
			btnCetvrtiSto.setBorder(null);
			btnCetvrtiSto.setBackground(new Color(237, 187, 153));
			btnCetvrtiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnCetvrtiSto;
	}
	private JButton getBtnPetiSto() {
		if (btnPetiSto == null) {
			btnPetiSto = new JButton("5");
			btnPetiSto.setBorder(null);
			btnPetiSto.setBackground(new Color(237, 187, 153));
			btnPetiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnPetiSto;
	}
	private JButton getBtnSestiSto() {
		if (btnSestiSto == null) {
			btnSestiSto = new JButton("6");
			btnSestiSto.setBorder(null);
			btnSestiSto.setBackground(new Color(237, 187, 153));
			btnSestiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnSestiSto;
	}
}
