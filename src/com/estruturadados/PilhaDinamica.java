package com.estruturadados;

public class PilhaDinamica<T> extends Pilha<T>{

	public PilhaDinamica(){
		super(0);
	}
	
	@Override
	public void adicionar(T valor) throws Exception {
		
		Object[] temporario;
		
		this.posicao ++;
		
		temporario = new Object[posicao+1];
		
		for(int i = 0; i < this.posicao; i++){
			temporario[i] = clonarObjeto((T)this.estrutura[i]);
		}
		
		temporario[this.posicao] = clonarObjeto(valor);
		
		this.estrutura = new Object[this.posicao+1];
		
		for(int i = 0; i <= this.posicao; i++){
			this.estrutura[i] = clonarObjeto((T)temporario[i]);
		}
		
	}
	
	
	@Override
	public void remover() throws Exception {
		super.remover();
	}
}
