package com.upt.lp.repository;
import com.upt.lp.Recursos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursosRepository extends JpaRepository<Recursos, Integer> {
	List<Recursos> findByTipo_IdTipo(int idTipo);
    List<Recursos> findByLocalizacao_IdLocalizacao(int idLocalizacao);
    List<Recursos> findByNome(String nome);


	
}
