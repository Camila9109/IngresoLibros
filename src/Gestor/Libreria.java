package Gestor;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Libreria extends javax.swing.JFrame {

    public static final String url = "jdbc:mysql://localhost:3306/libreria";
    public static final String user = "root";
    public static final String password = "admin";

    DefaultTableModel dtm;

    public Libreria() {
        initComponents();
        
        this.setLocationRelativeTo(null);

        dtm = new DefaultTableModel();

        dtm.addColumn("Id");
        dtm.addColumn("Titulo");
        dtm.addColumn("Autor");
        dtm.addColumn("Genero");

        mostrarDatos();
       
    }

    public void mostrarDatos() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        dtm.setRowCount(0);

        try {
            con = DriverManager.getConnection(url, user, password);

            String sql = "SELECT id,titulo,autor,genero FROM libro";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String genero = rs.getString("genero");

                dtm.addRow(new Object[]{id, titulo, autor, genero});
            }
            jtDatos.setModel(dtm);
            
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {

            System.out.println(e);
        }

    }

    public Connection getConnection() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e);

        }

        return conexion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenedor = new javax.swing.JPanel();
        jpVistaIngreso = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jlFondo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtTitulo = new javax.swing.JTextField();
        jtAutor = new javax.swing.JTextField();
        jtGenero = new javax.swing.JTextField();
        jpVistaDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jpContenedor.setBackground(new java.awt.Color(255, 255, 255));
        jpContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpVistaIngreso.setBackground(new java.awt.Color(255, 255, 255));
        jpVistaIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(0, 153, 204));
        jlTitulo.setText("LIBRERÍA CAMILA");
        jpVistaIngreso.add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos.imagenes/Image20230210191009.jpg"))); // NOI18N
        jpVistaIngreso.add(jlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 400, 250));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Id:");
        jpVistaIngreso.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Autor:");
        jpVistaIngreso.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Título:");
        jpVistaIngreso.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Género:");
        jpVistaIngreso.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        jtId.setEnabled(false);
        jpVistaIngreso.add(jtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 100, 20));

        jtTitulo.setToolTipText("");
        jpVistaIngreso.add(jtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 100, -1));
        jpVistaIngreso.add(jtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 140, -1));
        jpVistaIngreso.add(jtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 140, -1));

        jpVistaDatos.setBackground(new java.awt.Color(0, 153, 204));

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Titulo", "Autor", "Genero"
            }
        ));
        jScrollPane1.setViewportView(jtDatos);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Datos");

        javax.swing.GroupLayout jpVistaDatosLayout = new javax.swing.GroupLayout(jpVistaDatos);
        jpVistaDatos.setLayout(jpVistaDatosLayout);
        jpVistaDatosLayout.setHorizontalGroup(
            jpVistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVistaDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpVistaDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(42, 42, 42))
        );
        jpVistaDatosLayout.setVerticalGroup(
            jpVistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpVistaDatosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpVistaIngreso.add(jpVistaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 440));

        btnEnviar.setBackground(new java.awt.Color(0, 153, 204));
        btnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Enviar");
        btnEnviar.setBorder(null);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jpVistaIngreso.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 80, 30));

        jpContenedor.add(jpVistaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        Connection con = getConnection();

        PreparedStatement ps = null;

        String sql = "INSERT INTO libro(titulo, autor,genero) value(?,?,?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, jtTitulo.getText());
            ps.setString(2, jtAutor.getText());
            ps.setString(3, jtGenero.getText());

            ps.executeUpdate();

            con.close();

            JOptionPane.showMessageDialog(null, "Libro Guardado");

            jtTitulo.setText("");
            jtAutor.setText("");
            jtGenero.setText("");
            
            mostrarDatos();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al guardar el libro: " + e);
        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libreria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlFondo;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JPanel jpContenedor;
    private javax.swing.JPanel jpVistaDatos;
    private javax.swing.JPanel jpVistaIngreso;
    private javax.swing.JTextField jtAutor;
    private javax.swing.JTable jtDatos;
    private javax.swing.JTextField jtGenero;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtTitulo;
    // End of variables declaration//GEN-END:variables
}
