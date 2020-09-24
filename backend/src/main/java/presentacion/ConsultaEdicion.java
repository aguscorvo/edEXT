package presentacion;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import interfaces.IControladorConsultaEdicion;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import datatype.DtEdicion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaEdicion extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	
	private IControladorConsultaEdicion iConConEdi;
	private JComboBox<String> comboBoxInstituto;
	private JComboBox<String> comboBoxCurso;
	private JComboBox<String> comboBoxEdicion;
	private JButton btnSalir;
	private String institutoSeleccionado;
	private String cursoSeleccionado;
	private String edicionSeleccionado;
	private JTextPane textPane;
	private JButton btnVerCursos;
	private JButton btnVerEdiciones;
	private JButton btnConfirmar;

	

	public ConsultaEdicion(IControladorConsultaEdicion iConConEdi) {
		this.iConConEdi = iConConEdi;
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setTitle("Consulta de edición de curso");
		setBounds(100, 100, 811, 409);
		getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(67, 52, 81, 15);
		getContentPane().add(lblInstituto);
		
		comboBoxEdicion = new JComboBox<String>();
		comboBoxEdicion.setBounds(152, 212, 194, 24);
		getContentPane().add(comboBoxEdicion);
		
		comboBoxCurso = new JComboBox<String>();
		comboBoxCurso.setBounds(152, 126, 194, 24);
		getContentPane().add(comboBoxCurso);
		
		comboBoxInstituto = new JComboBox<String>();
		comboBoxInstituto.setBounds(152, 47, 194, 24);
		getContentPane().add(comboBoxInstituto);
					
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(67, 131, 70, 15);
		getContentPane().add(lblCurso);
		
		JLabel lblEdicion = new JLabel("EDICION");
		lblEdicion.setBounds(67, 217, 70, 15);
		getContentPane().add(lblEdicion);
				
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirActionPerformed(e);
			}
		});
		btnSalir.setBounds(229, 275, 117, 25);
		getContentPane().add(btnSalir);
		
		textPane = new JTextPane();
		textPane.setBounds(502, 47, 254, 253);
		getContentPane().add(textPane);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(63, 275, 117, 25);
		getContentPane().add(btnConfirmar);
		
		btnVerCursos = new JButton("VER");
		btnVerCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verCursosActionPerformed(e);
			}
		});
		btnVerCursos.setBounds(373, 47, 70, 25);
		getContentPane().add(btnVerCursos);
		
		btnVerEdiciones = new JButton("VER");
		btnVerEdiciones.setEnabled(false);
		btnVerEdiciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verEdicionesActionPerformed(e);
			}
		});
		btnVerEdiciones.setBounds(373, 126, 70, 25);
		getContentPane().add(btnVerEdiciones);
		
		
	}
	
	protected void 	verCursosActionPerformed(ActionEvent e) {
		institutoSeleccionado= comboBoxInstituto.getSelectedItem().toString();
		inicializarComboBoxCurso();
		btnVerEdiciones.setEnabled(true);
	}

	
	protected void verEdicionesActionPerformed(ActionEvent e) {
		cursoSeleccionado = comboBoxCurso.getSelectedItem().toString();
		inicializarComboBoxEdicion();

	}
	
	
	protected void salirActionPerformed(ActionEvent e) {
		btnConfirmar.setEnabled(false);
		btnVerEdiciones.setEnabled(false);
		limpiar();
		setVisible(false);	
	}
	
	protected void  confirmarActionPerformed(ActionEvent e) {
		
		textPane.setText("");
		this.edicionSeleccionado = comboBoxEdicion.getSelectedItem().toString();
		DtEdicion auxEdicion = iConConEdi.ingresarEdicion(edicionSeleccionado);
		String auxDatos = iConConEdi.obtenerDatosEdicion(auxEdicion);
		textPane.setText(auxDatos);
		
	}
	
	

	
	public void inicializarComboBoxInstituto() {
		
		if(iConConEdi.getInstitutos().length != 0) {
			DefaultComboBoxModel<String> modelInstituto = new DefaultComboBoxModel<String>(iConConEdi.getInstitutos());		
			comboBoxInstituto.setModel(modelInstituto);
		}
		
	}
	
	public void inicializarComboBoxCurso() {
		
		if(iConConEdi.getInstitutos().length != 0) {
			this.institutoSeleccionado =  comboBoxInstituto.getSelectedItem().toString();
			if(iConConEdi.getCursos(this.institutoSeleccionado).length != 0){
				DefaultComboBoxModel<String> modelCurso = new DefaultComboBoxModel<String>(iConConEdi.getCursos(this.institutoSeleccionado));		
				comboBoxCurso.setModel(modelCurso);		
			}

		}
	}	
	
	public void inicializarComboBoxEdicion() {
		
		if(iConConEdi.getEdiciones(this.cursoSeleccionado).length != 0) {
			DefaultComboBoxModel<String> modelEdicion = new DefaultComboBoxModel<String>(iConConEdi.getEdiciones(this.cursoSeleccionado));		
			comboBoxEdicion.setModel(modelEdicion);
			btnConfirmar.setEnabled(true);
		}
		else {
			btnConfirmar.setEnabled(false);
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();	
			comboBoxEdicion.setModel(model);
		}

	}
	
	public void limpiar() {
		textPane.setText("");
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();		
		comboBoxInstituto.setModel(model);
		comboBoxCurso.setModel(model);
		comboBoxEdicion.setModel(model);		
	}
}