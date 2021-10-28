package medical.m2i.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import medical.m2i.model.Patient;

public class PatientDao {

	private Properties db = new Properties();

	public int registerPatient(Patient patient) throws ClassNotFoundException {

		try {
			db.load(getClass().getResourceAsStream("connectiondb.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String url = db.getProperty("url");
		String user = db.getProperty("user");
		String password = db.getProperty("password");

		String INSERT_PATIENTS_SQL = "INSERT INTO patient" + "  (nom, prenom, naissance, adresse, pays, ville) VALUES "
				+ " (?, ?, ?, ?,?,?);";

		int result = 0;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(url, user, password);
				// Creation du statement utilise pour la connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENTS_SQL)) {
			preparedStatement.setString(1, patient.getNom());
			preparedStatement.setString(2, patient.getPrenom());
			preparedStatement.setString(3, patient.getNaissance().toString());
			preparedStatement.setString(4, patient.getAdresse());
			preparedStatement.setString(5, patient.getPays());
			preparedStatement.setString(6, patient.getVille());

			System.out.println(preparedStatement);
			// Execution de la query ou update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return result;
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
