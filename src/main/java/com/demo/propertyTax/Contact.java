package com.demo.propertyTax;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Contact {
    private String name;
    private List<String> phoneNumbers;
    private String image;
}
