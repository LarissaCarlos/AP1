public class Program {
    public static void main(String[] args) {
        //criando dimensão matriz
        int row = 100;
        int column = 100;

        int matrix[][] = buildMatrix(row, column);
        int patternMatrix[][] = buildMatrix(2,3);
//matriz exemplo
        int[][] matrixTest = {
                {0,0,1,0,0,0,0,1,0},
                {0,1,1,1,1,1,1,0,0},
                {0,0,1,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,1,0,0},
                {0,0,0,0,0,1,0,0,0},
                {1,1,1,0,1,0,1,0,0},
                {1,0,1,0,0,0,0,0,0},
                {1,1,1,0,0,1,1,1,0}
        };
//matriz teste
        int[][] patternTest = {
                {1,1},
                {1,0},
                {0,1}
        };

        printMatrix(matrix, row, column);
        System.out.println("-----------------------------");
        printMatrix(patternMatrix, patternMatrix.length, patternMatrix.length);

// add cronometro
        double startTime = System.nanoTime();
        findPattern(matrix, patternMatrix, row, column);
        double endTime = System.nanoTime();

        System.out.println("Duracao: " + ((endTime - startTime)/10000) + " milisegundos");

    }
//define um método estático usando linhas e colunas da matriz que se deseja criar. retornando com o valor da matriz
    public static int[][] buildMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for (int y = 0; y < columns; y++) {
                matrix[i][y] = (int)(Math.random() * 2);
            }
        }
        return matrix;
    }
    //   imprimir na saída padrão
    public static void printMatrix(int[][] matrix, int rows, int columns) {
        for(int i = 0; i < rows; i++) {
            for (int y = 0; y < columns; y++) {
                System.out.print(" | " + matrix[i][y]);
            }
            System.out.println(" |");
        }
    }
        //da valor - preenche matriz
    public static void findPattern(int[][] matrix, int[][] patternMatrix, int matrixRows, int matrixColumns) {
        int counter = 0;
        int patternRows = patternMatrix.length;
        int patternCols = patternMatrix[0].length;

        for (int row = 0; row <= matrixRows - patternRows; row++) {
            for (int col = 0; col <= matrixColumns - patternCols; col++) {
                if (hasPattern(matrix, patternMatrix, row, col)) {
                    counter++;
                }
            }
        }
        System.out.println("Número de repetições encontradas: " + counter);
    }

    private static boolean hasPattern(int[][] matrix, int[][] patternMatrix, int row, int col) {
        for (int i = 0; i < patternMatrix.length; i++) {
            for (int j = 0; j < patternMatrix[0].length; j++) {
                if (matrix[row + i][col + j] != patternMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
