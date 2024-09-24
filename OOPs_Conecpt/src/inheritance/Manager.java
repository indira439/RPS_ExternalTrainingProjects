package inheritance;

public class Manager extends Employee{
private int numberOfEmp;
private Address add =new Address();		// Manager has Address reference or complex property 

public void readMgr() {
	readEmp();
	System.out.println("Enter the number of employee working under him");
	numberOfEmp= sc.nextInt();
	add.readAdd();
}
public void disMgr() {
	disEmp();
	System.out.println("Number of employee working under him "+numberOfEmp);
	add.disAdd();
}
}