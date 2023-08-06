package nhom8.qlgiaodichnhadat.command;

import nhom8.qlgiaodichnhadat.domain.GiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
import nhom8.qlgiaodichnhadat.memento.Originator;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class SaveCommand implements Command {
    // FIELDS:
    private IGiaoDichManager domain;
    private GiaoDich giaoDich;
    private Originator originator;
    private CareTaker careTaker;

    // CONSTRUCTORS:
    public SaveCommand(IGiaoDichManager domain, GiaoDich giaoDich, Originator originator, CareTaker careTaker) {
        this.domain = domain;
        this.giaoDich = giaoDich;
        this.originator = originator;
        this.careTaker = careTaker;
    }

    // METHODS:
    @Override
    public void execute() {
        // Check if giaoDich existed and replace if different type
        int maGiaoDich = giaoDich.getMaGiaoDich();
        GiaoDich gd = domain.getGiaoDich(maGiaoDich);
        if (gd != null) {
            if (gd.getClass() != giaoDich.getClass()) {
                domain.removeGiaoDichs(gd);
            }
        }

        // Save giaoDich using domain
        domain.saveGiaoDichs(giaoDich);

        // Tells domain to load DB
        domain.getAllGiaoDichs();

        // Save a done memento
        careTaker.addDone(
            originator.saveMemento()
        );
    }
}
