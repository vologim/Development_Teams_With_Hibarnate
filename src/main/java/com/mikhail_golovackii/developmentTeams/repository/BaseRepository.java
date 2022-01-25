
package com.mikhail_golovackii.developmentTeams.repository;

import java.util.List;

public interface BaseRepository<T> {

    void save(T elem);
    
    void updateById(int id, T elem);
    
    T getById(int id);
    
    List<T> getAll();
    
    void deleteById(int id);
}
