package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "billiards", schema = "public")
public class Billiards extends GeneralEntertainment {

    @Column(name = "type")
    private BilliardsType billiardsType;

    @Column(name = "table_count")
    private byte tableCount;
}