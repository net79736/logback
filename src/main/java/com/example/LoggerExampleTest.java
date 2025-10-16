package com.example;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * additivity="false"와 appender-ref 예제 테스트 클래스
 * 
 * 🎯 이 클래스의 목적:
 * - com.example 패키지의 로그가 어떻게 동작하는지 보여주기
 * - additivity="false"의 의미를 이해하기
 * - appender-ref로 특정 파일에만 로그를 기록하는 방법 배우기
 * 
 * 📋 현재 logback-spring.xml 설정:
 * <logger name="com.example" level="DEBUG" additivity="false">
 *     <appender-ref ref="FILE"/>
 * </logger>
 * 
 * 🔍 이 설정의 의미:
 * 1. level="DEBUG": DEBUG 레벨 이상의 로그만 출력 (DEBUG, INFO, WARN, ERROR)
 * 2. additivity="false": 상위 logger(root)로 로그를 전파하지 않음
 * 3. appender-ref ref="FILE": FILE appender에만 로그를 기록
 * 
 * 📊 예상 결과:
 * - 콘솔에는 로그가 출력되지 않음 (additivity="false" 때문)
 * - 파일에만 로그가 기록됨 (FILE appender만 사용)
 * - DEBUG, INFO, WARN, ERROR 레벨의 로그만 기록됨
 */
@Component
@Slf4j
public class LoggerExampleTest {

    /**
     * 모든 로그 레벨을 테스트하는 메소드
     * 어린아이도 이해할 수 있도록 단계별로 설명합니다.
     */
    public void testAllLogLevels() {
        System.out.println("🎉 === com.example 패키지 로그 테스트 시작 ===");
        System.out.println("📝 설정: DEBUG 레벨, additivity=false, FILE appender만 사용");
        System.out.println("🔍 예상 결과: 콘솔에는 출력 안됨, 파일에만 기록됨\n");
        
        // 1단계: TRACE 레벨 테스트 (가장 낮은 레벨)
        System.out.println("1️⃣ TRACE 레벨 테스트 중...");
        log.trace("🔍 TRACE: 이 로그는 출력되지 않습니다 (TRACE < DEBUG)");
        System.out.println("   → TRACE는 DEBUG보다 낮은 레벨이므로 출력되지 않습니다\n");
        
        // 2단계: DEBUG 레벨 테스트 (설정된 최소 레벨)
        System.out.println("2️⃣ DEBUG 레벨 테스트 중...");
        log.debug("🐛 DEBUG: 이 로그는 파일에만 기록됩니다 (DEBUG = DEBUG)");
        System.out.println("   → DEBUG는 설정된 최소 레벨이므로 파일에 기록됩니다\n");
        
        // 3단계: INFO 레벨 테스트
        System.out.println("3️⃣ INFO 레벨 테스트 중...");
        log.info("ℹ️ INFO: 이 로그는 파일에만 기록됩니다 (INFO > DEBUG)");
        System.out.println("   → INFO는 DEBUG보다 높은 레벨이므로 파일에 기록됩니다\n");
        
        // 4단계: WARN 레벨 테스트
        System.out.println("4️⃣ WARN 레벨 테스트 중...");
        log.warn("⚠️ WARN: 이 로그는 파일에만 기록됩니다 (WARN > DEBUG)");
        System.out.println("   → WARN은 DEBUG보다 높은 레벨이므로 파일에 기록됩니다\n");
        
        // 5단계: ERROR 레벨 테스트
        System.out.println("5️⃣ ERROR 레벨 테스트 중...");
        log.error("❌ ERROR: 이 로그는 파일에만 기록됩니다 (ERROR > DEBUG)");
        System.out.println("   → ERROR는 DEBUG보다 높은 레벨이므로 파일에 기록됩니다\n");
        
        System.out.println("✅ === com.example 패키지 로그 테스트 완료 ===");
        System.out.println("📁 로그 파일을 확인해보세요: /Users/ijong-ug/Documents/logback_log_dir/special-example.log");
        System.out.println("💡 콘솔에는 로그가 출력되지 않는 것이 정상입니다 (additivity=false 때문)\n");
    }
    
    /**
     * additivity의 차이점을 보여주는 메소드
     * additivity="true"와 "false"의 차이를 이해할 수 있습니다.
     */
    public void explainAdditivity() {
        System.out.println("🎓 === additivity 설명 ===");
        System.out.println("📚 additivity는 '추가성'이라는 뜻입니다");
        System.out.println("🔍 로그가 상위 logger(root)로 전파되는지를 결정합니다\n");
        
        System.out.println("✅ additivity=\"true\" (기본값):");
        System.out.println("   - 로그가 상위 logger로 전파됩니다");
        System.out.println("   - 콘솔과 파일 모두에 로그가 출력됩니다");
        System.out.println("   - 예: root logger가 STDOUT과 FILE appender를 사용하면 둘 다에 기록됩니다\n");
        
        System.out.println("❌ additivity=\"false\" (현재 설정):");
        System.out.println("   - 로그가 상위 logger로 전파되지 않습니다");
        System.out.println("   - 현재 logger에서 지정한 appender에만 기록됩니다");
        System.out.println("   - 예: FILE appender만 지정하면 파일에만 기록되고 콘솔에는 출력되지 않습니다\n");
        
        System.out.println("🎯 현재 com.example 패키지 설정:");
        System.out.println("   - additivity=\"false\"");
        System.out.println("   - appender-ref ref=\"FILE\"");
        System.out.println("   - 결과: 파일에만 로그가 기록되고 콘솔에는 출력되지 않습니다\n");
    }
    
    /**
     * 실제 로그를 출력하는 메소드
     * 각 레벨별로 의미있는 메시지를 출력합니다.
     */
    public void generateMeaningfulLogs() {
        System.out.println("📝 === 의미있는 로그 생성 테스트 ===");
        
        // 사용자 행동 로그
        log.debug("사용자가 로그인 페이지에 접근했습니다");
        log.info("사용자 '홍길동'이 성공적으로 로그인했습니다");
        log.warn("사용자가 5번 연속으로 잘못된 비밀번호를 입력했습니다");
        log.error("데이터베이스 연결에 실패했습니다");
        
        // 시스템 상태 로그
        log.debug("시스템 메모리 사용량: 45%");
        log.info("애플리케이션이 정상적으로 시작되었습니다");
        log.warn("디스크 공간이 부족합니다 (사용률: 85%)");
        log.error("외부 API 호출에 실패했습니다: 500 Internal Server Error");
        
        System.out.println("✅ 의미있는 로그가 파일에 기록되었습니다");
        System.out.println("📁 파일 위치: /Users/ijong-ug/Documents/logback_log_dir/special-example.log\n");
    }
}
