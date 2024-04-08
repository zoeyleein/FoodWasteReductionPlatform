package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*") // 對所有請求進行過濾
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 獲取用戶的 Session
        HttpSession session = request.getSession(false);

        // 檢查用戶是否已登入
        boolean loggedIn = session != null && session.getAttribute("userId") != null;

        // 檢查用戶是否試圖訪問受限頁面，如果是且未登入，則重定向到登錄頁面
        String requestURI = request.getRequestURI();
        if (isRestrictedPage(requestURI) && !loggedIn) {
            response.sendRedirect(request.getContextPath() + "/views/Signin.jsp");
            return;
        }

        // 允許請求通過過濾器
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    // 定義受限頁面的 URI
    private boolean isRestrictedPage(String requestURI) {
        return requestURI.contains("/CustomerView.jsp") ||
                requestURI.contains("/CharityView.jsp") ||
                requestURI.contains("/RetailerView.jsp");
    }
}
