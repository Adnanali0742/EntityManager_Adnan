package services.data.api;

import java.util.List;

public interface IDAO<T> {
	
	
	public void create(T entity) throws DataAccessException;
	public void update(T entity) throws DataAccessException;
	public void delete(T entity) throws DataAccessException;
	public List<T> search(T entity) throws DataAccessException;


}
