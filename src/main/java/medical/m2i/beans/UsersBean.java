package medical.m2i.beans;

import java.io.Serializable;
import java.util.List;

import medical.m2i.dao.UserDao;
import medical.m2i.model.User;

public class UsersBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<User> listeUsers;
	private User user;

	public UsersBean() throws ClassNotFoundException {
		UserDao uDao = new UserDao();
		listeUsers = uDao.getUsers();
		user = new User();

		System.out.println("Je suis dans init bean user, taille de la liste = " + listeUsers.size());
	}

	/**
	 * @return the listeUsers
	 */
	public List<User> getListeUsers() {
		return listeUsers;
	}

	/**
	 * @param listeUsers the listeUsers to set
	 */
	public void setListeUsers(List<User> listeUsers) {
		this.listeUsers = listeUsers;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}

	public String saveUser() throws ClassNotFoundException {
		UserDao uDao = new UserDao();
		user.setRoles("ROLE_USER");
		user.setPassword(MD5("1234"));
		user.setName("Michel");
		user.setPhotouser("user1.png");
		uDao.registerUser(user);

		this.listeUsers = uDao.getUsers();

		System.out.println(user.getUsername());
		return "/done.xhtml?faces-redirect=true";
	}

}
