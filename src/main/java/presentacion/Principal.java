package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfaces.Fabrica;
import interfaces.IControladorAltaInstituto;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {
	
	Fabrica f = Fabrica.getInstancia();
	IControladorAltaInstituto IConAltInst = f.getIControladorAltaInstituto(); 
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);
		
		JMenuItem mntmInstitutos = new JMenuItem("Institutos");
		mntmInstitutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnAltas.add(mntmInstitutos);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
	}

}
