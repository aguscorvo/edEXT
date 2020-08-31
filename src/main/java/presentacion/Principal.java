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

	public Principal() throws PropertyVetoException {
		initialize();
		
		Fabrica f = Fabrica.getInstancia();
		IControladorAltaInstituto IConAltInst = f.getIControladorAltaInstituto();
		IControladorAltaUsuario IConAltUsu = f.getIControladorAltaUsuario();
		
		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		ingresarInstitutoInternalFrame = new IngresarInstituto(IConAltInst);
		ingresarUsuarioInternalFrame = new IngresarUsuario(IConAltUsu);
		
		
		//dejamos el jInternalFrame en el medio de la pantalla
		jInternalFrameSize = ingresarInstitutoInternalFrame.getSize();
		ingresarInstitutoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		ingresarInstitutoInternalFrame.setVisible(false);
		frame.getContentPane().add(ingresarInstitutoInternalFrame);
		ingresarInstitutoInternalFrame.getContentPane().setLayout(null);
		
		jInternalFrameSize = ingresarUsuarioInternalFrame.getSize();
		ingresarUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		ingresarUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(ingresarUsuarioInternalFrame);
		ingresarUsuarioInternalFrame.getContentPane().setLayout(null);
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 846, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
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
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarUsuarioInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmUsuario);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
	}
}
