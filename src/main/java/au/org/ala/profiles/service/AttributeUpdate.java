package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeUpdate {

    String title;
    String text;
    String source;

    String original;
    String attributeTo;
    String userDisplayName;
    String userId;

    boolean significantEdit;

    List<String> contributors = new ArrayList<>();
    List<String> editors = new ArrayList<>();
}
