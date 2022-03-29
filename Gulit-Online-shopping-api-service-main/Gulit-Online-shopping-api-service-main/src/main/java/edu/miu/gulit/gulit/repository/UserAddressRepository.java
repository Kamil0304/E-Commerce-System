package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.UserAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserAddressRepository extends CrudRepository<UserAddress, Long> {
    @Override
    List<UserAddress> findAll();

    @Override
    public Optional<UserAddress> findById(Long id);
}
