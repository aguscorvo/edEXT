package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import interfaces.IControladorAltaEdicion;
import logica.Instituto;

import javax.swing.JLabel;
import javax.swing.JTextField;

import excepciones.EdicionRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import datatype.DtEdicionExp;

import javax.swing.JCheckBox;;

public class IngresarEdicion extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	
	private IControladorAltaEdicion iConAltEd;
	private List<String> CursosInstituto = new ArrayList<String>();
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JComboBox <String>comboBoxCursos;
	private JComboBox <String> comboBoxDocentes;
	private JTextField textFieldCupo;
	private JTextField textFieldNombre;
	private JTextField textFieldInstituto;
	private JCheckBox chckbxCupo;
	private String cursoSeleccionado;
	private JDateChooser dateChooserInicia;
	private JDateChooser dateChooserFinaliza;
	private JButton btnAgregar;
	private List<String> docentesSeleccionados = new ArrayList <String>();


	
	public IngresarEdicion(IControladorAltaEdicion iConAltEd) {
		this.iConAltEd = iConAltEd;
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Ingresar Edición");
		setBounds(100, 100, 748, 321);
		getContentPane().setLayout(null);
		
		JLabel lblInicio = new JLabel("INICIO");
		lblInicio.setBounds(416, 42, 70, 15);
		getContentPane().add(lblInicio);
		
		comboBoxDocentes = new JComboBox<String>();
		comboBoxDocentes.setBounds(139, 175, 231, 24);
		getContentPane().add(comboBoxDocentes);
		
		textFieldCupo = new JTextField();
		textFieldCupo.setEnabled(false);
		textFieldCupo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldCupo.setBounds(535, 131, 70, 19);
		getContentPane().add(textFieldCupo);
		textFieldCupo.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarEdicionCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(382, 246, 117, 25);
		getContentPane().add(btnCancelar);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldNombre.setBounds(139, 131, 231, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(41, 133, 70, 15);
		getContentPane().add(lblNombre);
		
		dateChooserInicia = new JDateChooser();
		Date aux1 = new Date();
		dateChooserInicia.setDate(aux1);
		dateChooserInicia.setBounds(531, 42, 160, 19);
		getContentPane().add(dateChooserInicia);
		
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarEdicionConfirmarActionPerformed(e);
			
			}
		});
		btnConfirmar.setBounds(233, 246, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JLabel lblFinaliza = new JLabel("FINALIZACIÓN");
		lblFinaliza.setBounds(415, 85, 106, 15);
		getContentPane().add(lblFinaliza);
		
		JLabel lblDocentes = new JLabel("DOCENTES");
		lblDocentes.setBounds(41, 180, 117, 15);
		getContentPane().add(lblDocentes);
		
		dateChooserFinaliza = new JDateChooser();
		Date aux2 = new Date();
		dateChooserFinaliza.setDate(aux2);
		dateChooserFinaliza.setBounds(531, 85, 160, 19);
		getContentPane().add(dateChooserFinaliza);
		
		comboBoxCursos = new JComboBox<String>();
		comboBoxCursos.setBounds(139, 80, 231, 24);
		getContentPane().add(comboBoxCursos);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(41, 85, 70, 15);
		getContentPane().add(lblCurso);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
				iniciarlizarComboBoxes();
			}
		});
		textFieldInstituto.setBounds(139, 40, 231, 19);
		getContentPane().add(textFieldInstituto);
		textFieldInstituto.setColumns(10);
		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(41, 42, 80, 15);
		getContentPane().add(lblInstituto);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarDocenteActionPerformed(e);
			}
		});
		btnAgregar.setBounds(416, 175, 97, 25);
		getContentPane().add(btnAgregar);
		
		chckbxCupo = new JCheckBox("CUPO");
		chckbxCupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBotonConfirmar();
				chckbxCupoActionPerformed(e);
			}
		});
		chckbxCupo.setBounds(416, 129, 80, 23);
		getContentPane().add(chckbxCupo);
		chckbxCupo.setSelected(false);
	}
	
	
	protected void ingresarEdicionConfirmarActionPerformed(ActionEvent e) {
		String instituto = this.textFieldInstituto.getText();
		cursoSeleccionado= comboBoxCursos.getSelectedItem().toString();
		String nombre = textFieldNombre.getText();
		Date fechaI = new Date();
		fechaI=dateChooserInicia.getDate();
		Date fechaF = new Date();
		fechaF= dateChooserFinaliza.getDate();
		String c = textFieldCupo.getText();
		int cupo=0;
		Date fechaPub = new Date();
		
		if(checkTextField(instituto) & checkTextField(nombre) &checkTextFieldInt(c)) {
			if (chckbxCupo.isSelected()) 
				cupo = Integer.parseInt(c);
			
			DtEdicionExp edicion = new DtEdicionExp(nombre, fechaI, fechaF, cupo, fechaPub, docentesSeleccionados);
			
			try {
				
				this.CursosInstituto = iConAltEd.ingresarInstituto(instituto);
				iConAltEd.seleccionarCurso(cursoSeleccionado);
				iConAltEd.ingresarDtEdicion(edicion);
				iConAltEd.confirmarAltaEdicion();
								
				JOptionPane.showMessageDialog(this, "La edición '" + nombre + "' del curso '" + cursoSeleccionado + "' se ha creado con éxito", "Ingresar Edición", JOptionPane.INFORMATION_MESSAGE);

				
			}catch (NoExisteInstitutoException neie) {
				
                JOptionPane.showMessageDialog(this, neie.getMessage(), "Ingresar Edicion", JOptionPane.ERROR_MESSAGE);

				
			}catch(EdicionRepetidaException ere) {
				
				JOptionPane.showMessageDialog(this, ere.getMessage(), "Ingresar Edicion", JOptionPane.ERROR_MESSAGE);
			
			}catch(NoExisteCursoException nece) {
				
                JOptionPane.showMessageDialog(this, nece.getMessage(), "Ingresar Edicion", JOptionPane.ERROR_MESSAGE);

				
			}
			
		}
		btnConfirmar.setEnabled(false);
		btnAgregar.setEnabled(false);
		comboBoxCursos.setEnabled(false);
		limpiarComboBox(comboBoxDocentes);
		limpiarComboBox(comboBoxCursos);
		limpiarFormulario();
		setVisible(false); 
		
	}
	
	protected void ingresarEdicionCancelarActionPerformed(ActionEvent e) {
		iConAltEd.cancelarAltaEdicion();
		limpiarComboBox(comboBoxDocentes);
		limpiarComboBox(comboBoxCursos);
		limpiarFormulario();
		btnConfirmar.setEnabled(false);
		btnAgregar.setEnabled(false);
		setVisible(false); 

	}
	
	protected void chckbxCupoActionPerformed(ActionEvent e) {
		if (chckbxCupo.isSelected())
			textFieldCupo.setEnabled(true);
		else {
			textFieldCupo.setEnabled(false);
			textFieldCupo.setText("");
		}
	}
	
	protected void agregarDocenteActionPerformed(ActionEvent e) {
		String docente=comboBoxDocentes.getSelectedItem().toString();
		docentesSeleccionados.add(docente);
		JOptionPane.showMessageDialog(this, "El docente '" + docente+ "' fue agregado con éxito a la edición.", "Ingresar Edición", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void iniciarlizarComboBoxes() {
		if (!textFieldInstituto.getText().isEmpty()) {
			if(iConAltEd.existeInstituto(textFieldInstituto.getText())){
				Instituto inst = iConAltEd.getInstituto(textFieldInstituto.getText());
				DefaultComboBoxModel<String> modelcursos = new DefaultComboBoxModel<String>(iConAltEd.getCursos(inst));		
				comboBoxCursos.setModel(modelcursos);
				comboBoxCursos.setEnabled(true);

			}
			else {
				DefaultComboBoxModel<String> modelcursos = new DefaultComboBoxModel<String>();		
				comboBoxCursos.setModel(modelcursos);
				comboBoxCursos.setEnabled(false);
			}
		}
		
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
	    if (chckbxCupo.isSelected()){
			if (string.isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Ningún campo puede quedar vacío.", "Ingresar Edición",
		                JOptionPane.ERROR_MESSAGE);
		        return false;
		    }
		    try {
		        Integer.parseInt(string);
		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(this, "Cupo deben ser un número.", "Ingresar Edición",
		                JOptionPane.ERROR_MESSAGE);
		        return false;
		    }
		    return true;
	    }
	    return true;
	}
	
	
	
	private void limpiarFormulario() {
		textFieldInstituto.setText("");
		textFieldCupo.setText("");
		textFieldNombre.setText("");
		Date fechaActual = new Date();
		dateChooserInicia.setDate(fechaActual);
		dateChooserFinaliza.setDate(fechaActual);
		
	}
	
	public void habilitarBotonConfirmar() {
		if (!textFieldInstituto.getText().isEmpty() & !textFieldNombre.getText().isEmpty()) {
			if (chckbxCupo.isSelected() & !textFieldCupo.getText().isEmpty())
				btnConfirmar.setEnabled(true);
			else if (!chckbxCupo.isSelected())
				btnConfirmar.setEnabled(true);
		}
		else {
			btnConfirmar.setEnabled(false);
		}
	}
	
	public void iniciarlizarComboBoxCurso() {
		if (!textFieldInstituto.getText().isEmpty()) {
			if(iConAltEd.existeInstituto(textFieldInstituto.getText())){
				Instituto inst = iConAltEd.getInstituto(textFieldInstituto.getText());
				DefaultComboBoxModel<String> modelcursos = new DefaultComboBoxModel<String>(iConAltEd.getCursos(inst));		
				comboBoxCursos.setModel(modelcursos);
				comboBoxCursos.setEnabled(true);

			}
			else {
				DefaultComboBoxModel<String> modelcursos = new DefaultComboBoxModel<String>();		
				comboBoxCursos.setModel(modelcursos);
				comboBoxCursos.setEnabled(false);
			}
		}
		
	}	
	
	public void iniciarlizarComboBoxDocentes() {
		DefaultComboBoxModel<String> modelcursos = new DefaultComboBoxModel<String>(iConAltEd.getDocentes());		
		comboBoxDocentes.setModel(modelcursos);
		
		if (iConAltEd.getDocentes().toString().isEmpty()) {
			comboBoxDocentes.setEnabled(false);
			btnAgregar.setEnabled(false);

		}
		else  {
			comboBoxDocentes.setEnabled(true);
			btnAgregar.setEnabled(true);
		}

	}
	
	public void limpiarComboBox(JComboBox<String> comboBox) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();		
		comboBox.setModel(model);
	}
		
	
}
