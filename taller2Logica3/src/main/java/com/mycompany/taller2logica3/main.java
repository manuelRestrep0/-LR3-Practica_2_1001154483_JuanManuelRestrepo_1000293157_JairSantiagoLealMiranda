package com.mycompany.taller2logica3;

public class main {
    public static void main(String[] args)
    {
        String aux = "(a(b(c,d(e)),f,g(h,i(j,k(l)),m,n)))";
        arbol prueba = new arbol(aux);
        prueba.imprimirArbol(prueba.getRaiz(), 0);
        
    }
    
}
