package uz.sudev.metaclonebackend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String post;
    private String name;
    private String email;
    @Lob
    private String image;
    private String profilePic;
    private String timeStamp;

    public Post(String post, String name, String email, String image, String profilePic, String timeStamp) {
        this.post = post;
        this.name = name;
        this.email = email;
        this.image = image;
        this.profilePic = profilePic;
        this.timeStamp = timeStamp;
    }
}
