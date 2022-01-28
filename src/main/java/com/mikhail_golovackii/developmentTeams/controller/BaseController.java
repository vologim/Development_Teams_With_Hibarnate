
package com.mikhail_golovackii.developmentTeams.controller;

public interface BaseController<T> {

    void save(T elem);
    
    void updateById(T elem);
    
    void getById(int id);
    
    void getAll();
    
    void deleteById(int id);
    
}
