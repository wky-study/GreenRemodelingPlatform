package com.team.green.estimate.service;

import org.springframework.stereotype.Service;

import com.team.green.estimate.util.BuildingAPIClient;

@Service
public class BuildingInfoService {

    private final BuildingAPIClient buildingAPIClient;

    public BuildingInfoService(BuildingAPIClient buildingAPIClient) {
        this.buildingAPIClient = buildingAPIClient;
    }

    public String getBuildingArea(String sigunguCd, String bjdongCd, String bun, String ji, String dongNm, String hoNm) {
        try {
            return buildingAPIClient.getBuildingAreaFromAPI(sigunguCd, bjdongCd, bun, ji, dongNm, hoNm);
        } catch (Exception e) {
            e.printStackTrace();
            return "알 수 없음"; // 오류 발생 시 기본값
        }
    }
}
