package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Opus {

    /*

        masterListUid nullable: true

        featureListSectionName nullable: true

        //marshalled
        masterListUid              : opus.masterListUid,

        supportingOpuses           : marshalSupportingOpuses(opus.supportingOpuses?.findAll {
            it.requestStatus == ShareRequestStatus.ACCEPTED
        }),
        requestedSupportingOpuses  : marshalSupportingOpuses(opus.supportingOpuses?.findAll {
            it.requestStatus != ShareRequestStatus.ACCEPTED
        }),
        sharingDataWith            : marshalSupportingOpuses(opus.sharingDataWith),
        florulaListId              : opus.florulaListId ?: '',

     */

    String uuid;

    String shortName;

    String title;

    String description;

    String dataResourceUid;

    @Builder.Default DataResourceConfig dataResourceConfig = new DataResourceConfig();

    @Builder.Default ImageOption approvedImageOption = ImageOption.INCLUDE;

    @Builder.Default List<String> approvedLists = new ArrayList<>();

    @Builder.Default List<String> featureLists = new ArrayList<>();

    String featureListSectionName;

    @Builder.Default BrandingConfig brandingConfig = new BrandingConfig();

    @Builder.Default ProfileLayoutConfig profileLayoutConfig = new ProfileLayoutConfig();

    @Builder.Default OpusLayoutConfig opusLayoutConfig = new OpusLayoutConfig();

    @Builder.Default Theme theme = new Theme();

    @Builder.Default HelpLink help = new HelpLink();

    String keybaseProjectId;

    String keybaseKeyId;

    String attributeVocabUuid;

    String authorshipVocabUuid;

    boolean autoDraftProfiles;

    String glossaryUuid;

    @Builder.Default List<Attachment> attachments = new ArrayList<>();

    Boolean enablePhyloUpload;

    Boolean enableOccurrenceUpload;

    Boolean enableTaxaUpload;

    Boolean enableKeyUpload;

    boolean privateCollection;

    boolean keepImagesPrivate;

    boolean usePrivateRecordData;

    @Builder.Default MapConfig mapConfig = new MapConfig();

    boolean autoApproveShareRequests;

    Boolean allowCopyFromLinkedOpus;

    Boolean showLinkedOpusAttributes;

    Boolean allowFineGrainedAttribution;

    @Builder.Default List<Authority> authorities = new ArrayList<>();

    String copyrightText;

    String footerText;

    @Builder.Default Contact contact = new Contact();

    Boolean hasAboutPage;

    Integer profileCount;

    String aboutHtml;

    String citationHtml;

    String citationProfile;

    String accessToken;

    @Builder.Default List<Tag> tags = new ArrayList<>();

    @Builder.Default List<String> additionalStatuses = new ArrayList<>();

    Date dateCreated;

    Date lastUpdated;

}
