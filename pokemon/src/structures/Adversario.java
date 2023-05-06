package structures;

import java.util.Objects;

public class Adversario implements Cloneable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adversario that = (Adversario) o;
        return Objects.equals(id, that.id) && Objects.equals(energia, that.energia) && Objects.equals(esMaestro, that.esMaestro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, energia, esMaestro);
    }

    @Override
    public Adversario clone()
    {
        return new Adversario(this.id, this.energia, this.esMaestro);
    }
}

