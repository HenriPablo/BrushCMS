package bap.admin.controllers.propertyeditors;

import bap.persistance.dao.SettingDao;
import bap.settings.Setting;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 2/18/13
 * Time: 8:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class SettingEditor extends PropertyEditorSupport {
    private SettingDao settingDao;
    public SettingEditor( SettingDao settingDao ){
        this.settingDao = settingDao;
    }

    @Override
    public void setAsText( String text ){
        int id = Integer.parseInt( text );
        Setting setting = settingDao.get( id );
        setValue( setting );
    }
}
