
package com.mikhail_golovackii.developmentTeams.controller;

import java.util.List;

public interface BaseController<T> {

    void save(T elem);
    
    void updateById(int id, T elem);
    
    void getById(int id);
    
    void getAll();
    
    void deleteById(int id);
    
}
