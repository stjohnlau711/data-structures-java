public class MatrixExponentiation {

    static int[][] identityMatrix(int size) { //constructs an identity matrix of a given size
        int[][] matrix = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == j){
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    static int[][] multiplyMatrices(int[][] a, int[][] b){ //assumes matrices are of the same length
        int[][] c = new int[a.length][b.length];
        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < b.length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }

    static int[][] matrixPower(int[][] matrix, int k){
        int[][] identity = identityMatrix(matrix.length);

        if(k == 0){ //same as regular efficient power function, just replace integers with matrices
            return identity;
        } else if(k % 2 == 0){
            int[][] dividedMatrix = multiplyMatrices(matrixPower(matrix,k/2),matrixPower(matrix,k/2));
            return dividedMatrix;
        } else {
            int[][] dividedMatrix = multiplyMatrices(matrixPower(matrix,k/2),matrixPower(matrix,k/2));
            return multiplyMatrices(matrix, dividedMatrix);
        }

    }

    static void printMatrix(int[][] matrix){ //print matrix function
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args){ //driver method to test

        int[][] A = { {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] B = matrixPower(A, 3);

        printMatrix(B);

    }
}
