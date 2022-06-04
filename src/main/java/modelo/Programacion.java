package modelo;

public class Programacion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected String fecha;
	protected String nom_col;
	protected String nom_asig;
	protected String nom_prof;
	protected String coment;
	
	public Programacion() {
	}	

	public Programacion(String fecha, String nom_col, String nom_asig, String nom_prof, String coment) {
		super();
		this.fecha = fecha;
		this.nom_col = nom_col;
		this.nom_asig = nom_asig;
		this.nom_prof = nom_prof;
		this.coment = coment;
	}

	public Programacion(int id, String fecha, String nom_col, String nom_asig, String nom_prof, String coment) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.nom_col = nom_col;
		this.nom_asig = nom_asig;
		this.nom_prof = nom_prof;
		this.coment = coment;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNom_col() {
		return nom_col;
	}

	public void setNom_col(String nom_col) {
		this.nom_col = nom_col;
	}

	public String getNom_asig() {
		return nom_asig;
	}

	public void setNom_asig(String nom_asig) {
		this.nom_asig = nom_asig;
	}

	public String getNom_prof() {
		return nom_prof;
	}

	public void setNom_prof(String nom_prof) {
		this.nom_prof = nom_prof;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	
	
	
}
