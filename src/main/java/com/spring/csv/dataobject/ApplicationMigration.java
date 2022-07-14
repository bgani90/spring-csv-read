package com.spring.csv.dataobject;

import java.math.BigDecimal;

public class ApplicationMigration {

    private BigDecimal applicationId;
    private String applicationName;
    private String migrated;

    public BigDecimal getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(BigDecimal applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getMigrated() {
        return migrated;
    }

    public void setMigrated(String migrated) {
        this.migrated = migrated;
    }

    @Override
    public String toString() {
        return "ApplicationMigration{" +
                "applicationid=" + applicationId +
                ", applicationName='" + applicationName + '\'' +
                ", migrated=" + migrated +
                '}';
    }
}
