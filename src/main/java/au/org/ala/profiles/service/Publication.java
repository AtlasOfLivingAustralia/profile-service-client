package au.org.ala.profiles.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publication {

    String uuid;
    Date publicationDate;
    String title;
    Integer version;
    String doi;
    String userId;
    String authors;
    StorageExtension fileType;

}
