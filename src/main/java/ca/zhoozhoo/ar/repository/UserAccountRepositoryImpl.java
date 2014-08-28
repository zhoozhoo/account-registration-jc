package ca.zhoozhoo.ar.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.zhoozhoo.ar.model.UserAccount;

@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public Integer save(UserAccount userAccount) {
		return (Integer) sessionFactory.getCurrentSession().save(userAccount);
	}

	@Transactional
	@Override
	public UserAccount findByUsername(String username) {
		return null;
	}
}
