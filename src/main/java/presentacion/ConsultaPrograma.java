package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import datatype.DtCursoExp;
import datatype.DtProgFormacionExp;
import interfaces.IControladorConsultaEdicion;
import interfaces.IControladorConsultaProgFormacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaPrograma extends JInternalFrame {

	private IControladorConsultaProgFormacion iConConPF;

	
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboBoxProgramas;
	private JComboBox<String> comboBoxCursos;
	private JButton btnVerPrograma;
	private JButton btnVerCurso;
	private JTextPane textPane;
	private JButton btnSalir;
	private DtProgFormacionExp dtPrograma;
	private DtCursoExp dtCurso;
	private String programaSeleccionado;
	private String cursoSeleccionado;
	private String datosPrograma;
	private String datosCurso;
	

	public ConsultaPrograma(IControladorConsultaProgFormacion iConConPF) {
		this.iConConPF=iConConPF;
		setTitle("Consulta de programa de formación");
		setBounds(100, 100, 686, 353);
		getContentPane().setLayout(null);
		
		JLabel lblPrograma = new JLabel("PROGRAMA");
		lblPrograma.setBounds(35, 55, 94, 14);
		getContentPane().add(lblPrograma);
		
		comboBoxProgramas = new JComboBox<String>();
		comboBoxProgramas.setBounds(35, 81, 162, 20);
		getContentPane().add(comboBoxProgramas);
		
		btnVerPrograma = new JButton("VER");
		btnVerPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verProgramaActionPerformed(e);
			}
		});
		btnVerPrograma.setBounds(269, 80, 89, 23);
		getContentPane().add(btnVerPrograma);
		
		comboBoxCursos = new JComboBox<String>();
		comboBoxCursos.setBounds(36, 161, 162, 20);
		getContentPane().add(comboBoxCursos);
		
		btnVerCurso = new JButton("VER");
		btnVerCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verCursoActionPerformed(e);
			}
		});
		btnVerCurso.setBounds(269, 160, 89, 23);
		getContentPane().add(btnVerCurso);
		
		textPane = new JTextPane();
		textPane.setBounds(410, 30, 236, 251);
		getContentPane().add(textPane);
		
		JLabel lblCursosAsociados = new JLabel("CURSOS QUE LO INTEGRAN:");
		lblCursosAsociados.setBounds(36, 135, 196, 14);
		getContentPane().add(lblCursosAsociados);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirActionPerformed(e);
			}
		});
		btnSalir.setBounds(145, 241, 117, 25);
		getContentPane().add(btnSalir);

	}
	
	protected void verProgramaActionPerformed(ActionEvent e) {
		textPane.setText("");
		programaSeleccionado= comboBoxProgramas.getSelectedItem().toString();
		dtPrograma= iConConPF.seleccionarPrograma(programaSeleccionado);
		datosPrograma= iConConPF.obtenerDatosPrograma(dtPrograma);
		textPane.setText(datosPrograma);
		inicializarComboBoxCursos();
	}
	
	protected void verCursoActionPerformed(ActionEvent e) {
		textPane.setText("");
		cursoSeleccionado= comboBoxCursos.getSelectedItem().toString();
		dtCurso = iConConPF.seleccionarCurso(cursoSeleccionado);
		datosCurso = iConConPF.obtenerDatosCurso(dtCurso);
		textPane.setText(datosCurso);
		
	}
	
	protected void salirActionPerformed(ActionEvent e) {
		textPane.setText("");
		setVisible(false);
	}
	
	
	
	
	
	
	public void inicializarComboBoxProgramas() {	
		if(iConConPF.getProgramasDeFormacion().length != 0) {
			DefaultComboBoxModel<String> modelPrograma = new DefaultComboBoxModel<String>(iConConPF.getProgramasDeFormacion());		
			comboBoxProgramas.setModel(modelPrograma);
		}	
	}
	
		
	public void inicializarComboBoxCursos() {
		String [] cursos = iConConPF.getCursos(dtPrograma);
				
		if(cursos.length != 0) {
			DefaultComboBoxModel<String> modelCurso = new DefaultComboBoxModel<String>(cursos);		
			comboBoxCursos.setModel(modelCurso);
		}	
	}
	 
	 	
	
	 
	
	
}
