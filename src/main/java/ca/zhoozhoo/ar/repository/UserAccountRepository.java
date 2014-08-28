package ca.zhoozhoo.ar.repository;

import ca.zhoozhoo.ar.model.UserAccount;

public interface UserAccountRepository {

	public Integer save(UserAccount userAccount);

	public UserAccount findByUsername(String username);
}
