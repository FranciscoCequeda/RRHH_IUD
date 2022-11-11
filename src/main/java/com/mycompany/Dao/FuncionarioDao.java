/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dao;

import com.mycompany.Utils.ConnectionUtil;
import com.mycompany.domain.EstadoCivil;
import com.mycompany.domain.Funcionario;
import com.mycompany.domain.Sexo;
import com.mycompany.domain.TipoDocumento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Francisco
 */
public class FuncionarioDao {

    private static final String GET_FUNCIONARIOS = "SELECT tipo_documentos.*, funcionarios.*, estados_civiles.*, sexos.* FROM funcionarios INNER JOIN estados_civiles ON (funcionarios.estado_civil_id = estados_civiles.id) INNER JOIN tipo_documentos ON (funcionarios.tipo_documento_id = tipo_documentos.id) INNER JOIN sexos ON (funcionarios.sexo_id = sexos.id) ORDER BY funcionarios.id ASC";
    private static final String GET_FUNCIONARIO_BY_ID = "SELECT tipo_documentos.*, funcionarios.*, estados_civiles.*, sexos.* FROM funcionarios INNER JOIN estados_civiles ON (funcionarios.estado_civil_id = estados_civiles.id) INNER JOIN tipo_documentos ON (funcionarios.tipo_documento_id = tipo_documentos.id) INNER JOIN sexos ON (funcionarios.sexo_id = sexos.id) WHERE (funcionarios.id = ?)";
    private static final String CREATE_FUNCIONARIO = "INSERT INTO funcionarios(tipo_documento_id, numero_identificacion, nombre1, nombre2, apellido1, apellido2, fecha_nacimiento, estado_civil_id, sexo_id, direccion, celular) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_FUNCIONARIO_BY_ID = "DELETE FROM funcionarios WHERE (id = ?)";
    private static final String UPDATE_FUNCIONARIO_BY_ID = "UPDATE funcionarios SET tipo_documento_id = ?, numero_identificacion = ?, nombre1 = ?, nombre2 = ?, apellido1 = ?, apellido2 = ?, fecha_nacimiento = ?, estado_civil_id = ?, sexo_id = ?, direccion = ?, celular = ? WHERE id = ?";

    public List<Funcionario> getFuncionarios() throws SQLException {
        Connection connect = null;
        PreparedStatement sql = null;
        ResultSet result = null;

        List<Funcionario> listaFuncionarios = new ArrayList<>();

        try {

            connect = ConnectionUtil.getConnection();
            sql = connect.prepareStatement(GET_FUNCIONARIOS);
            result = sql.executeQuery();

            while (result.next()) {
                Funcionario funcionario = new Funcionario();
                EstadoCivil estadoCivil = new EstadoCivil();
                TipoDocumento tipoDocumento = new TipoDocumento();
                Sexo sexo = new Sexo();

                tipoDocumento.setId(result.getInt("id"));
                tipoDocumento.setTipoDocumento(result.getString("tipo_documento"));
                tipoDocumento.setSigla(result.getString("sigla"));
                tipoDocumento.setEstado(result.getInt("estado"));
                tipoDocumento.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());

                funcionario.setfuncionarioId(result.getInt("funcionarios.id"));
                funcionario.setTipoDocumento(tipoDocumento);
                funcionario.setNumeroIdentificacion(result.getString("numero_identificacion"));
                funcionario.setNombre1(result.getString("nombre1"));
                funcionario.setNombre2(result.getString("nombre2"));
                funcionario.setApellido1(result.getString("apellido1"));
                funcionario.setApellido2(result.getString("apellido2"));
                funcionario.setFechaNacimiento(result.getDate("fecha_nacimiento"));
                funcionario.setEstadoCivil(estadoCivil);
                funcionario.setSexo(sexo);
                funcionario.setDireccion(result.getString("direccion"));
                funcionario.setCelular(result.getString("celular"));
                funcionario.setEstado(result.getInt("estado"));
                funcionario.setFechaCreacion(result.getTimestamp("fecha_creacion").toLocalDateTime());

                estadoCivil.setId(result.getInt("id"));
                estadoCivil.setEstadoCivil(result.getString("estado_civil"));
                estadoCivil.setEstado(result.getInt("estado"));
                estadoCivil.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());

                sexo.setSexoId(result.getInt("id"));
                sexo.setSexo(result.getString("sexo"));
                sexo.setSigla(result.getString("sigla"));
                sexo.setEstado(result.getInt("estado"));
                sexo.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());

                listaFuncionarios.add(funcionario);
            }
            return listaFuncionarios;
        } finally {

            if (connect != null) {
                connect.close();
            }

            if (sql != null) {
                sql.close();
            }

            if (result != null) {
                result.close();
            }
        }

    }

    public Funcionario getFuncionario(int id_funcionario) throws SQLException {

        Funcionario funcionario = new Funcionario();
        EstadoCivil estadoCivil = new EstadoCivil();
        TipoDocumento tipoDocumento = new TipoDocumento();
        Sexo sexo = new Sexo();

        Connection connect = null;
        PreparedStatement sql = null;
        ResultSet result = null;

        try {

            connect = ConnectionUtil.getConnection();
            sql = connect.prepareStatement(GET_FUNCIONARIO_BY_ID);
            sql.setInt(1, id_funcionario);
            result = sql.executeQuery();

            if (result != null) {
                if (result.next()) {

                    tipoDocumento.setId(result.getInt("id"));
                    tipoDocumento.setTipoDocumento(result.getString("tipo_documento"));
                    tipoDocumento.setSigla(result.getString("sigla"));
                    tipoDocumento.setEstado(result.getInt("estado"));
                    tipoDocumento.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());

                    funcionario.setfuncionarioId(result.getInt("id"));
                    funcionario.setTipoDocumento(tipoDocumento);
                    funcionario.setNumeroIdentificacion(result.getString("numero_identificacion"));
                    funcionario.setNombre1(result.getString("nombre1"));
                    funcionario.setNombre2(result.getString("nombre2"));
                    funcionario.setApellido1(result.getString("apellido1"));
                    funcionario.setApellido2(result.getString("apellido2"));
                    funcionario.setFechaNacimiento(result.getDate("fecha_nacimiento"));
                    funcionario.setEstadoCivil(estadoCivil);
                    funcionario.setSexo(sexo);
                    funcionario.setDireccion(result.getString("direccion"));
                    funcionario.setCelular(result.getString("celular"));
                    funcionario.setEstado(result.getInt("estado"));
                    funcionario.setFechaCreacion(result.getTimestamp("fecha_creacion").toLocalDateTime());

                    estadoCivil.setId(result.getInt("id"));
                    estadoCivil.setEstadoCivil(result.getString("estado_civil"));
                    estadoCivil.setEstado(result.getInt("estado"));
                    estadoCivil.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());

                    sexo.setSexoId(result.getInt("id"));
                    sexo.setSexo(result.getString("sexo"));
                    sexo.setSigla(result.getString("sigla"));
                    sexo.setEstado(result.getInt("estado"));
                    sexo.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());
                }
                return funcionario;
            }

            System.out.println("Funcionario no encontrado!!");
            return funcionario;
        } finally {

            if (connect != null) {
                connect.close();
            }

            if (sql != null) {
                sql.close();
            }

            if (result != null) {
                result.close();
            }
        }
    }

    public void createFuncionario(Funcionario funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement sql = null;

        try {
            connection = ConnectionUtil.getConnection();
            sql = connection.prepareCall(CREATE_FUNCIONARIO);

            sql.setInt(1, funcionario.getTipoDocumento().getId());
            sql.setString(2, funcionario.getNumeroIdentificacion());
            sql.setString(3, funcionario.getNombre1());
            sql.setString(4, funcionario.getNombre2());
            sql.setString(5, funcionario.getApellido1());
            sql.setString(6, funcionario.getApellido2());
            sql.setDate(7, (Date) funcionario.getFechaNacimiento());
            sql.setInt(8, funcionario.getEstadoCivil().getId());
            sql.setInt(9, funcionario.getSexo().getSexoId());
            sql.setString(10, funcionario.getDireccion());
            sql.setString(11, funcionario.getCelular());
            sql.executeUpdate();
        } finally {
            if (sql != null) {
                sql.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    public void deleteFuncionario(int id_funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement sql = null;

        try {

            connection = ConnectionUtil.getConnection();
            sql = connection.prepareStatement(DELETE_FUNCIONARIO_BY_ID);
            sql.setInt(1, id_funcionario);
            sql.executeUpdate();

        } finally {
            if (sql != null) {
                sql.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
    
     public void updateFuncionario(int idFuncionario, Funcionario funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement sql = null;

        try {
            connection = ConnectionUtil.getConnection();
            sql = connection.prepareStatement(UPDATE_FUNCIONARIO_BY_ID);
            
            
            sql.setInt(1, funcionario.getTipoDocumento().getId());
            sql.setString(2, funcionario.getNumeroIdentificacion());
            sql.setString(3, funcionario.getNombre1());
            sql.setString(4, funcionario.getNombre2());
            sql.setString(5, funcionario.getApellido1());
            sql.setString(6, funcionario.getApellido2());
            sql.setDate(7, (Date) funcionario.getFechaNacimiento());
            sql.setInt(8, funcionario.getEstadoCivil().getId());
            sql.setInt(9, funcionario.getSexo().getSexoId());
            sql.setString(10, funcionario.getDireccion());
            sql.setString(11, funcionario.getCelular());
            sql.setInt(12, funcionario.getfuncionarioId());
            
            sql.executeUpdate();
            
            System.out.println("sql: " + sql);
        } finally {
            if (sql != null) {
                sql.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
    
    
}
