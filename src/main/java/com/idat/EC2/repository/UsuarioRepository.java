package com.idat.EC2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.idat.EC2.model.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{ 

}
