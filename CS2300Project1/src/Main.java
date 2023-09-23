import java.io.IOException;
import java.io.FileWriter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {


        //mat1            [rows][cols]
        FileWriter writer = new FileWriter("johara_mat1.txt");
        writer.write("This is Matrix 1\n");
        int[][]mat1 = new int[5][5];
        int matValue = 1;
        int numRows = mat1.length;
        int numCols = mat1[0].length;

        for(int i=0; i < numCols; i++){
            for(int j=0; j < numRows; j++){
                mat1[j][i] = matValue;
                matValue++;
                writer.write(mat1[j][i] + " ");
            }//end nested for
            writer.write("\n");
        }//end main for


        //mat2
        FileWriter writer2 = new FileWriter("johara_mat2.txt");
        writer2.write("This is Matrix 2\n");
        int[][]mat2 = new int[5][5];
        matValue = 2;

        for(int i=0; i < mat2.length; i++){
            for(int j=0; j < mat2[i].length; j++){
                mat2[i][j] = matValue;
                matValue += 3;
                writer2.write(mat2[i][j] + " ");
            }//end nested for
            writer2.write("\n");
        }//end main for


        //mat3
        FileWriter writer3 = new FileWriter("johara_mat3.txt");
        writer3.write("This is Matrix 3\n");
        int[][]mat3 = new int[2][4];
        matValue = 10;
        numRows = mat3.length;
        numCols = mat3[0].length;

        for(int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                mat3[i][j] = matValue;
                matValue += -2;
                writer3.write(mat3[i][j] + " ");
            }
            writer3.write("\n");
        }


        //mat4
        FileWriter writer4 = new FileWriter("johara_mat4.txt");
        writer4.write("This is Matrix 4\n");
        double[][]mat4 = new double[4][2];
        double mat4Value = -6;

       for(int i = 0; i < mat4.length; i++){
           for(int j = 0; j < mat4[i].length; j++){
               mat4[i][j] = mat4Value;
               mat4Value += 1.5;
               writer4.write(mat4[i][j] + " ");
           }
           writer4.write("\n");
       }

        writer.close();
        writer2.close();
        writer3.close();
        writer4.close();
    }//end body
}//end main