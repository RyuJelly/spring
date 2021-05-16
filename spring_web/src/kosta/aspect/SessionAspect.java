package kosta.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SessionAspect {
	
	@Around("execution(public * kosta.controller.*.*do(..))")
	public String sessionCheck(ProceedingJoinPoint joinPoint)throws Throwable{
		// 세션 유무를 체크 => Session객체 
		Object[] obj = joinPoint.getArgs(); // => controller에서 넘어오는 파라미터를 모두 받아올수 있다.
		HttpServletRequest request = (HttpServletRequest)obj[0];
		HttpSession session = request.getSession();
		
		String name = (String)session.getAttribute("name");
		String view = "session/session_fail";
		
		try {
			if(name == null){
				throw new Exception("no session");
			}
			
			view = (String)joinPoint.proceed();	// session_do() 호출
			
		} catch (Exception e) {
			return view;
		}
		
		return view;
	}
	
}
