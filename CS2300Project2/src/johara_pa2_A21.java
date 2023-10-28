import java.util.Scanner;
import java.io.IOException;
import Jama.Matrix;

import java.io.File;
public class johara_pa2_A21 {
    public static void main(String[] args) throws IOException {



        File file = new File("C:\\GitHub\\CS2300\\CS2300Project2\\src\\input-A21.txt");
        Scanner input = new Scanner(file);

        System.out.print("This is the message to be encoded:\n");
        String normalMessage = input.nextLine();
        System.out.print(normalMessage);
        int numValues = normalMessage.length();
        int rows = 4;
        int cols = (int) Math.ceil((double) numValues / rows);
        int totalNumbers = rows * cols;

        double[] unicodeNums = new double[totalNumbers];

        for(int i=0; i<numValues; i++){                      //adds input to 1D array
            unicodeNums[i] = (double) normalMessage.codePointAt(i);
        }
        for(int i = numValues; i < totalNumbers; i++){
            unicodeNums[i] = 0.0;
        }

        Matrix matrixB = new Matrix(unicodeNums, rows);

        System.out.print("\n\nEncrypted Matrix B [" + rows + "x" + cols + "]"); //prints matrix B
        matrixB.print(3, 0);


        //hard-coding invertible matrix A
        double[] aNumbers = {1, -1, -1, 1, 2, -3, -5, 4, -2, -1, -2, 2, 3, -3, -1, 2};

        Matrix matrixATransposed = new Matrix(aNumbers, rows);
        Matrix matrixA = matrixATransposed.transpose();

        System.out.print("\nInvertible Matrix A [4x4]");
        matrixA.print(3, 0);

        System.out.print("\nMatrix C [" + rows + "x" + cols +"] Product of AB");
        Matrix matrixC = matrixA.times(matrixB);
        matrixC.print(3, 0);

        input.close();
    }
}









