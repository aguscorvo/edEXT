package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfaces.Fabrica;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaUsuario;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Principal {
	private JFrame frame;
	private IngresarInstituto ingresarInstitutoInternalFrame;
	private IngresarUsuario ingresarUsuarioInternalFrame;

	
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
	 * @throws PropertyVetoException 
	 */
	public Principal() throws PropertyVetoException {
		initialize();
		
		Fabrica f = Fabrica.getInstancia();
		IControladorAltaInstituto IConAltInst = f.getIControladorAltaInstituto();
		
		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		ingresarInstitutoInternalFrame = new IngresarInstituto(IConAltInst);
		//ingresarUsuario
		
		//dejamos el jInternalFrame en el medio de la pantalla
		jInternalFrameSize = ingresarInstitutoInternalFrame.getSize();
		ingresarInstitutoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		ingresarInstitutoInternalFrame.setVisible(false);
		frame.getContentPane().add(ingresarInstitutoInternalFrame);
		ingresarInstitutoInternalFrame.getContentPane().setLayout(null);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);
		
		JMenuItem mntmInstitutos = new JMenuItem("Instituto");
		mntmInstitutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarInstitutoInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmInstitutos);
		
		JMenuItem mntmUsuario = new JMenuItem("Usuario");
		mnAltas.add(mntmUsuario);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
	}
}
