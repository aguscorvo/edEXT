package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class IngresarUsuario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresarUsuario frame = new IngresarUsuario();
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
	public IngresarUsuario() {
		setClosable(true);
		setTitle("Ingresar Usuario");
		setBounds(100, 100, 664, 393);
		getContentPane().setLayout(null);

	}

}
