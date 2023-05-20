package uz.sudev.metaclonebackend.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import uz.sudev.metaclonebackend.entity.Post;
import uz.sudev.metaclonebackend.payload.Message;
import uz.sudev.metaclonebackend.payload.PostDTO;

public interface PostService {
    ResponseEntity<Page<Post>> getPosts(int page, int size);

    ResponseEntity<?> getPost(Long id);

    ResponseEntity<Message> deletePost(Long id);

    ResponseEntity<Message> addPost(PostDTO postDTO);

    ResponseEntity<Message> editPost(Long id, PostDTO postDTO);
}
