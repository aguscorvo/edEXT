package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaInstituto;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class IngresarCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaCurso iConAltCur;
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldCantHoras;
	private JTextField textFieldDuracion;
	private JTextField textFieldURL;
	private JTextField textFieldPrevias;
	

	
	public IngresarCurso(IControladorAltaCurso iConAltCur) {
		this.iConAltCur = iConAltCur;
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Ingresar Curso");
		setBounds(100, 100, 809, 483);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(76, 74, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(164, 72, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(76, 127, 92, 15);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(186, 125, 114, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblDuracin = new JLabel("DURACIÓN");
		lblDuracin.setBounds(76, 179, 79, 15);
		getContentPane().add(lblDuracin);
		
		JLabel lblCantidadDeHoras = new JLabel("CANTIDAD DE HORAS");
		lblCantidadDeHoras.setBounds(76, 230, 150, 15);
		getContentPane().add(lblCantidadDeHoras);
		
		textFieldCantHoras = new JTextField();
		textFieldCantHoras.setBounds(244, 228, 56, 19);
		getContentPane().add(textFieldCantHoras);
		textFieldCantHoras.setColumns(10);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(186, 177, 114, 19);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(76, 288, 32, 15);
		getContentPane().add(lblUrl);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(126, 286, 232, 19);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JLabel lblPrevias = new JLabel("PREVIAS");
		lblPrevias.setBounds(76, 353, 62, 15);
		getContentPane().add(lblPrevias);
		
		textFieldPrevias = new JTextField();
		textFieldPrevias.setBounds(150, 351, 208, 19);
		getContentPane().add(textFieldPrevias);
		textFieldPrevias.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(454, 140, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(454, 202, 117, 25);
		getContentPane().add(btnCancelar);


	}
}
