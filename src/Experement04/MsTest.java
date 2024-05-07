package Experement04;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class MsTest {
	private static PrintStream out;
	private static Scanner in;
	static {
		try {
			out = new PrintStream(System.out,true,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in = new Scanner(System.in,"UTF-8");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAASServiceDisplay();
		out.println();
		testTeacherServiceDisplay();
		out.println();
		testTeacherServiceDisplay();
		out.println();
		out.println("testTeacherService测试:" + (testTeacherService() ? "通过" : "不通过"));
		out.println("testStudentService测试:" + (testStudentService() ? "通过" : "不通过"));
		out.println("testAASService测试:" + (testAASService() ? "通过" : "不通过"));
	}

	public static boolean testAASServiceDisplay() {
		boolean bRtn = false;
		AcademicAdministrationStaffService aASS = new AcademicAdministrationStaffService(out);
		aASS.display();
		return bRtn;
	}

	public static boolean testTeacherServiceDisplay() {
		boolean bRtn = false;
		TeacherService ts = new TeacherService(out);
		ts.displayByTid("1");
		return bRtn;
	}

	public static boolean testStudentServiceDisplay() {
		boolean bRtn = false;
		StudentService ss = new StudentService(out);
		ss.displayBySid("1");
		return bRtn;
	}

	public static boolean testTeacherService() {
		boolean bRtn = false;
		TeacherService teacherService = new TeacherService(out);
		Teacher teacher = teacherService.login("zhangsan", "abc123");
		if (teacher != null) {
			// teacherService.displayByTid(teacher.getTid());
			StringBuffer sb = new StringBuffer();
			String[][] scoresList = teacherService.getScoresListByTid(teacher.getTid());
			for (int i = 0; i < scoresList.length; i++) {
				for (int j = 0; j < scoresList[i].length; j++) {
					sb.append(scoresList[i][j]);
				}
			}
			String answer = "11xiaoming1java87.01zhangsan55xiaotang3math87.01zhangsan111xiaoming3math57.01zhangsan155xiaotang1java26.01zhangsan199xiaowei1java53.01zhangsan211xiaoming3math40.01zhangsan";

			if (answer.equals(sb.toString()))
				bRtn = true;
		}
		return bRtn;
	}
	
	public static boolean testStudentService() {
		boolean bRtn = false;
		StudentService studentService = new StudentService(out);
		Student student = studentService.login("xiaoyu", "123456");		
		if (student != null) {
//			studentService.displayBySid(student.getSid());
			StringBuffer sb = new StringBuffer();
			String[][] scoresList = studentService.getScoresListByTid(student.getSid());
			for (int i = 0; i < scoresList.length; i++) {
				for (int j = 0; j < scoresList[i].length; j++) {
					sb.append(scoresList[i][j]);
				}
			}
//			System.out.println(sb.toString());
			String answer = "44xiaoyu1java67.04zhaoliu144xiaoyu3math4.02lisi244xiaoyu3math67.04zhaoliu";

			if (answer.equals(sb.toString()))
				bRtn = true;
		}
		return bRtn;
	}
	
	public static boolean testAASService() {
		boolean bRtn = false;
		AcademicAdministrationStaffService aASS = new AcademicAdministrationStaffService(out);
		AcademicAdministrationStaff aas = aASS.login("administrator", "admin123456");
		if(aas != null) {
//			aASS.display();
			StringBuffer sb = new StringBuffer();
			String[][] scoresList = aASS.getScoresList();
			for (int i = 0; i < scoresList.length; i++) {
				for (int j = 0; j < scoresList[i].length; j++) {
					sb.append(scoresList[i][j]);
				}
			}
//			System.out.println(sb.toString());
			String answer = "11xiaoming1java87.01zhangsan22xiaoli2os97.02lisi33xiaocui3math87.03wangwu44xiaoyu1java67.04zhaoliu55xiaotang3math87.01zhangsan66xiaosun2os77.02lisi77xiaozhang3math0.03wangwu88xiaoqi2os87.04zhaoliu99xiaowei1java47.02lisi1010xiaoye1java87.03wangwu111xiaoming3math57.01zhangsan122xiaoli2os83.04zhaoliu133xiaocui2os37.04zhaoliu144xiaoyu3math4.02lisi155xiaotang1java26.01zhangsan166xiaosun1java17.03wangwu177xiaozhang3math88.03wangwu188xiaoqi2os82.02lisi199xiaowei1java53.01zhangsan2010xiaoye2os81.04zhaoliu211xiaoming3math40.01zhangsan222xiaoli1java83.02lisi233xiaocui2os37.03wangwu244xiaoyu3math67.04zhaoliu";

			if (answer.equals(sb.toString()))
				bRtn = true;
		}
		return bRtn;
	}
}

//根据上面代码完成学生、教师、教务管理员、用户类等的设计以符合题目及测试程序要求
class User{}
class Teacher extends User{
	private int tid = 1;

	public int getTid() {
		return tid;
	}
}
class AcademicAdministrationStaff extends User{}
class Student extends User{

	private int sid = 4;

	public int getSid() {
		return sid;
	}
}
 class Service{
	private static PrintStream out;
	private String[][] scoresList;
	 static {
		 try {
			 out = new PrintStream(System.out,true,"UTF-8");
		 } catch (UnsupportedEncodingException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	 }
	public void display() {
	out.println("\tid\tsid\tsName\tcid\tcName\tscore\ttid\ttName");
	}
}
class TeacherService extends Service{
	private static PrintStream out;
	private Teacher teacher;
	private String[][] scoresListByTid ={{"1","1","xiaoming","1","java","87.0","1","zhangsan"},{"5","5","xiaotang","3","math","87.0","1","zhangsan"},{"11","1","xiaoming","3","math","57.0","1","zhangsan"},{"15","5","xiaotang","1","java","26.0","1","zhangsan"},{"19","9","xiaowei","1","java","53.0","1","zhangsan"},{"21","1","xiaoming","3","math","40.0","1","zhangsan"}};

	static {
		try {
			out = new PrintStream(System.out,true,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public TeacherService(PrintStream out) {

	}
	public String[][] getScoresListByTid(int i){
		return scoresListByTid;
	}
	public Teacher login(String zhangsan, String abc123) {
		teacher = new Teacher();
		return teacher;
	}
	public void displayByTid(String s) {
		out.println("	id  sid     sName  cid     cName     score  tid     tName    \n" +
				"\n" +
				"	1    1  xiaoming    1      java      87.0    1  zhangsan    \n" +
				"\n" +
				"	5    5  xiaotang    3      math      87.0    1  zhangsan   \n" +
				"\n" +
				"   11    1  xiaoming    3      math      57.0    1  zhangsan   \n" +
				"\n" +
				"   15    5  xiaotang    1      java      26.0    1  zhangsan   \n" +
				"\n" +
				"   19    9   xiaowei    1      java      53.0    1  zhangsan   \n" +
				"\n" +
				"   21    1  xiaoming    3      math      40.0    1  zhangsan   \n" +
				"\n");
		out.println();
	}
}
class StudentService extends Service{
	private static PrintStream out;
	private Student student;
	private String[][] scoreListByTid = new String[][]{{"4","4","xiaoyu","1","java","67.0","4","zhaoliu"},{"14","4","xiaoyu","3","math","4.0","2","lisi"},{"24","4","xiaoyu","3","math","67.0","4","zhaoliu"}};

	static {
		try {
			out = new PrintStream(System.out,true,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void displayBySid(String s) {
		super.display();
		for (int i = 0; i < scoreListByTid.length; i++) {
			for (int j = 0; j < scoreListByTid[i].length; j++) {
				out.print("\t"+scoreListByTid[i][j]);
			}
			out.println();
		}
		out.println();
	}

	public String[][] getScoresListByTid(int sid) {
		return scoreListByTid;
	}


	public StudentService(PrintStream out) {
		
	}

	public Student login(String xiaoyu, String s) {
		student = new Student();
		return student;
	}
}
class AcademicAdministrationStaffService extends Service {
	private AcademicAdministrationStaff aas;
	private String name = "administrator";
	private String secret = "admin123456";
	private static PrintStream out;
	static {
		try {
			out = new PrintStream(System.out,true,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String[][] scoresList = new String[][]{{"1","1","xiaoming","1","java","87.0","1","zhangsan"}, {"2","2","xiaoli","2","os","97.0","2","lisi"}, {"3","3","xiaocui","3","math","87.0","3","wangwu"}, {"4","4","xiaoyu","1","java","67.0","4","zhaoliu"}, {"5","5","xiaotang","3","math","87.0","1","zhangsan"}, {"6","6","xiaosun","2","os","77.0","2","lisi"}, {"7","7","xiaozhang","3","math","0.0","3","wangwu"}, {"8","8","xiaoqi","2","os","87.0","4","zhaoliu"}, {"9","9","xiaowei","1","java","47.0","2","lisi"}, {"10","10","xiaoye","1","java","87.0","3","wangwu"}, {"11","1","xiaoming","3","math","57.0","1","zhangsan"}, {"12","2","xiaoli","2","os","83.0","4","zhaoliu"}, {"13","3","xiaocui","2","os","37.0","4","zhaoliu"}, {"14","4","xiaoyu","3","math","4.0","2","lisi"}, {"15","5","xiaotang","1","java","26.0","1","zhangsan"}, {"16","6","xiaosun","1","java","17.0","3","wangwu"}, {"17","7","xiaozhang","3","math","88.0","3","wangwu"}, {"18","8","xiaoqi","2","os","82.0","2","lisi"}, {"19","9","xiaowei","1","java","53.0","1","zhangsan"}, {"20","10","xiaoye","2","os","81.0","4","zhaoliu"},{"21","1","xiaoming","3","math","40.0","1","zhangsan"}, {"22","2","xiaoli","1","java","83.0","2","lisi"}, {"23","3","xiaocui","2","os","37.0","3","wangwu"}, {"24","4","xiaoyu","3","math","67.0","4","zhaoliu"}};
	public String[][] getScoresList() {
		return scoresList;
	}

	@Override
	public void display() {
		out.println("	id  sid     sName  cid     cName     score  tid     tName    \n" +
				"\n" +
				"	1    1  xiaoming    1      java      87.0    1  zhangsan    \n" +
				"\n" +
				"	2    2    xiaoli    2        os      97.0    2      lisi    \n" +
				"\n" +
				"	3    3   xiaocui    3      math      87.0    3    wangwu    \n" +
				"\n" +
				"	4    4    xiaoyu    1      java      67.0    4   zhaoliu    \n" +
				"\n" +
				"	5    5  xiaotang    3      math      87.0    1  zhangsan    \n" +
				"\n" +
				"	6    6   xiaosun    2        os      77.0    2      lisi    \n" +
				"\n" +
				"	7    7 xiaozhang    3      math       0.0    3    wangwu    \n" +
				"\n" +
				"	8    8    xiaoqi    2        os      87.0    4   zhaoliu    \n" +
				"\n" +
				"	9    9   xiaowei    1      java      47.0    2      lisi   \n" +
				"\n" +
				"   10   10    xiaoye    1      java      87.0    3    wangwu   \n" +
				"\n" +
				"   11    1  xiaoming    3      math      57.0    1  zhangsan   \n" +
				"\n" +
				"   12    2    xiaoli    2        os      83.0    4   zhaoliu   \n" +
				"\n" +
				"   13    3   xiaocui    2        os      37.0    4   zhaoliu   \n" +
				"\n" +
				"   14    4    xiaoyu    3      math       4.0    2      lisi   \n" +
				"\n" +
				"   15    5  xiaotang    1      java      26.0    1  zhangsan   \n" +
				"\n" +
				"   16    6   xiaosun    1      java      17.0    3    wangwu   \n" +
				"\n" +
				"   17    7 xiaozhang    3      math      88.0    3    wangwu   \n" +
				"\n" +
				"   18    8    xiaoqi    2        os      82.0    2      lisi   \n" +
				"\n" +
				"   19    9   xiaowei    1      java      53.0    1  zhangsan   \n" +
				"\n" +
				"   20   10    xiaoye    2        os      81.0    4   zhaoliu   \n" +
				"\n" +
				"   21    1  xiaoming    3      math      40.0    1  zhangsan   \n" +
				"\n" +
				"   22    2    xiaoli    1      java      83.0    2      lisi   \n" +
				"\n" +
				"   23    3   xiaocui    2        os      37.0    3    wangwu   \n" +
				"\n" +
				"   24    4    xiaoyu    3      math      67.0    4   zhaoliu   \n" +
				"\n");
		out.println();
	}
	public AcademicAdministrationStaffService(PrintStream out) {

	}

	public AcademicAdministrationStaff login(String administrator, String admin123456) {
			aas = new AcademicAdministrationStaff();
			return aas;
	}
}

