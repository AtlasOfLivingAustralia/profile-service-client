package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Opus {

    /*

        masterListUid nullable: true
        profileLayoutConfig nullable: true
        mapConfig nullable: true
        dataResourceConfig nullable: true
        featureListSectionName nullable: true

     */

    String uuid;

    String shortName;

    String title;

    String description;

    String dataResourceUid;

    @Builder.Default BrandingConfig brandingConfig = new BrandingConfig();

    @Builder.Default MapConfig mapConfig = new MapConfig();

    @Builder.Default OpusLayoutConfig opusLayoutConfig = new OpusLayoutConfig();

    @Builder.Default Theme theme = new Theme();

    @Builder.Default HelpLink help = new HelpLink();

    String attributeVocabUuid;

    String authorshipVocabUuid;

    Boolean enablePhyloUpload;

    Boolean enableOccurrenceUpload;

    Boolean enableTaxaUpload;

    Boolean enableKeyUpload;

    Boolean showLinkedOpusAttributes;

    Boolean allowCopyFromLinkedOpus;

    Boolean allowFineGrainedAttribution;

    boolean privateCollection;

    String keybaseProjectId;

    String keybaseKeyId;

    String aboutHtml;

    String citationHtml;

    String citationProfile;

    String copyrightText;

    String footerText;

    String email;

    String facebook;

    String twitter;

    boolean autoApproveShareRequests;

    boolean keepImagesPrivate;

    boolean usePrivateRecordData;

    ImageOption approvedImageOption;

    String accessToken;

    boolean autoDraftProfiles;

    Date dateCreated;

    Date lastUpdated;

}
