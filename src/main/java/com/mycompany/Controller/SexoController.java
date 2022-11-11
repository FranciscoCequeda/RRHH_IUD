/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Dao.SexoDao;
import com.mycompany.domain.Sexo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Francisco
 */
public class SexoController {
    private SexoDao sexoDao;

    public SexoController() {
        sexoDao = new SexoDao();
    }

    public List<Sexo> getSexos() throws SQLException {
        return sexoDao.getSexos();
    }
}
