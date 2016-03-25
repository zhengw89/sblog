package com.sblog.web.viewmodel;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.sblog.web.validator.FieldMatch;

@FieldMatch.List({
    @FieldMatch(first = "newPassword", second = "confirmPassword", message = "The password fields must match"),
})
public class UpdatePasswordModel {

	@NotNull
	@NotEmpty
	private String newPassword;
	
	@NotNull
	@NotEmpty
	private String confirmPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
