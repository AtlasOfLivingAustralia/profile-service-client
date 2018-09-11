package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Profile {

    final static String STATUS_PARTIAL = "Partial";

    String uuid;

    String guid;

    String scientificName;

    String nameAuthor;

    String fullName;

    String rank;

    String nslNameIdentifier;

    String nslNomenclatureIdentifier;

    String nslProtologue;

    String occurrenceQuery;

    boolean customMapConfig;

    String profileStatus;

    Integer emptyProfileVersion;

    boolean privateMode;

    Name matchedName;

    boolean manuallyMatchedName;

    String taxonomyTree;

    String primaryImage;

    Map<String, ImageSettings> imageSettings = new HashMap<>();

    String primaryVideo;

    String primaryAudio;

    boolean showLinkedOpusAttributes;

    List<String> specimenIds = new ArrayList<>();

    List<Authorship> authorship = new ArrayList<>();

    List<Classification> classification = new ArrayList<>();

    boolean manualClassification;

    List<Link> links = new ArrayList<>();

    List<Link> bhlLinks = new ArrayList<>();

    List<Bibliography> bibliography = new ArrayList<>();

    List<Document> documents = new ArrayList<>();

    List<Publication> publications = new ArrayList<>();

    List<LocalImage> privateImages = new ArrayList<>();

    List<LocalImage> stagedImages = new ArrayList<>();

    List<Attachment> attachments = new ArrayList<>();

    List<Attribute> attributes = new ArrayList<>();

    String lastAttributeChange;

    Date dateCreated;

    String createdBy;

    Date lastUpdated;

    String lastUpdatedBy;

    Date lastPublished;

    DraftProfile draft;

    String archiveComment;

    Date archivedDate;

    String archivedBy;

    String archivedWithName;

    String scientificNameLower;

    ProfileSettings profileSettings = new ProfileSettings();

}
