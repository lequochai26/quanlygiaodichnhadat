package nhom8.qlgiaodichnhadat.command;

import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
import nhom8.qlgiaodichnhadat.memento.Originator;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class RedoCommand implements Command {
    // FIELDS:
    private Originator<GDMMemento> originator;
    private CareTaker<GDMMemento> careTaker;

    // CONSTRUCTORS:
    public RedoCommand(Originator<GDMMemento> originator,
        CareTaker<GDMMemento> careTaker)
    {
        this.originator = originator;
        this.careTaker = careTaker;
    }

    // METHODS:
    @Override
    public void execute() {
        // Get latest undone memento
        GDMMemento latestUndone = careTaker.getLatestUndone();

        // Check latestUndone null
        if (latestUndone == null) {
            return;
        }

        // Apply latest undone memento for originator
        originator.applyMemento(latestUndone);

        // Add latestUndone memento into careTaker's done
        careTaker.addDone(latestUndone);
    }
}
