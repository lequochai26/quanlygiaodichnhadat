package nhom8.qlgiaodichnhadat.memento;

import java.util.List;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;

public class GDMMemento {
    // FIELDS:
    private List<GiaoDich> data;

    // CONSTRUCTORS:
    public GDMMemento(List<GiaoDich> data) {
        this.data = data;
    }

    // METHODS:
    public List<GiaoDich> getData() {
        return data;
    }
}
