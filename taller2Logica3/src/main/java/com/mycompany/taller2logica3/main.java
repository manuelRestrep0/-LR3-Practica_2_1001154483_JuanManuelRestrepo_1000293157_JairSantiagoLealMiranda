package com.mycompany.taller2logica3;

public class main {
    public static void main(String[] args)
    {
        String aux = "(a(b(c,d(e)),f,g(h,i(j,k(l)),m,n)))";
        arbol hola = new arbol(aux);
        nodoDoble hoja = hola.getRaiz();
        for(int i=1;i<10;i++)
        {
            System.out.println(hoja.getValor());
            hoja = hoja.getLigaDer();
        }
        
    }
    
}
