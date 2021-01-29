package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.User;
import es.salesianos.repository.UserRepository;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userRepository = new UserRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Nothing to do here
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGetAction(req, resp);
	}

	private void doGetAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> userList = userRepository.getAllUsers();
		req.setAttribute("userList", userList);
		redirect(req, resp);

	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userList.jsp");
		dispatcher.forward(req, resp);
	}

}
