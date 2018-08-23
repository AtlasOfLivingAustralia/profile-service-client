package au.org.ala.profiles.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {

    String uuid;
    Term title;
    String text;
    Attribute original;
    String source;

    Date dateCreated;
    Date lastUpdated;

}
