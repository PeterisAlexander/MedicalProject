package medical.m2i.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.dao.PatientDao;
import medical.m2i.model.Patient;

/**
 * Servlet implementation class ListPatientServlet
 */
@WebServlet("/ListPatientServlet")
public class ListPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PatientDao patientDao;

	public void init() {
		patientDao = new PatientDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListPatientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType(" text / html ");
		PrintWriter out = response.getWriter();
		out.println("<html >");
		out.println("<body >");
		out.println("<header><h1>Liste des patients</h1> </header>");
		out.println("<main>");
		out.println(" <button type=\"button\" id=\"add-btn\">Nouveau patient</button>");
		out.println(" <div class=\"clear\"></div>");
		out.println("  <table width=\"100%\" cellpadding=\"5\" cellspacing=\"0\">");
		out.println("<thead>\r\n" + "                <tr>\r\n" + "                    <th>Nom</th>\r\n"
				+ "                    <th>Prénom</th>\r\n" + "                    <th>Naissance</th>\r\n"
				+ "                    <th>Adresse</th>\r\n" + "                    <th>Pays</th>\r\n"
				+ "                    <th>Ville</th>\r\n"
				+ "                    <th><i class=\"fa fa-cogs\" aria-hidden=\"true\"></i></th>\r\n"
				+ "                </tr>\r\n" + "            </thead>");
		out.println("<tbody>");

		try {
			for (Patient p : patientDao.getPatients()) {
				out.println("<tr>\r\n" + "                    <td>" + p.getNom() + "</td>\r\n"
						+ "                    <td>" + p.getPrenom() + "</td>\r\n" + "                    <td>"
						+ p.getNaissance() + "</td>\r\n" + "                    <td>" + p.getAdresse() + "</td>\r\n"
						+ "                    <td>" + p.getPays() + "</td>\r\n" + "                    <td>"
						+ p.getVille() + "</td>\r\n" + "                    <td>\r\n"
						+ "                        <button type=\"button\" class=\"btn-action\"><i class=\"fa fa-pencil-square-o\"\r\n"
						+ "                                aria-hidden=\"true\"></i></button>\r\n"
						+ "                        <button type=\"button\" class=\"btn-action\"><i class=\"fa fa-trash\" aria-hidden=\"true\"></i></button>\r\n"
						+ "                    </td>\r\n" + "                </tr>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println("  </tbody>\r\n" + "        </table>\r\n" + "    </main>\r\n" + "</body>\r\n" + "\r\n" + "</html>");
	}

}
