package com.example.calculatrice_v1;

import java.util.Stack;

public class Pile extends Stack <Float> {

     public Pile(){

     }

     public void drop(){
          int len =size();
          removeElementAt(len - 1);

     }
    public void swap(){
          float a = this.pop();
          float b = this.pop();

          this.push(a);
          this.push(b);
     }


     public void clear(){
          while (this.isEmpty() == false){
               this.drop();
          }

     }
}
