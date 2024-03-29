package com.estruturadados;

public class Fila<T> extends EstruturaDados<T> {
   
	/** Cria uma nova fila com tamanho igual ao passado no parametro
	 * @param tamanho Tamanho da estrutura
	 */
    public Fila(int tamanho){   
        super(tamanho);
    }

    @Override
    public void adicionar(T valor)throws Exception {
        
        if(this.estrutura.length-1 == this.posicao)
            throw new Exception("A fila já está cheia");
        
            this.posicao++;
            this.estrutura[posicao] = clonarObjeto(valor); 
    }
    
    @Override
    public T recuperar() throws Exception{     
            if(estaVazio())
                throw new Exception("Não há nada para ser recuperado na fila");
            
            return clonarObjeto((T)this.estrutura[0]);        
    }

    @Override
    public void remover()throws Exception {
        
        if(estaVazio())
            throw new Exception("Não há nada para ser recuperado na fila");
        
        for(int i=0 ; i < posicao ; i++){
            this.estrutura[i] = this.estrutura[i+1];
        
        }
        
        this.estrutura[posicao] = null; 
        this.posicao--;  
    }
    
    
    
}
