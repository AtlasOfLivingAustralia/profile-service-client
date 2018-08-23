package au.org.ala.profiles.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpusLayoutConfig {

    String explanatoryText;

    List<Image> images;

    Integer duration;

    String updatesSection;

    String helpTextSearch;

    String helpTextIdentify;

    String helpTextFilter;

    String helpTextBrowse;

    String helpTextDocuments;

    String bannerOverlayText;
}
