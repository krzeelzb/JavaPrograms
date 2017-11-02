package Zad1_Matrix;

public class MatrixProgram{
    public static void main(String [] argv) throws MatrixDimensionsException, Exception {
        Matrix ne=new Matrix("/home/ela/Pulpit/1.txt");
        try {
            int[][] scores = {{1, 2, 3},
                    {1, 2, 3},
                    {1, 2, 3}
            };

            int[][] scores2 = {{2, 2, 3},
                    {2, 2, 3},
            };
            Matrix m = new Matrix(scores);
            Matrix m2 = new Matrix(scores2);

            Matrix x = m.mul(m2);
            x.print();

        }catch(Exception e){
            throw e;

        }
    };


}

