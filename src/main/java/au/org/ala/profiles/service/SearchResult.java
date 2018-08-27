package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult {

    String uuid;
    String guid;
    String scientificName;
    MatchReason matchInfo;
    String nameAuthor;
    String fullName;
    String rank;
    String primaryImage;
    String opusShortName;
    String opusName;
    String opusId;
    String profileStatus;
    String archivedDate;
    List<String> classification;
    int score;
    List<SearchResultAttribute> description;
    List<SearchResultAttribute> otherNames;
}
