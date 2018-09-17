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

    String uuid;
    Term title = new Term();
    String text;
    Attribute original;
    String source;

    List<Contributor> creators = new ArrayList<>();
    List<Contributor> editors = new ArrayList<>();

    Date dateCreated;
    Date lastUpdated;

}
