package uz.sudev.metaclonebackend.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private String post;
    private String name;
    private String email;
    private String file;
    private String profilePic;
    private String timeStamp;
    private String image;
}
