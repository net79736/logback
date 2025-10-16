package com.logbackGroup.logback;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * additivity="true" (기본값)와 additivity="false"의 차이점을 보여주는 비교 테스트 클래스
 * 
 * 🎯 이 클래스의 목적:
 * - com.logbackGroup.logback 패키지는 특별한 logger 설정이 없음
 * - root logger 설정을 상속받음 (additivity="true" 기본값)
 * - com.example 패키지와 비교하여 차이점을 보여줌
 * 
 * 📋 현재 설정:
 * - 특별한 logger 설정 없음
 * - root logger 설정 상속: level="INFO", STDOUT + FILE appender
 * - additivity="true" (기본값)
 * 
 * 🔍 예상 결과:
 * - 콘솔과 파일 모두에 로그가 출력됨 (additivity="true" 때문)
 * - INFO, WARN, ERROR 레벨의 로그만 출력됨 (root level="INFO")
 */
@Component
@Slf4j
public class LoggerComparisonTest {

    /**
     * 일반 패키지의 로그 동작을 테스트하는 메소드
     * com.example 패키지와 비교하여 차이점을 보여줍니다.
     */
    public void testNormalPackageLogs() {
        System.out.println("🎉 === 일반 패키지 로그 테스트 시작 ===");
        System.out.println("📝 설정: root logger 상속 (INFO 레벨, STDOUT + FILE appender)");
        System.out.println("🔍 예상 결과: 콘솔과 파일 모두에 로그가 출력됨\n");
        
        // 1단계: TRACE 레벨 테스트
        System.out.println("1️⃣ TRACE 레벨 테스트 중...");
        log.trace("🔍 TRACE: 이 로그는 출력되지 않습니다 (TRACE < INFO)");
        System.out.println("   → TRACE는 INFO보다 낮은 레벨이므로 출력되지 않습니다\n");
        
        // 2단계: DEBUG 레벨 테스트
        System.out.println("2️⃣ DEBUG 레벨 테스트 중...");
        log.debug("🐛 DEBUG: 이 로그는 출력되지 않습니다 (DEBUG < INFO)");
        System.out.println("   → DEBUG는 INFO보다 낮은 레벨이므로 출력되지 않습니다\n");
        
        // 3단계: INFO 레벨 테스트
        System.out.println("3️⃣ INFO 레벨 테스트 중...");
        log.info("ℹ️ INFO: 이 로그는 콘솔과 파일 모두에 출력됩니다 (INFO = INFO)");
        System.out.println("   → INFO는 root logger의 설정 레벨이므로 콘솔과 파일 모두에 출력됩니다\n");
        
        // 4단계: WARN 레벨 테스트
        System.out.println("4️⃣ WARN 레벨 테스트 중...");
        log.warn("⚠️ WARN: 이 로그는 콘솔과 파일 모두에 출력됩니다 (WARN > INFO)");
        System.out.println("   → WARN은 INFO보다 높은 레벨이므로 콘솔과 파일 모두에 출력됩니다\n");
        
        // 5단계: ERROR 레벨 테스트
        System.out.println("5️⃣ ERROR 레벨 테스트 중...");
        log.error("❌ ERROR: 이 로그는 콘솔과 파일 모두에 출력됩니다 (ERROR > INFO)");
        System.out.println("   → ERROR는 INFO보다 높은 레벨이므로 콘솔과 파일 모두에 출력됩니다\n");
        
        System.out.println("✅ === 일반 패키지 로그 테스트 완료 ===");
        System.out.println("📁 로그 파일: /Users/ijong-ug/Documents/logback_log_dir/around_hub_spring_boot.log");
        System.out.println("💡 콘솔에도 로그가 출력되는 것이 정상입니다 (additivity=true 기본값)\n");
    }
    
    /**
     * com.example 패키지와의 차이점을 설명하는 메소드
     */
    public void explainDifference() {
        System.out.println("🎓 === 패키지별 로그 설정 차이점 설명 ===");
        
        System.out.println("📦 com.logbackGroup.logback 패키지 (현재 패키지):");
        System.out.println("   - 특별한 logger 설정 없음");
        System.out.println("   - root logger 설정 상속");
        System.out.println("   - additivity=\"true\" (기본값)");
        System.out.println("   - 결과: 콘솔과 파일 모두에 로그 출력\n");
        
        System.out.println("📦 com.example 패키지:");
        System.out.println("   - 특별한 logger 설정 있음");
        System.out.println("   - level=\"DEBUG\", additivity=\"false\"");
        System.out.println("   - appender-ref ref=\"FILE\"만 사용");
        System.out.println("   - 결과: 파일에만 로그 출력 (콘솔에는 출력 안됨)\n");
        
        System.out.println("🔍 핵심 차이점:");
        System.out.println("   1. 로그 레벨: INFO vs DEBUG");
        System.out.println("   2. 출력 위치: 콘솔+파일 vs 파일만");
        System.out.println("   3. additivity: true vs false");
        System.out.println("   4. appender: STDOUT+FILE vs FILE만\n");
    }
}
