package sumcoda.boardbuddy.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PublicDistrictResponse {

    @Getter
    @NoArgsConstructor
    public static class InfoDTO {

        private String sido;
        private String sgg;
        private String emd;
        private Double longitude;
        private Double latitude;

        @Builder
        public InfoDTO(String sido, String sgg, String emd, Double longitude, Double latitude) {
            this.sido = sido;
            this.sgg = sgg;
            this.emd = emd;
            this.longitude = longitude;
            this.latitude = latitude;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class InfoWithIdDTO {

        private Long id;
        private String sido;
        private String sgg;
        private String emd;
        private Double longitude;
        private Double latitude;

        @Builder
        public InfoWithIdDTO(Long id, String sido, String sgg, String emd, Double longitude, Double latitude) {
            this.id = id;
            this.sido = sido;
            this.sgg = sgg;
            this.emd = emd;
            this.longitude = longitude;
            this.latitude = latitude;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class LocationDTO {

        private String sido;
        private String sgg;
        private String emd;

        @Builder
        public LocationDTO(String sido, String sgg, String emd) {
            this.sido = sido;
            this.sgg = sgg;
            this.emd = emd;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class IdDTO {

        private Long id;

        @Builder
        public IdDTO(Long id) {
            this.id = id;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class CoordinateDTO {
        private Double longitude;
        private Double latitude;

        @Builder
        public CoordinateDTO(Double longitude, Double latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }
    }
}
