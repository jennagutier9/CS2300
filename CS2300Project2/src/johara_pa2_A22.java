import java.util.Scanner;
import java.io.IOException;
import Jama.Matrix;
import java.io.File;
public class johara_pa2_A22 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\GitHub\\CS2300\\CS2300Project2\\src\\input-A22.txt");
        Scanner input = new Scanner(file);

        System.out.print("Values to be decoded:\n");
        String normalMessage = input.nextLine();
        System.out.print(normalMessage);

        input.close();


        double[] unicodeNums = new double[28];

        input = new Scanner(file);
        int index = 0;
        while(input.hasNext()){
            unicodeNums[index] = input.nextDouble();
            index++;
        }
        index = index;

        int numValues = index;
        int rows = 4;
        int cols = (int) Math.ceil((double) numValues / rows);
        int totalNumbers = rows * cols;

        for(int i = numValues; i < totalNumbers; i++){          //
            unicodeNums[i] = 0.0;
        }

        System.out.print("\n\nEncrypted Matrix B [" + rows + "x" + cols + "]"); //prints matrix B
        Matrix matrixB = new Matrix(unicodeNums, rows);
        matrixB.print(3, 0);

        double[] aNumbers = {1, -1, -1, 1, 2, -3, -5, 4, -2, -1, -2, 2, 3, -3, -1, 2};

        Matrix matrixATransposed = new Matrix(aNumbers, rows);      //transpose A since it was added by row instead of by column
        Matrix matrixA = matrixATransposed.transpose();

        System.out.print("Matrix A Inverse");                   //get inverse of A and print matrix
        Matrix matrixAInverse = matrixA.inverse();
        matrixAInverse.print(3, 0);

        System.out.print("Matrix C [" + rows + "x" + cols +"] Product of AB");     //multiply AB to get C and print matrix
        Matrix matrixC = matrixA.times(matrixB);
        matrixC.print(3, 0);

        System.out.print("Matrix B from A inverse multiplied by C");    //multiply A invers by C to get B and print matrix
        Matrix matBAgain = matrixAInverse.times(matrixC);
        matBAgain.print(3, 0);

        double[] unicNumsAgain = new double[numValues];         //used for moving values from matrix to array
        index = 0;
        rows = matBAgain.getRowDimension();
        cols = matBAgain.getColumnDimension();

        for(int i = 0; i < cols; i++){                          //puts each value of matrix b into 1d array by column
            for(int j = 0; j < rows; j++){
                if(index < numValues){
                    unicNumsAgain[index] = matBAgain.get(j, i);
                    index++;

                }
            }
        }

        System.out.print("Encoded Unicode Message:\n");         //prints encoded message as a line
        for(int i = 0; i < unicNumsAgain.length; i++){
            int roundedNum = (int) Math.round(unicNumsAgain[i]);
            System.out.print( roundedNum + " ");
        }

        StringBuilder makeString = new StringBuilder();         //string builder

        for(int i = 0; i < unicNumsAgain.length; i++){         //turns each number into its character and appends to string builder
            char character = (char) Math.round(unicNumsAgain[i]);
            makeString.append(character);
        }

        String decoded = makeString.toString();             //converts characters in stringbuilder to String to print
        System.out.println("\n\nDecoded Message:\n" + decoded);

    }
}
