package Zad2_DummyMatrix;

public class MatrixDummyDimensionsException extends Exception {

    protected int[][] tab;
    protected int row;
    protected int col;
    protected Matrix good;
    protected Matrix bad;


    public MatrixDummyDimensionsException() {
    }
}
