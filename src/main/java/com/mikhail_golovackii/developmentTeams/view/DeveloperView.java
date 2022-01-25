
package com.mikhail_golovackii.developmentTeams.view;

import com.mikhail_golovackii.developmentTeams.entity.Developer;

public interface DeveloperView extends BaseView<Developer>{

    public void deleteSkillFromDeveloper();

    public void addSkillToDeveloper();

}
