package viewsv;

import controller.Controller;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.CongNo;
import model.GiaoDich;
import model.SinhVien;
import model.TaiKhoan;
import model.Thu;
import model.ThuTheoDangKy;

public class RutTien extends java.awt.Dialog {

    private SinhVien sinhVien;
    private ArrayList<SinhVien> dsSinhVien;
    private ArrayList<TaiKhoan> dsTaiKhoan;
    private ArrayList<GiaoDich> dsGiaoDich;
    private Controller con;

    private SinhVienMain sinhVienMain;

    public RutTien(java.awt.Frame parent, boolean modal, SinhVien sinhVien) {
        super(parent, modal);
        this.sinhVien = sinhVien;
        this.con = new Controller();
        this.dsSinhVien = con.docFile("src/TextJava/sinhvien.txt");
        this.dsTaiKhoan = con.docFile("src/TextJava/taikhoan.txt");
        this.dsGiaoDich = con.docFile("src/TextJava/giaodich.txt");
        initComponents();
        this.setLocationRelativeTo(null);
        sinhVienMain = (SinhVienMain) parent;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSoTienCanRut = new javax.swing.JTextField();
        btnHuy = new javax.swing.JButton();
        btnNapTien = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JPasswordField();

        setMinimumSize(new java.awt.Dimension(290, 150));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Mật khẩu");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        jLabel2.setText("Số tiền muốn rút");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 20));
        add(txtSoTienCanRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 120, -1));

        btnHuy.setBackground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 110, 80, -1));

        btnNapTien.setBackground(new java.awt.Color(255, 255, 255));
        btnNapTien.setText("Rút tiền");
        btnNapTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNapTienActionPerformed(evt);
            }
        });
        add(btnNapTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));
        add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnNapTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNapTienActionPerformed
        // TODO add your handling code here:
        Frame frame = new Frame();
        try {
            if (txtSoTienCanRut.getText().equals("") || txtMatKhau.getText().equals("")) {
                throw new Exception("Không được để trống số tiền cấn rút hoặc tài khoản");
            }
            double soDu = sinhVien.getSoTienTK();
            double soTienRut = Double.parseDouble(txtSoTienCanRut.getText());
            if (soTienRut > soDu) {
                throw new Exception("Số tiền cần rút không được vượt quá số dư của tài khoản");
            }
            TaiKhoan tk = dsTaiKhoan.get(dsTaiKhoan.indexOf(new TaiKhoan(sinhVien.getMaSinhVien(), "", "")));
            if (!tk.getMatKhau().equals(txtMatKhau.getText())) {
                throw new Exception("Mật khẩu không chính xác");
            }

            int output = JOptionPane.showConfirmDialog(frame,
                    "Xác nhận rút tiền", "Lựa chọn", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
                sinhVien.getTaiKhoanTien().setSoDu(sinhVien.getTaiKhoanTien().getSoDu() + soTienRut);
                sinhVien.setSoTienTK(soDu - soTienRut);
                dsSinhVien.set(dsSinhVien.indexOf(sinhVien), sinhVien);

                GiaoDich giaoDich = new GiaoDich(sinhVien, "Rút tiền", sinhVien.getTaiKhoanTien(), new Date(), "- " + String.valueOf(soTienRut));
                dsGiaoDich.add(giaoDich);
                con.ghiFile(dsGiaoDich, "src/TextJava/giaodich.txt");
                con.ghiFile(dsSinhVien, "src/TextJava/sinhvien.txt");
                sinhVienMain.loadData();
                throw new Exception("Rút thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnNapTienActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnNapTien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSoTienCanRut;
    // End of variables declaration//GEN-END:variables
}
