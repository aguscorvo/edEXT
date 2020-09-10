package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import interfaces.IControladorConsultaCurso;
import interfaces.IControladorConsultaEdicion;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaCurso extends JInternalFrame {

	private IControladorConsultaCurso iConConCur;
	private JComboBox<String> comboBoxInstituto;
	private JComboBox<String> comboBoxCurso;
	private JComboBox<String> comboBoxEdiciones;
	private JComboBox<String> comboBoxProgramas;
	private JButton btnVerCurso;
	private JButton btnVerEdicion;
	private JButton btnVerPrograma;
	private JButton btnSalir;
	private JTextPane textPaneDatos;


	
	public ConsultaCurso(IControladorConsultaCurso iConConCur) {
		this.iConConCur=iConConCur;
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Curso");
		setBounds(100, 100, 811, 372);
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
		lblEdiciones.setBounds(27, 169, 87, 14);
		getContentPane().add(lblEdiciones);
		
		comboBoxEdiciones = new JComboBox<String>();
		comboBoxEdiciones.setBounds(148, 166, 190, 20);
		getContentPane().add(comboBoxEdiciones);
		
		JLabel lblProgramas = new JLabel("PROGRAMAS");
		lblProgramas.setBounds(27, 209, 105, 14);
		getContentPane().add(lblProgramas);
		
		comboBoxProgramas = new JComboBox<String>();
		comboBoxProgramas.setBounds(148, 209, 190, 20);
		getContentPane().add(comboBoxProgramas);
		
		btnVerEdicion = new JButton("VER");
		btnVerEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verEdicionActionPerformed(e);
			}
		});
		btnVerEdicion.setBounds(392, 166, 80, 23);
		getContentPane().add(btnVerEdicion);
		
		JButton btnVerPrograma = new JButton("VER");
		btnVerPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verProgramaActionPerformed(e);
			}
		});
		btnVerPrograma.setBounds(392, 206, 80, 23);
		getContentPane().add(btnVerPrograma);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirActionPerformed(e);
			}
		});
		btnSalir.setBounds(324, 289, 117, 25);
		getContentPane().add(btnSalir);

	}
	
	protected void verCursoActionPerformed(ActionEvent e) {}
	
	protected void verEdicionActionPerformed(ActionEvent e) {}
	
	protected void verProgramaActionPerformed(ActionEvent e) {}
	
	protected void salirActionPerformed(ActionEvent e) {
		//limpiar comboBoxes y textPane
		setVisible(false);
	}
	
	
	/*public void iniciarlizarComboBoxInstituto() {		
		if(iConConEdi.getInstitutos().length != 0) {
			DefaultComboBoxModel<String> modelInstituto = new DefaultComboBoxModel<String>(iConConEdi.getInstitutos());		
			comboBoxInstituto.setModel(modelInstituto);
		}		
	}*/
	
	/*public void iniciarlizarComboBoxCurso() {		
		this.institutoSeleccionado =  comboBoxInstituto.getSelectedItem().toString();
		if(iConConEdi.getCursos(this.institutoSeleccionado).length != 0){
			DefaultComboBoxModel<String> modelCurso = new DefaultComboBoxModel<String>(iConConEdi.getCursos(this.institutoSeleccionado));		
			comboBoxCurso.setModel(modelCurso);	
		}		
	}*/
}
