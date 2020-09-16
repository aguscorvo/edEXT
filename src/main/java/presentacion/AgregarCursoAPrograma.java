package presentacion;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import excepciones.CursoEnPFRepetidoException;
import interfaces.IControladorAgregarCursoAPF;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarCursoAPrograma extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
		
	private IControladorAgregarCursoAPF iConAgrCurAPF;
	private JComboBox<String> comboBoxPrograma;
	private JComboBox<String> comboBoxCurso;
	private JButton btnConfirmar; 

	
	public AgregarCursoAPrograma(IControladorAgregarCursoAPF iConAgrCurAPF) {
		this.iConAgrCurAPF=iConAgrCurAPF;
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Agregar curso a programa de formacion");
		setBounds(100, 100, 448, 270);
		getContentPane().setLayout(null);
		
		JLabel lblProgramaDeFormacion = new JLabel("PROGRAMA");
		lblProgramaDeFormacion.setBounds(52, 55, 128, 14);
		getContentPane().add(lblProgramaDeFormacion);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(52, 106, 73, 14);
		getContentPane().add(lblCurso);
		
		comboBoxPrograma = new JComboBox<String>();
		comboBoxPrograma.setBounds(168, 52, 208, 20);
		getContentPane().add(comboBoxPrograma);
		
		comboBoxCurso = new JComboBox<String>();
		comboBoxCurso.setBounds(166, 103, 210, 20);
		getContentPane().add(comboBoxCurso);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(77, 174, 122, 23);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarActionPerformed(e);
				
			}
		});
		btnCancelar.setBounds(239, 174, 122, 23);
		getContentPane().add(btnCancelar);

	}
	
	protected void confirmarActionPerformed(ActionEvent e) {
		String programa = comboBoxPrograma.getSelectedItem().toString();
		String curso = comboBoxCurso.getSelectedItem().toString();
		
		iConAgrCurAPF.seleccionarPrograma(programa);
		try {
			iConAgrCurAPF.seleccionarCurso(curso);
			JOptionPane.showMessageDialog(this, "El curso '" + curso + "' se ha agregado al programa de formación '" + programa + "' con éxito", "Agregar curso a programa de formación", JOptionPane.INFORMATION_MESSAGE);

		}catch (CursoEnPFRepetidoException cepfre) {
            JOptionPane.showMessageDialog(this, cepfre.getMessage(), "Ingresar programa de formación", JOptionPane.ERROR_MESSAGE);

		}
		limpiarComboBoxes();
		btnConfirmar.setEnabled(false);
		setVisible(false);
		
	}
	
	protected void cancelarActionPerformed(ActionEvent e) {
		btnConfirmar.setEnabled(false);
		limpiarComboBoxes();
		setVisible(false);
	}
	
	
		 
	 public void inicializarComboBoxCurso() {	
		if(iConAgrCurAPF.getCursos().length != 0) {
			DefaultComboBoxModel<String> modelCurso = new DefaultComboBoxModel<String>(iConAgrCurAPF.getCursos());		
			comboBoxCurso.setModel(modelCurso);
		}		
	}
	 
	 public void inicializarComboBoxProgramas() {	
		if(iConAgrCurAPF.getProgramas().length != 0) {
			DefaultComboBoxModel<String> modelPrograma = new DefaultComboBoxModel<String>(iConAgrCurAPF.getProgramas());		
			comboBoxPrograma.setModel(modelPrograma);
			btnConfirmar.setEnabled(true);

		}		
	}
	 
	public void limpiarComboBoxes() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();		
		comboBoxPrograma.setModel(model);
		comboBoxCurso.setModel(model);
	}
}