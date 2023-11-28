import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Jama.Matrix;

public class johara_pa3_part1prgrm {
    public static void main(String[] args) throws IOException{

        //numbers.txt is a list of all numbers in D and E separated by new lines
        File file = new File("C:\\GitHub\\CS2300\\CS2300Project3\\src\\numbers.txt");
        Scanner input = new Scanner(file);

        //MATRIX D
        double[] numbersD = new double[9];

        double value = 0;
        for(int i = 0; i < numbersD.length; i++){
            value = input.nextDouble();
            numbersD[i] = value;
        }
        Matrix matrixD = new Matrix(numbersD, 3);
        System.out.print("Matrix D:");
        matrixD.print(3, 2);

        //MATRIX E
        double[] numbersE = new double[3];
        for(int i = 0; i < numbersE.length; i++){
            numbersE[i] = input.nextDouble();
        }
        Matrix matrixE = new Matrix(numbersE, 3);
        System.out.print("Matrix E:");
        matrixE.print(3, 0);

        //3D ID Matrix
        Matrix idMatrix = new Matrix(new double[][] {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        });
        System.out.print("3D ID Matrix:");
        idMatrix.print(3, 0);

        //Subtract I - D
        Matrix iMinusD = idMatrix.minus(matrixD);
        System.out.print("Matrix I - D:");
        iMinusD.print(3, 2);

        //Inverse of I-D
        Matrix inverseIminD = iMinusD.inverse();
        System.out.print("Inverse of I - D:");
        inverseIminD.print(3, 2);

        //Multiply Inverse by E
        Matrix matrixX = inverseIminD.times(matrixE);
        System.out.print("Output Matrix X:");
        matrixX.print(3, 1);


    }
}
