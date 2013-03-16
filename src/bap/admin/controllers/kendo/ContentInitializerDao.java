package bap.admin.controllers.kendo;

import java.io.File;

public interface ContentInitializerDao {
    public String getUserFolder();
    public void setFolderOptions(File rootFolder, File copyFolder, String prettyName);
}
