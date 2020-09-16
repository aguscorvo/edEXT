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
	//private List<String> datosEdicion = new ArrayList<String>();
	private String institutoSeleccionado;
	private String cursoSeleccionado;
	private String edicionSeleccionado;
	private JTextPane textPane;

	

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
		textPane.setBounds(453, 47, 254, 253);
		getContentPane().add(textPane);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(63, 275, 117, 25);
		getContentPane().add(btnConfirmar);
		
		
		/*if(iConConEdi.getInstitutos().length == 0) {
			comboBoxInstituto.setEnabled(false);
			comboBoxCurso.setEnabled(false);
			comboBoxEdicion.setEnabled(false);
		}
		else {
			comboBoxInstituto.setEnabled(true);
			comboBoxCurso.setEnabled(true);
			comboBoxEdicion.setEnabled(true);
		}
		
		if(iConConEdi.getCursos(institutoSeleccionado).length == 0) {
			
			comboBoxCurso.setEnabled(false);
			comboBoxEdicion.setEnabled(false);
		}
		else {
			
			comboBoxCurso.setEnabled(true);
			comboBoxEdicion.setEnabled(true);
			
		}
		
		if(iConConEdi.getEdiciones(cursoSeleccionado).length == 0) {
			comboBoxEdicion.setEnabled(false);
		}
		else {
			comboBoxEdicion.setEnabled(true);

		}*/
		


	}
	
	
	protected void salirActionPerformed(ActionEvent e) {
		
		textPane.setText("");
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
	
	public void iniciarlizarComboBoxCurso() {
		
		if(iConConEdi.getInstitutos().length != 0) {
			this.institutoSeleccionado =  comboBoxInstituto.getSelectedItem().toString();
			if(iConConEdi.getCursos(this.institutoSeleccionado).length != 0){
				DefaultComboBoxModel<String> modelCurso = new DefaultComboBoxModel<String>(iConConEdi.getCursos(this.institutoSeleccionado));		
				comboBoxCurso.setModel(modelCurso);		
			}

		}
	}	
	
	public void iniciarlizarComboBoxEdicion() {
		
		this.cursoSeleccionado = (String) comboBoxCurso.getSelectedItem();
		if(iConConEdi.getEdiciones(this.cursoSeleccionado).length != 0) {
			DefaultComboBoxModel<String> modelEdicion = new DefaultComboBoxModel<String>(iConConEdi.getEdiciones(this.cursoSeleccionado));		
			comboBoxEdicion.setModel(modelEdicion);
		}
	}
}
