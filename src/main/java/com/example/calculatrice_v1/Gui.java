package com.example.calculatrice_v1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.collections.*;

import java.io.IOException;
import java.util.List;

import static javafx.scene.paint.Color.color;

public class Gui extends Application implements iView {
    private Stage stage ;
    private Label affichage = new Label();
    private TextField aff_calcul = new TextField();
    private TextField aff_chiffre_entrer = new TextField();
    private ListView aff_pile  = new ListView<>();
    private Label last_operation = new Label();
    private Label résulat = new Label();

    public Button btn_1 = new Button("1");

    private Button btn_2 = new Button("2");
    private Button btn_3 = new Button("3");
    private Button btn_4 = new Button("4");
    private Button btn_5 = new Button("5");
    private Button btn_6 = new Button("6");
    private Button btn_7 = new Button("7");
    private Button btn_8 = new Button("8");
    private Button btn_9 = new Button("9");
    private Button btn_moins= new Button("-");
    private Button btn_plus= new Button("+");
    private Button btn_mult = new Button("*");
    private Button btn_egal = new Button("=/ ↵");
    private Button btn_clear = new Button("clear");
    private Button btn_div = new Button("/");
    private Button btn_factoriel = new Button("!");
    private Button btn_moins_neg = new Button("(-)");
    private Button btn_virgule = new Button(".");
    private Button btn_zero = new Button("0");
    Accumulateur test = new Accumulateur();

    Controleur controleur = new Controleur(this,test);


    public void start(Stage stage) throws IOException {


        this.stage = stage;

        // Setting Label
        affichage.setText("Memory ");
        résulat.setText("Result ");
        aff_calcul.setEditable(false);
        aff_chiffre_entrer.setEditable(false);

        // Setting buttons's size
        change_button_size();
        //change button's positions
        change_button_position();
        // Listen of event to send them to the controller
        boutton_listener();
        // Setting panel
        StackPane button_panel = new StackPane();
        // tentative de mettre un background linéaire
        button_panel.setStyle("-fx-background-color: linear-gradient(to bottom left, #ff7f50, #6a5acd)" + "}");
        // Add command to panel to make them visibel
        button_panel.getChildren().addAll(btn_zero,btn_moins_neg,btn_virgule,aff_chiffre_entrer,btn_1,btn_2,btn_3,btn_4, btn_5,btn_6,btn_7,btn_8,btn_9,affichage,btn_moins,btn_mult,btn_plus,btn_clear,btn_factoriel,btn_div,btn_egal,résulat,aff_pile,aff_calcul);

        Scene sc = new Scene(button_panel, Color.BLACK);
        key_event_listennig(sc);
        stage.setScene(sc);
        // Setting  (texte, boutton, arraylist) design
        change_boutton_style();

        //Setting the stage
        stage.setResizable(false);
        stage.setWidth(480);
        stage.setHeight(600);
        stage.getIcons().add(new Image("file:src/main/resources/Licorne.png"));
        stage.setTitle("Caclulatrice");
        btn_egal.requestFocus();
        stage.show();
    }

    private void key_event_listennig(Scene sc) {

        sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                controleur.keycontroleur(keyEvent);
            }
        });

    }

    private void change_button_position() {
        btn_1.setTranslateX(-150);
        btn_clear.setTranslateX(-150);
        btn_2.setTranslateX(-70);
        btn_factoriel.setTranslateX(-70);
        btn_3.setTranslateX(10);
        btn_div.setTranslateX(10);
        btn_moins.setTranslateX(100);
        btn_moins_neg.setTranslateX(100);
        btn_virgule.setTranslateX(100);
        btn_moins.setTranslateY(80);
        btn_moins_neg.setTranslateY(40);
        btn_plus.setTranslateX(100);
        btn_mult.setTranslateX(100);
        btn_egal.setTranslateX(100);
        btn_4.setTranslateX(-150);
        btn_5.setTranslateX(-70);
        btn_6.setTranslateX(10);
        btn_7.setTranslateX(-150);
        btn_zero.setTranslateX(-70);
        btn_8.setTranslateX(-70);
        btn_9.setTranslateX(10);
        btn_1.setTranslateY(60);
        btn_2.setTranslateY(60);
        btn_3.setTranslateY(60);
        btn_4.setTranslateY(140);
        btn_5.setTranslateY(140);
        btn_6.setTranslateY(140);
        btn_plus.setTranslateY(160);
        btn_7.setTranslateY(220);
        btn_virgule.setTranslateY(120);
        btn_8.setTranslateY(200);
        btn_zero.setTranslateY(240);
        btn_9.setTranslateY(220);
        btn_mult.setTranslateY(220);
        btn_factoriel.setTranslateY(-20);
        btn_clear.setTranslateY(-20);
        btn_egal.setTranslateY(-20);
        btn_div.setTranslateY(-20);
        affichage.setTranslateX(15);
        affichage.setTranslateY(-250);
        résulat.setTranslateX(100);
        résulat.setTranslateY(-230);
        aff_calcul.setTranslateX(100);
        aff_calcul.setTranslateY(-200);
        aff_pile.setTranslateX(-150);
        aff_pile.setTranslateY(-180);
        aff_chiffre_entrer.setTranslateY(-100);
        aff_chiffre_entrer.setTranslateX(-150);
    }

    private void change_button_size() {
        btn_moins_neg.setMaxWidth(80);
        btn_moins_neg.setMaxHeight(40);
        btn_zero.setMaxWidth(80);
        btn_virgule.setMaxWidth(80);
        btn_virgule.setMaxHeight(40);
        btn_1.setMaxWidth(80);
        btn_1.setMaxHeight(80);
        btn_moins.setMaxWidth(80);
        btn_moins.setMaxHeight(40);
        btn_plus.setMaxWidth(80);
        btn_plus.setMaxHeight(40);
        btn_mult.setMaxWidth(80);
        btn_mult.setMaxHeight(80);
        btn_2.setMaxWidth(80);
        btn_2.setMaxHeight(80);
        btn_3.setMaxWidth(80);
        btn_3.setMaxHeight(80);
        btn_4.setMaxWidth(80);
        btn_4.setMaxHeight(80);
        btn_5.setMaxWidth(80);
        btn_5.setMaxHeight(80);
        btn_6.setMaxWidth(80);
        btn_6.setMaxHeight(80);
        btn_7.setMaxWidth(80);
        btn_7.setMaxHeight(80);
        btn_8.setMaxWidth(80);
        btn_8.setMaxHeight(25);
        btn_9.setMaxHeight(80);
        btn_9.setMaxWidth(80);
        btn_clear.setMaxHeight(50);
        btn_clear.setMaxWidth(80);
        btn_div.setMaxHeight(50);
        btn_div.setMaxWidth(80);
        btn_egal.setMaxHeight(50);
        btn_egal.setMaxWidth(80);
        btn_factoriel.setMaxHeight(50);
        btn_factoriel.setMaxWidth(80);
        affichage.setMaxWidth(400);
        affichage.setMaxHeight(80);
        aff_chiffre_entrer.setMaxWidth(80);
        aff_chiffre_entrer.setMaxHeight(20);
        aff_pile.setMaxHeight(120);
        aff_pile.setMaxWidth(80);
        aff_calcul.setMaxHeight(20);
        aff_calcul.setMaxWidth(80);
        btn_zero.setMaxHeight(10);
    }

    private void change_boutton_style(){
        btn_egal.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\n" +
                "        #9d4024,\n" +
                "        #d86e3a,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");

        btn_1.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#6a5acd  0%, #6a5acd 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #FFB2CE, #6a5acd);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_2.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#6a5acd  0%, #6a5acd 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #FFB2CE, #6a5acd);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_3.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#6a5acd  0%, #6a5acd 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #FFB2CE, #6a5acd);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_4.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#6a5acd  0%, #6a5acd 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #FFB2CE, #6a5acd);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_5.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#6a5acd  0%, #6a5acd 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #FFB2CE, #6a5acd);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_6.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#6a5acd  0%, #6a5acd 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #FFB2CE, #6a5acd);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_7.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#6a5acd  0%, #6a5acd 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #FFB2CE, #6a5acd);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");

        btn_8.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#6a5acd  0%, #6a5acd 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #FFB2CE, #6a5acd);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_zero.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#6a5acd  0%, #6a5acd 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #FFB2CE, #6a5acd);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");

        btn_9.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#6a5acd  0%, #6a5acd 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #FFB2CE, #6a5acd);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_mult.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#BA28C7  0%, #BA28C7 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #BA28C7, #5B1461);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_plus.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#BA28C7  0%, #BA28C7 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #BA28C7, #5B1461);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_moins.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#BA28C7  0%, #BA28C7 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #BA28C7, #5B1461);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_factoriel.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#BA28C7  0%, #BA28C7 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #BA28C7, #5B1461);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_moins_neg.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#BA28C7  0%, #BA28C7 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #BA28C7, #5B1461);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_virgule.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#BA28C7  0%, #BA28C7 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #BA28C7, #5B1461);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_div.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#BA28C7  0%, #BA28C7 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #BA28C7, #5B1461);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        btn_clear.setStyle("  -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%,#BA28C7  0%, #BA28C7 100%),\n" +
                "        " +
                "        " +
                "        radial-gradient(center 50% 50%, radius 100%, #BA28C7, #5B1461);\n" +
                "    " +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");

        aff_chiffre_entrer.setStyle("    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;"+"-fx-opacity: 0.5;");
        aff_pile.setStyle("    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;"+"-fx-opacity: 0.5;");
        aff_calcul.setStyle("    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;"+"-fx-opacity: 0.5;");
        affichage.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        résulat.setFont(Font.font("Verdana", FontWeight.BOLD, 15));


    }

    private void boutton_listener(){

        btn_moins_neg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_operand(btn_moins_neg.getText());
            }
        });
        btn_plus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_operand(btn_plus.getText());
            }
        });
        btn_div.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_operand(btn_div.getText());
            }
        });
        btn_moins.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_operand(btn_moins.getText());
            }
        });
        btn_zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_zero.getText());
            }
        });
        btn_virgule.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_virgule.getText());
            }
        });

        btn_mult.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_operand(btn_mult.getText());
            }
        });
        btn_clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_clear_button();
            }
        });
        btn_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_1.getText());
            }
        });
        btn_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_2.getText());
            }

        });
        btn_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_3.getText());
            }

        });
        btn_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_3.getText());
            }

        });
        btn_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_4.getText());
            }

        });
        btn_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_5.getText());
            }

        });
        btn_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_6.getText());
            }
        });
        btn_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_7.getText());
            }
        });

        btn_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_8.getText());
            }

        });
        btn_9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_digit_button(btn_9.getText());
            }

        });
        btn_egal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controleur.action_egale_buton();
            }
        });

    }


    @Override
    public void affiche() {
        stage.show();
    }

    @Override
    public void change(String chiffre) {
        aff_chiffre_entrer.setText(chiffre);
    }

    @Override
    public void change(List<String> nombre) {
        ObservableList<String> items =FXCollections.observableArrayList (nombre);
        aff_pile.setItems(items);
        if (nombre.size()!= 0){
            aff_calcul.setText(nombre.get(nombre.size()-1));
        }else{
            aff_calcul.setText("0");
        }

    }

    public static void main(String[] args) {
        launch();
    }

}