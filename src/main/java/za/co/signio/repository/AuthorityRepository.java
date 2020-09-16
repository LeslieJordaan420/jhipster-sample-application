package za.co.signio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.signio.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
