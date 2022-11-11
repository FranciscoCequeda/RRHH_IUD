package com.mycompany.rrhh_iud;

import com.mycompany.Controller.FuncionarioController;
import com.mycompany.domain.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Francisco
 */
public class Rrh_iud {

    public static void getFuncionarios(FuncionarioController funcionarioController) {
        try {
            List<Funcionario> listFuncionarios = funcionarioController.getFuncionarios();
            if (listFuncionarios.isEmpty()) {
                System.out.println("Lista Vacia!!!");
            } else {
                listFuncionarios.forEach(funcionario -> {
                    System.out.println(funcionario.getTipoDocumento().getTipoDocumento());
                    System.out.println(funcionario.getNumeroIdentificacion());
                    System.out.println(funcionario.getNombre1());
                    System.out.println(funcionario.getNombre2());
                    System.out.println(funcionario.getApellido1());
                    System.out.println(funcionario.getApellido2());
                    System.out.println(funcionario.getFechaNacimiento());
                    System.out.println(funcionario.getEstadoCivil().getEstadoCivil());
                    System.out.println(funcionario.getSexo().getSexo());
                    System.out.println(funcionario.getDireccion());
                    System.out.println(funcionario.getCelular());
                    System.out.println(funcionario.getFechaCreacion());
                    System.out.println("\n");

                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void getFuncionario(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite el id del Funcionario: ");
            int id = sc.nextInt();
            System.out.println("id: " + id);
            System.out.println("-------------------------- ");

            Funcionario funcionario = funcionarioController.getFuncionario(id);

            if (funcionario != null) {
                System.out.println("Funcionario seleccionado:\n" + funcionario);
                System.out.println("---------------");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException n) {
            System.out.println("No existe el ID ingresado!!!");
        }
    }

    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        getFuncionarios(funcionarioController);
        getFuncionario(funcionarioController);
    }
}
