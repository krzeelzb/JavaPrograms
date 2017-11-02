package Zad1_Matrix;

import Zad2_DummyMatrix.MatrixDummyDimensionsException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Matrix {
    public int[][] tab;
    public int row;
    public int col;
    public File plik;
    public Scanner skan;


    public Matrix() {
    }

    public Matrix(int _row, int _col) {
        row = _row;
        col = _col;
        tab = new int[_row][_col];
    }

    public Matrix(int[][] scores) {
        row = scores.length;
        col = scores[0].length;
        tab = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tab[i][j] = scores[i][j];
            }
        }
    }

    public Matrix(String path_) {
//        Plik w formacie:
//                "3 (wiersze)
//                 3 (kolumny)
//                 11,2,3,
//                 1,2,3,
//                 1,2,356,"

        this.plik = new File(path_);
        String odczyt = "";
        LinkedList<String> list = new LinkedList<>();
        int[] num;
        try {
            Scanner skaner = new Scanner(plik);
            skan=skaner;
            row = Integer.parseInt(skaner.nextLine());
            col = Integer.parseInt(skaner.nextLine());
            tab = new int[row][col];
            int i=0;
            int j=0;

            while( i < row ) {
                while(j <col ) {
                    while (skaner.hasNextLine()) {
                        odczyt = (skaner.nextLine());

                        for (int k = 0; k < odczyt.length(); k++) {
                            int m=k;
                            String tmp="";
                            while(odczyt.charAt(m++)!=','){
                                tmp += Character.toString(odczyt.charAt(k));
                                k++;
                            }
                            tab[i][j] = Integer.parseInt(tmp);
                            j++;
                        }
                        list.add(odczyt);
                        i++;
                        j=0;
                    }
                    j=col;
                }
                i=row;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Brak Pliku do odczytania!");
        }finally {
            skan.close();
        }
    }


    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(tab[i][j] + ",");
            }
            System.out.print("\n");
        }
    }

    public Matrix add(Matrix toadd) throws MatrixDimensionsException, MatrixDummyDimensionsException {
        Matrix toreturn = new Matrix(this.row, this.col);

        if (this.col == toadd.col & this.row == toadd.row) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    toreturn.tab[i][j] = this.tab[i][j] + toadd.tab[i][j];
                }
            }
            return toreturn;
        } else {
            throw new MatrixDimensionsException();
        }
    }

    public Matrix sub(Matrix tosub) throws MatrixDimensionsException, MatrixDummyDimensionsException {
        Matrix toreturn = new Matrix(this.row, this.col);

        if (this.col == tosub.col & this.row == tosub.row) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    toreturn.tab[i][j] = this.tab[i][j] - tosub.tab[i][j];
                }
            }
            return toreturn;
        } else {
            throw new MatrixDimensionsException();
        }
    }


    public Matrix mul(Matrix tomul) throws MatrixDimensionsException, MatrixDummyDimensionsException {
        Matrix toreturn = new Matrix(this.row, this.col);

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
            throw new MatrixDimensionsException();
        }
    }
}
