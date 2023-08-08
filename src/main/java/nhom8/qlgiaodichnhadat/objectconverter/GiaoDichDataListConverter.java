package nhom8.qlgiaodichnhadat.objectconverter;

import nhom8.qlgiaodichnhadat.persistence.dto.GiaoDichData;

public class GiaoDichDataListConverter extends ListArrayConverter<GiaoDichData> {
    // STATIC FIELDS:
    private static GiaoDichDataListConverter instance = new GiaoDichDataListConverter();

    // STATIC METHODS:
    public static GiaoDichDataListConverter getInstance() {
        return instance;
    }
    
    // CONSTRUCTORS:
    private GiaoDichDataListConverter() {
        // Inherit from super class's default constructor
        super();
    }

    // METHODS:
    @Override
    public GiaoDichData[] generateArray() {
        return new GiaoDichData[]{};
    }
}
