package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository <User, Long> {

    @Override
    public List<User> findAll();
    @Override
    public Optional<User>  findById(Long id);

    public Optional<User> findByUsername(String username);
    @Override
    public User save(User user);
    @Override
    public  void deleteById(Long id);

}
