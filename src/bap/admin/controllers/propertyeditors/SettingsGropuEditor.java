package bap.admin.controllers.propertyeditors;

import java.beans.PropertyEditorSupport;
import bap.persistance.dao.SettingGroupDao;
import bap.settings.SettingsGroup;

/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 2/18/13
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class SettingsGropuEditor  extends PropertyEditorSupport{
    private SettingGroupDao settingGroupDao;

    public SettingsGropuEditor(SettingGroupDao settingGroupDao) {
        this.settingGroupDao = settingGroupDao;
    }

    @Override
    public void setAsText( String text ){
        SettingsGroup children = settingGroupDao.get( Integer.parseInt( text ));
        setValue( children );
    }
}
