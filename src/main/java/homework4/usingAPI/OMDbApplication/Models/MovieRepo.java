package homework4.usingAPI.OMDbApplication.Models;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MovieRepo extends CrudRepository<Movie, UUID> {
}
