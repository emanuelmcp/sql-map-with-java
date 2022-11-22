package org.example.database.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Store {
    private final int idStore;
    private final String nameStore;
    private String phoneStore;
    private String emailStore;
    private String streetStore;
    private String cityStore;
    private String stateStore;
    private String zipCodeStore;
    @Builder
    public Store(int idStore, String nameStore) {
        this.idStore = idStore;
        this.nameStore = nameStore;
    }


}
