package nhom8.qlgiaodichnhadat.command;

import nhom8.qlgiaodichnhadat.domain.GiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
import nhom8.qlgiaodichnhadat.memento.Originator;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class RemoveCommand implements Command {
    // FIELDS:
    private IGiaoDichManager domain;
    private GiaoDich giaoDich;
    private Originator originator;
    private CareTaker careTaker;

    // CONSTRUCTORS:
    public RemoveCommand(IGiaoDichManager domain, GiaoDich giaoDich, Originator originator, CareTaker careTaker) {
        this.domain = domain;
        this.giaoDich = giaoDich;
        this.originator = originator;
        this.careTaker = careTaker;
    }

    // METHODS:
    @Override
    public void execute() {
        // Use domain to remove giaoDich
        domain.removeGiaoDichs(giaoDich);

        // Tells domain to load data from DB
        domain.getAllGiaoDichs();

        // Save memento
        careTaker.addDone(
            originator.saveMemento()
        );
    }
}
