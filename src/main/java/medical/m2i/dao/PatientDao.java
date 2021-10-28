package medical.m2i.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

	public List<Patient> getPatients() throws ClassNotFoundException {
		try {
			db.load(getClass().getResourceAsStream("connectiondb.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String url = db.getProperty("url");
		String user = db.getProperty("user");
		String password = db.getProperty("password");

		String GET_ALL_PATIENT = "SELECT * from patient";

		List<Patient> listPatient = new ArrayList<Patient>();

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(url, user, password);
				// Creation du statement utilise pour la connection object
				Statement statement = connection.createStatement()) {

			ResultSet resultSet = statement.executeQuery(GET_ALL_PATIENT);

			while (resultSet.next()) {
				Patient patient = new Patient(resultSet.getString("nom"), resultSet.getString("prenom"),
						resultSet.getString("naissance"), resultSet.getString("adresse"), resultSet.getString("pays"),
						resultSet.getString("ville"));
				listPatient.add(patient);
				System.out.println(resultSet.getString("nom") + "\t" + resultSet.getString("prenom"));
			}

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}

		return listPatient;
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
