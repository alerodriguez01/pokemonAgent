package structures;

public class Adversario {

    private Integer id;
    private Integer energia;
    private Boolean esMaestro;

    public Adversario(Integer id, Integer energia, Boolean esMaestro) {
        this.id = id;
        this.energia = energia;
        this.esMaestro = esMaestro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public Boolean getEsMaestro() {
        return esMaestro;
    }

    public void setEsMaestro(Boolean esMaestro) {
        this.esMaestro = esMaestro;
    }

    @Override
    public String toString() {
        return "Adversario{" +
                "id=" + id +
                ", energia=" + energia +
                ", esMaestro=" + esMaestro +
                '}';
    }
}
