import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

public class johara_p3 {    
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        double[][] multiplyM1 = new double[0][];
        double[][] multiplyM2 = new double[0][];
        double[][] product;

        char mat1Num = 0;           //the # of which matrix to use
        char mat2Num = 0;

        File file1;
        File file2;
        String file1Name = "";      //puts together full name of file
        String file2Name = "";
        String firstM = "";         //name of "mat#" inputted
        String secondM = "";
        boolean secondNonexist = true;
        boolean bothExist =  false;
        
        while(!bothExist) {
            System.out.print("Enter the name of the first matrix you want to multiply\n");
            firstM = input.next();
            mat1Num = firstM.charAt(3);
            file1Name = "johara_mat" + mat1Num + ".txt";
            file1 = new File(file1Name);

            if (file1.exists()) {

                while(secondNonexist) {
                    System.out.print("Enter the name of the second matrix you want to multiply\n");
                    secondM = input.next();
                    mat2Num = secondM.charAt(3);
                    file2Name = "johara_mat" + mat2Num + ".txt";
                    file2 = new File(file2Name);

                    if (file2.exists()) {
                        secondNonexist = false;
                        bothExist = true;
                        multiplyM1 = makeArray(file1Name);
                        multiplyM2 = makeArray(file2Name);

                    } else {
                        System.out.print("This file does not exist.\n");
                    }//end if File 2 exists
                }//end second while
            }else{
                System.out.println("This file does not exist.\n");
            }//end if File 1 exists
        }//end main while

        if(((checkSize(multiplyM1)).charAt(2)) != ((checkSize(multiplyM2)).charAt(0))){
            System.out.println("These cannot be multipled together");
        }else{

            String newFile = "johara_p3_out" + mat1Num + mat2Num + ".txt";

            FileWriter writer = new FileWriter(newFile);
            product = multiplyArrays(multiplyM1, multiplyM2);
            writer.write("Product of Matrices " + mat1Num + " & " + mat2Num + "\n");
            for(int i=0; i < product.length; i++){
                for(int j=0; j < product[0].length; j++){
                    writer.write(product[i][j] + " ");
                }
                writer.write("\n");
            }
            writer.close();
        }

    }//end body

    public static double[][] multiplyArrays(double[][] mat1, double[][] mat2){

        int num1Rows = mat1.length;
        int num1Cols = mat1[0].length;
        int num2Cols = mat2[0].length;
        double[][] product = new double[num1Rows][num2Cols];

        for(int i=0; i < num1Rows; i++){
            for(int j=0; j < num2Cols; j++){
                for(int k=0; k < num1Cols; k++) {
                    product[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        return product;
    }

    public static String checkSize(double[][] matrix){
        String size = "";

        size = matrix.length + " " + matrix[0].length;

        return size;
    }

    public static double[][] makeArray(String file) throws FileNotFoundException {

        File toOpen = new File(file);
        Scanner scanner = new Scanner(toOpen);
        double[][] matrix = new double[0][];
        int numRows = 0;
        int numCols = 0;

        scanner.nextLine();  //skips "This is Matrix #"
        while (scanner.hasNextLine()) {
            String[] numbers = scanner.nextLine().split(" ");
            numRows++;
            numCols = Math.max(numCols, numbers.length);
        }
        scanner.close();
        scanner = new Scanner(toOpen);

        if (numRows > 0 && numCols > 0) {
            matrix = new double[numRows][numCols];

            int row = 0;

            scanner.nextLine();  //skips "This is Matrix #"
            while (scanner.hasNextLine()) {
                String[] numbers = scanner.nextLine().split(" |\\n");
                for (int col = 0; col < numbers.length; col++) {
                    matrix[row][col] = Double.parseDouble(numbers[col]);
                }
                row++;
            }
            scanner.close();
        }
        return matrix;
    }
}//end class
