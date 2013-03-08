package bap.settings;


import bap.domain.DomainObject;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CascadeType;


import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 12/26/12
 * Time: 9:28 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@SequenceGenerator(name = "settings_group_id_seq", sequenceName = "settings_group_id_seq")
@Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="settings_group")
public class SettingsGroup implements Serializable, DomainObject {

    private int id;
    private String name;
    private String code;

    private List<SettingsGroup> children = new LinkedList<SettingsGroup>();
    private Set<Setting> settings = new HashSet<Setting>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "settings_group_id_seq")
    @Column(name = "id", insertable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column( name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @OneToMany( fetch = FetchType.EAGER)
    @JoinColumn( name = "parent_id")
    @OrderColumn
    public List<SettingsGroup> getChildren() {
        return children;
    }

    public void setChildren(List<SettingsGroup> children) {
        this.children = children;
    }

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "settingsGroup" )
    @Cascade( value={ org.hibernate.annotations.CascadeType.SAVE_UPDATE, CascadeType.DELETE_ORPHAN})
    @OrderColumn
    public Set<Setting> getSettings() {
        return settings;
    }

    public void setSettings(Set<Setting> settings) {
        this.settings = settings;
    }

}
