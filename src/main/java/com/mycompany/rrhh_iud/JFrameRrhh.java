/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rrhh_iud;

import com.mycompany.Controller.FuncionarioController;
import com.mycompany.Controller.SexoController;
import com.mycompany.Controller.TipoDocumentoController;
import com.mycompany.Controller.EstadoCivilController;
import com.mycompany.domain.EstadoCivil;
import com.mycompany.domain.Funcionario;
import com.mycompany.domain.Sexo;
import com.mycompany.domain.TipoDocumento;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Francisco
 */
public class JFrameRrhh extends javax.swing.JFrame {

    private final FuncionarioController funcionarioController = new FuncionarioController();
    private final SexoController sexoController = new SexoController();
    private final TipoDocumentoController tipoDocumentoController = new TipoDocumentoController();
    private final EstadoCivilController estadoCivilController = new EstadoCivilController();

    private static final String[] COLUMNAS = {
        "ID", "TIPO DOCUMENTO", "Nº DOCUMENTO", "NOMBRE1",
        "NOMBRE2", "APELLIDO1", "APELLIDO2", "F NACIMIENTO",
        "ESTADO CIVIL", "SEXO", "DIRECCION", "CELULAR", "ESTADO", "F CREACION"};

    TipoDocumento tipodDocSelect;
    Sexo sexoSelected;
    EstadoCivil estadoCivilSelected;

    /**
     * Creates new form JFrameRrhh
     */
    public JFrameRrhh() {

        initComponents();
        listarFuncionarios();
        listenerCbxFuncionarios();
        listarEstadoCivil();
        listarSexos();
        listarTipoDocumentos();
        listenerCombosCrear();
        listenerCombosEditar();
        limpiarCamposEdit();
    }

    private void limpiarCamposEdit() {

        cbxTipoDocE.setSelectedIndex(-1);
        txtID.setText("");
        txtDocumentoE.setText("");
        txtNombre1E.setText("");
        txtNombre2E.setText("");
        txtApellido1E.setText("");
        txtApellido2E.setText("");
        cbxSexoE.setSelectedIndex(-1);
        jDCFNacimientoE.setDate(null);
        txtDireccionE.setText("");
        txtCelularE.setText("");
        cbxEstadoCilvilE.setSelectedIndex(-1);
    }

    private void limpiarCampos() {

        cbxTipoDoc.setSelectedIndex(-1);
        txtID.setText("");
        txtDocumento.setText("");
        txtNombre1.setText("");
        txtNombre2.setText("");
        txtApellido1.setText("");
        txtApellido2.setText("");
        cbxSexo.setSelectedIndex(-1);
        jDCFNacimiento.setDate(null);
        txtDireccion.setText("");
        txtCelular.setText("");
        cbxEstadoCilvil.setSelectedIndex(-1);
    }

    private void listarFuncionarios() {

        cbxFuncionarios.removeAllItems();
        cbxFuncionarios.removeAll();

        DefaultTableModel defaultTableModel = new DefaultTableModel();

        for (String column : COLUMNAS) {
            defaultTableModel.addColumn(column);
        }

        tblFuncionarios.setModel(defaultTableModel);

        try {
            List<Funcionario> listaFuncionarios = funcionarioController.getFuncionarios();

            if (listaFuncionarios.isEmpty()) {
                return;
            }

            defaultTableModel.setRowCount(listaFuncionarios.size());

            int row = 0;

            for (Funcionario funcionario : listaFuncionarios) {
                defaultTableModel.setValueAt(funcionario.getfuncionarioId(), row, 0);
                defaultTableModel.setValueAt(funcionario.getTipoDocumento().getTipoDocumento(), row, 1);
                defaultTableModel.setValueAt(funcionario.getNumeroIdentificacion(), row, 2);
                defaultTableModel.setValueAt(funcionario.getNombre1(), row, 3);
                defaultTableModel.setValueAt(funcionario.getNombre2(), row, 4);
                defaultTableModel.setValueAt(funcionario.getApellido1(), row, 5);
                defaultTableModel.setValueAt(funcionario.getApellido2(), row, 6);
                defaultTableModel.setValueAt(funcionario.getFechaNacimiento(), row, 7);
                defaultTableModel.setValueAt(funcionario.getEstadoCivil().getEstadoCivil(), row, 8);
                defaultTableModel.setValueAt(funcionario.getSexo().getSexo(), row, 9);
                defaultTableModel.setValueAt(funcionario.getDireccion(), row, 10);
                defaultTableModel.setValueAt(funcionario.getCelular(), row, 11);
                defaultTableModel.setValueAt(funcionario.getEstado(), row, 12);
                defaultTableModel.setValueAt(funcionario.getFechaCreacion(), row, 13);

                row++;

                cbxFuncionarios.addItem(funcionario);
            }

            cbxFuncionarios.setSelectedIndex(-1);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void listarSexos() {

        cbxSexoE.removeAllItems();
        cbxSexoE.removeAll();
        cbxSexo.removeAllItems();
        cbxSexo.removeAll();

        try {
            List<Sexo> listaSexo = sexoController.getSexos();

            if (listaSexo.isEmpty()) {
                return;
            }

            for (Sexo sexo : listaSexo) {

                cbxSexo.addItem(sexo);
                cbxSexoE.addItem(sexo);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void listarTipoDocumentos() {

        cbxTipoDocE.removeAllItems();
        cbxTipoDocE.removeAll();
        cbxTipoDoc.removeAllItems();
        cbxTipoDoc.removeAll();

        try {
            List<TipoDocumento> listaTipoDocumentos = tipoDocumentoController.getTipoDocumentos();

            if (listaTipoDocumentos.isEmpty()) {
                return;
            }

            for (TipoDocumento tipoDoc : listaTipoDocumentos) {

                cbxTipoDocE.addItem(tipoDoc);
                cbxTipoDoc.addItem(tipoDoc);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void listarEstadoCivil() {

        cbxEstadoCilvilE.removeAllItems();
        cbxEstadoCilvilE.removeAll();
        cbxEstadoCilvil.removeAllItems();
        cbxEstadoCilvil.removeAll();

        try {
            List<EstadoCivil> listaEstadoCivil = estadoCivilController.getEstadosCiviles();

            if (listaEstadoCivil.isEmpty()) {
                return;
            }

            for (EstadoCivil estadoCivil : listaEstadoCivil) {

                cbxEstadoCilvilE.addItem(estadoCivil);
                cbxEstadoCilvil.addItem(estadoCivil);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void listenerCbxFuncionarios() {

        cbxFuncionarios.addItemListener(evnt -> {
            Funcionario funcionario = (Funcionario) evnt.getItem();
            cbxTipoDocE.getModel().setSelectedItem(funcionario.getTipoDocumento());
            txtID.setText(String.valueOf(funcionario.getfuncionarioId()));
            txtDocumentoE.setText(String.valueOf(funcionario.getNumeroIdentificacion()));
            txtNombre1E.setText(String.valueOf(funcionario.getNombre1()));
            txtNombre2E.setText(String.valueOf(funcionario.getNombre2()));
            txtApellido1E.setText(String.valueOf(funcionario.getApellido1()));
            txtApellido2E.setText(String.valueOf(funcionario.getApellido2()));
            cbxSexoE.getModel().setSelectedItem(funcionario.getSexo());
            jDCFNacimientoE.setDate(funcionario.getFechaNacimiento());
            txtDireccionE.setText(String.valueOf(funcionario.getDireccion()));
            txtCelularE.setText(String.valueOf(funcionario.getCelular()));
            cbxEstadoCilvilE.getModel().setSelectedItem(funcionario.getEstadoCivil());
        });
    }

    private void listenerCombosCrear() {
        cbxTipoDoc.getModel().setSelectedItem("---SELECCIONE---");
        cbxEstadoCilvil.getModel().setSelectedItem("---SELECCIONE---");
        cbxSexo.getModel().setSelectedItem("---SELECCIONE---");

        cbxTipoDoc.addItemListener(evnt -> {
            if (evnt.getStateChange() == evnt.SELECTED) {

                tipodDocSelect = new TipoDocumento();

                TipoDocumento tipodoc = (TipoDocumento) evnt.getItem();

                tipodDocSelect.setId(tipodoc.getId());
                tipodDocSelect.setTipoDocumento(tipodoc.getTipoDocumento());
                tipodDocSelect.setSigla(tipodoc.getSigla());
                tipodDocSelect.setFechaCreacion(tipodoc.getFechaCreacion());
                tipodDocSelect.setEstado(tipodoc.getEstado());
            }

            System.out.println("tipoDocSeleccionado: " + tipodDocSelect);

        });

        cbxSexo.addItemListener(evntsex -> {
            if (evntsex.getStateChange() == evntsex.SELECTED) {
                sexoSelected = new Sexo();
                sexoSelected = (Sexo) evntsex.getItem();
            }

            System.out.println("sexoSeleccionado: " + sexoSelected);
        });

        cbxEstadoCilvil.addItemListener(evntes -> {
            if (evntes.getStateChange() == evntes.SELECTED) {
                estadoCivilSelected = new EstadoCivil();
                estadoCivilSelected = (EstadoCivil) evntes.getItem();
            }

            System.out.println("eCivilSeleccionado: " + estadoCivilSelected);
        });

    }

    private void listenerCombosEditar() {
        tipodDocSelect = (TipoDocumento) cbxTipoDocE.getSelectedItem();
        sexoSelected = (Sexo) cbxSexoE.getSelectedItem();
        estadoCivilSelected = (EstadoCivil) cbxEstadoCilvilE.getSelectedItem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCrearFuncionarios = new javax.swing.JLabel();
        jPFuncionarios = new javax.swing.JPanel();
        jTabFuncionarios = new javax.swing.JTabbedPane();
        jPCrearFun = new javax.swing.JPanel();
        jPCrearFun2 = new javax.swing.JPanel();
        lblDocumento = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        lblApellido1 = new javax.swing.JLabel();
        lblApellido2 = new javax.swing.JLabel();
        lblFNacimiento = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JTextField();
        txtNombre2 = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        lblTipoDoc1 = new javax.swing.JLabel();
        cbxTipoDoc = new javax.swing.JComboBox<>();
        lblSexo1 = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        lblEstadoCivil1 = new javax.swing.JLabel();
        cbxEstadoCilvil = new javax.swing.JComboBox<>();
        jDCFNacimiento = new com.toedter.calendar.JDateChooser();
        jPGestionarFun = new javax.swing.JPanel();
        jPGestionarFun2 = new javax.swing.JPanel();
        lblFuncionarios = new javax.swing.JLabel();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblTipoDoc = new javax.swing.JLabel();
        cbxTipoDocE = new javax.swing.JComboBox<>();
        lblDocumentoE = new javax.swing.JLabel();
        lblNombre1E = new javax.swing.JLabel();
        lblNombre2E = new javax.swing.JLabel();
        lblApellido1E = new javax.swing.JLabel();
        lblApellido2E = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblFNacimientoE = new javax.swing.JLabel();
        lblDireccionE = new javax.swing.JLabel();
        lblCelularE = new javax.swing.JLabel();
        lblEstadoCivil = new javax.swing.JLabel();
        txtDocumentoE = new javax.swing.JTextField();
        txtNombre1E = new javax.swing.JTextField();
        txtNombre2E = new javax.swing.JTextField();
        txtApellido1E = new javax.swing.JTextField();
        txtApellido2E = new javax.swing.JTextField();
        cbxSexoE = new javax.swing.JComboBox<>();
        txtDireccionE = new javax.swing.JTextField();
        txtCelularE = new javax.swing.JTextField();
        cbxEstadoCilvilE = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jDCFNacimientoE = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCrearFuncionarios.setText("MODULO GESTION DE FUNCIONARIOS");
        lblCrearFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(lblCrearFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        jPCrearFun2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese Informacion de Funcionario:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPCrearFun2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDocumento.setText("Nº DOCUMENTO");
        jPCrearFun2.add(lblDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 115, -1));

        lblNombre1.setText("NOMBRE1");
        jPCrearFun2.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        lblNombre2.setText("NOMBRE2");
        jPCrearFun2.add(lblNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        lblApellido1.setText("APELLIDO1");
        jPCrearFun2.add(lblApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        lblApellido2.setText("APELLIDO2");
        jPCrearFun2.add(lblApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        lblFNacimiento.setText("FECHA NACIMIENTO");
        jPCrearFun2.add(lblFNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

        lblDireccion.setText("DIRECCION");
        jPCrearFun2.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, -1, -1));

        lblCelular.setText("CELULAR");
        jPCrearFun2.add(lblCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, -1, -1));

        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });
        jPCrearFun2.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 160, -1));

        txtNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre1ActionPerformed(evt);
            }
        });
        jPCrearFun2.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 115, -1));

        txtNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre2ActionPerformed(evt);
            }
        });
        jPCrearFun2.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 115, -1));

        txtApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido1ActionPerformed(evt);
            }
        });
        jPCrearFun2.add(txtApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 115, -1));

        txtApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido2ActionPerformed(evt);
            }
        });
        jPCrearFun2.add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 115, -1));

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPCrearFun2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 120, -1));

        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        jPCrearFun2.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 103, -1));

        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPCrearFun2.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, -1, -1));

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFuncionarios.setEditingColumn(0);
        tblFuncionarios.setEditingRow(0);
        tblFuncionarios.setEnabled(false);
        tblFuncionarios.setRowSelectionAllowed(false);
        tblFuncionarios.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tblFuncionarios);

        jPCrearFun2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 269, 1224, 257));

        lblTipoDoc1.setText("TIPO DOCUMENTO");
        jPCrearFun2.add(lblTipoDoc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        cbxTipoDoc.setName(""); // NOI18N
        jPCrearFun2.add(cbxTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 160, -1));

        lblSexo1.setText("SEXO");
        jPCrearFun2.add(lblSexo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 43, -1));

        cbxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexoActionPerformed(evt);
            }
        });
        jPCrearFun2.add(cbxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 120, -1));

        lblEstadoCivil1.setText("ESTADO CIVIL");
        jPCrearFun2.add(lblEstadoCivil1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 102, -1));

        jPCrearFun2.add(cbxEstadoCilvil, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 120, -1));

        jDCFNacimiento.setDateFormatString("yyyy-MM-dd");
        jPCrearFun2.add(jDCFNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 120, -1));

        javax.swing.GroupLayout jPCrearFunLayout = new javax.swing.GroupLayout(jPCrearFun);
        jPCrearFun.setLayout(jPCrearFunLayout);
        jPCrearFunLayout.setHorizontalGroup(
            jPCrearFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCrearFunLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCrearFun2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPCrearFunLayout.setVerticalGroup(
            jPCrearFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCrearFunLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCrearFun2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabFuncionarios.addTab("Crear Funcionario", jPCrearFun);

        jPGestionarFun2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestionar informacion Funcionarios:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPGestionarFun2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFuncionarios.setText("Funcionarios");
        jPGestionarFun2.add(lblFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 24, -1, -1));

        jPGestionarFun2.add(cbxFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 50, 272, -1));

        lblID.setText("ID");
        jPGestionarFun2.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtID.setEditable(false);
        txtID.setMaximumSize(new java.awt.Dimension(64, 22));
        txtID.setOpaque(true);
        jPGestionarFun2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 70, 20));

        lblTipoDoc.setText("TIPO DOCUMENTO");
        jPGestionarFun2.add(lblTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        cbxTipoDocE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoDocEActionPerformed(evt);
            }
        });
        jPGestionarFun2.add(cbxTipoDocE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 160, -1));

        lblDocumentoE.setText("Nº DOCUMENTO");
        jPGestionarFun2.add(lblDocumentoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 115, -1));

        lblNombre1E.setText("NOMBRE1");
        jPGestionarFun2.add(lblNombre1E, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        lblNombre2E.setText("NOMBRE2");
        jPGestionarFun2.add(lblNombre2E, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        lblApellido1E.setText("APELLIDO1");
        jPGestionarFun2.add(lblApellido1E, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        lblApellido2E.setText("APELLIDO2");
        jPGestionarFun2.add(lblApellido2E, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        lblSexo.setText("SEXO");
        jPGestionarFun2.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 43, -1));

        lblFNacimientoE.setText("FECHA NACIMIENTO");
        jPGestionarFun2.add(lblFNacimientoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        lblDireccionE.setText("DIRECCION");
        jPGestionarFun2.add(lblDireccionE, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, -1, -1));

        lblCelularE.setText("CELULAR");
        jPGestionarFun2.add(lblCelularE, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, -1, -1));

        lblEstadoCivil.setText("ESTADO CIVIL");
        jPGestionarFun2.add(lblEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 102, -1));

        txtDocumentoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoEActionPerformed(evt);
            }
        });
        jPGestionarFun2.add(txtDocumentoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 160, -1));

        txtNombre1E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre1EActionPerformed(evt);
            }
        });
        jPGestionarFun2.add(txtNombre1E, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 115, -1));

        txtNombre2E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre2EActionPerformed(evt);
            }
        });
        jPGestionarFun2.add(txtNombre2E, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 115, -1));

        txtApellido1E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido1EActionPerformed(evt);
            }
        });
        jPGestionarFun2.add(txtApellido1E, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 115, -1));

        txtApellido2E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido2EActionPerformed(evt);
            }
        });
        jPGestionarFun2.add(txtApellido2E, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 115, -1));

        cbxSexoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexoEActionPerformed(evt);
            }
        });
        jPGestionarFun2.add(cbxSexoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 110, -1));

        txtDireccionE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionEActionPerformed(evt);
            }
        });
        jPGestionarFun2.add(txtDireccionE, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 100, -1));

        txtCelularE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularEActionPerformed(evt);
            }
        });
        jPGestionarFun2.add(txtCelularE, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, 103, -1));

        jPGestionarFun2.add(cbxEstadoCilvilE, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 102, -1));

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPGestionarFun2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 180, 80, -1));

        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPGestionarFun2.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, -1, -1));

        jDCFNacimientoE.setDateFormatString("yyyy-MM-dd");
        jPGestionarFun2.add(jDCFNacimientoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 110, -1));

        javax.swing.GroupLayout jPGestionarFunLayout = new javax.swing.GroupLayout(jPGestionarFun);
        jPGestionarFun.setLayout(jPGestionarFunLayout);
        jPGestionarFunLayout.setHorizontalGroup(
            jPGestionarFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGestionarFunLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGestionarFun2, javax.swing.GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGestionarFunLayout.setVerticalGroup(
            jPGestionarFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGestionarFunLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPGestionarFun2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        jTabFuncionarios.addTab("Gestionar Funcionarios", jPGestionarFun);

        javax.swing.GroupLayout jPFuncionariosLayout = new javax.swing.GroupLayout(jPFuncionarios);
        jPFuncionarios.setLayout(jPFuncionariosLayout);
        jPFuncionariosLayout.setHorizontalGroup(
            jPFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabFuncionarios)
                .addContainerGap())
        );
        jPFuncionariosLayout.setVerticalGroup(
            jPFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabFuncionarios)
                .addContainerGap())
        );

        getContentPane().add(jPFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1270, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void txtNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1ActionPerformed

    private void txtNombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre2ActionPerformed

    private void txtApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido1ActionPerformed

    private void txtApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido2ActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtDocumentoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoEActionPerformed

    private void txtNombre1EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre1EActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1EActionPerformed

    private void txtNombre2EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre2EActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre2EActionPerformed

    private void txtApellido1EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido1EActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido1EActionPerformed

    private void txtApellido2EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido2EActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido2EActionPerformed

    private void txtDireccionEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionEActionPerformed

    private void txtCelularEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularEActionPerformed

    private void cbxSexoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSexoEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSexoEActionPerformed

    private void cbxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSexoActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:

        if (cbxTipoDoc.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione Tipo Documento!");
            cbxTipoDoc.requestFocus();
            return;
        }

        if (cbxSexo.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione Sexo!");
            cbxSexo.requestFocus();
            return;
        }

        if (cbxEstadoCilvil.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione Estado Civil!");
            cbxEstadoCilvil.requestFocus();
            return;
        }

        if (txtDocumento.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Documento");
            txtDocumento.requestFocus();
            return;
        }

        if (txtNombre1.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Nombre1");
            txtNombre1.requestFocus();
            return;
        }


        if (txtApellido1.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Apellido1");
            txtApellido1.requestFocus();
            return;
        }

        if (txtApellido2.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Apellido2");
            txtApellido2.requestFocus();
            return;
        }

        if (jDCFNacimiento.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Digite Fecha Nacimiento");
            jDCFNacimiento.requestFocus();
            return;
        }

        if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Direccion");
            txtDireccion.requestFocus();
            return;
        }

        if (txtCelular.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Celular");
            txtCelular.requestFocus();
            return;
        }

        Date fechaCalendar = jDCFNacimiento.getDate();

        long fechaLong = fechaCalendar.getTime();

        java.sql.Date fecha = new java.sql.Date(fechaLong);

        Funcionario funcionario = new Funcionario();
        funcionario.setTipoDocumento(tipodDocSelect);
        funcionario.setNumeroIdentificacion(txtDocumento.getText().trim().toUpperCase());
        funcionario.setNombre1(txtNombre1.getText().trim().toUpperCase());
        funcionario.setNombre2(txtNombre2.getText().trim().toUpperCase());
        funcionario.setApellido1(txtApellido1.getText().trim().toUpperCase());
        funcionario.setApellido2(txtApellido2.getText().trim().toUpperCase());
        funcionario.setFechaNacimiento(fecha);
        funcionario.setEstadoCivil(estadoCivilSelected);
        funcionario.setSexo(sexoSelected);
        funcionario.setDireccion(txtDireccion.getText().toUpperCase());
        funcionario.setCelular(txtCelular.getText());

        try {
            funcionarioController.createFuncionario(funcionario);
            listarFuncionarios();
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Funcionario creado exitosamente!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Funcionario No pudo ser creado!");
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtID.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un Funcionario de la lista!!");
            txtID.requestFocus();
            return;
        }

        int op = JOptionPane.showConfirmDialog(null, "Desea Eliminar el Funcionario?",
                "Eliminar Funcionario", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (op == 0) {

            try {
                funcionarioController.deleteFuncionario(Integer.parseInt(txtID.getText()));
                listarFuncionarios();
                limpiarCamposEdit();
                JOptionPane.showMessageDialog(null, "Funcionario Eliminado!", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Funcionario Se Elimino!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (txtID.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un elemento de la lista!!");
            txtID.requestFocus();
            return;
        }

        if (tipodDocSelect == null) {
            JOptionPane.showMessageDialog(null, "Seleccione Tipo Documento!");
            cbxTipoDoc.requestFocus();
            return;
        }


        if (sexoSelected == null) {
            JOptionPane.showMessageDialog(null, "Seleccione Sexo!");
            cbxSexo.requestFocus();
            return;
        }


        if (estadoCivilSelected == null) {
            JOptionPane.showMessageDialog(null, "Seleccione Estado Civil!");
            cbxEstadoCilvil.requestFocus();
            return;
        }

        if (txtDocumentoE.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Documento");
            txtDocumento.requestFocus();
            return;
        }

        if (txtNombre1E.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Nombre1");
            txtNombre1.requestFocus();
            return;
        }

        if (txtApellido1E.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Apellido1");
            txtApellido1.requestFocus();
            return;
        }

        if (txtApellido2E.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Apellido2");
            txtApellido2.requestFocus();
            return;
        }

        if (jDCFNacimientoE.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Digite Fecha Nacimiento");
            jDCFNacimientoE.requestFocus();
            return;
        }

        if (txtDireccionE.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Direccion");
            txtDireccion.requestFocus();
            return;
        }

        if (txtCelularE.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Celular");
            txtCelular.requestFocus();
            return;
        }

        Date fechaCalendar = jDCFNacimientoE.getDate();

        long fechaLong = fechaCalendar.getTime();

        java.sql.Date fecha = new java.sql.Date(fechaLong);

        Funcionario funcionario = new Funcionario();

        funcionario.setfuncionarioId(Integer.parseInt(txtID.getText().trim()));
        funcionario.setTipoDocumento(tipodDocSelect);
        funcionario.setNumeroIdentificacion(txtDocumentoE.getText().trim());
        funcionario.setNombre1(txtNombre1E.getText().trim());
        funcionario.setNombre2(txtNombre2E.getText().trim());
        funcionario.setApellido1(txtApellido1E.getText().trim());
        funcionario.setApellido2(txtApellido2E.getText().trim());
        funcionario.setFechaNacimiento(fecha);
        funcionario.setEstadoCivil(estadoCivilSelected);
        funcionario.setSexo(sexoSelected);
        funcionario.setDireccion(txtDireccionE.getText().trim());
        funcionario.setCelular(txtCelularE.getText().trim());

        int op = JOptionPane.showConfirmDialog(null, "Desea Actualizar el Funcionario?", "Actualizar Funcionario", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (op == 0) {

            try {
                funcionarioController.updateFuncionario(Integer.parseInt(txtID.getText()), funcionario);
                listarFuncionarios();
                limpiarCamposEdit();
                JOptionPane.showMessageDialog(null, "Funcionario Actualizado exitosamente!", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Funcionario No pudo ser Actualizado!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void cbxTipoDocEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoDocEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoDocEActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameRrhh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRrhh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRrhh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRrhh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRrhh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<EstadoCivil> cbxEstadoCilvil;
    private javax.swing.JComboBox<EstadoCivil> cbxEstadoCilvilE;
    private javax.swing.JComboBox<Funcionario> cbxFuncionarios;
    private javax.swing.JComboBox<Sexo> cbxSexo;
    private javax.swing.JComboBox<Sexo> cbxSexoE;
    private javax.swing.JComboBox<TipoDocumento> cbxTipoDoc;
    private javax.swing.JComboBox<TipoDocumento> cbxTipoDocE;
    private com.toedter.calendar.JDateChooser jDCFNacimiento;
    private com.toedter.calendar.JDateChooser jDCFNacimientoE;
    private javax.swing.JPanel jPCrearFun;
    private javax.swing.JPanel jPCrearFun2;
    private javax.swing.JPanel jPFuncionarios;
    private javax.swing.JPanel jPGestionarFun;
    private javax.swing.JPanel jPGestionarFun2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabFuncionarios;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido1E;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblApellido2E;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCelularE;
    private javax.swing.JLabel lblCrearFuncionarios;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionE;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblDocumentoE;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblEstadoCivil1;
    private javax.swing.JLabel lblFNacimiento;
    private javax.swing.JLabel lblFNacimientoE;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre1E;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre2E;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexo1;
    private javax.swing.JLabel lblTipoDoc;
    private javax.swing.JLabel lblTipoDoc1;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido1E;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtApellido2E;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCelularE;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionE;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtDocumentoE;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre1E;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtNombre2E;
    // End of variables declaration//GEN-END:variables
}
