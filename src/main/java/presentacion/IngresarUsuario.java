package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControladorAltaUsuario;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class IngresarUsuario extends JInternalFrame {
	private JTextField textFieldNick;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldCorreo;
	private JTextField textFieldInstituto;

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

	
	public IngresarUsuario(IControladorAltaUsuario iConAltUsu) {
		setClosable(true);
		setTitle("Ingresar Usuario");
		setBounds(100, 100, 680, 408);
		getContentPane().setLayout(null);
		
		JLabel lblNick = new JLabel("NICK");
		lblNick.setBounds(142, 34, 70, 15);
		getContentPane().add(lblNick);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(234, 32, 114, 19);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(142, 81, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(234, 79, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(142, 127, 70, 15);
		getContentPane().add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(234, 125, 114, 19);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CORREO");
		lblNewLabel.setBounds(142, 175, 70, 15);
		getContentPane().add(lblNewLabel);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(234, 173, 114, 19);
		getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(321, 223, 83, 19);
		getContentPane().add(dateChooser);
		
		JLabel lblNewLabel_1 = new JLabel("FECHA DE NACIMIENTO");
		lblNewLabel_1.setBounds(142, 227, 161, 15);
		getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnDocente = new JRadioButton("Docente");
		rdbtnDocente.setBounds(32, 267, 149, 23);
		getContentPane().add(rdbtnDocente);
		
		JRadioButton rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.setBounds(32, 302, 149, 23);
		getContentPane().add(rdbtnEstudiante);
		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(195, 282, 108, 15);
		getContentPane().add(lblInstituto);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.setBounds(290, 280, 114, 19);
		getContentPane().add(textFieldInstituto);
		textFieldInstituto.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(487, 29, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(487, 76, 117, 25);
		getContentPane().add(btnCancelar);

	}
}
