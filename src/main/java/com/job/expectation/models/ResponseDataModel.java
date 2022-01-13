package com.job.expectation.models;

public class ResponseDataModel {
    private TierOne tierOne;

    private TierTwo tierTwo;

    private TierThree tierThree;

    private Tier tier;

    public ResponseDataModel() {
    }

    public ResponseDataModel(TierOne tierOne, TierTwo tierTwo, TierThree tierThree, Tier tier) {
        this.tierOne = tierOne;
        this.tierTwo = tierTwo;
        this.tierThree = tierThree;
        this.tier = tier;
    }

    public TierOne getTierOne() {
        return tierOne;
    }

    public void setTierOne(TierOne tierOne) {
        this.tierOne = tierOne;
    }

    public TierTwo getTierTwo() {
        return tierTwo;
    }

    public void setTierTwo(TierTwo tierTwo) {
        this.tierTwo = tierTwo;
    }

    public TierThree getTierThree() {
        return tierThree;
    }

    public void setTierThree(TierThree tierThree) {
        this.tierThree = tierThree;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "ResponseDataModel{" +
                "tierOne=" + tierOne +
                ", tierTwo=" + tierTwo +
                ", tierThree=" + tierThree +
                ", tier=" + tier +
                '}';
    }
}
