package Sleepypoem.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Sleepypoem.demo.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    public abstract ArrayList<UserModel> findByEmail(String email);
}
