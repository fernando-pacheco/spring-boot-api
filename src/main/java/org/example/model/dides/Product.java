package org.example.model.dides;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class Product {

    private String id;
    private String action;
    private List<Attribute> attribute;
        public static class Attribute {
            private String key;
            private String value;
        }

}
