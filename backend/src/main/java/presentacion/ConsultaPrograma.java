package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import datatype.DtCursoExp;
import datatype.DtProgFormacionExp;
import interfaces.IControladorConsultaProgFormacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaPrograma extends JInternalFrame {

	private IControladorConsultaProgFormacion iConConPF;

	
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboBoxProgramas;
	private JComboBox<String> comboBoxCursos;
	private JComboBox<String> comboBoxCats;	
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
		lblPrograma.setBounds(36, 22, 94, 14);
		getContentPane().add(lblPrograma);
		
		comboBoxProgramas = new JComboBox<String>();
		comboBoxProgramas.setBounds(36, 48, 197, 20);
		getContentPane().add(comboBoxProgramas);
		
		btnVerPrograma = new JButton("VER");
		btnVerPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verProgramaActionPerformed(e);
			}
		});
		btnVerPrograma.setBounds(270, 47, 89, 23);
		getContentPane().add(btnVerPrograma);
		
		comboBoxCursos = new JComboBox<String>();
		comboBoxCursos.setBounds(36, 190, 196, 20);
		getContentPane().add(comboBoxCursos);
		
		btnVerCurso = new JButton("VER");
		btnVerCurso.setEnabled(false);
		btnVerCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verCursoActionPerformed(e);
			}
		});
		btnVerCurso.setBounds(269, 189, 89, 23);
		getContentPane().add(btnVerCurso);
		
		textPane = new JTextPane();
		textPane.setBounds(410, 30, 236, 251);
		getContentPane().add(textPane);
		
		JLabel lblCursosAsociados = new JLabel("CURSOS QUE LO INTEGRAN:");
		lblCursosAsociados.setBounds(36, 164, 196, 14);
		getContentPane().add(lblCursosAsociados);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirActionPerformed(e);
			}
		});
		btnSalir.setBounds(145, 241, 117, 25);
		getContentPane().add(btnSalir);
		
		JLabel lblCategorasAsociadas = new JLabel("CATEGORíAS ASOCIADAS:");
		lblCategorasAsociadas.setBounds(36, 86, 197, 15);
		getContentPane().add(lblCategorasAsociadas);
		
		comboBoxCats = new JComboBox<String>();
		comboBoxCats.setBounds(36, 113, 197, 24);
		getContentPane().add(comboBoxCats);

	}
	
	protected void verProgramaActionPerformed(ActionEvent e) {
		textPane.setText("");
		programaSeleccionado= comboBoxProgramas.getSelectedItem().toString();
		dtPrograma= iConConPF.seleccionarPrograma(programaSeleccionado);
		datosPrograma= iConConPF.obtenerDatosPrograma(dtPrograma);
		textPane.setText(datosPrograma);
		inicializarComboBoxCursos();
		inicializarComboBoxCategorias();
	}
	
	protected void verCursoActionPerformed(ActionEvent e) {
		textPane.setText("");
		cursoSeleccionado= comboBoxCursos.getSelectedItem().toString();
		dtCurso = iConConPF.seleccionarCurso(cursoSeleccionado);
		datosCurso = iConConPF.obtenerDatosCurso(dtCurso);
		textPane.setText(datosCurso);
		
	}
	
	protected void salirActionPerformed(ActionEvent e) {
		btnVerCurso.setEnabled(false);
		limpiar();
		setVisible(false);
	}
	
	
	
	
	
	
	public void inicializarComboBoxProgramas() {	
		if(iConConPF.getProgramasDeFormacion().length != 0) {
			DefaultComboBoxModel<String> modelPrograma = new DefaultComboBoxModel<String>(iConConPF.getProgramasDeFormacion());		
			comboBoxProgramas.setModel(modelPrograma);
		}	
	}
	
	public void inicializarComboBoxCategorias () {
		String [] categorias = iConConPF.getCategoriasPrograma(dtPrograma.getNombre());
		
		if(categorias.length != 0) {
			DefaultComboBoxModel<String> modelCurso = new DefaultComboBoxModel<String>(categorias);		
			comboBoxCats.setModel(modelCurso);
		}else {
			
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();		
			comboBoxCats.setModel(model);

		}
		
	}
	
	public void inicializarComboBoxCursos() {
		String [] cursos = iConConPF.getCursos(dtPrograma);
				
		if(cursos.length != 0) {
			DefaultComboBoxModel<String> modelCurso = new DefaultComboBoxModel<String>(cursos);		
			comboBoxCursos.setModel(modelCurso);
			btnVerCurso.setEnabled(true);
		}else {
			
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();		
			comboBoxCursos.setModel(model);
			btnVerCurso.setEnabled(false);

		}
	}
	
	public void limpiar() {
		textPane.setText("");
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();		
		comboBoxProgramas.setModel(model);
		comboBoxCursos.setModel(model);
		comboBoxCats.setModel(model);
		
	}
}