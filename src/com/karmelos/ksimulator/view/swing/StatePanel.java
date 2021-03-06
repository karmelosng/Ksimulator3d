/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karmelos.ksimulator.view.swing;

import com.karmelos.ksimulator.controller.SimController;
import com.karmelos.ksimulator.model.SimState;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author MorpheuS
 */
public class StatePanel extends javax.swing.JPanel {
  private DefaultListModel stateListModel;
  private SimView simView;
    /**
     * Creates new form StatePanel
     */
    public StatePanel() {
       stateListModel= new DefaultListModel();
       
        initComponents();  
        
        
    }
    private void initializeOpen(){
        
     SimController sc= getwrk().getController();
     SimState[] fetchSessions = sc.fetchSessions(false);
        for(int i=0;i<fetchSessions.length;i++)
     {
     stateListModel.addElement(fetchSessions[i]);
     
     }
    
    }
     public SimView getwrk() {
        return simView;
    }

    public void setWrk(SimView wrk) {
        this.simView = wrk;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        openStateJList = new javax.swing.JList();
        refreshButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cancelOnOpenState = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Previously Saved Sessions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aparajita", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        openStateJList.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        openStateJList.setModel(stateListModel);
        jScrollPane1.setViewportView(openStateJList);

        refreshButton.setText("RefresH");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        jButton1.setText("OPEN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cancelOnOpenState.setText("CANCEL");
        cancelOnOpenState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOnOpenStateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(2, 2, 2)
                        .addComponent(cancelOnOpenState)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(cancelOnOpenState))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        stateListModel.removeAllElements();
        getwrk().startSimulation(); 
        initializeOpen();        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           getwrk().startSimulation(); 
         SimState tempState = (SimState)openStateJList.getSelectedValue();
         SimState controlState= getwrk().getController().getState();
        if(!openStateJList.isSelectionEmpty()){
           // start simulation
           // getwrk().startSimulation();  
         // get Selected SimState and create new session
            Object[] tempObject = new Object[2];
      
       
            controlState.setId(tempState.getId());
            controlState.setDescription(tempState.getDescription());
            controlState.setGlobalAccessFlag(tempState.getGlobalAccessFlag());
            controlState.setReadWriteFlag(tempState.getReadWriteFlag());
            controlState.setAvailableComponents(tempState.getAvailableComponents());
            controlState.setUsedComponents(tempState.getUsedComponents());
            controlState.setPlacedComponents(tempState.getPlacedComponents());
            controlState.setSavedAt(tempState.getSavedAt());
            controlState.setSimUser(tempState.getSimUser());
            
             controlState.setChanged();  
             tempObject[0] = "OpenComponent";
             controlState.notifyObservers(tempObject);
            // populate the JLists for available and used compomemts
            getwrk().reloadListsOnOpen(tempState.getAvailableComponents(),tempState.getPlacedComponents());
           getwrk().getController().setOpenDirective(true);
            getwrk().getRecentMenu().setEnabled(false);
           
                       
            
            
        }
        else
        {
        JOptionPane.showMessageDialog(null, "You havent Selected Any Session To Open",
                        "Error", JOptionPane.OK_OPTION);
        getwrk().getController().closeState();
        }
       SwingUtilities.windowForComponent(this).setVisible(false);  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelOnOpenStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOnOpenStateActionPerformed
         getwrk().getController().closeState();
         SwingUtilities.windowForComponent(this).setVisible(false);
    }//GEN-LAST:event_cancelOnOpenStateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelOnOpenState;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList openStateJList;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
