package jsp_employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class SignUpController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);

		CRUD crud = new CRUD();
		try {
			int result = crud.signUpEmployee(employee);
			if (result != 0) {
				req.setAttribute("message", "SignUp Successful, Please Login"); 		//for displaying the message while the user moves to the next page. Input on key:value pair.
				RequestDispatcher reqDispatcher = req.getRequestDispatcher("login.jsp");
				reqDispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
