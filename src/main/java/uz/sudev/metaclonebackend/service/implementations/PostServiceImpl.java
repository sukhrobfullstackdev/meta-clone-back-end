package uz.sudev.metaclonebackend.service.implementations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.sudev.metaclonebackend.entity.Post;
import uz.sudev.metaclonebackend.payload.Message;
import uz.sudev.metaclonebackend.payload.PostDTO;
import uz.sudev.metaclonebackend.repository.PostRepository;
import uz.sudev.metaclonebackend.service.interfaces.PostService;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public ResponseEntity<Page<Post>> getPosts(int page, int size) {
        return ResponseEntity.ok(postRepository.findAll(PageRequest.of(page, size)));
    }

    @Override
    public ResponseEntity<?> getPost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            return ResponseEntity.ok(optionalPost.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(false, "Unfortunately, the post has not been found!"));
        }
    }

    @Override
    public ResponseEntity<Message> addPost(PostDTO postDTO) {
        postRepository.save(new Post(postDTO.getPost(), postDTO.getName(), postDTO.getEmail(), postDTO.getImage(), postDTO.getProfilePic(), postDTO.getTimeStamp()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new Message(true, "The post has been successfully added!"));
    }

    @Override
    public ResponseEntity<Message> editPost(Long id, PostDTO postDTO) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setPost(postDTO.getPost());
            post.setEmail(postDTO.getEmail());
            post.setImage(postDTO.getImage());
            post.setName(postDTO.getName());
            post.setProfilePic(postDTO.getProfilePic());
            post.setTimeStamp(postDTO.getTimeStamp());
            postRepository.save(post);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Message(true, "The post has been successfully edited!"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(false, "Unfortunately, the post has not been found!"));
        }
    }

    @Override
    public ResponseEntity<Message> deletePost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            postRepository.delete(optionalPost.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Message(true, "The post has been successfully deleted!"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(false, "Unfortunately, the post has not been found!"));
        }
    }
}
