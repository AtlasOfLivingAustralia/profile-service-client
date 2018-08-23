package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    String documentId;
    String name;
    String attribution;
    String licence;
    String type;
    String url;

    Date dateCreated;
    Date lastUpdated;
}
