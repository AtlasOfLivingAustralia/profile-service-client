package au.org.ala.profiles.service;

public enum StorageExtension {
    PDF(".pdf"),
    ZIP(".zip");

    String extension;

    StorageExtension(String extension) {
        this.extension = extension;
    }
}
