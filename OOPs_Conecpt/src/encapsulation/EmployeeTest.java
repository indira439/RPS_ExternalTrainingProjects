package encapsulation;

public class EmployeeTest {

	public EmployeeTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employye emp = new Employye(2, "Indu", 10.0f);
		Employye emp1 = new Employye();
	

	}
	
	public int getRollNo() {
		return 1;
	}

}

class Student extends EmployeeTest
{
	@Override
	public int getRollNo()
	{
		return 2;
	}
}
