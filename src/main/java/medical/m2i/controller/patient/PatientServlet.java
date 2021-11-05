package medical.m2i.controller.patient;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.dao.PatientDao;
import medical.m2i.model.Patient;

/**
 * Servlet implementation class Test
 */
@WebServlet("/registerPatient")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PatientDao patientDao;

	public void init() {
		patientDao = new PatientDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/patient/patientregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Je suis bien dans la méthode post");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String naissance = request.getParameter("naissance");
		String adresse = request.getParameter("adresse");
		String pays = request.getParameter("pays");
		String ville = request.getParameter("ville");

		Patient patient = new Patient();
		patient.setNom(nom);
		patient.setPrenom(prenom);
		patient.setNaissance(naissance);
		patient.setAdresse(adresse);
		patient.setPays(pays);
		patient.setVille(ville);

		try {
			patientDao.registerPatient(patient);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/ListPatientServlet");
	}

}
