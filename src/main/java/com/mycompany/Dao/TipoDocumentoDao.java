/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dao;

import com.mycompany.Utils.ConnectionUtil;
import com.mycompany.domain.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Francisco
 */
public class TipoDocumentoDao {

    private static final String GET_TIPO_DOCUMENTOS = "SELECT * FROM tipo_documentos";

    public List<TipoDocumento> getTipoDocumentos() throws SQLException {
        Connection connect = null;
        PreparedStatement sql = null;
        ResultSet result = null;

        List<TipoDocumento> listaTipoDocumentos = new ArrayList<>();

        try {

            connect = ConnectionUtil.getConnection();
            sql = connect.prepareStatement(GET_TIPO_DOCUMENTOS);
            result = sql.executeQuery();

            while (result.next()) {
                TipoDocumento tipoDocumento = new TipoDocumento();

                tipoDocumento.setId(result.getInt("id"));
                tipoDocumento.setTipoDocumento(result.getString("tipo_documento"));
                tipoDocumento.setSigla(result.getString("sigla"));
                tipoDocumento.setEstado(result.getInt("estado"));
                tipoDocumento.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());

                listaTipoDocumentos.add(tipoDocumento);
            }
            return listaTipoDocumentos;
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

}
