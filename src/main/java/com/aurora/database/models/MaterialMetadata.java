package com.aurora.database.models;

public class MaterialMetadata {
    public String title;
    public ResourceTypeEnum resourceType;

    public MaterialMetadata(String title, ResourceTypeEnum resourceType) {
        this.title = title;
        this.resourceType = resourceType;
    }

    public String getTitle() {
        return title;
    }

    public ResourceTypeEnum getResourceType() {
        return resourceType;
    }

}
