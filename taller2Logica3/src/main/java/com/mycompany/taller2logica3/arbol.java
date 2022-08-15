
package com.mycompany.taller2logica3;

public class arbol {
   public nodoDoble raiz;

    public arbol(String arbolHilera) {
        
        this.raiz = new nodoDoble(arbolHilera.charAt(1));
        int longitud = arbolHilera.length();
        nodoDoble auxAnterior, hoja = new nodoDoble();
        auxAnterior= this.raiz;
        for(int i=1; i<longitud; i++){
            if(arbolHilera.charAt(i)=='('){
                hoja = new nodoDoble(arbolHilera.charAt(i+1));
                hoja.setLigaIzq(auxAnterior);
                auxAnterior.setLigaDer(hoja); // error en esta linea, cuando se regresa el ancestro, la liga derecha cambia.
                if(arbolHilera.charAt(i)=='('){
                    auxAnterior = hoja;
                }
            }
            if(arbolHilera.charAt(i)==')'){
                auxAnterior = hoja.getLigaIzq();
                /*while(auxAnterior.getLigaDer()==null){
                    auxAnterior = auxAnterior.getLigaIzq();
                }*/
            }
            if(arbolHilera.charAt(i)==','){
                hoja = new nodoDoble(arbolHilera.charAt(i+1));
                hoja.setLigaIzq(auxAnterior);
                auxAnterior.setLigaDer(hoja);
            }
        }
    }

    public nodoDoble getRaiz() {
        return raiz;
    }
   
   
}
