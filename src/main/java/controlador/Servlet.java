package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AsignaturasDAO;
import modelo.Asignaturas;
import dao.ColegiosDAO;
import modelo.Colegios;
import dao.ProfesoresDAO;
import modelo.Profesores;
import dao.ProgramacionDAO;
import modelo.Programacion;


@WebServlet("/")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AsignaturasDAO asignaturasDAO;
	private ColegiosDAO colegiosDAO;
	private ProfesoresDAO profesoresDAO;
	private ProgramacionDAO programacionDAO;

	public void init() {
		asignaturasDAO = new AsignaturasDAO();
		colegiosDAO = new ColegiosDAO();
		profesoresDAO = new ProfesoresDAO();
		programacionDAO = new ProgramacionDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/newa":
				showNewFormA(request, response);
				break;
			case "/newc":
				showNewFormC(request, response);
				break;
			case "/newp":
				showNewFormP(request, response);
				break;
			case "/new":
				showNewFormProg(request, response);
				break;
			case "/inserta":
				insertAsignaturas(request, response);
				break;
			case "/insertc":
				insertColegios(request, response);
				break;
			case "/insertp":
				insertProfesores(request, response);
				break;
			case "/insert":
				insertProgramacion(request, response);
				break;
			case "/deletea":
				deleteAsignaturas(request, response);
				break;
			case "/deletec":
				deleteColegios(request, response);
				break;
			case "/deletep":
				deleteProfesores(request, response);
				break;
			case "/delete":
				deleteProgramacion(request, response);
				break;
			case "/edita":
				showEditFormA(request, response);
				break;
			case "/editc":
				showEditFormC(request, response);
				break;
			case "/editp":
				showEditFormP(request, response);
				break;
			case "/edit":
				showEditFormProg(request, response);
				break;
			case "/updatea":
				updateAsignaturas(request, response);
				break;
			case "/updatec":
				updateColegios(request, response);
				break;
			case "/updatep":
				updateProfesores(request, response);
				break;
			case "/update":
				updateProgramacion(request, response);
				break;
			case "/alla":
				listAsignaturas(request, response);
				break;
			case "/allc":
				listColegios(request, response);
				break;
			case "/allp":
				listProfesores(request, response);
				break;
			case "/all":
				listProgramacion(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listAsignaturas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Asignaturas> listAsignaturas = asignaturasDAO.selectAllAsignatura();
		request.setAttribute("listAsignaturas", listAsignaturas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("asignaturas-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormA(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("asignaturas-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormA(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Asignaturas existingAsignaturas = asignaturasDAO.selectAsignaturas(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("asignaturas-form.jsp");
		request.setAttribute("asignaturas", existingAsignaturas);
		dispatcher.forward(request, response);
	}

	private void insertAsignaturas(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		Asignaturas newAsignaturas = new Asignaturas(name);
		asignaturasDAO.insertAsignaturas(newAsignaturas);
		response.sendRedirect("alla");
	}

	private void updateAsignaturas(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Asignaturas book = new Asignaturas(id, name);
		asignaturasDAO.updateAsignaturas(book);
		response.sendRedirect("alla");
	}

	private void deleteAsignaturas(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		asignaturasDAO.deleteAsignaturas(id);
		response.sendRedirect("alla");
	}
	
	private void listColegios(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Colegios> listColegios = colegiosDAO.selectAllColegios();
		request.setAttribute("listColegios", listColegios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("colegios-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormC(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("colegios-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormC(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_colegio"));
		Colegios existingColegios = colegiosDAO.selectColegios(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("colegios-form.jsp");
		request.setAttribute("colegios", existingColegios);
		dispatcher.forward(request, response);
	}
	
	private void insertColegios(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		request.setCharacterEncoding("UTF-8");
		String departamento = request.getParameter("departamento");
		String nombre = request.getParameter("nombre");
		Colegios newColegios = new Colegios(departamento, nombre);
		colegiosDAO.insertColegios(newColegios);
		response.sendRedirect("allc");
	}

	private void updateColegios(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String departamento = request.getParameter("departamento");
		String nombre = request.getParameter("nombre");
		Colegios book = new Colegios(id, departamento, nombre);
		colegiosDAO.updateColegios(book);
		response.sendRedirect("allc");
	}

	private void deleteColegios(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id_colegio"));
		colegiosDAO.deleteColegios(id);
		response.sendRedirect("allc");
	}

	private void listProfesores(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Asignaturas> listAsignaturas = asignaturasDAO.selectAllAsignatura();
		request.setAttribute("listAsignaturas", listAsignaturas);
		List<Profesores> listProfesores = profesoresDAO.selectAllProfesores();
		request.setAttribute("listProfesores", listProfesores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profesores-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Asignaturas> listAsignaturas = asignaturasDAO.selectAllAsignatura();
		request.setAttribute("listAsignaturas", listAsignaturas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profesores-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormP(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Asignaturas> listAsignaturas = asignaturasDAO.selectAllAsignatura();
		request.setAttribute("listAsignaturas", listAsignaturas);
		int id = Integer.parseInt(request.getParameter("id"));
		Profesores existingProfesores = profesoresDAO.selectProfesores(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profesores-form.jsp");
		request.setAttribute("profesores", existingProfesores);
		dispatcher.forward(request, response);
	}

	private void insertProfesores(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		List<Asignaturas> listAsignaturas = asignaturasDAO.selectAllAsignatura();
		request.setAttribute("listAsignaturas", listAsignaturas);
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String idasi = request.getParameter("idasig");
		//int idasi = Integer.parseInt(ida);
		//int idasi = Integer.parseInt(request.getParameter("idasig"));
		String dias = request.getParameter("dias");
		Profesores newProfesores = new Profesores(id, name, telefono, email, idasi, dias);
		profesoresDAO.insertProfesores(newProfesores);
		response.sendRedirect("allp");
	}

	private void updateProfesores(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		List<Asignaturas> listAsignaturas = asignaturasDAO.selectAllAsignatura();
		request.setAttribute("listAsignaturas", listAsignaturas);
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String idasi = request.getParameter("idasig");
		//int idasi = Integer.parseInt(ida);
		//int idasi = Integer.parseInt(request.getParameter("idasig"));
		String dias = request.getParameter("dias");
		Profesores book = new Profesores(id, name, telefono, email, idasi, dias);
		profesoresDAO.updateProfesores(book);
		response.sendRedirect("allp");
	}

	private void deleteProfesores(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		profesoresDAO.deleteProfesores(id);
		response.sendRedirect("allp");
	}
	
	private void listProgramacion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Programacion> listProgramacion = programacionDAO.selectAllProgramacion();
		request.setAttribute("listProgramacion", listProgramacion);
		RequestDispatcher dispatcher = request.getRequestDispatcher("programacion-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormProg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Asignaturas> listAsignaturas = asignaturasDAO.selectAllAsignatura();
		request.setAttribute("listAsignaturas", listAsignaturas);
		List<Colegios> listColegios = colegiosDAO.selectAllColegios();
		request.setAttribute("listColegios", listColegios);
		List<Profesores> listProfesores = profesoresDAO.selectAllProfesores();
		request.setAttribute("listProfesores", listProfesores);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("programacion-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormProg(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Asignaturas> listAsignaturas = asignaturasDAO.selectAllAsignatura();
		request.setAttribute("listAsignaturas", listAsignaturas);
		List<Colegios> listColegios = colegiosDAO.selectAllColegios();
		request.setAttribute("listColegios", listColegios);
		List<Profesores> listProfesores = profesoresDAO.selectAllProfesores();
		request.setAttribute("listProfesores", listProfesores);
		
		int id = Integer.parseInt(request.getParameter("id"));
		Programacion existingProgramacion = programacionDAO.selectProgramacion(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("programacion-form.jsp");
		request.setAttribute("programacion", existingProgramacion);
		dispatcher.forward(request, response);
	}

	private void insertProgramacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Asignaturas> listAsignaturas = asignaturasDAO.selectAllAsignatura();
		request.setAttribute("listAsignaturas", listAsignaturas);
		List<Colegios> listColegios = colegiosDAO.selectAllColegios();
		request.setAttribute("listColegios", listColegios);
		List<Profesores> listProfesores = profesoresDAO.selectAllProfesores();
		request.setAttribute("listProfesores", listProfesores);

		String fecha = request.getParameter("fecha");
		String nomc = request.getParameter("id_col");
		//int id_col = Integer.parseInt(idc);
		//int id_col = Integer.parseInt(request.getParameter("id_col"));
		String id_asig = request.getParameter("id_asig");
		//int id_asig = Integer.parseInt(ida);
		//int id_asig = Integer.parseInt(request.getParameter("id_asig"));
		String id_prof = request.getParameter("id_prof");
		//int id_prof = Integer.parseInt(idp);
		//int id_prof = Integer.parseInt(request.getParameter("id_prof"));
		String coment = request.getParameter("coment");
		Programacion newProgramacion = new Programacion(fecha, nomc ,id_asig, id_prof, coment);
		programacionDAO.insertProgramacion(newProgramacion);
		response.sendRedirect("all");
	}

	private void updateProgramacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		List<Asignaturas> listAsignaturas = asignaturasDAO.selectAllAsignatura();
		request.setAttribute("listAsignaturas", listAsignaturas);
		List<Colegios> listColegios = colegiosDAO.selectAllColegios();
		request.setAttribute("listColegios", listColegios);
		List<Profesores> listProfesores = profesoresDAO.selectAllProfesores();
		request.setAttribute("listProfesores", listProfesores);

		int id = Integer.parseInt(request.getParameter("id"));
		String fecha = request.getParameter("fecha");
		String nomc = request.getParameter("id_col");
		//int id_col = Integer.parseInt(idc);
		//int id_col = Integer.parseInt(request.getParameter("id_col"));
		String id_asig = request.getParameter("id_asig");
		//int id_asig = Integer.parseInt(ida);
		//int id_asig = Integer.parseInt(request.getParameter("id_asig"));
		String id_prof = request.getParameter("id_prof");
		//int id_prof = Integer.parseInt(idp);
		//int id_prof = Integer.parseInt(request.getParameter("id_prof"));
		String coment = request.getParameter("coment");
		Programacion book = new Programacion(id, fecha, nomc ,id_asig, id_prof, coment);
		programacionDAO.updateProgramacion(book);
		response.sendRedirect("all");
	}

	private void deleteProgramacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		programacionDAO.deleteProgramacion(id);
		response.sendRedirect("all");
	}
}