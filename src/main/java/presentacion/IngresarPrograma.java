package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IngresarPrograma extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldDesc;

	
	public IngresarPrograma() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Crear programa de formacion");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(167, 28, 208, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(57, 31, 133, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(57, 75, 133, 14);
		getContentPane().add(lblDescripcion);
		
		textFieldDesc = new JTextField();
		textFieldDesc.setBounds(167, 69, 208, 20);
		getContentPane().add(textFieldDesc);
		textFieldDesc.setColumns(10);
		
		JLabel lblFechaDeInicio = new JLabel("FECHA DE INICIO");
		lblFechaDeInicio.setBounds(57, 116, 133, 14);
		getContentPane().add(lblFechaDeInicio);
		
		JLabel lblFechaDeFinalizacion = new JLabel("FECHA DE FINALIZACION");
		lblFechaDeFinalizacion.setBounds(57, 158, 133, 14);
		getContentPane().add(lblFechaDeFinalizacion);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setBounds(88, 210, 99, 23);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(239, 210, 99, 23);
		getContentPane().add(btnCancelar);
		
		JDateChooser dateChooserInicia = new JDateChooser();
		dateChooserInicia.setBounds(215, 111, 160, 19);
		getContentPane().add(dateChooserInicia);
		
		JDateChooser dateChooserFin = new JDateChooser();
		dateChooserFin.setBounds(215, 153, 160, 19);
		getContentPane().add(dateChooserFin);

	}
}
