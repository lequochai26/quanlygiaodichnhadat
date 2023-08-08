package nhom8.qlgiaodichnhadat.objectconverter;

import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDichDat;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDichNha;
import nhom8.qlgiaodichnhadat.notifiers.ErrorNotifier;
import nhom8.qlgiaodichnhadat.notifiers.Notifier;
import nhom8.qlgiaodichnhadat.persistence.dto.GiaoDichData;

public class GiaoDichConverter implements ObjectConverter<GiaoDich,GiaoDichData> {
    // STATIC FIELDS:
    private static GiaoDichConverter instance = new GiaoDichConverter();

    // STATIC METHODS:
    public static GiaoDichConverter getInstance() {
        return instance;
    }

    // FIELDS:
    private Notifier errorNotifier;

    // CONSTRUCTORS:
    private GiaoDichConverter() {
        // Get error notifier
        errorNotifier = ErrorNotifier.getInstance();
    }

    // METHODS:
    @Override
    public GiaoDichData convert(GiaoDich obj) {
        return obj.getData();
    }

    @Override
    public GiaoDich reverse(GiaoDichData obj) {
        // Target declaration
        GiaoDich target = null;

        // Loai giao dich declaration
        Class loaiGiaoDich = null;

        try {
            // Get loai giao dich
            loaiGiaoDich = Class.forName(obj.getLoaiGiaoDich());
        }
        catch (Exception e) {
            errorNotifier.notify(
                e.getStackTrace()
            );
        }

        // Check loaiGiaoDich and initial target
        if (loaiGiaoDich != null) {
            if (loaiGiaoDich == GiaoDichDat.class) {
                target = new GiaoDichDat();
            }
            else {
                target = new GiaoDichNha();
            }
        }

        // Check target and load data
        if (target != null) {
            target.loadData(obj);
        }

        // Return
        return target;
    }
}
