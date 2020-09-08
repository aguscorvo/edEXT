package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaces.IControladorConsultaEdicion;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextPane;

public class ConsultaEdicion extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	
	private IControladorConsultaEdicion iConConEdi;
	private JComboBox comboBoxInstituto;
	private JComboBox comboBoxCurso;
	private JComboBox comboBoxEdicion;
	private JButton btnCancelar;
	private List<String> datosEdicion = new ArrayList<String>();
	private String institutoSeleccionado;
	private String cursoSeleccionado;
	private String edicionSeleccionado;
	private JTextPane textPane;

	

	public ConsultaEdicion(IControladorConsultaEdicion iConConEdi) {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setTitle("Consulta de edición de curso");
		setBounds(100, 100, 799, 394);
		getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(67, 52, 81, 15);
		getContentPane().add(lblInstituto);
		
		comboBoxInstituto = new JComboBox();
		comboBoxInstituto.setBounds(152, 47, 194, 24);
		getContentPane().add(comboBoxInstituto);
		
		if(iConConEdi.getInstitutos().length == 0) {
			comboBoxInstituto.setEnabled(false);
			comboBoxCurso.setEnabled(false);
			comboBoxEdicion.setEnabled(false);
		}
		else {
			comboBoxInstituto.setEnabled(true);
			comboBoxCurso.setEnabled(true);
			comboBoxEdicion.setEnabled(true);
		}
			
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(67, 131, 70, 15);
		getContentPane().add(lblCurso);
		
		comboBoxCurso = new JComboBox();
		comboBoxCurso.setBounds(152, 126, 194, 24);
		getContentPane().add(comboBoxCurso);
		
		if(iConConEdi.getCursos(institutoSeleccionado).length == 0) {
			
			comboBoxCurso.setEnabled(false);
			comboBoxEdicion.setEnabled(false);
		}
		else {
			
			comboBoxCurso.setEnabled(true);
			comboBoxEdicion.setEnabled(true);
			
		}
		
		JLabel lblEdicion = new JLabel("EDICION");
		lblEdicion.setBounds(67, 217, 70, 15);
		getContentPane().add(lblEdicion);
		
		comboBoxEdicion = new JComboBox();
		comboBoxEdicion.setBounds(152, 212, 194, 24);
		getContentPane().add(comboBoxEdicion);
		
		if(iConConEdi.getEdiciones(cursoSeleccionado).length == 0) {
			comboBoxEdicion.setEnabled(false);
		}
		else {
			comboBoxEdicion.setEnabled(true);

		}
		
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(152, 275, 117, 25);
		getContentPane().add(btnCancelar);
		
		textPane = new JTextPane();
		textPane.setBounds(453, 47, 254, 253);
		getContentPane().add(textPane);
		
		
		


	}
	
	public void iniciarlizarComboBoxInstituto() {
		
		DefaultComboBoxModel<String> modelInstituto = new DefaultComboBoxModel<String>(iConConEdi.getInstitutos());		
		comboBoxInstituto.setModel(modelInstituto);
		
	}
	
	public void iniciarlizarComboBoxCurso() {
		
		DefaultComboBoxModel<String> modelCurso = new DefaultComboBoxModel<String>(iConConEdi.getCursos(this.institutoSeleccionado));		
		comboBoxCurso.setModel(modelCurso);
		
	}
	
	public void iniciarlizarComboBoxEdicion() {
		
		DefaultComboBoxModel<String> modelEdicion = new DefaultComboBoxModel<String>(iConConEdi.getEdiciones(this.cursoSeleccionado));		
		comboBoxEdicion.setModel(modelEdicion);
		
	}
}
