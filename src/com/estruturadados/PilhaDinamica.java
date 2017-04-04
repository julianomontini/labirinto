package com.estruturadados;

/**
 * Classe que guarda objetos e muda de tamanho de acordo com a quantidade de elementos.
 * @author Juliano Montini
 * @param <T> Qualquer objeto
 */
public class PilhaDinamica<T> extends Pilha<T>{

	/**
	 * Inicializa a pilha com tamanho 0.
	 */
	public PilhaDinamica(){
		super(0);
	}
	
	/**
	 * Guardar um elemento do tipo T na estrutura.
	 * Para cada elemento adicionado, a estrutura cresce em 1 elemento.
	 * @param valor Qualquer objeto do tipo T a ser guardado na estrutura
	 */
	@Override
	public void adicionar(T valor){
		
		this.posicao ++;
		
		Object[] temporario;
		
		temporario = new Object[posicao+1];
		
		for(int i = 0; i < this.posicao; i++){
			temporario[i] = clonarObjeto((T)this.estrutura[i]);
		}
		
		this.estrutura = new Object[this.posicao+1];
		
		for(int i = 0; i <= this.posicao; i++){
			this.estrutura[i] = clonarObjeto((T)temporario[i]);
		}
		
		this.estrutura[posicao] = clonarObjeto(valor);
		
	}
	
	/**
	 * Remove o último elemento da pilha.
	 * Para cada elemento removido, a estrutura diminui o tamanho em 1 elemento.
	 */
	@Override
	public void remover() throws Exception {
		
		if(estaVazio())
			throw new Exception("A pilha já está vazia");
		
		this.posicao--;
		
		Object[] temporario;
		
		temporario = new Object[posicao+1];
		
		for(int i = 0; i <= this.posicao; i++){
			temporario[i] = clonarObjeto((T)this.estrutura[i]);
		}
		
		this.estrutura = new Object[this.posicao+1];
		
		for(int i = 0; i <= this.posicao; i++){
			this.estrutura[i] = clonarObjeto((T)temporario[i]);
		}
		
	}
	
	/**
	 * Recupera o ultimo elemento da pilha, retorna o valor e então desempilha o valor recuperado.
	 */
	@Override
	public T recuperarERemover() throws Exception {
		Object retorno = this.recuperar();
		this.remover();
		return (T)retorno;
	}
	
}
