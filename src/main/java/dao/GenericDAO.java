package dao;

public interface GenericDAO <T>{
	
	boolean inserir(T obj);
	boolean atualizar(T obj);
	void deletarPeloId(Integer id);
	T procurarPeloId(Integer id);

}
