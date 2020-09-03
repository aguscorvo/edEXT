package presentacion;


import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaCurso;
import javax.swing.JLabel;
import javax.swing.JTextField;

import datatype.DtCurso;
import excepciones.CursoRepetidoException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class IngresarCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaCurso iConAltCur;
	
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldCantHoras;
	private JTextField textFieldDuracion;
	private JTextField textFieldURL;
	private JTextField textFieldInstituto;
	private JTextField textFieldCreditos;
	private JComboBox<String> comboBoxPrevias;
	private List<String> previasSeleccionadas = new ArrayList<String>();
	private JButton btnConfirmar;
	private JButton btnAgregarPrevia;
	

	
	public IngresarCurso(IControladorAltaCurso iConAltCur) {
		this.iConAltCur = iConAltCur;
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Ingresar Curso");
		setBounds(100, 100, 766, 371);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(36, 84, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldNombre.setBounds(142, 82, 231, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(36, 125, 92, 15);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldDescripcion.setBounds(142, 123, 231, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblDuracin = new JLabel("DURACIÓN");		
		lblDuracin.setBounds(431, 42, 79, 15);
		getContentPane().add(lblDuracin);
		
		JLabel lblCantidadDeHoras = new JLabel("CANTIDAD DE HORAS");
		lblCantidadDeHoras.setBounds(431, 84, 150, 15);
		getContentPane().add(lblCantidadDeHoras);
		
		textFieldCantHoras = new JTextField();
		textFieldCantHoras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldCantHoras.setBounds(608, 82, 79, 19);
		getContentPane().add(textFieldCantHoras);
		textFieldCantHoras.setColumns(10);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldDuracion.setBounds(608, 40, 79, 19);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(431, 170, 32, 15);
		getContentPane().add(lblUrl);
		
		textFieldURL = new JTextField();
		textFieldURL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldURL.setBounds(474, 168, 236, 19);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JLabel lblPrevias = new JLabel("PREVIAS");
		lblPrevias.setBounds(36, 170, 62, 15);
		getContentPane().add(lblPrevias);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ingresarCursoConfirmarActionPerformed(e);
				 if (iConAltCur.getCursos().length!=0) {
					btnAgregarPrevia.setEnabled(true);
					comboBoxPrevias.setEnabled(true);
				}
			}
		});
		btnConfirmar.setBounds(224, 275, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarCursoCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(393, 275, 117, 25);
		getContentPane().add(btnCancelar);
		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(36, 42, 85, 15);
		getContentPane().add(lblInstituto);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldInstituto.setBounds(142, 40, 231, 19);
		getContentPane().add(textFieldInstituto);
		textFieldInstituto.setColumns(10);
		
		JLabel lblCrditos = new JLabel("CRÉDITOS");
		lblCrditos.setBounds(431, 125, 70, 15);
		getContentPane().add(lblCrditos);
		
		textFieldCreditos = new JTextField();
		textFieldCreditos.setBounds(608, 123, 79, 19);
		getContentPane().add(textFieldCreditos);
		textFieldCreditos.setColumns(10);
		
		btnAgregarPrevia = new JButton("Agregar");
		btnAgregarPrevia.setBounds(282, 201, 91, 25);
		getContentPane().add(btnAgregarPrevia);
		
		btnAgregarPrevia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPreviaActionPerformed(e);
				
			}
		});

		
		comboBoxPrevias = new JComboBox<String>();
		comboBoxPrevias.setBounds(142, 165, 231, 24);
		getContentPane().add(comboBoxPrevias);
		
		
		if (iConAltCur.getCursos().length ==0) {
			btnAgregarPrevia.setEnabled(false);
			comboBoxPrevias.setEnabled(false);
		}
		
	

	}
	
	protected void agregarPreviaActionPerformed(ActionEvent e) {
		String curso = comboBoxPrevias.getSelectedItem().toString();
		previasSeleccionadas.add(curso);
		JOptionPane.showMessageDialog(this, "El curso '" +curso+ "' fue agregado con éxito a la lista de previas.", "Ingresar Curso", JOptionPane.INFORMATION_MESSAGE);
		
	}

	
	protected void ingresarCursoConfirmarActionPerformed(ActionEvent e) {
		String instituto= textFieldInstituto.getText();
		String nombre = textFieldNombre.getText();
		String desc = textFieldDescripcion.getText();
		String d = textFieldDuracion.getText();
		String cHoras  = textFieldCantHoras.getText();
		String cred = textFieldCreditos.getText();
		Date fechaR = new Date();
		String url = textFieldURL.getText();
		List <String> previas = new ArrayList<String>(previasSeleccionadas);
		if (checkTextField(instituto) & checkTextField(nombre)& checkTextField(desc) & checkTextFieldInt(cHoras) & checkTextFieldInt(cred) & checkTextFieldInt(d) & checkTextField(url)) {
			
			int duracion = Integer.parseInt(d);
			int cantHoras = Integer.parseInt(cHoras);
			int creditos = Integer.parseInt(cred);
			DtCurso dt = new DtCurso(nombre, desc, duracion, cantHoras, creditos, fechaR, url, previas);			
			try {
				iConAltCur.ingresarCurso(instituto, dt);
				iConAltCur.confirmarAltaCurso();
				
				JOptionPane.showMessageDialog(this, "El curso '"+nombre+"' se ha creado con éxito", "Ingresar Curso", JOptionPane.INFORMATION_MESSAGE);

			}catch (NoExisteInstitutoException neie) {
	              JOptionPane.showMessageDialog(this, neie.getMessage(), "Ingresar Curso", JOptionPane.ERROR_MESSAGE);

			}catch (CursoRepetidoException cre) {
	              JOptionPane.showMessageDialog(this, cre.getMessage(), "Ingresar Curso", JOptionPane.ERROR_MESSAGE);

			}catch(NoExisteCursoException nece) {
	               JOptionPane.showMessageDialog(this, nece.getMessage(), "Ingresar Curso", JOptionPane.ERROR_MESSAGE);

			}
		}
			
		
		limpiarFormulario();
        setVisible(false);
	
	}
	
	
	protected void ingresarCursoCancelarActionPerformed(ActionEvent e) {
		iConAltCur.cancelarAltaCurso();
		limpiarFormulario();
		setVisible(false);
	}
	
	
	private boolean checkTextField(String string) {
		
		if(string.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ningún campo puede quedar vacío.", "Ingresar Curso",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;			
		
	}

	
	private boolean checkTextFieldInt(String string) {
	    if (string.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Ningún campo puede quedar vacío.", "Ingresar Curso",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    try {
	        Integer.parseInt(string);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Cantidad de horas, créditos y duración deben ser un número.", "Ingresar Curso",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    return true;
	}
	
	private void limpiarFormulario() {
		textFieldInstituto.setText("");
		textFieldNombre.setText("");
		textFieldDescripcion.setText("");
		textFieldCantHoras.setText("");
		textFieldDuracion.setText("");
		textFieldCreditos.setText("");
		textFieldURL.setText("");
	}
	
	public void iniciarlizarComboBoxes() {
		
		DefaultComboBoxModel<String> modelcursos = new DefaultComboBoxModel<String>(iConAltCur.getCursos());		
		comboBoxPrevias.setModel(modelcursos);
		
	}	
	
	public void habilitarBotonConfirmar() {
		if (!textFieldInstituto.getText().isEmpty() & !textFieldNombre.getText().isEmpty() & !textFieldDescripcion.getText().isEmpty() & !textFieldCantHoras.getText().isEmpty()
				& !textFieldDuracion.getText().isEmpty() & !textFieldCreditos.getText().isEmpty() & !textFieldURL.getText().isEmpty()) {
			btnConfirmar.setEnabled(true);
		}
		else {
			btnConfirmar.setEnabled(false);
		}
	}
}
