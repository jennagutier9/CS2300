import java.util.Scanner;
import java.io.IOException;
//import Jama.Matrix;
import org.ejml.data.DMatrixRMaj;
import org.ejml.simple.SimpleMatrix;

public class johara_pa2_B2 {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a value for Flow A: ");
        double flowA = input.nextInt();

        System.out.println("Please enter a value for Flow B: ");
        double flowB = input.nextInt();

        System.out.println("Please enter a value for Flow C: ");
        double flowC = input.nextInt();

        System.out.println("Please enter a value for Flow D: ");
        double flowD = input.nextInt();

        SimpleMatrix matrixB = new SimpleMatrix(new DMatrixRMaj(new double[][]{
                {0, 0, 1, -1, flowA},
                {0, -1, 1, 0, flowB},
                {1, -1, 0, 0, flowC},
                {1, 0, 0, -1, flowD},
        }));

        System.out.println("Augmented Matrix of Traffic Flow:\n");
        matrixB.getMatrix().print("%3.0f");

        int rows = 4;
        int cols = 5;

        
        for(int i = 0; i < rows; i++) {
            int pivotCol = -1;
            for (int j = 0; j < cols; j++) {
                if (matrixB.get(i, j) != 0){
                    pivotCol = j;
                    break;
                }
            }
            if(pivotCol != -1){
                double pivotVal = matrixB.get(i, pivotCol);

                for(int k = 0; k < cols; k++){
                    matrixB.set(i, k, matrixB.get(i, k) / pivotVal);
                }

                for(int l = i + 1; l < rows; l++){
                    double factor = matrixB.get(l, pivotCol);
                    for(int m = 0; m < cols; m++){
                        matrixB.set(l, m, matrixB.get(l, m) - factor * matrixB.get(i, m));
                    }
                }
            }
        }

        System.out.println("\n\nRow Echelon Form:");
        matrixB.getMatrix().print("%3.0f");

        SimpleMatrix solution = matrixB.extractMatrix(0, rows, cols -1, cols);

        System.out.println("\n\nSolution:");
        solution.getMatrix().print("%3.0f");
        input.close();
    }
}
