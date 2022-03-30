package Market.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Market.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    @Modifying
    @Query(value = "insert into TAIKHOAN (username, password, id, role) values (:username, :password, :id, :role)", nativeQuery = true)
    void insertUser(@Param("username") String username, @Param("password") String password, @Param("id") String id,
            @Param("role") String role);

    @Override
    default <S extends User> S save(S entity) {
        insertUser(entity.getUsername(), entity.getPassword(), entity.getId(), entity.getRole());
        return entity;
    }

    @Transactional
    @Modifying
    @Query(value = "update TAIKHOAN set id = :id where username = :username", nativeQuery = true)
    void updateIdUser(@Param("username") String username, @Param("id") String id);

}