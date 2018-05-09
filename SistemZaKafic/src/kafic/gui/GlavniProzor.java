package kafic.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kafic.Radnik;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JPanel severniPanel;
	private JPanel centralniPanel;
	private JPanel istocniPanel;
	private JButton btnPrviSto;

	/**
	 * Create the frame.
	 */
	public GlavniProzor(Radnik randik) {
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
			severniPanel.setPreferredSize(new Dimension(0, 120));
			severniPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return severniPanel;
	}
	private JPanel getCentralniPanel() {
		if (centralniPanel == null) {
			centralniPanel = new JPanel();
			centralniPanel.setLayout(new GridLayout(3, 4, 0, 0));
			centralniPanel.add(getBtnPrviSto());
		}
		return centralniPanel;
	}
	private JPanel getIstocniPanel() {
		if (istocniPanel == null) {
			istocniPanel = new JPanel();
			istocniPanel.setPreferredSize(new Dimension(683, 0));
		}
		return istocniPanel;
	}
	private JButton getBtnPrviSto() {
		if (btnPrviSto == null) {
			btnPrviSto = new JButton("1");
		}
		return btnPrviSto;
	}
}
