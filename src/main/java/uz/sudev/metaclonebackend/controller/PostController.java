package uz.sudev.metaclonebackend.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.sudev.metaclonebackend.entity.Post;
import uz.sudev.metaclonebackend.payload.Message;
import uz.sudev.metaclonebackend.payload.PostDTO;
import uz.sudev.metaclonebackend.service.interfaces.PostService;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/posts")
public class PostController {
    final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<Page<Post>> getPosts(@RequestParam int page, @RequestParam int size) {
        return postService.getPosts(page, size);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Message> addPost(@RequestBody @Valid PostDTO postDTO) {
        return postService.addPost(postDTO);
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<Message> editPost(@PathVariable Long id,@RequestBody @Valid PostDTO postDTO) {
        return postService.editPost(id, postDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Message> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
