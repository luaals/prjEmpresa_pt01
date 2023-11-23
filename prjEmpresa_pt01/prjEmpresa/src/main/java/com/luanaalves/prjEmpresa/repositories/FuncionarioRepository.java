package com.luanaalves.prjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luanaalves.prjEmpresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
