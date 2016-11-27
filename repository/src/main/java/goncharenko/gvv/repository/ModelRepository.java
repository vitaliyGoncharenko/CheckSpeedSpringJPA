package goncharenko.gvv.repository;

import goncharenko.gvv.entity.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vitaliy on 26.11.2016.
 */
public interface ModelRepository extends CrudRepository<Model, Integer> {

    @Query("SELECT m FROM Model m")
    List<Model> getAllModel();
}
