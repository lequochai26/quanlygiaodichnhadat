package nhom8.qlgiaodichnhadat.memento;

import java.util.List;

public class GDMMemento {
    // FIELDS:
    private List data;

    // CONSTRUCTORS:
    public GDMMemento(List data) {
        this.data = data;
    }

    // METHODS:
    public List getData() {
        return data;
    }
}
