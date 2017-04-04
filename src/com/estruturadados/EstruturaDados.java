package com.estruturadados;

import java.lang.reflect.Method;
import java.util.Arrays;

public abstract class EstruturaDados<T> {
    
    protected int posicao = -1; 
    protected Object[] estrutura; 
    
    /**
     * 
     * @param tamanho Define a quantidade de elementos que a estrutura poderá armazenar
     */
    public EstruturaDados(int tamanho){
        this.estrutura = new Object[tamanho];
    }
    
    public abstract T recuperar() throws Exception;
    
    public abstract void adicionar (T valor) throws Exception;
    
    public abstract void remover() throws Exception; 
    
    /**
     * Recupera um elemento da estrutura e logo após apaga ele
     * @return Um objeto do tipo guardado na estrutura
     * @throws Exception Caso não seja possivel recuperar ou apagar elementos
     */
    public T recuperarERemover() throws Exception{
    	T recuperado = this.recuperar();
    	this.remover();
    	return recuperado;
    }
    
    /**
     * Usa a posição atual da estrutura para verificar se há elementos
     * @return true se posição é -1, false em qualquer outro caso
     */
    public boolean estaVazio(){
        return (this.posicao == -1);
    }
    
    /**
     * 
     * @return quantidade de posicoes que a estrutura pode armazenar, a quantidade foi definida no construtor
     */
    public int tamanhoEstrutura(){
        return estrutura.length;
    }
    
    /**
     * 
     * @return posicao que a estrutura está apontando atualmente
     */
    public int getPosicaoAtual(){
    	return this.posicao;
    }

    protected T clonarObjeto(T objeto){
    	
    	if(objeto instanceof Cloneable){
    		try{
    			Class<?> classe = objeto.getClass();
        		Method metodo = classe.getMethod("clone", null);
        		return (T) metodo.invoke(objeto, null);
    		}catch(Exception e){}
    		
    	}
    	return objeto;
    }
    
    @Override
    public String toString(){
    	String retorno = "";
    	retorno += "Tamanho da estrutura: " + this.posicao + 1 + "\n";
    	retorno += "Proximo elemento: " + ((this.posicao == -1) ? "null" : this.estrutura[this.posicao].toString()) + "\n";
    	return retorno;
    }
    
    @Override
    public boolean equals(Object o){
    	
    	if(o == null)
    		return false;
    	
    	if(o == this)
    		return true;
    	
    	if(!(o.getClass() == this.getClass()))
    		return false;
    	
    	EstruturaDados comparado = (EstruturaDados)o;
    	
    	if(this.posicao != comparado.posicao)
    		return false;
    	
    	if(posicao == -1)
    		return true;
    	
    	for(int i = 0; i <= posicao; i++){
    		if(this.estrutura[i] != comparado.estrutura[i])
    			return false;
    	}
    	
    	return true;
    	
    }
    
    @Override
    public int hashCode(){
    	int retorno = 777;
    	retorno = retorno * 31 + Arrays.deepHashCode(estrutura);
    	retorno = retorno * 31 + Integer.valueOf(this.posicao).hashCode();
    	return retorno;
    }
    
}
