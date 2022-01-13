package com.job.expectation.models;

public class ResponseTierDataModel {

    private Tier tier1;
    private Tier tier2;
    private Tier tier3;

    public ResponseTierDataModel() {
    }

    public ResponseTierDataModel(Tier tier1, Tier tier2, Tier tier3) {
        this.tier1 = tier1;
        this.tier2 = tier2;
        this.tier3 = tier3;
    }

    public Tier getTier1() {
        return tier1;
    }

    public void setTier1(Tier tier1) {
        this.tier1 = tier1;
    }

    public Tier getTier2() {
        return tier2;
    }

    public void setTier2(Tier tier2) {
        this.tier2 = tier2;
    }

    public Tier getTier3() {
        return tier3;
    }

    public void setTier3(Tier tier3) {
        this.tier3 = tier3;
    }

    @Override
    public String toString() {
        return "ResponseTierDataModel{" +
                "tier1=" + tier1 +
                ", tier2=" + tier2 +
                ", tier3=" + tier3 +
                '}';
    }
}
