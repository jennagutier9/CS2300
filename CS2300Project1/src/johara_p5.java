import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

public class johara_p5 {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        String[] letters = {"r", "s", "u", "v", "w"};


        int[] dot1;
        int[] dot2;
        String vector1 = "";
        String vector2 = "";

        boolean secondNonExist = false;
        boolean bothExist = false;
        while(!bothExist) {
            System.out.println("Please enter the vector you would like in the dot product: r, s, u, v, w");
             vector1 = input.next();

            for(int i=0; i < letters.length; i++){
                if(vector1.charAt(0) == (letters[i]).charAt(0)){
                    secondNonExist = true;
                }
            }

            if(secondNonExist) {

                while (secondNonExist) {
                    System.out.println("Please enter the other vector you would like in the dot product: r, s, u, v, w");
                    vector2 = input.next();

                    for (int i = 0; i < letters.length; i++) {
                        if (vector2.charAt(0) == (letters[i]).charAt(0)) {
                            secondNonExist = false;
                            bothExist = true;
                        }
                    }
                    if(secondNonExist){
                        System.out.println("Invalid second vector. ");
                    }
                }
            }else{
                System.out.println("Invalid first vector.");
            }
        }//end exist while

        dot1 = checkVector(vector1);
        dot2 = checkVector(vector2);

        int product = (dot1[0] * dot2[0]) + (dot1[1] * dot2[1]);

        String file = "johara_p5_out" + vector1 + vector2 + ".txt";
        FileWriter writer = new FileWriter(file);
        writer.write("Dot product of " + vector1 + " & " + vector2 + " = " + product);

        writer.close();
    }//end body

    public static int[] checkVector(String vector){
        int[] dot = new int[0];
        int[] r = {-1, -2};
        int[] s = {-3, 3};
        int[] u = {2, -1};
        int[] v = {3, 1};
        int[] w = {1, 3};

        if(vector.equals("r")){
            dot = r;
        }else if(vector.equals("s")){
            dot = s;
        }else if(vector.equals("u")){
            dot = u;
        }else if(vector.equals("v")){
            dot = v;
        }else if(vector.equals("w")){
            dot = w;
        }

        return dot;
    }
}
