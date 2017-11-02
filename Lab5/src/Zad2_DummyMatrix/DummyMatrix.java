package Zad2_DummyMatrix;

import Zad1_Matrix.Matrix;

public class DummyMatrix extends Matrix {
    public DummyMatrix(){};

    public DummyMatrix(int _row, int _col) {
        super(_row, _col);
    }

    public DummyMatrix(int[][] scores) {
        super(scores);
    }

    public DummyMatrix(String path_) {
        super(path_);
    }

    @Override
    public DummyMatrix add(Matrix toadd) throws MatrixDummyDimensionsException {
        DummyMatrix toreturn = new DummyMatrix(this.row, this.col);

        if (this.col == toadd.col & this.row == toadd.row) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    toreturn.tab[i][j] = this.tab[i][j] + toadd.tab[i][j];
                }
            }
            return toreturn;
        } else {
            throw new MatrixDummyDimensionsException();
        }
    }

    @Override
    public Matrix sub(Matrix tosub) throws MatrixDummyDimensionsException {
        DummyMatrix toreturn = new DummyMatrix(this.row, this.col);

        if (this.col == tosub.col & this.row == tosub.row) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    toreturn.tab[i][j] = this.tab[i][j] - tosub.tab[i][j];
                }
            }
            return toreturn;
        } else {
            throw new MatrixDummyDimensionsException();

        }
    }


    @Override
    public DummyMatrix mul(Matrix tomul) throws MatrixDummyDimensionsException {
        DummyMatrix toreturn = new DummyMatrix(this.row, this.col);

        if (this.col == tomul.row & this.row == tomul.col) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    for (int k = 0; k < this.col; k++) {
                        toreturn.tab[i][j] += (this.tab[i][k] * tomul.tab[k][j]);
                    }

                }
            }
            return toreturn;

        } else {
            // System.out.println("Poprawiona macierz-wstawione 1: ");
            int[][] tmptab=new int[this.row][this.col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i > tomul.row-1 | j > tomul.col-1)
                        tmptab[i][j] = 1;
                    else
                        tmptab[i][j] = tomul.tab[i][j];

                }
            }

            DummyMatrix tmp = new DummyMatrix(tmptab);
            this.mul(tmp).print();
            throw new MatrixDummyDimensionsException();
        }
    }
}
