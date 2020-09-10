package presentacion;


import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import excepciones.InstitutoRepetidaException;
import excepciones.NoExisteEdicionVigenteException;
import interfaces.IControladorInscripcionAEdicion;
import logica.Instituto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InscripcionAEdicion extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;


	private IControladorInscripcionAEdicion iConInsEd;
	private JTextField textFieldEdicion;
	private JComboBox <String> comboBoxInstituto;
	private JComboBox <String> comboBoxCurso;
	private JComboBox <String> comboBoxEstudiante;
	private JButton btnVerEdicion;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private String institutoSeleccionado;
	private String cursoSeleccionado;
	private String edicion;
	private String estudianteSeleccionado;
	
	
	public InscripcionAEdicion(IControladorInscripcionAEdicion iConInsEd) {
		this.iConInsEd=iConInsEd;
		setTitle("Inscripción a edición");
		setBounds(100, 100, 725, 403);
		getContentPane().setLayout(null);
		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(58, 55, 132, 15);
		getContentPane().add(lblInstituto);
		
		comboBoxInstituto = new JComboBox<String>();
		comboBoxInstituto.setBounds(237, 50, 203, 24);
		getContentPane().add(comboBoxInstituto);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(58, 107, 70, 15);
		getContentPane().add(lblCurso);
		
		comboBoxCurso = new JComboBox<String>();
		comboBoxCurso.setBounds(237, 102, 203, 24);
		getContentPane().add(comboBoxCurso);
		
		JLabel lblEdicion = new JLabel("EDICIÓN VIGENTE");
		lblEdicion.setBounds(58, 171, 132, 15);
		getContentPane().add(lblEdicion);
		
		comboBoxEstudiante = new JComboBox<String>();
		comboBoxEstudiante.setBounds(237, 220, 203, 24);
		getContentPane().add(comboBoxEstudiante);
		
		textFieldEdicion = new JTextField();
		textFieldEdicion.setBounds(237, 169, 203, 24);
		getContentPane().add(textFieldEdicion);
		textFieldEdicion.setColumns(10);
		
		JLabel lblEstudiante = new JLabel("ESTUDIANTE");
		lblEstudiante.setBounds(58, 225, 117, 15);
		getContentPane().add(lblEstudiante);
		
		btnVerEdicion = new JButton("VER EDICIÓN");
		btnVerEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verEdicionActionPerformed(e);
			}
		});
		btnVerEdicion.setBounds(488, 102, 142, 25);
		getContentPane().add(btnVerEdicion);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(180, 293, 117, 25);
		getContentPane().add(btnConfirmar);
		btnConfirmar.setEnabled(false);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(369, 293, 117, 25);
		getContentPane().add(btnCancelar);

	}
	
	public void inicializarComboBoxEstudiante() {
		edicion = textFieldEdicion.getText();
		if(!edicion.isEmpty()) {
			if(iConInsEd.getEstudiantes(edicion).length !=0) {
				DefaultComboBoxModel<String> modelEstudiante = new DefaultComboBoxModel<String>(iConInsEd.getEstudiantes(edicion));		
				comboBoxEstudiante.setModel(modelEstudiante);
				comboBoxEstudiante.setEnabled(true);
				btnConfirmar.setEnabled(true);

			}
		}else {
			limpiarComboBoxEstudiante();
			btnConfirmar.setEnabled(false);	
			

		}
	
	}
	
	protected void verEdicionActionPerformed(ActionEvent e){
		cursoSeleccionado = comboBoxCurso.getSelectedItem().toString();
		try{
			edicion=iConInsEd.ingresarCurso(cursoSeleccionado);
			textFieldEdicion.setEnabled(true);
			textFieldEdicion.setText(edicion);
			//textFieldEdicion.setEnabled(false);
			comboBoxEstudiante.setEnabled(true);
			inicializarComboBoxEstudiante();
			
			
		}catch (NoExisteEdicionVigenteException ed) {			
            JOptionPane.showMessageDialog(this, ed.getMessage(), "Inscripción a edición", JOptionPane.ERROR_MESSAGE);
            setVisible(false); //opcional
		}
	}
	
	protected void cancelarActionPerformed(ActionEvent e) {
		iConInsEd.cancelarInscripcionAEdicion();
		textFieldEdicion.setText("");
		limpiarComboBoxEstudiante();
		setVisible(false);
	}
	
	protected void confirmarActionPerformed(ActionEvent e) {
		Date horaActual = new Date();
		estudianteSeleccionado= comboBoxEstudiante.getSelectedItem().toString();
		iConInsEd.ingresarEstudiante(estudianteSeleccionado,horaActual);
		iConInsEd.confirmarInscripcionAEdicion();
		JOptionPane.showMessageDialog(this, "El estudiante '" + estudianteSeleccionado + "' se ha inscripto a la edición '" + edicion + "' con éxito",
				"Inscripción a edición de curso", JOptionPane.INFORMATION_MESSAGE);
		textFieldEdicion.setText("");
		limpiarComboBoxEstudiante();
		btnConfirmar.setEnabled(false);
		setVisible(false);
	}
	
	
	public void iniciarlizarComboBoxInstituto() {
		
		if(iConInsEd.getInstitutos().length != 0) {
			DefaultComboBoxModel<String> modelInstituto = new DefaultComboBoxModel<String>(iConInsEd.getInstitutos());		
			comboBoxInstituto.setModel(modelInstituto);
		}
		
	}
	
	public void iniciarlizarComboBoxCurso() {
		
		this.institutoSeleccionado =  comboBoxInstituto.getSelectedItem().toString();
		if(iConInsEd.getCursos(this.institutoSeleccionado).length != 0){
			DefaultComboBoxModel<String> modelCurso = new DefaultComboBoxModel<String>(iConInsEd.getCursos(this.institutoSeleccionado));		
			comboBoxCurso.setModel(modelCurso);		
		}
		
	}
	public void limpiarComboBoxEstudiante() {
		DefaultComboBoxModel<String> modelEstudiante = new DefaultComboBoxModel<String>();		
		comboBoxEstudiante.setModel(modelEstudiante);
		comboBoxEstudiante.setEnabled(false);
	}
	
	
}
