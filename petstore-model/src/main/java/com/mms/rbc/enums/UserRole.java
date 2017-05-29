package com.mms.rbc.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * UserRole
 */
public enum UserRole {
	
	ANONYMOUS("ANONYMOUS", StorePrivilege.READ),
	ADMIN("ADMIN", StorePrivilege.CREATE, StorePrivilege.READ, StorePrivilege.UPDATE, StorePrivilege.DELETE),
	CUSTOMER("CUSTOMER", StorePrivilege.CREATE, StorePrivilege.READ, StorePrivilege.UPDATE);
	
	private String code;
	private Collection<StorePrivilege> privileges;

	UserRole(String code, StorePrivilege... privileges) {
		this.code = code;
		this.privileges = initPrivileges(privileges);
	}

	public String getCode() {
		return code;
	}

	public Collection<StorePrivilege> getPrivileges() {
		return privileges;
	}
	
	private static Collection<StorePrivilege> initPrivileges(StorePrivilege... privileges){
		Collection resultingPrivileges = new ArrayList<>(4);
		if(privileges!=null){
			resultingPrivileges.addAll(Arrays.asList(privileges));
		}
		return resultingPrivileges;
	}
}
