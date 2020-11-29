package sub.optimal.jsonrpc.domains;

/**
 *
 * @author Ponec
 */
public class Car {

    private Integer id;

    private String name;

    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name=" + name + ", enabled=" + enabled + '}';
    }
    
    

}
