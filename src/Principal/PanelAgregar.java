package Principal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Funciones.Funcion;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgregar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCantidad;
	private JComboBox<String> comboBox;
	private DefaultListModel<Habitacion> listModel;

	/**
	 * Create the panel.
	 */
	public PanelAgregar() {
		setLayout(null);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(27, 32, 48, 14);
		add(lblCantidad);
		
		JLabel lblTipoDeHabitacion = new JLabel("Tipo de Habitacion");
		lblTipoDeHabitacion.setBounds(27, 57, 116, 14);
		add(lblTipoDeHabitacion);
		
		JLabel lblServiciosAdicionales = new JLabel("Servicios Adicionales");
		lblServiciosAdicionales.setBounds(27, 82, 131, 14);
		add(lblServiciosAdicionales);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(173, 29, 169, 20);
		add(txtCantidad);
		txtCantidad.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(173, 53, 169, 22);
		add(comboBox);
		Funcion.combo(comboBox);
		
		JCheckBox chckbxWifi = new JCheckBox("WIFI");
		chckbxWifi.setBounds(171, 78, 97, 23);
		add(chckbxWifi);
		
		JCheckBox chckbxDesayuno = new JCheckBox("Desayuno");
		chckbxDesayuno.setBounds(279, 78, 97, 23);
		add(chckbxDesayuno);
		
		JCheckBox chckbxGimnasio = new JCheckBox("Gimnasio");
		chckbxGimnasio.setBounds(171, 104, 97, 23);
		add(chckbxGimnasio);
		
		JCheckBox chckbxSalaDeJuegos = new JCheckBox("Sala de Juegos");
		chckbxSalaDeJuegos.setBounds(279, 104, 138, 23);
		add(chckbxSalaDeJuegos);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Funcion.validate(txtCantidad, "[1-5]+"))
				{
					Habitacion hab = new Habitacion();
					hab.setCant(Integer.parseInt(txtCantidad.getText()));
					//hab.setId(Funcion.nextID(listModel));
					//hab.setId(proxId());
					
					hab.setServicio(Funcion.getServicios(chckbxGimnasio, chckbxDesayuno, chckbxWifi, chckbxSalaDeJuegos));
					hab.setTipo(comboBox.getSelectedItem().toString());
					listModel.addElement(hab);
					Funcion.clear(chckbxWifi, chckbxDesayuno, chckbxGimnasio, chckbxSalaDeJuegos, comboBox, txtCantidad);
				}
			}
		});
		btnAceptar.setBounds(207, 146, 89, 23);
		add(btnAceptar);

	}

	public void setDefaultListModel(DefaultListModel<Habitacion> listModelRecibido)
	{
		this.listModel = listModelRecibido;
	}
	
}
