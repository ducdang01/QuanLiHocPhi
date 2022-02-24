package viewqt;

import controller.Controller;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import model.CongNo;
import model.Khoa;
import model.SinhVien;
import model.ThuChiDauNam;
import model.ThuTheoDangKy;

public class ThemThuChiDauNam extends java.awt.Dialog {

    private QLThuChiDauNam quanLyThuChiDauNam = new QLThuChiDauNam();
    private ArrayList<Khoa> dsKhoa;
    private ArrayList<ThuChiDauNam> dsThuChiDauNam;
    private ArrayList<CongNo> dsCongNo;
    private ArrayList<SinhVien> dsSinhVien;
    private Controller con;
    private Khoa khoaDuocChon;

    public ThemThuChiDauNam(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        con = new Controller();
        khoaDuocChon = null;
        quanLyThuChiDauNam = (QLThuChiDauNam) parent;
        dsKhoa = con.docFile("src/TextJava/khoa.txt");
        dsThuChiDauNam = con.docFile("src/TextJava/thuchidaunam.txt");
        dsCongNo = con.docFile("src/TextJava/congno.txt");
        dsSinhVien = con.docFile("src/TextJava/sinhVien.txt");
        initComponents();
        this.setLocationRelativeTo(null);
        showComBox();
        quanLyThuChiDauNam = (QLThuChiDauNam) parent;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTenKhoanThu = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboKhoa = new javax.swing.JComboBox<>();
        btnThoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(350, 230));
        setTitle("Thêm thu chi đầu năm");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel1.setText("Tên khoản thu");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 20));

        txtTenKhoanThu.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        add(txtTenKhoanThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 170, -1));

        txtGia.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 170, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel2.setText("Giá");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 20));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setText("Khoa");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 20));

        cboKhoa.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        cboKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhoaActionPerformed(evt);
            }
        });
        add(cboKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 170, -1));

        btnThoa.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnThoa.setText("Thoát");
        btnThoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoaActionPerformed(evt);
            }
        });
        add(btnThoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        btnThem.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void cboKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhoaActionPerformed
        // TODO add your handling code here:

        String tenKhoa = cboKhoa.getItemAt(cboKhoa.getSelectedIndex());
        for (int i = 0; i < dsKhoa.size(); i++) {
            Khoa get = dsKhoa.get(i);
            if (get.getTenKhoa().equals(tenKhoa)) {
                khoaDuocChon = get;
                break;
            }
        }
    }//GEN-LAST:event_cboKhoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        Frame frame = new Frame();

        try {
            if (txtTenKhoanThu.getText().equals("") || txtGia.getText().equals("") || khoaDuocChon == null) {
                throw new Exception("Vui lòng nhập đầy đủ thông tin");
            }

            int soMax;
            if (dsThuChiDauNam.size() != 0) {
                ThuChiDauNam maThuChiDauNamMax = Collections.max(dsThuChiDauNam, new Comparator<ThuChiDauNam>() {
                    @Override
                    public int compare(ThuChiDauNam o1, ThuChiDauNam o2) {
                        if (o1.getSoDanhMaTuDong() > o2.getSoDanhMaTuDong()) {
                            return 1;
                        } else if (o1.getSoDanhMaTuDong() > o2.getSoDanhMaTuDong()) {
                            return 0;
                        }
                        return -1;
                    }

                });
                soMax = maThuChiDauNamMax.getSoDanhMaTuDong();
            } else {
                soMax = 0;
            }
            ThuChiDauNam thuChiDauNam = new ThuChiDauNam(khoaDuocChon, soMax + 1, txtTenKhoanThu.getText(), Double.parseDouble(txtGia.getText()));
            dsThuChiDauNam.add(thuChiDauNam);
            for (int i = 0; i < dsSinhVien.size(); i++) {
                SinhVien get = dsSinhVien.get(i);
                if (get.getLop().getKhoa().getMaKhoa().equals(khoaDuocChon.getMaKhoa())) {
                    CongNo congNo = new CongNo(get, thuChiDauNam, false);
                    dsCongNo.add(congNo);
                }
            }
            con.ghiFile(dsThuChiDauNam, "src/TextJava/thuchidaunam.txt");
            con.ghiFile(dsCongNo, "src/TextJava/congno.txt");
            quanLyThuChiDauNam.loadDataTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_btnThoaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemThuChiDauNam dialog = new ThemThuChiDauNam(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoa;
    private javax.swing.JComboBox<String> cboKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtTenKhoanThu;
    // End of variables declaration//GEN-END:variables

    private void showComBox() {
        for (int i = 0; i < dsKhoa.size(); i++) {
            Khoa get = dsKhoa.get(i);
            cboKhoa.addItem(get.getTenKhoa());
        }
    }
}
