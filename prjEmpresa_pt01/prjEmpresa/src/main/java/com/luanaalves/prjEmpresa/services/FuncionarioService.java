package com.luanaalves.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.luanaalves.prjEmpresa.entities.Funcionario;
import com.luanaalves.prjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionariorepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionariorepository) {
		this.funcionariorepository = funcionariorepository;
}
	
	public Funcionario getFuncionarioById(Long funcodigo) {
		return funcionariorepository.findById(funcodigo).orElse(null);
	}
	
	public List<Funcionario> getAllFuncionario(){
		return funcionariorepository.findAll();
	}
	
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionariorepository.save(funcionario);
	}
		
	public void deletefuncionario(Long funcodigo) {
		funcionariorepository.deleteById(funcodigo);
	}
	public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
        Optional<Funcionario> funcionarioOptional = funcionariorepository.findById(funcodigo);
        if (funcionarioOptional.isPresent()) {
        	Funcionario funcionarioExistente = funcionarioOptional.get();
           	funcionarioExistente.setFunnome(novoFuncionario.getFunnome()); 
           	funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento()); 
           	funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario()); 
           	return funcionariorepository.save(funcionarioExistente); 
        } else {
            return null; 
        }
	}
}