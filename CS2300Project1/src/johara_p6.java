import java.io.IOException;
import java.io.FileWriter;

public class johara_p6 {
    public static void main(String[] args) throws IOException {


        //mat1            [rows][cols]
        double[][]mat1 = new double[5][5];
        double matValue = 1;
        double numRows = mat1.length;
        double numCols = mat1[0].length;

        for(int i=0; i < numCols; i++){
            for(int j=0; j < numRows; j++){
                mat1[j][i] = matValue;
                System.out.print(" ");
                matValue++;
            }//end nested for
            System.out.print("\n");
        }//end main for


        //mat2
        double[][]mat2 = new double[5][5];
        matValue = 2;

        for(int i=0; i < mat2.length; i++){
            for(int j=0; j < mat2[i].length; j++){
                mat2[i][j] = matValue;
                System.out.print(" ");
                matValue += 3;
            }//end nested for
            System.out.print("\n");
        }//end main for


        //mat3
        double[][]mat3 = new double[2][4];
        matValue = 10;
        numRows = mat3.length;
        numCols = mat3[0].length;

        for(int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                mat3[i][j] = matValue;
                System.out.print(" ");
                matValue += -2;
            }
            System.out.print("\n");
        }


        //mat4
        double[][]mat4 = new double[4][2];
        double mat4Value = -6;

        for(int i = 0; i < mat4.length; i++){
            for(int j = 0; j < mat4[i].length; j++){
                mat4[i][j] = mat4Value;
                System.out.print(" ");
                mat4Value += 1.5;
            }
            System.out.print("\n");
        }
        
        double[][] mat1T = transpose(mat1);
        double[][] mat2T = transpose(mat2);
        double[][]mat3T = transpose(mat3);
        double[][]mat4T = transpose(mat4);


        FileWriter writer1T = new FileWriter("johara_p6_mat1.txt");

        for(int i = 0; i < mat1T.length; i++){
            for(int j = 0; j < mat1T[i].length; j++){
                writer1T.write(mat1T[i][j] + " ");
            }
            writer1T.write("\n");
        }

        FileWriter writer2T = new FileWriter("johara_p6_mat2.txt");

        for(int i = 0; i < mat2T.length; i++){
            for(int j = 0; j < mat2T[i].length; j++){
                writer2T.write(mat2T[i][j] + " ");
            }
            writer2T.write("\n");
        }

        FileWriter writer3T = new FileWriter("johara_p6_mat3.txt");

        for(int i = 0; i < mat3T.length; i++){
            for(int j = 0; j < mat3T[i].length; j++){
                writer3T.write(mat3T[i][j] + " ");
            }
            writer3T.write("\n");
        }

        FileWriter writer4T = new FileWriter("johara_p6_mat4.txt");

        for(int i = 0; i < mat1T.length; i++){
            for(int j = 0; j < mat4T[i].length; j++){
                writer4T.write(mat4T[i][j] + " ");
            }
            writer4T.write("\n");
        }
        writer1T.close();
        writer2T.close();
        writer3T.close();
        writer4T.close();

    }//end body
    
    public static double[][] transpose(double[][] matrix){
        double[][] done = new double[matrix[0].length][matrix.length];
        
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                done[i][j] = matrix[j][i];
            }
        }
        
        return done;
    }

}//end class