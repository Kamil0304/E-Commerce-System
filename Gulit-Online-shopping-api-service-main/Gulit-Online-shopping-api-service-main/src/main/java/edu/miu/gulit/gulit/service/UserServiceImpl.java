package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.ProductPhoto;
import edu.miu.gulit.gulit.domain.User;
import edu.miu.gulit.gulit.repository.UserRepository;
import edu.miu.gulit.gulit.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;
    @Override
    public User loadUserByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }
    @Override
    public User save(User user) {
        if(loadUserByUsername(user.getUsername())!=null) {
            System.out.println("User is already registered");
            return null;
        }
        return repository.save(user);
    }
    @Override
    public User update(User user, long id) {
        user.setId(id);
        return repository.save(user);
    }
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
    @Override
    public User findById(long id) {
        System.out.println("User is found");
        return repository.findById(id).orElse(null);
    }
    @Override
    public void deleteById(long id) {
        if(findById(id)!=null)
        {
            repository.deleteById(id);
        }
         else
        {
            System.out.println("User doesn't exist");
        }
    }
    @Override
    public List<ProductPhoto> findImagesById(long id) {
        return null;
    }

    @Override
    public User getCurrentUser(){
        return UserUtil.getCurrentUserLogin()
                .flatMap(username -> repository.findByUsername(username))
                .orElse(null);
    }
}
