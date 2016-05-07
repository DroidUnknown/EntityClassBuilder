/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muneeb.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author curio
 */
public class EntityClassBuilder extends javax.swing.JFrame {

    /**
     * Creates new form EntityClassBuilder
     */
    public EntityClassBuilder() {
        try {
            initComponents();
            setLocationRelativeTo(null);
            Functions.init(entityNameTextField, sourceTextArea, outputTextArea);
            Functions.log("Program Initialized!");
        } catch (IOException ex) {
            Functions.log(ex);
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

        rootPanel = new javax.swing.JPanel();
        sourcePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sourceTextArea = new javax.swing.JTextArea();
        entityNamePanel = new javax.swing.JPanel();
        entityNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        outputPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        buttonPanel = new javax.swing.JPanel();
        saveToFileButton = new javax.swing.JButton();
        buildClassButton = new javax.swing.JButton();
        loadDataFromFileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Entity Class Builder");
        setResizable(false);

        sourcePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Source Text"));

        sourceTextArea.setColumns(20);
        sourceTextArea.setRows(5);
        sourceTextArea.setToolTipText("<html>\n<p>This text area is for the source data which is column names of an entity separated by line breaks.</p><br />\n\n<b>Example</b><br />\nemployee_id<br />\nemployee_name<br />\nemployee_address<br />\nemployee_email\n</html>");
        jScrollPane1.setViewportView(sourceTextArea);

        javax.swing.GroupLayout sourcePanelLayout = new javax.swing.GroupLayout(sourcePanel);
        sourcePanel.setLayout(sourcePanelLayout);
        sourcePanelLayout.setHorizontalGroup(
            sourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sourcePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        sourcePanelLayout.setVerticalGroup(
            sourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sourcePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        entityNamePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        entityNameTextField.setToolTipText("<html>\n<p>Enter <b> Entity </b> or <b>Class</b> name.<br />\n<b>Example</b><br />\nEmployee\n</html>");

        jLabel3.setText("Entity Name");

        javax.swing.GroupLayout entityNamePanelLayout = new javax.swing.GroupLayout(entityNamePanel);
        entityNamePanel.setLayout(entityNamePanelLayout);
        entityNamePanelLayout.setHorizontalGroup(
            entityNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entityNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entityNameTextField)
                .addContainerGap())
        );
        entityNamePanelLayout.setVerticalGroup(
            entityNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entityNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(entityNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(entityNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        outputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Output"));

        outputTextArea.setEditable(false);
        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        outputTextArea.setToolTipText("This area shows output and logs");
        jScrollPane2.setViewportView(outputTextArea);

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        saveToFileButton.setText("Save To File");
        saveToFileButton.setToolTipText("<html>\n<p>Builds entity class from data provided.</p>\n<br />\n<b>Requied Data</b><br />\nEntity Name<br />\nSource Text<br />\n</html>");
        saveToFileButton.setEnabled(false);
        saveToFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToFileButtonActionPerformed(evt);
            }
        });

        buildClassButton.setText("Build Class");
        buildClassButton.setToolTipText("<html>\n<p>Load data from file or source text area.</p>\n<br />\n<b>Requied Data</b><br />\nEntity Name<br />\n</html>");
        buildClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildClassButtonActionPerformed(evt);
            }
        });

        loadDataFromFileButton.setText("Load Data From File");
        loadDataFromFileButton.setToolTipText("<html>\n<p>Load data from file or source text area.</p>\n<br />\n<b>Requied Data</b><br />\nEntity Name<br />\n</html>");
        loadDataFromFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDataFromFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadDataFromFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buildClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveToFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveToFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buildClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadDataFromFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sourcePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(entityNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(entityNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sourcePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveToFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToFileButtonActionPerformed
        Path currentRelativePath = Paths.get("");
        String currentDirectoryPath = currentRelativePath.toAbsolutePath().toString();

        JFileChooser chooser = new JFileChooser(new File(currentDirectoryPath)); //Downloads Directory as default
        chooser.setDialogTitle("Select Location");

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        String path = "";
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                path = chooser.getSelectedFile().getPath() + "\\" + entityNameTextField.getText() + ".java";

                Functions.log("Saving Entity Class to " + path);

                Functions.saveClassToFile(path);
                
                Functions.log("Path to Class File is: " + path);

            } catch (Exception x) {
                x.printStackTrace();
                Functions.log(x);
            }
        }
    }//GEN-LAST:event_saveToFileButtonActionPerformed

    private void buildClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildClassButtonActionPerformed
        if (Functions.isRequirementComplete()) {
            Functions.fillListFromSourceTextArea();
            Functions.buildEntityClass();
            Functions.log("Entity Class Obtained.");
            saveToFileButton.setEnabled(true);
        }
    }//GEN-LAST:event_buildClassButtonActionPerformed

    private void loadDataFromFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDataFromFileButtonActionPerformed
        Path currentRelativePath = Paths.get("");
        String currentDirectoryPath = currentRelativePath.toAbsolutePath().toString();

        JFileChooser chooser = new JFileChooser(new File(currentDirectoryPath)); //Downloads Directory as default
        chooser.setDialogTitle("Select Location");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt", "text"));

        String path = "";
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                path = chooser.getSelectedFile().getPath();

                Functions.log("Loading data from " + path);

                System.out.println(path);
                Functions.readDataFromFile(path);

                Functions.log("Data from file has been loaded.");

                saveToFileButton.setEnabled(true);
            } catch (IOException ex) {
                ex.printStackTrace();
                Functions.log(ex);
                saveToFileButton.setEnabled(false);
            }
        }
    }//GEN-LAST:event_loadDataFromFileButtonActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EntityClassBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntityClassBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntityClassBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntityClassBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntityClassBuilder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buildClassButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel entityNamePanel;
    private javax.swing.JTextField entityNameTextField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadDataFromFileButton;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JButton saveToFileButton;
    private javax.swing.JPanel sourcePanel;
    private javax.swing.JTextArea sourceTextArea;
    // End of variables declaration//GEN-END:variables
}