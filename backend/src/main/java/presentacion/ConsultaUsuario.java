package presentacion;

import javax.swing.JInternalFrame;

import interfaces.IControladorConsultaUsuario;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import datatype.DtEdicion;
import datatype.DtProgFormacionExp;
import datatype.DtUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	IControladorConsultaUsuario iConConUsu;
	
	private JComboBox<String> comboBoxUsuarios;
	private JComboBox<String> comboBoxEdiciones;
	private JComboBox<String> comboBoxProgramas;
	private JButton btnVerUsuario;
	private JButton btnVerEdicion;
	private JButton btnVerPrograma;
	private String usuarioSeleccionado;
	private String edicionSeleccionada;
	private String programaSeleccionado;
	private JTextPane textPane;
	private DtUsuario dtUsuarioSeleccionado;
	
	
	
	
	public ConsultaUsuario(IControladorConsultaUsuario iConConUsu) {
		setTitle("Consulta de usuario");
		this.iConConUsu=iConConUsu;
		setBounds(100, 100, 838, 436);
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(33, 45, 70, 15);
		getContentPane().add(lblUsuario);
		
		comboBoxUsuarios = new JComboBox<String>();
		comboBoxUsuarios.setBounds(163, 40, 166, 24);
		getContentPane().add(comboBoxUsuarios);
		
		btnVerUsuario = new JButton("VER");
		btnVerUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verUsuarioActionPerformed(e);
			}
		});
		btnVerUsuario.setBounds(359, 40, 60, 25);
		getContentPane().add(btnVerUsuario);
		
		JLabel lblEdiciones = new JLabel("EDICIONES");
		lblEdiciones.setBounds(33, 187, 105, 15);
		getContentPane().add(lblEdiciones);
		
		JLabel lblProgramas = new JLabel("PROGRAMAS");
		lblProgramas.setBounds(33, 241, 105, 15);
		getContentPane().add(lblProgramas);
		
		comboBoxEdiciones = new JComboBox<String>();
		comboBoxEdiciones.setBounds(163, 182, 166, 24);
		getContentPane().add(comboBoxEdiciones);
		
		comboBoxProgramas = new JComboBox<String>();
		comboBoxProgramas.setBounds(163, 236, 166, 24);
		getContentPane().add(comboBoxProgramas);
		
		btnVerEdicion = new JButton("VER");
		btnVerEdicion.setEnabled(false);
		btnVerEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verEdicionActionPerformed(e);
			}
		});
		btnVerEdicion.setBounds(359, 182, 60, 25);
		getContentPane().add(btnVerEdicion);
		
		btnVerPrograma = new JButton("VER");
		btnVerPrograma.setEnabled(false);
		btnVerPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verProgramaActionPerformed(e);
			}
		});
		btnVerPrograma.setBounds(359, 236, 60, 25);
		getContentPane().add(btnVerPrograma);
		
		textPane = new JTextPane();
		textPane.setBounds(506, 45, 248, 237);
		getContentPane().add(textPane);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarActionPerformed();
			}
		});
		btnCancelar.setBounds(336, 340, 117, 25);
		getContentPane().add(btnCancelar);

	}
	
	protected void verUsuarioActionPerformed(ActionEvent e) {
		usuarioSeleccionado = comboBoxUsuarios.getSelectedItem().toString();
		dtUsuarioSeleccionado=iConConUsu.seleccionarUsuario(usuarioSeleccionado);
		String datosUsuario= iConConUsu.obtenerDatosUsuario(dtUsuarioSeleccionado);
		textPane.setText(datosUsuario);
		inicializarComboBoxEdiciones();
		inicializarComboBoxProgramas();
		
		
	}
	
	protected void verEdicionActionPerformed(ActionEvent e) {
		edicionSeleccionada = comboBoxEdiciones.getSelectedItem().toString();
		DtEdicion dt = iConConUsu.seleccionarEdicion(edicionSeleccionada);
		String datosEdicion = iConConUsu.obtenerDatosEdicion(dt);
		textPane.setText(datosEdicion);
		
	}
	
	protected void verProgramaActionPerformed(ActionEvent e) {
		programaSeleccionado = comboBoxProgramas.getSelectedItem().toString();
		DtProgFormacionExp dt = iConConUsu.seleccionarPrograma(programaSeleccionado);
		String datosPrograma = iConConUsu.obtenerDatosPrograma(dt);
		textPane.setText(datosPrograma);
		
	}
	
	public void cancelarActionPerformed() {
		btnVerEdicion.setEnabled(false);
		btnVerPrograma.setEnabled(false);
		
		limpiar();
		setVisible(false);
	}
	
	public void limpiar() {
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		comboBoxUsuarios.setModel(model);
		comboBoxEdiciones.setModel(model);
		comboBoxProgramas.setModel(model);
		
		textPane.setText("");
	}
	
	public void inicializarComboBoxUsuarios() {					
		if(iConConUsu.getUsuarios().length != 0) {
			DefaultComboBoxModel<String> modelInstituto = new DefaultComboBoxModel<String>(iConConUsu.getUsuarios());		
			comboBoxUsuarios.setModel(modelInstituto);
			btnVerUsuario.setEnabled(true);
		}else btnVerUsuario.setEnabled(false);

	}
	
	public void inicializarComboBoxEdiciones() {		
		
		if(iConConUsu.getEdiciones(dtUsuarioSeleccionado).length != 0) {
			DefaultComboBoxModel<String> modelEdiciones = new DefaultComboBoxModel<String>(iConConUsu.getEdiciones(dtUsuarioSeleccionado));		
			comboBoxEdiciones.setModel(modelEdiciones);
			btnVerEdicion.setEnabled(true);
		}
		else btnVerEdicion.setEnabled(false);
	}

	public void inicializarComboBoxProgramas() {		
	
		if(iConConUsu.getProgramas(dtUsuarioSeleccionado).length != 0) {
			DefaultComboBoxModel<String> modelProgramas = new DefaultComboBoxModel<String>(iConConUsu.getProgramas(dtUsuarioSeleccionado));		
			comboBoxProgramas.setModel(modelProgramas);
			btnVerPrograma.setEnabled(true);
		}
		else btnVerPrograma.setEnabled(false);
	}
	
}