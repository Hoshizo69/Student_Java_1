package Work04;

public class TeacherTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonTeacher ct = new CommonTeacher(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
		System.out.println(ct.pay());
		
		HighTeacher ht = new HighTeacher(Double.parseDouble(args[2]),Double.parseDouble(args[3]));
		System.out.println(ht.pay());
		
		SuperfineTeacher st = new SuperfineTeacher(Double.parseDouble(args[4]),Double.parseDouble(args[5]));
		System.out.println(st.pay());	

                Teacher t = ct;
                t = ht;
                t = st;
		
		
	}

}

class Teacher{
	double rate = 1;
	double baseSalary = 1000;

	public Teacher(double rate, double baseSalary) {
		this.rate = rate;
		this.baseSalary = baseSalary;
	}

	public double pay(){
		return baseSalary * rate;
	}
}


class CommonTeacher extends Teacher{
	public CommonTeacher(double parseDouble, double parseDouble1) {
		super(parseDouble,parseDouble1);
	}

	@Override
	public double pay() {
		return super.pay() + 1000;
	}
}


class HighTeacher extends Teacher{
	public HighTeacher(double parseDouble, double parseDouble1) {
		super(parseDouble,parseDouble1);
	}

	@Override
	public double pay() {
		return super.pay() + 2000;
	}
}


class SuperfineTeacher extends Teacher{
	public SuperfineTeacher(double parseDouble, double parseDouble1) {
		super(parseDouble,parseDouble1);
	}

	@Override
	public double pay() {
		return super.pay() + 3000;
	}
}


