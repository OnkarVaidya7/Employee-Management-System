package jsp_employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/login")
public class LogInController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		CRUD crud = new CRUD();
		try {
			String dbPassword = crud.logInUser(email);
			if (dbPassword != null) {
				if (password.equals(dbPassword)) {
					//1.
//					req.setAttribute("Emp's", crud.getAllEmployee());
					//OR
					//2.
					
					//Creating cookies
					Cookie cookie = new Cookie("session", email);
					resp.addCookie(cookie);
					
					//To create HTTPSession
					HttpSession session = req.getSession();
					System.out.println(session);
					session.setAttribute("hs", "951456");
										
					List<Employee> list =crud.getAllEmployee();
					req.setAttribute("Emp's", list);
					
					req.getRequestDispatcher("success.jsp").forward(req, resp);
				} else {
					req.setAttribute("message", "Invalid Password");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			} else {
				req.setAttribute("message", "User not registred, please SignUp!");
				req.getRequestDispatcher("signup.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
