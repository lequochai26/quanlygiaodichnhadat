package nhom8.qlgiaodichnhadat.presentation.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import nhom8.qlgiaodichnhadat.domain.GiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.IGiaoDichManager;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDich;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDichDat;
import nhom8.qlgiaodichnhadat.domain.entities.GiaoDichNha;
import nhom8.qlgiaodichnhadat.domain.entities.enums.LoaiDat;
import nhom8.qlgiaodichnhadat.domain.entities.enums.LoaiNha;
import nhom8.qlgiaodichnhadat.presentation.GUI;
import nhom8.qlgiaodichnhadat.presentation.controllers.AverageAllController;
import nhom8.qlgiaodichnhadat.presentation.controllers.AverageByTypeController;
import nhom8.qlgiaodichnhadat.presentation.controllers.CloseController;
import nhom8.qlgiaodichnhadat.presentation.controllers.CountAllController;
import nhom8.qlgiaodichnhadat.presentation.controllers.CountGiaoDichByTypeController;
import nhom8.qlgiaodichnhadat.presentation.controllers.DataSelectedController;
import nhom8.qlgiaodichnhadat.presentation.controllers.LoaiGiaoDichSelectedController;
import nhom8.qlgiaodichnhadat.presentation.controllers.RefreshController;
import nhom8.qlgiaodichnhadat.presentation.controllers.RemoveController;
import nhom8.qlgiaodichnhadat.presentation.controllers.SaveController;
import nhom8.qlgiaodichnhadat.presentation.controllers.SearchByKeyWordController;
import nhom8.qlgiaodichnhadat.presentation.controllers.SearchByTypeController;
import nhom8.qlgiaodichnhadat.presentation.controllers.SearchInRangeOfDateController;
import nhom8.qlgiaodichnhadat.presentation.views.objectgetters.MainWindowGiaoDichGetter;
import nhom8.qlgiaodichnhadat.presentation.views.objectgetters.ObjectGetter;
import nhom8.qlgiaodichnhadat.presentation.views.objectholders.ClassObjectHolder;
import nhom8.qlgiaodichnhadat.presentation.views.objectholders.ObjectHolder;

import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

import java.util.Date;
import java.util.List;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;

public class MainWindow extends JFrame implements GUI {
    // FIELDS:
    private ObjectGetter giaoDichGetter;

    private IGiaoDichManager domain;

    private JMenuBar menuBar;
    private JPanel mainPanel;
    private JSpinner jsNgayGiaoDich;
    private JTextField txtDiaChi;
    private JTable tblData;
    private JComboBox cbLoaiGiaoDich;
    private JSpinner jsMaGiaoDich;
    private JSpinner jsDonGia;
    private JSpinner jsDienTich;
    private JComboBox cbLoaiDat;
    private JComboBox cbLoaiNha;
    private JScrollPane spData;
    private JButton btnLuu;
    private JButton btnXoa;
    private JButton btnLamMoi;
    private JMenuItem mniDong;
    private JMenuItem mniHoanTac;
    private JMenuItem mniLamLai;
    private JMenuItem mniTimKiemTuKhoa;
    private JMenuItem mniTimKiemGDDat;
    private JMenuItem mniTimKiemGDNha;
    private JMenuItem mniTimKiemKhoangTG;
    private JMenuItem mniLamMoi;
    private JMenuItem mniSoLuongTatCa;
    private JMenuItem mniSoLuongGDDat;
    private JMenuItem mniSoLuongGDNha;
    private JMenuItem mniTBThanhTienTatCa;
    private JMenuItem mniTBThanhTienGDDat;
    private JMenuItem mniTBThanhTienGDNha;
    private JLabel lblLoaiGiaoDich;
    private JLabel lblMaGiaoDich;
    private JLabel lblNgayGiaoDich;
    private JLabel lblDonGia;
    private JLabel lblDienTich;
    private JLabel lblLoaiDat;
    private JLabel lblLoaiNha;
    private JLabel lblDiaChi;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;

    // CONSTRUCTORS:
    public MainWindow() {
        // Object getters initialization
        giaoDichGetter = new MainWindowGiaoDichGetter(this);

        // Domain initialization
        domain = new GiaoDichManager();

        // View configurations
        setFont(new Font("Arial", Font.PLAIN, 14));
        setTitle("Quản lý giao dịch nhà đất");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 894, 577);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnChuongTrinh = new JMenu("Chương trình");
        menuBar.add(mnChuongTrinh);

        mniDong = new JMenuItem("Đóng");
        mnChuongTrinh.add(mniDong);
        mniDong.addActionListener(new CloseController(this));

        JMenu mnHanhDong = new JMenu("Hành động");
        menuBar.add(mnHanhDong);

        mniHoanTac = new JMenuItem("Hoàn tác");
        mnHanhDong.add(mniHoanTac);

        mniLamLai = new JMenuItem("Làm lại");
        mnHanhDong.add(mniLamLai);

        JMenu mnTimKiem = new JMenu("Tìm kiếm");
        menuBar.add(mnTimKiem);

        mniTimKiemTuKhoa = new JMenuItem("Từ khóa");
        mnTimKiem.add(mniTimKiemTuKhoa);
        mniTimKiemTuKhoa.addActionListener(
            new SearchByKeyWordController(this)
        );

        JMenu mnTimKiemTheoLoai = new JMenu("Loại");
        mnTimKiem.add(mnTimKiemTheoLoai);

        mniTimKiemGDDat = new JMenuItem("Giao dịch đất");
        mnTimKiemTheoLoai.add(mniTimKiemGDDat);
        mniTimKiemGDDat.addActionListener(
            new SearchByTypeController(this, GiaoDichDat.class)
        );

        mniTimKiemGDNha = new JMenuItem("Giao dịch nhà");
        mnTimKiemTheoLoai.add(mniTimKiemGDNha);
        mniTimKiemGDNha.addActionListener(
            new SearchByTypeController(this, GiaoDichNha.class)
        );

        mniTimKiemKhoangTG = new JMenuItem("Khoảng thời gian");
        mnTimKiem.add(mniTimKiemKhoangTG);
        mniTimKiemKhoangTG.addActionListener(
            new SearchInRangeOfDateController(this)
        );

        mniLamMoi = new JMenuItem("Làm mới");
        mnTimKiem.add(mniLamMoi);
        mniLamMoi.addActionListener(
            new RefreshController(this)
        );

        JMenu mnSoLuong = new JMenu("Số lượng");
        menuBar.add(mnSoLuong);

        mniSoLuongTatCa = new JMenuItem("Tất cả");
        mnSoLuong.add(mniSoLuongTatCa);
        mniSoLuongTatCa.addActionListener(
            new CountAllController(this)
        );

        mniSoLuongGDDat = new JMenuItem("Giao dịch đất");
        mnSoLuong.add(mniSoLuongGDDat);
        mniSoLuongGDDat.addActionListener(
            new CountGiaoDichByTypeController(this, GiaoDichDat.class)
        );

        mniSoLuongGDNha = new JMenuItem("Giao dịch nhà");
        mnSoLuong.add(mniSoLuongGDNha);
        mniSoLuongGDNha.addActionListener(
            new CountGiaoDichByTypeController(this, GiaoDichNha.class)
        );

        JMenu mnTBThanhTien = new JMenu("TB thành tiền");
        menuBar.add(mnTBThanhTien);

        mniTBThanhTienTatCa = new JMenuItem("Tất cả");
        mnTBThanhTien.add(mniTBThanhTienTatCa);
        mniTBThanhTienTatCa.addActionListener(
            new AverageAllController(this)
        );

        mniTBThanhTienGDDat = new JMenuItem("Giao dịch đất");
        mnTBThanhTien.add(mniTBThanhTienGDDat);
        mniTBThanhTienGDDat.addActionListener(
            new AverageByTypeController(this, GiaoDichDat.class)
        );

        mniTBThanhTienGDNha = new JMenuItem("Giao dịch nhà");
        mnTBThanhTien.add(mniTBThanhTienGDNha);
        mniTBThanhTienGDNha.addActionListener(
            new AverageByTypeController(this, GiaoDichNha.class)
        );

        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout(0, 0));

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 200));
        mainPanel.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout(0, 2, 0, 0));

        panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(8, 2, 0, 0));

        lblLoaiGiaoDich = new JLabel("Loại giao dịch:");
        lblLoaiGiaoDich.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblLoaiGiaoDich);

        cbLoaiGiaoDich = new JComboBox();
        cbLoaiGiaoDich.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(cbLoaiGiaoDich);
        cbLoaiGiaoDich.addActionListener(
            new LoaiGiaoDichSelectedController(this)
        );

        lblMaGiaoDich = new JLabel("Mã giao dịch:");
        lblMaGiaoDich.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblMaGiaoDich);

        jsMaGiaoDich = new JSpinner();
        jsMaGiaoDich.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jsMaGiaoDich.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(jsMaGiaoDich);

        lblNgayGiaoDich = new JLabel("Ngày giao dịch:");
        lblNgayGiaoDich.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblNgayGiaoDich);

        jsNgayGiaoDich = new JSpinner();
        jsNgayGiaoDich.setModel(new SpinnerDateModel(new Date(1690822800000L), null, null, Calendar.DAY_OF_YEAR));
        jsNgayGiaoDich.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(jsNgayGiaoDich);

        lblDonGia = new JLabel("Đơn giá:");
        lblDonGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblDonGia);

        jsDonGia = new JSpinner();
        jsDonGia.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
        jsDonGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(jsDonGia);

        lblDienTich = new JLabel("Diện tích:");
        lblDienTich.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblDienTich);

        jsDienTich = new JSpinner();
        jsDienTich.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
        jsDienTich.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(jsDienTich);

        lblLoaiDat = new JLabel("Loại đất:");
        lblLoaiDat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblLoaiDat);

        cbLoaiDat = new JComboBox();
        cbLoaiDat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(cbLoaiDat);

        lblLoaiNha = new JLabel("Loại nhà:");
        lblLoaiNha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblLoaiNha);

        cbLoaiNha = new JComboBox();
        cbLoaiNha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(cbLoaiNha);

        lblDiaChi = new JLabel("Địa chỉ:");
        lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblDiaChi);

        txtDiaChi = new JTextField();
        txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtDiaChi.setColumns(10);
        panel_1.add(txtDiaChi);

        panel_2 = new JPanel();
        panel.add(panel_2);
        panel_2.setLayout(new GridLayout(3, 0, 0, 0));

        btnLuu = new JButton("Lưu");
        btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_2.add(btnLuu);
        btnLuu.addActionListener(new SaveController(this));

        btnXoa = new JButton("Xóa");
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_2.add(btnXoa);
        btnXoa.addActionListener(new RemoveController(this));

        btnLamMoi = new JButton("Làm mới");
        btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_2.add(btnLamMoi);
        btnLamMoi.addActionListener(new RefreshController(this));

        spData = new JScrollPane();
        mainPanel.add(spData, BorderLayout.CENTER);

        tblData = new JTable();
        tblData.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {
                    "Loại giao dịch", "Mã giao dịch", "Ngày giao dịch", "Đơn giá", "Diện tích", "Loại đất",
                    "Loại nhà", "Địa chỉ", "Thành tiền"
                }
            )
            {
                boolean[] columnEditables = new boolean[] {
                    false, false, false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int row, int column) {
                    return columnEditables[column];
                }
            }
        );
        spData.setViewportView(tblData);
        tblData.getSelectionModel().addListSelectionListener(
            new DataSelectedController(this)
        );

        // Default setup after configured successfully
        this.setup();
    }

    // METHODS:
    @Override
    public void display() {
        // Set default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set visible
        this.setVisible(true);

        // Set location relative to
        this.setLocationRelativeTo(null);

        // Startup
        startup();
    }

    public void setData(List data) {
        // Get DefaultTableModel from tblData
        DefaultTableModel model = (DefaultTableModel)tblData.getModel();

        // Clear table
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        // Updating
        for (Object obj : data) {
            // Check if obj instance of GiaoDich
            if (!(obj instanceof GiaoDich)) {
                continue;
            }

            // Cast to GiaoDich, GiaoDichDat and GiaoDichNha as needed
            GiaoDich giaoDich = (GiaoDich)obj;
            GiaoDichDat giaoDichDat = (
                (giaoDich instanceof GiaoDichDat) ?
                (GiaoDichDat)giaoDich :
                null
            );
            GiaoDichNha giaoDichNha = (
                (giaoDich instanceof GiaoDichNha) ?
                (GiaoDichNha)giaoDich :
                null
            );

            // Add row with specified data inside
            model.addRow(
                new Object[] {
                    giaoDich.getClass().getSimpleName(),
                    giaoDich.getMaGiaoDich(),
                    giaoDich.getNgayGiaoDich(),
                    giaoDich.getDonGia(),
                    giaoDich.getDienTich(),
                    (
                        (giaoDichDat != null) ?
                        giaoDichDat.getLoaiDat() :
                        null
                    ),
                    (
                        (giaoDichNha != null) ?
                        giaoDichNha.getLoaiNha() :
                        null
                    ),
                    (
                        (giaoDichNha != null) ?
                        giaoDichNha.getDiaChi() :
                        null
                    ),
                    giaoDich.tinhThanhTien()
                }
            );
        }
    }
    
    public void setGiaoDich(GiaoDich giaoDich) {
        // Check null
        if (giaoDich == null) {
            return;
        }

        // Get necessary informations
        GiaoDichDat giaoDichDat = null;
        GiaoDichNha giaoDichNha = null;
        Class loaiGiaoDich = giaoDich.getClass();
        int maGiaoDich = giaoDich.getMaGiaoDich();
        Date ngayGiaoDich = giaoDich.getNgayGiaoDich();
        double donGia = giaoDich.getDonGia();
        double dienTich = giaoDich.getDienTich();
        
        // Updating
        if (loaiGiaoDich == GiaoDichDat.class) {
            cbLoaiGiaoDich.setSelectedIndex(0);
            giaoDichDat = (GiaoDichDat)giaoDich;
        }
        else {
            cbLoaiGiaoDich.setSelectedIndex(1);
            giaoDichNha = (GiaoDichNha)giaoDich;
        }
        jsMaGiaoDich.setValue(maGiaoDich);
        jsNgayGiaoDich.setValue(ngayGiaoDich);
        jsDonGia.setValue(donGia);
        jsDienTich.setValue(dienTich);
        
        if (giaoDichDat != null) {
            cbLoaiDat.setSelectedItem(giaoDichDat.getLoaiDat());
        } 
        else {
            cbLoaiNha.setSelectedItem(giaoDichNha.getLoaiNha());
            txtDiaChi.setText(giaoDichNha.getDiaChi());
        }
    }

    private void setup() {
        // cbLoaiGiaoDich setup
        cbLoaiGiaoDich.addItem(new ClassObjectHolder(GiaoDichDat.class));
        cbLoaiGiaoDich.addItem(new ClassObjectHolder(GiaoDichNha.class));

        // cbLoaiDat setup
        cbLoaiDat.addItem(LoaiDat.A);
        cbLoaiDat.addItem(LoaiDat.B);
        cbLoaiDat.addItem(LoaiDat.C);

        // cbLoaiNha setup
        cbLoaiNha.addItem(LoaiNha.THUONG);
        cbLoaiNha.addItem(LoaiNha.CAOCAP);
    }   

    private void startup() {
        // Get all GiaoDich objects
        List all = domain.getAllGiaoDichs();

        // Check all and update tblData
        if (all != null) {
            setData(all);
        }
    }

    public ObjectGetter getGiaoDichGetter() {
        return giaoDichGetter;
    }

    public IGiaoDichManager getDomain() {
        return domain;
    }

    public JTable getTblData() {
        return tblData;
    }

    public JComboBox getCbLoaiGiaoDich() {
        return cbLoaiGiaoDich;
    }

    public JSpinner getJsMaGiaoDich() {
        return jsMaGiaoDich;
    }

    public JSpinner getJsNgayGiaoDich() {
        return jsNgayGiaoDich;
    }

    public JSpinner getJsDonGia() {
        return jsDonGia;
    }

    public JSpinner getJsDienTich() {
        return jsDienTich;
    }

    public JComboBox getCbLoaiDat() {
        return cbLoaiDat;
    }

    public JComboBox getCbLoaiNha() {
        return cbLoaiNha;
    }

    public JTextField getTxtDiaChi() {
        return txtDiaChi;
    }
}