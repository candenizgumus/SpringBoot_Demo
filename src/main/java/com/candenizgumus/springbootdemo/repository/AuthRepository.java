package com.candenizgumus.springbootdemo.repository;

import com.candenizgumus.springbootdemo.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth,Long>
{
    Optional<Auth> findOptionalByUsernameAndPassword(String username, String password);

    /*
    find: Genellikle select sorgularının tamamı için find kullanılır.
    by: işlem yapacağınız bileşen adından önce yazmak gerekli.
    [ad] : Kullanılan repository içindeki entity içindeki arama yapılacak field adı yazılır.
    Burada field adının ilk karakteri büyük harf olacak şekilde yazılmalıdır.
     */
    Auth findByUsername(String username);
}
