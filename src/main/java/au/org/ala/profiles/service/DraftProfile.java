package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DraftProfile {

    String uuid;
    String guid;
    String scientificName;
    String scientificNameLower;
    String nameAuthor;
    String fullName;
    Name matchedName;
    boolean manuallyMatchedName;
    String rank;
    String nslNameIdentifier;
    String nslNomenclatureIdentifier;
    String taxonomyTree;
    String primaryImage;
    String primaryVideo;
    String primaryAudio;
    boolean showLinkedOpusAttributes;
    String occurrenceQuery;
    boolean customMapConfig;
    String profileStatus;
    Map<String, ImageSettings> imageSettings;
    List<String> specimenIds;
    List<Authorship> authorship;
    List<Classification> classification;
    boolean manualClassification;
    List<Link> links;
    List<Link> bhlLinks;
    List<Attribute> attributes;
    List<Publication> publications;
    List<Bibliography> bibliography;
    List<Document> documents;
    List<LocalImage> stagedImages;
    List<LocalImage> privateImages;
    List<Attachment> attachments;
    String lastAttributeChange;

    Date dateCreated;
    Date draftDate;
    String createdBy;
    Date lastPublished;
    ProfileSettings profileSettings;

}
