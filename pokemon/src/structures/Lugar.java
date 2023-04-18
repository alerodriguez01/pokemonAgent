package structures;

import java.util.List;
import java.util.Objects;

public class Lugar {

    public Integer id;
    public List<Lugar> lugaresAdyacentes;

    public Lugar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Lugar> getLugaresAdyacentes() {
        return lugaresAdyacentes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lugar lugar = (Lugar) o;
        return id.equals(lugar.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setLugaresAdyacentes(List<Lugar> lugaresAdyacentes) {
        this.lugaresAdyacentes = lugaresAdyacentes;
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "id=" + id +
                '}';
    }
}
