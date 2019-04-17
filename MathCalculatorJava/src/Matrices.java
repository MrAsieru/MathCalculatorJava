public class Matrices {
  public static void Matrices(){ 
  }
  
  static Double matricesDeter(Integer[][] M, Integer f, Integer c) {
		Double result = 0.0;
		if(f== c && f == 2) {
			result = (double) ((M[0][0]*M[1][1]) - (M[0][1]*M[1][0]));
		} else if(f == c && f == 3) {
			result = (double) (((M[0][0]*M[1][1]*M[2][2])+(M[0][1]*M[1][2]*M[2][0])+(M[1][0]*M[2][1]*M[0][2])) - ((M[0][2]*M[1][1]*M[2][0])+(M[0][1]*M[1][0]*M[2][2])+(M[1][2]*M[2][1]*M[0][0])));
		} else if (f == c && f == 4) {
			Double tot = 0.0;
			for(int i = 1; i < 5; i++) {
				Integer[][] A = new Integer[3][3];
				if(i == 1) {
					Integer[][] C = {
							{M[1][1], M[1][2], M[1][3]}, 
							{M[2][1], M[2][2], M[2][3]},
							{M[3][1], M[3][2], M[3][3]}
					};
					A = C;
				} else if (i == 2) {
					Integer[][] C = {
							{M[0][1], M[0][2], M[0][3]}, 
							{M[2][1], M[2][2], M[2][3]},
							{M[3][1], M[3][2], M[3][3]}
					};
					A = C;
				} else if (i == 3) {
					Integer[][] C = {
							{M[0][1], M[0][2], M[0][3]}, 
							{M[1][1], M[1][2], M[1][3]},
							{M[3][1], M[3][2], M[3][3]}
					};
					A = C;
				} else if (i == 4) {
					Integer[][] C = {
							{M[0][1], M[0][2], M[0][3]}, 
							{M[1][1], M[1][2], M[1][3]},
							{M[2][1], M[2][2], M[2][3]}
					};					
					A = C;
				}
				
				tot = tot + Math.pow(-1, i+1)*M[i-1][0]*matricesDeter(A, 3, 3);
			}
			result = tot;
		}
		return result;
	}
}
