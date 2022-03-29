package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.ProductPhoto;
import edu.miu.gulit.gulit.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User loadUserByUsername(String name);
    User save(User  user);
    User update(User user,long id);
    List<User> findAll();
    User findById(long id);
    void deleteById(long id);

    List<ProductPhoto> findImagesById(long id);

    User getCurrentUser();
}
