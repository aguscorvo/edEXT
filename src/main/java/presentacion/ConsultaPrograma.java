package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaPrograma extends JInternalFrame {

	
	public ConsultaPrograma() {
		setTitle("Consulta de programa de formacion");
		setBounds(100, 100, 637, 334);
		getContentPane().setLayout(null);
		
		JLabel lblPrograma = new JLabel("PROGRAMA");
		lblPrograma.setBounds(26, 70, 74, 14);
		getContentPane().add(lblPrograma);
		
		JComboBox comboBoxProgramas = new JComboBox();
		comboBoxProgramas.setBounds(97, 67, 162, 20);
		getContentPane().add(comboBoxProgramas);
		
		JButton btnVerPrograma = new JButton("VER");
		btnVerPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerPrograma.setBounds(269, 66, 89, 23);
		getContentPane().add(btnVerPrograma);
		
		JComboBox comboBoxCursos = new JComboBox();
		comboBoxCursos.setBounds(97, 187, 162, 20);
		getContentPane().add(comboBoxCursos);
		
		JButton btnVerCurso = new JButton("VER");
		btnVerCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerCurso.setBounds(269, 186, 89, 23);
		getContentPane().add(btnVerCurso);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(391, 29, 203, 236);
		getContentPane().add(textPane);
		
		JLabel lblCursosAsociados = new JLabel("CURSOS QUE INTEGRAN EL PROGRAMA:");
		lblCursosAsociados.setBounds(97, 150, 218, 14);
		getContentPane().add(lblCursosAsociados);

	}
}
