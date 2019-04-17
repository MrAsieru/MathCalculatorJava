import java.util.Arrays;

public class Matrices {
  public Matrices(){ 
  }
  
  static Double Determinante(Double[][] M) {
	  System.out.println("Determinante: "+Arrays.deepToString(M));
		Double result = 0.0;
		if(M.length == M[0].length && M[0].length == 2) {
			result = M[0][0]*M[1][1]-M[0][1]*M[1][0];
		} else if(M.length == M[0].length && M[0].length == 3) {
			result = M[0][0]*Determinante(Minor(M, 1))-M[1][0]*Determinante(Minor(M, 4))+M[2][0]*Determinante(Minor(M, 7));
		} else if (M.length == M[0].length && M[0].length == 4) {			
			result = M[0][0]*Determinante(Minor(M, 1))-M[1][0]*Determinante(Minor(M, 5))+M[2][0]*Determinante(Minor(M, 9))-M[3][0]*Determinante(Minor(M, 13));
		}
		return result;
	}
	
	static Double[][] Invertida(Double[][] M) {
		System.out.println("Invertida: "+Arrays.deepToString(M));
		if(M.length == M[0].length && M[0].length == 3) {
			if(Determinante(M) != 0) {
				Double[][] B = new Double[3][3];
				Double[][] A = Adjunta(Transpuesta(M));
				Double Deter = Determinante(M);
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						B[i][j] = A[i][j]/Deter; 
					}
				}
				return B;
			} else {
				return null;	
			}
		}
		return null;		
	}
	
	static Double[][] Adjunta(Double[][] M) {
		System.out.println("Adjunta: "+Arrays.deepToString(M));
		if(M.length == M[0].length && M[0].length == 3) {
			Double[] B = new Double[9];
			for(int i = 0; i < 9; i++) {
				B[i] = Determinante(Minor(M, i+1));
			}
			return new Double[][] {
				{B[0], -B[1], B[2]},
				{-B[3], B[4], -B[5]},
				{B[6], -B[7], B[8]}
			};			
		}
		return null;
	}
	
	static Double[][] Transpuesta(Double[][] M) {
		System.out.println("Transpuesta: "+Arrays.deepToString(M));
		if(M.length == M[0].length && M[0].length == 3){
			return new Double[][] {
			{M[0][0], M[1][0], M[2][0]},
			{M[0][1], M[1][1], M[2][1]},
			{M[0][2], M[1][2], M[2][2]}
		};
		}
		return null;
	}
	
	static Double[][] Minor(Double[][] M, Integer intMinor){
		System.out.println("Minor: "+Arrays.deepToString(M));
		if(M.length == M[0].length && M[0].length == 2) {
			switch(intMinor) {
			case 1:
				Double[][] A1 = {
						{M[1][1]},						
					};
				return A1;
			case 2:
				Double[][] A2 = {
						{M[1][0]},						
					};
				return A2;
			case 3:
				Double[][] A3 = {
						{M[0][1]},						
					};
				return A3;
			case 4:
				Double[][] A4 = {
						{M[0][0]},						
					};
				return A4;
			}			
		} else if (M.length == M[0].length && M[0].length == 3) {
			switch (intMinor) {
			case 1:
				Double[][] A1 = {
						{M[1][1], M[1][2]},
						{M[2][1], M[2][2]}						
					};
				return A1;				
			case 2:
				Double[][] A2 = {
						{M[1][0], M[1][2]},
						{M[2][0], M[2][2]}						
					};
				return A2;
			case 3:
				Double[][] A3 = {
						{M[1][0], M[1][1]},
						{M[2][0], M[2][1]}						
					};
				return A3;
			case 4:
				Double[][] A4 = {
						{M[0][1], M[0][2]},
						{M[2][1], M[2][2]}						
					};
				return A4;
			case 5:
				Double[][] A5 = {
						{M[0][0], M[0][2]},
						{M[2][0], M[2][2]}						
					};
				return A5;
			case 6:
				Double[][] A6 = {
						{M[0][0], M[0][1]},
						{M[2][0], M[2][1]}						
					};
				return A6;
			case 7:
				Double[][] A7 = {
						{M[0][1], M[0][2]},
						{M[1][1], M[1][2]}						
					};
				return A7;
			case 8:
				Double[][] A8 = {
						{M[0][0], M[0][2]},
						{M[1][0], M[1][2]}						
					};
				return A8;
			case 9:
				Double[][] A9 = {
						{M[0][0], M[0][1]},
						{M[1][0], M[1][1]}						
					};
				return A9;
			}
		} else if(M.length == M[0].length && M[0].length == 4) {
			switch (intMinor) {
			case 1:
				Double[][] A1 = {
						{M[1][1], M[1][2], M[1][3]},
						{M[2][1], M[2][2], M[2][3]},
						{M[3][1], M[3][2], M[3][3]}
					};
				return A1;
			case 2:
				Double[][] A2 = {
						{M[1][0], M[1][2], M[1][3]},
						{M[2][0], M[2][2], M[2][3]},
						{M[3][0], M[3][2], M[3][3]}
					};
				return A2;
			case 3:
				Double[][] A3 = {
						{M[1][0], M[1][1], M[1][3]},
						{M[2][0], M[2][1], M[2][3]},
						{M[3][0], M[3][1], M[3][3]}
					};
				return A3;
			case 4:
				Double[][] A4 = {
						{M[1][0], M[1][1], M[1][2]},
						{M[2][0], M[2][1], M[2][2]},
						{M[3][0], M[3][1], M[3][2]}
					};
				return A4;
			case 5:
				Double[][] A5 = {
						{M[0][1], M[0][2], M[0][3]},
						{M[2][1], M[2][2], M[2][3]},
						{M[3][1], M[3][2], M[3][3]}
					};
				return A5;
			case 6:
				Double[][] A6 = {
						{M[0][0], M[0][2], M[0][3]},
						{M[2][0], M[2][2], M[2][3]},
						{M[3][0], M[3][2], M[3][3]}
					};
				return A6;
			case 7:
				Double[][] A7 = {
						{M[0][0], M[0][1], M[0][3]},
						{M[2][0], M[2][1], M[2][3]},
						{M[3][0], M[3][1], M[3][3]}
					};
				return A7;
			case 8:
				Double[][] A8 = {
						{M[0][0], M[0][1], M[0][2]},
						{M[2][0], M[2][1], M[2][2]},
						{M[3][0], M[3][1], M[3][2]}
					};
				return A8;
			case 9:
				Double[][] A9 = {
						{M[0][1], M[0][2], M[0][3]},
						{M[1][1], M[1][2], M[1][3]},
						{M[3][1], M[3][2], M[3][3]}
					};
				return A9;
			case 10:
				Double[][] A10 = {
						{M[0][0], M[0][2], M[0][3]},
						{M[1][0], M[1][2], M[1][3]},
						{M[3][0], M[3][2], M[3][3]}
					};
				return A10;
			case 11:
				Double[][] A11 = {
						{M[0][0], M[0][1], M[0][3]},
						{M[1][0], M[1][1], M[1][3]},
						{M[3][0], M[3][1], M[3][3]}
					};
				return A11;
			case 12:
				Double[][] A12 = {
						{M[0][0], M[0][1], M[0][2]},
						{M[1][0], M[1][1], M[1][2]},
						{M[3][0], M[3][1], M[3][2]}
					};
				return A12;
			case 13:
				Double[][] A13 = {
						{M[0][1], M[0][2], M[0][3]},
						{M[1][1], M[1][2], M[1][3]},
						{M[2][1], M[2][2], M[2][3]}
					};
				return A13;
			case 14:
				Double[][] A14 = {
						{M[0][0], M[0][2], M[0][3]},
						{M[1][0], M[1][2], M[1][3]},
						{M[2][0], M[2][2], M[2][3]}
					};
				return A14;
			case 15:
				Double[][] A15 = {
						{M[0][0], M[0][1], M[0][3]},
						{M[1][0], M[1][1], M[1][3]},
						{M[2][0], M[2][1], M[2][3]}
					};
				return A15;
			case 16:
				Double[][] A16 = {
						{M[0][0], M[0][1], M[0][2]},
						{M[1][0], M[1][1], M[1][2]},
						{M[2][0], M[2][1], M[2][2]}
					};
				return A16;
			}
			
			
		}
		return null;
	}
}
