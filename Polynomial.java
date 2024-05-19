public class Polynomial{
	double[] pol_arr; // field

	public Polynomial(){
		pol_arr = new double[1];
		pol_arr[0] = 0;
	}
	
	public Polynomial(double[] arr){
		pol_arr = new double[arr.length];
		for (int i=0; i < arr.length; i++){
			pol_arr[i] = arr[i];
		}
	}
	public Polynomial add(Polynomial to_add) {
		int max_len = Math.max(pol_arr.length, to_add.pol_arr.length);
		double [] new_arr = new double[max_len];
		for (int i=0; i < max_len; i++){
			if (i >= pol_arr.length) {new_arr[i] = to_add.pol_arr[i]; continue;}
			if (i >= to_add.pol_arr.length) {new_arr[i] = pol_arr[i]; continue;}
			new_arr[i] = to_add.pol_arr[i] + pol_arr[i];
		}
		Polynomial new_pol = new Polynomial(new_arr);
		return new_pol;
	}
	public double evaluate(double x) {
		double result = 0;
		for (int i=0; i < pol_arr.length; i++) {
			result = result + pol_arr[i]*Math.pow(x, i);
		}
		return result;
	}
	public boolean hasRoot(double maybe_root) {
		double eval = evaluate(maybe_root);
		if (eval == 0) { return true; }
		else { return false; }
	}
}