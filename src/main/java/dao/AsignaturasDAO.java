package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Asignaturas;

public class AsignaturasDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/clases_xavia?useSSL=false";
	private String jdbcUsername = "admin";
	private String jdbcPassword = "admin";
	private static final String INSERT_ASIGNATURA_SQL = "INSERT INTO tab_asignaturas" + " (nom_asignatura) VALUES "
			+ " (?);";
	private static final String SELECT_ASIGNATURA_BY_ID = "SELECT id_asignatura, nom_asignatura from tab_asignaturas WHERE id_asignatura =?";
	private static final String SELECT_ALL_ASIGNATURA = "SELECT * FROM tab_asignaturas";
	private static final String DELETE_ASIGNATURA_SQL = "DELETE FROM tab_asignaturas WHERE id_asignatura = ?;";
	private static final String UPDATE_ASIGNATURA_SQL = "UPDATE tab_asignaturas SET nom_asignatura = ? where id_asignatura = ?;";

	public AsignaturasDAO() {
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

	public void insertAsignaturas(Asignaturas asignaturas) throws SQLException {
		System.out.println(INSERT_ASIGNATURA_SQL);
		// Se conecta a la base de datos
		try (Connection connection = getConnection();
				// Prepara la sentencia sql a ejecutar con el objeto conexion
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ASIGNATURA_SQL)) {
			preparedStatement.setString(1, asignaturas.getName());
			//System.out.println(preparedStatement);
			// Ejecuta la consulta
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

// METODO PARA BUSCAR POR USUARIO (ID)
	public Asignaturas selectAsignaturas(int id) {
		Asignaturas asignaturas = null;// Se conecta a la base de datos
		try (Connection connection = getConnection();
				// Prepara la sentencia sql a ejecutar con el objeto conexion
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ASIGNATURA_BY_ID);) {
			preparedStatement.setInt(1, id);
			// System.out.println(preparedStatement);
			// Ejecuta la consulta
			ResultSet rs = preparedStatement.executeQuery();
			// Recorre los resultados y los devuelve en el objeto user
			while (rs.next()) {
				String name = rs.getString("nom_asignatura");
				asignaturas = new Asignaturas(id, name);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return asignaturas;
	}

	// METODO PARA MOSTRAR TODA LA LISTA DE USUARIOS
	public List<Asignaturas> selectAllAsignatura() {
		// crea el array para mostrar los resultados
		List<Asignaturas> asignaturas = new ArrayList<>();
		// Conecta con la bd
		try (Connection connection = getConnection();
				// Prepara la consulta sql
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ASIGNATURA);) {
			// System.out.println(preparedStatement);
			// Ejecuta la consulta y la almacena en un objeto ResultSet
			ResultSet rs = preparedStatement.executeQuery();
			// Recorre el resultado y lo almacena en el objeto users
			while (rs.next()) {
				int id = rs.getInt("id_asignatura");
				String name = rs.getString("nom_asignatura");
				asignaturas.add(new Asignaturas(id, name));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return asignaturas;
	}

	// METODO PARA BORRAR UN USUARIO DE LA BD
	public boolean deleteAsignaturas(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ASIGNATURA_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// METODO PARA ACTUALIZAR DATOS DE UN USUARIO GUARDADO EN BD
	public boolean updateAsignaturas(Asignaturas asignaturas) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ASIGNATURA_SQL);) {
			statement.setString(1, asignaturas.getName());
			statement.setInt(2, asignaturas.getId());
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
