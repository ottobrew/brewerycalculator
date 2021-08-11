package Model;

import Controller.CalcController;

public class BeerCalculator {

    private int totalBarrels;
    private int totalGals;
    private int availableGals;
    private int maxHalfs;
    private int maxSixtels;
    private int maxCans;
    private int userHalfs;
    private int userSixtels;
    private int computeCans;
    private double currentHalfs;
    private double currentSixtels;
    private double currentCans;

    public BeerCalculator(int enteredBbls) {
        totalBarrels = enteredBbls;
        maxHalfs = totalBarrels * 2;
        maxSixtels = totalBarrels * 6;
        totalGals = totalBarrels * 31;
        maxCans = totalGals * 128 / 12;
        userHalfs = 0;
        userSixtels = 0;
        computeCans = maxCans;
    }

    public void toGals() {
        currentHalfs = userHalfs * 15.5;
        currentSixtels = userSixtels * 5.16;
    }

    public void updateAvailableGals() {

        availableGals = (int)(totalGals - currentHalfs - currentSixtels);

        if (availableGals < 0) {
            // difference in gals subtracted from sixtels

            int diffInGals = -availableGals;
            double capSixtels;

            capSixtels = currentSixtels - diffInGals;
            setUserSixtels((int)(capSixtels / 5.16));
            availableGals = (int)(totalGals - currentHalfs - capSixtels);
            }

        if (availableGals > 0) {
            computeCans = availableGals * 128 / 12;
        }
        else {
            computeCans = 0;
        }
    }

    public int getComputeCans() {
        return computeCans;
    }

    public void setComputeCans(int computeCans) {
        this.computeCans = computeCans;
    }

    public int getTotalBarrels() {
        return totalBarrels;
    }

    public void setTotalBarrels(int totalBarrels) {
        this.totalBarrels = totalBarrels;
    }

    public int getAvailableGals() {
        return availableGals;
    }

    public void setAvailableGals(int availableGals) {
        this.availableGals = availableGals;
    }

    public int getMaxHalfs() {
        return maxHalfs;
    }

    public void setMaxHalfs(int maxHalfs) {
        this.maxHalfs = maxHalfs;
    }

    public int getMaxSixtels() {
        return maxSixtels;
    }

    public void setMaxSixtels(int maxSixtels) {
        this.maxSixtels = maxSixtels;
    }

    public int getMaxCans() {
        return maxCans;
    }

    public void setMaxCans(int maxCans) {
        this.maxCans = maxCans;
    }

    public int getUserHalfs() {
        return userHalfs;
    }

    public void setUserHalfs(int userHalfs) {
        this.userHalfs = userHalfs;
    }

    public int getUserSixtels() {
        return userSixtels;
    }

    public void setUserSixtels(int userSixtels) {
        this.userSixtels = userSixtels;
    }

    public double getCurrentHalfs() {
        return currentHalfs;
    }

    public void setCurrentHalfs(double currentHalfs) {
        this.currentHalfs = currentHalfs;
    }

    public double getCurrentSixtels() {
        return currentSixtels;
    }

    public void setCurrentSixtels(double currentSixtels) {
        this.currentSixtels = currentSixtels;
    }

    public double getCurrentCans() {
        return currentCans;
    }

    public void setCurrentCans(double currentCans) {
        this.currentCans = currentCans;
    }
}
