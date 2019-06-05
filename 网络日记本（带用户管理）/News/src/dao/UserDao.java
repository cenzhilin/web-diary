package dao;

import java.util.List;

import bean.NewsBean;
import bean.UserBean;

public interface UserDao {
public void add(UserBean bean);
public void upData(UserBean userBean);

public void delete(String[] s);

public List list();

public UserBean get(int id);


}
