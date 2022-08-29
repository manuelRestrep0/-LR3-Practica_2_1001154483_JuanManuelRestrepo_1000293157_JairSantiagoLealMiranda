
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
                //System.out.println(" padre = "+p.getLigaIzq().getValor());
            }
            else{
                q = (nodoDoble)p.getValor();
                System.out.print(q.getValor()+"(");
                //System.out.println(" padre ="+p.getLigaIzq().getValor());
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
    public int gradoMayor(){
        nodoDoble p = this.raiz;
        int mayor=0, aux;
        while(p!=null){
            aux = gradoRegistro(p,this.raiz);
            if(aux>mayor){
                mayor = aux;
            }
            p = p.getLigaDer();
        }
        p = this.raiz.getLigaDer();
        while(p!=null){
            if(p.getSw()==1){
                aux = gradoRegistro((nodoDoble)p.getValor(),(nodoDoble)p.getValor());
                if(aux>mayor){
                    mayor = aux;
                }
            }
            p = p.getLigaDer();
        }
        return mayor;
    }
    
    public int altura(nodoDoble raiz){
        nodoDoble p = raiz;
        if(p==null)return 0;
        if(p.getLigaDer()==null)return 1;
        int h=1,aux;
        p = p.getLigaDer();
        while(p!=null){
            if(p.getSw()==1){
                aux = altura((nodoDoble)p.getValor());
                if(aux>h){
                    h=aux;
                }
            }
            p = p.getLigaDer();
        }
        return h+1;
    }
    
    public int numeroHojas(nodoDoble raiz){
        if(raiz.getLigaDer()==null)return 0;
        if(raiz==null)return 0;
        nodoDoble p = raiz.getLigaDer();
        int hojas=0;
        while(p!=null){
            if(p.getSw()==0){
                hojas = hojas+1;
            }
            else{
                hojas = hojas + numeroHojas((nodoDoble)p.getValor());
            }
            p = p.getLigaDer();
        }
        return hojas;
    }
    
    public int gradoRegistro(nodoDoble registro, nodoDoble raiz){
        if(registro==raiz){
            nodoDoble p = registro.getLigaDer();
            int i = 0;
            while(p!=null){
                i = i+1;
                p = p.getLigaDer();
            }
            return i;
        }
        nodoDoble p,q;
        p = raiz.getLigaDer();
        int i = 0;
        while(p!= null){
            if(p==registro){
                if(p.getSw()==0)return 0;
                else{
                    q = (nodoDoble)p.getValor();
                    q = q.getLigaDer();
                    while(q!=null){
                        i = i+1;
                        q = q.getLigaDer();
                    }
                    return i;
                }
            }
            else{
                if(p.getSw()==1){
                    i = gradoRegistro(registro,(nodoDoble)p.getValor());
                    if(i!=0)return i;
                }
            }
            p = p.getLigaDer();
        }
        return 0;
    }
    
    public int nivelRegistro(nodoDoble registro){
        if(registro==this.raiz){
            return 1;
        }
        if(registro==null){
            return 0;
        }
        nodoDoble p = registro.getLigaIzq();
        int i=1;
        while(p!=null){
            i = i+1;
            p = p.getLigaIzq();
        }
        return i;
    }
    
    public void ancestros(nodoDoble registro){
        if(registro==this.raiz){
            System.out.println("El registro es la raiz, por lo tanto no tiene ancestros.");
            return;
        }
        nodoDoble p=registro.getLigaIzq();
        while(p!=null){
            System.out.println(p.getValor());
            p = p.getLigaIzq();
        }
        return;
    }
   
    
}
