package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.assembler.UserAssembler;
import es.salesianos.model.User;
import es.salesianos.repository.UserRepository;

public class WelcomeServlet extends HttpServlet {

	UserAssembler assembler = new UserAssembler();
	UserRepository userRepository = new UserRepository();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPostAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Nothig to do here
	}

	private void doPostAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		User user = assembler.createUserFromRequest(req);
		if (!userRepository.findUser(user)) {
			userRepository.insert(user);
			redirect(req, resp);
		} else {
			errorRedirect(req, resp);
		}

	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome.jsp");
		dispatcher.forward(req, resp);
	}

	protected void errorRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
		dispatcher.forward(req, resp);
	}
}
