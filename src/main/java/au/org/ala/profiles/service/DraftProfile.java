package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
    List<ImageSettings> imageSettings = new ArrayList<>();
    List<String> specimenIds = new ArrayList<>();
    List<Authorship> authorship = new ArrayList<>();
    List<Classification> classification = new ArrayList<>();
    boolean manualClassification;
    List<Link> links = new ArrayList<>();
    List<Link> bhlLinks = new ArrayList<>();
    List<Attribute> attributes = new ArrayList<>();
    List<Publication> publications = new ArrayList<>();
    List<Bibliography> bibliography = new ArrayList<>();
    List<Document> documents = new ArrayList<>();
    List<LocalImage> stagedImages = new ArrayList<>();
    List<LocalImage> privateImages = new ArrayList<>();
    List<Attachment> attachments = new ArrayList<>();
    String lastAttributeChange;

    Date dateCreated;
    Date draftDate;
    String createdBy;
    Date lastPublished;
    ProfileSettings profileSettings = new ProfileSettings();

}
