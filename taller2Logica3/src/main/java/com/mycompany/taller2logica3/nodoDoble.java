package com.mycompany.taller2logica3;


public class nodoDoble {
    
    private nodoDoble ligaIzq; //en la liga izquierda almacenar el padre
    private nodoDoble ligaDer; //liga derecha para el siguiente valor del arbol.
    
    public char valor;
    public Integer sw; 

    public nodoDoble(char valor) {
        this.valor = valor;
    }

    public nodoDoble() {
    }

    public nodoDoble getLigaIzq() {
        return ligaIzq;
    }

    public void setLigaIzq(nodoDoble ligaIzq) {
        this.ligaIzq = ligaIzq;
    }

    public nodoDoble getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(nodoDoble ligaDer) {
        this.ligaDer = ligaDer;
    }

    public char getValor() {
        return valor;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }

    public Integer getSw() {
        return sw;
    }
    
    
}
