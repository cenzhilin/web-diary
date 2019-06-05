package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import bean.NewsBean;
import bean.UserBean;
import dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(UserBean bean) {
		String sql = "insert into users (name,password,ismanager) values(?,?,?) ";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, bean.getName());
			pStatement.setString(2, bean.getPassword());
			pStatement.setBoolean(3, bean.isIsmanager());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			dbUtil.close(connection);
		}

	}

	@Override
	public List list() {
		String sql = "select id,name,password,ismanager from users";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.getConnection();
		List list = new ArrayList();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				Boolean isManager = rs.getBoolean(4);

				UserBean userBean = new UserBean();
				userBean.setId(id);
				userBean.setName(name);
				userBean.setPassword(password);
				userBean.setIsmanager(isManager);
				list.add(userBean);
			}
			return list;

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			dbUtil.close(connection);
		}
		return null;
	}

	@Override
	public void upData(UserBean userBean) {
		String sql = "update users set name = ?,password =? where id=? ";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.getConnection();
		
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, userBean.getName());
			pStatement.setString(2, userBean.getPassword());
			pStatement.setInt(3, userBean.getId());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			dbUtil.close(connection);
		}
		
	}

	@Override
	public void delete(String[] s) {
		String sql = "delete from users where id=? ";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			if (s != null && s.length > 0) {
				for (int i = 0; i < s.length; i++) {
					int id = new Integer(s[i]).intValue();
					pStatement.setInt(1, id);
					pStatement.executeUpdate();
				}
			}

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			dbUtil.close(connection);
		}
		
	}

	@Override
	public UserBean get(int id) {
		String sql = "select id,name,password from users where id=?";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.getConnection();

		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString(2);
				String password = rs.getString(3);

				UserBean userBean = new UserBean();
				userBean.setId(id);
				userBean.setName(name);
				userBean.setPassword(password);
				
				return userBean;
			}

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			dbUtil.close(connection);
		}
		return null;
	}

}
