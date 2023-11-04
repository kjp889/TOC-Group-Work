package converter;

import java.util.Arrays;


public class registerMachineConverter {

	private int num2 = 10;
	private int registerX;
	private int registerY;
	private int registerC;
	private int registerR;
	private int registerQ;
	private int[] tape = new int[11];
	
	
	public registerMachineConverter() {
		this.registerX = 0;
		this.registerY = 2;
		this.registerC = 0;
		this.registerR = 0;
		this.registerQ = 0; 
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
		return registerC;
	}

	public void setRegisterC(int registerC) {
		this.registerC = registerC;
	}

	public int getRegisterR() {
		return registerR;
	}

	public void setRegisterR(int registerR) {
		this.registerR = registerR;
	}

	public int getRegisterQ() {
		return registerQ;
	}

	public void setRegisterQ(int registerQ) {
		this.registerQ = registerQ;
	}

	public int findRemainder(int registerX, int numTape) {
		registerQ = 0;
		registerY = 2;
		//int remainder = 0;
		//int count = 0;
		//REPEATS THE FOLLOWING BLOCK OOF CODE UNTIL REGISTER 'X' IS EMPTY
		while (registerX > 0) {
			registerY--; //EMPTIES REGISTER 'Y' INTO REGISTER 'R'
			registerR++; //
			registerX--; //EMPTIES REGISTER 'X' INTO REGISTER 'C'
			registerC++; //
			/*WHEN REGISTER 'Y' GETS EMPTY INCREMENT REGISTER 'Q' AND REFILL REGISTER 'Y' BY
			EMPTING REGISTER 'R'*/
			if (registerY <= 0) {
				registerQ++;
				//REFILLS REGISTER 'Y'
				for (;registerR > 0; registerR--) {
					registerY++;
				}
			}
			//System.out.print("Iteration");
			//System.out.println(++count);
			//System.out.println(registerQ);
			//System.out.print(registerR);
			//System.out.println();
		}
		//remainder = registerR;
		tape[numTape] = registerR;
		return registerQ;
	}

	public void convert(int numX) {
		while (numX >= 1) {
			numX = findRemainder(numX, num2--);
			
		}
	}
		
 	@Override
	public String toString() {
		return "registerMachineConverter [tape=" + Arrays.toString(tape) + "]";
	}

}
