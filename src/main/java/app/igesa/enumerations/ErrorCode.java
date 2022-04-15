package app.igesa.enumerations;

import lombok.Getter;

@Getter
public enum ErrorCode {
	
	GROUPE_NOT_FOUND(1000),
	ENTREPRISE_NOT_FOUND(2000),
	PLATEFORME_NOT_FOUND(3000),
	PLATEFORME_NOT_VALID(3001),
	COMPANYBUSSINESS_NOT_FOUND(4000),
	POST_NOT_FOUND(4001),
	META_NOT_FOUND(4002),
	CONFIGURATION_NOT_FOUND(4003),
	CATEGORY_NOT_FOUND(4004),
	FORMENTITY_NOT_FOUND(4005),
	TAGS_NOT_FOUND(4006),
	PAGES_NOT_FOUND(4007),
	PRODUCT_NOT_FOUND(4008),
	ROLE_NOT_FOUND(4009),
	ENTREPRISE_NOT_VALID(5000),
	PRODUCT_NOT_VALID(6001),
	ACCOUNT_NOT_VALID(6002),
	PAGES_NOT_VALID(6003),
	GROUPE_NOT_VALID(6004),
	META_NOT_VALID(6005),
	POST_NOT_VALID(6006),
	ROLE_NOT_VALID(6007),
	FORM_NOT_VALID(6008),
	CATEGORY_NOT_VALID(3007),
	TAGS_NOT_VALID(3008),
	CONFIG_NOT_VALID(3009),
	COMPANYBUSSNESS_NOT_VALID(6009),
	LANGUAGE_NOT_VALID(7000),
	LANGUAGE_NOT_FOUND(7001),
	messageSource(1001),

	//List exception technique
	CATEGORY_IMAGE_NOT_VALID(1002),
	POST_IMAGE_NOT_VALID(1003),
	LANGUAGE_IMAGE_NOT_VALID(1004),
	PRODUCT_IMAGE_NOT_VALID(1005),
	CONFIG_IMAGE_NOT_VALID(1006),
	OPERATION_NOT_VALID(1007),
	UNKHNOWN_CONTEXT(1008),
	PASSWORD_CHANGE_NOT_VALID(1009),
	COMPANY_ALREADY_IN_USE(10010);

	

	private int code ;
	ErrorCode( int code){
		this.code=code;
	}
}
