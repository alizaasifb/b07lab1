import java.io.*;
import java.util.Arrays;
public class Driver {
	public static void main(String [] args) throws IOException{
		
		// methods to test:
		// 		1. Constructor: 	public Polynomial()																	(done)
		// 		2. Constructor: 	public Polynomial(double[] input_coefficient_arr, int[] input_exponent_arr)			(done)
		// 		3. Constructor: 	public Polynomial(File filename) throws IOException									(done)
		// 		4. 	public void saveToFile(String filename) throws IOException											(done)
		//		5. 	public int findMAX (int[] exp_arr)																	(done)
		// 		6.	public Polynomial add(Polynomial to_add)															(done)
		//		7.	public double evaluate(double x)																	(done)
		//		8.	public boolean hasRoot(double maybe_root)															(done)
		// 		9.	public Polynomial multiply(Polynomial to_multiply)													(done)
		
		double [] c1 = null;
		int [] e1 = {0, 1, 2};
		Polynomial p1 = new Polynomial(c1, e1);
		
		double [] c2 = {-1, -2, -3};
		int [] e2 = null;
		Polynomial p2 = new Polynomial(c2, e2);
		
		Polynomial p3 = new Polynomial();

		double [] c4 = {1};
		int [] e4 = {4};
		Polynomial p4 = new Polynomial(c4, e4);

		double [] c5 = {-1};
		int [] e5 = {4};
		Polynomial p5 = new Polynomial(c5, e5);

		double [] c6 = {1};
		int [] e6 = {1};
		Polynomial p6 = new Polynomial(c6, e6);		
		
		double [] c7 = {-1};
		int [] e7 = {1};
		Polynomial p7 = new Polynomial(c7, e7);
		
		double [] c8 = {1};
		int [] e8 = {0};
		Polynomial p8 = new Polynomial(c8, e8);
		
		double [] c9 = {-1};
		int [] e9 = {0};
		Polynomial p9 = new Polynomial(c9, e9);
		
		double [] c10 = {-2, 3};
		int [] e10 = {0, 1};
		Polynomial p10 = new Polynomial(c10, e10);
		
		double [] c11 = {9, -8};
		int [] e11 = {8, 2};
		Polynomial p11 = new Polynomial(c11, e11);
		
		double [] c12 = {1, -1};
		int [] e12 = {1, 0};
		Polynomial p12 = new Polynomial(c12, e12);
		
		double [] c13 = {1, 1};
		int [] e13 = {1, 0};
		Polynomial p13 = new Polynomial(c13, e13);
		
		double [] c14 = {-4, 3, 4, -2, -2, 1};
		int [] e14 = {9, 2, 3, 0, 11, 1};
		Polynomial p14 = new Polynomial(c14, e14);
		
		double [] c15 = {1, 1, -1, 4, 8, 2, -9, -10, -113};
		int [] e15 = {1, 2, 13, 5, 0, 9, 10, 3, 8};
		Polynomial p15 = new Polynomial(c15, e15);
		
		int count = 0;
		
		/* TESTING add() and evaluate() methods  */
		Polynomial p15_add_p10 = p15.add(p10);
		double a1 = p15_add_p10.evaluate(1);
		if ( a1 != -116 ) { System.out.println("Got p15_add_p10.evaluate(1) = " + a1 + " but expected -116"); }
		else count++;
		double a2 = p15_add_p10.evaluate(2);
		if ( a2 != -45246 ) { System.out.println("Got p15_add_p10.evaluate(2) = " + a2 + " but expected -45246"); }
		else count++;
		
		Polynomial p10_add_p15 = p10.add(p15);
		double a3 = p10_add_p15.evaluate(1);
		if ( a3 != -116) { System.out.println("Got p10_add_p15.evaluate(1) = " + a3 + " but expected -116"); }
		else count++;
		double a4 = p10_add_p15.evaluate(2);
		if ( a4 != -45246) { System.out.println("Got p10_add_p15.evaluate(2.4) = " + a4 + " but expected -45246"); }
		else count++;

		Polynomial p1_add_p12 = p1.add(p12);
		double a5 = p1_add_p12.evaluate(1);
		if ( a5 !=  0) { System.out.println("Got p1_add_p12.evaluate(1) = " + a5 + " but expected 0"); }
		else count++;
		double a6 = p1_add_p12.evaluate(-7.2);
		if ( a6 != -8.2) { System.out.println("Got p1_add_p12.evaluate(-7.2) = " + a6 + " but expected -8.2"); }
		else count++;
		
		Polynomial p14_add_p2 = p14.add(p2);
		double a7 = p14_add_p2.evaluate(-2);
		if ( a7 != 6120) { System.out.println("Got p14_add_p2.evaluate(-2) = " + a7 + " but expected 6120"); }
		else count++;
		double a8 = p14_add_p2.evaluate(1);
		if ( a8 != 0) { System.out.println("Got p14_add_p2.evaluate(8) = " + a8 + " but expected 0"); }
		else count++;
		
		Polynomial p10_add_p10 = p10.add(p10);
		double a9 = p10_add_p10.evaluate(-0.23);
		if ( a9 != -5.38) { System.out.println("Got p10_add_p10.evaluate(-0.23) = " + a9 + " but expected -5.38"); }
		else count++;
		double a10 = p10_add_p10.evaluate(3.234);
		if ( a10 != 15.404) { System.out.println("Got p10_add_p10.evaluate(3.234) = " + a10 + " but expected 15.404"); }
		else count++;
		
		/* TESTING add() and multiply() methods */
		Polynomial p13_multiply_p4 = p13.multiply(p4);
		double m1 = p13_multiply_p4.evaluate(2.1);
		if (m1 != 60.289110000000015) { System.out.println("Got p13_multiply_p4.evaluate(0.1) = " + m1 + " but expected 60.289110000000015"); }
		else count++;
		double m2 = p13_multiply_p4.evaluate(2.112);
		if (m2 != 61.91776103871285) { System.out.println("Got p13_multiply_p4.evaluate(2.112) = " + m2 + " but expected 61.91776103871285"); }
		else count++;
		
		Polynomial p4_multiply_p13 = p4.multiply(p13);
		double m3 = p4_multiply_p13.evaluate(3.1);
		if (m3 != 378.64361) { System.out.println("Got p4_multiply_p13.evaluate(0.1) = " + m3 + " but expected 378.64361"); }
		else count++;
		double m4 = p4_multiply_p13.evaluate(2.112);
		if (m4 != 61.91776103871285) { System.out.println("Got p4_multiply_p13.evaluate(2.112) = " + m4 + " but expected 61.91776103871285"); }
		else count++;
		
		Polynomial p7_multiply_p8 = p7.multiply(p8);
		double m5 = p7_multiply_p8.evaluate(4.12);
		if (m5 != -4.12) { System.out.println("Got p7_multiply_p8.evaluate(4.12) = " + m5 + " but expected -4.12"); }
		else count++;
		double m6 = p7_multiply_p8.evaluate(-7);
		if (m6 != 7) { System.out.println("Got p7_multiply_p8.evaluate(-7) = " + m6 + " but expected 7"); }
		else count++;
		
		Polynomial p3_multiply_p11 = p3.multiply(p11);
		double m7 = p3_multiply_p11.evaluate(-2.3);
		if (m7 != 0) { System.out.println("Got p3_multiply_p11.evaluate(-2.3) = " + m7 + " but expected 0"); }
		else count++;
		double m8 = p3_multiply_p11.evaluate(3.1);
		if (m8 != 0) { System.out.println("Got p3_multiply_p11.evaluate(3.1) = " + m8 + " but expected 0"); }
		else count++;
		
		Polynomial p6_multiply_p5 = p6.multiply(p5);
		double m9 = p6_multiply_p5.evaluate(5.1);
		if (m9 != -3450.252509999999) { System.out.println("Got p6_multiply_p5.evaluate(5.1) = " + m9 + " but expected -3450.252509999999"); }
		else count++;
		double m10 = p6_multiply_p5.evaluate(-0.41);
		if (m10 != 0.011585620099999996) { System.out.println("Got p6_multiply_p5.evaluate(-0.41) = " + m10 + " but expected 0.011585620099999996"); }
		else count++;
		
		Polynomial p15_multiply_p1 = p15.multiply(p1);
		double m11 = p15_multiply_p1.evaluate(-231);
		if (m11 != 0) { System.out.println("Got p15_multiply_p1.evaluate(-231) = " + m11 + " but expected 0"); }
		else count++;
		double m12 = p15_multiply_p1.evaluate(2.1);
		if (m12 != 0) { System.out.println("Got p15_multiply_p1.evaluate(2.1) = " + m12 + " but expected 0"); }
		else count++;
		
		Polynomial p7_multiply_p7 = p7.multiply(p7);
		double m13 = p7_multiply_p7.evaluate(1.2);
		if (m13 != 1.44) { System.out.println("Got p7_multiply_p7.evaluate(1.2) = " + m13 + " but expected 1.44"); }
		else count++;
		double m14 = p7_multiply_p7.evaluate(2.1);
		if (m14 != 4.41) { System.out.println("Got p7_multiply_p7.evaluate(2.1) = " + m14 + " but expected 4.41"); }
		else count++;
		
		Polynomial p1_multiply_p2 = p1.multiply(p2);
		double m15 = p1_multiply_p2.evaluate(-890);
		if (m15 != 0) { System.out.println("Got p1_multiply_p2.evaluate(-890) = " + m15 + " but expected 0"); }
		else count++;
		double m16 = p1_multiply_p2.evaluate(1);
		if (m16 != 0) { System.out.println("Got p1_multiply_p2.evaluate(1) = " + m16 + " but expected 0"); }
		else count++;
		
		
		
		
		/* TESTING multiply() and add() and hasRoot() methods */
		Polynomial p12_multiply_p13 = p12.multiply(p13);
		boolean r1 = p12_multiply_p13.hasRoot(-1); 
		if (r1 != true) System.out.println("-1 is a root of p12_multiply_p13, but got otherwise");
		else count++;
		boolean r2 = p12_multiply_p13.hasRoot(1);
		if (r2 != true) System.out.println("1 is a root of p12_multiply_p13, but got otherwise");
		else count++;
		boolean r3 = p12_multiply_p13.hasRoot(0);
		if (r3 == true) System.out.println("0 is not a root of p12_multiply_p13, but got otherwise");
		else count++;
		boolean r4 = p12_multiply_p13.hasRoot(1.1);
		if (r4 == true) System.out.println("1.1 is not a root of p12_multiply_p13, but got otherwise");
		else count++;
		
		boolean r5 = p1.hasRoot(1092.3);
		if (r5 != true) System.out.println("1092.3 is a root of p1, but got otherwise");
		else count++;
		boolean r6 = p3.hasRoot(-22332.1);
		if (r6 != true) System.out.println("-22332.1 is a root of p3, but got otherwise");
		else count++;
		boolean r7 = p1_multiply_p2.hasRoot(-8.221);
		if (r7 != true) System.out.println("-8.221 is a root of p1_multiply_p2, but got otherwise");
		else count++;
		
		Polynomial p11_multiply_p8 = p11.multiply(p8);
		boolean r8 = p11_multiply_p8.hasRoot(9.1);
		if (r8 == true) System.out.println("9.1 is not a root of p11_multiply_p8, but got otherwise");		
		else count++;
		boolean r9 = p11_multiply_p8.hasRoot(0);
		if (r9 != true) System.out.println("0 is a root of p11_multiply_p8, but got otherwise");
		else count++;
		
		Polynomial p14_multiply_p11 = p14.multiply(p11);
		boolean r11 = p14_multiply_p11.hasRoot(0);
		if (r11 != true) System.out.println("0 is a root of p14_multiply_p11, but got otherwise");
		else count++;
		boolean r12 = p14_multiply_p11.hasRoot(1);
		if (r12 != true) System.out.println("1 is a root of p14_multiply_p11, but got otherwise");
		else count++;
		boolean r13 = p14_multiply_p11.hasRoot(2.3);
		if (r13 == true) System.out.println("2.3 is not a root of p14_multiply_p11, but got otherwise");
		else count++;
		
		Polynomial p5_add_p11 = p5.add(p11);
		boolean r14 = p5_add_p11.hasRoot(0);
		if (r14 != true) System.out.println("0 is a root of p5_add_p11, but got otherwise");
		else count++;
		boolean r15 = p5_add_p11.hasRoot(2);
		if (r15 == true) System.out.println("2 is not a root of p5_add_p11, but got otherwise");
		else count++;
		boolean r16 = p5_add_p11.hasRoot(-1);
		if (r16 != true) System.out.println("-1 is a root of p5_add_p11, but got otherwise");
		else count++;
		boolean r17 = p5_add_p11.hasRoot(1);
		if (r17 != true) System.out.println("1 is a root of p5_add_p11, but got otherwise");
		else count++;
			
			
		/* TESTING  Polynomial(filename) constructor and saveToFile() method*/
		p1.saveToFile("file1.txt");
		File file1 = new File("file1.txt");
		Polynomial p1new = new Polynomial(file1);
		if ( !(Arrays.equals(p1.coefficient_arr, p1new.coefficient_arr)) || !(Arrays.equals(p1.exponent_arr, p1new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p2.saveToFile("file2.txt");
		File file2 = new File("file2.txt");
		Polynomial p2new = new Polynomial(file2);
		if ( !(Arrays.equals(p2.coefficient_arr, p2new.coefficient_arr)) || !(Arrays.equals(p2.exponent_arr, p2new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p3.saveToFile("file3.txt");
		File file3 = new File("file3.txt");
		Polynomial p3new = new Polynomial(file3);
		if ( !(Arrays.equals(p3.coefficient_arr, p3new.coefficient_arr)) || !(Arrays.equals(p3.exponent_arr, p3new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p4.saveToFile("file4.txt");
		File file4 = new File("file4.txt");
		Polynomial p4new = new Polynomial(file4);
		if ( !(Arrays.equals(p4.coefficient_arr, p4new.coefficient_arr)) || !(Arrays.equals(p4.exponent_arr, p4new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p5.saveToFile("file5.txt");
		File file5 = new File("file5.txt");
		Polynomial p5new = new Polynomial(file5);
		if ( !(Arrays.equals(p5.coefficient_arr, p5new.coefficient_arr)) || !(Arrays.equals(p5.exponent_arr, p5new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p6.saveToFile("file6.txt");
		File file6 = new File("file6.txt");
		Polynomial p6new = new Polynomial(file6);
		if ( !(Arrays.equals(p6.coefficient_arr, p6new.coefficient_arr)) || !(Arrays.equals(p6.exponent_arr, p6new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p7.saveToFile("file7.txt");
		File file7 = new File("file7.txt");
		Polynomial p7new = new Polynomial(file7);
		if ( !(Arrays.equals(p7.coefficient_arr, p7new.coefficient_arr)) || !(Arrays.equals(p7.exponent_arr, p7new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p8.saveToFile("file8.txt");
		File file8 = new File("file8.txt");
		Polynomial p8new = new Polynomial(file8);
		if ( !(Arrays.equals(p8.coefficient_arr, p8new.coefficient_arr)) || !(Arrays.equals(p8.exponent_arr, p8new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p9.saveToFile("file9.txt");
		File file9 = new File("file9.txt");
		Polynomial p9new = new Polynomial(file9);
		if ( !(Arrays.equals(p9.coefficient_arr, p9new.coefficient_arr)) || !(Arrays.equals(p9.exponent_arr, p9new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p10.saveToFile("file10.txt");
		File file10 = new File("file10.txt");
		Polynomial p10new = new Polynomial(file10);
		if ( !(Arrays.equals(p10.coefficient_arr, p10new.coefficient_arr)) || !(Arrays.equals(p10.exponent_arr, p10new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p11.saveToFile("file11.txt");
		File file11 = new File("file11.txt");
		Polynomial p11new = new Polynomial(file11);
		if ( !(Arrays.equals(p11.coefficient_arr, p11new.coefficient_arr)) || !(Arrays.equals(p11.exponent_arr, p11new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p12.saveToFile("file12.txt");
		File file12 = new File("file12.txt");
		Polynomial p12new = new Polynomial(file12);
		if ( !(Arrays.equals(p12.coefficient_arr, p12new.coefficient_arr)) || !(Arrays.equals(p12.exponent_arr, p12new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p13.saveToFile("file13.txt");
		File file13 = new File("file13.txt");
		Polynomial p13new = new Polynomial(file13);
		if ( !(Arrays.equals(p13.coefficient_arr, p13new.coefficient_arr)) || !(Arrays.equals(p13.exponent_arr, p13new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p14.saveToFile("file14.txt");
		File file14 = new File("file14.txt");
		Polynomial p14new = new Polynomial(file14);
		if ( !(Arrays.equals(p14.coefficient_arr, p14new.coefficient_arr)) || !(Arrays.equals(p14.exponent_arr, p14new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
		
		p15.saveToFile("file15.txt");
		File file15 = new File("file15.txt");
		Polynomial p15new = new Polynomial(file15);
		if ( !(Arrays.equals(p15.coefficient_arr, p15new.coefficient_arr)) || !(Arrays.equals(p15.exponent_arr, p15new.exponent_arr)) ) System.out.println("There's an issue in saveToFile() method or constructor");
		else count++;
				
		if (count == 57) System.out.println("Passed all test cases!");
		else {
			int failed = 57 - count;
			System.out.println("Failed " + failed + "test cases.");
		}
	}
}