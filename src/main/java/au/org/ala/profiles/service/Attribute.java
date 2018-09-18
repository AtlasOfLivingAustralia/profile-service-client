package au.org.ala.profiles.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {

    /*
     */

    String uuid;
//    Term title = new Term();
    String title;
    Integer order;
    Boolean required;
    Boolean containsName;
    Boolean summary;
    String text;
    String source;
    String plainText;
    Attribute original;

    List<String> creators;
    List<String> editors;

    Date dateCreated;
    Date lastUpdated;

}
