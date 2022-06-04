package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Colegios;

public class ColegiosDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/clases_xavia?useSSL=false";
	private String jdbcUsername = "admin";
	private String jdbcPassword = "admin";
	private static final String INSERT_COLEGIOS_SQL = "INSERT INTO tab_colegios" + " (departamento, nom_colegio) VALUES "
			+ " (?, ?);";
	private static final String SELECT_COLEGIOS_BY_ID = "select id_colegio,departamento,nom_colegio from tab_colegios where id_colegio =?";
	private static final String SELECT_ALL_COLEGIOS = "select * from tab_colegios";
	private static final String DELETE_COLEGIOS_SQL = "delete from tab_colegios where id_colegio = ?;";
	private static final String UPDATE_COLEGIOS_SQL = "update tab_colegios set departamento = ?,nom_colegio= ? where id_colegio = ?;";

	public ColegiosDAO() {
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

	public void insertColegios(Colegios colegios) throws SQLException {
		System.out.println(INSERT_COLEGIOS_SQL);
// Se conecta a la base de datos
		try (Connection connection = getConnection();
// Prepara la sentencia sql a ejecutar con el objeto conexion
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COLEGIOS_SQL)) {
			preparedStatement.setString(1, colegios.getDepartamento());
			preparedStatement.setString(2, colegios.getNombre());
//System.out.println(preparedStatement);
// Ejecuta la consulta
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

// METODO PARA BUSCAR POR USUARIO (ID)
	public Colegios selectColegios(int id) {
		Colegios colegios = null;
//Se conecta a la base de datos
		try (Connection connection = getConnection();
//Prepara la sentencia sql a ejecutar con el objeto conexion
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COLEGIOS_BY_ID);) {
			preparedStatement.setInt(1, id);
//System.out.println(preparedStatement);
//Ejecuta la consulta
			ResultSet rs = preparedStatement.executeQuery();
//Recorre los resultados y los devuelve en el objeto colegios
			while (rs.next()) {
				String departamento = rs.getString("departamento");
				String nombre = rs.getString("nom_colegio");
				colegios = new Colegios(id, departamento, nombre);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return colegios;
	}

//METODO PARA MOSTRAR TODA LA LISTA DE USUARIOS
	public List<Colegios> selectAllColegios() {
//crea el array para mostrar los resultados
		List<Colegios> colegios = new ArrayList<>();
//Conecta con la bd
		try (Connection connection = getConnection();
//Prepara la consulta sql
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COLEGIOS);) {
//System.out.println(preparedStatement);
//Ejecuta la consulta y la almacena en un objeto ResultSet
			ResultSet rs = preparedStatement.executeQuery();
//Recorre el resultado y lo almacena en el objeto colegios
			while (rs.next()) {
				int id = rs.getInt("id_colegio");
				String departamento = rs.getString("departamento");
				String nombre = rs.getString("nom_colegio");
				colegios.add(new Colegios(id, departamento, nombre));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return colegios;
	}

//METODO PARA BORRAR UN USUARIO DE LA BD
	public boolean deleteColegios(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_COLEGIOS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// METODO PARA ACTUALIZAR DATOS DE UN USUARIO GUARDADO EN BD
	public boolean updateColegios(Colegios colegios) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_COLEGIOS_SQL);) {
			statement.setString(1, colegios.getDepartamento());
			statement.setString(2, colegios.getNombre());
			statement.setInt(3, colegios.getId());
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