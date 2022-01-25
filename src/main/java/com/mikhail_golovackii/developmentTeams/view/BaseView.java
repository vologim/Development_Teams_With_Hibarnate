
package com.mikhail_golovackii.developmentTeams.view;

import java.util.List;

public interface BaseView<T> {

    void saveEntity();
    
    void updateEntity();
    
    void showEntityById(T elem);
    
    void showAllEntities(List<T> elem);
    
    void deleteEntity();
}
