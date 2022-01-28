
package com.mikhail_golovackii.developmentTeams.service;

import java.util.List;

public interface BaseService<T> {

    void save(T elem);
    
    void updateById(T elem);
    
    T getById(int id);
    
    List<T> getAll();
    
    void deleteById(int id);
}
