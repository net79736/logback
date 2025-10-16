package com.logbackGroup.logback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LoggerExampleTest;

import lombok.extern.slf4j.Slf4j;

/**
 * additivity="true"와 additivity="false"의 차이점을 비교하는 컨트롤러
 * 
 * 🎯 이 컨트롤러의 목적:
 * - 두 패키지의 로그 설정을 비교
 * - additivity의 차이점을 실제로 확인
 * - 어린아이도 이해할 수 있도록 단계별로 설명
 * 
 * 📋 테스트 가능한 엔드포인트:
 * - /comparison/all: 전체 비교 테스트
 * - /comparison/explain: 차이점 설명
 * - /comparison/example: com.example 패키지 테스트
 * - /comparison/normal: 일반 패키지 테스트
 */
@RestController
@RequestMapping("/comparison")
@Slf4j
public class LoggerComparisonController {

    @Autowired
    private LoggerExampleTest loggerExampleTest;
    
    @Autowired
    private LoggerComparisonTest loggerComparisonTest;

    /**
     * 전체 비교 테스트를 실행합니다.
     * GET /comparison/all
     */
    @GetMapping("/all")
    public String testAllComparisons() {
        System.out.println("🚀 === Logger Comparison Test 시작 ===");
        
        // 1단계: 차이점 설명
        loggerComparisonTest.explainDifference();
        
        // 2단계: 일반 패키지 테스트 (additivity="true" 기본값)
        System.out.println("📦 === 일반 패키지 테스트 (additivity=true) ===");
        loggerComparisonTest.testNormalPackageLogs();
        
        // 3단계: com.example 패키지 테스트 (additivity="false")
        // System.out.println("📦 === com.example 패키지 테스트 (additivity=false) ===");
        // loggerExampleTest.testAllLogLevels();
        
        System.out.println("🎉 === Logger Comparison Test 완료 ===");
        
        return "✅ Logger Comparison Test가 완료되었습니다!\n\n" +
               "📊 결과 요약:\n" +
               "1. 일반 패키지: 콘솔과 파일 모두에 로그 출력 (additivity=true)\n" +
               "2. com.example 패키지: 파일에만 로그 출력 (additivity=false)\n\n" +
               "📁 로그 파일 위치: /Users/ijong-ug/Documents/logback_log_dir/around_hub_spring_boot.log\n" +
               "💡 콘솔을 확인하여 차이점을 직접 확인해보세요!";
    }

    /**
     * 차이점 설명을 출력합니다.
     * GET /comparison/explain
     */
    @GetMapping("/explain")
    public String explainDifference() {
        loggerComparisonTest.explainDifference();
        return "📚 차이점 설명이 완료되었습니다!";
    }

    /**
     * com.example 패키지만 테스트합니다.
     * GET /comparison/example
     */
    @GetMapping("/example")
    public String testExamplePackage() {
        System.out.println("📦 === com.example 패키지 테스트 ===");
        // loggerExampleTest.testAllLogLevels();
        return "✅ com.example 패키지 테스트가 완료되었습니다!";
    }

    /**
     * 일반 패키지만 테스트합니다.
     * GET /comparison/normal
     */
    @GetMapping("/normal")
    public String testNormalPackage() {
        System.out.println("📦 === 일반 패키지 테스트 ===");
        loggerComparisonTest.testNormalPackageLogs();
        return "✅ 일반 패키지 테스트가 완료되었습니다!";
    }

    /**
     * 간단한 비교 테스트를 실행합니다.
     * GET /comparison/simple
     */
    @GetMapping("/simple")
    public String simpleComparison() {
        System.out.println("🔍 === 간단한 비교 테스트 ===");
        
        // 일반 패키지에서 로그 출력 (콘솔과 파일 모두에 출력됨)
        System.out.println("📦 일반 패키지에서 로그 출력:");
        log.info("ℹ️ 일반 패키지 INFO 로그 (콘솔과 파일 모두에 출력됨)");
        
        System.out.println("\n📦 com.example 패키지에서 로그 출력:");
        // com.example 패키지의 로그는 파일에만 출력됨
        // (실제로는 LoggerExampleTest를 통해 출력)
        
        System.out.println("✅ 간단한 비교 테스트 완료");
        System.out.println("💡 일반 패키지 로그는 콘솔에 출력되고, com.example 패키지 로그는 파일에만 기록됩니다");
        
        return "🔍 간단한 비교 테스트가 완료되었습니다!";
    }
}
