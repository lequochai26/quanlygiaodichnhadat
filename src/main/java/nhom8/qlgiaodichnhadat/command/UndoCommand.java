package nhom8.qlgiaodichnhadat.command;

import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
import nhom8.qlgiaodichnhadat.memento.Originator;
import nhom8.qlgiaodichnhadat.pattern.command.Command;

public class UndoCommand implements Command {
    // FIELDS:
    private Originator<GDMMemento> originator;
    private CareTaker<GDMMemento> careTaker;

    // CONSTRUCTORS:
    public UndoCommand(Originator<GDMMemento> originator,
        CareTaker<GDMMemento> careTaker)
    {
        this.originator = originator;
        this.careTaker = careTaker;
    }

    // METHODS:
    @Override
    public void execute() {
        // Get latest done memento
        GDMMemento latestDone = careTaker.getLatestDone();

        // Get second latest done memento
        GDMMemento secondLatestDone = careTaker.getLatestDone();

        // Latest done null
        if (latestDone == null) {
            return;
        }

        // Second latest done null
        if (secondLatestDone == null) {
            // Add latest done back to careTaker
            careTaker.addDone(latestDone);

            return;
        }

        // Add latestDone into careTaker's undone
        careTaker.addUndone(latestDone);

        // Originator apply memento
        originator.applyMemento(secondLatestDone);

        // Add second latest done back to careTaker's done
        careTaker.addDone(secondLatestDone);
    }
}
