package Principal;

public class Habitacion {

	public static int cont=0;

	public static int proxId()
	{
	return cont+1;
	}
	
	private int id;
	private int cant;
	private String Tipo;
	private String Servicio;
	public int getId() {
		return id;
	}
	
	
	public Habitacion()
	{
		cont++;
		id=cont;
		cant=0;
		Tipo = "";
		Servicio="";
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getServicio() {
		return Servicio;
	}
	public void setServicio(String servicio) {
		Servicio = servicio;
	}
	@Override
	public String toString() {
		return "ID " + id + " | Cant de Pers :" + cant  +" | Tipo de Habit: " + Tipo + " | Servicios Adicionales: -" + Servicio ;
	}
	public Habitacion(int id, int cant, String tipo, String servicio) {
		super();
		this.id = id;
		this.cant = cant;
		Tipo = tipo;
		Servicio = servicio;
	}

	
}
