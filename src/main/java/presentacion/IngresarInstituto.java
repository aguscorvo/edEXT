package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaInstituto;

public class IngresarInstituto extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private IControladorAltaInstituto iConAltInst;

		
	public IngresarInstituto() {
		super();
		getContentPane().setLayout(null);
		// TODO Auto-generated constructor stub
	}

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
		this.iConAltInst = iConAltInst; //revisar
		
		//Cerrar, maximizar, mover
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Ingresar un instituto");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		setBounds(100, 100, 450, 300);

	}

}
