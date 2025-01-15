package ua.com.kisit.courseshop2025.repository.dao;

import java.util.List;

public interface GeneralDao<T> {

    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T findById(Long id);
    List<T> findAll();

}
