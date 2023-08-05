package nhom8.qlgiaodichnhadat.command;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class RefreshCommand implements Command {
    // FIELDS:
    private IGiaoDichManager domain;

    // CONSTRUCTORS:
    public RefreshCommand(IGiaoDichManager domain) {
        this.domain = domain;
    }

    // METHODS:
    @Override
    public void execute() {
        // Tells domain to load data
        domain.getAllGiaoDichs();
    }
}
