/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Dao.TipoDocumentoDao;
import com.mycompany.domain.TipoDocumento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Francisco
 */
public class TipoDocumentoController {

    private TipoDocumentoDao tipoDocumentoDao;

    public TipoDocumentoController() {
        tipoDocumentoDao = new TipoDocumentoDao();
    }

    public List<TipoDocumento> getTipoDocumentos() throws SQLException {
        return tipoDocumentoDao.getTipoDocumentos();
    }
}
