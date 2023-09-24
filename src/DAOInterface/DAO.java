package DAOInterface;

import java.sql.ResultSet;
import java.util.List;

public interface DAO<T> {

    public int create(T data);

    public T read(int id);

    public int update(T data);

    public int delete(int id);

    public List<T> getAll();

    public T getResult(ResultSet rs)throws Exception;
}
