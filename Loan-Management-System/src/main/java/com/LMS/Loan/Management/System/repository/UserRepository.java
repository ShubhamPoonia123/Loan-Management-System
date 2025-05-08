package com.LMS.Loan.Management.System.repository;

import com.LMS.Loan.Management.System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository< User,Integer > {

    User findByUsername( String username);

    boolean existsByUsername ( String username );
}
