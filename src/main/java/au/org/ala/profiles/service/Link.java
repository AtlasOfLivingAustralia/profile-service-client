package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    String uuid;
    String url;

    String title;

    String description;
    String doi;
    String edition;
    String publisherName;
    String fullTitle;
}
