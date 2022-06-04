package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Programacion;

public class ProgramacionDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/clases_xavia?useSSL=false";
	private String jdbcUsername = "admin";
	private String jdbcPassword = "admin";
	private static final String INSERT_PROGRAMACION_SQL = "INSERT INTO tab_programacion" + " (fecha, id_colegio, id_asignatura, id_profesor, comentarios) VALUES "
			+ " (?, ?, ?, ?, ?);";
	private static final String SELECT_PROGRAMACION_BY_ID = "SELECT a.id_programacion, a.fecha, b.nom_colegio, c.nom_asignatura, d.nom_profesor, a.comentarios FROM tab_programacion as a, tab_colegios as b, tab_asignaturas as c, tab_profesores as d WHERE a.id_colegio = b.id_colegio AND a.id_asignatura = c.id_asignatura AND a.id_profesor = d.id_profesor AND a.id_programacion=?";
	private static final String SELECT_ALL_PROGRAMACION = "SELECT a.id_programacion, a.fecha, b.nom_colegio, c.nom_asignatura, d.nom_profesor, a.comentarios FROM tab_programacion as a, tab_colegios as b, tab_asignaturas as c, tab_profesores as d WHERE a.id_colegio = b.id_colegio AND a.id_asignatura = c.id_asignatura AND a.id_profesor = d.id_profesor";
	private static final String DELETE_PROGRAMACION_SQL = "DELETE FROM tab_programacion WHERE id_programacion = ?;";
	private static final String UPDATE_PROGRAMACION_SQL = "UPDATE tab_programacion SET fecha = ?,id_colegio = ?,id_asignatura = ?,id_profesor = ?, comentarios = ? where id_programacion = ?;";

	public ProgramacionDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			//registra el driver de conexión para la base de datos
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insertProgramacion(Programacion programacion) throws SQLException {
		System.out.println(INSERT_PROGRAMACION_SQL);
		// Se conecta a la base de datos
		try (Connection connection = getConnection();
				// Prepara la sentencia sql a ejecutar con el objeto conexion
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROGRAMACION_SQL)) {
			//preparedStatement.setInt(1, programacion.getId());
			preparedStatement.setString(1, programacion.getFecha());
			preparedStatement.setString(2, programacion.getNom_col());
			preparedStatement.setString(3, programacion.getNom_asig());
			preparedStatement.setString(4, programacion.getNom_prof());	
			preparedStatement.setString(5, programacion.getComent());
			//System.out.println(preparedStatement);
			// Ejecuta la consulta
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

// METODO PARA BUSCAR POR USUARIO (ID)
	public Programacion selectProgramacion(int id) {
		Programacion programacion = null;// Se conecta a la base de datos
		try (Connection connection = getConnection();
				// Prepara la sentencia sql a ejecutar con el objeto conexion
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROGRAMACION_BY_ID);) {
			preparedStatement.setInt(1, id);
			// System.out.println(preparedStatement);
			// Ejecuta la consulta
			ResultSet rs = preparedStatement.executeQuery();
			// Recorre los resultados y los devuelve en el objeto user
			while (rs.next()) {
				String fecha = rs.getString("fecha");
				String nom_col = rs.getString("nom_colegio");
				String nom_asig = rs.getString("nom_asignatura");
				String nom_prof = rs.getString("nom_profesor");
				String coment = rs.getString("comentarios");
				programacion = new Programacion(id, fecha, nom_col, nom_asig, nom_prof, coment);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return programacion;
	}

	// METODO PARA MOSTRAR TODA LA LISTA DE USUARIOS
	public List<Programacion> selectAllProgramacion() {
		// crea el array para mostrar los resultados
		List<Programacion> programacion = new ArrayList<>();
		// Conecta con la bd
		try (Connection connection = getConnection();
				// Prepara la consulta sql
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROGRAMACION);) {
			// System.out.println(preparedStatement);
			// Ejecuta la consulta y la almacena en un objeto ResultSet
			ResultSet rs = preparedStatement.executeQuery();
			// Recorre el resultado y lo almacena en el objeto users
			while (rs.next()) {
				int id = rs.getInt("id_programacion");
				String fecha = rs.getString("fecha");
				String nom_col = rs.getString("nom_colegio");
				String nom_asig = rs.getString("nom_asignatura");
				String nom_prof = rs.getString("nom_profesor");
				String coment = rs.getString("comentarios");
				programacion.add(new Programacion(id, fecha, nom_col, nom_asig, nom_prof, coment));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return programacion;
	}

	// METODO PARA BORRAR UN USUARIO DE LA BD
	public boolean deleteProgramacion(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PROGRAMACION_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// METODO PARA ACTUALIZAR DATOS DE UN USUARIO GUARDADO EN BD
	public boolean updateProgramacion(Programacion programacion) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PROGRAMACION_SQL);) {
			statement.setString(1, programacion.getFecha());
			statement.setString(2, programacion.getNom_col());
			statement.setString(3, programacion.getNom_asig());
			statement.setString(4, programacion.getNom_prof());
			statement.setString(5, programacion.getComent());
			statement.setInt(6, programacion.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
