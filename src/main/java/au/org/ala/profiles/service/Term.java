package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Term {

    String uuid;
    String name;
    int order;
    boolean required;
    boolean summary;
    boolean containsName;

}
