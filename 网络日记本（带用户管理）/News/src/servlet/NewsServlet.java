package servlet;

import java.util.List;
import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.NewsBean;
import bean.UserBean;
import dao.NewsDao;
import dao.UserDao;
import daoimpl.NewsDaoImpl;
import daoimpl.UserDaoImpl;

@WebServlet("/servlet/NewsServlet")
public class NewsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if (action != null && action.equals("add")) {
			add(req, resp);
		} else if (action != null && action.equals("list")) {
			list(req, resp);
		} else if (action != null && action.equals("show")) {
			show(req, resp);
		} else if (action != null && action.equals("toEdit")) {
			toEdit(req, resp);
		} else if (action != null && action.equals("toEditU")) {
			toEditU(req, resp);
		}else if (action != null && action.equals("update")) {
			update(req, resp);
		}else if (action != null && action.equals("updateU")) {
			updateU(req, resp);
		} else if (action != null && action.equals("delete")) {
			delete(req, resp);
		}else if (action != null && action.equals("udelete")) {
			udelete(req, resp);
		}else {

		}
	}

	protected void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String title = req.getParameter("title");
		String text = req.getParameter("text");

		NewsDao ndao = new NewsDaoImpl();
		NewsBean nBean = new NewsBean();
		nBean.setText(text);
		nBean.setTitle(title);
		ndao.add(nBean);

		list(req, resp);

	}

	protected void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根

		NewsDao ndao = new NewsDaoImpl();
		List list = ndao.list();
		
		UserDao uDao = new UserDaoImpl();
		
		List uList =uDao.list();
		
		req.setAttribute("UL", uList);
		req.setAttribute("NL", list);
		
		
		
		req.setAttribute("isManager", UserServlet.manager);
		req.getRequestDispatcher("/newsList.jsp").forward(req, resp);
	}

	protected void show(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// TODO 自动生成的方法存根
		String id = req.getParameter("id");

		NewsDao ndao = new NewsDaoImpl();
		NewsBean nBean = ndao.get(new Integer(id).intValue());

		req.setAttribute("NewsBean", nBean);
		req.getRequestDispatcher("/newsShow.jsp").forward(req, resp);
	}

	protected void toEdit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// TODO 自动生成的方法存根
		String id = req.getParameter("id");

		NewsDao ndao = new NewsDaoImpl();
		NewsBean nBean = ndao.get(new Integer(id).intValue());

		req.setAttribute("NewsBean", nBean);
		req.getRequestDispatcher("/edit.jsp").forward(req, resp);
	}
	protected void toEditU(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// TODO 自动生成的方法存根
		String id = req.getParameter("id");

		UserDao uDao = new UserDaoImpl();
		UserBean uBean = uDao.get(new Integer(id).intValue());	
		
		req.setAttribute("UserBean",uBean);
		req.getRequestDispatcher("/uedit.jsp").forward(req, resp);
	}

	protected void update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String text = req.getParameter("text");

		NewsDao ndao = new NewsDaoImpl();
		NewsBean nBean = new NewsBean();
		
		nBean.setId(new Integer(id).intValue());
		nBean.setText(text);
		nBean.setTitle(title);
		
		ndao.upData(nBean);
		list(req, resp);

	}
	
	protected void updateU(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("password");

		System.out.println(id);
		System.out.println(name);
		System.out.println(password);
		
		UserDao uDao = new UserDaoImpl();
		UserBean uBean = new UserBean();
		uBean.setId(new Integer(id).intValue());
		uBean.setName(name);
		uBean.setPassword(password);
		
		uDao.upData(uBean);
		
		list(req, resp);

	}
	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String[] ids = req.getParameterValues("ids");
		
		NewsDao ndao = new NewsDaoImpl();
		
		ndao.delete(ids);

		list(req, resp);
	}
	protected void udelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String[] ids = req.getParameterValues("uids");
		
		UserDao uDao =new UserDaoImpl();
		
		uDao.delete(ids);

		list(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doGet(req, resp);
	}
}
