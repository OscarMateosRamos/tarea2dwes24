package dao;

import java.util.Collection;



public interface OperacionesCrud<T> {

	public long insertar(T elemento);

	public boolean eliminar(T elemento);

	public boolean modificar(T elemento);

	public Collection<T> verTodas();

	public T buscarPorID(long id);

}
