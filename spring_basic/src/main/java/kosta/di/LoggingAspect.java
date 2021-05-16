package kosta.di;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {
	
	private Log log = LogFactory.getLog(getClass());
	
	// 공통관심 메서드
	// advice : around(이전, 이후) = 이전(공통) -> 핵심관심사항(insert()) -> 이후(공통)
	public Object logging(ProceedingJoinPoint joinPoint)throws Throwable{
		log.info("로그시작");
		StopWatch stopWatch = new StopWatch();
		
		try {
			stopWatch.start();
			
			// 핵심관심사항 호출 : WriteService - insert() 호출
			Object obj = joinPoint.proceed();
			
			return obj;
			
		} catch (Exception e) {
			throw e;
		} finally{
			stopWatch.stop();
			log.info("로그아웃");
			log.info(joinPoint.getSignature().getName() + "메서드 실행시: " 
					+ stopWatch.getTotalTimeMillis());
		}
	}
	
}
