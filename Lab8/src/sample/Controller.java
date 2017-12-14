package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Controller {
    @FXML
    private javafx.scene.control.TextField autorSearch,autorSearchButt, isbmSearchButt,isbmSearch, ismbAdd , titleAdd, authorAdd,yearAdd,addBookButt;
    private String searchauthor_, searchisbm_, addisbm_, addauthor_, addtitel_,wypisz_,wypisz__;
    private int addyear_;
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private int proby=0;

    public boolean connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/elakrz",
                            "elakrz","rd92NRAig3YW8Ltd");

            return true;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            proby+=1;
            if (proby<3)
                this.connect();

            return false;
        }catch(Exception e){e.printStackTrace();
            return false;}
    }

    public String listNames(String tosearch){
        String name= "";
        try {
            connect();
            stmt = conn.createStatement();

            String sql="SELECT * FROM books where author LIKE ? or isbn=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+tosearch+"%");
            pstmt.setString(2,tosearch);
            rs= pstmt.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int columnsNumber=rsmd.getColumnCount();

            while(rs.next()){
                for(int i=1;i<=columnsNumber;i++)
                    name=name+" " +rs.getString(i);
            }
            return name;
        }catch (SQLException ex){ex.printStackTrace();
            // handle any errors
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {sqlEx.printStackTrace(); } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { sqlEx.printStackTrace();} // ignore

                stmt = null;
            }
        }
        return "";
    }




    public String insertKsiazka( String  ISMB, String tytul, String autor, int year) {
        connect();
        try {
            String insert="insert into books values (?,?,?,?);";
            PreparedStatement prepStmt = conn.prepareStatement(insert
                    );
            prepStmt.setString(1, ISMB);
            prepStmt.setString(2, tytul);
            prepStmt.setString(3, autor);
            prepStmt.setInt(4, year);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return "niepowodzenie";
        }
        return ISMB+ " " + tytul+ " "+  autor +" "+year;
    }

    public void sAutor(ActionEvent actionEvent){
        wypisz_=listNames(autorSearch.getText());
        Text text=new Text(wypisz_);
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Pane root=new Pane();
        text.relocate(100,100);
        root.getChildren().add(text);
        Button btn = new Button();
        btn.setText("Powrót");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dalej(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        root.getChildren().add(btn);
        stage.setScene(new Scene(root,800,200));
        stage.show();

    }
    public void sIsbm(ActionEvent actionEvent){
        wypisz_=listNames(isbmSearch.getText());
        Text text=new Text(wypisz_);
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Pane root=new Pane();
        text.relocate(100,100);
        root.getChildren().add(text);
        Button btn = new Button();
        btn.setText("Powrót");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dalej(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        root.getChildren().add(btn);
        stage.setScene(new Scene(root,800,200));

        stage.show();

    }
    public void sBook(ActionEvent actionEvent){
        addisbm_=ismbAdd.getText();
        addtitel_= titleAdd.getText();
        addauthor_=  authorAdd.getText();
        addyear_=Integer.parseInt(yearAdd.getText());
        System.out.println(addisbm_);
        System.out.println(addtitel_);
        System.out.println(addauthor_);
        System.out.println(addyear_);


       wypisz__=insertKsiazka(addisbm_,addtitel_,addtitel_,addyear_);
       Text text= new Text(wypisz__);
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Pane root=new Pane();
        text.relocate(100,100);
        root.getChildren().add(text);
        Button btn = new Button();
        btn.setText("Powrót");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dalej(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        root.getChildren().add(btn);
        stage.setScene(new Scene(root,800,200));
        stage.show();

    }

    public void dalej(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample2.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
