/*Tutor: Mrs. Khalilah Burrell-Battick

Group Members:
Andre Grant - 1908921
Kyle Parris - 1804904
Rojét Facey- 2006746*/
package converter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		registerMachineConverter A = new registerMachineConverter();
		turingmachine b = new turingmachine();
		
		//int num = A.findRemainder(7, 10);
		A.convert(6);
		//System.out.print(num);
		//System.out.println(A.toString());
		b.additionQ0(A.toBin());
		//A.toBin();
		//System.out.println(A.toString());

	}

}
