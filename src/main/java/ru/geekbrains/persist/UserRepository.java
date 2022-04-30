package ru.geekbrains.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    // То, что было на уроке это баг в Hibernate, который пока не исправлен
    // Временное решение - указать аннотацию @Param для всех параметров
    // https://github.com/spring-projects/spring-data-jpa/issues/2472
    @Query("select u " +
            " from User u " +
            "where (u.username like concat('%', :username, '%') or :username is null) and " +
            "      (u.email like concat('%', :email, '%') or :email is null)")
    List<User> findUserByFilter(@Param("username") String username,
                                @Param("email") String email);

}
