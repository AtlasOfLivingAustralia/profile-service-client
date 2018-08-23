package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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

    Map<String, ImageSettings> imageSettings;

    String primaryVideo;

    String primaryAudio;

    boolean showLinkedOpusAttributes;

    List<String> specimenIds;

    List<Authorship> authorship;

    List<Classification> classification;

    boolean manualClassification;

    List<Link> links;

    List<Link> bhlLinks;

    List<Bibliography> bibliography;

    List<Document> documents;

    List<Publication> publications;

    List<LocalImage> privateImages;

    List<LocalImage> stagedImages;

    List<Attachment> attachments;

    List<Attribute> attributes;

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

    ProfileSettings profileSettings;

}
