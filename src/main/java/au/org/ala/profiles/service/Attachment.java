package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {

    /*
        filename nullable: true
        url nullable: true
        title nullable: true
        description nullable: true
        contentType nullable: true
        rights nullable: true
        rightsHolder nullable: true
        creator nullable: true
        licence nullable: true
        createdDate nullable: true
     */

    String uuid;
    String filename;
    String url;
    String title;
    String description;
    String contentType;
    String rights;
    String rightsHolder;
    String licence;
    String creator;
    Date createdDate;

}
