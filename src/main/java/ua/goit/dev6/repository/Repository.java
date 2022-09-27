package ua.goit.dev6.repository;

import java.util.List;

public interface Repository<T>{
    long save(T entity);
    void delete(T entity);
    T findById(int id);
    List<T> findAll();
}
