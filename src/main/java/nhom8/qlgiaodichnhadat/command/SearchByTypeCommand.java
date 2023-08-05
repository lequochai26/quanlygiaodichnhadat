package nhom8.qlgiaodichnhadat.command;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class SearchByTypeCommand implements Command {
    // FIELDS:
    private IGiaoDichManager domain;
    private Class type;

    // CONSTRUCTORS:
    public SearchByTypeCommand(IGiaoDichManager domain, Class type) {
        this.domain = domain;
        this.type = type;
    }

    // METHODS:
    @Override
    public void execute() {
        // Search by type
        domain.getGiaoDichsByType(type);
    }
}
