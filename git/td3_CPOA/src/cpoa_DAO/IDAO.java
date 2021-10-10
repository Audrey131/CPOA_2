package cpoa_DAO;

/**
 * 
 * @author girard144u
 *
 */

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
	T getById(int id);

	List<T> getAll();

	boolean update(T objet);

	boolean create(T objet) throws SQLException;

	boolean delete(T objet);
	
}
