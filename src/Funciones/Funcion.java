package Funciones;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Funcion {

public static void combo(JComboBox <String>llenar)
{
	llenar.addItem("Simple");
	llenar.addItem("Triple");
	llenar.addItem("Doble");
	llenar.addItem("Suite");
}

public static boolean validate(JTextField cadena, String request) {
	
	
	if(cadena.getText().matches(request)&& Integer.parseInt(cadena.getText())<=5 && Integer.parseInt(cadena.getText())>=1)
	{
		cadena.setBackground(Color.WHITE);
		return true;
	}else
	{
		cadena.setBackground(Color.RED);
		return false;
	}
}

public static boolean validate2(JTextField cadena, String request) {
	
	
	if(cadena.getText().matches(request)&& Integer.parseInt(cadena.getText())>=1)
	{
		cadena.setBackground(Color.WHITE);
		return true;
	}else
	{
		cadena.setBackground(Color.RED);
		return false;
	}
}

public static void clear(JCheckBox ch1, JCheckBox ch2, JCheckBox ch3, JCheckBox ch4, JComboBox combo, JTextField txt)
{
	ch1.setSelected(false);
	ch2.setSelected(false);
	ch3.setSelected(false);
	ch4.setSelected(false);
	combo.setSelectedIndex(0);
	txt.setText("");
}

public static int indexcombo(String select)
{
	int selected=0;
	if(select=="Simple")
	{
		selected= 0;
	}
	if(select=="Triple")
	{
		selected= 1;
	}
	if(select=="Doble")
	{
		selected= 2;
	}
	if(select=="Suite")
	{
		selected= 3;
	}
	return selected;
}

public static String getServicios(JCheckBox Gimnasio, JCheckBox Desayuno, JCheckBox Wifi, JCheckBox Sala)
{
	String Servicios="";
	if(Gimnasio.isSelected())
	{
		Servicios = Servicios+" Gimnasio -";
	}
	if(Desayuno.isSelected())
	{
		Servicios = Servicios+" Desayuno -";
	}
	if(Wifi.isSelected())
	{
		Servicios = Servicios+" Wifi -";
	}
	if(Wifi.isSelected())
	{
		Servicios = Servicios+" Sala de Juegos -";
	}
	if(Servicios=="")
	{
		Servicios = " Ninguno -";
	}
	
	return Servicios;
	
}
	
}
