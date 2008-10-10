/*
 * RecordEditor.java
 *
 * Created on 16 July 2008, 14:46
 */
package canreg.client.gui.dataentry;

import canreg.common.DatabaseVariablesListElement;
import canreg.common.Globals;
import canreg.server.database.DatabaseRecord;
import canreg.server.database.Dictionary;
import canreg.server.database.Patient;
import canreg.server.database.Tumour;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import org.jdesktop.application.Action;
import org.w3c.dom.Document;

/**
 *
 * @author  ervikm
 */
public class RecordEditor extends javax.swing.JInternalFrame {

    private Document doc;
    private Map<Integer, Dictionary> dictionary;
    private LinkedList<DatabaseRecord> patientRecords;
    private LinkedList<DatabaseRecord> tumourRecords;

    /** Creates new form RecordEditor */
    public RecordEditor() {
        initComponents();
        patientRecords = new LinkedList<DatabaseRecord>();
        tumourRecords = new LinkedList<DatabaseRecord>();

        addInternalFrameListener(new InternalFrameAdapter() {

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                int option = JOptionPane.NO_OPTION;
                option = JOptionPane.showConfirmDialog(null, "Really close?\nChanges made will be lost.");
                if (option == JOptionPane.YES_OPTION) {
                    close();
                }
            }
        });
    }

    public void setDocument(Document doc) {
        this.doc = doc;
    }

    public void closing() {
    }

    public void close() {
        this.dispose();
    }

    public void setDictionary(Map<Integer, Dictionary> dictionary) {
        this.dictionary = dictionary;
    }

    public void addRecord(DatabaseRecord dbr) {
        RecordEditorPanel rePanel = new RecordEditorPanel();
        rePanel.setDictionary(dictionary);
        rePanel.setDocument(doc);
        rePanel.setRecord(dbr);
        rePanel.repaint();
        if (dbr.getClass().isInstance(new Patient())) {
            patientRecords.add(dbr);
            patientTabbedPane.addTab(dbr.toString() + " - " + (patientTabbedPane.getTabCount() + 1), rePanel);
        } else if (dbr.getClass().isInstance(new Tumour())) {
            tumourRecords.add(dbr);
            tumourTabbedPane.addTab(dbr.toString() + " - " + (tumourTabbedPane.getTabCount() + 1), rePanel);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        patientTabbedPane = new javax.swing.JTabbedPane();
        tumourTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setName("Form"); // NOI18N

        jSplitPane1.setDividerSize(10);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(0.5);
        jSplitPane1.setName("jSplitPane1"); // NOI18N
        jSplitPane1.setOneTouchExpandable(true);

        patientTabbedPane.setName("patientTabbedPane"); // NOI18N
        jSplitPane1.setTopComponent(patientTabbedPane);

        tumourTabbedPane.setName("tumourTabbedPane"); // NOI18N
        jSplitPane1.setRightComponent(tumourTabbedPane);

        jPanel1.setName("jPanel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(RecordEditor.class, this);
        jButton1.setAction(actionMap.get("addTumourAction")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setAction(actionMap.get("addPatientAction")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jButton3.setAction(actionMap.get("saveAllAction")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2)
                .addComponent(jButton3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    @Action
    public void addTumourAction() {
        Tumour tumour = new Tumour();
        populateNewRecord(tumour, doc);
        addRecord(tumour);
    }

    @Action
    public void addPatientAction() {
        Patient patient = new Patient();
        populateNewRecord(patient, doc);
        addRecord(patient);
    }
    
    private static DatabaseRecord populateNewRecord(DatabaseRecord dbr, Document doc) {
        String tableName = "";
        if (dbr instanceof Tumour) {
            tableName = "tumour";
        } else if (dbr instanceof Patient) {
            tableName = "patient";
        }
        DatabaseVariablesListElement[] variablesInTable = canreg.common.Tools.getVariableListElements(doc, Globals.NAMESPACE, tableName);
        for (DatabaseVariablesListElement dbvle : variablesInTable) {
            String type = dbvle.getVariableType();
            if (type.equalsIgnoreCase("date") || type.equalsIgnoreCase("number")) {
                dbr.setVariable(dbvle.getShortName(), -1);
            } else {
                dbr.setVariable(dbvle.getShortName(), "");
            }
        }
        return dbr;
    }

    @Action
    public void saveAllAction() {
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane patientTabbedPane;
    private javax.swing.JTabbedPane tumourTabbedPane;
    // End of variables declaration//GEN-END:variables

    

    
}
