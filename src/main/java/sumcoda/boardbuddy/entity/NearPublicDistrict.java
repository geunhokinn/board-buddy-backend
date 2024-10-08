package sumcoda.boardbuddy.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class NearPublicDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 주변의 oo시, oo도
    @Column(nullable = false)
    private String sido;

    // 주변의 oo시, oo군, oo구
    @Column(nullable = false)
    private String sgg;

    // 주변의 oo읍, oo면, oo동
    @Column(nullable = false)
    private String emd;

    // 반경 정보
    @Column(nullable = false)
    private Integer radius;

    // 양방향 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "public_district_id")
    private PublicDistrict publicDistrict;

    @Builder
    public NearPublicDistrict(String sido, String sgg, String emd, Integer radius, PublicDistrict publicDistrict) {
        this.sido = sido;
        this.sgg = sgg;
        this.emd = emd;
        this.radius = radius;
        this.assignPublicDistrict(publicDistrict);
    }

    // 직접 빌더 패턴의 생성자를 활용하지 말고 해당 메서드를 활용하여 엔티티 생성
    public static NearPublicDistrict buildNearPublicDistrict(String sido, String sgg, String emd, Integer radius, PublicDistrict publicDistrict) {
        return NearPublicDistrict.builder()
                .sido(sido)
                .sgg(sgg)
                .emd(emd)
                .radius(radius)
                .publicDistrict(publicDistrict)
                .build();
    }

    // NearPublicDistrict N <-> 1 PublicDistrict
    // 양방향 연관관계 편의 메서드
    public void assignPublicDistrict(PublicDistrict publicDistrict) {
        if (this.publicDistrict != null) {
            this.publicDistrict.getNearPublicDistricts().remove(this);
        }
        this.publicDistrict = publicDistrict;

        if (!publicDistrict.getNearPublicDistricts().contains(this)) {
            publicDistrict.addNearPublicDistrict(this);
        }
    }
}
