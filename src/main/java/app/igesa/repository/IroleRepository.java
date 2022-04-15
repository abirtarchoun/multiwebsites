package app.igesa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.igesa.entity.Role;


@Repository
public interface IroleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(String name);
	
	boolean existsByName(String name);
	
}