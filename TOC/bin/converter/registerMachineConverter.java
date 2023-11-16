package converter;

import java.util.Arrays;


public class registerMachineConverter {

	private int num2 = 10;
	private int registerX;
	private int registerY;
	private int registerYCopy;
	private int registerXCopy;
	private int registerDivCopy;
	private int registerRemainder;
	private int registerMul;
	private int registerDiv;
	private int[] tape = new int[11];
	
	
	public registerMachineConverter() {
		this.registerX = 0;
		this.registerY = 2;
		this.registerYCopy = 0;
		this.registerRemainder = 0;
		this.registerDiv = 0; 
		this.registerDivCopy = 0;
		this.registerXCopy =0;
		this.registerMul = 0;
	}
	
	public int getRegisterX() {
		return registerX;
	}

	public void setRegisterX(int registerX) {
		this.registerX = registerX;
	}

	public int getRegisterY() {
		return registerY;
	}

	public void setRegisterY(int registerY) {
		this.registerY = registerY;
	}

	public int getRegisterC() {
		return registerYCopy;
	}

	public void setRegisterC(int registerC) {
		this.registerYCopy = registerC;
	}

	public int getRegisterR() {
		return registerRemainder;
	}

	public void setRegisterR(int registerR) {
		this.registerRemainder = registerR;
	}

	public int getRegisterQ() {
		return registerDiv;
	}

	public void setRegisterQ(int registerQ) {
		this.registerDiv = registerQ;
	}

	public int findRemainder(int registerX, int numTape) {
		registerDiv = 0;
		registerDivCopy = 0;
		registerY = 2;
		registerRemainder =0;
		registerXCopy = 0;
		registerYCopy = 0;
		registerMul = 0;
		//int remainder = 0;
		//int count = 0;
		//registerY--; //EMPTIES REGISTER 'Y' INTO REGISTER 'R'
		//REPEATS THE FOLLOWING BLOCK OOF CODE UNTIL REGISTER 'X' IS EMPTY
		for (;registerX > 0;) {
			registerY--; //EMPTIES REGISTER 'Y' INTO REGISTER 'R'
			registerYCopy++;
			registerX--; //EMPTIES REGISTER 'X' INTO REGISTER 'C'
			registerRemainder++; //
			registerXCopy++;
			/*WHEN REGISTER 'Y' GETS EMPTY INCREMENT REGISTER 'Div' AND REFILL REGISTER 'Y' BY
			EMPTING REGISTER 'R'*/
			if (registerY <= 0) {
				registerDiv++;
				//REFILLS REGISTER 'Y'
				for (;registerYCopy > 0; registerYCopy--) {
					registerY++;
				}
			}
			//System.out.print("Iteration");
			//System.out.println(++count);
			//System.out.println(registerDiv);
			//System.out.print(registerRemainder);
			//System.out.println();
		}
		for (;registerYCopy > 0; registerYCopy--) {
			registerY++;
		}
		
		while (registerDiv > 0) {
			registerDiv--;
			registerDivCopy++;
			for(;registerY > 0; registerY--) {
				registerYCopy++;
				registerMul++;
			}
			for (;registerYCopy > 0; registerYCopy--) {
				registerY++;
			}
		}
		for(;registerMul > 0; registerMul--) {
			registerRemainder--;
		}
		//System.out.print("index: ");
		//System.out.println(num2);
		//System.out.print("Div: ");
		//System.out.println(registerDivCopy);
		//System.out.print("Remainder");
		//System.out.println(registerRemainder);
		//remainder = registerR;
		tape[numTape] = registerRemainder;
		return registerDivCopy;
	}

	public void convert(int numX) {
		while (numX >= 1) {
			numX = findRemainder(numX, num2--);
			/*if (num2 == 0) {
				break;
			}*/
		}
	}
		
 	@Override
	public String toString() {
		return "" + Arrays.toString(tape) + "";
	}

}
