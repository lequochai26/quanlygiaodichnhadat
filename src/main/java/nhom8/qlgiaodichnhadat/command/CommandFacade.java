package nhom8.qlgiaodichnhadat.command;

import javax.swing.JFrame;

import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.memento.CareTaker;
import nhom8.qlgiaodichnhadat.memento.GDMMemento;
import nhom8.qlgiaodichnhadat.memento.Originator;

public class CommandFacade {
    // STATIC FIELDS:
    private static CommandFacade instance = new CommandFacade();

    // STATIC METHODS:
    public static CommandFacade getInstance() {
        return instance;
    }

    // CONSTRUCTORS:
    private CommandFacade() {

    }

    // METHODS:
    public void executeAverageAllCommand(JFrame frame, IGiaoDichManager domain) {
        // Create and execute command
        new AverageAllCommand(frame, domain).execute();
    }

    public void executeAverageByTypeCommand(JFrame frame, IGiaoDichManager domain, Class type) {
        // Create and execute command
        new AverageByTypeCommand(frame, domain, type).execute();
    }

    public void executeCheckHashCommand(JFrame frame, Object target) {
        // Create and execute command
        new CheckHashCommand(frame, target).execute();
    }

    public void executeCountAllCommand(JFrame frame, IGiaoDichManager domain) {
        // Create and execut command
        new CountAllCommand(frame, domain).execute();
    }

    public void executeCountByTypeCommand(JFrame frame, IGiaoDichManager domain, Class type) {
        // Create and execute command
        new CountByTypeCommand(frame, domain, type).execute();;
    }

    public void executeGetHashCommand(JFrame frame, Object target) {
        // Create and execute command
        new GetHashCommand(frame, target).execute();;
    }

    public void executeRedoCommand(Originator<GDMMemento> originator, CareTaker<GDMMemento> careTaker) {
        // Create and execute command
        new RedoCommand(originator, careTaker).execute();
    }

    public void executeRefreshCommand(IGiaoDichManager domain) {
        // Create and execute command
        new RefreshCommand(domain).execute();
    }

    public void executeRemoveCommand(IGiaoDichManager domain, GiaoDich giaoDich, Originator<GDMMemento> originator, CareTaker<GDMMemento> memento) {
        // Create and execute command
        new RemoveCommand(domain, giaoDich, originator, memento).execute();
    }

    public void executeSaveCommand(IGiaoDichManager domain, GiaoDich giaoDich, Originator<GDMMemento> originator, CareTaker<GDMMemento> careTaker) {
        // Create and execute command
        new SaveCommand(domain, giaoDich, originator, careTaker).execute();
    }

    public void executeSearchByHashCommand(JFrame frame, IGiaoDichManager domain) {
        // Create and execute command
        new SearchByHashCommand(frame, domain).execute();
    }

    public void executeSearchByIdCommand(JFrame frame, IGiaoDichManager domain) {
        // Create and execute command
        new SearchByIdCommand(frame, domain).execute();
    }

    public void executeSearchByKeyWordCommand(JFrame frame, IGiaoDichManager domain) {
        // Create and execute command
        new SearchByKeyWordCommand(frame, domain).execute();
    }

    public void executeSearchByTypeCommand(IGiaoDichManager domain, Class type) {
        // Create and execute command
        new SearchByTypeCommand(domain, type).execute();
    }

    public void executeSearchInRangeOfDateCommand(JFrame frame, IGiaoDichManager domain) {
        // Create and execute command
        new SearchInRangeOfDateCommand(frame, domain).execute();
    }

    public void executeUndoCommand(Originator<GDMMemento> originator, CareTaker<GDMMemento> careTaker) {
        // Create and execute command
        new UndoCommand(originator, careTaker).execute();
    }
}
