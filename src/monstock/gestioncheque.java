/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monstock;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YASSOU
 */
public class gestioncheque extends javax.swing.JFrame {

    Statement stm,stm1;
    connexion maconx =new connexion();
    DefaultTableModel model;
    int selectedrow;
    /**
     * Creates new form gestioncheque
     */
    public gestioncheque() {
        initComponents();
          this.setLocationRelativeTo(null);
        setResizable(false);
        etat2.setSelected(true);
          model=(DefaultTableModel) tab_cheque.getModel();
        icon();
        listefournisseur();
      //affichecheque();
        
    }
    
 void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));
    }
  public void affichenumcheque(String num){
     String req="select * from cheque where num_cheque='"+num+"' ";
     try{
         stm1=maconx.obtenircnx().createStatement();
          ResultSet res = stm1.executeQuery(req);
            while (res.next()) {
                Vector v= new Vector();
                 for(int i=0;i<model.getColumnCount();i++){
                v.add(res.getInt("id"));
                v.add(res.getString("societe"));
              v.add(res.getString("num_cheque"));
              v.add(res.getString("date_payer"));
              v.add(res.getString("date_rappel"));
              v.add(res.getString("montant"));
               v.add(res.getString("etat"));
                 }
               model.addRow(v);
            }
     }catch(SQLException ex){
         JOptionPane.showMessageDialog(this,"erreur de connexion"+ex.getMessage());
     }
 }
 public void affichetouscheque(){
     String req="select * from cheque ";
     try{
         stm1=maconx.obtenircnx().createStatement();
          ResultSet res = stm1.executeQuery(req);
            while (res.next()) {
                Vector v= new Vector();
                 for(int i=0;i<model.getColumnCount();i++){
                v.add(res.getInt("id"));
                v.add(res.getString("societe"));
              v.add(res.getString("num_cheque"));
              v.add(res.getString("date_payer"));
              v.add(res.getString("date_rappel"));
              v.add(res.getString("montant"));
               v.add(res.getString("etat"));
                 }
               model.addRow(v);
            }
     }catch(SQLException ex){
         JOptionPane.showMessageDialog(this,"erreur de connexion"+ex.getMessage());
     }
 }
 private void listefournisseur() {
        String req_affiche = "select * from fournisseur";
        try {
            stm = maconx.obtenircnx().createStatement();
            ResultSet res = stm.executeQuery(req_affiche);
            while (res.next()) {

                String name = res.getString("nom_soc");
                soc.addItem(name);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }
  public void affichechequepayer(){
          
      String ch="payer";
     String req="select * from cheque where etat='"+ch+"' ";
     try{
         stm1=maconx.obtenircnx().createStatement();
          ResultSet res = stm1.executeQuery(req);
            while (res.next()) {
                Vector v= new Vector();
                 for(int i=0;i<model.getColumnCount();i++){
                v.add(res.getInt("id"));
                v.add(res.getString("societe"));
              v.add(res.getString("num_cheque"));
              v.add(res.getString("date_payer"));
              v.add(res.getString("date_rappel"));
              v.add(res.getString("montant"));
               v.add(res.getString("etat"));
                 }
               model.addRow(v);
            }
     }catch(SQLException ex){
         JOptionPane.showMessageDialog(this,"erreur de connexion"+ex.getMessage());
     }
 }
    public void affichechequepayerimpayer(){
          
      String ch="impayer";
     String req="select * from cheque where etat='"+ch+"' ";
     try{
         stm1=maconx.obtenircnx().createStatement();
          ResultSet res = stm1.executeQuery(req);
            while (res.next()) {
                Vector v= new Vector();
                 for(int i=0;i<model.getColumnCount();i++){
                v.add(res.getInt("id"));
                v.add(res.getString("societe"));
              v.add(res.getString("num_cheque"));
              v.add(res.getString("date_payer"));
              v.add(res.getString("date_rappel"));
              v.add(res.getString("montant"));
               v.add(res.getString("etat"));
                 }
               model.addRow(v);
            }
     }catch(SQLException ex){
         JOptionPane.showMessageDialog(this,"erreur de connexion"+ex.getMessage());
     }
 }

    public void affichechequepardate(){
              SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
                String datep=sdf.format(date_payer.getDate());

                 SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
                 String dater=sdf1.format(date_rappel.getDate().getTime());
      
      String ch="impayer";
      String ch2="payer";
      String xx=(String) cher.getSelectedItem();
      String req=null;
     
      switch(xx){
        case  "Tous":  req="select * from cheque where date_payer BETWEEN '"+datep+"' and '"+dater+"' ";
         case "Impayé": req="select * from cheque where date_payer BETWEEN '"+datep+"' and '"+dater+"' and etat='"+ch+"' "; 
         case "Payer": req="select * from cheque where date_payer BETWEEN '"+datep+"' and '"+dater+"' and etat='"+ch2+"' "; 
      }
      
     try{
         stm1=maconx.obtenircnx().createStatement();
          ResultSet res = stm1.executeQuery(req);
            while (res.next()) {
                Vector v= new Vector();
                 for(int i=0;i<model.getColumnCount();i++){
                v.add(res.getInt("id"));
                v.add(res.getString("societe"));
              v.add(res.getString("num_cheque"));
              v.add(res.getString("date_payer"));
              v.add(res.getString("date_rappel"));
              v.add(res.getString("montant"));
               v.add(res.getString("etat"));
                 }
               model.addRow(v);
            }
     }catch(SQLException ex){
         JOptionPane.showMessageDialog(this,"erreur de connexion"+ex.getMessage());
     }
 }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_cheque = new javax.swing.JTable();
        res = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        num = new javax.swing.JTextField();
        mon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        etat1 = new javax.swing.JRadioButton();
        etat2 = new javax.swing.JRadioButton();
        soc = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        date_payer = new datechooser.beans.DateChooserCombo();
        date_rappel = new datechooser.beans.DateChooserCombo();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ajoutercheque = new javax.swing.JButton();
        modifiercheque = new javax.swing.JButton();
        supprimercheque = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cher = new javax.swing.JComboBox<>();
        recherchecheque = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Z-STock | Gestion des chéques");

        jPanel1.setBackground(new java.awt.Color(37, 204, 247));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Gestion des chéques ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tab_cheque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "société", "Numero cheque", "Date a payer", "Date de rappel", "Montant", "Etat"
            }
        ));
        tab_cheque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_chequeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_cheque);

        res.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        res.setText("Total :");

        jPanel2.setBackground(new java.awt.Color(37, 204, 247));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Société");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("N° chéque");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Date à payer");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Date de rappel");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Montant");

        num.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        mon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Etat");

        etat1.setBackground(new java.awt.Color(37, 204, 247));
        buttonGroup1.add(etat1);
        etat1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etat1.setText("Payer");

        etat2.setBackground(new java.awt.Color(37, 204, 247));
        buttonGroup1.add(etat2);
        etat2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etat2.setText("Impayé");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("ID");

        id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(etat1)
                                .addGap(18, 18, 18)
                                .addComponent(etat2))
                            .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_rappel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(num)
                            .addComponent(soc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date_payer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(soc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(date_payer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(date_rappel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etat1)
                        .addComponent(etat2)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(37, 204, 247));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ajoutercheque.setBackground(new java.awt.Color(4, 139, 154));
        ajoutercheque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ajoutercheque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monstock/ajouter.png"))); // NOI18N
        ajoutercheque.setText("Ajouter");
        ajoutercheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterchequeActionPerformed(evt);
            }
        });

        modifiercheque.setBackground(new java.awt.Color(4, 139, 154));
        modifiercheque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        modifiercheque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monstock/modif (1).png"))); // NOI18N
        modifiercheque.setText("Modifier");
        modifiercheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierchequeActionPerformed(evt);
            }
        });

        supprimercheque.setBackground(new java.awt.Color(4, 139, 154));
        supprimercheque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        supprimercheque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monstock/modif (1).png"))); // NOI18N
        supprimercheque.setText("Supprimer");
        supprimercheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerchequeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Recherche par");

        cher.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous", "Payer", "Impayé" }));

        recherchecheque.setBackground(new java.awt.Color(4, 139, 154));
        recherchecheque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        recherchecheque.setText("Chercher");
        recherchecheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recherchechequeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ajoutercheque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(supprimercheque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modifiercheque, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(cher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(recherchecheque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(ajoutercheque, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supprimercheque, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifiercheque, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(recherchecheque, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(390, 390, 390)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(res, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(res, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void ajouterchequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterchequeActionPerformed
      
       if((num.getText().trim().equals(""))||(mon.getText().trim().equals("")) || (date_payer.getSelectedDate().getTime()==null)||(date_rappel.getSelectedDate().getTime()==null)){
           JOptionPane.showMessageDialog(this, "Champs vide !!");
           return;
       }
       else{
           SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
       String datep=sdf.format(date_payer.getSelectedDate().getTime());
       
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
        String dater=sdf1.format(date_rappel.getSelectedDate().getTime());
        
     if (date_rappel.getSelectedDate().getTime().after(date_payer.getSelectedDate().getTime())){
         JOptionPane.showMessageDialog(this, "la date de rappel doit étre inférieur a la date payé ");
         return;
     }
       String res_etat;
        try{
             
                if(etat2.isSelected()){
                res_etat="impayer";
                 }else{
                res_etat="payer";
                   }
               
             String requete="INSERT INTO cheque(num_cheque, societe, date_payer, date_rappel, montant, etat) VALUES ('"+num.getText()+"', '"+soc.getSelectedItem()+"','"+datep+"','"+dater+"', '"+Double.parseDouble(mon.getText())+"', '"+res_etat+"')"; 
             stm=maconx.obtenircnx().createStatement();
                 stm.executeUpdate(requete);
                 
                  JOptionPane.showMessageDialog(this,"Ajout réussite!!");
                  affichenumcheque(num.getText());
                  //model.addRow(new Object[]{soc.getSelectedItem(), num.getText(), datep, dater, mon.getText(), res_etat});
                  id.setText("");
                  num.setText("");
                    mon.setText("");
                  // date_payer.setDate(null);
                  //date_rappel.setDate(null);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }   
        
      int s=0;
        for(int i=0;i<tab_cheque.getRowCount();i++){
           
               s+= Integer.parseInt(tab_cheque.getValueAt(i, 5).toString());
            
        }
        res.setText("Total :"+Integer.toString(s));
       }
    }//GEN-LAST:event_ajouterchequeActionPerformed

    private void tab_chequeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_chequeMouseClicked
      
         selectedrow=tab_cheque.getSelectedRow();
    
            String  date = (tab_cheque.getValueAt(selectedrow, 3).toString());
          String  date2 = (model.getValueAt(selectedrow, 4).toString());

       
       id.setText(tab_cheque.getValueAt(selectedrow, 0).toString());
         soc.setSelectedItem(tab_cheque.getValueAt(selectedrow, 1).toString());
         num.setText(tab_cheque.getValueAt(selectedrow, 2).toString());
         
         date_rappel.setDateFormat(dateFormat);
       // ((JTextField)date_payer.getDateEditor().getUiComponent()).setText(date);
         ((JTextField)date_rappel.getDateEditor().getUiComponent()).setText(date2);
         
            mon.setText(tab_cheque.getValueAt(selectedrow, 5).toString());
            
            if(tab_cheque.getValueAt(selectedrow, 6).equals("impayer")){
                etat2.setSelected(true);
            }else{
                etat1.setSelected(true);
            }
          
        
    }//GEN-LAST:event_tab_chequeMouseClicked

    private void modifierchequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierchequeActionPerformed
            
        String res_etat;
            
        if(tab_cheque.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"Voulez vous selectionnée une ligne pour modifier");
            return;
        }
           else{
            //  SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");   
       // String datep=sdf.format(date_payer.getDate().getTime());         
      //String dater=sdf.format(date_rappel.getDate().getTime());
          String datep=((JTextField)date_payer.getDateEditor().getUiComponent()).getText();
          String dater=((JTextField)date_rappel.getDateEditor().getUiComponent()).getText();
              if(etat2.isSelected()){
                res_etat="impayer";
                 }else{
                res_etat="payer";
                   }
            String req_update_dep="UPDATE cheque SET num_cheque='"+num.getText()+"', societe='"+soc.getSelectedItem()+"', date_payer='"+datep+"' , date_rappel='"+dater+"', montant='"+mon.getText()+"' , etat='"+res_etat+"' where id='"+Integer.parseInt(id.getText())+"' ";
            try{
                if  (JOptionPane.showConfirmDialog(this,"voulez-vous modifier", "Verification!!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION)
                {
                    stm=maconx.obtenircnx().createStatement();
                    stm.executeUpdate(req_update_dep);
                   model.setValueAt(id.getText(), tab_cheque.getSelectedRow(),0);
                    model.setValueAt(soc.getSelectedItem(), tab_cheque.getSelectedRow(),1);
                    model.setValueAt(num.getText(), tab_cheque.getSelectedRow(),2);   
                    model.setValueAt(datep, tab_cheque.getSelectedRow(),3);
                    model.setValueAt(dater, tab_cheque.getSelectedRow(),4);
                    model.setValueAt(mon.getText(), tab_cheque.getSelectedRow(),5);
                      model.setValueAt(res_etat, tab_cheque.getSelectedRow(),6);
                      
                       id.setText("");
                        num.setText("");
                        mon.setText("");
                        date_payer.setDate(null);
                        date_rappel.setDate(null);
                   
                }
                    
            }catch (SQLException ex){
             
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }
           
             int s=0;
        for(int i=0;i<tab_cheque.getRowCount();i++){
           
               s+= Integer.parseInt(tab_cheque.getValueAt(i, 5).toString());
            
        }
        res.setText("Total :"+Integer.toString(s));
            
        }               
      
        
    }//GEN-LAST:event_modifierchequeActionPerformed

    private void supprimerchequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerchequeActionPerformed
       
         if(tab_cheque.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"Voulez vous selectionnée une ligne pour supprimer");
            return;
        }
         else{
             String req="delete from cheque where id='"+Integer.parseInt(id.getText())+"' ";
             try{
                 if  (JOptionPane.showConfirmDialog(this,"voulez-vous supprimer", "Verification!!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION)
                {
                 stm=maconx.obtenircnx().createStatement();
                    stm.executeUpdate(req);
                     
                    model.removeRow(selectedrow);
                     id.setText("");
                     num.setText("");
                     mon.setText("");
                    date_payer.setDate(null);
                    date_rappel.setDate(null);
                }
             }catch (SQLException ex){
                 JOptionPane.showMessageDialog(this,"Erreur lors de supprission !!");
             }
               int s=0;
        for(int i=0;i<tab_cheque.getRowCount();i++){
           
               s+= Integer.parseInt(tab_cheque.getValueAt(i, 5).toString());
            
        }
        res.setText("Total :"+Integer.toString(s));
            
         }
         
    }//GEN-LAST:event_supprimerchequeActionPerformed

    private void recherchechequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recherchechequeActionPerformed
       while (model.getRowCount()>0)
                {
                    for(int i=0;i<model.getRowCount();i++)
                    {
                        model.removeRow(0);
                    }
                }
       if ((date_payer.getDate()==null)||(date_rappel.getDate()==null)){
           
                        if(cher.getSelectedItem().equals("Tous")){
                      affichetouscheque();
                  }else{
                       if(cher.getSelectedItem().equals("Payer")){
                      affichechequepayer();
                  }
                       else{
                           affichechequepayerimpayer();
                       }
                  }
              
       }else{
           affichechequepardate();
       }
                      id.setText("");
                     num.setText("");
                     mon.setText("");
                    date_payer.setDate(null);
                    date_rappel.setDate(null);
        
               int s=0;
        for(int i=0;i<tab_cheque.getRowCount();i++){
           
               s+= Integer.parseInt(tab_cheque.getValueAt(i, 5).toString());
            
        }
        res.setText("Total :"+Integer.toString(s));
          
    }//GEN-LAST:event_recherchechequeActionPerformed

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
            java.util.logging.Logger.getLogger(gestioncheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestioncheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestioncheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestioncheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gestioncheque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajoutercheque;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cher;
    private datechooser.beans.DateChooserCombo date_payer;
    private datechooser.beans.DateChooserCombo date_rappel;
    private javax.swing.JRadioButton etat1;
    private javax.swing.JRadioButton etat2;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifiercheque;
    private javax.swing.JTextField mon;
    private javax.swing.JTextField num;
    private javax.swing.JButton recherchecheque;
    public javax.swing.JLabel res;
    private javax.swing.JComboBox<String> soc;
    private javax.swing.JButton supprimercheque;
    public javax.swing.JTable tab_cheque;
    // End of variables declaration//GEN-END:variables
}
