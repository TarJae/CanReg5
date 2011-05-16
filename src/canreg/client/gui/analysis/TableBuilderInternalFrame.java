/**
 * CanReg5 - a tool to input, store, check and analyse cancer registry data.
 * Copyright (C) 2008-2011  International Agency for Research on Cancer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @author Morten Johannes Ervik, CIN/IARC, ervikm@iarc.fr
 */

/*
 * TableBuilderInternalFrame.java
 *
 * Created on 28-Apr-2009, 16:33:32
 */
package canreg.client.gui.analysis;

import canreg.client.analysis.AbstractEditorialTableBuilder.FileTypes;
import canreg.common.cachingtableapi.DistributedTableDescription;
import canreg.client.CanRegClientApp;
import canreg.client.DistributedTableDataSourceClient;
import canreg.client.LocalSettings;
import canreg.client.analysis.AgeSpecificCasesPerHundredThousandTableBuilder;
import canreg.client.analysis.AgeSpecificCasesTableBuilder;
import canreg.client.analysis.ConfigFields;
import canreg.client.analysis.ConfigFieldsReader;
import canreg.client.analysis.NotCompatibleDataException;
import canreg.client.analysis.PieChartTableBuilder;
import canreg.client.analysis.PopulationPyramidTableBuilder;
import canreg.client.analysis.AbstractEditorialTableBuilder;
import canreg.client.analysis.TableBuilderInterface;
import canreg.client.analysis.TableBuilderListElement;
import canreg.client.gui.components.LabelAndComboBoxJPanel;
import canreg.client.gui.tools.globalpopup.MyPopUpMenu;
import canreg.common.DatabaseFilter;
import canreg.common.DatabaseVariablesListElement;
import canreg.common.Globals;
import canreg.common.database.PopulationDataset;
import java.awt.Cursor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jdesktop.application.Action;

/**
 *
 * @author ervikm
 */
public class TableBuilderInternalFrame extends javax.swing.JInternalFrame {

    private Map<Integer, PopulationDataset> populationDatasetsMap;
    private PopulationDataset[] populationDatasetsArray;
    private LinkedList<LabelAndComboBoxJPanel> populationDatasetChooserPanels;
    private LocalSettings localSettings;
    private String path;
    private JFileChooser chooser;
    private Cursor hourglassCursor = new Cursor(Cursor.WAIT_CURSOR);
    private Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    private TableBuilderInterface tableBuilder = null;

    /** Creates new form TableBuilderInternalFrame */
    public TableBuilderInternalFrame() {
        initComponents();
        setCursor(hourglassCursor);
        initData();

        localSettings = CanRegClientApp.getApplication().getLocalSettings();

        // Add a listener for changing the active tab
        ChangeListener tabbedPaneChangeListener = new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                // initializeVariableMappingTab();
                changeTab(tabbedPane.getSelectedIndex());
            }
        };
        // And add the listener to the tabbedPane

        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        changeTab(0);

        // remove filter tab
        // Component filterTab = tabbedPane.getComponents()[3];
        tabbedPane.remove(3);
        setCursor(normalCursor);
    }

    private String generateHeadingString() {
        String heading;
        int startYear = startYearChooser.getValue();
        int endYear = endYearChooser.getValue();
        heading = canreg.client.CanRegClientApp.getApplication().getSystemName() + " (" + startYear;
        if (endYear != startYear) {
            heading += "-" + endYear;
        }
        heading += ")";
        return heading;
    }

    protected final void changeTab(int tabNumber) {
        tabbedPane.setSelectedIndex(tabNumber);
        nextButton.setEnabled(tabNumber < tabbedPane.getTabCount() - 1);
        backButton.setEnabled(tabNumber > 0);
        headerOfTableTextField.setText(generateHeadingString());
    }

    /**
     *
     */
    @Action
    public void jumpToPreviousTabAction() {
        int tabNumber = tabbedPane.getSelectedIndex();
        if (tabNumber >= 1) {
            tabbedPane.setSelectedIndex(--tabNumber);
            changeTab(tabNumber);
        }
    }

    /**
     *
     */
    @Action
    public void jumpToNextTabAction() {
        int tabNumber = tabbedPane.getSelectedIndex();
        if (tabNumber < tabbedPane.getTabCount()) {
            tabbedPane.setSelectedIndex(++tabNumber);
            changeTab(tabNumber);
        }
    }

    /**
     *
     */
    @Action
    public void cancelAction() {
        this.dispose();
    }

    private PopulationDataset[] getSelectedPopulations() {
        PopulationDataset[] populations = new PopulationDataset[populationDatasetChooserPanels.size()];
        int i = 0;
        for (LabelAndComboBoxJPanel panel : populationDatasetChooserPanels) {
            populations[i++] = (PopulationDataset) panel.getComboBoxSelectedItem();
        }

        return populations;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        tableTypePanel = new javax.swing.JPanel();
        tableTypeScrollPane = new javax.swing.JScrollPane();
        tableTypeList = new javax.swing.JList();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionTextPane = new javax.swing.JTextPane();
        descriptionLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        previewLabel = new javax.swing.JLabel();
        previewImageLabel = new javax.swing.JLabel();
        rangePanel = new javax.swing.JPanel();
        startYearChooser = new com.toedter.calendar.JYearChooser();
        startYearLabel = new javax.swing.JLabel();
        endYearLabel = new javax.swing.JLabel();
        endYearChooser = new com.toedter.calendar.JYearChooser();
        jLabel6 = new javax.swing.JLabel();
        midYearTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        numberOfYearsTextField = new javax.swing.JTextField();
        warningLabel = new javax.swing.JLabel();
        populationDatasetChooserPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        populationDatasetChoosersPanel = new javax.swing.JPanel();
        filterPanel = new javax.swing.JPanel();
        rangeFilterPanel = new canreg.client.gui.components.RangeFilterPanel();
        writeOutPanel = new javax.swing.JPanel();
        postScriptButton = new javax.swing.JButton();
        tabulatedButton = new javax.swing.JButton();
        headerOfTableLabel = new javax.swing.JLabel();
        headerOfTableTextField = new javax.swing.JTextField();
        imageButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(TableBuilderInternalFrame.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        tabbedPane.setName("tabbedPane"); // NOI18N
        tabbedPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabbedPaneFocusLost(evt);
            }
        });

        tableTypePanel.setName("tableTypePanel"); // NOI18N
        tableTypePanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableTypePanelFocusLost(evt);
            }
        });

        tableTypeScrollPane.setName("tableTypeScrollPane"); // NOI18N

        tableTypeList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Incidence per 100000 by Age groups (Annual)", "Incidence per 100000 by Age groups (Period)" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        tableTypeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableTypeList.setName("tableTypeList"); // NOI18N
        tableTypeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tableTypeListValueChanged(evt);
            }
        });
        tableTypeList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tableTypeListPropertyChange(evt);
            }
        });
        tableTypeScrollPane.setViewportView(tableTypeList);

        descriptionScrollPane.setName("descriptionScrollPane"); // NOI18N

        descriptionTextPane.setEditable(false);
        descriptionTextPane.setName("descriptionTextPane"); // NOI18N
        descriptionScrollPane.setViewportView(descriptionTextPane);

        descriptionLabel.setName("descriptionLabel"); // NOI18N

        typeLabel.setName("typeLabel"); // NOI18N

        previewLabel.setName("previewLabel"); // NOI18N

        previewImageLabel.setName("previewImageLabel"); // NOI18N

        javax.swing.GroupLayout tableTypePanelLayout = new javax.swing.GroupLayout(tableTypePanel);
        tableTypePanel.setLayout(tableTypePanelLayout);
        tableTypePanelLayout.setHorizontalGroup(
            tableTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tableTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeLabel)
                    .addComponent(tableTypeScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addGroup(tableTypePanelLayout.createSequentialGroup()
                        .addGroup(tableTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel)
                            .addComponent(descriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tableTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(previewLabel)
                            .addComponent(previewImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))
                .addContainerGap())
        );
        tableTypePanelLayout.setVerticalGroup(
            tableTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableTypeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tableTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionLabel)
                    .addComponent(previewLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tableTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previewImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(descriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPane.addTab(resourceMap.getString("tableTypePanel.TabConstraints.tabTitle"), tableTypePanel); // NOI18N

        rangePanel.setName("rangePanel"); // NOI18N

        startYearChooser.setName("startYearChooser"); // NOI18N
        startYearChooser.setStartYear(-292278994);
        startYearChooser.setValue(1999);
        startYearChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                startYearChooserPropertyChange(evt);
            }
        });

        startYearLabel.setText(resourceMap.getString("startYearLabel.text")); // NOI18N
        startYearLabel.setName("startYearLabel"); // NOI18N

        endYearLabel.setText(resourceMap.getString("endYearLabel.text")); // NOI18N
        endYearLabel.setName("endYearLabel"); // NOI18N

        endYearChooser.setDayChooser(null);
        endYearChooser.setName("endYearChooser"); // NOI18N
        endYearChooser.setStartYear(-292278994);
        endYearChooser.setValue(2001);
        endYearChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                endYearChooserPropertyChange(evt);
            }
        });

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        midYearTextField.setEditable(false);
        midYearTextField.setName("midYearTextField"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        numberOfYearsTextField.setEditable(false);
        numberOfYearsTextField.setName("numberOfYearsTextField"); // NOI18N

        warningLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        warningLabel.setText(resourceMap.getString("warningLabel.text")); // NOI18N
        warningLabel.setName("warningLabel"); // NOI18N

        javax.swing.GroupLayout rangePanelLayout = new javax.swing.GroupLayout(rangePanel);
        rangePanel.setLayout(rangePanelLayout);
        rangePanelLayout.setHorizontalGroup(
            rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rangePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addGroup(rangePanelLayout.createSequentialGroup()
                        .addGroup(rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(endYearLabel)
                            .addComponent(startYearLabel)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addGroup(rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startYearChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endYearChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numberOfYearsTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(midYearTextField, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        rangePanelLayout.setVerticalGroup(
            rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rangePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startYearLabel)
                    .addComponent(startYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(endYearLabel)
                    .addComponent(endYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(midYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(numberOfYearsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        tabbedPane.addTab(resourceMap.getString("rangePanel.TabConstraints.tabTitle"), rangePanel); // NOI18N

        populationDatasetChooserPanel.setName("populationDatasetChooserPanel"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        populationDatasetChoosersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        populationDatasetChoosersPanel.setName("populationDatasetChoosersPanel"); // NOI18N
        populationDatasetChoosersPanel.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(populationDatasetChoosersPanel);

        javax.swing.GroupLayout populationDatasetChooserPanelLayout = new javax.swing.GroupLayout(populationDatasetChooserPanel);
        populationDatasetChooserPanel.setLayout(populationDatasetChooserPanelLayout);
        populationDatasetChooserPanelLayout.setHorizontalGroup(
            populationDatasetChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(populationDatasetChooserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(populationDatasetChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        populationDatasetChooserPanelLayout.setVerticalGroup(
            populationDatasetChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(populationDatasetChooserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab(resourceMap.getString("populationDatasetChooserPanel.TabConstraints.tabTitle"), populationDatasetChooserPanel); // NOI18N

        filterPanel.setEnabled(false);
        filterPanel.setFocusable(false);
        filterPanel.setName("filterPanel"); // NOI18N
        filterPanel.setRequestFocusEnabled(false);

        rangeFilterPanel.setName("rangeFilterPanel"); // NOI18N
        rangeFilterPanel.initValues();

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rangeFilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addContainerGap())
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rangeFilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab(resourceMap.getString("filterPanel.TabConstraints.tabTitle"), filterPanel); // NOI18N

        writeOutPanel.setName("writeOutPanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(TableBuilderInternalFrame.class, this);
        postScriptButton.setAction(actionMap.get("generateTablesAction")); // NOI18N
        postScriptButton.setText(resourceMap.getString("postScriptButton.text")); // NOI18N
        postScriptButton.setEnabled(false);
        postScriptButton.setName("postScriptButton"); // NOI18N
        postScriptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postScriptButtonActionPerformed(evt);
            }
        });

        tabulatedButton.setAction(actionMap.get("generateTablesAction")); // NOI18N
        tabulatedButton.setText(resourceMap.getString("tabulatedButton.text")); // NOI18N
        tabulatedButton.setEnabled(false);
        tabulatedButton.setName("tabulatedButton"); // NOI18N

        headerOfTableLabel.setText(resourceMap.getString("headerOfTableLabel.text")); // NOI18N
        headerOfTableLabel.setName("headerOfTableLabel"); // NOI18N

        headerOfTableTextField.setText(resourceMap.getString("headerOfTableTextField.text")); // NOI18N
        headerOfTableTextField.setName("headerOfTableTextField"); // NOI18N
        headerOfTableTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerOfTableTextFieldMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                headerOfTableTextFieldMouseReleased(evt);
            }
        });

        imageButton.setAction(actionMap.get("generateTablesAction")); // NOI18N
        imageButton.setText(resourceMap.getString("imageButton.text")); // NOI18N
        imageButton.setEnabled(false);
        imageButton.setName("imageButton"); // NOI18N

        javax.swing.GroupLayout writeOutPanelLayout = new javax.swing.GroupLayout(writeOutPanel);
        writeOutPanel.setLayout(writeOutPanelLayout);
        writeOutPanelLayout.setHorizontalGroup(
            writeOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(writeOutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(writeOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(writeOutPanelLayout.createSequentialGroup()
                        .addComponent(headerOfTableLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(headerOfTableTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                    .addComponent(tabulatedButton, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addComponent(postScriptButton, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addComponent(imageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                .addContainerGap())
        );
        writeOutPanelLayout.setVerticalGroup(
            writeOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(writeOutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(writeOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerOfTableLabel)
                    .addComponent(headerOfTableTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postScriptButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabulatedButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageButton)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        tabbedPane.addTab(resourceMap.getString("writeOutPanel.TabConstraints.tabTitle"), writeOutPanel); // NOI18N

        backButton.setAction(actionMap.get("jumpToPreviousTabAction")); // NOI18N
        backButton.setName("backButton"); // NOI18N

        cancelButton.setAction(actionMap.get("cancelAction")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N

        nextButton.setAction(actionMap.get("jumpToNextTabAction")); // NOI18N
        nextButton.setName("nextButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(cancelButton)
                    .addComponent(backButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void populatePopulationDataSetChooser() {
        populationDatasetChoosersPanel.removeAll();
        if (populationDatasetChooserPanels == null) {
            populationDatasetChooserPanels = new LinkedList<LabelAndComboBoxJPanel>();
        }
        populationDatasetChooserPanels.clear();
        for (int i = 0; i <= (endYearChooser.getYear() - startYearChooser.getYear()); i++) {
            LabelAndComboBoxJPanel panel = new LabelAndComboBoxJPanel();
            panel.setComboBoxModel(new DefaultComboBoxModel(populationDatasetsArray));
            panel.setLabel((startYearChooser.getYear() + i) + ":");
            populationDatasetChoosersPanel.add(panel);
            populationDatasetChooserPanels.add(panel);
            panel.setVisible(true);
        }
        populationDatasetChoosersPanel.revalidate();
        populationDatasetChoosersPanel.repaint();
    }

    private void startYearChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_startYearChooserPropertyChange
        if (startYearChooser.getYear() > endYearChooser.getYear()) {
            endYearChooser.setYear(startYearChooser.getYear());
            warningLabel.setText(java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("START_BEFORE_END_MOVING_END"));
        } else if (startYearChooser.getYear() <= endYearChooser.getYear() - Globals.MAX_POPULATION_DATASETS_IN_TABLE) {
            endYearChooser.setYear(startYearChooser.getYear() + Globals.MAX_POPULATION_DATASETS_IN_TABLE);
            warningLabel.setText(java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("MAX_SPAN_ALLOWED_IS_") + Globals.MAX_POPULATION_DATASETS_IN_TABLE + java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("_MOVING_END."));
        }
        updateRangeFields();
    }//GEN-LAST:event_startYearChooserPropertyChange

    private void endYearChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_endYearChooserPropertyChange
        if (startYearChooser.getYear() > endYearChooser.getYear()) {
            startYearChooser.setYear(endYearChooser.getYear());
            warningLabel.setText(java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("END_BEFORE_START_MOVING_START"));
        } else if (startYearChooser.getYear() <= endYearChooser.getYear() - Globals.MAX_POPULATION_DATASETS_IN_TABLE) {
            startYearChooser.setYear(endYearChooser.getYear() - Globals.MAX_POPULATION_DATASETS_IN_TABLE);
            warningLabel.setText(java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("MAX_SPAN_ALLOWED_IS_") + Globals.MAX_POPULATION_DATASETS_IN_TABLE + java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("_MOVING_START."));
        }
        updateRangeFields();
    }//GEN-LAST:event_endYearChooserPropertyChange

    private void tableTypeListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tableTypeListPropertyChange
        // do nothing
    }//GEN-LAST:event_tableTypeListPropertyChange

    private void tableTypeListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tableTypeListValueChanged
        TableBuilderListElement tble = (TableBuilderListElement) tableTypeList.getSelectedValue();
        ImageIcon icon = new ImageIcon(Globals.TABLES_PREVIEW_PATH + "/" + Globals.DEFAULT_PREVIEW_FILENAME,
                tble.getName());

        // set all buttons off
        postScriptButton.setEnabled(false);
        tabulatedButton.setEnabled(false);
        imageButton.setEnabled(false);

        if (tble != null) {
            descriptionTextPane.setText(tble.getDescription());
            if (tble.getPreviewImageFilename() != null) {
                icon = new ImageIcon(Globals.TABLES_PREVIEW_PATH + "/" + tble.getPreviewImageFilename(),
                        tble.getName());
                previewImageLabel.setIcon(icon);
            }

            if (tble.getEngineName().equalsIgnoreCase("incidencerates")) {
                tableBuilder = new AgeSpecificCasesPerHundredThousandTableBuilder();
            } else if (tble.getEngineName().equalsIgnoreCase("numberofcases")) {
                tableBuilder = new AgeSpecificCasesTableBuilder();
            } else if (tble.getEngineName().equalsIgnoreCase("populationpyramids")) {
                tableBuilder = new PopulationPyramidTableBuilder();
            } else if (tble.getEngineName().equalsIgnoreCase("top10piechart")) {
                tableBuilder = new PieChartTableBuilder();
            } else {
                tableBuilder = null;
            }
            
            if (tableBuilder != null) {
                FileTypes[] fileTypes = tableBuilder.getFileTypesGenerated();

                for (FileTypes filetype : fileTypes) {
                    if (filetype.equals(FileTypes.ps)) {
                        postScriptButton.setEnabled(true);
                    } else if (filetype.equals(FileTypes.csv)) {
                        tabulatedButton.setEnabled(true);
                    } else if (filetype.equals(FileTypes.png)) {
                        imageButton.setEnabled(true);
                    }
                }
            }
        } else {
            descriptionTextPane.setText("");
        }
        previewImageLabel.setIcon(icon);
        // tableTypePanel.revalidate();
        // tableTypePanel.repaint();



    }//GEN-LAST:event_tableTypeListValueChanged

    private void headerOfTableTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerOfTableTextFieldMousePressed
        MyPopUpMenu.potentiallyShowPopUpMenuTextComponent(headerOfTableTextField, evt);
    }//GEN-LAST:event_headerOfTableTextFieldMousePressed

    private void headerOfTableTextFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerOfTableTextFieldMouseReleased
        MyPopUpMenu.potentiallyShowPopUpMenuTextComponent(headerOfTableTextField, evt);
    }//GEN-LAST:event_headerOfTableTextFieldMouseReleased

    private void tabbedPaneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabbedPaneFocusLost
    }//GEN-LAST:event_tabbedPaneFocusLost

    private void tableTypePanelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableTypePanelFocusLost
    }//GEN-LAST:event_tableTypePanelFocusLost

    private void postScriptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postScriptButtonActionPerformed
        // generateTablesAction();
    }//GEN-LAST:event_postScriptButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextPane descriptionTextPane;
    private com.toedter.calendar.JYearChooser endYearChooser;
    private javax.swing.JLabel endYearLabel;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JLabel headerOfTableLabel;
    private javax.swing.JTextField headerOfTableTextField;
    private javax.swing.JButton imageButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField midYearTextField;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField numberOfYearsTextField;
    private javax.swing.JPanel populationDatasetChooserPanel;
    private javax.swing.JPanel populationDatasetChoosersPanel;
    private javax.swing.JButton postScriptButton;
    private javax.swing.JLabel previewImageLabel;
    private javax.swing.JLabel previewLabel;
    private canreg.client.gui.components.RangeFilterPanel rangeFilterPanel;
    private javax.swing.JPanel rangePanel;
    private com.toedter.calendar.JYearChooser startYearChooser;
    private javax.swing.JLabel startYearLabel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JList tableTypeList;
    private javax.swing.JPanel tableTypePanel;
    private javax.swing.JScrollPane tableTypeScrollPane;
    private javax.swing.JButton tabulatedButton;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JPanel writeOutPanel;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        rangeFilterPanel.setDatabaseDescription(canreg.client.CanRegClientApp.getApplication().getDatabseDescription());

        // get population datasets
        try {
            populationDatasetsMap = canreg.client.CanRegClientApp.getApplication().getPopulationDatasets();
            Collection<PopulationDataset> populationDatasetsCollection;
            Collection<PopulationDataset> populationDatasetsCollection2 = new LinkedList<PopulationDataset>();
            populationDatasetsCollection = populationDatasetsMap.values();
            for (PopulationDataset pd : populationDatasetsCollection) {
                if (!pd.isWorldPopulationBool()) {
                    populationDatasetsCollection2.add(pd);
                }
            }
            populationDatasetsArray = populationDatasetsCollection2.toArray(new PopulationDataset[0]);
            populatePopulationDataSetChooser();
        } catch (SecurityException ex) {
            Logger.getLogger(TableBuilderInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(TableBuilderInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //get table builder engines
        refreshTableTypeList();
    }

    private void updateRangeFields() {
        String midYearString = "";
        int numberOfYears = endYearChooser.getYear() - startYearChooser.getYear() + 1;
        int midYear = startYearChooser.getYear() + numberOfYears / 2;
        midYearString = midYear + "";
        if (numberOfYears % 2 != 1) {
            midYearString = (midYear - 1) + "-" + midYearString;
        }
        midYearTextField.setText(midYearString);
        numberOfYearsTextField.setText(numberOfYears + "");

        populatePopulationDataSetChooser();
    }

    private void refreshTableTypeList() {
        //get directory of .confs

        File dir = new File(Globals.TABLES_CONF_PATH);
        FilenameFilter filter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(".conf"));
            }
        };
        String[] children = dir.list(filter);

        LinkedList<TableBuilderListElement> tableTypeLinkedList = new LinkedList<TableBuilderListElement>();
        DefaultListModel listModel = new DefaultListModel();
        if (children == null) {
            // Either dir does not exist or is not a directory
        } else {
            //open one by one using configreader
            //make list
            for (int i = 0; i < children.length; i++) {
                // Get filename of file or directory
                String filename = children[i];

                try {
                    String[] tempArray = null;
                    String configFileName = Globals.TABLES_CONF_PATH + "/" + filename;
                    FileReader fileReader = new FileReader(configFileName);
                    LinkedList<ConfigFields> configFields = ConfigFieldsReader.readFile(fileReader);
                    TableBuilderListElement etle = new TableBuilderListElement();
                    etle.setConfigFileName(configFileName);
                    etle.setConfigFields(configFields);

                    tempArray = ConfigFieldsReader.findConfig("table_label", configFields);
                    if (tempArray != null && tempArray.length > 0) {
                        etle.setName(tempArray[0]);
                        System.out.println(tempArray[0]);
                    }

                    tempArray = ConfigFieldsReader.findConfig("table_description", configFields);
                    if (tempArray != null && tempArray.length > 0) {
                        etle.setDescription(tempArray[0]);
                        System.out.println(tempArray[0]);
                    }

                    tempArray = ConfigFieldsReader.findConfig("table_engine", configFields);
                    if (tempArray != null && tempArray.length > 0) {
                        etle.setEngineName(tempArray[0]);
                        System.out.println(tempArray[0]);
                    }

                    String[] engineParameters = ConfigFieldsReader.findConfig("engine_parameters", configFields);
                    etle.setEngineParameters(engineParameters);

                    tempArray = ConfigFieldsReader.findConfig("preview_image", configFields);
                    if (tempArray != null && tempArray.length > 0) {
                        etle.setPreviewImageFilename(tempArray[0]);
                        System.out.println(tempArray[0]);
                    }

                    tableTypeLinkedList.add(etle);
                    listModel.addElement(etle);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TableBuilderInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            tableTypeList.setModel(listModel);
        }
    }

    @Action
    public void generateTablesAction() {
        boolean filterError = false;

        TableBuilderListElement tble = (TableBuilderListElement) tableTypeList.getSelectedValue();

        if (tble == null) {
            JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("NO_TABLE_TYPE_SELECTED"), java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("NO_TABLE_TYPE_SELECTED"), JOptionPane.ERROR_MESSAGE);
            return;
        } else if (tble.getEngineName().equalsIgnoreCase("incidencerates")) {
            tableBuilder = new AgeSpecificCasesPerHundredThousandTableBuilder();
        } else if (tble.getEngineName().equalsIgnoreCase("numberofcases")) {
            tableBuilder = new AgeSpecificCasesTableBuilder();
        } else if (tble.getEngineName().equalsIgnoreCase("populationpyramids")) {
            tableBuilder = new PopulationPyramidTableBuilder();
        } else if (tble.getEngineName().equalsIgnoreCase("top10piechart")) {
            tableBuilder = new PieChartTableBuilder();
        }

        Set<DatabaseVariablesListElement> variables = new LinkedHashSet<DatabaseVariablesListElement>();
        DistributedTableDescription tableDatadescription;

        if (tableBuilder == null) {
            JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("TABLE_TYPE_NOT_YET_IMPLEMENTED"), java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("TABLE_TYPE_NOT_YET_IMPLEMENTED"), JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            String heading = headerOfTableTextField.getText();
            int startYear = startYearChooser.getValue();
            int endYear = endYearChooser.getValue();
            PopulationDataset[] populations = getSelectedPopulations();
            PopulationDataset[] standardPopulations = new PopulationDataset[populations.length];

            if (tableBuilder.areThesePopulationDatasetsCompatible(populations)) {
                String fileName = null;
                // Choose file name;
                if (chooser == null) {
                    path = localSettings.getProperty(LocalSettings.TABLES_PATH_KEY);
                    if (path == null) {
                        chooser = new JFileChooser();
                    } else {
                        chooser = new JFileChooser(path);
                    }
                }
                int returnVal = chooser.showSaveDialog(this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        localSettings.setProperty(LocalSettings.TABLES_PATH_KEY, chooser.getSelectedFile().getParentFile().getCanonicalPath());
                        fileName = chooser.getSelectedFile().getAbsolutePath();
                    } catch (IOException ex) {
                        Logger.getLogger(TableBuilderInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    // cancelled
                    return;
                }

                int i = 0;
                String populationFilterString = "";
                for (PopulationDataset pop : populations) {
                    if (pop != null) {
                        int stdPopID = pop.getWorldPopulationID();
                        standardPopulations[i++] = populationDatasetsMap.get(stdPopID);
                        if (populationFilterString.trim().length() == 0) {
                            populationFilterString = pop.getFilter();
                        } else if (!populationFilterString.equalsIgnoreCase(pop.getFilter())) {
                            // population filters not matching on all the pds...
                            filterError = true;
                        }
                    }
                }

                Globals.StandardVariableNames[] variablesNeeded = tableBuilder.getVariablesNeeded();
                if (variablesNeeded != null) {
                    for (Globals.StandardVariableNames standardVariableName : variablesNeeded) {
                        variables.add(canreg.client.CanRegClientApp.getApplication().getGlobalToolBox().translateStandardVariableNameToDatabaseListElement(standardVariableName.toString()));
                    }
                }
                DatabaseFilter filter = new DatabaseFilter();
                String tableName = Globals.TUMOUR_AND_PATIENT_JOIN_TABLE_NAME;
                String filterString = rangeFilterPanel.getFilter().trim();

                if (filterString.length() != 0) {
                    filterString += " AND ";
                }

                if (populationFilterString.length() != 0) {
                    filterString += populationFilterString + " AND ";
                }

                // add the years to the filter
                DatabaseVariablesListElement incidenceDate = canreg.client.CanRegClientApp.getApplication().getGlobalToolBox().translateStandardVariableNameToDatabaseListElement(Globals.StandardVariableNames.IncidenceDate.toString());
                filterString += incidenceDate.getDatabaseVariableName() + " BETWEEN '" + startYear * 10000 + "' AND '" + ((endYear + 1) * 10000 - 1) + "'";

                // filter only the confirmed cases
                DatabaseVariablesListElement recordStatus = canreg.client.CanRegClientApp.getApplication().getGlobalToolBox().translateStandardVariableNameToDatabaseListElement(Globals.StandardVariableNames.TumourRecordStatus.toString());
                filterString += " AND " + recordStatus.getDatabaseVariableName() + " <> '0'";

                filter.setFilterString(filterString);

                System.out.println(filterString);

                filter.setQueryType(DatabaseFilter.QueryType.FREQUENCIES_BY_YEAR);
                filter.setDatabaseVariables(variables);
                DistributedTableDataSourceClient tableDataSource;
                Object[][] incidenceData = null;
                try {
                    tableDatadescription = canreg.client.CanRegClientApp.getApplication().getDistributedTableDescription(filter, tableName);
                    tableDataSource = new DistributedTableDataSourceClient(tableDatadescription);
                    if (tableDatadescription.getRowCount() > 0) {
                        incidenceData = tableDataSource.retrieveRows(0, tableDatadescription.getRowCount());
                    }

                    setCursor(hourglassCursor);

                    LinkedList<String> filesGenerated = tableBuilder.buildTable(heading, fileName, startYear, endYear, incidenceData, populations, standardPopulations, tble.getConfigFields(), tble.getEngineParameters());

                    String filesGeneratedList = new String();
                    for (String fileN : filesGenerated) {
                        filesGeneratedList += "\n" + fileN;
                    }

                    setCursor(normalCursor);

                    JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("TABLE(S)_BUILT.") + filesGeneratedList, java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("TABLE(S)_BUILT."), JOptionPane.INFORMATION_MESSAGE);

                    // Opening the resulting files...
                    for (String resultFileName : filesGenerated) {
                        canreg.common.Tools.openFile(resultFileName);
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Something wrong with the SQL query: \n" + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(TableBuilderInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(TableBuilderInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(TableBuilderInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotCompatibleDataException ex) {
                    Logger.getLogger(TableBuilderInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(TableBuilderInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("POPULATION_SET_NOT_COMPATIBLE"), java.util.ResourceBundle.getBundle("canreg/client/gui/analysis/resources/TableBuilderInternalFrame").getString("NO_TABLES_BUILT"), JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
