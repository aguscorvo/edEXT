package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import datatype.DtProgFormacion;
import excepciones.ProgramaRepetidoException;
import interfaces.IControladorAltaProgFormacion;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.awt.event.ActionEvent;

public class IngresarPrograma extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaProgFormacion iConAltPF;
	private JTextField textFieldNombre;
	private JTextField textFieldDesc;
	private JDateChooser dateChooserInicio;
	private JDateChooser dateChooserFin;
	private JButton btnConfirmar;


	
	public IngresarPrograma(IControladorAltaProgFormacion iConAltPF) {
		this.iConAltPF=iConAltPF;
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Crear programa de formación");
		setBounds(100, 100, 485, 297);
		getContentPane().setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldNombre.setBounds(204, 29, 208, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(57, 31, 133, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(57, 75, 133, 14);
		getContentPane().add(lblDescripcion);
		
		textFieldDesc = new JTextField();
		textFieldDesc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldDesc.setBounds(204, 73, 208, 20);
		getContentPane().add(textFieldDesc);
		textFieldDesc.setColumns(10);
		
		JLabel lblFechaDeInicio = new JLabel("FECHA DE INICIO");
		lblFechaDeInicio.setBounds(57, 116, 133, 14);
		getContentPane().add(lblFechaDeInicio);
		
		JLabel lblFechaDeFinalizacion = new JLabel("FECHA DE FINALIZACIÓN");
		lblFechaDeFinalizacion.setBounds(57, 158, 173, 14);
		getContentPane().add(lblFechaDeFinalizacion);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(94, 214, 118, 23);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(247, 214, 119, 23);
		getContentPane().add(btnCancelar);
		
		dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(279, 111, 133, 19);
		getContentPane().add(dateChooserInicio);
		
		dateChooserFin = new JDateChooser();
		dateChooserFin.setBounds(285, 153, 127, 19);
		getContentPane().add(dateChooserFin);

	}
	
	protected void confirmarActionPerformed(ActionEvent e) {
		String nombre= textFieldNombre.getText();
		String desc= textFieldDesc.getText();
		Date auxFechaI = dateChooserInicio.getDate();
		Date auxFechaF = dateChooserFin.getDate();
		Date fechaAlta = new Date();
		
		if(checkFormulario(nombre) & checkFormulario(desc)) {
			DtProgFormacion dt = new DtProgFormacion (nombre, desc, auxFechaI, auxFechaF, fechaAlta);
			try {
				iConAltPF.ingresarProgFormacion(dt);
				iConAltPF.confirmarAltaPrograma();
				JOptionPane.showMessageDialog(this, "El programa de formación '" + nombre + "' se ha creado con éxito", "Ingresar programa de formación", JOptionPane.INFORMATION_MESSAGE);

			}catch (ProgramaRepetidoException pre) {
	              JOptionPane.showMessageDialog(this, pre.getMessage(), "Ingresar programa de formación", JOptionPane.ERROR_MESSAGE);

			}
		}
		
		btnConfirmar.setEnabled(false);
		limpiarFormularios();
        setVisible(false);		
		
		
	}
	
	protected void cancelarActionPerformed(ActionEvent e) {
		btnConfirmar.setEnabled(false);
		iConAltPF.cancelarAltaPrograma();
		limpiarFormularios();
		setVisible(false);
	}
	
	public void limpiarFormularios() {
		textFieldNombre.setText("");
		textFieldDesc.setText("");
		Date fechaActual = new Date();
		dateChooserInicio.setDate(fechaActual);
		dateChooserFin.setDate(fechaActual);
	}
	
	private boolean checkFormulario(String string) {
		if(string.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ningún campo puede quedar vacío.", "Ingresar programa de formación",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}		
		return true;
	}
	
	public void habilitarBotonConfirmar() {
		if (!textFieldNombre.getText().isEmpty() & !textFieldDesc.getText().isEmpty()) {
			btnConfirmar.setEnabled(true);
		}
		else {
			btnConfirmar.setEnabled(false);
		}
	}

	

}