/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Dao.EstadoCivilDao;
import com.mycompany.domain.EstadoCivil;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Francisco
 */
public class EstadoCivilController {

    private EstadoCivilDao estadoCivilDao;

    public EstadoCivilController() {
        estadoCivilDao = new EstadoCivilDao();
    }

    public List<EstadoCivil> getEstadosCiviles() throws SQLException {
        return estadoCivilDao.getEstadosCiviles();
    }
}
