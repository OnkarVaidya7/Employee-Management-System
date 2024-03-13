package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class CRUD {

String className = "com.mysql.cj.jdbc.Driver";
	
	public Connection getConnection() throws Exception {
		Class.forName(className);
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "root");	
	}
	
	public int signUpEmployee(Employee employee) throws Exception {
		
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values (?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setString(6, employee.getPassword());
		int res = preparedStatement.executeUpdate();
		connection.close();
		return res;
	}
	
	public String logInUser(String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select password from employee where email = ?");  // and password = ?
		preparedStatement.setString(1, email);
		ResultSet set = preparedStatement.executeQuery();
		String password = null;
		if (set.next()) {
			password = set.getString("password");
		}
		connection.close();
		return password;
	}
	
	public List<Employee> getAllEmployee() throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");
		ResultSet set = preparedStatement.executeQuery();
		List<Employee> list = new ArrayList<Employee>();
		while (set.next()) {
//			int id = set.getInt("id");
//	        String name = set.getString("name");
//	        long phone = set.getLong("phone");
//	        String address = set.getString("address");
//	        String email = set.getString("email");
//	        String password = set.getString("password");
//	        
//	        Employee employee = new Employee(id, name, phone, address, email, password);
//	        list.add(employee);	
	        
//	        Above or This, use any one
	        Employee employee = new Employee();
	        employee.setId(set.getInt("id"));
	        employee.setName(set.getString("name"));
	        employee.setPhone(set.getLong("phone"));
	        employee.setAddress(set.getString("address"));
	        employee.setEmail(set.getString("email"));
	        employee.setPassword(set.getString("password"));
	        list.add(employee);
		}
		connection.close();
		return list;
	}
	
	public int deleteEmployee(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id = ?");
		preparedStatement.setInt(1, id);
		int count = preparedStatement.executeUpdate();
		connection.close();
		return count;
	}
	
	public Employee getEmployee(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id = ?");
		preparedStatement.setInt(1, id);
		ResultSet set = preparedStatement.executeQuery();
		Employee employee = new Employee();
		while (set.next()) {
	        employee.setId(set.getInt("id"));
	        employee.setName(set.getString("name"));
	        employee.setPhone(set.getLong("phone"));
	        employee.setAddress(set.getString("address"));
	        employee.setEmail(set.getString("email"));
	        employee.setPassword(set.getString("password"));
		}
		connection.close();
		return employee;
	}
	
	public int updateEmployee(Employee employee) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update employee set name=?, phone=?, address=?, email=?, password=? where id=?");
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setLong(2, employee.getPhone());
		preparedStatement.setString(3, employee.getAddress());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setInt(6, employee.getId());
		int count = preparedStatement.executeUpdate();	
		connection.close();
		return count;
	}
	
}














