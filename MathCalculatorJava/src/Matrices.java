public class Matrices {
  public static void Matrices(){ 
  }
  
  static Double Determinante(Integer[][] M, Integer f, Integer c) {
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
				
				tot = tot + Math.pow(-1, i+1)*M[i-1][0]*Determinante(A, 3, 3);
			}
			result = tot;
		}
		return result;
	}
	
	static Integer[][] Invertida(Integer[][] M) {
		if(M[0].length == M[1].length && M[1].length == 3) {
			if(Determinante(M, 3, 3) != 0) {
				return M/Determinante(M, 3, 3);
			} else {
				return null;	
			}
		}		
	}
	
	static Integer[][] Adjunta(Integer[][] M) {
		Integer[][] A = Transpuesta(M);
		if(M[0].length == M[1].length && M[1].length == 3) {
			return Integer[][] B = {
				{Determinante(Integer[][] {{M[1][1], M[1][2]}, {M[2][1], M[2][2]}}, 2, 2), -Determinante(Integer[][] {{M[0][1], M[0][2]}, {M[2][1], M[2][2]}}, 2, 2), Determinante(Integer[][] {{M[0][1], M[0][2]}, {M[1][1], M[1][2]}}, 2, 2)},
				{{-Determinante(Integer[][] {{M[0][1], M[0][2]}, {M[2][1], M[2][2]}}, 2, 2), Determinante(Integer[][] {{M[0][0], M[0][2]}, {M[2][0], M[2][2]}}, 2, 2), -Determinante(Integer[][] {{M[0][0], M[0][1]}, {M[2][0], M[2][1]}}, 2, 2)}},
				{Determinante(Integer[][] {{M[0][1], M[0][2]}, {M[1][1], M[1][2]}}, 2, 2), -Determinante(Integer[][] {{M[0][0], M[0][2]}, {M[1][0], M[1][2]}}, 2, 2), Determinante(Integer[][] {{M[0][0], M[0][1]}, {M[1][0], M[1][1]}}, 2, 2)}
			};
		}
	}
	
	static Integer[][] Transpuesta(Integer[][] M) {
		if(M[0].length == M[1].length && M[1].length == 3){
			return Integer[][] A = {
			{M[0][0], M[1][0]}, M[2][0],
			{M[0][1], M[1][1], M[2][1]},
			{M[0][2], M[1][2], M[2][2]}
		};
		}		
	}
}
