package service;

import java.util.List;

/**
 * Created by anton on 17.04.17.
 */
public interface Service<T> {
    public List<T> selectAll();
    public T selectById(int id);
    public void remove(int id);
    public void update(T obj);
    public void create(T obj);
}
