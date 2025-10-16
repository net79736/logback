package com.logbackGroup.logback.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 테스트용 MyBatis 매퍼 인터페이스
 * 실제 사용시 필요에 따라 수정하세요
 */
@Mapper
public interface TestMapper {
    
    /**
     * 테스트용 쿼리
     * @return 테스트 메시지
     */
    String selectTest();
}
