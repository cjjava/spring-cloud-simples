package cloud.simple.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import cloud.simple.domain.User;


public interface UserRepository extends JpaRepository<User, String> {

}
