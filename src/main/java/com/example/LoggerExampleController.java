package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * additivity="false"와 appender-ref 예제를 테스트하는 컨트롤러
 * 
 * 🎯 이 컨트롤러의 목적:
 * - com.example 패키지의 로그 설정을 테스트
 * - additivity="false"의 동작을 확인
 * - appender-ref로 특정 파일에만 로그를 기록하는 것을 확인
 * 
 * 📋 테스트 가능한 엔드포인트:
 * - /example/test-all: 모든 로그 레벨 테스트
 * - /example/explain: additivity 설명
 * - /example/meaningful: 의미있는 로그 생성
 */
@RestController
@RequestMapping("/example")
@Slf4j
public class LoggerExampleController {

    @Autowired
    private LoggerExampleTest loggerExampleTest;

    /**
     * 모든 로그 레벨을 테스트합니다.
     * GET /example/test-all
     */
    @GetMapping("/test-all")
    public String testAllLogLevels() {
        System.out.println("🚀 === Logger Example Test 시작 ===");
        
        // additivity 설명
        // loggerExampleTest.explainAdditivity();
        
        // 모든 로그 레벨 테스트
        // loggerExampleTest.testAllLogLevels();
        
        // 의미있는 로그 생성
        loggerExampleTest.generateMeaningfulLogs();
        
        System.out.println("🎉 === Logger Example Test 완료 ===");
        
        return "✅ Logger Example Test가 완료되었습니다!\n" +
               "📁 로그 파일을 확인해보세요: /Users/ijong-ug/Documents/logback_log_dir/special-example.log\n" +
               "💡 콘솔에는 로그가 출력되지 않는 것이 정상입니다 (additivity=false 때문)";
    }

    /**
     * additivity에 대한 설명을 출력합니다.
     * GET /example/explain
     */
    @GetMapping("/explain")
    public String explainAdditivity() {
        loggerExampleTest.explainAdditivity();
        return "📚 additivity 설명이 완료되었습니다!";
    }

    /**
     * 의미있는 로그를 생성합니다.
     * GET /example/meaningful
     */
    @GetMapping("/meaningful")
    public String generateMeaningfulLogs() {
        loggerExampleTest.generateMeaningfulLogs();
        return "📝 의미있는 로그가 파일에 기록되었습니다!";
    }

    /**
     * 간단한 로그 테스트를 실행합니다.
     * GET /example/simple
     */
    @GetMapping("/simple")
    public String simpleTest() {
        System.out.println("🔍 === 간단한 로그 테스트 ===");
        
        // 각 레벨별로 한 개씩만 테스트
        log.debug("🐛 DEBUG: 간단한 디버그 메시지");
        log.info("ℹ️ INFO: 간단한 정보 메시지");
        log.warn("⚠️ WARN: 간단한 경고 메시지");
        log.error("❌ ERROR: 간단한 에러 메시지");
        
        System.out.println("✅ 간단한 로그 테스트 완료");
        System.out.println("📁 파일을 확인해보세요: /Users/ijong-ug/Documents/logback_log_dir/special-example.log");
        
        return "🔍 간단한 로그 테스트가 완료되었습니다!";
    }
}
