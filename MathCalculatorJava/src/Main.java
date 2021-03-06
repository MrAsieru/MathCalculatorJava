import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
	public static void main (String[] args) {
		if(args[0].equals("-h")) {
			Ayuda(1);
		} else if(args[0].equals("-m")) {
			if(args[1].equals("-h")) {
				Ayuda(2);
			} else if(args[1].equals("-d")) {
				Double[][] M = new Double[Integer.parseInt(args[2])] [Integer.parseInt(args[3])];
				
				Integer c = 4;
				for(int i = 0; i < Integer.parseInt(args[2]); i++) {
					for(int j = 0; j < Integer.parseInt(args[3]); j++) {
						M[i][j] = Double.parseDouble(args[c]);
						c++;
					}
				}
				Double result = Matrices.Determinante(M);
				if(Integer.parseInt(args[2]) == Integer.parseInt(args[2]) && Integer.parseInt(args[2]) == 2) {
					System.out.println("\t    |\t"+M[0][0]+"\t"+M[0][1]+"\t|");
					System.out.println("\t|M|=|\t"+M[1][0]+"\t"+M[1][1]+"\t|= "+result);
				} else if(Integer.parseInt(args[2]) == Integer.parseInt(args[2]) && Integer.parseInt(args[2]) == 3) {
					System.out.println("\t    |\t"+M[0][0]+"\t"+M[0][1]+"\t"+M[0][2]+"\t|");
					System.out.println("\t|M|=|\t"+M[1][0]+"\t"+M[1][1]+"\t"+M[1][2]+"\t|= "+result);
					System.out.println("\t    |\t"+M[2][0]+"\t"+M[2][1]+"\t"+M[2][2]+"\t|");
				} else if(Integer.parseInt(args[2]) == Integer.parseInt(args[2]) && Integer.parseInt(args[2]) == 4) {
					System.out.println("\t    |\t"+M[0][0]+"\t"+M[0][1]+"\t"+M[0][2]+"\t"+M[0][3]+"\t|");
					System.out.println("\t|M|=|\t"+M[1][0]+"\t"+M[1][1]+"\t"+M[1][2]+"\t"+M[1][3]+"\t|= "+result);
					System.out.println("\t    |\t"+M[2][0]+"\t"+M[2][1]+"\t"+M[2][2]+"\t"+M[2][3]+"\t|");
					System.out.println("\t    |\t"+M[3][0]+"\t"+M[3][1]+"\t"+M[3][2]+"\t"+M[3][3]+"\t|");
				}
			} else if (args[1].equals("-i")) {
				Double[][] M = new Double[Integer.parseInt(args[2])] [Integer.parseInt(args[3])];
				
				Integer c = 4;
				for(int i = 0; i < Integer.parseInt(args[2]); i++) {
					for(int j = 0; j < Integer.parseInt(args[3]); j++) {
						M[i][j] = Double.parseDouble(args[c]);
						c++;
					}
				}
				Double D = Matrices.Determinante(M);
				Double[][] R = Matrices.Invertida(M);
				System.out.println("\t    |\t"+M[0][0]+"\t"+M[0][1]+"\t"+M[0][2]+"\t|");
				System.out.println("\t M =|\t"+M[1][0]+"\t"+M[1][1]+"\t"+M[1][2]+"\t|");
				System.out.println("\t    |\t"+M[2][0]+"\t"+M[2][1]+"\t"+M[2][2]+"\t|");				
				System.out.println("\t      |\t"+R[0][0]*D+"/"+D+"\t"+R[0][1]*D+"/"+D+"\t"+R[0][2]*D+"/"+D+"\t|   |\t"+R[0][0]+"\t"+R[0][1]+"\t"+R[0][2]+"\t|");
				System.out.println("\t M⁻¹ =|\t"+R[1][0]*D+"/"+D+"\t"+R[1][1]*D+"/"+D+"\t"+R[1][2]*D+"/"+D+"\t| = |\t"+R[1][0]+"\t"+R[1][1]+"\t"+R[1][2]+"\t|");
				System.out.println("\t      |\t"+R[2][0]*D+"/"+D+"\t"+R[2][1]*D+"/"+D+"\t"+R[2][2]*D+"/"+D+"\t|   |\t"+R[2][0]+"\t"+R[2][1]+"\t"+R[2][2]+"\t|");
			} else {
				System.out.println("-d : Determinante max 4x4 Ex. -m -d <filas> <columnas> (a11) (a12) (a13) ... (afc)");
			}
		}
	}
	
	
	static void Ayuda (Integer i){
		switch(i) {
			case 1:
				System.out.println("Math Calculator help:");
				System.out.println("-m : Matrices");
				break;
			case 2:
				System.out.println("-d : Determinante max 4x4 Ex. -m -d <filas> <columnas> (a11) (a12) (a13) ... (afc) \n"+
					   "-i : Matriz invertida 3x3 Ex -m -i (a11) (a12) (a13) ... (afc)");
				break;
			case 3:
				break;
				
		}
	}
}
