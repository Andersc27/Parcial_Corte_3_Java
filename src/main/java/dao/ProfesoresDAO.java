package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Profesores;

public class ProfesoresDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/clases_xavia?useSSL=false";
	private String jdbcUsername = "admin";
	private String jdbcPassword = "admin";
	private static final String INSERT_PROFESOR_SQL = "INSERT INTO tab_profesores" + " (id_profesor, nom_profesor, tel_profesor, email_profesor, id_asignatura, dias) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";
	private static final String SELECT_PROFESOR_BY_ID = "SELECT a.id_profesor, a.nom_profesor, a.tel_profesor, a.email_profesor, b.nom_asignatura, a.dias FROM tab_profesores as a, tab_asignaturas as b WHERE a.id_asignatura = b.id_asignatura AND a.id_profesor =?";
	private static final String SELECT_ALL_PROFESOR = "SELECT a.id_profesor, a.nom_profesor, a.tel_profesor, a.email_profesor, b.nom_asignatura, a.dias FROM tab_profesores as a, tab_asignaturas as b WHERE a.id_asignatura = b.id_asignatura";
	private static final String DELETE_PROFESOR_SQL = "DELETE FROM tab_profesores WHERE id_profesor = ?;";
	private static final String UPDATE_PROFESOR_SQL = "UPDATE tab_profesores SET nom_profesor = ?,tel_profesor = ?,email_profesor = ?,id_asignatura = ?,dias = ? where id_profesor = ?;";

	public ProfesoresDAO() {
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

	public void insertProfesores(Profesores profesores) throws SQLException {
		System.out.println(INSERT_PROFESOR_SQL);
		// Se conecta a la base de datos
		try (Connection connection = getConnection();
				// Prepara la sentencia sql a ejecutar con el objeto conexion
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROFESOR_SQL)) {
			preparedStatement.setInt(1, profesores.getId());
			preparedStatement.setString(2, profesores.getName());
			preparedStatement.setString(3, profesores.getTelefono());
			preparedStatement.setString(4, profesores.getEmail());
			preparedStatement.setString(5, profesores.getNomasig());
			preparedStatement.setString(6, profesores.getDias());			
			//System.out.println(preparedStatement);
			// Ejecuta la consulta
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

// METODO PARA BUSCAR POR USUARIO (ID)
	public Profesores selectProfesores(int id) {
		Profesores profesores = null;// Se conecta a la base de datos
		try (Connection connection = getConnection();
				// Prepara la sentencia sql a ejecutar con el objeto conexion
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROFESOR_BY_ID);) {
			preparedStatement.setInt(1, id);
			// System.out.println(preparedStatement);
			// Ejecuta la consulta
			ResultSet rs = preparedStatement.executeQuery();
			// Recorre los resultados y los devuelve en el objeto user
			while (rs.next()) {
				String name = rs.getString("nom_profesor");
				String telefono = rs.getString("tel_profesor");
				String email = rs.getString("email_profesor");
				String nomasig = rs.getString("nom_asignatura");
				String dias = rs.getString("dias");
				profesores = new Profesores(id, name, telefono, email, nomasig, dias);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return profesores;
	}

	// METODO PARA MOSTRAR TODA LA LISTA DE USUARIOS
	public List<Profesores> selectAllProfesores() {
		// crea el array para mostrar los resultados
		List<Profesores> profesores = new ArrayList<>();
		// Conecta con la bd
		try (Connection connection = getConnection();
				// Prepara la consulta sql
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROFESOR);) {
			// System.out.println(preparedStatement);
			// Ejecuta la consulta y la almacena en un objeto ResultSet
			ResultSet rs = preparedStatement.executeQuery();
			// Recorre el resultado y lo almacena en el objeto users
			while (rs.next()) {
				int id = rs.getInt("id_profesor");
				String name = rs.getString("nom_profesor");
				String telefono = rs.getString("tel_profesor");
				String email = rs.getString("email_profesor");
				String nomasig = rs.getString("nom_asignatura");
				String dias = rs.getString("dias");
				profesores.add(new Profesores(id, name, telefono, email, nomasig, dias));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return profesores;
	}

	// METODO PARA BORRAR UN USUARIO DE LA BD
	public boolean deleteProfesores(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PROFESOR_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// METODO PARA ACTUALIZAR DATOS DE UN USUARIO GUARDADO EN BD
	public boolean updateProfesores(Profesores profesores) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PROFESOR_SQL);) {
			statement.setString(1, profesores.getName());
			statement.setString(2, profesores.getTelefono());
			statement.setString(3, profesores.getEmail());
			statement.setString(4, profesores.getNomasig());
			statement.setString(5, profesores.getDias());
			statement.setInt(6, profesores.getId());
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
