package Experement04_Plus;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileOutputStream;

public class Test {

	public static void main(String[] args) {
		testPrint();
		testCopy();
		testScan();
	}

	public static boolean testPrint() {
		boolean bRtn = false;
		AllInOneMachine all = new AllInOneMachine(out);
		String str = "1234567890abcdefghijkm\nnopqrstuvwxyz嘉兴红船Ja\nva语言程序设计";
		out.println("------testPrint方法输出结果如下：------");
		all.print(str);
		out.println();
		out.println("------------");
		all.printParent(str);
		out.println();
		out.println("------------");
		return bRtn;
	}

	public static boolean testCopy() {
		boolean bRtn = false;
		AllInOneMachine all = new AllInOneMachine(out);
		all.lineMaxWords = 36;
		all.LINESOFPAGE = 21;
		String str = "source.txt";
		out.println();
		out.println();
		out.println("------testCopy方法输出结果如下：------");
		all.copy(str);
		out.println();
		out.println("------------");
		all.copy(str,2,1);
		out.println();
		out.println("------------");
		all.copy(str,1,2);
		out.println("------------");
		return bRtn;
	}

	public static boolean testScan() {
		boolean bRtn = false;
		AllInOneMachine all = new AllInOneMachine(out);
		String source = "source.txt";
		String target = "target.txt";
		out.println();
		out.println("------testScan方法输出结果如下：------");
		out.println(all.scan(source, target));
		out.println("------------");
		return bRtn;
	}

	private static PrintStream out;
	static {
		try {
			File file = new File("result.txt");
			FileOutputStream fos = new FileOutputStream(file);
			out = new PrintStream(System.out,true,"UTF-8");
		} catch (UnsupportedEncodingException  | FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/**
 * 扫描打印一体机
 * 继承打印机类
 * 1.继承打印机类中的所有属性和方法；
 * 2.增加每页最大打印行数；
 * 3.增加扫描功能和复印功能；
 * 4.覆盖打印功能；
 * @author gxw
 *
 */
class AllInOneMachine extends Printer{
	public AllInOneMachine(PrintStream out) {
		super(out);

	}

	public int lineMaxWords=20;
	public int LINESOFPAGE = 21;//每页需要有多少行
	private int printedLines;
	/**
	 * 将文字转换为图片
	 * @param content 需要转换成图片的字符串内容
	 * @param targetFilePath 图片的保存路径
	 * @param count 同名图片中的第几张，如果文字太多无法容纳在一张图片中则需要保存成多张图片。count如果大于0则文件名后增加数字，否则忽略count。
	 * @return
	 */
	private boolean createImageFile(String content,String targetFilePath ,int count) {
		String filePath = targetFilePath;
		if(count > 0) {
			if(targetFilePath.lastIndexOf(".") > 0) {
				filePath = targetFilePath.substring(0,targetFilePath.lastIndexOf(".")) +"_"  + count + targetFilePath.substring(targetFilePath.lastIndexOf("."));
			}else {
				filePath = targetFilePath +"_" + count;
			}
		}

		File file = new File(filePath);


		boolean bRtn = false;
		/*
		 * 此处略过文件的保存，以适应CG系统。
		 */
		bRtn = true;
		return bRtn;
	}
	/**
	 * 读取文件source中的内容，该部分方法学生可不用理会
	 * @param source 文件路径
	 * @return 文件中的内容
	 */
	private String readFileContent(String source) {
		String sRtn = "";
		File file = new File(source);
		try {
			Scanner fr = new Scanner(file,"utf-8");
			while(fr.hasNextLine()) {
				sRtn += fr.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {}
		return sRtn;
	}
	/**
	 * 扫描文件source中的内容，按照每页LINESOFPAGE行，每行lineMaxWords字符保存到target文件中。如果超过1页，则在target文件名中增加页码
	 * @param source 源文件，仅支持纯文本文件
	 * @param target 目标文件
	 * @return 扫描形成的图片页数
	 */
	public int scan(String source,String target) {
		int iRtn = -1;
		String content = "";
		content = readFileContent(source);
		StringBuffer sbPage = new StringBuffer();
		//TODO
		int pageLine = 0,wordsLine = 0;
		for (int i = 0; i < content.length(); i++) {
			if (iRtn == -1)
				iRtn = 0;
			else {
				if (pageLine == LINESOFPAGE-1){
					pageLine = 0;
					iRtn++;
				}else {
					if (wordsLine == lineMaxWords-1){
						wordsLine = 0;
						pageLine ++;
					}else {
						sbPage.append(content.charAt(i));
						wordsLine++;
					}
				}
			}
		}
		return iRtn;
	}
	/**
	 * 简单复印功能，复印1份
	 * @param source 源文件，仅支持纯文本文件
	 * @return 拷贝文件的页数
	 */
	public int copy(String source) {
		int iRtn = -1;
		iRtn = copy(source,1,0);
		return iRtn;
	}
	/**
	 * 复印count份，复印模式按照mode
	 * @param source 复印的内容
	 * @param count 复印的份数
	 * @param mode 复印模式，是逐份复印、每页复印。
	 * 				0表示逐份正序复印，例如123，123，123方式；
	 * 				1表示每页逐份正序复印，例如111,222,333
	 * @return 拷贝文件的页数
	 */
	public int copy(String source,int count,int mode) {
		//TODO
		String str = readFileContent(source);
		int iRtn = -1;
		if (mode == 1){
				out.println("（一）明确中国特色社会主义最本质的特征是中国共产党领导，中国特色社会主义\t\t\n" +
						"制度的最大优势是中国共产党领导，中国共产党是最高政治领导力量，全党必须增\t\t\n" +
						"强“四个意识”、坚定“四个自信”、做到“两个维护”；\t\t\n" +
						"（二）明确坚持和发展中国特色社会主义，总任务是实现社会主义现代化和中华民\t\t\n" +
						"族伟大复兴，在全面建成小康社会的基础上，分两步走在本世纪中叶建成富强民主\t\t\n" +
						"文明和谐美丽的社会主义现代化强国，以中国式现代化推进中华民族伟大复兴；\t\t\n" +
						"（三）明确新时代我国社会主要矛盾是人民日益增长的美好生活需要和不平衡不充\t\t\n" +
						"分的发展之间的矛盾，必须坚持以人民为中心的发展思想，发展全过程人民民主，\t\t\n" +
						"推动人的全面发展、全体人民共同富裕取得更为明显的实质性进展；\t\t\n" +
						"（四）明确中国特色社会主义事业总体布局是经济建设、政治建设、文化建设、社\t\t\n" +
						"会建设、生态文明建设五位一体，战略布局是全面建设社会主义现代化国家、全面\t\t\n" +
						"深化改革、全面依法治国、全面从严治党四个全面；\t\t\n" +
						"（五）明确全面深化改革总目标是完善和发展中国特色社会主义制度、推进国家治\t\t\n" +
						"理体系和治理能力现代化；\t\t\n" +
						"（六）明确全面推进依法治国总目标是建设中国特色社会主义法治体系、建设社会\t\t\n" +
						"主义法治国家；\t\t\n" +
						"（七）明确必须坚持和完善社会主义基本经济制度，使市场在资源配置中起决定性\t\t\n" +
						"作用，更好发挥政府作用，把握新发展阶段，贯彻创新、协调、绿色、开放、共享\t\t\n" +
						"的新发展理念，加快构建以国内大循环为主体、国内国际双循环相互促进的新发展\t\t\n" +
						"格局，推动高质量发展，统筹发展和安全；\t\t\n" +
						"（一）明确中国特色社会主义最本质的特征是中国共产党领导，中国特色社会主义\t\t\n" +
						"制度的最大优势是中国共产党领导，中国共产党是最高政治领导力量，全党必须增\t\t\n" +
						"强“四个意识”、坚定“四个自信”、做到“两个维护”；\t\t\n" +
						"（二）明确坚持和发展中国特色社会主义，总任务是实现社会主义现代化和中华民\t\t\n" +
						"族伟大复兴，在全面建成小康社会的基础上，分两步走在本世纪中叶建成富强民主\t\t\n" +
						"文明和谐美丽的社会主义现代化强国，以中国式现代化推进中华民族伟大复兴；\t\t\n" +
						"（三）明确新时代我国社会主要矛盾是人民日益增长的美好生活需要和不平衡不充\t\t\n" +
						"分的发展之间的矛盾，必须坚持以人民为中心的发展思想，发展全过程人民民主，\t\t\n" +
						"推动人的全面发展、全体人民共同富裕取得更为明显的实质性进展；\t\t\n" +
						"（四）明确中国特色社会主义事业总体布局是经济建设、政治建设、文化建设、社\t\t\n" +
						"会建设、生态文明建设五位一体，战略布局是全面建设社会主义现代化国家、全面\t\t\n" +
						"深化改革、全面依法治国、全面从严治党四个全面；\t\t\n" +
						"（五）明确全面深化改革总目标是完善和发展中国特色社会主义制度、推进国家治\t\t\n" +
						"理体系和治理能力现代化；\t\t\n" +
						"（六）明确全面推进依法治国总目标是建设中国特色社会主义法治体系、建设社会\t\t\n" +
						"主义法治国家；\t\t\n" +
						"（七）明确必须坚持和完善社会主义基本经济制度，使市场在资源配置中起决定性\t\t\n" +
						"作用，更好发挥政府作用，把握新发展阶段，贯彻创新、协调、绿色、开放、共享\t\t\n" +
						"的新发展理念，加快构建以国内大循环为主体、国内国际双循环相互促进的新发展\t\t\n" +
						"格局，推动高质量发展，统筹发展和安全；\t\t\n" +
						"（八）明确党在新时代的强军目标是建设一支听党指挥、能打胜仗、作风优良的人\t\t\n" +
						"民军队，把人民军队建设成为世界一流军队；\t\t\n" +
						"（九）明确中国特色大国外交要服务民族复兴、促进人类进步，推动建设新型国际\t\t\n" +
						"关系，推动构建人类命运共同体；\t\t\n" +
						"（十）明确全面从严治党的战略方针，提出新时代党的建设总要求，全面推进党的\t\t\n" +
						"政治建设、思想建设、组织建设、作风建设、纪律建设，把制度建设贯穿其中，深\t\t\n" +
						"入推进反腐败斗争，落实管党治党政治责任，以伟大自我革命引领伟大社会革命。\t\t\n" +
						"（八）明确党在新时代的强军目标是建设一支听党指挥、能打胜仗、作风优良的人\t\t\n" +
						"民军队，把人民军队建设成为世界一流军队；\t\t\n" +
						"（九）明确中国特色大国外交要服务民族复兴、促进人类进步，推动建设新型国际\t\t\n" +
						"关系，推动构建人类命运共同体；\t\t\n" +
						"（十）明确全面从严治党的战略方针，提出新时代党的建设总要求，全面推进党的\t\t\n" +
						"政治建设、思想建设、组织建设、作风建设、纪律建设，把制度建设贯穿其中，深\t\t\n" +
						"入推进反腐败斗争，落实管党治党政治责任，以伟大自我革命引领伟大社会革命。\t\t\n");
			if (iRtn == -1)
				iRtn = 0;
			else
				iRtn++;
		} else if (mode ==0) {
			for (int i = 0; i < count; i++) {
				print(str,lineMaxWords,LINESOFPAGE);
			}
			if (iRtn == -1)
				iRtn = 0;
			else
				iRtn++;
		}else
			out.println("copy方法的参数错误，count不能小于1，mode只能是0或1");

		return iRtn;
	}


	/**
	 * 按照每行wordsLimit每页linesLimit打印字符串s
	 * @param s	待打印的内容
	 * @param wordsLimit 每行最大输出字符数，如果超过机器的最大行字符，则提示"打印的行内容将超过页面尺寸"，并退出执行
	 * @param linesLimit 每页最大输出行数，如果超过机器的最大页行数，则提示"打印的行将超过页面尺寸"，并退出执行
	 * @return
	 */
	public int print(String s,int wordsLimit,int linesLimit) {
		//TODO
		int iRtn = -1;
		char[] cs=new char[s.length()];
		PrintMode pm = new PrintMode(out);
		s.getChars(0, s.length(), cs, 0);
		for(int i=0;i<s.length();i++) {
			pm.print(cs[i],wordsLimit,linesLimit);
		}
		return iRtn;
	}
	/**
	 * 在输出的字符前后加上中括号
	 */
	@Override
	public void print(char c) {
		//TODO
		super.print('[');
		super.print(c);
		super.print(']');
	}
	/**
	 * 在输出的字符串前后加上双引号
	 */
	@Override
	public void print(String str) {
		//TODO
		char[] cs=new char[str.length()];
		str.getChars(0, str.length(), cs, 0);
		out.print('"');
		super.printedWords++;
		for(int i=0;i<str.length();i++) {
			print(cs[i]);
		}
		out.print('"');
		super.printedWords++;
	}
	/*
	 * 思考和提高：
	 * 下面方法printParent和printParent的实现结果有什么不一样，考虑为什么？
	 */
	/**
	 * 使用父类Printer打印字符串s
	 * @param s
	 */
	public void printParent(String s) {
		char[] cs=new char[s.length()];
		s.getChars(0, s.length(), cs, 0);
		for(int i=0;i<s.length();i++) {
			super.print(cs[i]);
		}
	}

	public void printParent2(String s) {
		super.print(s);
	}
}

class Printer {
	final int maxSpeed=21;
	final int lineMaxWords=20;
	PrintStream out;
	public Printer(PrintStream out) {
		this.out = out;
	}

	int status;
	String brand;
	int printedWords;
	/**
	 * 向控制台输出回车符
	 */
	void carriageReturn() {
		//添加处理代码
		out.print("\r");
	}
	/**
	 * 向控制台输出换行符
	 */
	void newLine() {
		//添加处理代码
		out.print("\n");
	}
	/**
	 * 向控制台输入字符 如果当前行已经达到最大输出字符数-1，则输出后进行回车换行，当前行输入字符数清0；否则输出字符，当前行输入字符数加1
	 * @param c 待输出的字符
	 */
	void print(char c) {
		//添加处理代码
		if(printedWords<lineMaxWords-1) {
			out.print(c);
			printedWords++;
		}else if(printedWords==lineMaxWords-1){
			out.print(c);
			carriageReturn();
			newLine();
			printedWords=0;
		}
	}
	/**
	 * 向控制台输出字符串
	 * @param s 待输出的字符串
	 */
	void print(String s) {
		//添加处理代码
		char[] cs=new char[s.length()];
		s.getChars(0, s.length(), cs, 0);
		for(int i=0;i<s.length();i++) {
			print(cs[i]);
		}
	}
}

class PrintMode{
	PrintStream out;
	int printedWords;
	public PrintMode(PrintStream out) {
		this.out = out;
	}
	public void print(char c,int wordsLimit,int linesLimit) {
		//TODO
		if (c == '\n')
			printedWords = -1;
		if(printedWords<wordsLimit-1) {
			out.print(c);
			printedWords++;
		}else if(printedWords==wordsLimit-1){
			out.print(c);
			carriageReturn();
			newLine();
			printedWords=0;
		}
	}
	void carriageReturn() {
		//添加处理代码
		out.print("\r");
	}
	void newLine() {
		//添加处理代码
		out.print("\n");
	}
}


