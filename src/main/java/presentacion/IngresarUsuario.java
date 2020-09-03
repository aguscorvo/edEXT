package presentacion;


import javax.swing.JInternalFrame;

import interfaces.IControladorAltaUsuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import datatype.DtDocente;
import datatype.DtEstudiante;
import datatype.DtUsuario;
import excepciones.UsuarioRepetidoException;

import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class IngresarUsuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaUsuario iConAltaUsu;

	private JTextField textFieldNick;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldCorreo;
	private JTextField textFieldInstituto;
	private JRadioButton rdbtnDocente;
	private JRadioButton rdbtnEstudiante;
	private JDateChooser dateChooserFechaNac;
	private JButton btnConfirmar;
	private JButton btnCancelar;

	
	public IngresarUsuario(IControladorAltaUsuario iConAltUsu) {
		this.iConAltaUsu=iConAltUsu;
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Ingresar Usuario");
		setBounds(100, 100, 699, 265);
		getContentPane().setLayout(null);
		
		JLabel lblNick = new JLabel("NICK");
		lblNick.setBounds(34, 34, 70, 15);
		getContentPane().add(lblNick);
		
		textFieldNick = new JTextField();
		textFieldNick.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldNick.setBounds(111, 32, 181, 19);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(34, 81, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldNombre.setBounds(111, 79, 181, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(34, 127, 70, 15);
		getContentPane().add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldApellido.setBounds(111, 125, 181, 19);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblCorreo = new JLabel("CORREO");
		lblCorreo.setBounds(34, 175, 70, 15);
		getContentPane().add(lblCorreo);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldCorreo.setBounds(111, 173, 181, 19);
		getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		dateChooserFechaNac = new JDateChooser();
		//dateChooserFechaNac.setDate(null);
		dateChooserFechaNac.setBounds(496, 30, 162, 19);
		getContentPane().add(dateChooserFechaNac);
		
		JLabel lblFechaNac = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNac.setBounds(331, 34, 161, 15);
		getContentPane().add(lblFechaNac);
		
		rdbtnDocente = new JRadioButton("Docente");
		rdbtnDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDocente.setSelected(true);
				rdbtnEstudiante.setSelected(false);
				textFieldInstituto.setEnabled(true);
			}
		});
		rdbtnDocente.setSelected(true);
		rdbtnDocente.setBounds(375, 123, 95, 23);
		getContentPane().add(rdbtnDocente);
		
		rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDocente.setSelected(false);
				rdbtnEstudiante.setSelected(true);
				textFieldInstituto.setText("");
				textFieldInstituto.setEnabled(false);
			}
		});
		rdbtnEstudiante.setSelected(false);
		rdbtnEstudiante.setBounds(515, 123, 108, 23);
		getContentPane().add(rdbtnEstudiante);
		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(331, 81, 108, 15);
		getContentPane().add(lblInstituto);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldInstituto.setBounds(496, 81, 162, 19);
		getContentPane().add(textFieldInstituto);
		textFieldInstituto.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.setBackground(UIManager.getColor("Button.darkShadow"));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarUsuarioAceptarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(363, 170, 117, 25);
		getContentPane().add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarUsuarioCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(515, 170, 117, 25);
		getContentPane().add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBounds(363, 120, 269, 30);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 12, 665, 209);
		getContentPane().add(panel_1);

	}
	
	protected void ingresarUsuarioAceptarActionPerformed(ActionEvent e) {
		String nick = this.textFieldNick.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String correo = this.textFieldCorreo.getText();
		Date fecha = this.dateChooserFechaNac.getDate();
		DtUsuario dt=null;
		
		if(rdbtnDocente.isSelected()) {
			String instituto = this.textFieldInstituto.getText();
			if (checkTextField(instituto)) {
				dt = new DtDocente(nick, nombre, apellido, correo, fecha, instituto);
			}
			else return;
			
		}
		if(rdbtnEstudiante.isSelected()) {
			dt= new DtEstudiante(nick, nombre, apellido, correo, fecha);
		}
		if(checkTextField(nick)& checkTextField(nombre)& checkTextField(apellido)&checkTextField(correo)) {
			try {			
					this.iConAltaUsu.ingresarDtUsuario(dt);
					this.iConAltaUsu.confirmarAltaUsuario();
					JOptionPane.showMessageDialog(this, "El usuario se ha creado con éxito", "Ingresar Usuario", JOptionPane.INFORMATION_MESSAGE);
								
				} catch(UsuarioRepetidoException ue) {
	               JOptionPane.showMessageDialog(this, ue.getMessage(), "Ingresar Usuario", JOptionPane.ERROR_MESSAGE);
	
				}
			limpiarFormulario();
			setVisible(false);
				
			}
		}
		


	protected void ingresarUsuarioCancelarActionPerformed(ActionEvent e) {		
		limpiarFormulario();
		setVisible(false);	
	}
	
	private boolean checkTextField(String string) {
		
		if(string.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ningún campo puede quedar vacío.", "Ingresar Usuario",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;			
		
	}
	
	private void limpiarFormulario() {
		textFieldNick.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldCorreo.setText("");
		textFieldInstituto.setText("");
	}

	public void habilitarBotonConfirmar() {
		if (!textFieldNick.getText().isEmpty() & !textFieldNombre.getText().isEmpty() & !textFieldApellido.getText().isEmpty() & !textFieldCorreo.getText().isEmpty()) {
			if(rdbtnDocente.isSelected() & !textFieldInstituto.getText().isEmpty())
				btnConfirmar.setEnabled(true);
			else if (rdbtnEstudiante.isSelected())
				btnConfirmar.setEnabled(true);
		}
		else {
			btnConfirmar.setEnabled(false);
		}
	}
}
