package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import datatype.DtUsuario;
import interfaces.IControladorModificarDatosUsuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ModificarDatosUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorModificarDatosUsuario iConModUsu;

	
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JComboBox<String> comboBoxUsuarios;
	private JDateChooser dateChooserFechaDeNacimiento;
	private JButton btnConfirmar;
	private JButton btnSeleccionar;
	private DtUsuario usuarioAModificar;
	

	public ModificarDatosUsuario(IControladorModificarDatosUsuario iConModUsu) {
		this.iConModUsu=iConModUsu;
		setTitle("Modificar datos de usuario");
		setBounds(100, 100, 670, 373);
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(60, 45, 70, 15);
		getContentPane().add(lblUsuario);
		
		comboBoxUsuarios = new JComboBox<String>();
		comboBoxUsuarios.setBounds(245, 40, 177, 24);
		getContentPane().add(comboBoxUsuarios);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(60, 155, 70, 15);
		getContentPane().add(lblApellido);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(245, 103, 177, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(60, 105, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(245, 153, 177, 19);
		getContentPane().add(textFieldApellido);
		
		dateChooserFechaDeNacimiento = new JDateChooser();
		dateChooserFechaDeNacimiento.setBounds(245, 210, 177, 19);
		getContentPane().add(dateChooserFechaDeNacimiento);
		
		JLabel lblFechaDeNacimiento = new JLabel("FECHA DE NACIMIENTO");
		lblFechaDeNacimiento.setBounds(60, 214, 167, 15);
		getContentPane().add(lblFechaDeNacimiento);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(182, 276, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(358, 276, 117, 25);
		getContentPane().add(btnCancelar);
		
		btnSeleccionar = new JButton("SELECCIONAR");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarActionPerformed(e);
			}
		});
		btnSeleccionar.setBounds(461, 40, 128, 25);
		getContentPane().add(btnSeleccionar);

	}
	
	protected void confirmarActionPerformed(ActionEvent e) {
		usuarioAModificar.setNombre(textFieldNombre.getText());
		usuarioAModificar.setApellido(textFieldApellido.getText());
		usuarioAModificar.setFechaNac(dateChooserFechaDeNacimiento.getDate());
		iConModUsu.modificarDatosUsuario(usuarioAModificar);
		JOptionPane.showMessageDialog(this, "Los datos del usuario '" + usuarioAModificar.getNick() + "' fueron modificados con éxito.", "Modificar datos de usuario", JOptionPane.INFORMATION_MESSAGE);
		limpiar();
		btnConfirmar.setEnabled(false);
		setVisible(false);
	}
	
	protected void cancelarActionPerformed(ActionEvent e) {
		btnConfirmar.setEnabled(false);
		limpiar();
		setVisible(false);
	}
	
	protected void seleccionarActionPerformed(ActionEvent e) {
		 String usuarioSeleccionado = comboBoxUsuarios.getSelectedItem().toString();
		 usuarioAModificar = iConModUsu.seleccionarUsuario(usuarioSeleccionado);
		 llenarTextFields(usuarioAModificar);
		 btnConfirmar.setEnabled(true);
		 
	}
	
	public void inicializarComboBoxUsuarios() {					
		if(iConModUsu.getUsuarios().length != 0) {
			DefaultComboBoxModel<String> modelInstituto = new DefaultComboBoxModel<String>(iConModUsu.getUsuarios());		
			comboBoxUsuarios.setModel(modelInstituto);
		}
	}
	
	public void llenarTextFields(DtUsuario usuario) {
		textFieldNombre.setText(usuario.getNombre());
		textFieldApellido.setText(usuario.getApellido());
		dateChooserFechaDeNacimiento.setDate(usuario.getFechaNac());
		
	}
	
	public void limpiar() {
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		Date aux = new Date();
		dateChooserFechaDeNacimiento.setDate(aux);
	}
	
}
