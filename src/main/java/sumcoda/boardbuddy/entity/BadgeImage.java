package sumcoda.boardbuddy.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BadgeImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 원본 파일명
    @Column(nullable = false)
    private String originalFilename;

    // 이미지에 대한 URL 정보를 DB에서 찾을때 활용
    @Column(nullable = false)
    private String badgeImageS3SavedURL;

    // 뱃지 발급 연월 정보
    @Column(nullable = false)
    private String badgeYearMonth;

    // 연관관계 주인
    // 양방향 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public BadgeImage(String originalFilename, String badgeImageS3SavedURL, String badgeYearMonth, Member member) {
        this.originalFilename = originalFilename;
        this.badgeImageS3SavedURL = badgeImageS3SavedURL;
        this.badgeYearMonth = badgeYearMonth;
        this.assignMember(member);
    }

    // 직접 빌더 패턴의 생성자를 활용하지 않고 해당 메서드를 활용하여 엔티티 생성
    public static BadgeImage buildBadgeImage(String originalFilename, String badgeImageS3SavedURL, String badgeYearMonth, Member member) {
        return BadgeImage.builder()
                .originalFilename(originalFilename)
                .badgeImageS3SavedURL(badgeImageS3SavedURL)
                .badgeYearMonth(badgeYearMonth)
                .member(member)
                .build();
    }

    // BadgeImage N <-> 1 Member
    // 양방향 연관관계 편의 메서드
    public void assignMember(Member member) {
        if (this.member != null) {
            this.member.getBadgeImages().remove(this);
        }
        this.member = member;

        if (!member.getBadgeImages().contains(this)) {
            member.addBadgeImage(this);
        }
    }
}
