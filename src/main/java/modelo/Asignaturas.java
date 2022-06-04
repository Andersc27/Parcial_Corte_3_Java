package modelo;

public class Asignaturas implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	// atributos
	protected int id;
	protected String name;
	
	//constructor vacío
	public Asignaturas() {
	}

	public Asignaturas(String name) {
		this.name = name;
	}

	public Asignaturas(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}