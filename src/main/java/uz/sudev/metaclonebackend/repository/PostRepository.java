package uz.sudev.metaclonebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.sudev.metaclonebackend.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
