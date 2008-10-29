/*
 * RangeFilterPanel.java
 *
 * Created on 27 May 2008, 16:38
 */
package canreg.client.gui.components;

import canreg.client.gui.*;
import canreg.client.CanRegClientApp;
import canreg.common.DatabaseIndexesListElement;
import canreg.common.DatabaseVariablesListElement;
import canreg.common.Globals;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import org.jdesktop.application.Action;
import org.w3c.dom.Document;

/**
 *
 * @author  ervikm
 */
public class RangeFilterPanel extends javax.swing.JPanel implements ActionListener {

    private Document doc;
    // private DatabaseVariablesListElement[] variablesInDB;
    private DatabaseIndexesListElement[] indexesInDB;
    private Vector filterCollection;
    private JDesktopPane dtp;
    private FastFilterInternalFrame filterWizardInternalFrame;
    private ActionListener actionListener;
    private DatabaseVariablesListElement[] variablesInDB;

    /** Creates new form RangeFilterPanel */
    public RangeFilterPanel() {
        initComponents();
    }

    /**
     * 
     */
    public void close() {
        filterWizardInternalFrame.dispose();
    }

    /**
     * 
     * @return
     */
    public Document getDatabseDescription() {
        return doc;
    }

    /**
     * 
     * @return
     */
    public String getFilter() {
        if (useFilterCheckBox.isSelected()) {
            return filterComboBox.getSelectedItem().toString().trim();
        } else {
            return new String("");
        }
    }

    /**
     * 
     * @return
     */
    public String getSelectedTable() {
        return tableChooserComboBox.getSelectedItem().toString();
    }    

    /**
     * 
     * @param dtp
     */
    public void setDeskTopPane(JDesktopPane dtp) {
        this.dtp = dtp;
    }

    /**
     * 
     * @param active
     */
    public void setFilterActive(boolean active) {
        useFilterCheckBox.setSelected(active);
    }

    /**
     * 
     * @param enabled
     */
    public void setRefreshButtonEnabled(boolean enabled) {
        refreshTableButton.setEnabled(enabled);
    }

    /**
     * 
     * @param visible
     */
    public void setTableChooserVisible(boolean visible) {
        tableChooserPanel.setVisible(visible);
    }
    
    /**
     * 
     * @param visible
     */
    public void setRecordPanelvisible(boolean visible){
        recordsPanel.setVisible(visible);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rangePanel = new javax.swing.JPanel();
        rangeComboBox = new javax.swing.JComboBox();
        limitsSplitPane = new javax.swing.JSplitPane();
        rangeStartTextField = new javax.swing.JTextField();
        rangeEndTextField = new javax.swing.JTextField();
        filterPanel = new javax.swing.JPanel();
        filterComboBox = new javax.swing.JComboBox();
        useFilterCheckBox = new javax.swing.JCheckBox();
        wizardButton = new javax.swing.JButton();
        recordsPanel = new javax.swing.JPanel();
        recordsShownField = new javax.swing.JTextField();
        recordsShownLabel = new javax.swing.JLabel();
        andLabel = new javax.swing.JLabel();
        tableChooserPanel = new javax.swing.JPanel();
        tableChooserComboBox = new javax.swing.JComboBox();
        sortByChooserPanel = new javax.swing.JPanel();
        sortByChooserComboBox = new javax.swing.JComboBox();
        refreshTableButton = new javax.swing.JButton();

        setName("Form"); // NOI18N

        rangePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Range"));
        rangePanel.setName("rangePanel"); // NOI18N

        rangeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Record Number", "ICD10", "Names" }));
        rangeComboBox.setName("rangeComboBox"); // NOI18N

        limitsSplitPane.setDividerLocation(125);
        limitsSplitPane.setDividerSize(4);
        limitsSplitPane.setResizeWeight(0.5);
        limitsSplitPane.setName("limitsSplitPane"); // NOI18N

        rangeStartTextField.setName("rangeStartTextField"); // NOI18N
        limitsSplitPane.setLeftComponent(rangeStartTextField);

        rangeEndTextField.setName("rangeEndTextField"); // NOI18N
        limitsSplitPane.setRightComponent(rangeEndTextField);

        javax.swing.GroupLayout rangePanelLayout = new javax.swing.GroupLayout(rangePanel);
        rangePanel.setLayout(rangePanelLayout);
        rangePanelLayout.setHorizontalGroup(
            rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rangePanelLayout.createSequentialGroup()
                .addComponent(rangeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limitsSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
        );
        rangePanelLayout.setVerticalGroup(
            rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rangePanelLayout.createSequentialGroup()
                .addGroup(rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rangeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limitsSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        filterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));
        filterPanel.setName("filterPanel"); // NOI18N

        filterComboBox.setEditable(true);
        filterComboBox.setName("filterComboBox"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(RangeFilterPanel.class);
        useFilterCheckBox.setText(resourceMap.getString("useFilterCheckBox.text")); // NOI18N
        useFilterCheckBox.setName("useFilterCheckBox"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(RangeFilterPanel.class, this);
        wizardButton.setAction(actionMap.get("filterWizardAction")); // NOI18N
        wizardButton.setName("wizardButton"); // NOI18N

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filterComboBox, 0, 394, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterPanelLayout.createSequentialGroup()
                .addComponent(useFilterCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                .addComponent(wizardButton))
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wizardButton)
                    .addComponent(useFilterCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recordsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Records"));
        recordsPanel.setName("recordsPanel"); // NOI18N

        recordsShownField.setEditable(false);
        recordsShownField.setText(resourceMap.getString("recordsShownField.text")); // NOI18N
        recordsShownField.setName("recordsShownField"); // NOI18N

        recordsShownLabel.setText(resourceMap.getString("recordsShownLabel.text")); // NOI18N
        recordsShownLabel.setName("recordsShownLabel"); // NOI18N

        javax.swing.GroupLayout recordsPanelLayout = new javax.swing.GroupLayout(recordsPanel);
        recordsPanel.setLayout(recordsPanelLayout);
        recordsPanelLayout.setHorizontalGroup(
            recordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recordsShownField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recordsShownLabel)
                .addGap(78, 78, 78))
        );
        recordsPanelLayout.setVerticalGroup(
            recordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordsPanelLayout.createSequentialGroup()
                .addGroup(recordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recordsShownField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recordsShownLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        andLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        andLabel.setText(resourceMap.getString("andLabel.text")); // NOI18N
        andLabel.setName("andLabel"); // NOI18N

        tableChooserPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Table"));
        tableChooserPanel.setName("tableChooserPanel"); // NOI18N

        tableChooserComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Both", "Patient", "Tumour" }));
        tableChooserComboBox.setAction(actionMap.get("setTableName")); // NOI18N
        tableChooserComboBox.setName("tableChooserComboBox"); // NOI18N
        tableChooserComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableChooserComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tableChooserPanelLayout = new javax.swing.GroupLayout(tableChooserPanel);
        tableChooserPanel.setLayout(tableChooserPanelLayout);
        tableChooserPanelLayout.setHorizontalGroup(
            tableChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableChooserComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 153, Short.MAX_VALUE)
        );
        tableChooserPanelLayout.setVerticalGroup(
            tableChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableChooserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        sortByChooserPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("sortByChooserPanel.border.title"))); // NOI18N
        sortByChooserPanel.setName("sortByChooserPanel"); // NOI18N

        sortByChooserComboBox.setAction(actionMap.get("setTableName")); // NOI18N
        sortByChooserComboBox.setName("sortByChooserComboBox"); // NOI18N
        sortByChooserComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortByChooserComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sortByChooserPanelLayout = new javax.swing.GroupLayout(sortByChooserPanel);
        sortByChooserPanel.setLayout(sortByChooserPanelLayout);
        sortByChooserPanelLayout.setHorizontalGroup(
            sortByChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sortByChooserComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 107, Short.MAX_VALUE)
        );
        sortByChooserPanelLayout.setVerticalGroup(
            sortByChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sortByChooserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        refreshTableButton.setAction(actionMap.get("refreshAction")); // NOI18N
        refreshTableButton.setName("refreshTableButton"); // NOI18N
        refreshTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(andLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addComponent(rangePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(filterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tableChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortByChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(recordsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(refreshTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rangePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(andLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableChooserPanel, 0, 61, Short.MAX_VALUE)
                    .addComponent(sortByChooserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(recordsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshTableButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void refreshTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTableButtonActionPerformed
}//GEN-LAST:event_refreshTableButtonActionPerformed

private void tableChooserComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableChooserComboBoxActionPerformed
    filterWizardInternalFrame.setTableName(tableChooserComboBox.getSelectedItem().toString());
}//GEN-LAST:event_tableChooserComboBoxActionPerformed

private void sortByChooserComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortByChooserComboBoxActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_sortByChooserComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel andLabel;
    private javax.swing.JComboBox filterComboBox;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JSplitPane limitsSplitPane;
    private javax.swing.JComboBox rangeComboBox;
    private javax.swing.JTextField rangeEndTextField;
    private javax.swing.JPanel rangePanel;
    private javax.swing.JTextField rangeStartTextField;
    private javax.swing.JPanel recordsPanel;
    private javax.swing.JTextField recordsShownField;
    private javax.swing.JLabel recordsShownLabel;
    private javax.swing.JButton refreshTableButton;
    private javax.swing.JComboBox sortByChooserComboBox;
    private javax.swing.JPanel sortByChooserPanel;
    private javax.swing.JComboBox tableChooserComboBox;
    private javax.swing.JPanel tableChooserPanel;
    private javax.swing.JCheckBox useFilterCheckBox;
    private javax.swing.JButton wizardButton;
    // End of variables declaration//GEN-END:variables
    /**
     * Get the details on the range.
     *
     * @return            an array of String of the following format:
     * [the range variable, the start, the end]
     */
    public String[] getRange() {
        String[] range = new String[3];
        range[0] = rangeComboBox.getSelectedItem().toString();
        range[1] = rangeStartTextField.getText();
        range[2] = rangeEndTextField.getText();
        return range;
    }

    /**
     * 
     * @return
     */
    public String getFromValue(){
        return rangeStartTextField.getText();
    }
    
    /**
     * 
     * @return
     */
    public String getToValue(){
        return rangeEndTextField.getText();
    }
    
    /**
     * 
     * @return
     */
    public String getIndexName(){
        return rangeComboBox.getSelectedItem().toString();
    }
    
    /**
     * Initialize the values of the panel.
     *
     */
    public void initValues() {
        filterCollection = new Vector();
        // Get the system description
        doc = CanRegClientApp.getApplication().getDatabseDescription();
        // variablesInDB = canreg.common.Tools.getVariableListElements(doc, Globals.NAMESPACE);
        indexesInDB = canreg.common.Tools.getIndexesListElements(doc, Globals.NAMESPACE);
        rangeComboBox.setModel(new javax.swing.DefaultComboBoxModel(indexesInDB));      
        
        filterWizardInternalFrame = new FastFilterInternalFrame();
        filterWizardInternalFrame.setActionListener(this);

        filterWizardInternalFrame.setTableName(tableChooserComboBox.getSelectedItem().toString());
        
        variablesInDB = CanRegClientApp.getApplication().getGlobalToolBox().getVariables();
        sortByChooserComboBox.setModel(new DefaultComboBoxModel(variablesInDB));
        
        refreshFilterComboBox();
    }

    /**
     * Refreshes the filter combobox.
     *
     */
    private void refreshFilterComboBox() {
        String[] filters = new String[1];
        if (filterCollection.toArray(filters).length > 0) {
            filterComboBox.setModel(new javax.swing.DefaultComboBoxModel(filterCollection.toArray(filters)));
        } else {
            String[] str = new String[1];
            str[0] = "";
            filterComboBox.setModel(new javax.swing.DefaultComboBoxModel(str));
        }
    }

    /**
     * Adds a filter to the filter combobox if this is not already there.
     * @param String the filter to add
     * @return integer specifying the new filters position in the combobox
     */
    private int addFilterToComboBox(String filter) {
        int position = filterCollection.indexOf(filter);
        if (position < 0) {
            filterCollection.add(filter);
            return filterCollection.indexOf(filter);
        } else {
            return position;
        }
    }

    /**
     * 
     */
    @Action
    public void refreshAction() {
        int position = -1;
        Object filter = filterComboBox.getSelectedItem();
        if (filter != null) {
            String filterString = filter.toString();
            position = addFilterToComboBox(filterString);
            refreshFilterComboBox();
            filterComboBox.setSelectedIndex(position);
        }
        actionListener.actionPerformed(new ActionEvent(this,0,"refresh"));
    }

    /**
     * Adds a filter to the filter combobox if this is not already there and sets it as the current active filter.
     * @param filter 
     * @param String the filter to add
     */
    public void setFilter(String filter) {
        int position = addFilterToComboBox(filter);
        refreshFilterComboBox();
        filterComboBox.setSelectedIndex(position);
    }

    /**
     * 
     */
    @Action
    public void filterWizardAction() {

        if (filterWizardInternalFrame.getParent() == null) {
            dtp.add(filterWizardInternalFrame, javax.swing.JLayeredPane.DEFAULT_LAYER);
            filterWizardInternalFrame.setLocation(dtp.getWidth() / 2 - filterWizardInternalFrame.getWidth() / 2, dtp.getHeight() / 2 - filterWizardInternalFrame.getHeight() / 2);
            filterWizardInternalFrame.setVisible(false);
            filterWizardInternalFrame.setActionListener(this);
        }
        if (filterWizardInternalFrame.isVisible()) {
            filterWizardInternalFrame.toFront();
            try {
                filterWizardInternalFrame.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(RangeFilterPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            filterWizardInternalFrame.setTextPane("");
            filterWizardInternalFrame.setVisible(true);
        }
    }

    /**
     * 
     * @param rec
     */
    public void setRecordsShown(int rec) {
        recordsShownField.setText("" + rec);
    }
    
    /**
     * 
     * @param visible
     */
    public void setSortByVariableShown(boolean visible){
        sortByChooserPanel.setVisible(visible);
    }

    /**
     * 
     * @return
     */
    public String getSortByVariable(){
        return sortByChooserComboBox.getSelectedItem().toString();
    }
    
    /**
     * 
     */
    @Action
    public void refreshTableAction() {
        String filter = filterComboBox.getSelectedItem().toString();
        int position = addFilterToComboBox(filter);
        refreshFilterComboBox();
        filterComboBox.setSelectedIndex(position);
        actionListener.actionPerformed(new ActionEvent(this,0,"refresh"));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass()==FastFilterInternalFrame.class){
            setFilter(e.getActionCommand());
            useFilterCheckBox.setSelected(true);
        }
    }
    
    /**
     * 
     * @param actionListener
     */
    public void setActionListener(ActionListener actionListener){
        this.actionListener = actionListener;
    }
}
