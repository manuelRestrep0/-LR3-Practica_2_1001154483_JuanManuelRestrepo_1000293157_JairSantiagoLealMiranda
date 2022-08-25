
package com.mycompany.taller2logica3;
import java.util.Stack;

public class arbol {
   public nodoDoble raiz;
   
   public arbol(){
       
   }
   
    public arbol(String arbolHilera) {
        int longitud = arbolHilera.length();
        if(longitud<1)return;
        if(longitud==3){
            this.raiz = new nodoDoble(arbolHilera.charAt(1));
            return;
        }
        
        this.raiz = new nodoDoble(arbolHilera.charAt(1));
        nodoDoble auxPadre, hoja, nodoAux;
        Stack pila = new Stack();
        auxPadre = raiz;
        nodoAux = auxPadre;
        int i=3;
        while(i<=longitud-2){
            hoja = new nodoDoble(null);
            nodoAux.setLigaDer(hoja);
            nodoAux = hoja;
            if(arbolHilera.charAt(i+1)=='('){
                nodoAux.setSw(1);
                pila.push(nodoAux);
                nodoAux.setLigaIzq(auxPadre);
                hoja = new nodoDoble(arbolHilera.charAt(i));
                nodoAux.setValor((nodoDoble)hoja);
                nodoAux = hoja;
                auxPadre = hoja;                
                i = i+2;
                       
            }
            else{
                nodoAux.setValor(arbolHilera.charAt(i));
                nodoAux.setLigaIzq(auxPadre);
                if(arbolHilera.charAt(i+1)==')'){
                   i = i+1;
                   while(i<longitud && arbolHilera.charAt(i)==')' && !pila.empty()){
                       nodoAux = (nodoDoble)pila.pop();
                       auxPadre = nodoAux.getLigaIzq();
                       i = i+1;
                   }
                   if(arbolHilera.charAt(i)==','){
                       i = i+1;
                   }
                }
                else{
                    i = i+2;
                }           
            }
        }
    }

    public nodoDoble getRaiz() {
        return raiz;
    }

   
}
