package bap.services;

import bap.persistance.dao.SettingDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 6/9/13
 * Time: 11:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropDBFetcher {

    @Autowired
    SettingDao settingDao;

    public String getSetting( String settingCode ){
        return  settingDao.getSettingByCode( settingCode ).getValue();
    }
}
