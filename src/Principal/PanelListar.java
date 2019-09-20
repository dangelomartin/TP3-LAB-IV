package Principal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import Funciones.Funcion;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelListar extends JPanel {
	private JTextField txtId;
	private JTextField txtCant;
	private JComboBox<String> comboBox;
	private DefaultListModel<Habitacion> listModel;
	private JList<Habitacion> list;
	private JList<Habitacion> list2;
	/**
	 * Create the panel.
	 */
	public PanelListar() {
		setLayout(null);
		
		JLabel lblListadoDeHabitaciones = new JLabel("Listado de Habitaciones Reservadas");
		lblListadoDeHabitaciones.setBounds(22, 25, 260, 14);
		add(lblListadoDeHabitaciones);
		
		list = new JList<Habitacion>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Habitacion x = new Habitacion();
				int indexList=list.getSelectedIndex();
				x=listModel.getElementAt(indexList);
				txtId.setText(Integer.toString(x.getId()));
				txtCant.setText(Integer.toString(x.getCant()));
				comboBox.setSelectedIndex(Funcion.indexcombo(x.getTipo()));
			}
		});
		list.setBounds(34, 67, 626, 286);
		add(list);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(44, 364, 48, 14);
		add(lblId);
		
		JLabel lblCantDePer = new JLabel("CANT. DE PER");
		lblCantDePer.setBounds(123, 364, 92, 14);
		add(lblCantDePer);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(227, 391, 118, 22);
		add(comboBox);
		Funcion.combo(comboBox);
		
		JLabel lblTipoDeHabitacion = new JLabel("TIPO DE HABITACION");
		lblTipoDeHabitacion.setBounds(225, 364, 120, 14);
		add(lblTipoDeHabitacion);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Funcion.validate(txtCant, "[1-5]+"))
				{
					if(Funcion.validate2(txtId, "[0-9]+"))
					{
						int index=list.getSelectedIndex();
						Habitacion y = new Habitacion();
						y=list.getSelectedValue();
						y.setCant(Integer.parseInt(txtCant.getText()));
						y.setId(Integer.parseInt(txtId.getText()));
						y.setTipo(comboBox.getSelectedItem().toString());
						listModel.set(index, y);
					}
				}
			}
		});
		btnModificar.setBounds(372, 391, 133, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()!=-1)
				{
					listModel.removeElementAt(list.getSelectedIndex());
					
				}
			}
		});
		btnEliminar.setBounds(515, 391, 145, 23);
		add(btnEliminar);
		
		txtId = new JTextField();
		txtId.setBounds(34, 392, 48, 20);
		add(txtId);
		txtId.setColumns(10);
		
		txtCant = new JTextField();
		txtCant.setBounds(105, 392, 96, 20);
		add(txtCant);
		txtCant.setColumns(10);


	}
	
	public void setDefaultListModel(DefaultListModel<Habitacion> listModelRecibido)
	{
		this.listModel = listModelRecibido;
		list.setModel(this.listModel);
	}
}
