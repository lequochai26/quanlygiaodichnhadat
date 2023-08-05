package nhom8.qlgiaodichnhadat.command;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class RemoveCommand implements Command {
    // FIELDS:
    private IGiaoDichManager domain;
    private GiaoDich giaoDich;

    // CONSTRUCTORS:
    public RemoveCommand(IGiaoDichManager domain, GiaoDich giaoDich) {
        this.domain = domain;
        this.giaoDich = giaoDich;
    }

    // METHODS:
    @Override
    public void execute() {
        // Use domain to remove giaoDich
        domain.removeGiaoDichs(giaoDich);

        // Tells domain to load data from DB
        domain.getAllGiaoDichs();
    }
}
