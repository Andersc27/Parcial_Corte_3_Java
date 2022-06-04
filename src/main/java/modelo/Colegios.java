package modelo;

public class Colegios implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
// atributos
	protected int id;
	protected String departamento;
	protected String nombre;

//constructor vacío
	public Colegios() {
	}

	public Colegios(String departamento, String nombre) {
		this.departamento = departamento;
		this.nombre = nombre;
	}

	public Colegios(int id, String departamento, String nombre) {
		this.id = id;
		this.departamento = departamento;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}