package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalImage {

    String imageId;
    String originalFileName;
    String title;
    String description;
    String rightsHolder;
    String rights;
    String licence;
    String creator;
    String contentType;
    String created;
}
