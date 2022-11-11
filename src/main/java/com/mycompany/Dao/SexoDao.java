/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dao;

import com.mycompany.Utils.ConnectionUtil;
import com.mycompany.domain.Sexo;
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
public class SexoDao {

    private static final String GET_SEXOS = "SELECT * FROM sexos";

    public List<Sexo> getSexos() throws SQLException {
        Connection connect = null;
        PreparedStatement sql = null;
        ResultSet result = null;

        List<Sexo> listaSexos = new ArrayList<>();

        try {

            connect = ConnectionUtil.getConnection();
            sql = connect.prepareStatement(GET_SEXOS);
            result = sql.executeQuery();

            while (result.next()) {
                Sexo sexo = new Sexo();

                sexo.setSexoId(result.getInt("id"));
                sexo.setSexo(result.getString("sexo"));
                sexo.setSigla(result.getString("sigla"));
                sexo.setEstado(result.getInt("estado"));
                sexo.setFechaCreacion(result.getDate("fecha_creacion").toLocalDate());

                listaSexos.add(sexo);
            }
            return listaSexos;
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
