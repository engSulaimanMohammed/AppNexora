package org.example.Interfaces;
import java.util.List;

    public interface Repository<T> {

        void save(T entity);

        T findById(int id);

