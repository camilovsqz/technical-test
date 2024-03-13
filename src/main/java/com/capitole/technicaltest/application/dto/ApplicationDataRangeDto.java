package com.capitole.technicaltest.application.dto;

import java.util.Date;

import lombok.Getter;

@Getter
public class ApplicationDataRangeDto {
	private final String type;
	private final Date value;
	
	private ApplicationDataRangeDto(Builder builder) {
        this.type = builder.type;
        this.value = builder.value;
    }
	
	public static class Builder {
        private final String type;
        private final Date value;
    
        public Builder(String type, Date value) {
            this.type = type;
            this.value = value;
        }
        
        public ApplicationDataRangeDto build() {
            return new ApplicationDataRangeDto(this);
        }
	}
}

