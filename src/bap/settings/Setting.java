package bap.settings;

import bap.domain.DomainObject;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 12/26/12
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@SequenceGenerator( name = "setting_id_seq", sequenceName = "setting_id_seq")
@Cache( usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table( name = "image")
public class Setting implements DomainObject {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "setting_id_seq")
    @Column( name = "id", insertable = false )
    private int id = 0;

    private String code = "";
    private String label = "";
    private String value = "";
    private String hint = "";

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "settings_group_id", nullable = false)
    private SettingsGroup settingsGroup;



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getHint() {

        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SettingsGroup getSettingsGroup() {
        return settingsGroup;
    }

    public void setSettingsGroup(SettingsGroup settingsGroup) {
        this.settingsGroup = settingsGroup;
    }
}
