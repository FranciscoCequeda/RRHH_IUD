/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Dao.FuncionarioDao;
import com.mycompany.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Francisco
 */
public class FuncionarioController {

    private FuncionarioDao funcionarioDao;

    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();
    }

    public List<Funcionario> getFuncionarios() throws SQLException {
        return funcionarioDao.getFuncionarios();
    }

    public Funcionario getFuncionario(int id_funcionario) throws SQLException {
        return funcionarioDao.getFuncionario(id_funcionario);
    }

    public void createFuncionario(Funcionario funcionario) throws SQLException {
        funcionarioDao.createFuncionario(funcionario);
    }

    public void deleteFuncionario(int id_funcionario) throws SQLException {
        funcionarioDao.deleteFuncionario(id_funcionario);
    }

    public void updateFuncionario(int idFuncionario, Funcionario funcionario) throws SQLException {
        funcionarioDao.updateFuncionario(idFuncionario, funcionario);
    }

}
