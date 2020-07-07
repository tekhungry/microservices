package com.tekhungry.retail.inventroy.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
//@AllArgsConstructor
public class Inventory {
    private String category;
    private String section;
    private String product;
    private Number price;

    public Inventory(String category, String section, String product, Number price) {
        this.category = category;
        this.section = section;
        this.product = product;
        this.price = price;
    }
}
