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

    String opusUuid;

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

    @Builder.Default List<ImageSettings> imageSettings = new ArrayList<>();

    String primaryVideo;

    String primaryAudio;

    boolean showLinkedOpusAttributes;

    @Builder.Default List<String> specimenIds = new ArrayList<>();

    @Builder.Default List<Authorship> authorship = new ArrayList<>();

    @Builder.Default List<Classification> classification = new ArrayList<>();

    boolean manualClassification;

    @Builder.Default List<Link> links = new ArrayList<>();

    @Builder.Default List<Link> bhlLinks = new ArrayList<>();

    @Builder.Default List<Bibliography> bibliography = new ArrayList<>();

    @Builder.Default List<Document> documents = new ArrayList<>();

    @Builder.Default List<Publication> publications = new ArrayList<>();

    @Builder.Default List<LocalImage> privateImages = new ArrayList<>();

    @Builder.Default List<LocalImage> stagedImages = new ArrayList<>();

    @Builder.Default List<Attachment> attachments = new ArrayList<>();

    @Builder.Default List<Attribute> attributes = new ArrayList<>();

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

    @Builder.Default ProfileSettings profileSettings = new ProfileSettings();

    String manuallyMatchedGuid;

}
