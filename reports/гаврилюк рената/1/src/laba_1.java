import java.util.Random;
import java.util.Scanner;

class Lab_1 {
    public void randomOutput(int N) {
        Random rand = new Random();
        for(int i = 0; i < N; i++) {
            System.out.println(rand.nextInt(100));
        }
        System.out.println();
    }

    public void printMatrix (double[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public double[][] transpose (double[][] matrix) {
        double[][] transposedMatrix = new double[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    public String abbreviate(String str) {
        String abbreviate = "";
        if(!str.isEmpty()) {
            str.trim();
            while(str.contains("  ")) {
                String replace = str.replace("  ", " ");
                str = replace;
            }

            for (String word : str.split(" ", (str.replaceAll("[^ ]", "").length() + 1))) {
                abbreviate += word.substring(0, 1);
            }
        }
        return abbreviate;
    }

    public static void main(String[] args) { 
        Lab_1 contr = new Lab_1();
        
        System.out.println("Task 1");    
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number : ");
        contr.randomOutput(in.nextInt());

        System.out.println("Task 2");
        System.out.print("Enter num rows : ");
        int N = in.nextInt();
        System.out.print("Enter num colums : ");
        int M = in.nextInt();

        double[][] matrix = new double[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                matrix[i][j] = in.nextDouble();
            }
        }

        System.out.println("\nMatrix :");
        contr.printMatrix(matrix);
        System.out.println("\nTransposedMatrix :");
        contr.printMatrix(contr.transpose(matrix));
        System.out.println();

        System.out.println("Task 3");
        System.out.print("Enter string : ");
        in.nextLine();
        System.out.println(contr.abbreviate(in.nextLine()));
        
        in.close();
    }
}