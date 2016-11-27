package goncharenko.gvv.service;

import goncharenko.gvv.entity.Model;
import goncharenko.gvv.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Vitaliy on 26.11.2016.
 */
@Service
public class ModelRepositoryServiceImpl implements ModelRepositoryService {

    @Autowired
    private ModelRepository repository;

    @Override
    public void insertListModel() {
        Model model = null;
        for (int i = 0; i < 100; i++) {
            model = new Model();
            model.setName("Name_" + i);
            model.setInfo("Info_" + i);
            repository.save(model);
        }
    }

    @Override
    public void selectListModel() {
        Iterable<Model> modelList = repository.findAll();
    }

    @Override
    public void selectListModelUseQuery() {
        repository.getAllModel();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
