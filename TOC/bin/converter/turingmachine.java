package converter;

import java.util.Arrays;


public class turingmachine {

	private char[] tape1;
	private char[] tape2;
	private char[] tape3;
	//private char head1;
	
	
	public turingmachine() {
	}
	
	public char[] invertion(char[] compute){
		tape1 = compute;
		int l = (tape1.length);
		int i = 0;
		int k = 0;
		int m = 0;
		tape2 = new char[l];
		
		
		//State Q0
		for (i=0; tape1[i] !='\0'; i++) {
			for(int head1 = 0; head1<l; head1++) {
				if(i==head1) {
					System.out.print("[" + tape1[head1] + "]");
					
				}else {
					System.out.print(tape1[head1]);
				}
			}
			System.out.println();
			System.out.print("[" + tape2[0] + "]");
			for(int head2 = 1; head2<l; head2++) {
				System.out.print(tape2[head2]);
			}
			System.out.println();
		}
		 //Q1
		System.out.println("Q1");
		i--;//move left
		
		//Q2
		System.out.println("Q2");
		for (k=0; i>=0; k++) {
			tape2[k] = tape1[i];
						
			for(int head1 = 0; head1<l; head1++) {
				if(i==head1) {
					System.out.print("[" + tape1[head1] + "]");
				}else {
					System.out.print(tape1[head1]);
				}
			}
			System.out.println();
			for(int head2 = 0; head2<l; head2++) {
				if(k==head2) {
					System.out.print("[" + tape2[head2] + "]");
				}else {
					System.out.print(tape2[head2]);
				}
			}
			System.out.println();
		
			i--;
		}
		
		//Q3
		System.out.println("Q3");
		for (m=0; k >= m; k--) {
			System.out.print("[" + tape1[0] + "]");
			for(int head1 = 1; head1<l; head1++) {
				System.out.print(tape1[head1]);
			}
			System.out.println();
			for(int head2 = 0; head2<l; head2++) {
				if(k==head2) {
					System.out.print("[" + tape2[head2] + "]");
				}else {
					System.out.print(tape2[head2]);
				}
			}
			System.out.println();
		}
		return tape2;	
	}

	public void additionQ0(char[] compute) {
		tape1 = compute;
		int l = (tape1.length);
		int i = 0;
		int k = 0;
		int m = l;
		tape2 = invertion(compute);
		tape3 = new char[l+1];
		
		//State Q0
		System.out.println("Add Q0");
		for (i=0; tape1[i] !='\0'; i++) {
			for(int head1 = 0; head1<l; head1++) {
				if(i==head1) {
					System.out.print("[" + tape1[head1] + "]");
				}else {
					System.out.print(tape1[head1]);
				}
			}
			System.out.println();
			for(int head2 = 0; head2<l; head2++) {
				if(i==head2) {
					System.out.print("[" + tape2[head2] + "]");
				}else {
					System.out.print(tape2[head2]);
				}
			}
			System.out.println();
			for(int head3 = m; head3>0; head3--) {
				System.out.print(tape3[head3]);
			}
			System.out.print("[" + tape3[m] + "]");
			System.out.println();
		}
		i=i-1;
		additionQ1(i, m);
		System.out.println(tape3);
	}
	
	public void additionQ1(int i, int m) {
		//State Q1
		System.out.println("Add Q1");
		for(;m>=0;i--) {
			if(tape1[i]=='0' && tape2[i]=='0') {
				tape3[m]='0';
			}else if(tape1[i]=='1' && tape2[i]=='0') {
				tape3[m]='1';
			}else if(tape1[i]=='0' && tape2[i]=='1') {
				tape3[m]='1';
			}else if(tape1[i]=='1' && tape2[i]=='1'){
				tape3[m]='0';
				System.out.println(tape3);
				additionQ2(i,m);
			}else if(i<0 && m>0){
				tape3[m]='\0';
				additionQ3();
			}
			m--;
		}
	}
	
	public void additionQ2(int i, int m) {
		//State Q2
		System.out.println("Add Q2");
		for(;m>=0;i--) {
			if(tape1[i]=='0' && tape2[i]=='0') {
				tape3[m]='1';
				additionQ1(i,m);
			}else if(tape1[i]=='1' && tape2[i]=='0') {
				tape3[m]='0';
			}else if(tape1[i]=='0' && tape2[i]=='1') {
				tape3[m]='0';
			}else if(tape1[i]=='1' && tape2[i]=='1'){
				tape3[m]='1';	
			}else if(i<0 && m>0){
				tape3[m]='1';
				additionQ3();
			}
			m--;
		}
	}
	
	public char[] additionQ3() {
		System.out.println("Add Q2");
		System.out.println(tape3);
		return tape3;
	}
	
	public String toString2() {
		String st = String.valueOf(tape2);
		return "" + st + "";
	}
}