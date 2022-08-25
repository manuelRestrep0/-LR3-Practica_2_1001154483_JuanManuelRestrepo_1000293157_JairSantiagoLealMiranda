
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
        while(i<=longitud-3){
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
    
    public void imprimirArbol(nodoDoble raiz, int band){
        nodoDoble p, primero, q;
        Stack pila = new Stack();
        if(raiz==null){
            System.out.println("LISTA VACIA");
            return;
        }
        primero = null;
        if(band==0){
            System.out.print("("+raiz.getValor());
            if(raiz.getLigaDer()==null){
                System.out.print(")");
                return;
            }
            System.out.print("(");
            primero = raiz;
        }
        p = raiz.getLigaDer();
        while(p!=null){
            if(p.getSw()==0){
                System.out.print(p.getValor());
            }
            else{
                q = (nodoDoble)p.getValor();
                System.out.print(q.getValor()+"(");
                imprimirArbol((nodoDoble)p.getValor(),1);
            }
            if(p.getLigaDer()!=null){
                System.out.print(",");
            }
            p = p.getLigaDer();
        }
        System.out.print(")");
        if(primero==raiz){
            System.out.print(")");
        } 
    }
   
}
