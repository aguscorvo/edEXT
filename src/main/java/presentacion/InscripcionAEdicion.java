package presentacion;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;

import interfaces.IControladorInscripcionAEdicion;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class InscripcionAEdicion extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private IControladorInscripcionAEdicion iConInsEd;
	
	public InscripcionAEdicion(IControladorInscripcionAEdicion iConsInsEd) {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Inscripción a edición de curso");
		this.iConInsEd=iConsInsEd;
		setBounds(100, 100, 710, 452);
		getContentPane().setLayout(null);
		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(56, 38, 93, 15);
		getContentPane().add(lblInstituto);
		
		JComboBox comboBoxInstituto = new JComboBox();
		comboBoxInstituto.setBounds(147, 33, 198, 24);
		getContentPane().add(comboBoxInstituto);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(56, 107, 70, 15);
		getContentPane().add(lblCurso);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(147, 102, 198, 24);
		getContentPane().add(comboBox);
		
		JButton btnVerEdicion = new JButton("VER EDICIÓN");
		btnVerEdicion.setBounds(374, 102, 145, 24);
		getContentPane().add(btnVerEdicion);

	}
}
