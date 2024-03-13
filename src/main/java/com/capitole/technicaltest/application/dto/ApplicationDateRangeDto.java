package com.capitole.technicaltest.application.dto;

import java.util.Date;

import lombok.Getter;

@Getter
public class ApplicationDateRangeDto {
	private final String type;
	private final Date value;
	
	private ApplicationDateRangeDto(Builder builder) {
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
        
        public ApplicationDateRangeDto build() {
            return new ApplicationDateRangeDto(this);
        }
	}
}

