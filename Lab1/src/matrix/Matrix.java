package matrix;

public class Matrix {
    private int[][] tab;
    private int row;
    private int col;


    public Matrix(int _row, int _col) {
        row = _row;
        col = _col;
        tab = new int[_row][_col];
    }


    public Matrix add(Matrix toadd) {
        Matrix toreturn = new Matrix(this.row, this.col);

        if (this.col == toadd.col & this.row == toadd.row) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    toreturn.tab[i][j] = this.tab[i][j] + toadd.tab[i][j];
                }
            }
            return toreturn;
        } else{
            System.out.println("błąd");
            return new Matrix(0, 0);
        }
    }

    public Matrix sub(Matrix tosub) {
        Matrix toreturn = new Matrix(this.row, this.col);

        if (this.col == tosub.col & this.row == tosub.row) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    toreturn.tab[i][j] = this.tab[i][j] - tosub.tab[i][j];
                }
            }
            return toreturn;
        } else {
            System.out.println("błąd");
            return new Matrix(0, 0);
        }
    }


    public Matrix mul(Matrix tomul) {
        Matrix toreturn = new Matrix(this.row, this.col);
        if (this.col == tomul.row & this.row == tomul.col) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    toreturn.tab[i][j] += this.tab[i][j] * tomul.tab[j][i];
                }
            }
            return toreturn;

        } else {
            System.out.println("błąd");
            return new Matrix(0, 0);
        }
    }
}
