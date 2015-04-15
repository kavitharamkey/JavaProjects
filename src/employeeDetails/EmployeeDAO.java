package employeeDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String connectionURL = "jdbc:oracle:thin:@localhost:1521/XE";
	private static Connection con = null;
	private static Statement stmt =null;
	
	private ResultSet rs = null;
	public List<EmployeeBean> empList = null;
	
	
	public EmployeeDAO(){
	try {
		con = getConnection();
	}catch(Exception exp){
		exp.printStackTrace();
		//send a message to servlet
	}
	try{
		empList = new ArrayList<EmployeeBean>();
		getEmployeeInfo(con);
	}catch(Exception exp){
		exp.printStackTrace();
	}finally{
		closeConnection(stmt,con);
	}
	
	}
	

	private static Connection getConnection() throws ClassNotFoundException, Exception{
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(connectionURL,"HR","hr");
		}catch(ClassNotFoundException exp){
			exp.printStackTrace();
			throw exp;
		}catch(Exception exp){
			exp.printStackTrace();
			throw exp;
		}
		return con;
	}
	
	public void getEmployeeInfo(Connection con) throws SQLException {
		try{
			stmt = con.createStatement(); // Step 3
			rs = stmt.executeQuery("select employee_id, first_name,last_name,salary,department_id from employees where salary > 4000 order by salary "); // Step 4
			while (rs.next()) {
				EmployeeBean empbean = new EmployeeBean();
				empbean.setEmpId(rs.getInt("employee_id"));
				empbean.setFname(rs.getString("first_name"));
				empbean.setLname(rs.getString("last_name"));
				empbean.setSalary(rs.getDouble("salary"));
				empbean.setDeptId(rs.getInt("department_id"));
				empList.add(empbean);			
			}

		  }catch(SQLException exp){
			exp.printStackTrace();
			throw exp;
		  }finally{
			  if(rs != null){
					rs.close();
				} 
		  }
	}
	private void closeConnection(Statement stmt , Connection con){
		try{
			if(stmt != null){
				stmt.close();
			}
			if(con != null){
				con.close();
			}
		}catch(Exception exp){
			exp.printStackTrace();
		}
	}
}
