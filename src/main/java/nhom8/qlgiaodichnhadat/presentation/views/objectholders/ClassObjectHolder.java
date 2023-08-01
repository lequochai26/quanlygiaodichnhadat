package nhom8.qlgiaodichnhadat.presentation.views.objectholders;

public class ClassObjectHolder implements ObjectHolder<Class> {
    // FIELDS:
    private Class classObject;

    // CONSTRUCTORS:
    public ClassObjectHolder(Class cls) {
        this.classObject = cls;
    }

    // METHODS:
    @Override
    public String toString() {
        return classObject.getSimpleName();
    }

    @Override
    public Class getObject() {
        return classObject;
    }

    @Override
    public void setObject(Class object) {
        this.classObject = object;
    }
}