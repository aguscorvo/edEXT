package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarCursoAPrograma extends JInternalFrame {

	
	public AgregarCursoAPrograma() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Agregar curso a programa de formacion");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblProgramaDeFormacion = new JLabel("PROGRAMA");
		lblProgramaDeFormacion.setBounds(56, 58, 73, 14);
		getContentPane().add(lblProgramaDeFormacion);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(56, 109, 73, 14);
		getContentPane().add(lblCurso);
		
		JComboBox comboBoxPrograma = new JComboBox();
		comboBoxPrograma.setBounds(141, 55, 208, 20);
		getContentPane().add(comboBoxPrograma);
		
		JComboBox comboBoxCurso = new JComboBox();
		comboBoxCurso.setBounds(139, 106, 210, 20);
		getContentPane().add(comboBoxCurso);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setBounds(85, 186, 99, 23);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(222, 186, 99, 23);
		getContentPane().add(btnCancelar);

	}
}
