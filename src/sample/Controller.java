package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {

    ObservableList<String> choise_box_list = FXCollections.observableArrayList("Трус и Балбес","Трус","Балбес");

    @FXML
    private Label trus_choise;
    @FXML
    private Label trus_count;
    @FXML
    private Label balbes_choise;
    @FXML
    private Label balbes_count;
    @FXML
    private Label igrok_choise;
    @FXML
    private Label igrok_count;
    @FXML
    private ChoiceBox choise_box;
    @FXML
    private void initialize(){
        choise_box.setValue("Трус и Балбес");
        choise_box.setItems(choise_box_list);
    }


    public String tc;
    public String bc;
    public String ic;
    public int trus_co=0;
    public int balbes_co=0;
    public int igrok_co=0;
    public Choise choise=new Choise();



    public void kamenClick(MouseEvent mouseEvent) {
        ic="k";
        igrok_choise.setText("Камень");
        game();
    }

    public void scizorsClick(MouseEvent mouseEvent) {
        ic="n";
        igrok_choise.setText("Ножницы");
        game();
    }

    public void paperClick(MouseEvent mouseEvent) {
        ic="b";
        igrok_choise.setText("Бумага");
        game();
    }

    private void game() {
        String igroki= (String) choise_box.getValue();
        switch (igroki) {
            case "Трус и Балбес":
                tc = choise.ch();
                bc = choise.ch();

                labelText(tc, trus_choise);
                labelText(bc, balbes_choise);

                reshenie(ic, tc, bc, igrok_count);
                reshenie(tc, ic, bc, trus_count);
                reshenie(bc, tc, ic, balbes_count);
                break;
            case "Трус":
                tc = choise.ch();

                labelText(tc, trus_choise);

                reshenie1(ic, tc, igrok_count);
                reshenie1(tc, ic, trus_count);
                break;
            case "Балбес":
                bc = choise.ch();

                labelText(bc, balbes_choise);

                reshenie1(ic, bc, igrok_count);
                reshenie1(bc, ic, balbes_count);
                break;
        }
    }

    private void reshenie1(String i1, String i2, Label l) {
        int co=0;
        if (i1 == "k" && i2 == "n") {
            co += 1;
        } else if (i1 == "n" && i2 == "b") {
            co += 1;
        } else if (i1 == "b" && i2 == "k") {
            co += 1;
        }
            if (co==1 && l==igrok_count){
            igrok_co+=1;
            l.setText(String.valueOf(igrok_co));
            }
            else if (co==1 && l==trus_count){
                trus_co+=1;
                l.setText(String.valueOf(trus_co));
            }
            else if (co==1 && l==balbes_count){
                balbes_co+=1;
                l.setText(String.valueOf(balbes_co));
            }
    }

    private void reshenie(String i1, String i2, String i3, Label l) {
        int co=0;
        if (i1 == "k" && i2 == "n" && i3 == "n") {
            co += 1;
        } else if (i1 == "n" && i2 == "b" && i3 == "b") {
            co += 1;
        } else if (i1 == "b" && i2 == "k" && i3 == "k") {
            co += 1;
        }
            if (co==1 && l==igrok_count){
                igrok_co+=1;
                l.setText(String.valueOf(igrok_co));
            }
            else if (co==1 && l==trus_count){
                trus_co+=1;
                l.setText(String.valueOf(trus_co));
            }
            else if (co==1 && l==balbes_count){
                balbes_co+=1;
                l.setText(String.valueOf(balbes_co));
            }
    }


    private void labelText(String game_choise, Label gamer_choise){
        switch (game_choise){
            case "k":
                gamer_choise.setText("Камень");
                break;
            case "n":
                gamer_choise.setText("Ножницы");
                break;
            case "b":
                gamer_choise.setText("Бумага");
                break;
        }
    }

    public void gamers(ActionEvent actionEvent) {
        obnul();
        if (choise_box.getValue()=="Трус и Балбес"){
            trus_choise.setVisible(true);
            trus_count.setVisible(true);
            balbes_choise.setVisible(true);
            balbes_count.setVisible(true);
        }
        else if (choise_box.getValue()=="Трус"){
            trus_choise.setVisible(true);
            trus_count.setVisible(true);
            balbes_choise.setVisible(false);
            balbes_count.setVisible(false);
        }
        else {
            trus_choise.setVisible(false);
            trus_count.setVisible(false);
            balbes_choise.setVisible(true);
            balbes_count.setVisible(true);
        }
    }

    private void obnul() {
        trus_co=0;
        balbes_co=0;
        igrok_co=0;
        trus_count.setText(String.valueOf(trus_co));
        balbes_count.setText(String.valueOf(balbes_co));
        igrok_count.setText(String.valueOf(igrok_co));
    }
}
