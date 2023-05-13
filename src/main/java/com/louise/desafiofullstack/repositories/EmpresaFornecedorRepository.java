package com.louise.desafiofullstack.repositories;

import com.louise.desafiofullstack.domain.EmpresaFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaFornecedorRepository extends JpaRepository<EmpresaFornecedor, Integer> {
}
