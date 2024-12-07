package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.User;

//crud: create, read, update, delete
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // day la function, kphai la bien'
    User save(User hoidanit); // == insert into user value()

    List<User> findByEmail(String email);
}
