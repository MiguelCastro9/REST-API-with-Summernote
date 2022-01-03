package com.summernote.repository;

import com.summernote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
