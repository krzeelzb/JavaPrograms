package Zad2_DummyMatrix;

//import Zad1_Matrix.Matrix;

public class MatrixProgram {
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
            DummyMatrix m3=new DummyMatrix(scores);
            DummyMatrix m4=new DummyMatrix(scores2);
            DummyMatrix x = m3.mul(m4);


            //x.print();



            // x = m.mul(m2);
//            x=m.mul(ne);
//            x.print();
//
//
//            x = m.sub(m2);
//            x.print();
        }catch(Exception e){
            throw e;

        }
        finally {
            //zamknięcie zasobu
            // ne.plik.close();
        }
    };


}

