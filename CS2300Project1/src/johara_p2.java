import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

public class johara_p2 {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        double[][] addM1 = new double[0][];
        double[][] addM2 = new double[0][];
        double[][] sum;

        char mat1Num = 0;
        char mat2Num = 0;

        File file1;
        File file2;
        String file1Name = "";
        String file2Name = "";
        String firstM = "";
        String secondM = "";
        boolean secondNonexist = true;
        boolean bothExist =  false;
        while(!bothExist) {
            System.out.print("Enter the name of the first matrix you want to add to\n");
             firstM = input.next();
             mat1Num = firstM.charAt(3);
             file1Name = "johara_mat" + mat1Num + ".txt";
             file1 = new File(file1Name);

                 if (file1.exists()) {

                     while(secondNonexist) {
                         System.out.print("Enter the name of the second matrix you want to be added\n");
                         secondM = input.next();
                         mat2Num = secondM.charAt(3);
                         file2Name = "johara_mat" + mat2Num + ".txt";
                         file2 = new File(file2Name);

                         if (file2.exists()) {
                             secondNonexist = false;
                             bothExist = true;
                             addM1 = makeArray(file1Name);
                             addM2 = makeArray(file2Name);

                         } else {
                             System.out.print("This file does not exist.\n");
                         }//end if File 2 exists
                     }//end second while
                 }else{
                         System.out.println("This file does not exist.\n");
                 }//end if File 1 exists
             }//end main while

        if(!(checkSize(addM1)).equals(checkSize(addM2))){
            System.out.println("These cannot be added together");
        }else{

            String newFile = "johara_p2_out" + mat1Num + mat2Num + ".txt";

            FileWriter writer = new FileWriter(newFile);
            sum = addArrays(addM1, addM2);
            writer.write("Sum of Matrices " + mat1Num + " & " + mat2Num + "\n");
            for(int i=0; i < sum.length; i++){
                for(int j=0; j < sum[0].length; j++){
                    writer.write(sum[i][j] + " ");
                }
                writer.write("\n");
            }
            writer.close();
        }

    }//end body

    public static double[][] addArrays(double[][] mat1, double[][] mat2){

        int numRows = mat1.length;
        int numCols = mat1[0].length;
        double[][] sum = new double[numRows][numCols];

        for(int i=0; i < numRows; i++){
            for(int j=0; j < numCols; j++){
                sum[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        return sum;
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
