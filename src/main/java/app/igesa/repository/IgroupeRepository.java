package app.igesa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import app.igesa.entity.Groupe;

import java.util.List;

public interface IgroupeRepository extends JpaRepository<Groupe, Long> {


    List<Groupe> findAllById(Long id);
}