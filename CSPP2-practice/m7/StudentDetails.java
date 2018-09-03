public class StudentDetails{
	public static void main(String[] args) {
	Student sangay = new Student("IT201985001", 7.5 , 7.0 ,8.0);
	Student bidhya = new Student("IT201985003", 8.5 , 6.0,7.5);
	Student kelzang = new Student("IT201985065", 7.5 , 8.0 ,9.0);
	System.out.println(sangay.getGpa());
	System.out.println(bidhya.getGpa());
	System.out.println(kelzang.getGpa());

	}
}
class Student{
	//int name;
	String roll;
	double subject1;
	double subject2;
	double subject3;

	Student(String rollNumber,double sub1,double sub2,double sub3){
		//this.name = name;
		this.roll = rollNumber;
		this.subject1 = sub1;
		this.subject2 = sub2;
		this.subject3 = sub3;
	}

	public double getGpa(){
		double x = this.subject1;
		double y = this.subject2;
		double z = this.subject3;
		return ((x+y+z)/3);
	}
}
