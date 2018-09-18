package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    // Preserve id so that they can be matched for creating opera
    Long id;

    String uuid;

    String colour;

    String name;

    String abbrev;

}
