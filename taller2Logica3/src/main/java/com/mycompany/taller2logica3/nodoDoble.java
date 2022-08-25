package com.mycompany.taller2logica3;


public class nodoDoble {
    
    private nodoDoble ligaIzq; //en la liga izquierda almacenar el padre
    private nodoDoble ligaDer; //liga derecha para el siguiente valor del arbol.
    
    public Object valor;
    public Integer sw=0; 

    public nodoDoble(Object valor) {
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

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Integer getSw() {
        return sw;
    }

    public void setSw(Integer sw) {
        this.sw = sw;
    }
    
    
}
