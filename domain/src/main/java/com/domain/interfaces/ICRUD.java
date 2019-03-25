package com.domain.interfaces;

import java.util.List;

public interface ICRUD<T, R> {

    R create(T entity);

    T read(long id);
    Iterable readAll();

    R update(T entity);

    void delete(long id);
}
