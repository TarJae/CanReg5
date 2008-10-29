/*
 * WelcomeInternalFrame.java
 *
 * Created on 02 April 2008, 16:24
 */
package canreg.client.gui;

import canreg.common.Globals;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JDesktopPane;
import org.jdesktop.application.Action;
import org.jdesktop.application.FrameView;

/**
 *
 * @author  morten
 */
public class WelcomeInternalFrame extends javax.swing.JInternalFrame {

    FrameView fv;
    Properties appInfoProperties;

    /** Creates new form WelcomeInternalFrame
     * @param fv 
     */
    public WelcomeInternalFrame(FrameView fv) {
        this.fv = fv;
        
        appInfoProperties = new Properties();
        InputStream in = null;
        //
        // load properties file
        //
        try {
            //
            // get Application information
            //
            in = getClass().getResourceAsStream(Globals.APPINFO_PROPERTIES_PATH);
            appInfoProperties.load(in);
            in.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } // end-try-catch

        initComponents();
        // set version

        String versionString = "";
        for (String part : Globals.versionStringParts) {
            versionString += appInfoProperties.getProperty(part);
        }
        versionString += "b" + appInfoProperties.getProperty("program.BUILDNUM");
        versionString += " (" + appInfoProperties.getProperty("program.BUILDDATE") + ")";
        versionLabel.setText(versionLabel.getText() + " " + versionString);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        logoButton = new javax.swing.JButton();
        aboutScrollPane = new javax.swing.JScrollPane();
        aboutEditorPane = new javax.swing.JEditorPane();
        buttonPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        restoreBackupButton = new javax.swing.JButton();
        versionLabel = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(WelcomeInternalFrame.class);
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        mainPanel.setName("mainPanel"); // NOI18N

        logoButton.setIcon(resourceMap.getIcon("logoButton.icon")); // NOI18N
        logoButton.setBorder(null);
        logoButton.setBorderPainted(false);
        logoButton.setContentAreaFilled(false);
        logoButton.setFocusable(false);
        logoButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoButton.setName("logoButton"); // NOI18N
        logoButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        aboutScrollPane.setName("aboutScrollPane"); // NOI18N

        aboutEditorPane.setEditable(false);
        aboutEditorPane.setFont(resourceMap.getFont("aboutEditorPane.font")); // NOI18N
        aboutEditorPane.setText(resourceMap.getString("aboutEditorPane.text")); // NOI18N
        aboutEditorPane.setFocusCycleRoot(false);
        aboutEditorPane.setFocusable(false);
        aboutEditorPane.setName("aboutEditorPane"); // NOI18N
        aboutEditorPane.setRequestFocusEnabled(false);
        aboutScrollPane.setViewportView(aboutEditorPane);

        buttonPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonPanel.setName("buttonPanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(WelcomeInternalFrame.class, this);
        loginButton.setAction(actionMap.get("showLoginFrame")); // NOI18N
        loginButton.setIcon(resourceMap.getIcon("loginButton.icon")); // NOI18N
        loginButton.setText(resourceMap.getString("loginButton.text")); // NOI18N
        loginButton.setToolTipText(resourceMap.getString("loginButton.toolTipText")); // NOI18N
        loginButton.setActionCommand(resourceMap.getString("loginButton.actionCommand")); // NOI18N
        loginButton.setName("loginButton"); // NOI18N

        restoreBackupButton.setAction(actionMap.get("installNewSystemAction")); // NOI18N
        restoreBackupButton.setToolTipText(resourceMap.getString("restoreBackupButton.toolTipText")); // NOI18N
        restoreBackupButton.setName("restoreBackupButton"); // NOI18N

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(restoreBackupButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restoreBackupButton, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        versionLabel.setText(resourceMap.getString("versionLabel.text")); // NOI18N
        versionLabel.setName("versionLabel"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(logoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(versionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(aboutScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aboutScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(versionLabel)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // We want to keep this window "always on top"
    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        this.toFront();
    }//GEN-LAST:event_formFocusLost

    /**
     * 
     */
    @Action
    public void showLoginFrame() {

        this.dispose();
        LoginInternalFrame loginInternalFrame = new LoginInternalFrame(fv, desktopPane);
        desktopPane.add(loginInternalFrame, javax.swing.JLayeredPane.DEFAULT_LAYER);
        //JFrame mainFrame = CanRegClientApp.getApplication().getMainFrame();
        loginInternalFrame.setLocation(desktopPane.getWidth() / 2 - loginInternalFrame.getWidth() / 2, desktopPane.getHeight() / 2 - loginInternalFrame.getHeight() / 2);

        loginInternalFrame.setVisible(true);

    }

    /**
     * 
     * @param dtp
     */
    public void setDesktopPane(JDesktopPane dtp) {
        desktopPane = dtp;
    }

    /**
     * 
     */
    @Action
    public void installNewSystemAction() {
        InstallNewSystemInternalFrame internalFrame = new InstallNewSystemInternalFrame();
        desktopPane.add(internalFrame, javax.swing.JLayeredPane.DEFAULT_LAYER);
        //JFrame mainFrame = CanRegClientApp.getApplication().getMainFrame();
        internalFrame.setLocation(desktopPane.getWidth() / 2 - internalFrame.getWidth() / 2, desktopPane.getHeight() / 2 - internalFrame.getHeight() / 2);
        internalFrame.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane aboutEditorPane;
    private javax.swing.JScrollPane aboutScrollPane;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton logoButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton restoreBackupButton;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JDesktopPane desktopPane;
}
