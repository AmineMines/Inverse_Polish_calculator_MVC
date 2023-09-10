package com.example.calculatrice_v1;

import java.util.EmptyStackException;

public class Accumulateur  extends Pile{

        public Accumulateur(){
        }
        public void add(){
            this.push(this.pop() + this.pop()) ;
        }

        public void sub(){
            this.push(this.pop() - this.pop()) ;
    }
        public void multi(){
            this.push(this.pop() * this.pop());

        }
        public void div (){
            this.push(this.pop() / this.pop()) ;
            }
        }


