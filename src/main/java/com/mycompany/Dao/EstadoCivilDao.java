/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dao;

import com.mycompany.Utils.ConnectionUtil;
import com.mycompany.domain.EstadoCivil;
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
public class EstadoCivilDao {

    private static final String GET_SEXOS = "SELECT * FROM estados_civiles";

    public List<EstadoCivil> getEstadosCiviles() throws SQLException {
        Connection connect = null;
        PreparedStatement sql = null;
        ResultSet result = null;

        List<EstadoCivil> listaEstadoCivil = new ArrayList<>();

        try {

            connect = ConnectionUtil.getConnection();
            sql = connect.prepareStatement(GET_SEXOS);
            result = sql.executeQuery();

            while (result.next()) {
                EstadoCivil estadoCivil = new EstadoCivil();

                estadoCivil.setId(result.getInt("id"));
                estadoCivil.setEstadoCivil(result.getString("estado_civil"));
                estadoCivil.setEstado(result.getInt("estado"));
                estadoCivil.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());

                listaEstadoCivil.add(estadoCivil);
            }
            return listaEstadoCivil;
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
