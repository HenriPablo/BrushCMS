/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.domain;

/**
 *
 * @author rohan
 */
public class GlobalPreferences implements PreferencesInterface {
    
    private boolean allowComments = true;
    
    public final void setAllowComments ( Boolean setting ) {
        this.allowComments = setting;
    }
    public final boolean getAllowComments ( ) {
        return this.allowComments;
    }
}
