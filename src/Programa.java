public class Programa {
    public static void main(String[] args) {
        int row = 100;
        int column = 100;

        int matrix[][] = buildMatrix(row, column);
        int patternMatrix[][] = buildMatrix(2,3);

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

        int[][] patternTest = {
                {1,1},
                {1,0},
                {0,1}
        };

        printMatrix(matrix, row, column);
        System.out.println("-----------------------------");
        printMatrix(patternMatrix, patternMatrix.length, patternMatrix.length);


        double startTime = System.nanoTime();
        findPattern(matrix, patternMatrix, row, column);
        double endTime = System.nanoTime();

        System.out.println("Duracao: " + ((endTime - startTime)/10000) + " milisegundos");

    }

    public static int[][] buildMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for (int y = 0; y < columns; y++) {
                matrix[i][y] = (int)(Math.random() * 2);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix, int rows, int columns) {
        for(int i = 0; i < rows; i++) {
            for (int y = 0; y < columns; y++) {
                System.out.print(" | " + matrix[i][y]);
            }
            System.out.println(" |");
        }
    }

    public static void findPattern(int[][] matrix, int[][] patternMatrix, int matrixRows, int matrixColumns) {
        int counter = 0;
        for (int i = 0; i < matrixColumns; i++) {
            for (int y = 0; y < matrixRows; y++) {
                if (matrix[y][i] == patternMatrix[0][0] && y < (matrixRows - patternMatrix.length + 1) && i < (matrixColumns - patternMatrix.length + 1)) {
                    if (matrix[y][i+1] == patternMatrix[0][1]) {
                        if (matrix[y][i+2] == patternMatrix[0][2]) {
                            if (matrix[y+2][i] == patternMatrix[1][0]) {
                                if (matrix[y+1][i+1] == patternMatrix[1][1]) {
                                    if (matrix[y+1][i+2] == patternMatrix[1][2]) {
                                        if (matrix[y+2][i] == patternMatrix[2][0]) {
                                            if (matrix[y+2][i+1] == patternMatrix[2][1]) {
                                                if (matrix[y+2][i+2] == patternMatrix[2][2]) {
                                                    counter++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Número de repetições encontradas: " + counter);
    }
}
