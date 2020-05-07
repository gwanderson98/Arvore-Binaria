package arvorebinaria;

import javax.swing.JOptionPane;

// Todos os nós possuem no MÁXIMO 2 nós filho
// Os menores valores situam à esquerda e os maiores ou igual situados à direita do nó atual

public class Arvorebinaria {
    
    private int valor;
    private Arvorebinaria esq;
    private Arvorebinaria dir;
       
    public Arvorebinaria(){
        valor = 0;
    }
    
    public void geraArvore(Arvorebinaria no, int num) {
        
        Arvorebinaria aux = new Arvorebinaria();   
        aux.valor = num;
                
        if(num < no.valor) 
            if(no.esq != null)  // vai pra o nó filho à esquerda 
                geraArvore(no.esq,num);   // chamada recursiva
            else
                no.esq = aux;               
        else 
            if(no.dir != null)  // vai pra o nó filho à direita 
                geraArvore(no.dir,num);   // chamada recursiva
            else
                no.dir = aux; 
    }            
    
    public void exibe(Arvorebinaria no){
        if((no!= null)) // critério de continuidade
        {
             exibe(no.esq);             // vai para o nó filho mais à esquerda  
             exibe(no.dir);             // vai para o nó filho mais à direita     
             System.out.println(no.valor + " ");  // primeiro exibe o valor do nó atual
        }
    }     
          
    public static void main( String[] args ) {        
        Arvorebinaria g = new Arvorebinaria();
        int n, v[];
        
        n = Integer.parseInt(JOptionPane.showInputDialog("Quantos elementos serão digitados?"));
        v = new int[n];
        for(int i=0; i<n; i++)
            v[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i+1) + "° número inteiro: "));
        g.valor = v[0];
        for(int i=1; i<n; i++)
            g.geraArvore(g,v[i]);
        g.exibe(g);        
    }    
}


    

