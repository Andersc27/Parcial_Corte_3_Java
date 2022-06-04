package modelo;

public class Profesores implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected String name;
	protected String telefono;
	protected String email;
	protected String nomasig;
	protected String dias;
	
	public Profesores() {
	}

	public Profesores(String name, String telefono, String email, String nomasig, String dias) {
		super();
		this.name = name;
		this.telefono = telefono;
		this.email = email;
		this.nomasig = nomasig;
		this.dias = dias;
	}

	public Profesores(int id, String name, String telefono, String email, String nomasig, String dias) {
		super();
		this.id = id;
		this.name = name;
		this.telefono = telefono;
		this.email = email;
		this.nomasig = nomasig;
		this.dias = dias;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomasig() {
		return nomasig;
	}

	public void setNomasig(String nomasig) {
		this.nomasig = nomasig;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}
	
	
}
