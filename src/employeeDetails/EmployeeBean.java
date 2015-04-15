package employeeDetails;


public class EmployeeBean {
	private String Fname = null;
	private String Lname = null;
	private int empId = 0;
	private int deptId = 0;
	private double salary = 0.00;
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}
