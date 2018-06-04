package com.lucentit.pecuniam.domain.repository;

import java.util.List;

public interface BaseRepository<T, TID> {
    void save(T obj);
    void delete(T obj);
    void deleteById(TID id);
    List<T> returnAll();
    T returnById(TID id);
}
