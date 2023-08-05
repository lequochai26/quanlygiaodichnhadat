package nhom8.qlgiaodichnhadat.command;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class SaveCommand implements Command {
    // FIELDS:
    private IGiaoDichManager domain;
    private GiaoDich giaoDich;

    // CONSTRUCTORS:
    public SaveCommand(IGiaoDichManager domain, GiaoDich giaoDich) {
        this.domain = domain;
        this.giaoDich = giaoDich;
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
    }
}
