package com.example.calculatrice_v1;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;


public class Controleur implements KeyListener, WindowListener,ActionListener, PropertyChangeListener {

    ArrayList nb_afficher = new ArrayList<String>();
    Gui view;
    Accumulateur test;

    public Controleur(Gui view,Accumulateur test) {
        this.view = view;
        this.test = test;
    }
    public void test(ActionEvent e){
    }

    public void keyTyped(KeyEvent e){
    }

    public void keyPressed(KeyEvent e){
        System.out.println(e);
    }
    public void keyReleased(KeyEvent e){

    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
    // Setting action performer for each digit button
    public void action_digit_button(String button_id) {
        nb_afficher.add(button_id);
        view.change(change_arraylist_to_string(nb_afficher));
    }
    // Setting action performed for egal_button
    public void action_egale_buton(){
        try {
            test.push(Float.parseFloat(change_arraylist_to_string(nb_afficher)));
            view.change(change_stack_to_arrayList(test));
            view.change("");
            nb_afficher.clear();

        } catch (Exception e) {
            System.out.println(e);
            view.change("Vous ne pouvez pas ne rien ajouter à la mémoire ");
        }


    }
    public void action_clear_button(){

        if (nb_afficher.isEmpty() == false){
            nb_afficher.remove(nb_afficher.size()-1);
            view.change(change_arraylist_to_string(nb_afficher));
        }else{
            try{
                test.drop();
                view.change(change_stack_to_arrayList(test));
            }catch (Exception e){
                view.change("Il n'y a rien à supprimer");
            }

        }
    }
    public String change_arraylist_to_string(ArrayList nb){
        String chiffre = "";
        for( Object element : nb){
            chiffre += element;
        }
        return chiffre;
    }
    public ArrayList<String> change_stack_to_arrayList(Accumulateur p){
        ArrayList nb_afficher_pile = new ArrayList<String>();
        int pile_size = p.size();
        while ( pile_size>0){
            nb_afficher_pile.add(p.get(pile_size-1).toString());
            pile_size = pile_size-1;
        }
        Collections.reverse(nb_afficher_pile);

       return nb_afficher_pile;
    }
    public void action_operand(String btn_id){
        switch(btn_id){
            case "*" : test.multi(); break ;
            case "+" : test.add(); break ;
            case "-" : test.sub(); break ;
            case "/" : test.div(); break ;
        }
        view.change(change_stack_to_arrayList(test));
    }

    public void keycontroleur(javafx.scene.input.KeyEvent keyEvent) {

        switch(keyEvent.getCode()){
            case NUMPAD1:
            case NUMPAD3:
            case NUMPAD2:
            case NUMPAD4:
            case NUMPAD5:
            case NUMPAD6:
            case NUMPAD7:
            case NUMPAD8:
            case NUMPAD9: action_digit_button(keyEvent.getText());break;
            case E: action_egale_buton();break;
            case C: action_clear_button();break;
        }

    }
}