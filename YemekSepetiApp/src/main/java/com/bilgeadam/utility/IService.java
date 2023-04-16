package com.bilgeadam.utility;

import java.util.List;
import java.util.Optional;

public interface IService<T, ID> {
    T save(T t);

    T update(T t);

    Optional<T> findById(ID id);

    List<T> findAll();
}