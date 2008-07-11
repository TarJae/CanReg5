/*
 * NavigationPanel.java
 *
 * Created on 23 June 2008, 11:54
 */

package canreg.client.gui.components;

import javax.swing.ListSelectionModel;
import org.jdesktop.application.Action;

/**
 *
 * @author  ervikm
 */
public class NavigationPanel extends javax.swing.JPanel {
    private ListSelectionModel listSelectionModel;
    private javax.swing.JTable table;
    
    /** Creates new form NavigationPanel */
    public NavigationPanel() {
        initComponents();
    }
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigatePanel = new javax.swing.JPanel();
        topButton = new javax.swing.JButton();
        topButton1 = new javax.swing.JButton();
        topButton2 = new javax.swing.JButton();
        topButton3 = new javax.swing.JButton();

        setName("Form"); // NOI18N

        navigatePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Navigate"));
        navigatePanel.setName("navigatePanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(NavigationPanel.class, this);
        topButton.setAction(actionMap.get("goToTopAction")); // NOI18N
        topButton.setName("topButton"); // NOI18N

        topButton1.setAction(actionMap.get("goToBottomAction")); // NOI18N
        topButton1.setName("topButton1"); // NOI18N

        topButton2.setAction(actionMap.get("goOneUpAction")); // NOI18N
        topButton2.setName("topButton2"); // NOI18N

        topButton3.setAction(actionMap.get("goOneDownAction")); // NOI18N
        topButton3.setName("topButton3"); // NOI18N

        javax.swing.GroupLayout navigatePanelLayout = new javax.swing.GroupLayout(navigatePanel);
        navigatePanel.setLayout(navigatePanelLayout);
        navigatePanelLayout.setHorizontalGroup(
            navigatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navigatePanelLayout.createSequentialGroup()
                        .addComponent(topButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(topButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navigatePanelLayout.createSequentialGroup()
                        .addComponent(topButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(topButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navigatePanelLayout.setVerticalGroup(
            navigatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatePanelLayout.createSequentialGroup()
                .addGroup(navigatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topButton)
                    .addComponent(topButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(navigatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(topButton3)
                    .addComponent(topButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void goToTopAction() {
        listSelectionModel.setSelectionInterval(0, 0);
        table.scrollRectToVisible(table.getCellRect(0,0,true));
    }

    @Action
    public void goOneUpAction() {
        
    }

    @Action
    public void goToBottomAction() {
        listSelectionModel.setSelectionInterval(table.getRowCount()-1, table.getRowCount()-1);
        table.scrollRectToVisible(table.getCellRect(table.getRowCount()-1,0,true));
    }

    @Action
    public void goOneDownAction() {
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel navigatePanel;
    private javax.swing.JButton topButton;
    private javax.swing.JButton topButton1;
    private javax.swing.JButton topButton2;
    private javax.swing.JButton topButton3;
    // End of variables declaration//GEN-END:variables

    public void setTable(javax.swing.JTable table) {
        this.table = table;
        this.listSelectionModel = table.getSelectionModel();
    }

  
}
