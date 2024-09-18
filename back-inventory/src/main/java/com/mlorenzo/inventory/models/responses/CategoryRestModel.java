package com.mlorenzo.inventory.models.responses;

import lombok.Value;

@Value
public class CategoryRestModel {
	private Long id;
	private String name;
	private String description;
}
