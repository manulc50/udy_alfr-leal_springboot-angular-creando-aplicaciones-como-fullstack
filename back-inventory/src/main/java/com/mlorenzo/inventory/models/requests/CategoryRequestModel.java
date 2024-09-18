package com.mlorenzo.inventory.models.requests;

import lombok.Value;

@Value
public class CategoryRequestModel {
	private String name;
	private String description;
}
