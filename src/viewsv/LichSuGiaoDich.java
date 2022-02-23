/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package viewsv;

import controller.Controller;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import model.CongNo;
import model.SinhVien;
import model.TableModel;

/**
 *
 * @author DucDang
 */
public class LichSuGiaoDich extends javax.swing.JFrame {
    
    private SinhVienMain sinhVienMain;
    private SinhVien sinhVien;
    private TableModel<CongNo> congNoThuModel;
    private ArrayList<CongNo> congNos = new ArrayList<>();
    private Controller con;
    private String maKhoanThu;

    /**
     * Creates new form LichSuGiaoDich
     */
    public LichSuGiaoDich(java.awt.Frame parent, boolean modal, SinhVien sinhVien) {
        this.sinhVienMain = (SinhVienMain) parent;
        this.sinhVien = sinhVien;
        this.con = new Controller();
        this.congNos = con.docFile("src/TextJava/congno.txt");
        initComponents();
        loadTable();
        this.setLocationRelativeTo(null);
    }

    private LichSuGiaoDich(Frame parent, boolean modal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void loadTable() {
        String[] tenCot = {"Mã khoản thu", "Tên khoản thu", "Giá"};
        List<CongNo> temp = congNos.stream().filter(cn -> cn.isKiemTraThu() == false && cn.getSinhVien().getMaSinhVien().equals(sinhVien.getMaSinhVien())).toList();
        ArrayList<CongNo> congNoChuaThanhToan = new ArrayList<>();
        congNoChuaThanhToan.addAll(temp);
        this.congNoThuModel = new TableModel<CongNo>(congNoChuaThanhToan, tenCot) {
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return congNoChuaThanhToan.get(rowIndex).getKhoanThu().getMaKhoanThu();
                    case 1:
                        return congNoChuaThanhToan.get(rowIndex).getKhoanThu().getTenKhoanThu();
                    case 2:
                        return congNoChuaThanhToan.get(rowIndex).getKhoanThu().getGia();
                    default:
                        return null;
                }
            }
        };
        tableGiaoDich.setModel(this.congNoThuModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnThoat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableGiaoDich = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        tableGiaoDich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableGiaoDich);

        jLabel1.setText("Lịch Sử Giao Dịch");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThoat)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThoat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableGiaoDich;
    // End of variables declaration//GEN-END:variables
}
