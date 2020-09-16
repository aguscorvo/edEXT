package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import datatype.DtCursoExp;
import datatype.DtEdicion;
import datatype.DtProgFormacionExp;
import interfaces.IControladorConsultaCurso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;


	private IControladorConsultaCurso iConConCur;
	private JComboBox<String> comboBoxInstituto;
	private JComboBox<String> comboBoxCurso;
	private JComboBox<String> comboBoxPrevias;
	private JComboBox<String> comboBoxEdiciones;
	private JComboBox<String> comboBoxProgramas;
	private JButton btnVerCurso;
	private JButton btnVerEdicion;
	private JButton btnSalir;
	private JTextPane textPaneDatos;
	private String institutoSeleccionado;
	private String cursoSeleccionado;
	private String edicionSeleccionada; 
	private String progFormacionSeleccionado;
	private JButton btnVerPrograma;


	
	public ConsultaCurso(IControladorConsultaCurso iConConCur) {
		this.iConConCur=iConConCur;
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Curso");
		setBounds(100, 100, 818, 418);
		getContentPane().setLayout(null);
		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(27, 49, 73, 14);
		getContentPane().add(lblInstituto);
		
		comboBoxInstituto = new JComboBox<String>();
		comboBoxInstituto.setBounds(148, 49, 190, 20);
		getContentPane().add(comboBoxInstituto);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(27, 96, 73, 14);
		getContentPane().add(lblCurso);
		
		comboBoxCurso = new JComboBox<String>();
		comboBoxCurso.setBounds(148, 93, 190, 20);
		getContentPane().add(comboBoxCurso);
		
		btnVerCurso = new JButton("VER");
		btnVerCurso.setEnabled(false);
		btnVerCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verCursoActionPerformed(e);
			}
		});
		btnVerCurso.setBounds(392, 93, 80, 23);
		getContentPane().add(btnVerCurso);
		
		textPaneDatos = new JTextPane();
		textPaneDatos.setBounds(523, 26, 243, 219);
		getContentPane().add(textPaneDatos);
		
		JLabel lblEdiciones = new JLabel("EDICIONES");
		lblEdiciones.setBounds(27, 193, 87, 14);
		getContentPane().add(lblEdiciones);
		
		comboBoxEdiciones = new JComboBox<String>();
		comboBoxEdiciones.setBounds(148, 190, 190, 20);
		getContentPane().add(comboBoxEdiciones);
		
		JLabel lblProgramas = new JLabel("PROGRAMAS");
		lblProgramas.setBounds(27, 233, 105, 14);
		getContentPane().add(lblProgramas);
		
		comboBoxProgramas = new JComboBox<String>();
		comboBoxProgramas.setBounds(148, 233, 190, 20);
		getContentPane().add(comboBoxProgramas);
		
		btnVerEdicion = new JButton("VER");
		btnVerEdicion.setEnabled(false);
		btnVerEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verEdicionActionPerformed(e);
			}
		});
		btnVerEdicion.setBounds(392, 190, 80, 23);
		getContentPane().add(btnVerEdicion);
		
		btnVerPrograma = new JButton("VER");
		btnVerPrograma.setEnabled(false);
		btnVerPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verProgramaActionPerformed(e);
			}
		});
		btnVerPrograma.setBounds(392, 230, 80, 23);
		getContentPane().add(btnVerPrograma);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirActionPerformed(e);
			}
		});
		btnSalir.setBounds(324, 313, 117, 25);
		getContentPane().add(btnSalir);
		
		JButton btnVerInstituto = new JButton("VER");
		btnVerInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verCursosInstitutoActionPerformed(e);
			}
		});
		btnVerInstituto.setBounds(392, 47, 80, 23);
		getContentPane().add(btnVerInstituto);
		
		comboBoxPrevias = new JComboBox<String>();
		comboBoxPrevias.setBounds(148, 146, 190, 20);
		getContentPane().add(comboBoxPrevias);
		
		JLabel lblPrevias = new JLabel("PREVIAS");
		lblPrevias.setBounds(27, 149, 87, 14);
		getContentPane().add(lblPrevias);

	}
	
	
	protected void verCursosInstitutoActionPerformed(ActionEvent e) {
		institutoSeleccionado= comboBoxInstituto.getSelectedItem().toString();
		inicializarComboBoxCurso();
		btnVerCurso.setEnabled(true);

	}
	
	
	protected void verCursoActionPerformed(ActionEvent e) {
		
		textPaneDatos.setText("");
		this.cursoSeleccionado = comboBoxCurso.getSelectedItem().toString();
		comboBoxEdiciones.setEnabled(true);
		comboBoxProgramas.setEnabled(true);
		inicializarComboBoxPrevias();
		inicializarComboBoxEdiciones();
		inicializarComboBoxProgramas();
		DtCursoExp auxDTCE = iConConCur.seleccionarCurso(cursoSeleccionado);
		textPaneDatos.setText(iConConCur.obtenerDatosCurso(auxDTCE));
		
	}
	
		
	protected void verEdicionActionPerformed(ActionEvent e) {
		
		textPaneDatos.setText("");
		this.edicionSeleccionada = comboBoxEdiciones.getSelectedItem().toString();
		DtEdicion auxDTE = iConConCur.seleccionarEdicion(edicionSeleccionada);
		textPaneDatos.setText(iConConCur.obtenerDatosEdicion(auxDTE));
		

		
		
	}
	
	protected void verProgramaActionPerformed(ActionEvent e) {
		
		textPaneDatos.setText("");
		this.progFormacionSeleccionado = comboBoxProgramas.getSelectedItem().toString();
		DtProgFormacionExp auxDTPFE = iConConCur.seleccionarProgFormacion(progFormacionSeleccionado);
		textPaneDatos.setText(iConConCur.obtenerDatosPrograma(auxDTPFE));
		
		
	}
	
	
	
	
	protected void salirActionPerformed(ActionEvent e) {
		btnVerCurso.setEnabled(false);
		btnVerEdicion.setEnabled(false);
		btnVerEdicion.setEnabled(false);
		btnVerPrograma.setEnabled(false);
		limpiar();
		setVisible(false);
	
	}
	
	
	public void inicializarComboBoxInstituto() {		
		
		
		if(iConConCur.getInstitutos().length != 0) {
			DefaultComboBoxModel<String> modelInstituto = new DefaultComboBoxModel<String>(iConConCur.getInstitutos());		
			comboBoxInstituto.setModel(modelInstituto);
		}

	
	}
	
	public void inicializarComboBoxCurso() {		
		
		if(iConConCur.getInstitutos().length != 0) {
			this.institutoSeleccionado =  comboBoxInstituto.getSelectedItem().toString();
		
		
			if(iConConCur.ingresarInstituto(institutoSeleccionado).length != 0) {
				DefaultComboBoxModel<String> modelCurso = new DefaultComboBoxModel<String>(iConConCur.ingresarInstituto(institutoSeleccionado));		
				comboBoxCurso.setModel(modelCurso);
			}		
		}
	}	
	
	public void inicializarComboBoxPrevias() {
		if(iConConCur.getPrevias(cursoSeleccionado).length != 0) {
			DefaultComboBoxModel<String> modelPrevia = new DefaultComboBoxModel<String>(iConConCur.getPrevias(cursoSeleccionado));		
			comboBoxPrevias.setModel(modelPrevia);
		}
	
	}
	

	public void inicializarComboBoxEdiciones() {		
		
		if(iConConCur.getEdiciones(cursoSeleccionado).length != 0) {
			DefaultComboBoxModel<String> modelEdiciones = new DefaultComboBoxModel<String>(iConConCur.getEdiciones(cursoSeleccionado));		
			comboBoxEdiciones.setModel(modelEdiciones);
			btnVerEdicion.setEnabled(true);

		}		
	}
	
	public void inicializarComboBoxProgramas() {		
		
		if(iConConCur.getPFs(cursoSeleccionado).length != 0) {
			DefaultComboBoxModel<String> modelProgramas = new DefaultComboBoxModel<String>(iConConCur.getPFs(cursoSeleccionado));		
			comboBoxProgramas.setModel(modelProgramas);
			btnVerPrograma.setEnabled(true);

		}		
	}
	
	public void limpiar() {
				
		textPaneDatos.setText("");
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();		
		comboBoxInstituto.setModel(model);
		comboBoxCurso.setModel(model);
		comboBoxPrevias.setModel(model);
		comboBoxEdiciones.setModel(model);
		comboBoxProgramas.setModel(model);
		
		
	}
}


	
