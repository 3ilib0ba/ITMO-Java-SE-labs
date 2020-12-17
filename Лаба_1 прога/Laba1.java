public class Laba1{
	public static void ddddd_go(int[] a, double[] b){
			double [][]d = new double[12][15];
			for(int i = 0; i < 12; i++){
				for(int j = 0; j < 15; j++){
					if (a[i] == 6){
						d[i][j] = Math.pow(Math.cos(b[j] * b[j] + 4.0), Math.sin(Math.tan(b[j])) / 4.0);
					}
					else if ((a[i] == 2) || (a[i] == 4) || (a[i] == 10) || (a[i] == 12) || (a[i] == 22) || (a[i] == 24)) {
						d[i][j] = Math.pow(Math.pow(Math.asin((b[j] - 1.0) / 26.0) / 6.0, Math.pow(b[j], 1.0 / 3.0)) * (1.0 - Math.pow(Math.PI * (b[j] + 0.25), 1.0 / 3.0)), 3.0);
					}
					else{
						d[i][j] = Math.pow((2.0 / 3.0) * (1.0 - Math.pow(Math.pow((0.5 - (0.25 / Math.pow(b[j] - 1.0, b[j]))) / Math.pow(2.0 - b[j], 3.0), 3.0), 3.0 * Math.pow((Math.atan((b[j] - 1.0) / 26.0) + 1.0) / Math.cos(b[j]), 3.0))), Math.tan(Math.exp(Math.pow(3.0 * (b[j] + 0.25), 3.0))));
					}
					
					System.out.printf("%.5f \n", d[i][j]);
				}
			}
		}
	public static void main(String[] args){
		int counter = 2;
		int k = 0;
		int []d = new int[12];
		double x[] = new double[15];
		while (counter <= 24){
			d[k] = counter;
			k += 1;
			counter += 2;
		}
		for (int i = 0; i < 15; i++){
			x[i] = Math.random() * 26.0 - 14.0;
		}

		ddddd_go(d, x);
	}
}