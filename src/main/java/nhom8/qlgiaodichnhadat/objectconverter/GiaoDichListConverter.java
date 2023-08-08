package nhom8.qlgiaodichnhadat.objectconverter;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;

public class GiaoDichListConverter extends ListArrayConverter<GiaoDich> {
    // STATIC FIELDS:
    private static GiaoDichListConverter instance = new GiaoDichListConverter();

    // STATIC METHODS:
    public static GiaoDichListConverter getInstance() {
        return instance;
    }

    // CONSTRUCTORS:
    private GiaoDichListConverter() {
        // Inherit from super class's default constructor
        super();
    }

    // METHODS:
    @Override
    public GiaoDich[] generateArray() {
        return new GiaoDich[]{};
    }
}
