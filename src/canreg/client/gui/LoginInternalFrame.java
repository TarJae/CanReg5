/*
 * LoginInternalFrame.java
 *
 * Created on 02 April 2008, 16:36
 */
package canreg.client.gui;

import canreg.client.CanRegClientApp;
import canreg.client.LocalSettings;
import canreg.client.ServerDescription;
import java.beans.PropertyChangeSupport;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.Task;

/**
 *
 * @author  morten
 */
public class LoginInternalFrame extends javax.swing.JInternalFrame {

    private static boolean debug = true;
    private javax.swing.JLabel externalFeedbackLabel;
    private FrameView fv;
    private JDesktopPane desktopPane;
    private LocalSettings localSettings;
    protected final PropertyChangeSupport propertyChangeSupport;

    /** Creates new form LoginInternalFrame */
    public LoginInternalFrame(FrameView fv, JDesktopPane dtp) {
        localSettings = CanRegClientApp.getApplication().getLocalSettings();
        this.desktopPane = dtp;
        this.fv = fv;
        propertyChangeSupport = new PropertyChangeSupport(this);
        initComponents();
        loadDefaultValues();
        if (autoStartCheckBox.isSelected()) {
            Task task = launchCanRegServerAction();
            task.execute();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        feedbackLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        systemPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        canRegSystemComboBox = new javax.swing.JComboBox();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        rememberPasswordCheckBox = new javax.swing.JCheckBox();
        settingsPanel = new javax.swing.JPanel();
        nameTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        serverURLTextField = new javax.swing.JTextField();
        serverURLLabel = new javax.swing.JLabel();
        addServerToListButton = new javax.swing.JButton();
        advancedPanel = new javax.swing.JPanel();
        autoStartCheckBox = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        portField = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        advancedCheckBox = new javax.swing.JCheckBox();
        launchServerButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        codeField = new javax.swing.JTextField();

        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(LoginInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(LoginInternalFrame.class, this);
        loginButton.setAction(actionMap.get("loginAction")); // NOI18N
        loginButton.setText(resourceMap.getString("loginButton.text")); // NOI18N
        loginButton.setName("loginButton"); // NOI18N

        cancelButton.setAction(actionMap.get("cancelAction")); // NOI18N
        cancelButton.setText(resourceMap.getString("cancelButton.text")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N

        feedbackLabel.setText(resourceMap.getString("feedbackLabel.text")); // NOI18N
        feedbackLabel.setName("feedbackLabel"); // NOI18N

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        systemPanel.setName("systemPanel"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        canRegSystemComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        canRegSystemComboBox.setAction(actionMap.get("serverComboboxChanged")); // NOI18N
        canRegSystemComboBox.setName("canRegSystemComboBox"); // NOI18N

        usernameLabel.setText(resourceMap.getString("usernameLabel.text")); // NOI18N
        usernameLabel.setName("usernameLabel"); // NOI18N

        usernameTextField.setText(resourceMap.getString("usernameTextField.text")); // NOI18N
        usernameTextField.setName("usernameTextField"); // NOI18N
        usernameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameTextFieldKeyTyped(evt);
            }
        });

        passwordLabel.setText(resourceMap.getString("passwordLabel.text")); // NOI18N
        passwordLabel.setName("passwordLabel"); // NOI18N

        passwordField.setText(resourceMap.getString("passwordField.text")); // NOI18N
        passwordField.setName("passwordField"); // NOI18N
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                enterKeyTyped(evt);
            }
        });

        rememberPasswordCheckBox.setText(resourceMap.getString("rememberPasswordCheckBox.text")); // NOI18N
        rememberPasswordCheckBox.setToolTipText(resourceMap.getString("rememberPasswordCheckBox.toolTipText")); // NOI18N
        rememberPasswordCheckBox.setName("rememberPasswordCheckBox"); // NOI18N

        javax.swing.GroupLayout systemPanelLayout = new javax.swing.GroupLayout(systemPanel);
        systemPanel.setLayout(systemPanelLayout);
        systemPanelLayout.setHorizontalGroup(
            systemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(systemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(systemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel)
                    .addComponent(passwordLabel)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(systemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canRegSystemComboBox, 0, 365, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, systemPanelLayout.createSequentialGroup()
                        .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rememberPasswordCheckBox))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, systemPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))
                .addContainerGap())
        );
        systemPanelLayout.setVerticalGroup(
            systemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(systemPanelLayout.createSequentialGroup()
                .addGroup(systemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(canRegSystemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(systemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(systemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(rememberPasswordCheckBox)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(resourceMap.getString("systemPanel.TabConstraints.tabTitle"), systemPanel); // NOI18N

        settingsPanel.setName("settingsPanel"); // NOI18N

        nameTextField.setEditable(false);
        nameTextField.setText(resourceMap.getString("nameTextField.text")); // NOI18N
        nameTextField.setName("nameTextField"); // NOI18N

        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N

        serverURLTextField.setText(resourceMap.getString("serverURLTextField.text")); // NOI18N
        serverURLTextField.setName("serverURLTextField"); // NOI18N
        serverURLTextField.setNextFocusableComponent(portField);
        serverURLTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                enterKeyTyped(evt);
            }
        });

        serverURLLabel.setText(resourceMap.getString("serverURLLabel.text")); // NOI18N
        serverURLLabel.setName("serverURLLabel"); // NOI18N

        addServerToListButton.setAction(actionMap.get("addServerToList")); // NOI18N
        addServerToListButton.setName("addServerToListButton"); // NOI18N

        advancedPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("advancedPanel.border.title"))); // NOI18N
        advancedPanel.setName("advancedPanel"); // NOI18N

        autoStartCheckBox.setText(resourceMap.getString("autoStartCheckBox.text")); // NOI18N
        autoStartCheckBox.setName("autoStartCheckBox"); // NOI18N

        jButton2.setAction(actionMap.get("testServerConnection")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jButton1.setAction(actionMap.get("getIPaddressAction")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        portField.setText(resourceMap.getString("portField.text")); // NOI18N
        portField.setName("portField"); // NOI18N

        portLabel.setText(resourceMap.getString("portLabel.text")); // NOI18N
        portLabel.setName("portLabel"); // NOI18N

        javax.swing.GroupLayout advancedPanelLayout = new javax.swing.GroupLayout(advancedPanel);
        advancedPanel.setLayout(advancedPanelLayout);
        advancedPanelLayout.setHorizontalGroup(
            advancedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advancedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(advancedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(advancedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(autoStartCheckBox)
                    .addGroup(advancedPanelLayout.createSequentialGroup()
                        .addComponent(portLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        advancedPanelLayout.setVerticalGroup(
            advancedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advancedPanelLayout.createSequentialGroup()
                .addGroup(advancedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(advancedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(autoStartCheckBox)))
        );

        advancedCheckBox.setAction(actionMap.get("changeShowAdvancedAction")); // NOI18N
        advancedCheckBox.setName("advancedCheckBox"); // NOI18N

        launchServerButton.setAction(actionMap.get("launchCanRegServerAction")); // NOI18N
        launchServerButton.setName("launchServerButton"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        codeField.setText(resourceMap.getString("codeField.text")); // NOI18N
        codeField.setName("codeField"); // NOI18N
        codeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                enterKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(advancedPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, settingsPanelLayout.createSequentialGroup()
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serverURLLabel)
                            .addComponent(nameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addComponent(serverURLTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codeField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                            .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addComponent(advancedCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                        .addComponent(launchServerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addServerToListButton)))
                .addContainerGap())
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverURLLabel)
                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverURLTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addServerToListButton)
                    .addComponent(advancedCheckBox)
                    .addComponent(launchServerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(advancedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(resourceMap.getString("settingsPanel.TabConstraints.tabTitle"), settingsPanel); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(feedbackLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addGap(109, 109, 109)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(cancelButton)
                    .addComponent(feedbackLabel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadDefaultValues() {
        // Properties p = localSettings.getProperties();
        String rememberPasswordBooleanString = localSettings.getProperty(LocalSettings.REMEMBER_PASSWORD_KEY);
        boolean rememberPassword = rememberPasswordBooleanString.equalsIgnoreCase(LocalSettings.TRUE_PROPERTY);
        rememberPasswordCheckBox.setSelected(rememberPassword);
        if (rememberPassword) {
            passwordField.setText(localSettings.getProperty(LocalSettings.PASSWORD_KEY));
        }
        usernameTextField.setText(localSettings.getProperty(LocalSettings.USERNAME_KEY));
        // Load the server list
        String[] serverNames = localSettings.getServerNames();
        if (serverNames != null) {
            canRegSystemComboBox.setModel(new javax.swing.DefaultComboBoxModel(localSettings.getServerDescriptions().toArray()));
            String lastServerIDString = localSettings.getProperty(LocalSettings.LAST_SERVER_ID_KEY);
            if (lastServerIDString != null) {
                ServerDescription sd = localSettings.getServerDescription(Integer.parseInt(lastServerIDString));
                if (sd != null) {
                    canRegSystemComboBox.setSelectedItem(sd);
                    portField.setText(Integer.toString(sd.getPort()));
                    serverURLTextField.setText(sd.getUrl());
                    codeField.setText(sd.getCode());
                }
                canRegSystemComboBox.setSelectedItem(sd);
            }
        } else {
            canRegSystemComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{""}));
        }
        String autoStartServerBooleanString = localSettings.getProperty(LocalSettings.AUTO_START_SERVER_KEY);
        if (autoStartServerBooleanString != null) {
            boolean autoStartServerBoolean = autoStartServerBooleanString.equalsIgnoreCase(LocalSettings.TRUE_PROPERTY);
            autoStartCheckBox.setSelected(autoStartServerBoolean);
        } else {
            autoStartCheckBox.setSelected(false);
        }
        // Advanced 
        advancedPanel.setVisible(false);

    }

    private void saveDefaultValues() {
        // Properties p = localSettings.getProperties();
        // Should CanReg remember the password?
        if (rememberPasswordCheckBox.isSelected()) {
            localSettings.setProperty(LocalSettings.REMEMBER_PASSWORD_KEY, LocalSettings.TRUE_PROPERTY);
            localSettings.setProperty(LocalSettings.PASSWORD_KEY, new String(passwordField.getPassword()));
        } else {
            localSettings.setProperty(LocalSettings.REMEMBER_PASSWORD_KEY, LocalSettings.FALSE_PROPERTY);
            localSettings.setProperty(LocalSettings.PASSWORD_KEY, "");
        }
        localSettings.setProperty(LocalSettings.USERNAME_KEY, usernameTextField.getText());
        // Get list of servers stored locally
        LinkedList<ServerDescription> sds = localSettings.getServerDescriptions();
        // If this list contains more than one entry - save it.
        if (sds.size() > 0) {
            ServerDescription sd = sds.get(canRegSystemComboBox.getSelectedIndex());
            localSettings.setProperty(LocalSettings.LAST_SERVER_ID_KEY, sd.getId() + "");
        }
        // Should one autostart the CanReg server the next time?
        if (autoStartCheckBox.isSelected()) {
            localSettings.setProperty(LocalSettings.AUTO_START_SERVER_KEY, LocalSettings.TRUE_PROPERTY);
        } else {
            localSettings.setProperty(LocalSettings.AUTO_START_SERVER_KEY, LocalSettings.FALSE_PROPERTY);
        }
        localSettings.writeSettings();
    }

    private void enterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enterKeyTyped
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            loginAction();
        }
}//GEN-LAST:event_enterKeyTyped

    private void usernameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldKeyTyped

    @Action
    public void loginAction() {
        String server = serverURLTextField.getText().trim();
        String port = portField.getText().trim();
        String code = codeField.getText().trim();
        String username = usernameTextField.getText().trim();
        char[] password = passwordField.getPassword();
        String serverObjectString = "rmi://" + server + ":" + port + "/CanRegLogin" + code;

        try {
            String canRegSystemName = CanRegClientApp.getApplication().login(serverObjectString, username, password);
            if (canRegSystemName != null) {
                fv.getFrame().setTitle("CanReg5 - " + canRegSystemName);
                saveDefaultValues();
                this.dispose();
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Successfully logged in to " + canRegSystemName + " as " + username + ".", "Logged in", JOptionPane.INFORMATION_MESSAGE);
            } else {
                feedbackLabel.setText("Error.");
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Could not log in to the CanReg server on " + server + " with the given credentials.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception exception) {
//            System.out.println(exception.getLocalizedMessage());
            feedbackLabel.setText(exception.getLocalizedMessage());
        }
    }

    @Action
    public void cancelAction() {
        this.dispose();
    }

    public void setFeedbackLabel(javax.swing.JLabel label) {
        this.externalFeedbackLabel = label;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addServerToListButton;
    private javax.swing.JCheckBox advancedCheckBox;
    private javax.swing.JPanel advancedPanel;
    private javax.swing.JCheckBox autoStartCheckBox;
    private javax.swing.JComboBox canRegSystemComboBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField codeField;
    private javax.swing.JLabel feedbackLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton launchServerButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JCheckBox rememberPasswordCheckBox;
    private javax.swing.JLabel serverURLLabel;
    private javax.swing.JTextField serverURLTextField;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JPanel systemPanel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
    /**
     * Simple console trace to system.out for debug purposes only.&Ltp>
     *
     * @param msg the message to be printed to the console
     */
    private static void debugOut(String msg) {
        if (debug) {
            System.out.println("\t[LoginInternalFrame] " + msg);
        }
    }

    @Action()
    public Task launchCanRegServerAction() {
        return new LaunchCanRegServerActionTask(org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class));
    }

    private class LaunchCanRegServerActionTask extends org.jdesktop.application.Task<Object, Void> {

        WaitFrame waitFrame;

        LaunchCanRegServerActionTask(org.jdesktop.application.Application app) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to LaunchCanRegServerActionTask fields, here.
            super(app);
            // launchServerButton.setEnabled(false);
            feedbackLabel.setText("Launching server...");
            waitFrame = new WaitFrame();
            waitFrame.setLabel("Launching server...");
            waitFrame.setIndeterminate(true);
            desktopPane.add(waitFrame, javax.swing.JLayeredPane.POPUP_LAYER);
            waitFrame.setVisible(true);
            waitFrame.setLocation((desktopPane.getWidth() - waitFrame.getWidth()) / 2, (desktopPane.getHeight() - waitFrame.getHeight()) / 2);
        }

        @Override
        protected Object doInBackground() {
            // Your Task's code here.  This method runs
            // on a background thread, so don't reference
            // the Swing GUI from here...
            String result = "stopped";
            try {
                if (canreg.common.ServerLauncher.start(codeField.getText(), Integer.parseInt(portField.getText()))) {
                    result = "started";
                }
            } catch (AlreadyBoundException ex) {
                result = "running";
            // Logger.getLogger(LoginInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Return your result... 
            return result;
        }

        @Override
        protected void succeeded(Object resultObject) {
            waitFrame.dispose();
            String resultString = (String) resultObject;
            if (resultString.equalsIgnoreCase("running")) {
                feedbackLabel.setText("Server already running.");
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Server already running.", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else if (resultString.equalsIgnoreCase("stopped")) {
                feedbackLabel.setText("Server failed to start.");
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Server failed to start.", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (resultString != null) {
                feedbackLabel.setText("Server started.");
                CanRegClientApp.getApplication().setCanregServerRunningInThisThread(true);
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Server started.", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                feedbackLabel.setText("Server failed to start.");
                JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Server failed to start.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            launchServerButton.setEnabled(false);
        }
    }

    @Action
    public boolean testServerConnection() {
        String server = serverURLTextField.getText().trim();
        String port = portField.getText().trim();
        String code = codeField.getText().trim();

        String serverObjectString = "rmi://" + server + ":" + port + "/CanRegLogin" + code;

        String systemName = CanRegClientApp.getApplication().testConnection(serverObjectString);

        if (systemName != null) {
            nameTextField.setText(systemName);
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Server connection OK.", "Message", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "Server connection not OK.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Action
    public void addServerToList() {
        if (testServerConnection()) {
            localSettings.addServerToServerList(nameTextField.getText(),
                    serverURLTextField.getText(),
                    Integer.parseInt(portField.getText()),
                    codeField.getText());
            canRegSystemComboBox.setModel(new javax.swing.DefaultComboBoxModel(localSettings.getServerDescriptions().toArray()));
        }
    }

    @Action
    public void serverComboboxChanged() {
        ServerDescription sd = localSettings.getServerDescriptions().get(canRegSystemComboBox.getSelectedIndex());
        portField.setText(sd.getPort() + "");
        serverURLTextField.setText(sd.getUrl());
        codeField.setText(sd.getCode());
    }

    @Action
    public void getIPaddressAction() {
        try {
            InetAddress addr;
            if (serverURLTextField.getText().equalsIgnoreCase("localhost")) {
                addr = InetAddress.getLocalHost();
            } else {
                addr = InetAddress.getByName(serverURLTextField.getText());
            }
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "<html>The IP address of <b>" + addr.getHostName() + "</b> is <b>" + addr.getHostAddress() + "</b>.</html>", "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (UnknownHostException ex) {
            JOptionPane.showInternalMessageDialog(CanRegClientApp.getApplication().getMainFrame().getContentPane(), "<html>Cannot find the IP address of <b>" + serverURLTextField.getText() + "</b>.</html>", "Message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LoginInternalFrame.class.getName()).log(Level.WARNING, null, ex);
        }
    }

    @Action
    public void changeShowAdvancedAction() {
        advancedPanel.setVisible(advancedCheckBox.isSelected());
    }
}
