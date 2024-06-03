import java.io.*;
import java.util.Arrays;

public class Polynomial{
	double[] coefficient_arr; // field
	int[] exponent_arr;
	
	public Polynomial(){
		coefficient_arr = null;
		exponent_arr = null;
	}
	
	public Polynomial(double[] input_coefficient_arr, int[] input_exponent_arr){
		if (input_coefficient_arr == null && input_exponent_arr == null) {coefficient_arr = null; exponent_arr = null;}
		else if (input_coefficient_arr == null) { coefficient_arr = null; }
		else if (input_exponent_arr == null) { exponent_arr = null; }
		else {
			coefficient_arr = new double[input_exponent_arr.length];
			exponent_arr = new int[input_exponent_arr.length];
			for (int i=0; i < input_coefficient_arr.length; i++){
				coefficient_arr[i] = input_coefficient_arr[i];
				exponent_arr[i] = input_exponent_arr[i];
			} 
		}
	}
	
	public Polynomial(File filename) throws IOException {
		// things to fix: 
		//			exponent zero 				(done)
		// 			negative coefficient		(done)
		// 			x^1 = x						(not needed)
		//			1x = x						(not needed)
		// 			first coefficient negative	(done)
		
		BufferedReader input = new BufferedReader(new FileReader(filename)); 
		String str0 = input.readLine(); 
		if (str0 == null) { input.close(); coefficient_arr = null; exponent_arr = null; input.close(); }
		else {
		input.close(); 
		String str = str0.replace("-", "+-");
		String [] arr;
		if (str.charAt(0) == '+'){
			String str1 = str.substring(1, str.length());
			arr = str1.split("[+]");
		} else {
			arr = str.split("[+]"); 
		}
		coefficient_arr = new double[arr.length]; 
		exponent_arr = new int[arr.length]; 
		for (int i = 0; i < arr.length; i++){
			if (arr[i].contains("x")){
				coefficient_arr[i] = Double.parseDouble(arr[i].substring(0, arr[i].indexOf("x")));	
				exponent_arr[i] = Integer.parseInt(arr[i].substring(arr[i].indexOf("x")+1, arr[i].length()));
			}
			else{ 
				coefficient_arr[i] = Double.parseDouble(arr[i]); 
				exponent_arr[i] = 0; 
			}
		}
		}
	}
	
	public void saveToFile(String filename) throws IOException {
		// things to fix: 
		//			exponent zero 				(done)
		// 			negative coefficient		(done)
		// 			x^1 = x						(not needed)
		//			1x = x						(not needed)
		// 			first coefficient negative	(covered)
		BufferedWriter output = new BufferedWriter( new FileWriter(filename));
		if (coefficient_arr == null || exponent_arr == null) {output.close();  return;}
		for (int i =0; i < coefficient_arr.length; i++){
			if (i==0){ // checking if its first term (to not add +)
				if (coefficient_arr[i] == 0) {continue;} // if coefficient = 0, ignore this term
				if (exponent_arr[i] == 0) { output.write(Double.toString(coefficient_arr[i])); } // if exponent == 0, just write the coefficient
				else{output.write(Double.toString(coefficient_arr[i]) + "x" + Integer.toString(exponent_arr[i]));} // if the exponent nor coefficient is 0, write normally
			}
			else{ // if its not first term, always add + or -
				if (coefficient_arr[i] < 0){ // if the coefficient is negative
					output.write("-"); // add -
					if (exponent_arr[i] == 0) { output.write(Double.toString(-1*coefficient_arr[i])); } // checking if exponent == 0, then just write coefficient
					else {output.write(Double.toString(-1*coefficient_arr[i]) + "x" + Integer.toString(exponent_arr[i])); } // if the exponent is non zero
				} 
				else if (coefficient_arr[i] == 0){ // if the coefficient is negative, ignore this term
					continue;
				}
				else{ // if the coefficient is positive
				output.write("+");  // add +
				if (exponent_arr[i] == 0) { output.write(Double.toString(coefficient_arr[i])); } // checking if exponent == 0, then just write coefficient
				else {output.write(Double.toString(coefficient_arr[i]) + "x" + Integer.toString(exponent_arr[i])); } // if the exponent is non zero
				}
			}
		}
		output.close();
	}
	
	public int findMAX (int[] exp_arr){
		int max = 0;
		for (int i = 0; i < exp_arr.length; i++){
			if (exp_arr[i] > max){
				max = exp_arr[i];
			}
		}
		return max;
	}

	public Polynomial add(Polynomial to_add) {
		// strategy: get the maximum degree of both polynomials (max1 and max2)
		// get the max of max1 and max2
		// create 2 new arrays of lenght max (one for coff and one for exp)
		// loop through 1st polynomial and add the coff value to corresponding exp value in new array
		// loop through 2nd polynomial and do the same thing
		// loop through new polynomial and find the number of 0 coefficients
		// create a return array that has lenght of new array lenght - number of 0 coefficents
		// loop throuh new array again and if it doesnt have zero coefficient, add it to your return array
		
		if ((to_add.exponent_arr == null || to_add.coefficient_arr == null) && (exponent_arr == null || coefficient_arr == null)) {
			Polynomial new_pol = new Polynomial(null, null);
			return new_pol;
		}
		if (to_add.exponent_arr == null || to_add.coefficient_arr == null) { 
			Polynomial new_pol = new Polynomial(coefficient_arr, exponent_arr);
			return new_pol;
		}
		if (exponent_arr == null || coefficient_arr == null) {
			Polynomial new_pol = new Polynomial(to_add.coefficient_arr, to_add.exponent_arr);
			return new_pol;
		}
		
		int max1 = findMAX(exponent_arr);
		int max2 = findMAX(to_add.exponent_arr);
		int max = Math.max(max1, max2);
		double[] new_coefficient_arr = new double[max+1];
		int[] new_exponent_arr = new int[max+1];
		for (int i=0; i < exponent_arr.length; i++){
			new_exponent_arr[exponent_arr[i]] = exponent_arr[i];
			new_coefficient_arr[exponent_arr[i]] = new_coefficient_arr[exponent_arr[i]] + coefficient_arr[i];
		}
		for (int i=0; i < to_add.exponent_arr.length; i++){
			new_exponent_arr[to_add.exponent_arr[i]] = to_add.exponent_arr[i];
			new_coefficient_arr[to_add.exponent_arr[i]] = new_coefficient_arr[to_add.exponent_arr[i]] + to_add.coefficient_arr[i];
		}
		int count=0;
		
		for (int i=0; i < max+1; i++){
			if (new_coefficient_arr[i] == 0){
				count++;
			}
		}
		
		/*if (count == max+1) { 
			Polynomial new_pol = new Polynomial(null, null);
			return new_pol; 
		}*/
		
		int return_arr_index = 0;
		double[] return_coefficient_arr = new double[max+1-count];
		int[] return_exponent_arr = new int[max+1-count];
		for (int i=0; i < max+1; i++){
			if (new_coefficient_arr[i]!=0){
				return_coefficient_arr[return_arr_index] = new_coefficient_arr[i];
				return_exponent_arr[return_arr_index] = new_exponent_arr[i];
				return_arr_index++;
			}
		}
		Polynomial new_pol = new Polynomial(return_coefficient_arr, return_exponent_arr);
		return new_pol;
	}


	public double evaluate(double x) {
		if (coefficient_arr == null || exponent_arr == null) return 0;
		double result = 0;
		for (int i=0; i < coefficient_arr.length; i++){
			result = result + coefficient_arr[i]*Math.pow(x, exponent_arr[i]);
		}
		return result;
	}
	
	public boolean hasRoot(double maybe_root) {
		double eval = evaluate(maybe_root);
		if (eval == 0) { return true; }
		else { return false; }
	}
		
		
	public Polynomial multiply(Polynomial to_multiply) {
		// strategy: get the maximum degree of both polynomials (max1 and max2)
		// get the max = max1 + max2 + 1
		// create 2 new arrays of lenght max (one for coeff and one for exp)
		// loop through each pair of polynomial 1 and polynomial 2 terms 
		// 		add both exponents and both multiply coefficients
		// 		put the new exponent in its place in the new exponent array
		//   	put the new coefficient in the same index in new coefficient array, adding to its current value
		// now, loop through new array to find the number of zero coefficients
		// create 2 result arrays of size max - number of zero coefficients
		// loop through new array again and for each iteration, if a term doesnt have coeff 0, add it to result array like you did for add method
		
		if ((to_multiply.exponent_arr == null || to_multiply.coefficient_arr == null) || (exponent_arr == null || coefficient_arr == null) || to_multiply == null) {
			Polynomial new_pol = new Polynomial(null, null);
			return new_pol;
		}
	
		int max1 = findMAX(exponent_arr);
		int max2 = findMAX(to_multiply.exponent_arr);
		int max = max1 + max2 + 1;
		double[] new_coefficient_arr = new double[max];
		int[] new_exponent_arr = new int[max];
		for (int i=0; i < exponent_arr.length; i++){
			for (int j=0; j < to_multiply.exponent_arr.length; j++){
				int new_exp = exponent_arr[i]+to_multiply.exponent_arr[j];
				double new_cof = coefficient_arr[i]*to_multiply.coefficient_arr[j];
				new_exponent_arr[new_exp] = new_exp;
				new_coefficient_arr[new_exp] = new_coefficient_arr[new_exp] + new_cof;
			}
		}
		int count = 0;
		for (int i=0; i < max; i++){
			if (new_coefficient_arr[i] == 0){
				count++;
			}
		}
		
		if (count == max+1) { 
			Polynomial new_pol = new Polynomial(null, null);
			return new_pol;
		}
		
		double[] return_coefficient_arr = new double[max-count];
		int[] return_exponent_arr = new int[max-count];
		int return_arr_index = 0;
		for (int i=0; i < max; i++){
			if (new_coefficient_arr[i] != 0){
				return_coefficient_arr[return_arr_index] = new_coefficient_arr[i];
				return_exponent_arr[return_arr_index] = new_exponent_arr[i];
				return_arr_index++;
			}
		}
		Polynomial new_pol = new Polynomial(return_coefficient_arr, return_exponent_arr);
		return new_pol;
	}
	
}