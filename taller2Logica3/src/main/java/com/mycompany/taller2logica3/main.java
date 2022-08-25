package com.mycompany.taller2logica3;

public class main {
    public static void main(String[] args)
    {
        String aux = "(a(b(c,d(e)),f,g(h,i(j,k(l)),m,n)))";
        arbol prueba = new arbol(aux);
        nodoDoble p = prueba.getRaiz();
        while(p!=null){
            if(p.getSw()==0){
                System.out.println(p.getValor());
                p = p.getLigaDer();
            }
            else{
                p = p.getLigaDer();
            }
            
        }
        
        
    }
    
}
