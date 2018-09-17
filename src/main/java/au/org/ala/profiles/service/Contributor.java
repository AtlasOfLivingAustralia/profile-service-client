package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contributor {

    String uuid;
    String userId;
    String name;
    String dataResourceUid;

    Date dateCreated;
    Date lastUpdated;
}
