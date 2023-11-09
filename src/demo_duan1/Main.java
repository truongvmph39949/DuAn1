package demo_duan1;

import Model.ChitietSP;
import Model.DanhMuc;
import Model.SanPham;
import Model.ThuongHie;
import Model.XuatSu;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import demo_duan1.Login;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import sevice.DBconnect1;
import sevice.SanPhamService;

/**
 *
 * @author Nguyen Truc
 */
public class Main extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private DefaultTableModel mol = new DefaultTableModel();
    private SanPhamService service = new SanPhamService();
    private int index = -1;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fillTable(service.getAll());
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Main.this.getRootPane().setBorder(new LineBorder(new Color(76, 41, 211)));

    }

    public void fillTable(List<ChitietSP> list) {
        mol = (DefaultTableModel) tblBang.getModel();
        mol.setRowCount(0);
        for (ChitietSP chitietSP : list) {
            mol.addRow(chitietSP.toDataRow());
        }
    }

    public void showData(int index) {

        ChitietSP chitietSP = service.getAll().get(index);
        txtMaSP.setText(chitietSP.getSanPham().getMaSP());
        txtDanhMuc.setText(String.valueOf(chitietSP.getSanPham().getDanhMuc().getTenDM()));

        txtDanhMuc.setText(chitietSP.getSanPham().getDanhMuc().getTenDM().toString());

        txtTenSP.setText(chitietSP.getSanPham().getTenSP().toString());

        txtSL.setText(chitietSP.getSanPham().getSoluong().toString());

        if (chitietSP.getSanPham().getTrangThai().equals("1")) {
            rdoCon.setSelected(true);
        } else {
            RdoHet.setSelected(true);
        }
        txtGia.setText(chitietSP.getSanPham().getGia().toString());

        txtXuatXu.setText(chitietSP.getSanPham().getXuatSu().toString());

        txtThuonghieu.setText(chitietSP.getSanPham().getThuongHie().toString());

        cboKichCo.setSelectedItem(String.valueOf(chitietSP.getKichCO().getSize()));
        cboMauSac.setSelectedItem(String.valueOf(chitietSP.getMauSac()));
        txtChatLieu.setText(chitietSP.getChatLieu().toString());
        txtPnMoTa.setText(chitietSP.getSanPham().getMota());
    }

    public boolean validateForm() {
        List<ChitietSP> list = service.getAll();

        if (txtDanhMuc.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return false;
        }
        for (ChitietSP chitietSP : list) {
            String danhmuc = chitietSP.getSanPham().getDanhMuc().getTenDM();

        }
        if (txtMaSP.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return false;
        }
        if (txtTenSP.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return false;
        }
        if (txtSL.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return false;
        }
        if (txtXuatXu.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return false;
        }
        if (txtThuonghieu.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return false;
        }
        if (txtChatLieu.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return false;
        }
        if (txtGia.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return false;
        }
        if (Integer.parseInt(txtGia.getText().trim()) <= 0) {
            JOptionPane.showMessageDialog(this, "Giá sai!");
            return false;
        }
        if (txtPnMoTa.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return false;
        }
        boolean flag = false;
        for (ChitietSP chitietSP : list) {
            String danhmuc = chitietSP.getSanPham().getDanhMuc().getTenDM();
            String maSP = chitietSP.getSanPham().getMaSP();
            String xuatXu = chitietSP.getSanPham().getXuatSu().getXuatXu();
            String thuongHieu = chitietSP.getSanPham().getThuongHie().getTenTH();
            String chatLieu = chitietSP.getChatLieu().getTenCL();
            if (!danhmuc.equals(txtDanhMuc.getText().trim())) {
                flag = true;
            }
            if (maSP.equals(txtMaSP.getText().trim())) {
                flag = true;
            }
            if (!xuatXu.equals(txtXuatXu.getText().trim())) {
                flag = true;
            }
            if (!thuongHieu.equals(txtThuonghieu.getText().trim())) {
                flag = true;
            }
            if (!chatLieu.equals(txtChatLieu.getText().trim())) {
                flag = true;
            }
        }
        if (flag) {
            return false;
        }
        return true;
    }
    // hàm trong tab thuộc tính sản phẩm, đưa dữ liệu sau khi được thêm hoặc sửa rồi fill lên bảng

    public void fillThuocTinh(List<ChitietSP> list) {
        mol = (DefaultTableModel) tblThongTinThuocTinh.getModel();
        mol.setRowCount(0);
        int i = 1;
        Object ob = null, ob1 = null;
        for (ChitietSP chitietSP : list) {
            if (rdMauSac.isSelected()) {
                ob = "Màu sắc";
                ob1 = chitietSP.getMauSac().getTenMau();
            } else if (rdChatLieu.isSelected()) {
                ob = "Chất liệu";
                ob1 = chitietSP.getChatLieu().getTenCL();
            } else if (rdKichCo.isSelected()) {
                ob = "Kích cỡ";
                ob1 = chitietSP.getKichCO().getSize();
            } else if (rdDanhMuc.isSelected()) {
                ob = "Danh mục";
                ob1 = chitietSP.getSanPham().getDanhMuc().getTenDM();
            } else if (rdXuatXU.isSelected()) {
                ob = "Xuất xứ";
                ob1 = chitietSP.getSanPham().getXuatSu().getXuatXu();
            } else if (rdThuongHieu.isSelected()) {
                ob = "Thương hiệu";
                ob1 = chitietSP.getSanPham().getThuongHie().getTenTH();
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn thuộc tính!");
                return;
            }
            mol.addRow(new Object[]{
                i, ob, ob1
            });
            i++;
        }
    }

    public SanPham getDataOnForm() {
        List<ChitietSP> list = service.getAll();
        String maSP, tenSP, soLuong, trangThai, gia, ma_DM = null, ma_XX = null, ma_TH = null, mota;
        for (ChitietSP chitietSP : list) {
            String danhmuc = chitietSP.getSanPham().getDanhMuc().getTenDM();
            if (danhmuc.equals(txtDanhMuc.getText().trim())) {
                ma_DM = chitietSP.getSanPham().getDanhMuc().getMaDM();
                break;
            }
        }
        DanhMuc danhMuc = new DanhMuc(ma_DM, txtDanhMuc.getText().trim());
        for (ChitietSP chitietSP : list) {
            String xuatXu = chitietSP.getSanPham().getXuatSu().getXuatXu();
            if (xuatXu.equals(txtXuatXu.getText().trim())) {
                ma_XX = chitietSP.getSanPham().getXuatSu().getMaXX();
                break;
            }
        }
        XuatSu xuatXu = new XuatSu(ma_XX, txtXuatXu.getText().trim());
        for (ChitietSP chitietSP : list) {
            String thuongHieu = chitietSP.getSanPham().getThuongHie().getTenTH();
            if (thuongHieu.equals(txtThuonghieu.getText().trim())) {
                ma_DM = chitietSP.getSanPham().getDanhMuc().getMaDM();
                break;
            }
        }
        ThuongHie thuongHieu = new ThuongHie(ma_TH, txtThuonghieu.getText().trim());
        maSP = txtMaSP.getText();
        tenSP = txtTenSP.getText();
        soLuong = txtSL.getText();
        if (Integer.parseInt(soLuong) > 0) {
            trangThai = "1";
        } else {
            trangThai = "0";
        }
        gia = txtGia.getText();
        mota = txtPnMoTa.getText();

        return new SanPham(maSP, tenSP, soLuong, trangThai, danhMuc, thuongHieu, xuatXu, gia, mota);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        TTSP = new javax.swing.JTabbedPane();
        thongTinSP = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        rdoCon = new javax.swing.JRadioButton();
        RdoHet = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtXuatXu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtChatLieu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboKichCo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtThuonghieu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDanhMuc = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtPnMoTa = new javax.swing.JTextPane();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        rdMauSac = new javax.swing.JRadioButton();
        rdKichCo = new javax.swing.JRadioButton();
        rdChatLieu = new javax.swing.JRadioButton();
        rdDanhMuc = new javax.swing.JRadioButton();
        btnThemThuocTinh = new javax.swing.JButton();
        btnSuaThuocTinh = new javax.swing.JButton();
        btnAnThuocTinh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rdXuatXU = new javax.swing.JRadioButton();
        rdThuongHieu = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThongTinThuocTinh = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        banHang = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();

        jButton3.setText("jButton3");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton4.setText("jButton4");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SNAKE G1");
        setBackground(new java.awt.Color(51, 51, 255));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.setOpaque(true);

        jLabel2.setText("Tên sản phẩm");

        jLabel3.setText("Số lượng ");

        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
            }
        });

        txtSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoCon);
        rdoCon.setText("Còn hàng");

        buttonGroup1.add(RdoHet);
        RdoHet.setText("Hết hàng ");

        jLabel4.setText("Giá ");

        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        jLabel5.setText("Xuất xứ ");

        txtXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXuatXuActionPerformed(evt);
            }
        });

        jLabel6.setText("Thương hiệu ");

        txtChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChatLieuActionPerformed(evt);
            }
        });

        jLabel7.setText("Trạng Thái");

        jLabel8.setText("Mã sản phẩm");

        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });

        jLabel9.setText("Màu sắc");

        cboKichCo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "31", "32", "33" }));

        jLabel10.setText("Kích cỡ ");

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đen", "Đỏ", "Trắng" }));

        jLabel11.setText("Chất liệu");

        txtThuonghieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThuonghieuActionPerformed(evt);
            }
        });

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên SP", "Số lượng", "Trạng thái", "Giá", "Xuất xứ", "Thương hiệu", "Kích cỡ", "Màu sắc", "Chất liệu", "Danh mục"
            }
        ));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Notes.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel12.setText("Danh mục");

        txtDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDanhMucActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(txtPnMoTa);

        jLabel13.setText("Mô tả");

        javax.swing.GroupLayout thongTinSPLayout = new javax.swing.GroupLayout(thongTinSP);
        thongTinSP.setLayout(thongTinSPLayout);
        thongTinSPLayout.setHorizontalGroup(
            thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thongTinSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(thongTinSPLayout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(thongTinSPLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(thongTinSPLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(thongTinSPLayout.createSequentialGroup()
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(thongTinSPLayout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(txtDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongTinSPLayout.createSequentialGroup()
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(thongTinSPLayout.createSequentialGroup()
                                .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongTinSPLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RdoHet, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(thongTinSPLayout.createSequentialGroup()
                                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(thongTinSPLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongTinSPLayout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongTinSPLayout.createSequentialGroup()
                                            .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txtThuonghieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(28, 28, 28))))
        );
        thongTinSPLayout.setVerticalGroup(
            thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thongTinSPLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDanhMuc)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(thongTinSPLayout.createSequentialGroup()
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSP)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSP)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoCon)
                            .addComponent(RdoHet)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(thongTinSPLayout.createSequentialGroup()
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThuonghieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(thongTinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua))
                .addGap(128, 128, 128))
        );

        TTSP.addTab("Thông tin sản phẩm", thongTinSP);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thuộc tính sản phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(98, 97, 97))); // NOI18N

        buttonGroup2.add(rdMauSac);
        rdMauSac.setText("Màu sắc");
        rdMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMauSacActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdKichCo);
        rdKichCo.setText("Kích cỡ");
        rdKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdKichCoActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdChatLieu);
        rdChatLieu.setText("Chất liệu");

        buttonGroup2.add(rdDanhMuc);
        rdDanhMuc.setText("Danh mục");

        btnThemThuocTinh.setText("Thêm");
        btnThemThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemThuocTinhMouseClicked(evt);
            }
        });

        btnSuaThuocTinh.setText("Sửa");
        btnSuaThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaThuocTinhMouseClicked(evt);
            }
        });

        btnAnThuocTinh.setText("Ẩn");

        jLabel1.setText("Tên thuộc tính");

        buttonGroup2.add(rdXuatXU);
        rdXuatXU.setText("Xuất xứ");

        buttonGroup2.add(rdThuongHieu);
        rdThuongHieu.setText("Thương hiệu");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdChatLieu)
                            .addComponent(rdMauSac))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdKichCo)
                            .addComponent(rdDanhMuc))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdThuongHieu)
                            .addComponent(rdXuatXU))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemThuocTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnSuaThuocTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnThuocTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemThuocTinh)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdMauSac)
                    .addComponent(rdKichCo)
                    .addComponent(btnSuaThuocTinh)
                    .addComponent(rdXuatXU))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAnThuocTinh)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdDanhMuc)
                            .addComponent(rdChatLieu)
                            .addComponent(rdThuongHieu))
                        .addGap(66, 66, 66))))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI Black", 0, 14), new java.awt.Color(142, 135, 135))); // NOI18N

        tblThongTinThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Loại thuộc tính", "Tên thuộc tính"
            }
        ));
        jScrollPane2.setViewportView(tblThongTinThuocTinh);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jButton1.setText("Hiển thị thuộc tính đã ẩn");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );

        TTSP.addTab("Thuộc tính sản phẩm", jPanel2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(TTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(TTSP)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Sản phẩm ", new javax.swing.ImageIcon(getClass().getResource("/Icons/trainers (1).png")), jPanel5); // NOI18N

        javax.swing.GroupLayout banHangLayout = new javax.swing.GroupLayout(banHang);
        banHang.setLayout(banHangLayout);
        banHangLayout.setHorizontalGroup(
            banHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        banHangLayout.setVerticalGroup(
            banHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(" Bán hàng", new javax.swing.ImageIcon(getClass().getResource("/Icons/Add to basket.png")), banHang); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Hoá đơn ", new javax.swing.ImageIcon(getClass().getResource("/Icons/Price list.png")), jPanel4); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Khuyến mãi", new javax.swing.ImageIcon(getClass().getResource("/Icons/Label.png")), jPanel6); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thống kê", new javax.swing.ImageIcon(getClass().getResource("/Icons/Diagram.png")), jPanel7); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Nhân Viên ", new javax.swing.ImageIcon(getClass().getResource("/Icons/User group.png")), jPanel8); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Đăng xuất", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdMauSacActionPerformed

    private void rdKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdKichCoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdKichCoActionPerformed

    private void btnThemThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemThuocTinhMouseClicked
        if (jTextField2.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền tên thuộc tính!");
            return;
        }
        fillThuocTinh(service.getAll());
    }//GEN-LAST:event_btnThemThuocTinhMouseClicked

    private void btnSuaThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaThuocTinhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaThuocTinhMouseClicked

    private void txtDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDanhMucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDanhMucActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked

        index = tblBang.getSelectedRow();
        this.showData(index);
    }//GEN-LAST:event_tblBangMouseClicked

    private void txtThuonghieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThuonghieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThuonghieuActionPerformed

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void txtChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChatLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChatLieuActionPerformed

    private void txtXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXuatXuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXuatXuActionPerformed

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed

    private void txtSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSLActionPerformed

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
       
            SanPham sp = getDataOnForm();
            if (service.add(sp) > 1) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillTable(service.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
                fillTable(service.getAll());
            }
       
    }//GEN-LAST:event_btnThemMouseClicked
    int xy, xx;

    void setColor(JPanel panel) {
        panel.setBackground(new Color(135, 112, 225));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(76, 41, 211));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RdoHet;
    private javax.swing.JTabbedPane TTSP;
    private javax.swing.JPanel banHang;
    private javax.swing.JButton btnAnThuocTinh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaThuocTinh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemThuocTinh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboKichCo;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton rdChatLieu;
    private javax.swing.JRadioButton rdDanhMuc;
    private javax.swing.JRadioButton rdKichCo;
    private javax.swing.JRadioButton rdMauSac;
    private javax.swing.JRadioButton rdThuongHieu;
    private javax.swing.JRadioButton rdXuatXU;
    private javax.swing.JRadioButton rdoCon;
    private javax.swing.JTable tblBang;
    private javax.swing.JTable tblThongTinThuocTinh;
    private javax.swing.JPanel thongTinSP;
    private javax.swing.JTextField txtChatLieu;
    private javax.swing.JTextField txtDanhMuc;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextPane txtPnMoTa;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtThuonghieu;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}
