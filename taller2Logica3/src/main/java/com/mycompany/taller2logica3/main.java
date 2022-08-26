package com.mycompany.taller2logica3;

public class main {
    public static void main(String[] args)
    {
        String aux = "(a(b(c,d(e)),f,g(h,i(j,k(l)),m,n)))";
        arbol prueba = new arbol(aux);
        prueba.imprimirArbol(prueba.getRaiz(), 0);
        System.out.println("");
        System.out.println("altura: "+String.valueOf(prueba.altura(prueba.getRaiz())));
        System.out.println("grado de un registro: "+String.valueOf(prueba.gradoRegistro(prueba.getRaiz())));
        System.out.println("grado mayor: "+String.valueOf(prueba.gradoMayor()));
        System.out.println("numero hojas: "+String.valueOf(prueba.numeroHojas(prueba.getRaiz())));
        
    }
    
}
