/*
 * InstallNewSystemInternalFrame.java
 *
 * Created on 01 July 2008, 16:59
 */
package canreg.client.gui;

import canreg.client.CanRegClientApp;
import canreg.client.LocalSettings;
import canreg.common.Globals;
import canreg.server.management.SystemDescription;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.application.Action;

/**
 *
 * @author  ervikm
 */
public class InstallNewSystemInternalFrame extends javax.swing.JInternalFrame {

    SystemDescription systemDescription;
    LocalSettings localSettings;

    /** Creates new form InstallNewSystemInternalFrame */
    public InstallNewSystemInternalFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileNameTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(InstallNewSystemInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N

        fileNameTextField.setText(resourceMap.getString("fileNameTextField.text")); // NOI18N
        fileNameTextField.setName("fileNameTextField"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(InstallNewSystemInternalFrame.class, this);
        jButton1.setAction(actionMap.get("browseAction")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jButton2.setAction(actionMap.get("installAction")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jButton3.setAction(actionMap.get("cancelAction")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     */
    @Action
    public void installAction() {
        String fileNameWithPath = fileNameTextField.getText().trim();
        File file = new File(fileNameWithPath);
        if (file.exists())
            
        try {
            localSettings = CanRegClientApp.getApplication().getLocalSettings();
            
            String document = Globals.CANREG_SERVER_SYSTEM_CONFIG_FOLDER+Globals.FILE_SEPARATOR+file.getName();
            
            // Create the directories if they don't exist.
            File systemDir = new File(Globals.CANREG_SERVER_FOLDER);
            systemDir.mkdir();
            systemDir = new File(Globals.CANREG_SERVER_SYSTEM_CONFIG_FOLDER);
            systemDir.mkdir();
            // copy the document to the CanReg system folder...
            canreg.common.Tools.fileCopy(fileNameWithPath, document);
            // load the document
            loadDocument(document);
            // Add this new server to the list of favourite servers
            int i = localSettings.addServerToServerList(systemDescription.getSystemName(), "localhost", Globals.DEFAULT_PORT, systemDescription.getSystemCode());
            // Set it as default start up server
            localSettings.setProperty(LocalSettings.LAST_SERVER_ID_KEY, ""+i);
            // Set it to autostart
            localSettings.setProperty(LocalSettings.AUTO_START_SERVER_KEY,LocalSettings.TRUE_PROPERTY);
            // and show confirmation
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), systemDescription.getSystemName()+" is now ready. \nPlease log in.", "Message.", JOptionPane.INFORMATION_MESSAGE);            
            this.dispose();
        } catch (IOException ex) {
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Error copying file.", "Error.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InstallNewSystemInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }else {
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Please specify file name.", "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 
     */
    @Action
    public void cancelAction() {
        this.dispose();
    }

    /**
     * 
     */
    @Action
    public void browseAction() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml");
 
        JFileChooser chooser = new JFileChooser(".");
        chooser.addChoosableFileFilter(filter);

        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                //set the file name
                fileNameTextField.setText(chooser.getSelectedFile().getCanonicalPath());
                // changeFile();
            } catch (IOException ex) {
                Logger.getLogger(InstallNewSystemInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void loadDocument(String document){
        systemDescription = new SystemDescription(document);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
