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
	private JComboBox<String> comboBoxCategorias;
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
		lblInstituto.setBounds(27, 28, 73, 14);
		getContentPane().add(lblInstituto);
		
		comboBoxInstituto = new JComboBox<String>();
		comboBoxInstituto.setBounds(148, 28, 190, 20);
		getContentPane().add(comboBoxInstituto);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(27, 75, 73, 14);
		getContentPane().add(lblCurso);
		
		comboBoxCurso = new JComboBox<String>();
		comboBoxCurso.setBounds(148, 72, 190, 20);
		getContentPane().add(comboBoxCurso);
		
		btnVerCurso = new JButton("VER");
		btnVerCurso.setEnabled(false);
		btnVerCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verCursoActionPerformed(e);
			}
		});
		btnVerCurso.setBounds(392, 72, 80, 23);
		getContentPane().add(btnVerCurso);
		
		textPaneDatos = new JTextPane();
		textPaneDatos.setBounds(523, 26, 243, 219);
		getContentPane().add(textPaneDatos);
		
		JLabel lblEdiciones = new JLabel("EDICIONES");
		lblEdiciones.setBounds(27, 230, 87, 14);
		getContentPane().add(lblEdiciones);
		
		comboBoxEdiciones = new JComboBox<String>();
		comboBoxEdiciones.setBounds(148, 227, 190, 20);
		getContentPane().add(comboBoxEdiciones);
		
		JLabel lblProgramas = new JLabel("PROGRAMAS");
		lblProgramas.setBounds(27, 270, 105, 14);
		getContentPane().add(lblProgramas);
		
		comboBoxProgramas = new JComboBox<String>();
		comboBoxProgramas.setBounds(148, 270, 190, 20);
		getContentPane().add(comboBoxProgramas);
		
		btnVerEdicion = new JButton("VER");
		btnVerEdicion.setEnabled(false);
		btnVerEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verEdicionActionPerformed(e);
			}
		});
		btnVerEdicion.setBounds(392, 227, 80, 23);
		getContentPane().add(btnVerEdicion);
		
		btnVerPrograma = new JButton("VER");
		btnVerPrograma.setEnabled(false);
		btnVerPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verProgramaActionPerformed(e);
			}
		});
		btnVerPrograma.setBounds(392, 267, 80, 23);
		getContentPane().add(btnVerPrograma);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirActionPerformed(e);
			}
		});
		btnSalir.setBounds(221, 323, 117, 25);
		getContentPane().add(btnSalir);
		
		JButton btnVerInstituto = new JButton("VER");
		btnVerInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verCursosInstitutoActionPerformed(e);
			}
		});
		btnVerInstituto.setBounds(392, 26, 80, 23);
		getContentPane().add(btnVerInstituto);
		
		comboBoxPrevias = new JComboBox<String>();
		comboBoxPrevias.setBounds(148, 128, 190, 20);
		getContentPane().add(comboBoxPrevias);
		
		JLabel lblPrevias = new JLabel("PREVIAS");
		lblPrevias.setBounds(27, 131, 87, 14);
		getContentPane().add(lblPrevias);
		
		JLabel lblCategoras = new JLabel("CATEGORÍAS");
		lblCategoras.setBounds(27, 172, 87, 15);
		getContentPane().add(lblCategoras);
		
		comboBoxCategorias = new JComboBox<String>();
		comboBoxCategorias.setBounds(148, 172, 190, 19);
		getContentPane().add(comboBoxCategorias);

	}
	
	
	protected void verCursosInstitutoActionPerformed(ActionEvent e) {
		institutoSeleccionado= comboBoxInstituto.getSelectedItem().toString();
		inicializarComboBoxCurso();
		btnVerCurso.setEnabled(true);
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();	
		comboBoxEdiciones.setModel(model);
		comboBoxProgramas.setModel(model);
		comboBoxPrevias.setModel(model);
		textPaneDatos.setText("");

		


	}
	
	
	protected void verCursoActionPerformed(ActionEvent e) {
		
		textPaneDatos.setText("");
		this.cursoSeleccionado = comboBoxCurso.getSelectedItem().toString();
		comboBoxEdiciones.setEnabled(true);
		comboBoxProgramas.setEnabled(true);
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();	
		comboBoxEdiciones.setModel(model);
		comboBoxProgramas.setModel(model);
		inicializarComboBoxPrevias();
		inicializarComboBoxCategorias();
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
	

	public void inicializarComboBoxCategorias() {
		
		DefaultComboBoxModel<String> modelCat;
		
		if(iConConCur.getCategorias(cursoSeleccionado).length != 0) {
			modelCat = new DefaultComboBoxModel<String>(iConConCur.getCategorias(cursoSeleccionado));
		}
		else {
			modelCat = new DefaultComboBoxModel<String>();
		}
		
		comboBoxCategorias.setModel(modelCat);
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
		comboBoxCategorias.setModel(model);
		
		
	}
}


	
