package kafic.gui.kontroler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class IzvestajGUI extends JFrame {

	private JPanel contentPane;
	private JPanel juzniPanel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnZavrsi;
	private JButton btnOdustani;
	
	private IzvestajGUI izvestaj = this;

	/**
	 * Create the frame.
	 */
	public IzvestajGUI() {
		setResizable(false);
		setTitle("Izvestaj");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getJuzniPanel(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		//GUIKontroler.napuniIzvestaj(izvestaj);
	}
	private JPanel getJuzniPanel() {
		if (juzniPanel == null) {
			juzniPanel = new JPanel();
			juzniPanel.setPreferredSize(new Dimension(0, 80));
			juzniPanel.setLayout(null);
			juzniPanel.add(getBtnZavrsi());
			juzniPanel.add(getBtnOdustani());
		}
		return juzniPanel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		}
		return textArea;
	}
	private JButton getBtnZavrsi() {
		if (btnZavrsi == null) {
			btnZavrsi = new JButton("Zavrsi");
			btnZavrsi.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnZavrsi.setBackground(new Color(130, 224, 170));
			btnZavrsi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnZavrsi.setBounds(48, 16, 115, 48);
		}
		return btnZavrsi;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnOdustani.setBackground(new Color(236, 112, 99));
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnOdustani.setBounds(267, 16, 115, 48);
		}
		return btnOdustani;
	}
}
