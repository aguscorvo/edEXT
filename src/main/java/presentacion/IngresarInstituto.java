package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaInstituto;

public class IngresarInstituto extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresarInstituto frame = new IngresarInstituto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IngresarInstituto(IControladorAltaInstituto iConAltInst) {
		this.icon = icon; //revisar
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de un Socio");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		setBounds(100, 100, 450, 300);

	}

}
